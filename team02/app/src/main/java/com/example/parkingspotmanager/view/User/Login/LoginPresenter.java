    package com.example.parkingspotmanager.view.User.Login;

    import com.example.parkingspotmanager.domain.Credentials;
    import com.example.parkingspotmanager.dao.CustomerDAO;
    import com.example.parkingspotmanager.dao.EmployeeDAO;
    import com.example.parkingspotmanager.dao.ManagementDAO;
    import com.example.parkingspotmanager.domain.User;

    public class LoginPresenter {

        private LoginView view;
        private CustomerDAO CustomerDAO;
        private ManagementDAO ManagementDAO;
        private EmployeeDAO EmployeeDAO;
        private User loggedInUser;

        /**
         * default constructor
         */
        public LoginPresenter() {
        }


        /**
         * Check for input validation and existence of Credentials in DAOs.
         */
        public void validateCredentials() {
            String username = view.getUsername();
            String password = view.getPassword();
            if (password.length() < 8)
                view.showPopUp(view, "Password must be at least 8 characters!");
            else {
                checkInDAO(username, password);
            }
        }


        /**
         * This method check in CustomerDAO via credentials.
         *
         * @param username user input
         * @param password user input
         */
        public void checkInDAO(String username, String password) {
            Credentials credCheck = new Credentials(username, password);
            if(CustomerDAO.findByCredentials(credCheck)!=null) {
                loggedInUser = CustomerDAO.findByCredentials(credCheck);
                view.startCustomerPage(username);
            }else if (ManagementDAO.findByCredentials(credCheck) != null) {
                loggedInUser = ManagementDAO.findByCredentials(credCheck);
                view.startManagementPage(username);
            } else if (EmployeeDAO.findByCredentials(credCheck) != null) {;
                loggedInUser = EmployeeDAO.findByCredentials(credCheck);
                view.startEmployeePage(username);
            } else {
                view.showPopUp(view, "Invalid credentials. We didn't find any user with these credentials.");
            }
        }

        /**
         * set a new view
         * @param view the new view
         */
        public void setView(LoginView view) {
            this.view = view;
        }

        /**
         * clear the view
         */
        public void clearView() {
            this.view = null;
        }

        /**
         * get the CustomerDAO
         * @return the CustomerDAO
         */
        public User getUser() {
            return loggedInUser;
        }

        /**
         * set the CustomerDAO
         * @param customerDAOMemory the new CustomerDAO
         */
        public void setCustomerDAO(CustomerDAO customerDAOMemory) {
            this.CustomerDAO = customerDAOMemory;
        }

        /**
         * set the ManagementDAO
         * @param managementDAOMemory the new ManagementDAO
         */
        public void setManagementDAO(ManagementDAO managementDAOMemory) {
            this.ManagementDAO = managementDAOMemory;
        }

        /**
         * set the EmployeeDAO
         * @param employeeDAOMemory the new EmployeeDAO
         */
        public void setEmployeeDAO(EmployeeDAO employeeDAOMemory) {
            this.EmployeeDAO = employeeDAOMemory;
        }

        /**
         * get the view
         * @return the view
         */
        public Object getView() {
            return view;
        }
    }
