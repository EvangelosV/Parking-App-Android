package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManagementTest {

    private Management management;

    @Before
    public void setUp() {
        management = new Management(
                "John",
                "Doe",
                "johndoe@example.com",
                "1234567890",
                "john_doe",
                "securePassword"
        );
    }

    @Test
    public void testManagementInitialization() {
        // Test that the management object is initialized correctly
        Assert.assertEquals("johndoe@example.com", management.getEmail());
        Assert.assertEquals("1234567890", management.getPhoneNumber());
        Assert.assertEquals("john_doe", management.getUsername());
        Assert.assertEquals("securePassword", management.getPassword());
    }

    @Test
    public void testSetEmail() {
        management.setEmail("newemail@example.com");
        Assert.assertEquals("newemail@example.com", management.getEmail());
    }

    @Test
    public void testSetPhoneNumber() {
        management.setPhoneNumber("0987654321");
        Assert.assertEquals("0987654321", management.getPhoneNumber());
    }

    @Test
    public void testSetUsername() {
        management.setUsername("new_username");
        Assert.assertEquals("new_username", management.getUsername());
    }

    @Test
    public void testSetPassword() {
        management.setPassword("newPassword");
        Assert.assertEquals("newPassword", management.getPassword());
    }
}
