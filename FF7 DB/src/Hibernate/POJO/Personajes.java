package Hibernate.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Personajes
 */
@Entity
@Table(name = "personajes")
public class Personajes implements java.io.Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "edad")
    private String edad;
    @Column(name = "ocupacion")
    private String ocupacion;
    @Column(name = "arma")
    private String arma;
    @Column(name = "fechana")
    private String fechana;
    @Column(name = "lugarna")
    private String lugarna;

    public Personajes() {
    }

    public Personajes(String nombre, String imagen, String edad, String ocupacion, String arma, String fechana, String lugarna) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.arma = arma;
        this.fechana = fechana;
        this.lugarna = lugarna;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEdad() {
        return this.edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getArma() {
        return this.arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
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
