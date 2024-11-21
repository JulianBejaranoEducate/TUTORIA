
package co.edu.ue.tutoria;

import co.edu.ue.conexion.ConexionDataBase;

public class TUTORIA {

   public static void main(String[] args) {
        ConexionDataBase conDB = new ConexionDataBase();
        conDB.getConnectionDB();
    }
}
