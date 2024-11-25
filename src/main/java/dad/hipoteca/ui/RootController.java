package dad.hipoteca.ui;

import dad.hipoteca.api.HipotecaApi;
import dad.hipoteca.api.ResultHipoteca;
import dad.hipoteca.model.CuotaInicial;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // Logic

    private final HipotecaApi hipotecaApi = new HipotecaApi();
    private DoubleProperty capital = new SimpleDoubleProperty();
    private DoubleProperty interes = new SimpleDoubleProperty();
    private DoubleProperty anyo = new SimpleDoubleProperty();
    private ListProperty<CuotaInicial> cuotasIniciales = new SimpleListProperty<>(FXCollections.observableArrayList());


    // Model


    private final ListProperty<CuotaInicial> cuotas = new SimpleListProperty<>(FXCollections.observableArrayList());

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Binds de las celdas

        numberColumn.setCellValueFactory(v -> v.getValue().numeroProperty());
        yearColumn.setCellValueFactory(v -> v.getValue().anyoProperty());
        monthColumn.setCellValueFactory(v -> v.getValue().mesProperty());
        initialCapitalColumn.setCellValueFactory(v -> v.getValue().capitalInicialProperty());
        interestColumn.setCellValueFactory(v -> v.getValue().interesesProperty());
        paidCapitalColumn.setCellValueFactory(v -> v.getValue().capitalAmortizadoProperty());
        feeColumn.setCellValueFactory(v -> v.getValue().cuotaProperty());
        unpaidCapitalColumn.setCellValueFactory(v -> v.getValue().capitalPendienteProperty());


        // Bindings de los textfield

        capitalTextField.textProperty().bindBidirectional(capital, new NumberStringConverter());
        interestTextField.textProperty().bindBidirectional(interes, new NumberStringConverter());
        yearTextField.textProperty().bindBidirectional(anyo, new NumberStringConverter());

        mortgageTable.itemsProperty().bind(cuotasIniciales);

    }

    @FXML
    private TextField capitalTextField;

    @FXML
    private TableColumn<CuotaInicial, Number> feeColumn;

    @FXML
    private TableColumn<CuotaInicial, Number> initialCapitalColumn;

    @FXML
    private TableColumn<CuotaInicial, Number> interestColumn;

    @FXML
    private TextField interestTextField;

    @FXML
    private TableColumn<CuotaInicial, Number> monthColumn;

    @FXML
    private TableView<CuotaInicial> mortgageTable;

    @FXML
    private TableColumn<CuotaInicial, Number> numberColumn;

    @FXML
    private TableColumn<CuotaInicial, Number> paidCapitalColumn;

    @FXML
    private BorderPane root;

    @FXML
    private TableColumn<CuotaInicial, Number> unpaidCapitalColumn;

    @FXML
    private TableColumn<CuotaInicial, Number> yearColumn;

    @FXML
    private TextField yearTextField;

    @FXML
    void onCalculate(ActionEvent event) {
        try {

            ResultHipoteca result = hipotecaApi.getCuotas(capital.get(), interes.get(), anyo.get());

            List<CuotaInicial> cuotas = result.getCuotas().stream()
                    .map(cuota -> new CuotaInicial(cuota))
                    .toList();

            this.cuotasIniciales.setAll(cuotas);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public BorderPane getRoot() {
        return root;
    }
}
