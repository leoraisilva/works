package main.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.view.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory view;
    private final database dbase;
    private boolean fragResult;
    private usuarioModel dadosUsuario;


    public Model(){
        this.view = new ViewFactory();
        this.dbase = new database();
        this.fragResult = false;
        this.dadosUsuario = new usuarioModel("", "", "", "", "");
    }

    public static synchronized Model getInstance(){
        if(model==null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getView(){
        return this.view;
    }

    public database getDbase() {
        return dbase;
    }

    public boolean getFlag(){
        return fragResult;
    }
    public void setFrag(boolean flag){
        this.fragResult = flag;
    }

    public void setDadosUsuario(usuarioModel dadosUsuario) {
        this.dadosUsuario = dadosUsuario;
    }
    public usuarioModel getDadosUsuario() {
        return dadosUsuario;
    }

    public void returnValue (String user, String pass){
        ResultSet resultSet = dbase.dadosSQL(user, pass);
        try {
            if(resultSet.isBeforeFirst()){
                this.dadosUsuario.getNome().set(resultSet.getString("nome"));
                this.dadosUsuario.getTell().set(resultSet.getString("tell"));
                this.dadosUsuario.getTelegram().set(resultSet.getString("telegram"));
                this.dadosUsuario.getWhatsapp().set(resultSet.getString("whatsapp"));
                this.fragResult = true;
            }
            resultSet.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    
    public int cadastroContato(String nome, String tell, String whatsapp, String telegram){
            String sql = "INSERT INTO contatos (nome, tell, whatsapp, telegram) VALUES ('"+nome+"', '"+tell+"', '"+whatsapp+"', '"+telegram+"');";
            int valordb = dbase.addValue(sql);
            return valordb;
    }

    public int cadastroValue(String nome, String usuario, String senha, String tell, String telegram, String whatsapp){
        String addValue = "INSERT INTO dadoUsuario (nome, usuario, senha, tell, telegram, whatsapp) VALUES ('" + nome + "', '"+ usuario + "', '"+ senha + "', '"+ tell + "', '"+ telegram + "', '"+ whatsapp +"' );";
        int result = dbase.addValue(addValue);
        return result;
    }

}
