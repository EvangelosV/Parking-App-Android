package com.example.parkingspotmanager.memorydao;

import com.example.parkingspotmanager.dao.PaymentDAO;
import com.example.parkingspotmanager.domain.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Developed for the purposes of the Course "Software Engineering" at AUEB
 * Athens University of Economics and Business
 * 2024-2025
 */
public class PaymentDAOMemory implements PaymentDAO {
    protected static ArrayList<Payment> entities = new ArrayList<Payment>();
    private int nextId = 1;
    /**
     * Deletes all Payment entities from the in-memory list.
     */
    @Override
    public void deleteAll() {
        entities = new ArrayList<>();
        nextId = 1;
    }

    /**
     * Saves a Payment entity to the in-memory list.
     * @param entity the payment to be saved
     */
    @Override
    public void save(Payment entity) {
        entities.add(entity);
    }

    /**
     * Returns a list of all Payment entities stored in memory.
     * @return the list of payments
     */
    @Override
    public ArrayList<Payment> findAll() {
        return new ArrayList<Payment>(entities);
    }

    /**
     * Finds a Payment by its ID.
     * @param paymentId the ID of the payment
     * @return the payment
     */
    @Override
    public Payment find(int paymentId)
    {
        for(Payment payment : entities)
            if(payment.getPaymentID() == paymentId)
                return payment;

        return null;
    }

    /**
     * Deletes a Payment entity from the in-memory list.
     * @param entity the payment to be deleted
     */
    @Override
    public void delete(Payment entity) {
        entities.remove(entity);
    }

    /**
     * Generates the next available ID for a Payment entity.
     * @return the next available ID
     */
    @Override
    public int nextId() {
        return (!entities.isEmpty() ? entities.get(entities.size() - 1).getPaymentID() + 1 : 1);
    }

/*
    public Map<Integer, Double> getMonthlyRevenue(int year) {
        return entities.stream()
                .filter(payment -> payment.getPaymentDate().getYear() == year)
                .collect(Collectors.groupingBy(
                        payment -> payment.getPaymentDate().getMonthValue(),
                        Collectors.summingDouble(Payment::getAmount)
                ));
    }
*/

    /**
     * Returns a map of the monthly revenue for a specific year.
     * @return a map of the monthly revenue
     */
    public Map<String, Double> getAverageParkingDurationPerCustomer() {
        return entities.stream()
                .collect(Collectors.groupingBy(
                        payment -> payment.getCustomer().getUsername(),
                        Collectors.averagingDouble(this::getParkingDurationInHours)
                ));
    }

    /**
     * Returns the average parking duration in hours for a specific payment.
     * @param payment the payment to calculate the parking duration for
     * @return the average parking duration in hours
     */
    private double getParkingDurationInHours(Payment payment) {
        if (payment.getReservationTicket() != null) {
            return payment.getReservationTicket().getDuration().toHours();
        } else if (payment.getParkingTicket() != null) {
            return payment.getParkingTicket().getDuration().toHours();
        }
        return 0.0;
    }

}
