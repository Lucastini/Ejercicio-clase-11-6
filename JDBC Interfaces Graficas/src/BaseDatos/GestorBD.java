

package BaseDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import negocio.Cliente;


public class GestorBD {
    private Connection con;
    private Properties propCon;
    
    public void abrirConeccion() throws SQLException{
        propCon=new Properties();
        propCon.put("useSSL", "false");
        propCon.put("allowPublicKeyRetriveal", "true");
        propCon.put("serverTimezone", "America/Argentina/Cordoba");
        propCon.put("port", "3306");
        propCon.put("user", "root");
        propCon.put("password", "1234");

        con=DriverManager.getConnection("jdbc:mysql:localhost:3306/bdcorta4", propCon);
        System.out.println("Coneccion exitosa");
        
    }
    
    public void cerrarConeccion() throws SQLException{
        con.close();
    }
    
    public void insertarRegistro(Cliente cli){
        try{
            abrirConeccion();
            PreparedStatement preStatement=con.prepareStatement("INSERT INTO Clientes (nombre,apellido,tipo,fecha_nacimiento) VALUES (?,?,?,?)");
            preStatement.setString(1, cli.getNombre());
            preStatement.setString(2, cli.getApellido());
            preStatement.setInt(3, cli.getTipo());
            preStatement.setDate(4, new Date(cli.getFechaNacimiento().getTime()));
            preStatement.executeUpdate();
            cerrarConeccion();
        }catch(SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
       
    
}
