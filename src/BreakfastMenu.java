import java.sql.*;

public class BreakfastMenu extends Items {
    private Connection conn;
    private Statement stmt;
    private String nutrient;
    private String menuItemName;

    public BreakfastMenu(Connection conn) throws SQLException {
        super(conn);
        this.conn = conn;
        stmt = conn.createStatement();
    }

    public void setNutrient(String nutrient) {
        this.nutrient = nutrient;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    @Override
    public void showHigh() {
        String sql = "SELECT * FROM breakfast_menu ORDER BY " + nutrient + " ASC LIMIT 5;";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Top 5 Breakfast items with lowest " + nutrient + ":");
            while (rs.next()) {
                System.out.println(rs.getString("Item") + " - " + rs.getFloat(nutrient) + " " + nutrient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLow() {
        String sql = "SELECT * FROM breakfast_menu ORDER BY " + nutrient + " DESC LIMIT 5;";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Top 5 Breakfast items with highest " + nutrient + ":");
            while (rs.next()) {
                System.out.println(rs.getString("Item") + " - " + rs.getFloat(nutrient) + " " + nutrient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showInfo() {
        String sql = "SELECT * FROM breakfast_menu WHERE Item = '" + menuItemName + "'";
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}