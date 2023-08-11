package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.model.Model;
import main.view.ClientView;

public class menuControl implements Initializable {
    @FXML
    public Label erroLabel;
    @FXML
    public Button perfilButton;
    @FXML
    public Button logoutButton;
    @FXML
    public Button listaTellButton;
    @FXML
    public Button adicionarButton;
    @FXML
    public Button RemoverButton;
    @FXML
    public TextArea reportArea;
    @FXML
    public Button reportButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addListener();
    }
    
    public void addListener(){
        perfilButton.setOnAction(event -> onPerfil());
        listaTellButton.setOnAction(event -> onListaTell());
        adicionarButton.setOnAction(event -> onAdicionar());
        RemoverButton.setOnAction(event -> onRemover());
        logoutButton.setOnAction(event -> onLogout());
    }

    public void onPerfil(){
        Model.getInstance().getView().getObjectProperty().set(ClientView.Perfil);
    }

    public void onAdicionar(){
        Model.getInstance().getView().getObjectProperty().set(ClientView.Adicionar);
    }
    
    public void onListaTell(){
        Model.getInstance().getView().getObjectProperty().set(ClientView.ListaTell);
    }

    public void onRemover(){
        Model.getInstance().getView().getObjectProperty().set(ClientView.Remover);
    }

    public void onLogout(){
        Stage Stage = (Stage) erroLabel.getScene().getWindow();
        Model.getInstance().getView().showLoginWindow();
        Model.getInstance().getView().getClose(Stage);
    }
    
}
