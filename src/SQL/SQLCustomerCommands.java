package SQL;

public class SQLCustomerCommands {
    /**-SQL COMMAND TO: CREATE CUSTOMER TABLE-*/
    public static final String CREATE_CUSTOMER_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`customers` (" +
                    "  `customer_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `first_name` VARCHAR(45) NOT NULL," +
                    "  `last_name` VARCHAR(45) NOT NULL," +
                    "  `email` VARCHAR(45) NOT NULL," +
                    "  `password` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`customer_id`)," +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);";
    /**-SQL COMMAND TO: CHECK IF CUSTOMER EXISTS-*/
    public static final String isCustomerExist =
            "SELECT count(*) FROM `" + DBManager.SQL_DB + "`.`customers` WHERE email=? AND password=?;";

    public static final String isEmailExist =
            "SELECT count(*) FROM `" + DBManager.SQL_DB + "`.`customers` WHERE email=?;";

    /**-SQL COMMAND TO: ADD THE CUSTOMER TO THE DATABASE-*/
    public static final String addCustomer =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`customers`" +
            " (`first_name`, `last_name`, `email`, `password`)" +
            " VALUES (?, ?, ?, ?);";

    public static final String updateCustomer =
            "UPDATE `" + DBManager.SQL_DB + "`.`customers` SET first_name=?, last_name=?, email=?, password=? WHERE customer_id=?;";

    /**-SQL COMMAND TO: DELETE A CUSTOMER FROM THE DATABASE-*/
    public static final String deleteCustomer= "DELETE FROM `" + DBManager.SQL_DB + "`.`customers` WHERE customer_id=?;";
    /**-SQL COMMAND TO: GET ALL CUSTOMERS IN THE DATABASE-*/
    public static final String getAllCustomers= "SELECT * FROM `" + DBManager.SQL_DB + "`.`customers`;";
    /**-SQL COMMAND TO: GET CUSTOMER IN THE DATABASE BY ID-*/
    public static final String getOneCustomer= "SELECT * FROM `" + DBManager.SQL_DB + "`.`customers` WHERE customer_id= ?;";

    public static final String getIdByEmail= "SELECT customer_id FROM `" + DBManager.SQL_DB + "`.`customers` WHERE email=?;";

    public static final String DROP_CUSTOMER_TABLE = "DROP TABLE `" + DBManager.SQL_DB + "`.`customers`;";
}
