package SQL;

public class SQLCommands {
    /**-CREATE COMPANY TABLE-*/
    public static final String CREATE_COMPANY_TABLE = "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB +
            "`.`companies` (" +
            "  `company_id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  `email` VARCHAR(45) NOT NULL," +
            "  `password` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`company_id`)," +
            "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
            "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";

    /**-CREATE CUSTOMER TABLE-*/
    public static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB +
            "`.`customers` (" +
            "  `customer_id` INT NOT NULL AUTO_INCREMENT," +
            "  `first_name` VARCHAR(45) NOT NULL," +
            "  `last_name` VARCHAR(45) NOT NULL," +
            "  `email` VARCHAR(45) NOT NULL," +
            "  `password` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`customer_id`)," +
            "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
            "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";

    /**-CREATE CATEGORY TABLE-*/
    public static final String CREATE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB +
            "`.`categories` (" +
            "  `category_id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`category_id`)," +
            "  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);";

    /**-CREATE COUPON TABLE-*/
    public static final String CREATE_COUPON_TABLE = "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB +
            "`.`coupons` (" +
            "  `coupon_id` INT NOT NULL AUTO_INCREMENT," +
            "  `company_id` INT NOT NULL," +
            "  `category_id` INT NOT NULL," +
            "  `title` VARCHAR(45) NOT NULL," +
            "  `description` VARCHAR(45) NULL," +
            "  `start_date` DATE NOT NULL," +
            "  `end_date` DATE NOT NULL," +
            "  `amount` INT NOT NULL," +
            "  `price` DOUBLE NOT NULL," +
            "  `image` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`coupon_id`)," +
            "  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE," +
            "  UNIQUE INDEX `id_UNIQUE` (`coupon_id` ASC) VISIBLE);";

    /**-ADD FOREIGN KEY TO COUPONS*/
    public static final String COUPON_FOREIGN_KEY = "ALTER TABLE `"+ DBManager.SQL_DB +
            "`.`coupons`" +
            "ADD CONSTRAINT FK_company" +
            "FOREIGN KEY (company_id) REFERENCES companies(company_id)," +
            "ADD CONSTRAINT FK_category" +
            "FOREIGN KEY (category_id) REFERENCES categories(category_id);";

    /**-CREATE CUSTOMERS_VS_COUPONS TABLE-*/
    public static final String CREATE_CUSTOMERS_VS_COUPONS_TABLE = "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB +
            "`.`customers_vs_coupons` (" +
            "  `customer_id` INT NOT NULL," +
            "  `coupon_id` INT NOT NULL);";

    /**-ADD FOREIGN KEY TO CUSTOMERS_VS_COUPONS*/
    public static final String CUSTOMERS_VS_COUPONS_FOREIGN_KEY ="ALTER TABLE `" + DBManager.SQL_DB +
            "`.`customers_vs_coupons`" +
            "ADD CONSTRAINT FK_customer" +
            "FOREIGN KEY (customer_id) REFERENCES customers(customer_id)," +
            "ADD CONSTRAINT FK_coupon" +
            "FOREIGN KEY (coupon_id) REFERENCES coupons(coupon_id);";
}
