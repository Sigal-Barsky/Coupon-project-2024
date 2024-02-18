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
                    "  `amount` INT NULL," +
                    "  `price` DOUBLE NULL," +
                    "  `image` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`coupon_id`)," +
                    "  INDEX `company_id_idx` (`company_id` ASC) VISIBLE," +
                    "  INDEX `category_fk_idx` (`category_id` ASC) VISIBLE," +
                    "  CONSTRAINT `company_fk`" +
                    "    FOREIGN KEY (`company_id`)" +
                    "    REFERENCES `coupon_db`.`companies` (`company_id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION," +
                    "  CONSTRAINT `category_fk`" +
                    "    FOREIGN KEY (`category_id`)" +
                    "    REFERENCES `coupon_db`.`categories` (`category_id`)" +
                    "    ON DELETE NO ACTION" +
                    "    ON UPDATE NO ACTION);";

    public static final String addCoupon =
                    "INSERT INTO `" + DBManager.SQL_DB + "`.`coupons` " +
                    "(`company_id`, `category_id`, `title`, `description`, `start_date`, `end_date`, `amount`, `price`, `image`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String deleteCoupon=
            "DELETE FROM `" + DBManager.SQL_DB + "`.`coupons` WHERE coupon_id=?;";
    public static final String getCompanyCoupons=
            "SELECT * FROM `" + DBManager.SQL_DB + "`.`coupons` WHERE company_id=?;";

    public static final String deleteCompanyCoupons=
            "DELETE FROM `" + DBManager.SQL_DB + "`.`coupons` WHERE company_id=?;";

    public static final String getAllCoupons=
            "SELECT * FROM `" + DBManager.SQL_DB + "`.`coupons`;";

    public static final String getOneCoupon=
            "SELECT * FROM `" + DBManager.SQL_DB + "`.`coupons` WHERE coupon_id= ?;";

    public static final String DROP_COUPON_TABLE =
            "DROP TABLE `" + DBManager.SQL_DB + "`.`coupons`;";
}
