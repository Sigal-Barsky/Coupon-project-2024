package Cls;


import Beans.ClientType;
import Exeptions.WrongInfoException;
import Facade.AdminFacade;
import Facade.ClientFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;
import SQL.ConnectionPool;

import java.sql.SQLException;

public class LoginManager {
    private static LoginManager instance=null;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (instance==null){
            synchronized (LoginManager.class){
                if (instance==null){
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public ClientFacade login(String email, String password, ClientType clientType){
        try {
            return switch (clientType) {
                case Administrator -> new AdminFacade(email, password);
                case Company -> new CompanyFacade(email, password);
                case Customer -> new CustomerFacade(email, password);
            };
        }
        catch (WrongInfoException e){
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
