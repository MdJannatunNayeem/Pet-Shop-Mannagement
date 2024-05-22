/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package petshopmannagement;

import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private TableView<PurchaseData> purchase_table;
    @FXML
    private TableColumn<PurchaseData, String> purchase_petid;
    @FXML
    private TableColumn<PurchaseData, String> purchase_variant;
    @FXML
    private TableColumn<PurchaseData, String> purchase_price;
    @FXML
    private TableColumn<PurchaseData, String> purchase_providerName;
    @FXML
    private AnchorPane purchase_short;
    @FXML
    private TextField purcase_petid;
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
    private Statement statement;
    private ResultSet result;
    @FXML
    private AnchorPane sales_form;
    @FXML
    private TableColumn<?, ?> purchase_type;
    @FXML
    private ComboBox<?> purcase_type;
    @FXML
    private TableView<SalesData> in_table1;
    @FXML
    private TextField sales_petid;
    @FXML
    private TextField sales_price;
    @FXML
    private TextField sales_name;
    @FXML
    private TextField sales_phone;
    @FXML
    private Button sales_addBtn;
    @FXML
    private Button sales_updateBtn;
    @FXML
    private Button sales_clearBtn;
    @FXML
    private Button sales_deleteBtn;
    @FXML
    private ComboBox<?> sales_type;
    @FXML
    private TableColumn<SalesData, String> sales_col_petid;
    @FXML
    private TableColumn<SalesData, String> sales_col_type;
    @FXML
    private TableColumn<SalesData, String> sales_col_price;
    @FXML
    private TableColumn<SalesData, String> sales_col_name;
    @FXML
    private TableColumn<SalesData, String> sales_col_phone;
    @FXML
    private TextField sales_search;
    @FXML
    private AnchorPane sales_form1;
    @FXML
    private TextField report_petid;
    @FXML
    private TextField report_price;
    @FXML
    private TextField report_date;
    @FXML
    private Button report_addBtn;
    @FXML
    private Button report_updateBttn;
    @FXML
    private Button report_clearBtn;
    @FXML
    private Button report_deleteBtn;
    @FXML
    private ComboBox<?> report_action;
    @FXML
    private ComboBox<?> report_month;
    @FXML
    private TextField report_search;
    @FXML
    private TableView<MonthlyData> in_table11;
    @FXML
    private TableColumn<MonthlyData, String> report_col_petid;
    @FXML
    private TableColumn<MonthlyData, String> report_col_action;
    @FXML
    private TableColumn<MonthlyData, String> report_col_price;
    @FXML
    private TableColumn<MonthlyData, String> report_col_date;
    @FXML
    private TableColumn<MonthlyData, String> report_col_month;

    @FXML
    public void addpetAdd() throws ClassNotFoundException, SQLException {
        String sql = "Insert Into petdata (PetId,Type,Variant,Age,CageOrAquriumId) values(?,?,?,?,?)";

        connection = database.connectDb();

        try {

            Alert alert;
            if (in_petid.getText().isEmpty() || in_type.getSelectionModel().getSelectedItem() == null
                    || in_variant.getText().isEmpty() || in_age.getText().isEmpty() || in_cageId.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {

                String checkData = "Select PetId from petdata where PetId=" + in_petid.getText() + "";
                statement = (Statement) connection.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("is already added");
                    alert.showAndWait();
                } else {
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, in_petid.getText());
                    prepare.setString(2, (String) in_type.getSelectionModel().getSelectedItem());
                    prepare.setString(3, in_variant.getText());
                    prepare.setString(4, in_age.getText());
                    prepare.setString(5, in_cageId.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added");
                    alert.showAndWait();

                    addPetListShow();
                    addPetClear();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addPetUpdate() throws ClassNotFoundException, SQLException {

        String sql = "update petdata set Type='" + in_type.getSelectionModel().getSelectedItem() + "',"
                + " Variant='" + in_variant.getText() + "', Age='" + in_age.getText() + "',"
                + " CageOrAquriumId='" + in_cageId.getText() + "' where PetId= " + in_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;
            if (in_petid.getText().isEmpty() || in_type.getSelectionModel().getSelectedItem() == null
                    || in_variant.getText().isEmpty() || in_age.getText().isEmpty() || in_cageId.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to update Pet Id " + in_petid.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = (Statement) connection.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully updated");
                    alert.showAndWait();

                    addPetListShow();
                    addPetClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void addPetDelete() throws ClassNotFoundException, SQLException {
        String sql = "Delete from petdata where PetId =" + in_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to delete Pet Id " + in_petid.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = (Statement) connection.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();

                addPetListShow();
                addPetClear();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addPetClear() {

        in_petid.setText("");
        in_type.getSelectionModel().clearSelection();
        in_variant.setText("");
        in_age.setText("");
        in_cageId.setText("");

    }
    private String[] TypeList = {"Cat", "Bird", "Fish", "Dog"};

    @FXML
    public void addPetTypeList() {
        List<String> lists = new ArrayList();

        for (String data : TypeList) {
            lists.add(data);
        }
        ObservableList listD = FXCollections.observableArrayList(lists);
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
            sales_form.setVisible(false);
            sales_form1.setVisible(false);

        } else if (event.getSource() == inventory_btn) {
            home_form.setVisible(false);
            Inventory_form.setVisible(true);
            Purchase_form.setVisible(false);
            sales_form.setVisible(false);
            sales_form1.setVisible(false);

            addPetListShow();
            addPetTypeList();
            addPetSearch();

        } else if (event.getSource() == purchaseBtn) {
            home_form.setVisible(false);
            Inventory_form.setVisible(false);
            Purchase_form.setVisible(true);
            sales_form.setVisible(false);
            sales_form1.setVisible(false);

            PurchasePetListShow();
            PurchasePetTypeList();
            PurchasePetTypeList();

        } else if (event.getSource() == salesBtn) {
            home_form.setVisible(false);
            Inventory_form.setVisible(false);
            Purchase_form.setVisible(false);
            sales_form.setVisible(true);
            sales_form1.setVisible(false);

            SalesPetListShow();
            SalesPetTypeList();
            SalesPetClear();

        } else if (event.getSource() == monthlyBtn) {
            home_form.setVisible(false);
            Inventory_form.setVisible(false);
            Purchase_form.setVisible(false);
            sales_form.setVisible(false);
            sales_form1.setVisible(true);

            MonthlyPetListShow();

            MonthlyPetActionList();
            MonthlyPetMonthList();
            MonthlyPetClear();
        }

    }

    private ObservableList<Petdata> addPetList;

    public void addPetListShow() throws ClassNotFoundException, SQLException {
        addPetList = addPetListData();

        in_col_petid.setCellValueFactory(new PropertyValueFactory<>("PetId"));
        in_col_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        in_col_variant.setCellValueFactory(new PropertyValueFactory<>("Variant"));
        in_col_age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        in_col_cageId.setCellValueFactory(new PropertyValueFactory<>("CageOrAquriumId"));

        in_table.setItems(addPetList);
    }

    @FXML
    public void addPetSelect() {
        Petdata petD = in_table.getSelectionModel().getSelectedItem();
        int num = in_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        in_petid.setText(String.valueOf(petD.getPetId()));
        in_variant.setText(String.valueOf(petD.getVariant()));
        in_age.setText(String.valueOf(petD.getAge()));
        in_cageId.setText(String.valueOf(petD.getCageOrAquriumId()));
    }

    @FXML
    public void addPetSearch() {
        FilteredList<Petdata> filter = new FilteredList<>(addPetList, e -> true);
        in_search.textProperty().addListener((observable, oldValue, newValue)
                -> {
            filter.setPredicate(predicatePetdata -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchkey = newValue.toLowerCase();

                if (predicatePetdata.getCageOrAquriumId().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicatePetdata.getVariant().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicatePetdata.getType().toLowerCase().contains(searchkey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Petdata> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(in_table.comparatorProperty());
        in_table.setItems(sortList);

    }
//purchase 

    public ObservableList<PurchaseData> PurchasePetListData() throws ClassNotFoundException, SQLException {
        ObservableList<PurchaseData> ListData1;
        ListData1 = FXCollections.observableArrayList();

        String sql = "select * from PurchaseData";
        connection = database.connectDb();

        try {
            prepare = connection.prepareStatement(sql);
            result = prepare.executeQuery();

            PurchaseData temp_data;

            while (result.next()) {
                temp_data = new PurchaseData(result.getInt("PetId"), result.getString("Type"),
                        result.getString("Variant"), result.getInt("Price"), result.getString("ProviderName"));

                ListData1.add(temp_data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData1;
    }

    private ObservableList<PurchaseData> PurchasePetList;

    public void PurchasePetListShow() throws ClassNotFoundException, SQLException {
        PurchasePetList = PurchasePetListData();

        purchase_petid.setCellValueFactory(new PropertyValueFactory<>("PetId"));
        purchase_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        purchase_variant.setCellValueFactory(new PropertyValueFactory<>("Variant"));
        purchase_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        purchase_providerName.setCellValueFactory(new PropertyValueFactory<>("ProviderName"));

        purchase_table.setItems(PurchasePetList);
    }

    @FXML
    public void PurchasePetTypeList() {
        List<String> lists = new ArrayList();

        for (String data : TypeList) {
            lists.add(data);
        }
        ObservableList listD = FXCollections.observableArrayList(lists);
        purcase_type.setItems(listD);
    }

    @FXML
    public void PurchasePetClear() {

        purcase_petid.setText("");
        purcase_type.getSelectionModel().clearSelection();
        purcase_variant.setText("");
        purcase_price.setText("");
        purcase_provideName.setText("");

    }

    @FXML
    public void PurchasePetSelect() {
        PurchaseData petD = purchase_table.getSelectionModel().getSelectedItem();
        int num = purchase_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        purcase_petid.setText(String.valueOf(petD.getPetId()));
        purcase_variant.setText(String.valueOf(petD.getVariant()));
        purcase_price.setText(String.valueOf(petD.getPrice()));
        purcase_provideName.setText(String.valueOf(petD.getProviderName()));
    }

    @FXML
    public void PurchasepetAdd() throws ClassNotFoundException, SQLException {
        String sql = "Insert Into PurchaseData (PetId,Type,Variant,Price,ProviderName) values(?,?,?,?,?)";

        connection = database.connectDb();

        try {

            Alert alert;
            if (purcase_petid.getText().isEmpty() || purcase_type.getSelectionModel().getSelectedItem() == null
                    || purcase_variant.getText().isEmpty() || purcase_price.getText().isEmpty() || purcase_provideName.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {

                String checkData = "Select PetId from PurchaseData where PetId=" + purcase_petid.getText() + "";
                statement = (Statement) connection.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("is already added");
                    alert.showAndWait();
                } else {
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, purcase_petid.getText());
                    prepare.setString(2, (String) purcase_type.getSelectionModel().getSelectedItem());
                    prepare.setString(3, purcase_variant.getText());
                    prepare.setString(4, purcase_price.getText());
                    prepare.setString(5, purcase_provideName.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added");
                    alert.showAndWait();

                    PurchasePetListShow();
                    PurchasePetClear();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void PurchasePetUpdate() throws ClassNotFoundException, SQLException {

        String sql = "update PurchaseData set Type='" + purcase_type.getSelectionModel().getSelectedItem() + "',"
                + " Variant='" + purcase_variant.getText() + "', price='" + purcase_price.getText() + "',"
                + " ProviderName='" + purcase_provideName.getText() + "' where PetId= " + purcase_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;
            if (purcase_petid.getText().isEmpty() || purcase_type.getSelectionModel().getSelectedItem() == null
                    || purcase_variant.getText().isEmpty() || purcase_price.getText().isEmpty() || purcase_provideName.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to update Pet Id " + purcase_petid.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = (Statement) connection.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully updated");
                    alert.showAndWait();

                    PurchasePetListShow();
                    PurchasePetClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void PurchasePetDelete() throws ClassNotFoundException, SQLException {
        String sql = "Delete from PurchaseData where PetId =" + purcase_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to delete Pet Id " + purcase_petid.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = (Statement) connection.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();

                PurchasePetListShow();
                PurchasePetClear();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //sales data
    public ObservableList<SalesData> SalesPetListData() throws ClassNotFoundException, SQLException {
        ObservableList<SalesData> ListData1;
        ListData1 = FXCollections.observableArrayList();

        String sql = "select * from SalesData";
        connection = database.connectDb();

        try {
            prepare = connection.prepareStatement(sql);
            result = prepare.executeQuery();

            SalesData temp_data;

            while (result.next()) {
                temp_data = new SalesData(result.getInt("PetId"), result.getString("Type"),
                        result.getInt("Price"), result.getString("CustomerName"), result.getString("PhoneNo"));

                ListData1.add(temp_data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData1;
    }

    private ObservableList<SalesData> SalesPetList;

    public void SalesPetListShow() throws ClassNotFoundException, SQLException {
        SalesPetList = SalesPetListData();

        sales_col_petid.setCellValueFactory(new PropertyValueFactory<>("PetId"));
        sales_col_type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        sales_col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        sales_col_name.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        sales_col_phone.setCellValueFactory(new PropertyValueFactory<>("PhoneNo"));

        in_table1.setItems(SalesPetList);
    }

    @FXML
    public void SalesPetTypeList() {
        List<String> lists = new ArrayList();

        for (String data : TypeList) {
            lists.add(data);
        }
        ObservableList listD = FXCollections.observableArrayList(lists);
        sales_type.setItems(listD);
    }

    @FXML
    public void SalesPetClear() {

        sales_petid.setText("");
        sales_type.getSelectionModel().clearSelection();
        sales_price.setText("");
        sales_name.setText("");
        sales_phone.setText("");

    }

    @FXML
    public void SalesPetSelect() {
        SalesData petD = in_table1.getSelectionModel().getSelectedItem();
        int num = in_table1.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        sales_petid.setText(String.valueOf(petD.getPetId()));
        sales_price.setText(String.valueOf(petD.getPrice()));
        sales_name.setText(String.valueOf(petD.getCustomerName()));
        sales_phone.setText(String.valueOf(petD.getPhoneNo()));
    }

    @FXML
    public void SalespetAdd() throws ClassNotFoundException, SQLException {
        String sql = "Insert Into SalesData (PetId,Type,Price,CustomerName,PhoneNo) values(?,?,?,?,?)";

        connection = database.connectDb();

        try {

            Alert alert;
            if (sales_petid.getText().isEmpty() || sales_type.getSelectionModel().getSelectedItem() == null
                    || sales_price.getText().isEmpty() || sales_name.getText().isEmpty() || sales_phone.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {

                String checkData = "Select PetId from SalesData where PetId=" + sales_petid.getText() + "";
                statement = (Statement) connection.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("is already added");
                    alert.showAndWait();
                } else {
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, sales_petid.getText());
                    prepare.setString(2, (String) sales_type.getSelectionModel().getSelectedItem());
                    prepare.setString(3, sales_price.getText());
                    prepare.setString(4, sales_name.getText());
                    prepare.setString(5, sales_phone.getText());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added");
                    alert.showAndWait();

                    SalesPetListShow();
                    SalesPetClear();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SalesPetUpdate() throws ClassNotFoundException, SQLException {

        String sql = "update SalesData set Type='" + sales_type.getSelectionModel().getSelectedItem() + "',"
                + " Price='" + sales_price.getText() + "', CustomerName='" + sales_name.getText() + "',"
                + " PhoneNo='" + sales_phone.getText() + "' where PetId= " + sales_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;
            if (sales_petid.getText().isEmpty() || sales_type.getSelectionModel().getSelectedItem() == null
                    || sales_price.getText().isEmpty() || sales_name.getText().isEmpty() || sales_phone.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to update Pet Id " + sales_petid.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = (Statement) connection.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully updated");
                    alert.showAndWait();

                    SalesPetListShow();
                    SalesPetClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void SalesPetDelete() throws ClassNotFoundException, SQLException {
        String sql = "Delete from SalesData where PetId =" + sales_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to delete Pet Id " + sales_petid.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = (Statement) connection.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();

                SalesPetListShow();
                SalesPetClear();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SalesPetSearch() {
        FilteredList<SalesData> filter = new FilteredList<>(SalesPetList, e -> true);
        sales_search.textProperty().addListener((observable, oldValue, newValue)
                -> {
            filter.setPredicate(predicateSalesData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchkey = newValue.toLowerCase();

                if (predicateSalesData.getCustomerName().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicateSalesData.getType().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicateSalesData.getPhoneNo().toLowerCase().contains(searchkey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<SalesData> sortList1 = new SortedList<>(filter);
        sortList1.comparatorProperty().bind(in_table1.comparatorProperty());
        in_table1.setItems(sortList1);

    }
    //Monthly Report
    private String[] ActionList = {"Sales", "Purchase"};
    private String[] MonthList = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGEST", "SEPTEMBER", "OCTOBAR", "NOVEMBER", "DECEMBER"};

    public ObservableList<MonthlyData> MonthlyPetListData() throws ClassNotFoundException, SQLException {
        ObservableList<MonthlyData> ListData1;
        ListData1 = FXCollections.observableArrayList();

        String sql = "select * from MonthlyData";
        connection = database.connectDb();

        try {
            prepare = connection.prepareStatement(sql);
            result = prepare.executeQuery();

            MonthlyData temp_data;

            while (result.next()) {
                temp_data = new MonthlyData(result.getInt("PetId"), result.getString("Action"),
                        result.getInt("Price"), result.getString("Date"), result.getString("Month"));

                ListData1.add(temp_data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData1;
    }

    private ObservableList<MonthlyData> MonthlyPetList;

    public void MonthlyPetListShow() throws ClassNotFoundException, SQLException {
        MonthlyPetList = MonthlyPetListData();

        report_col_petid.setCellValueFactory(new PropertyValueFactory<>("PetId"));
        report_col_action.setCellValueFactory(new PropertyValueFactory<>("Action"));
        report_col_price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        report_col_date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        report_col_month.setCellValueFactory(new PropertyValueFactory<>("Month"));

        in_table11.setItems(MonthlyPetList);
    }

    @FXML
    public void MonthlyPetActionList() {
        List<String> lists = new ArrayList();

        for (String data : ActionList) {
            lists.add(data);
        }
        ObservableList listD = FXCollections.observableArrayList(lists);
        report_action.setItems(listD);
    }

    @FXML
    public void MonthlyPetMonthList() {
        List<String> lists = new ArrayList();

        for (String data : MonthList) {
            lists.add(data);
        }
        ObservableList listD = FXCollections.observableArrayList(lists);
        report_month.setItems(listD);
    }

    @FXML
    public void MonthlyPetClear() {

        report_petid.setText("");
        report_action.getSelectionModel().clearSelection();
        report_price.setText("");
        report_date.setText("");
        report_month.getSelectionModel().clearSelection();

    }

    @FXML
    public void MonthlyPetSelect() {
        MonthlyData petD = in_table11.getSelectionModel().getSelectedItem();
        int num = in_table11.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        report_petid.setText(String.valueOf(petD.getPetId()));
        report_price.setText(String.valueOf(petD.getPrice()));
        report_date.setText(String.valueOf(petD.getDate()));
        //sales_phone.setText(String.valueOf(petD.getPhoneNo()));
    }

    @FXML
    public void MonthlypetAdd() throws ClassNotFoundException, SQLException {
        String sql = "Insert Into MonthlyData (PetId,Action,Price,Date,Month) values(?,?,?,?,?)";

        connection = database.connectDb();

        try {

            Alert alert;
            if (report_petid.getText().isEmpty() || report_action.getSelectionModel().getSelectedItem() == null
                    || report_price.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {

                String checkData = "Select PetId from MonthlyData where PetId=" + report_petid.getText() + "";
                statement = (Statement) connection.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("is already added");
                    alert.showAndWait();
                } else {
                    prepare = connection.prepareStatement(sql);
                    prepare.setString(1, report_petid.getText());
                    prepare.setString(2, (String)report_action.getSelectionModel().getSelectedItem());
                    prepare.setString(3, report_price.getText());
                    prepare.setString(4, LocalDate.now().toString());
                    prepare.setString(5, LocalDate.now().getMonth().toString());

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added");
                    alert.showAndWait();

                    MonthlyPetListShow();
                    MonthlyPetClear();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void MonthlyPetUpdate() throws ClassNotFoundException, SQLException {

        String sql = "update MonthlyData set Action='" + report_action.getSelectionModel().getSelectedItem() + "',"
                + " Price='" + report_price.getText() + "', Date='" + report_date.getText() + "',"
                + " Month='" + report_month.getSelectionModel().getSelectedItem() + "' where PetId= " + report_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;
            if (report_petid.getText().isEmpty() || report_action.getSelectionModel().getSelectedItem() == null
                    || report_price.getText().isEmpty() || report_month.getSelectionModel().getSelectedItem() == null || report_date.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill those information");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to update Pet Id " + report_petid.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = (Statement) connection.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully updated");
                    alert.showAndWait();

                    MonthlyPetListShow();
                    MonthlyPetClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void MonthlyPetDelete() throws ClassNotFoundException, SQLException {
        String sql = "Delete from  MonthlyData where PetId =" + report_petid.getText() + "";

        connection = database.connectDb();

        try {
            Alert alert;

            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure want to delete Pet Id " + report_petid.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                statement = (Statement) connection.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted");
                alert.showAndWait();

                MonthlyPetListShow();
                MonthlyPetClear();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void MonthlyPetSearch() {
        FilteredList<MonthlyData> filter = new FilteredList<>(MonthlyPetList, e -> true);
        report_search.textProperty().addListener((observable, oldValue, newValue)
                -> {
            filter.setPredicate(predicateMonthlyData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchkey = newValue.toLowerCase();

                if (predicateMonthlyData.getAction().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicateMonthlyData.getMonth().toLowerCase().contains(searchkey)) {
                    return true;
                } else if (predicateMonthlyData.getDate().toLowerCase().contains(searchkey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<MonthlyData> sortList1 = new SortedList<>(filter);
        sortList1.comparatorProperty().bind(in_table11.comparatorProperty());
        in_table11.setItems(sortList1);

    }

    private double x = 0;
    private double y = 0;

    @FXML
    public void signOut() {
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

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

    public void maximization() {
        Stage stage = (Stage) main_form.getScene().getWindow();

        stage.fullScreenProperty();
    }

}
