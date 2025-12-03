package com.example.parkingspotmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CredentialsTest {
    private Credentials credentials;
    private Credentials credentials2;

    @Before
    public void setUp() {
        credentials = new Credentials("MAOU", "12345678");
        credentials2 = new Credentials();
    }

    @Test
    public void getUsernameTest() {
        Assert.assertEquals("MAOU", credentials.getUsername());
    }

    @Test
    public void getEmptyTest() {
        Assert.assertNull(credentials2.getUsername());
    }

    @Test
    public void getEmptyPasswordTest() {
        Assert.assertNull(credentials2.getPassword());
    }

    @Test
    public void getPasswordTest() {
        Assert.assertEquals("12345678", credentials.getPassword());
    }

    @Test
    public void testSetUsername() {
        credentials.setUsername("KATSAOU");
        Assert.assertEquals("KATSAOU", credentials.getUsername());
    }

    @Test
    public void testSetPassword() {
        credentials.setPassword("87654321");
        Assert.assertEquals("87654321", credentials.getPassword());
    }
}