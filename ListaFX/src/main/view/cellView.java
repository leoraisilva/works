package main.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import main.Control.cellContatoControl;
import main.model.cellContatoModel;

public class cellView extends ListCell<cellContatoModel> {

    @Override
    public void updateItem(cellContatoModel cellContato, boolean empty){
        super.updateItem(cellContato, empty);
        
        if(empty){
            setText(null);
            setGraphic(null);
        }
        else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/FXML/cellContato.fxml"));
                cellContatoControl controller = new cellContatoControl(cellContato);
                loader.setController(controller);
                setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}
