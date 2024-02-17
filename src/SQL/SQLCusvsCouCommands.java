package SQL;

public class SQLCusvsCouCommands {
    /**-CREATE CUSTOMERS_VS_COUPONS TABLE-*/
    public static final String CREATE_CUSTOMERS_VS_COUPONS_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`customers_vs_coupons` (" +
                    "`customer_id` INT NOT NULL," +
                    "  `coupon_id` INT NOT NULL," +
                    "  INDEX `customer_fk_idx` (`customer_id` ASC) VISIBLE," +
                    "  INDEX `coupon_fk_idx` (`coupon_id` ASC) VISIBLE," +
                    "  CONSTRAINT `customer_fk`" +
                    "    FOREIGN KEY (`customer_id`)" +
                    "    REFERENCES `coupon_db`.`customers` (`customer_id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION," +
                    "  CONSTRAINT `coupon_fk`" +
                    "    FOREIGN KEY (`coupon_id`)" +
                    "    REFERENCES `coupon_db`.`coupons` (`coupon_id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION);";

    /**-ADD FOREIGN KEY TO CUSTOMERS_VS_COUPONS*/
    public static final String CUSTOMERS_VS_COUPONS_FOREIGN_KEY =
            "ALTER TABLE `" + DBManager.SQL_DB + "`.`customers_vs_coupons`" +
                    "ADD CONSTRAINT FK_customer" +
                    "FOREIGN KEY (customer_id) REFERENCES customers(customer_id)," +
                    "ADD CONSTRAINT FK_coupon" +
                    "FOREIGN KEY (coupon_id) REFERENCES coupons(coupon_id);";
}
