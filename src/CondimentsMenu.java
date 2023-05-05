import java.sql.*;

public class CondimentsMenu extends Items {
    private Statement stmt;
    private Connection conn;
    private String nutrient;
    private String menuItemName;

    public CondimentsMenu(Connection conn) throws SQLException {
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
}