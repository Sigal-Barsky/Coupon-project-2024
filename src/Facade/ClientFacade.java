package Facade;

import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import DBDAO.CustomerDBDAO;

import java.sql.SQLException;

public abstract class ClientFacade {
    protected CompanyDBDAO companyDBDAO = new CompanyDBDAO();
    protected CustomerDBDAO customerDBDAO = new CustomerDBDAO();
    protected CouponDBDAO couponDBDAO = new CouponDBDAO();
    public abstract Boolean Login(String email, String password) throws SQLException;
}
