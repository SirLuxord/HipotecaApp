package dad.hipoteca.ui;

import dad.hipoteca.api.HipotecaApi;
import dad.hipoteca.api.SearchResultHipoteca;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // Logic

    private final HipotecaApi hipotecaApi = new HipotecaApi();

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

    }

    @FXML
    private TextField capitalTextField;

    @FXML
    private TableColumn<?, ?> feeColumn;

    @FXML
    private TableColumn<?, ?> initialCapitalColumn;

    @FXML
    private TableColumn<?, ?> interestColumn;

    @FXML
    private TextField interestTextField;

    @FXML
    private TableColumn<?, ?> monthColumn;

    @FXML
    private TableView<?> mortgageTable;

    @FXML
    private TableColumn<?, ?> numberColumn;

    @FXML
    private TableColumn<?, ?> paidCapitalColumn;

    @FXML
    private BorderPane root;

    @FXML
    private TableColumn<?, ?> unpaidCapitalColumn;

    @FXML
    private TableColumn<?, ?> yearColumn;

    @FXML
    private TextField yearTextField;

    @FXML
    void onCalculate(ActionEvent event) {

    }

    public BorderPane getRoot() {
        return root;
    }
}
