package Hibernate.POJO;
// Generated 20-may-2015 20:43:41 by Hibernate Tools 4.3.1



/**
 * Canciones generated by hbm2java
 */
public class Canciones  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String mp3;

    public Canciones() {
    }

    public Canciones(String nombre, String mp3) {
       this.nombre = nombre;
       this.mp3 = mp3;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMp3() {
        return this.mp3;
    }
    
    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }




}

