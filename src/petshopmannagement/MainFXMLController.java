/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package petshopmannagement;

import com.gluonhq.charm.glisten.control.TextField;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author LENOVO
 */
public class MainFXMLController implements Initializable {

    @FXML
    private Button close;
    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField userid;
    @FXML
    private Button loginbtn;

    private double x = 0;
    private double y = 0;

    /**
     *
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void adminLogin() throws SQLException, ClassNotFoundException, IOException {
        String sql = "select * from admin where Username=? and Password=?";
        connection = database.connectDb();

        try {
            Alert alert;
            if (userid.getText().isEmpty() || pass.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {
                prepare = connection.prepareStatement(sql);
                prepare.setString(1, userid.getText());
                prepare.setString(2, pass.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Sucessfully Login");
                    alert.showAndWait();

                    loginbtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);

                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect username or password");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){e.printStackTrace();}
            

    }
}
