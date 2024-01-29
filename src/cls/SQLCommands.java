package cls;

public class SQLCommands {
    //------COMPANY TABLE AND COMMANDS-------
    public static final String CREATE_COMPANY_TABLE = "CREATE TABLE IF NOT EXISTS `coupon_db`.`companies` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  `email` VARCHAR(45) NOT NULL," +
            "  `password` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
            "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";

    //------CUSTOMER TABLE AND COMMANDS-------
    public static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS `coupon_db`.`customers` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `first_name` VARCHAR(45) NOT NULL," +
            "  `last_name` VARCHAR(45) NOT NULL," +
            "  `email` VARCHAR(45) NOT NULL," +
            "  `password` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
            "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";

    //------CATEGORY TABLE AND COMMANDS-------
    public static final String CREATE_CATEGORY_TABLE = "CREATE TABLE `coupon_db`.`categories` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);";

    //------COMPANY TABLE AND COMMANDS-------
    public static final String CREATE_COUPON_TABLE = "CREATE TABLE `coupon_db`.`coupons` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `company_id` INT NOT NULL," +
            "  `category_id` INT NOT NULL," +
            "  `title` VARCHAR(45) NOT NULL," +
            "  `description` VARCHAR(45) NULL," +
            "  `start_date` DATE NOT NULL," +
            "  `end_date` DATE NOT NULL," +
            "  `amount` INT NOT NULL," +
            "  `price` DOUBLE NOT NULL," +
            "  `image` VARCHAR(45) NULL," +
            "  PRIMARY KEY (`id`)," +
            "  UNIQUE INDEX `title_UNIQUE` (`title` ASC) VISIBLE," +
            "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);";
}
