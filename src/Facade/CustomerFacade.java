package Facade;

import java.sql.SQLException;

public class CustomerFacade extends ClientFacade{
    private Integer customerID;

    @Override
    public Boolean Login(String email, String password) throws SQLException {
        return customerDBDAO.isCustomerExist(email,password);
    }
}
