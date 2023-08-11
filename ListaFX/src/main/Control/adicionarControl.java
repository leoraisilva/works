package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.model.Model;
import main.model.database;

public class adicionarControl implements Initializable {
    private database dbase = new database();
    @FXML
    public TextField newContatoField;
    @FXML
    public TextField newTellField;
    @FXML
    public TextField newTmgField;
    @FXML
    public TextField newWspField;
    @FXML
    public Button addButton;
    @FXML
    public Label falhaContato;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnAction(event -> onContact());
    }
    public void onContact(){
        int valor = Model.getInstance().cadastroContato(newContatoField.getText(), newTellField.getText(), newWspField.getText(), newTmgField.getText());
        valueCadastro(valor);

    }
    public void valueCadastro(int valor){
        if(valor == 1){
            falhaContato.setText("Cadastrado com Sucesso");
        }
        else{
            falhaContato.setText("Cadastro Invalido");
        }
        newContatoField.setText("");
        newTellField.setText("");
        newTmgField.setText("");
        newWspField.setText("");
    }
    
}
