package main.Control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.model.cellContatoModel;

public class cellContatoControl implements Initializable {
    @FXML
    public Label usuario;
    @FXML
    public Label tell;
    @FXML
    public Label wsp;
    @FXML
    public Label telm;

    private final cellContatoModel cellContato;

    public cellContatoControl(cellContatoModel cellContato){
        this.cellContato = cellContato;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usuario.textProperty().bind(cellContato.getNomeContato());
        tell.textProperty().bind(cellContato.getTellContato());
        telm.textProperty().bind(cellContato.getTelgContato());
        wsp.textProperty().bind(cellContato.getWspContato());
    }
    
}
