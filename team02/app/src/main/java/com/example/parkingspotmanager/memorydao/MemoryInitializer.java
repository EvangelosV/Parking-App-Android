package com.example.parkingspotmanager.memorydao;
import com.example.parkingspotmanager.dao.CustomerDAO;
import com.example.parkingspotmanager.dao.EmployeeDAO;
import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.dao.ManagementDAO;
import com.example.parkingspotmanager.dao.ParkingBuildingDAO;
import com.example.parkingspotmanager.dao.ParkingSpaceDAO;
import com.example.parkingspotmanager.dao.ParkingTicketDAO;
import com.example.parkingspotmanager.dao.PaymentDAO;
import com.example.parkingspotmanager.dao.RegistrationDAO;
import com.example.parkingspotmanager.dao.RenewalDAO;
import com.example.parkingspotmanager.dao.ReservationDAO;
import com.example.parkingspotmanager.dao.ReservationTicketDAO;
import com.example.parkingspotmanager.dao.VehicleDAO;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class MemoryInitializer extends Initializer {

    /**
     * Deletes all data from the in-memory lists.
     */
    @Override
    protected void eraseData() {
        getCustomerDAO().deleteAll();
        getEmployeeDAO().deleteAll();
        getManagementDAO().deleteAll();
        getParkingBuildingDAO().deleteAll();
        getParkingSpaceDAO().deleteAll();
        getParkingTicketDAO().deleteAll();
        getPaymentDAO().deleteAll();
        getRegistrationDAO().deleteAll();
        getRenewalDAO().deleteAll();
        getReservationDAO().deleteAll();
        getReservationTicketDAO().deleteAll();
        getVehicleDAO().deleteAll();
    }

    /**
     * Returns a new instance of CustomerDAOMemory.
     *
     * @return A new CustomerDAO implementation.
     */
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOMemory();
    }

    /**
     * Returns a new instance of EmployeeDAOMemory.
     *
     * @return A new EmployeeDAO implementation.
     */
    public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOMemory();
    }

    /**
     * Returns a new instance of ManagementDAOMemory.
     *
     * @return A new ManagementDAO implementation.
     */
    public ManagementDAO getManagementDAO() {
        return new ManagementDAOMemory();
    }

    /**
     * Returns a new instance of ParkingBuildingDAOMemory.
     *
     * @return A new ParkingBuildingDAO implementation.
     */
    public ParkingBuildingDAO getParkingBuildingDAO() {
        return new ParkingBuildingDAOMemory();
    }

    /**
     * Returns a new instance of ParkingSpaceDAOMemory.
     *
     * @return A new ParkingSpaceDAO implementation.
     */
    public ParkingSpaceDAO getParkingSpaceDAO() {
        return new ParkingSpaceDAOMemory();
    }

    /**
     * Returns a new instance of ParkingTicketDAOMemory.
     *
     * @return A new ParkingTicketDAO implementation.
     */
    public ParkingTicketDAO getParkingTicketDAO() {
        return new ParkingTicketDAOMemory();
    }

    /**
     * Returns a new instance of PaymentDAOMemory.
     *
     * @return A new PaymentDAO implementation.
     */
    public PaymentDAO getPaymentDAO() {
        return new PaymentDAOMemory();
    }

    /**
     * Returns a new instance of RegistrationDAOMemory.
     *
     * @return A new RegistrationDAO implementation.
     */
    public RegistrationDAO getRegistrationDAO() {
        return new RegistrationDAOMemory();
    }

    /**
     * Returns a new instance of RenewalDAOMemory.
     *
     * @return A new RenewalDAO implementation.
     */
    public RenewalDAO getRenewalDAO() {
        return new RenewalDAOMemory();
    }

    /**
     * Returns a new instance of ReservationDAOMemory.
     *
     * @return A new ReservationDAO implementation.
     */
    public ReservationDAO getReservationDAO() {
        return new ReservationDAOMemory();
    }

    /**
     * Returns a new instance of ReservationTicketDAOMemory.
     *
     * @return A new ReservationTicketDAO implementation.
     */
    public ReservationTicketDAO getReservationTicketDAO() {
        return new ReservationTicketDAOMemory();
    }

    /**
     * Returns a new instance of VehicleDAOMemory.
     *
     * @return A new VehicleDAO implementation.
     */
    public VehicleDAO getVehicleDAO() {
        return new VehicleDAOMemory();
    }
}
