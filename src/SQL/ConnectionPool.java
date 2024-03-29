package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPool {
    private static final int NUMBER_OF_CONNECTION=10;
    private static ConnectionPool instance=null;
    private final Stack<Connection> connections = new Stack<>();
    private ConnectionPool() {
        System.out.println("new connection pool instance created");
        try {
            openAllConnections();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static ConnectionPool getInstance() {
        if (instance==null){
            synchronized (ConnectionPool.class){
                if (instance==null){
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }
    private void openAllConnections() throws SQLException {
        for (int counter=0;counter<NUMBER_OF_CONNECTION;counter++){
            Connection connection = DriverManager.getConnection(DBManager.URL,DBManager.SQL_USER,DBManager.SQL_PASSWORD);
            connections.push(connection);
        }
    }
    public Connection getConnection() throws InterruptedException {
        //lock the connections
        synchronized (connections){
            if (connections.isEmpty()){
                connections.wait();
            }
            return connections.pop();
        }
    }
    public void closeAllConnections() throws InterruptedException {
        synchronized (connections){
            while (connections.size()<NUMBER_OF_CONNECTION){
                connections.wait();
            }
            connections.removeAllElements();
        }
    }
    public void restoreConnection(Connection connection){
        synchronized (connections){
            connections.push(connection);
            connections.notify();
        }
    }
}
