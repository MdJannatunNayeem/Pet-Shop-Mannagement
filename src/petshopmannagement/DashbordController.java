/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package petshopmannagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class DashbordController implements Initializable {

    @FXML
    private Button closeBtn;
    @FXML
    private Button minimizeBtn;
    @FXML
    private AnchorPane nav_bar;
    @FXML
    private Button homeBtn;
    @FXML
    private Button inventory_btn;
    @FXML
    private Button purchaseBtn;
    @FXML
    private Button salesBtn;
    @FXML
    private Button monthlyBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private AnchorPane home_form;
    @FXML
    private Label avaiable_pets;
    @FXML
    private Label total_income;
    @FXML
    private Label total_customerrs;
    @FXML
    private AreaChart<?, ?> data_chart;
    @FXML
    private AnchorPane Inventory_form;
    @FXML
    private TextField in_petid;
    @FXML
    private TextField in_variant;
    @FXML
    private TextField in_age;
    @FXML
    private TextField in_cageId;
    @FXML
    private Button in_add;
    @FXML
    private Button in_update;
    @FXML
    private Button in_clear;
    @FXML
    private Button in_delete;
    @FXML
    private ComboBox<?> in_type;
    @FXML
    private TextField in_search;
    @FXML
    private TableView<Petdata> in_table;
    @FXML
    private TableColumn<Petdata, String> in_col_petid;
    @FXML
    private TableColumn<Petdata, String> in_col_type;
    @FXML
    private TableColumn<Petdata, String> in_col_variant;
    @FXML
    private TableColumn<Petdata, String> in_col_age;
    @FXML
    private TableColumn<Petdata, String> in_col_cageId;
    @FXML
    private AnchorPane Purchase_form;
    @FXML
    private TableView<?> purchase_table;
    @FXML
    private TableColumn<?, ?> purchase_petid;
    @FXML
    private TableColumn<?, ?> purchase_type;
    @FXML
    private TableColumn<?, ?> purchase_variant;
    @FXML
    private TableColumn<?, ?> purchase_price;
    @FXML
    private TableColumn<?, ?> purchase_providerName;
    @FXML
    private AnchorPane purchase_short;
    @FXML
    private TextField purcase_petid;
    @FXML
    private ComboBox<?> purcase_type;
    @FXML
    private TextField purcase_variant;
    @FXML
    private TextField purcase_price;
    @FXML
    private TextField purcase_provideName;
    @FXML
    private Button purcase_addBtn;
    @FXML
    private Button purcase_UpdateBtn;
    @FXML
    private Button purcase_delteBtn;
    @FXML
    private Button purcase_clc;
    @FXML
    private AnchorPane main_form;

    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private String[] TypeList={"Cat","Bird","Fish","Dog"};
    @FXML
    public void addPetTypeList(){
        List<String> lists= new ArrayList();
        
        for(String data : TypeList)
        {
            lists.add(data);
        }
            ObservableList listD= FXCollections.observableArrayList(lists);
            in_type.setItems(listD);
    }

    public ObservableList<Petdata> addPetListData() throws ClassNotFoundException, SQLException {
        ObservableList<Petdata> ListData;
        ListData = FXCollections.observableArrayList();

        String sql = "select * from petdata";
        connection = database.connectDb();

        try {
            prepare = connection.prepareStatement(sql);
            result = prepare.executeQuery();

            Petdata temp_data;

            while (result.next()) {
                temp_data = new Petdata(result.getInt("PetId"), result.getString("Type"),
                        result.getString("Variant"), result.getInt("Age"), result.getString("CageOrAquriumId"));

                ListData.add(temp_data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData;
    }

    @FXML
    public void swithFrom(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (event.getSource() == homeBtn) {
            home_form.setVisible(true);
            Inventory_form.setVisible(false);
            Purchase_form.setVisible(false);

        } else if (event.getSource() == inventory_btn) {
            home_form.setVisible(false);
            Inventory_form.setVisible(true);
            Purchase_form.setVisible(false);
            
            addPetListShow();
            addPetTypeList();

        } else if (event.getSource() == purchaseBtn) {
            home_form.setVisible(false);
            Inventory_form.setVisible(false);
            Purchase_form.setVisible(true);

        }
    }

    private ObservableList<Petdata> addPetList;

    public void addPetListShow() throws ClassNotFoundException, SQLException {
        addPetList = addPetListData();

        in_col_petid.setCellValueFactory(new PropertyValueFactory<>("PetId"));
        in_col_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        in_col_type.setCellValueFactory(new PropertyValueFactory<>("Variant"));
        in_col_type.setCellValueFactory(new PropertyValueFactory<>("Age"));
        in_col_cageId.setCellValueFactory(new PropertyValueFactory<>("CageOrAquriumId"));

        in_table.setItems(addPetList);
    }
    
    @FXML
    public void addPetSelect()
    {
        Petdata petD =in_table.getSelectionModel().getSelectedItem();
        int num= in_table.getSelectionModel().getSelectedIndex();
        
        if((num -1) <-1){return;}
        
        in_petid.setText(String.valueOf(petD.getPetId()));
        in_variant.setText(String.valueOf(petD.getVariant()));
        in_age.setText(String.valueOf(petD.getAge()));
        in_cageId.setText(String.valueOf(petD.getCageOrAquriumId()));
    }

    private double x = 0;
    private double y = 0;

    @FXML
    public void signOut() {
        try {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect username or password");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                logoutBtn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });
                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {

                    stage.setOpacity(1);
                });
                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            addPetListShow();
            addPetTypeList();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DashbordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void minimization() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);

    }

}
