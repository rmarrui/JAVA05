/* Acesso a la base de datos:
 * - Con recorrido lineal -> nex()
 * - Con Statemen de s�lo lectura -> createStatement() (sin p�rametros. Opciones por defecto.
 * - Actualizaciones, Borrados, e inserciones directas a la BDs y no al ResulSet.
 */

package controlador;
import java.sql.*;
import javax.swing.JOptionPane;

public class AccesoA {
  public static void conectarBD() {
    try {
      // en Servidor remoto Connection con = DriverManager.getConnection("jdbc:oracle:thin:@server:1521:infor","banquero","banquero");
      Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/empresa","empresa","empresa");
      //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","banquero","banquero");
      //Connection con = DriverManager.getConnection("jdbc:odbc:DB","","");
      System.out.println("Conectado");
      JOptionPane.showMessageDialog(null, "Conectada la Base de Datos");
      
      /* 
         Con esta versi�n, sin par�metros, del m�todo createStatement(), creamos un objeto Statement
         que producur� un ResultSet que s�lo se puede recorrer hacia delante con next()
       */
      Statement stmt = con.createStatement();
      //stmt.execute("Update..."); //SI QUIERES AÑADIR UNA NUEVA FILA A LA LISTA
      ResultSet rs = stmt.executeQuery("SELECT * FROM empleado");
      ResultSetMetaData rsmd = rs.getMetaData();
      int numCols = rsmd.getColumnCount();

      while (rs.next()) {
        for (int i = 1; i <= numCols; i++) {
            //String nombre = rs.getString(i) + "Nombre"); //con cada columna de la tabla. Si sigue fallando cambiar quitando el for y solo dejar el while
            //System.out.printf("%s - ", nombre); //para ir imprimiendo esas variables guardadas
          System.out.print(rs.getString(i) + " ");      
          /*    String id = rs.getString("ID"); //EJEMPLO DE COMO SERIA
                String usr = rs.getString("USERNAME");
                String psw = rs.getString("PASSWORD");
                String nombre = rs.getString("NOMBRE");
                System.out.println("userid : " + id);
                System.out.println("usr : " + usr);
                System.out.println("psw : " + psw);
                System.out.println("nombre : " + nombre);*/
        }
        System.out.println("");
      }
        
      /*int count = stmt.executeUpdate("INSERT INTO  " +
                                            "VALUES (1031,'Andrés','PEREZ','default.jpg',2500,3000,'10/17/2021')");
      System.out.print("Insetadas: " + count + "filas");*/
      
      rs.close();
      stmt.close();
      con.close();

          
    }
    catch (Exception e) {
      System.out.println(e);
    } 
  }
}
/*
String datebaseURL = "jdbc:derby://localhost:1527/empresa";
Connection connect = DriverManager.getConnection(datebaseURL);

String sql = "SELECT * FROM empresa";

Statement stat = connect.createStatement();
ResultSet result = stat.executeQuery(sql);

while (rs.next()
{
    String nombre = rs.getString(i) + "Nombre");

    System.out.printf("%s - ", nombre);
}

connect.close;
*/