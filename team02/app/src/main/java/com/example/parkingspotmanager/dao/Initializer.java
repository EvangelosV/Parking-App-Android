package com.example.parkingspotmanager.dao;

import com.example.parkingspotmanager.domain.Customer;
import com.example.parkingspotmanager.domain.Employee;
import com.example.parkingspotmanager.domain.Management;
import com.example.parkingspotmanager.domain.ParkingBuilding;
import com.example.parkingspotmanager.domain.ParkingSpace;
import com.example.parkingspotmanager.domain.Registration;
import com.example.parkingspotmanager.domain.Reservation;
import com.example.parkingspotmanager.domain.Vehicle;


import java.time.LocalTime;

public abstract class Initializer {

    protected abstract void eraseData();

    /**
      create the initial data
     */
    public void prepareData() {
        eraseData();
        CustomerDAO customerDAOMemory = getCustomerDAO();
        EmployeeDAO employeeDAOMemory = getEmployeeDAO();
        ManagementDAO managementDAOMemory = getManagementDAO();
        ParkingBuildingDAO parkingBuildingDAOMemory = getParkingBuildingDAO();
        ParkingSpaceDAO parkingSpaceDAOMemory = getParkingSpaceDAO();
        ParkingTicketDAO parkingTicketDAOMemory = getParkingTicketDAO();
        PaymentDAO paymentDAOMemory = getPaymentDAO();
        RegistrationDAO registrationDAOMemory = getRegistrationDAO();
        RenewalDAO renewalDAOMemory = getRenewalDAO();
        ReservationDAO reservationDAOMemory = getReservationDAO();
        ReservationTicketDAO reservationTicketDAOMemory = getReservationTicketDAO();
        VehicleDAO vehicleDAOMemory = getVehicleDAO();

        /**
         * Create 20 customers
         * */
        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer(
                    "FirstNameCustomer" + i,
                    "LastNameCustomer" + i,
                    "customer" + i + "@gmail.com",
                    "1234567890",
                    "customer" + i,
                    "password" + i,
                    new Vehicle("Plate" + i, "Brand" + i, "Model" + i)
            );
            customer.setAccountBalance(i*2);
            customerDAOMemory.save(customer);
        }

        /**
         * Create 10 registration request
         * */
        for (int i = 0; i < 10; i++) {
            Registration registration = new Registration(new Customer( "FirstNameCustomerRequest" + i,
                    "LastNameCustomerRequest" + i,
                    "customerRequest" + i + "@gmail.com",
                    "1234567890",
                    "customerRequest" + i,
                    "passwordRequest" + i,
                    new Vehicle("PlateRequest" + i, "BrandRequest" + i, "ModelRequest" + i)));
            registrationDAOMemory.save(registration);
        }

        /**
         * Create 3 employees
         *
         */
        for (int i = 0; i < 3; i++) {
            Employee employee = new Employee(
                    "FirstNameEmployee" + i,
                    "LastNameEmployee" + i,
                    "employee" + i + "@gmail.com",
                    "1234567890",
                    "employee" + i,
                    "password" + i
            );
            employeeDAOMemory.save(employee);
        }

        /**
         * Create 1 management
         */
        Management management = new Management(
                "FirstNameManagement",
                "LastNameManagement",
                "management1@gmail.com",
                "1234567890",
                "management1",
                "password1");
        managementDAOMemory.save(management);

        /**
         * Create 3 parking buildings
         */
        for (int i = 0; i < 3; i++) {
            ParkingBuilding parkingBuilding = new ParkingBuilding(i, "Address" + i, "08:00", "22:00", Integer.toString(10000 + i));
            /**
             * Create 10 parking spaces for each parking building
             */
            for (int j = 0; j < 10; j++) {
                ParkingSpace parkingSpace = new ParkingSpace(j, parkingBuilding, false, false, 10);
                parkingSpaceDAOMemory.save(parkingSpace);
                if (j % 2 == 0) {
                    // Create 5 reservations for each parking building
                    Reservation reservation = new Reservation(parkingSpace,new Customer("FirstNameCustomer" + j,
                        "LastNameCustomer" + j,
                        "customer" + j + "@gmail.com",
                        "1234567890",
                        "customer" + j,
                        "password" + j,
                        new Vehicle("Plate" + j, "Brand" + j, "Model" + j)), LocalTime.parse("10:00"), LocalTime.parse("12:00"),parkingSpace.getPricePerHour());
                    reservationDAOMemory.save(reservation);
                }

            }
            parkingBuildingDAOMemory.save(parkingBuilding);
        }

        /**
         * Create 10 vehicles
         */
        for (int i = 0; i < 10; i++) {
            Vehicle vehicle = new Vehicle("Plate" + i, "Brand" + i, "Model" + i);
            vehicleDAOMemory.save(vehicle);
        }
    }

    public abstract CustomerDAO getCustomerDAO();
    public abstract EmployeeDAO getEmployeeDAO();
    public abstract ManagementDAO getManagementDAO();

    public abstract ParkingBuildingDAO getParkingBuildingDAO();
    public abstract ParkingSpaceDAO getParkingSpaceDAO();
    public abstract ParkingTicketDAO getParkingTicketDAO();
    public abstract PaymentDAO getPaymentDAO();
    public abstract RegistrationDAO getRegistrationDAO();
    public abstract RenewalDAO getRenewalDAO();
    public abstract ReservationDAO getReservationDAO();
    public abstract ReservationTicketDAO getReservationTicketDAO();
    public abstract VehicleDAO getVehicleDAO();
}
