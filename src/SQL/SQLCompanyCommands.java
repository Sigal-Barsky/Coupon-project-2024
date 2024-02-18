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
                    "  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE),"+
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);";

    /**-SQL COMMAND TO: CHECK COMPANY EXISTS-*/
    public static final String isCompanyExist =
            "SELECT count(*) FROM `" + DBManager.SQL_DB + "`.`companies` WHERE email=? AND password=?;";

    public static final String isNameExist =
            "SELECT count(*) FROM `" + DBManager.SQL_DB + "`.`companies` WHERE name=?;";

    public static final String isEmailExist =
            "SELECT count(*) FROM `" + DBManager.SQL_DB + "`.`companies` WHERE email=?;";

    /**-SQL COMMAND TO: ADD COMPANY TO TABLE-*/
    public static final String addCompany =
            "INSERT INTO `" + DBManager.SQL_DB + "`.`companies`" +
            " (`name`, `email`, `password`)" +
            " VALUES ( ?, ?, ?);";

    public static final String updateCompany =
            "UPDATE `" + DBManager.SQL_DB + "`.`companies` SET email=?, password=? WHERE company_id=?;";

    /**-SQL COMMAND TO: DELETE A COMPANY FROM THE DATABASE-*/
    public static final String deleteCompany=
            "DELETE FROM `" + DBManager.SQL_DB + "`.`companies` WHERE company_id=?;";

    /**-SQL COMMAND TO: GET COMPANIES IN THE DATABASE-*/
    public static final String getAllCompanies=
            "SELECT * FROM `" + DBManager.SQL_DB + "`.`companies`;";

    /**-SQL COMMAND TO: GET COMPANY IN THE DATABASE BY ID-*/
    public static final String getOneCompany=
            "SELECT * FROM `" + DBManager.SQL_DB + "`.`companies` WHERE company_id= ?;";

    /**-SQL COMMAND TO: DROP COMPANY TABLE-*/
    public static final String DROP_COMPANY_TABLE =
            "DROP TABLE `" + DBManager.SQL_DB + "`.`companies`;";
}
