package SQL;

public class SQLCompanyCommands {
    /**-SQL COMMAND TO: CREATE COMPANY TABLE-*/
    public static final String CREATE_COMPANY_TABLE =
            "CREATE TABLE IF NOT EXISTS `" + DBManager.SQL_DB + "`.`companies` (" +
                    "  `company_id` INT NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(45) NOT NULL," +
                    "  `email` VARCHAR(45) NOT NULL," +
                    "  `password` VARCHAR(45) NOT NULL," +
                    "  PRIMARY KEY (`company_id`)," +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE," +
                    "  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE);";

    /**-SQL COMMAND TO: CHECK COMPANY EXISTS-*/
    public static final String isCompanyExist =
            "SELECT count(*) FROM companies WHERE email=? AND password=?;";

    /**-SQL COMMAND TO: ADD COMPANY TO TABLE-*/
    public static final String addCompany =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`companies`" +
            " (`name`, `email`, `password`)" +
            " VALUES ( ?, ?, ?);";

    /**-SQL COMMAND TO: CREATE COMPANY TABLE-*/
    public static final String deleteCompany= "DELETE FROM companies WHERE company_id=?;";

    /**-SQL COMMAND TO: GET COMPANIES IN THE DATABASE-*/
    public static final String getAllCompanies= "SELECT * FROM companies;";

    /**-SQL COMMAND TO: GET COMPANY IN THE DATABASE BY ID-*/
    public static final String getOneCompany= "SELECT * FROM companies WHERE company_id= ?;";
}
