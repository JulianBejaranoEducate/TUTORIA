package co.edu.ue.Dao;

import co.edu.ue.Entity.Pet;
import co.edu.ue.conexion.ConexionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDaoGood {

    private ConexionDataBase conDataBase;

    public PetDaoGood() {
        this.conDataBase = new ConexionDataBase();
    }

    public String registerPet(Pet pet) {
        String query = "INSERT INTO mascotas VALUES(null, ?, ?, ? ,?)";
        try (Connection con = conDataBase.getConexionDB(); PreparedStatement preStm = con.prepareStatement(query)) {
            byte status = 1;
            preStm.setString(1, pet.getName());
            preStm.setShort(2, pet.getAge());
            preStm.setByte(3, status);
            preStm.setByte(4, pet.getType());

            int response = preStm.executeUpdate();
            if (response > 0) {
                return "Se ha registrado la Mascota: " + pet.getName();
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e);
        }
        return "No se ha registrado la mascota";
    }

    public String updatePet(Pet pet) {
        if (!searchPetById(pet.getId())) {
            return "La mascota no existe";
        }
        String query = "UPDATE mascotas SET mas_nombre = ?, mas_edad = ?, " + "tip_id = ? WHERE mas_id = ?";
        try (Connection con = conDataBase.getConexionDB(); PreparedStatement preStm = con.prepareStatement(query)) {
            preStm.setString(1, pet.getName());
            preStm.setShort(2, pet.getAge());
            preStm.setByte(3, pet.getType());
            preStm.setByte(4, (byte) pet.getId());

            int response = preStm.executeUpdate();
            if (response > 0) {
                return "Se ha actualizado la mascota: " + pet.getName();
            }
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e);
        }
        return "No se ha registrado la mascota";
    }

    public boolean searchPetById(int id) {
        String query = "SELECT mas_id FROM mascotas WHERE mas_id = ? and mas_estatus = ?";
        try (Connection con = conDataBase.getConexionDB(); PreparedStatement preStm = con.prepareStatement(query)) {

            preStm.setInt(1, id);
            preStm.setString(2, "1");

            try (ResultSet rs = preStm.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la mascota: " + e);
        }
        return false;
    }

    public Pet searchPetByIdObj(int id) {
        String query = "SELECT mas_id FROM mascotas WHERE mas_id = ? and mas_estatus = ?";
        try (Connection con = conDataBase.getConexionDB(); PreparedStatement preStm = con.prepareStatement(query)) {

            preStm.setInt(1, id);
            preStm.setString(2, "1");
            try (ResultSet rs = preStm.executeQuery()) {
                if (rs.next()) {
                    return new Pet(
                            rs.getInt("mas_id"),
                            rs.getString("mas_nombre"),
                            rs.getShort("mas_edad"),
                            rs.getByte("mas_id"),
                            rs.getByte("tip_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la mascota: " + e);
        }
        return null;
    }

    public String deletePet(int id) {
        if (!searchPetById(id)) {
            return "La mascota no existe";
        }

        String query = "UPDATE mascotas SET mas_estatus = ? WHERE mas_id = ?";
        try (Connection con = conDataBase.getConexionDB(); PreparedStatement preStm = con.prepareStatement(query)) {

            preStm.setString(1, "0");
            preStm.setInt(2, id);

            int response = preStm.executeUpdate();
            if (response > 0) {
                return "Se ha dado de baja la mascota";
            }
        } catch (SQLException e) {
            System.out.println("Error al dar de baja: " + e);
        }
        return "No se ha dado de baja la mascota";
    }

    public List<Pet> getAllPets() {
        String query = "SELECT * FROM mascotas WHERE mas_estatus = ?";
        List<Pet> petList = new ArrayList<>();
        try (Connection con = conDataBase.getConexionDB(); PreparedStatement preStm = con.prepareStatement(query)) {

            byte status = 1;
            preStm.setByte(1, status);

            try (ResultSet rs = preStm.executeQuery()) {
                while (rs.next()) {
                    petList.add(new Pet(
                            rs.getInt("mas_id"),
                            rs.getString("mas_nombre"),
                            rs.getShort("mas_edad"),
                            rs.getByte("mas_id"),
                            rs.getByte("tip_id")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar todas las mascotas: " + e.getMessage());
        }
        return petList;
    }
}
