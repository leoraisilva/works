package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class cellContatoModel {
    private final StringProperty nomeContato;
    private final StringProperty tellContato;
    private final StringProperty wspContato;
    private final StringProperty telgContato;

    public cellContatoModel(String nomeContato, String tellContato, String wspContato, String telgContato){
        this.nomeContato = new SimpleStringProperty(this, "nomeContato", nomeContato);
        this.tellContato = new SimpleStringProperty(this, "tellContato", tellContato);
        this.wspContato = new SimpleStringProperty(this, "wspContato", wspContato);
        this.telgContato = new SimpleStringProperty(this, "telgContato", telgContato);
    }

    public StringProperty getNomeContato() {
        return nomeContato;
    }
    public StringProperty getTelgContato() {
        return telgContato;
    }
    public StringProperty getTellContato() {
        return tellContato;
    }
    public StringProperty getWspContato() {
        return wspContato;
    }
}
