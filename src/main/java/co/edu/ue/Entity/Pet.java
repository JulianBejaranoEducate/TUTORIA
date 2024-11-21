
package co.edu.ue.Entity;

public class Pet {
    //1. A tributps
    private int id;
    private String name;
    private Short age;
    private byte status;
    private byte type;
    //2. Constructor
    
    public Pet() {
    }
    
    public Pet(String name, Short age, byte status, byte type) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.type = type;
    }
    
    public Pet(int id, String name, Short age, byte status, byte type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
        this.type = type;
    }
    
    //Metodos de acceso

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
     
    //ToString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pet{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
    
    
}
