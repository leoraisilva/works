package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import main.model.Model;
import main.model.cellContatoModel;

public class perfilControl implements Initializable{
    @FXML
    public Label nomePerfil;
    @FXML
    public Label tellPerfil;
    @FXML
    public Label contatoPerfil;
    @FXML
    public Label telegramPerfil;
    @FXML
    public Label whatsappPerfil;
    @FXML
    public ListView<cellContatoModel> listaEvento;
    @FXML
    public TextArea areaCadastro;
    @FXML
    public Button cadastroButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomePerfil.setText(Model.getInstance().getDadosUsuario().getNome().getValue());
        tellPerfil.setText(Model.getInstance().getDadosUsuario().getTell().getValue());
        telegramPerfil.setText(Model.getInstance().getDadosUsuario().getTelegram().getValue());
        whatsappPerfil.setText(Model.getInstance().getDadosUsuario().getWhatsapp().getValue());
    }
    
}
