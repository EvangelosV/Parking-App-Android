package com.example.parkingspotmanager.view.Management.ManagementPage;

import com.example.parkingspotmanager.dao.Initializer;
import com.example.parkingspotmanager.memorydao.MemoryInitializer;
import com.example.parkingspotmanager.memorydao.ManagementDAOMemory;
import com.example.parkingspotmanager.domain.Management;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The `ManagementPagePresenterTest` class contains unit tests for the `ManagementPagePresenter` class.
 * It tests the functionality of retrieving management information, handling user actions, and clearing the view.
 */
public class ManagementPagePresenterTest {

    private ManagementPagePresenter presenter;
    private ManagementPageViewStub view;

    /**
     * Sets up the test environment before each test case. Initializes the data, view, and presenter.
     */
    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();
        view = new ManagementPageViewStub();
        presenter = new ManagementPagePresenter();
        presenter.setView(view);
        presenter.setManagementDAO(new ManagementDAOMemory());
    }

    /**
     * Tests the retrieval of management information by username.
     * Verifies that the correct management user is retrieved and that the username matches.
     */
    @Test
    public void testGetManagementInfo() {
        Management management = new Management("Andreas", "Lamp", "management@org.com", "6995956585", "UsernameTest", "UsernamePassword");
        presenter.getManagementDAO().save(management);

        Management result = presenter.getManagementInfo("UsernameTest");
        Assert.assertNotNull(result);
        Assert.assertEquals("UsernameTest", result.getUsername());
    }

    /**
     * Tests the retrieval of the management user's username.
     * Verifies that the correct username is returned.
     */
    @Test
    public void testGetManagementUsername() {
        Management management = new Management("Andreas", "Lamp", "management@org.com", "6995956585", "UsernameTest", "UsernamePassword");
        presenter.getManagementDAO().save(management);
        presenter.getManagementInfo("UsernameTest");

        String username = presenter.getManagementUsername();
        Assert.assertEquals("UsernameTest", username);
    }

    /**
     * Tests the handling of user actions such as navigating to analytics and logging out.
     * Verifies that the corresponding view methods are called.
     */
    @Test
    public void testActions() {
        presenter.onAnalytics();
        Assert.assertTrue(view.onAnalytics);

        presenter.onLogout();
        Assert.assertTrue(view.onLogout);
    }

    /**
     * Tests the `clearView` method to ensure that the view reference is properly cleared.
     * Verifies that the view is set to null after calling the method.
     */
    @Test
    public void testClearView() {
        // Ensure the view is set initially
        Assert.assertNotNull(presenter.getView());

        // Call the clearView method
        presenter.clearView();

        // Verify that the view is set to null
        Assert.assertNull(presenter.getView());
    }
}