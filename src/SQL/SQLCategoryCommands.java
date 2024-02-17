package SQL;

public class SQLCategoryCommands {
    /**-CREATE CATEGORY TABLE-*/
    public static final String CREATE_CATEGORY_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`categories` (" +
                    "  `category_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`category_id`)," +
                    "  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);";

    public static final String addCategory =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`categories` (`name`) VALUES (?);";

    public static final String getOneCategory= "SELECT name FROM `" + DBManager.SQL_DB + "`.`categories` WHERE category_id= ?;";

    public static final String DROP_CATEGORY_TABLE = "DROP TABLE `" + DBManager.SQL_DB + "`.`categories`;";

}
