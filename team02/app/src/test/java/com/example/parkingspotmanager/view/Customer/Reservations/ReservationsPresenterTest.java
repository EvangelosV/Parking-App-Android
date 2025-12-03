package com.example.parkingspotmanager.view.Customer.Reservations;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.domain.Vehicle;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.ReservationDAOMemory;
import com.example.parkingspotmanager.memorydao.ReservationTicketDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ReservationsPresenterTest {

    private ReservationsPresenter presenter;
    private ReservationsViewStub view;
    private ReservationDAOMemory reservationDAO;
    private CustomerDAOMemory customerDAO;
    private ReservationTicketDAOMemory reservationTicketDAO;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new ReservationsViewStub();
        presenter = new ReservationsPresenter();
        reservationDAO = new ReservationDAOMemory();
        customerDAO = new CustomerDAOMemory();
        reservationTicketDAO = new ReservationTicketDAOMemory();
        presenter.setView(view);
        presenter.setCustomerDAO(customerDAO);
        presenter.setReservationDAO(reservationDAO);
        presenter.setReservationTicketDAO(reservationTicketDAO);
    }

    @Test
    public void testFindCustomerInfo() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);
        Customer result = presenter.findCustomerInfo("UsernameTest");
        Assert.assertNotNull(result);
        Assert.assertEquals("UsernameTest", result.getUsername());
    }

    @Test
    public void testClearView() {
        Assert.assertNotNull(presenter.getView());
        presenter.clearView();
        Assert.assertNull(presenter.getView());
    }

    @Test
    public void testSetAndGetView() {
        Assert.assertEquals(view, presenter.getView());
    }

    @Test
    public void testSetAndGetReservationDAO() {
        presenter.setReservationDAO(null);
        Assert.assertNull(presenter.getReservationDAO());
        presenter.setReservationDAO(reservationDAO);
        Assert.assertEquals(reservationDAO, presenter.getReservationDAO());
    }

    @Test
    public void testSetAndGetCustomerDAO() {
        presenter.setCustomerDAO(null);
        Assert.assertNull(presenter.getCustomerDAO());
        presenter.setCustomerDAO(customerDAO);
        Assert.assertEquals(customerDAO, presenter.getCustomerDAO());
    }

    @Test
    public void testSetAndGetReservationTicketDAO() {
        presenter.setReservationTicketDAO(null);
        Assert.assertNull(presenter.getReservationTicketDAO());
    }

    @Test
    public void testFindCustomerInfo_NullUsername() {
        Customer result = presenter.findCustomerInfo(null);
        Assert.assertNull(result);
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", null);
        customerDAO.save(customer);
        presenter.findCustomerInfo("UsernameTest");
        Assert.assertEquals(customer, presenter.getCustomer());
    }

    @Test
    public void testGetReservationsList() {
        List<Reservation> reservations = reservationDAO.findAll();
        Assert.assertNotNull(reservations);
    }
}