package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import main.model.Model;

public class dashboardControl implements Initializable {
    @FXML
    public BorderPane dashPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getView().getObjectProperty().addListener((observable, oldVal, newVal)->{
            switch(newVal){
                case Perfil -> dashPane.setCenter(Model.getInstance().getView().getPerfilView());
                case ListaTell -> dashPane.setCenter(Model.getInstance().getView().getListaTellView());
                case Adicionar -> dashPane.setCenter(Model.getInstance().getView().getAdicionarView());
                case Remover -> dashPane.setCenter(Model.getInstance().getView().getRemoverView());
            }
        });
    }
    
}
