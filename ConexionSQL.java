package registrosql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class ConexionSQL{
    private Connection conexion;
    private Statement statement;
    private String basedatos,usuario,contra,ip,puerto;
    private ResultSet res;
    public ConexionSQL(){
        ip="localhost";
        puerto="3306";
        basedatos="registrosql";
        usuario="root";
        contra="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://"+ip+":"+puerto
                +"/"+basedatos,usuario,contra);
        }
        catch(Exception g){
            g.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Verifique la conexión al servidor",
                "(1311) ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public String darBaseDatos(){
        return basedatos;
    }
    public String darUsuario(){
        return usuario;
    }
    public String darContra(){
        return contra;
    }
    public String darIP(){
        return ip;
    }
    public String darPuerto(){
        return puerto;
    }
    public ResultSet ConsultaSelect(String sqlconsulta){
        try{
            if(!conexion.isClosed()){
                statement=conexion.createStatement();
                res=statement.executeQuery(sqlconsulta);
            }
        }catch(SQLException g){
            g.printStackTrace();
            JOptionPane.showMessageDialog(null,
               "Verifique la consulta de DB","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        finally{
            return res;
        }
    }
    public void ConsultaNoSelect(String sqlconsulta){
        try{
            if(!conexion.isClosed()){
                statement=conexion.createStatement();
                statement.executeUpdate(sqlconsulta);
            }
        }catch(SQLException g){
            g.printStackTrace();
            JOptionPane.showMessageDialog(null,
               "Verifique la consulta de DB","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public PreparedStatement darConsultaPreparada(String sqlconsulta){
        PreparedStatement st=null;
        try {
            st=conexion.prepareStatement(sqlconsulta);
        }catch(SQLException g){
            g.printStackTrace();
        }
        finally{
            return st;
        }
    }
    public void cerrarConexion(boolean owo){
        if(owo){
            try{
                conexion.close();
            }catch (SQLException g){}
        }
    }
}