package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class usuarioModel {
    private final StringProperty nome;
    private final StringProperty usuario;
    private final StringProperty tell;
    private final StringProperty telegram;
    private final StringProperty whatsapp;


    public usuarioModel(String nome, String usuario, String tell, String telegram, String whatsapp){
        this.nome = new SimpleStringProperty(this, "nome", nome);
        this.usuario = new SimpleStringProperty(this, "usuario", usuario);
        this.tell = new SimpleStringProperty(this, "tell", tell);
        this.telegram = new SimpleStringProperty(this, "telegram", telegram);
        this.whatsapp = new SimpleStringProperty(this, "whatsapp", whatsapp);
    }

    public StringProperty getNome() {
        return nome;
    }
    public StringProperty getUsuario() {
        return usuario;
    }
    public StringProperty getTell() {
        return tell;
    }

    public StringProperty getTelegram() {
        return telegram;
    }

    public StringProperty getWhatsapp() {
        return whatsapp;
    }

}
