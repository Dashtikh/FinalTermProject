package Model.Repsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Update {
    private static PreparedStatement pstmt = null;
    private static Connection conn = Config.getConnect();

    private static String time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void updatePrices(String year, int bread, int rice, int meat, int dairy, int vegetables, float cpi, float inf) throws SQLException {

        String sql = "UPDATE INFLATION SET " +
                "bread = ?," +
                " rice = ?," +
                " meat = ?," +
                " dairy = ?," +
                " vegetables = ?," +
                " cpi = ?," +
                " inf = ?," +
                " updated_date = ?," +
                " agent_name = ?," +
                " agent_id = ?" +
                " where year = ?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, bread);
        pstmt.setInt(2, rice);
        pstmt.setInt(3, meat);
        pstmt.setInt(4, dairy);
        pstmt.setInt(5, vegetables);
        pstmt.setFloat(6, cpi);
        pstmt.setFloat(7, inf);
        pstmt.setString(8, time());
        pstmt.setString(9, "Amir Mohammad Bahrami");
        pstmt.setString(10, "971113004");
        pstmt.setString(11, year);

        pstmt.executeUpdate();
        pstmt.close();
    }

    public static void updateNextInflation(String year, float inf) throws SQLException {

        String sql = "UPDATE INFLATION SET inf = ?, updated_date = ?, agent_name = ?, agent_id = ? where year = ?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setFloat(1, inf);
        pstmt.setString(2, time());
        pstmt.setString(3, "Amir Mohammad Bahrami");
        pstmt.setString(4, "971113004");
        pstmt.setString(5, year);

        pstmt.executeUpdate();
        pstmt.close();
    }

}

