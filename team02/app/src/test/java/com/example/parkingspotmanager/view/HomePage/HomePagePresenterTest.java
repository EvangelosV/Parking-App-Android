package com.example.parkingspotmanager.view.HomePage;

import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `HomePagePresenterTest` class contains unit tests for the `HomePagePresenter` class.
 * It tests the functionality of handling user actions such as login and registration.
 */
public class HomePagePresenterTest {

    private HomePagePresenter presenter;
    private HomePageView view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter.
     *
     * @throws Exception if the setup fails.
     */
    @Before
    public void setUp() throws Exception {
        new MemoryInitializer().prepareData();
        view = new HomePageViewStub();
        presenter = new HomePagePresenter();
        presenter.setView(view);
    }

    /**
     * Tests the handling of user actions such as login and registration.
     * Verifies that the corresponding view methods are called when the actions are triggered.
     */
    @Test
    public void testActions() {
        // Test login action
        presenter.onLoginAction();
        Assert.assertTrue(((HomePageViewStub) view).onLogin);

        // Test register action
        presenter.onRegisterAction();
        Assert.assertTrue(((HomePageViewStub) view).onRegister);
    }
}