package Hibernate.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Personajessecundarios
 */
@Entity
@Table(name = "Personajessecundarios")
public class Personajessecundarios implements java.io.Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ocupacion")
    private String ocupacion;
    @Column(name = "fechana")
    private String fechana;
    @Column(name = "lugarna")
    private String lugarna;

    public Personajessecundarios() {
    }

    public Personajessecundarios(String nombre, String ocupacion, String fechana, String lugarna) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.fechana = fechana;
        this.lugarna = lugarna;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFechana() {
        return this.fechana;
    }

    public void setFechana(String fechana) {
        this.fechana = fechana;
    }

    public String getLugarna() {
        return this.lugarna;
    }

    public void setLugarna(String lugarna) {
        this.lugarna = lugarna;
    }

}
