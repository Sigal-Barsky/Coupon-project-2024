package SQL;

public class SQLCustomerCommands {
    /**-CREATE CUSTOMER TABLE-*/
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
    public static final String addCustomer =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`customers`" +
            " (`first_name`, `last_name`, `email`, `password`)" +
            " VALUES (?, ?, ?, ?);";
}
