package jdbc;

import javax.management.Query;
import javax.management.QueryExp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:2022/Shop";
        String uname = "postgres";
        String password = "qwerty12";
        String query = "SELECT * FROM public.\"user\"";
        QueryExp query1 = Query.eq(Query.attr("name"), Query.value("Krystian"));
// @NamedQuery
        try {
            Connection connection = DriverManager.getConnection(url, uname, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                StringBuilder usersData = new StringBuilder();
                for (int i = 1; i <= 3; i++) {
                    usersData.append(result.getString(i)).append(":");
                }
                System.out.println(usersData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
