package SQL;

public class SQLCouponCommands {
    /**-CREATE COUPON TABLE-*/
    public static final String CREATE_COUPON_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`coupons` (" +
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
    public static final String COUPON_FOREIGN_KEY =
            "ALTER TABLE `"+ DBManager.SQL_DB + "`.`coupons`" +
                    "ADD CONSTRAINT FK_company" +
                    "FOREIGN KEY (company_id) REFERENCES companies(company_id)," +
                    "ADD CONSTRAINT FK_category" +
                    "FOREIGN KEY (category_id) REFERENCES categories(category_id);";
}
