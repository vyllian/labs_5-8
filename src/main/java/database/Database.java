package database;
public class Database {
    public static java.sql.Connection connection = null;
    private static final String url = "jdbc:sqlserver://DESKTOP-LUAR5V5\\SQLEXPRESS:62650;main.java.database=Coffee_Van";
    private static final String user = "vylit";
    private static final String password = "#PASSword2004";

    public static java.sql.Connection getConnection() {
        if(connection == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection  = java.sql.DriverManager.getConnection(url, user, password);
                System.out.println("(з'єднання з базою даних успішне)");
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error trace in getConnection() : " + e.getMessage());
            }
        }
        return  connection;
    }

}
