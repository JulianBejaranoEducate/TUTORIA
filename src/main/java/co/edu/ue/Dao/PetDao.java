package co.edu.ue.Dao;

import co.edu.ue.Entity.Pet;
import co.edu.ue.conexion.ConexionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PetDao {

    //1. Declaración de atributos 
    private ConexionDataBase conDataBase;
    private PreparedStatement preStm;

    //2. Métodos constructores
    public PetDao() {
        conDataBase = new ConexionDataBase();
        this.preStm = null;
    }

    public String registerPet(Pet pet) {
        Connection con = this.conDataBase.getConnectionDB();
        String query = "INSERT INTO mascotas VALUES (null, ?,?,?,?)";
        //insercion
        try { //Manejo de excepciones
            if (this.preStm == null) {
                byte status = 1;
                this.preStm = con.prepareStatement(query);
                //                   posicion , de donde vienen los datos.get...
                this.preStm.setString(1, pet.getName());
                this.preStm.setShort(2, pet.getAge());
                this.preStm.setByte(3, status);
                this.preStm.setByte(4, pet.getType());
                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    return "Se ha registrado la mascota:" + pet.getName();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar" + e);
            return "No se ha registardo la mascota";
        } catch (Exception e) {
            System.out.println("Error al insertar" + e);
            return "No se ha registrado la mascota";
        }
        return "Error al registrar la mascota";
    }

    public String updatePet(Pet pet) {
        Connection con = this.conDataBase.getConnectionDB();
        String query = "UPDATE mascotas SET mas_nombre=?, mas_edad=?, tip_id=? WHERE mas_id=?";
        try { //Manejo de excepciones
            if (this.preStm == null) {
                byte status = 1;
                this.preStm = con.prepareStatement(query);
                //                   posicion , de donde vienen los datos.get...
                this.preStm.setString(1, pet.getName());
                this.preStm.setShort(2, pet.getAge());
                this.preStm.setByte(3, status);
                this.preStm.setByte(4, pet.getType());
                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    return "Exito al actualizar:" + pet.getName();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar" + e);
            return "No se ha actualizado la mascota";
        } catch (Exception e) {
            System.out.println("Error al actualizar la mascota" + e);
            return "Error al actualizar la mascota";
        }
        return "";
    }

    //Para corroborar la existencia de la mascota
    public boolean searchPetById(int id) {
        Connection con = this.conDataBase.getConnectionDB();
        String query = "SELECT mas_id from mascotas WHERE mas_id = ?";
        String response = query;
      
        return false;
    }
}
