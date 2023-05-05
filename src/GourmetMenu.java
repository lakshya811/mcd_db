import java.sql.*;

public class GourmetMenu extends MenuItems {
    private Statement stmt;

    public GourmetMenu(Connection conn) throws SQLException {
        super(conn);
        stmt = conn.createStatement();
//        super(stmt);
    }

    public void showTopItems(String nutrient) throws SQLException {
        String sql = "SELECT * FROM gourmet_menu ORDER BY " + nutrient + " DESC LIMIT 5;";
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Top 5 Gourmet items with highest " + nutrient + ":");
        while (rs.next()) {
            System.out.println(rs.getString("menu_item") + " - " + rs.getInt(nutrient) + " " + nutrient);
        }
    }

    public void showItemInfo(String menuItemName) throws SQLException {
        String sql = "SELECT * FROM gourmet_menu WHERE Item = '" + menuItemName + "'";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            System.out.println("Name: " + rs.getString("Item"));
            System.out.println("Per serve amount: " + rs.getString("per_serve_size"));
            System.out.println("Calories: " + rs.getFloat("Energy_kCal"));
            System.out.println("Protein: " + rs.getFloat("Protein_g"));
            System.out.println("Cholesterol: " + rs.getFloat("Cholesterol_g"));
            System.out.println("Carbs: " + rs.getFloat("Carbohydrates_g"));
            System.out.println("Fats: " + rs.getFloat("TotalFats_g"));
            System.out.println("Sugars: " + rs.getFloat("TotalSugars_g"));
            System.out.println("Price: " + rs.getInt("Price_Rs"));
        } else {
            System.out.println("Menu item not found!");
        }
    }
}