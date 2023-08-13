package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;
import main.model.Model;
import main.model.cellContatoModel;
import main.view.cellView;

public class listaTell implements Initializable {
    @FXML
    public ListView<cellContatoModel> listaView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        listaView.setItems(Model.getInstance().getLista());
        listaView.setCellFactory(e -> new cellView());
    }
    
    public void init(){
        if(Model.getInstance().getLista().isEmpty()){
            Model.getInstance().setLista();
        }
    }
    
}
