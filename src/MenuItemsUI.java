//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class MenuItemsUI extends MenuItemsDB {
//    static final String DB_URL = "jdbc:mysql://localhost/mcd_db";
//    static final String DB_USER = "root";
//    static final String DB_PASS = "admin";
//
//    private ComboBox<String> menuComboBox;
//    private ComboBox<String> nutrientComboBox;
//    private Label resultLabel;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create UI elements
//        Label menuLabel = new Label("Select menu:");
//        menuComboBox = new ComboBox<>();
//        menuComboBox.getItems().addAll("breakfast_menu", "condiments_menu", "gourmet_menu", "mc_cafe_menu", "menu_items", "regular_menu");
//
//        Label nutrientLabel = new Label("Select nutrient:");
//        nutrientComboBox = new ComboBox<>();
//        nutrientComboBox.getItems().addAll("energy_kcal", "protein_g", "cholesterol_g", "carbohydrates_g", "totalfats_g", "totalsugars_g");
//
//        Button searchButton = new Button("Search");
//        searchButton.setOnAction(event -> search());
//
//        resultLabel = new Label("");
//
//        VBox root = new VBox();
//        root.setSpacing(10);
//        root.setPadding(new Insets(10));
//        root.setAlignment(Pos.CENTER);
//
//        GridPane searchPane = new GridPane();
//        searchPane.setHgap(10);
//        searchPane.setVgap(10);
//        searchPane.setAlignment(Pos.CENTER);
//        searchPane.add(menuLabel, 0, 0);
//        searchPane.add(menuComboBox, 1, 0);
//        searchPane.add(nutrientLabel, 0, 1);
//        searchPane.add(nutrientComboBox, 1, 1);
//        searchPane.add(searchButton, 2, 1);
//
//        root.getChildren().addAll(searchPane, resultLabel);
//
//        Scene scene = new Scene(root, 600, 400);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Menu Items Database");
//        primaryStage.show();
//    }
//
//    private void search() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
//
//            String menu = menuComboBox.getValue();
//            String nutrient = nutrientComboBox.getValue();
//
//            Statement stmt = conn.createStatement();
//            String sql = "SELECT * FROM " + menu + " ORDER BY " + nutrient + " DESC LIMIT 5;";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            StringBuilder sb = new StringBuilder();
//            sb.append("Top 5 " + menu + " items with " + nutrient + "\n");
//            while (rs.next()) {
//                sb.append(rs.getString("menu_items") + " - " + rs.getInt(nutrient) + " " + nutrient + "\n");
//            }
//
//            resultLabel.setText(sb.toString());
//
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}