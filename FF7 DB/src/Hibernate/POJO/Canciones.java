package Hibernate.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Canciones
 */
@Entity
@Table(name = "canciones")
public class Canciones implements java.io.Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "mp3")
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
