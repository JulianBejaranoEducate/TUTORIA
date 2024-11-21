/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ue.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDataBase {

    //1. Declaracion de atrbutos
    private String user;//Encapsulamiento
    private String pwd;
    private String dataBase;
    private String port;
    private String server;
    private String cad;//Cadena de oneció
    //Objeto para conectar
    private Connection con;

    //2. Constructores
    public ConexionDataBase() {
        this.user = "root";
        this.pwd = "";
        this.dataBase = "pets";
        this.port = "3306";
        this.server = "localhost";
        this.cad = "jdbc:mysql://" + this.server + ":" + this.port + "/" + this.dataBase;
    }

    //3. MétodoOrden-> para conectar la bae de datos
    private Connection conexionDB() {
        // Manejo de excepcions
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.cad, this.user, this.pwd);

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            System.out.println("\nHay conexión");
        }
        return this.con;
    }

    public Connection getConnectionDB() {
        return this.conexionDB();
    }
}
