package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("Kyriakos", "Grizzly", "maou@maou.gr", "12345678", "KYRIAKOS", "KYRIAKOS");
    }

    @Test
    public void testGetFirstName() {
        Assert.assertEquals("Kyriakos", user.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Assert.assertEquals("Grizzly", user.getLastName());
    }


    @Test
    public void testGetPhoneNumber() {
        Assert.assertEquals("12345678", user.getPhoneNumber());
    }

    @Test
    public void testGetEmail() {
        Assert.assertEquals("maou@maou.gr", user.getEmail());
    }

    @Test
    public void testSetFirstName() {
        user.setFirstName("Kostas");
        Assert.assertEquals("Kostas", user.getFirstName());
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals("KYRIAKOS", user.getUsername());
    }

    @Test
    public void testSetLastName() {
        user.setLastName("Bear");
        Assert.assertEquals("Bear", user.getLastName());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("KATSAOU");
        Assert.assertEquals("KATSAOU", user.getUsername());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("87654321");
        Assert.assertEquals("87654321", user.getPassword());
    }

    @Test
    public void testSetPhone() {
        user.setPhoneNumber("87654321");
        Assert.assertEquals("87654321", user.getPhoneNumber());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("katsaou@rah.gr");
        Assert.assertEquals("katsaou@rah.gr", user.getEmail());
    }
}