package Facade;

import DBDAO.CompanyDBDAO;
import DBDAO.CouponDBDAO;
import DBDAO.CustomerDBDAO;

import java.sql.SQLException;

abstract class ClientFacade {
    protected CompanyDBDAO companyDBDAO;
    protected CustomerDBDAO customerDBDAO;
    protected CouponDBDAO couponDBDAO;
    public abstract Boolean Login(String email, String password) throws SQLException;
}
