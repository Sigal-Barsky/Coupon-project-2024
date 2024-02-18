package SQL;

public class SQLCusvsCouCommands {
    /**-CREATE CUSTOMERS_VS_COUPONS TABLE-*/
    public static final String CREATE_CUSTOMERS_VS_COUPONS_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`customers_vs_coupons` (" +
                    "  `cvsc_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `customer_id` INT NOT NULL," +
                    "  `coupon_id` INT NOT NULL," +
                    "  PRIMARY KEY (`cvsc_id`)," +
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

    public static final String addCVsC =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`customers_vs_coupons` " +
                    "(`customer_id`, `coupon_id`) VALUES (?, ?);";

    public static final String deleteCVsC=
            "DELETE FROM `" + DBManager.SQL_DB + "`.`customers_vs_coupons` WHERE coupon_id=1 AND customer_id=1;";

    public static final String DROP_CUSTOMERS_VS_COUPONS_TABLE =
            "DROP TABLE `" + DBManager.SQL_DB + "`.`customers_vs_coupons`;";

}
