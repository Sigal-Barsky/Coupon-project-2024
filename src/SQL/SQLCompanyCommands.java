package SQL;

public class SQLCompanyCommands {
    /**-CREATE COMPANY TABLE-*/
    public static final String CREATE_COMPANY_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`companies` (" +
                    "  `company_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(45) NOT NULL," +
                    "  `email` VARCHAR(45) NOT NULL," +
                    "  `password` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`company_id`)," +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
                    "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";

    public static final String isCompanyExist =
            "SELECT COUNT(*) AS user " +
                    "FROM companies " +
                    "WHERE name=? AND password=?";
}
