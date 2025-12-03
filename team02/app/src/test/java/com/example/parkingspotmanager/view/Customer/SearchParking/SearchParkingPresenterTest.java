package com.example.parkingspotmanager.view.Customer.SearchParking;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.CustomerDAOMemory;
import com.example.parkingspotmanager.memorydao.ParkingBuildingDAOMemory;
import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.Vehicle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The `SearchParkingPresenterTest` class contains unit tests for the `SearchParkingPresenter` class.
 * It tests the functionality of retrieving customer information, fetching parking buildings, booking parking spaces,
 * navigating to the home page, and clearing the view.
 */
public class SearchParkingPresenterTest {

    private SearchParkingPresenter presenter;
    private SearchParkingViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new SearchParkingViewStub();
        presenter = new SearchParkingPresenter();
        presenter.setView(view);
        presenter.setCustomerDAO(new CustomerDAOMemory());
        presenter.setParkingBuildingDAO(new ParkingBuildingDAOMemory());
    }

    /**
     * Tests the retrieval of customer information by username.
     * Verifies that the correct customer is retrieved and that the username matches.
     */
    @Test
    public void testFindCustomerInfo() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);

        presenter.findCustomerInfo("UsernameTest");
        Assert.assertNotNull(presenter.getCustomer());
        Assert.assertEquals("UsernameTest", presenter.getCustomer().getUsername());
    }

    /**
     * Tests the retrieval of all parking buildings.
     * Verifies that the list of parking buildings is not null and not empty.
     */
    @Test
    public void testGetParkingBuildings() {
        ArrayList<ParkingBuilding> parkingBuildings = presenter.getParkingBuildings();
        Assert.assertNotNull(parkingBuildings);
        Assert.assertFalse(parkingBuildings.isEmpty());
    }

    /**
     * Tests the booking of a parking space.
     * Verifies that the booking process is successful and that the parking building details are correct.
     */
    @Test
    public void testBookSpace() {
        Customer customer = new Customer("Andreas", "Lamp", "customer@org.com", "6995956585", "UsernameTest", "UsernamePassword", new Vehicle("ABC1233", "Toyota", "Corolla"));
        presenter.getCustomerDAO().save(customer);
        presenter.findCustomerInfo("UsernameTest");

        ParkingBuilding parkingBuilding = new ParkingBuilding(1, "Address1", "07:00", "22:00", "11111");
        presenter.getParkingBuildingDAO().save(parkingBuilding);

        LocalTime entryTime = LocalTime.of(13, 0);
        LocalTime exitTime = LocalTime.of(15, 0);

        // Check initial state of parking building
        Assert.assertNotNull(parkingBuilding);
        Assert.assertEquals(1, parkingBuilding.getId());
        Assert.assertEquals("Address1", parkingBuilding.getAddress());

        boolean result = presenter.BookSpace(parkingBuilding, entryTime, exitTime);

        // Check the result of the booking
        Assert.assertFalse("Booking space failed", !result);
    }

    /**
     * Tests the navigation to the home page.
     * Verifies that the `onHomePage` method is called and the corresponding view method is triggered.
     */
    @Test
    public void testOnHomePage() {
        presenter.onHomePage();
        Assert.assertTrue(view.backToHomePageCalled);
    }

    /**
     * Tests the `clearView` method to ensure that the view reference is properly cleared.
     * Verifies that the view is set to null after calling the method.
     */
    @Test
    public void testClearView() {
        Assert.assertNotNull(presenter.getView());
        presenter.clearView();
        Assert.assertNull(presenter.getView());
    }
}