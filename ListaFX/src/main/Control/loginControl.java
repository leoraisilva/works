package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.model.Model;

public class loginControl implements Initializable {
    @FXML
    public TextField userField;
    @FXML
    public TextField passField;
    @FXML
    public Button loginButton;
    @FXML
    public Button signupButton;
    @FXML
    public Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(event -> onAction());
        signupButton.setOnAction(event -> onCadastro());
    }

    public void onAction(){
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        Model.getInstance().returnValue(userField.getText(), passField.getText());
        if(Model.getInstance().getFlag()){
            Model.getInstance().getView().showClientWindow();
            Model.getInstance().getView().getClose(stage);

        }
        else {
            userField.setText("");
            passField.setText("");
            errorLabel.setText("Erro de usuario");
        }

    }
    
    public void onCadastro() {
        Model.getInstance().getView().showSingupWindow(); 
    }
}
