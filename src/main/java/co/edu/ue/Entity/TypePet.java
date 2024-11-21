
package co.edu.ue.Entity;

public class TypePet {
    //1.Atributos
    private int idType;
    private String descripcion;
    //2. constructores

    public TypePet() {
    }
    //3 metodos de acceso 

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //ToString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypePet{");
        sb.append("idType=").append(idType);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }
    
    
}
