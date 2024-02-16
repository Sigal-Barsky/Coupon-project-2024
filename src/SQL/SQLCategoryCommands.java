package SQL;

public class SQLCategoryCommands {
    /**-CREATE CATEGORY TABLE-*/
    public static final String CREATE_CATEGORY_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`categories` (" +
                    "  `category_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`category_id`)," +
                    "  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);";
}