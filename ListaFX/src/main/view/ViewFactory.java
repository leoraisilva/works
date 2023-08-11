package main.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private ObjectProperty<ClientView> objectProperty;
    private ObjectProperty<String> objectModelProperty;
    private AnchorPane AdicionarView;
    private AnchorPane RemoverView;
    private AnchorPane PerfilView;
    private AnchorPane ListaTellView;

    public ViewFactory (){
        this.objectProperty = new SimpleObjectProperty<>();
        this.objectModelProperty = new SimpleObjectProperty<>();
    }
    
    public AnchorPane getAdicionarView(){
        if(AdicionarView==null){
            try {
                AdicionarView = new FXMLLoader(getClass().getResource("/resource/FXML/adicionar.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return AdicionarView;
    }

    public AnchorPane getRemoverView(){
        if(RemoverView==null){
            try {
                RemoverView = new FXMLLoader(getClass().getResource("/resource/FXML/remover.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return RemoverView;
    }

    public AnchorPane getPerfilView(){
        if(PerfilView==null){
            try {
                PerfilView = new FXMLLoader(getClass().getResource("/resource/FXML/perfil.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return PerfilView;
    }

    public AnchorPane getListaTellView(){
        if(ListaTellView==null){
            try {
                ListaTellView = new FXMLLoader(getClass().getResource("/resource/FXML/listaTell.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ListaTellView;
    }

    public ObjectProperty<ClientView> getObjectProperty() {
        return objectProperty;
    }

    public ObjectProperty<String> getObjectModelProperty() {
        return objectModelProperty;
    }

    public void getWindow(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("ListaFX");
        stage.getIcons().add(new Image("/resource/image/icon.png"));
        stage.setResizable(false);
        stage.show();
    }

    public void showSingupWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/FXML/loginCadastro.fxml"));
        getWindow(loader);
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/FXML/login.fxml"));
        getWindow(loader);
    }

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/FXML/client.fxml"));
        getWindow(loader);
    }

    public void getClose(Stage stage){
        stage.close();
    }
    
}
