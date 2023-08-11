package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import main.model.Model;

public class loginCadastroControl implements Initializable{
    private int correto = 3;
    @FXML
    public TextField nomeField;
    @FXML
    public TextField userField;
    @FXML
    public PasswordField passField;
    @FXML
    public PasswordField passConfField;
    @FXML
    public TextField tellField;
    @FXML
    public TextField telegramField;
    @FXML
    public TextField whatsappField;
    @FXML
    public Label erroDadoLabel;
    @FXML
    public RadioButton buttonSTm;
    @FXML
    public RadioButton buttonNTm;
    @FXML
    public RadioButton buttonSWapp;
    @FXML
    public RadioButton buttonNWapp;
    @FXML
    public Button cadastroButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonSTm.setOnAction(event -> telegramField.setDisable(true));
        buttonNTm.setOnAction(event -> telegramField.setDisable(false));
        buttonSWapp.setOnAction(event -> whatsappField.setDisable(true));
        buttonNWapp.setOnAction(event -> whatsappField.setDisable(false));
        cadastroButton.setOnAction(event -> onCadastro());
    }


    private void onCadastro(){
        if(validador()==3){
            int valor = Model.getInstance().cadastroValue(nomeField.getText(), userField.getText(), passField.getText(), tellField.getText(), telegramField.getText(), whatsappField.getText());
            valueCadastro(valor);
        }
        else{
            nomeField.setText("");
            userField.setText("");
            passField.setText("");
            passConfField.setText("");
            tellField.setText("");
            telegramField.setText("");
            if(buttonSTm.isSelected()){
                buttonSTm.setSelected(false);
            }
            else{
                buttonNTm.setSelected(false);
            }
            whatsappField.setText("");
            if(buttonSWapp.isSelected()){
                buttonSWapp.setSelected(false);
            }
            else{
                buttonNWapp.setSelected(false);
            }
        }

    }

    private int validador(){
        
        if(!userField.getText().trim().isEmpty()){
            if(Model.getInstance().getDbase().nomSet("usuario", userField.getText(), "dadoUsuario")){
                erroDadoLabel.setText("Usuario já existe");
                correto --;
            }
        }
        if(!passField.getText().equals(passConfField.getText())){
            erroDadoLabel.setText("Senhas não correspondem");
            correto--;
        }
        if(tellField.getText().trim().isEmpty()){
            erroDadoLabel.setText("Falta Tell");
            correto--;
        }
        if(buttonSTm.isSelected()){
            telegramField.setText(tellField.getText());
        }
        if(buttonSWapp.isSelected()){
            whatsappField.setText(tellField.getText());
        }
        return correto;
    }

    private void valueCadastro(int valor){
        if(valor == 1){
            erroDadoLabel.setText("Cadastrado com Sucesso");
        }
        else{
            erroDadoLabel.setText("Cadastro Invalido");
        }
        nomeField.setText("");
        userField.setText("");
        passField.setText("");
        passConfField.setText("");
        tellField.setText("");
        telegramField.setText("");
        if(buttonSTm.isSelected()){
            buttonSTm.setSelected(false);
        }
        else{
            buttonNTm.setSelected(false);
        }
        whatsappField.setText("");
        if(buttonSWapp.isSelected()){
            buttonSWapp.setSelected(false);
        }
        else{
            buttonNWapp.setSelected(false);
        }
    }
}