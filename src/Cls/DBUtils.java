package Cls;

import SQL.ConnectionPool;

import java.sql.*;
import java.util.Map;

public class DBUtils {
    public static boolean runQuery(String sql) {
        Connection connection = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }

    }

    public static boolean runQuery(String sql, Map<Integer, Object> params) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            params.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConnectionPool.getInstance().restoreConnection(connection);
        }
    }

    public static ResultSet runQueryFroResult(String sql, Map<Integer, Object> params) {
        Connection connection = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            params.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            System.out.println(preparedStatement);
            return preparedStatement.executeQuery();
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet runQueryFroResult(String sql) {
        Connection connection = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            System.out.println(preparedStatement);
            return preparedStatement.executeQuery();
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}