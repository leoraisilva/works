package main.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    private Connection connection;

    public database(){
        try{
            String url = "jdbc:sqlite:/C:/Users/leyto/OneDrive/Documentos/ProjetoTest/ListaFX/src/resource/listaFX.db";
        this.connection = DriverManager.getConnection(url);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet dadosSQL(String user, String pass){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT*FROM dadoUsuario WHERE usuario='" + user + "'AND senha='" + pass +"';";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public int tam(String table){
        int tamanho = 0;
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            String sql = "SELECT COUNT(*) FROM "+ table +";";
            resultSet = statement.executeQuery(sql);
            tamanho = resultSet.getInt(1);
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tamanho;
    }


    public Boolean nomSet(String procura, String dado, String table){
        Statement statement;
        ResultSet resultSet = null;
        Boolean valor = false;
        try{
            int id =0;
            statement = connection.createStatement();
            String sql = "SELECT "+procura+" FROM "+ table +" id = "+id+";";
            resultSet = statement.executeQuery(sql);
            for (int i = 1; i <= tam(table); i++) {
                String dadoResult = resultSet.getString(i);
                if(dadoResult.equals(dado))
                    valor = true;
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return valor;
    }

    public int addValue(String sql){
        Statement statement;
        int resultado = 0;
        try {
            statement = connection.createStatement();
            resultado = statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public ResultSet cellControl(){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM contatos;";
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;

    }

}
