package main.Control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.model.Model;
import main.model.usuarioModel;


public class usuarioControl implements Initializable {
    private usuarioModel dados;
    @FXML
    public Label userLabel;
    @FXML
    public Label dateLabel;

    public String mes(int num){
        String mes = "";
        switch(num){
            case 1:
                mes = "Janeiro";
                break;
            case 2:
                mes = "Fevereiro";
                break;
            case 3:
                mes = "Março";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Maio";
                break;
            case 6:
                mes = "Junho";
                break;
            case 7:
                mes = "Julho";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Setembro";
                break;
            case 10:
                mes = "Outubro";
                break;
            case 11:
                mes = "Novembro";
                break;
            case 12:
                mes = "Dezembro";
                break;
        }
        return mes;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dados = Model.getInstance().getDadosUsuario();
        userLabel.setText("Ola, " + dados.getNome().getValue());

        LocalDate date = LocalDate.now();
        int ano = date.getYear();
        int mes = date.getMonthValue();
        int dia = date.getDayOfMonth();

        String data = "Hoje, " + dia + " de " + mes(mes) + " de " + ano;
        dateLabel.setText(data);
        
    }
    
}
