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
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
                    "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";
    /**-SQL COMMAND TO: CHECK IF CUSTOMER EXISTS-*/
    public static final String isCustomerExist =
            "SELECT count(*) FROM customers WHERE email=? AND password=?;";
    /**-SQL COMMAND TO: ADD THE CUSTOMER TO THE DATABASE-*/
    public static final String addCustomer =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`customers`" +
            " (`first_name`, `last_name`, `email`, `password`)" +
            " VALUES (?, ?, ?, ?);";
    /**-SQL COMMAND TO: DELETE A CUSTOMER FROM THE DATABASE-*/
    public static final String deleteCustomer= "DELETE FROM customers WHERE customer_id=?;";
    /**-SQL COMMAND TO: GET ALL CUSTOMERS IN THE DATABASE-*/
    public static final String getAllCustomers= "SELECT * FROM customers;";
    /**-SQL COMMAND TO: GET CUSTOMER IN THE DATABASE BY ID-*/
    public static final String getOneCustomer= "SELECT * FROM customers WHERE customer_id= ?;";
}
