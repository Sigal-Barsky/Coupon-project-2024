package Facade;

import java.sql.SQLException;

public class CompanyFacade extends ClientFacade {
    private Integer companyID;

    @Override
    public Boolean Login(String email, String password) throws SQLException {
        return companyDBDAO.isCompanyExist(email,password);
    }
}
