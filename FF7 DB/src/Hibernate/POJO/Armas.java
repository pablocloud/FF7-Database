package Hibernate.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Armas
 */
@Entity
@Table(name = "armas")
public class Armas implements java.io.Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ataque")
    private int ataque;
    @Column(name = "golpe")
    private String golpe;
    @Column(name = "materia")
    private String materia;
    @Column(name = "materia2")
    private String materia2;
    @Column(name = "materia3")
    private String materia3;
    @Column(name = "materia4")
    private String materia4;
    @Column(name = "materia5")
    private String materia5;
    @Column(name = "materia6")
    private String materia6;
    @Column(name = "materia7")
    private String materia7;
    @Column(name = "materia8")
    private String materia8;
    @Column(name = "materia9")
    private String materia9;
    @Column(name = "localizacion")
    private String localizacion;
    @Column(name = "coste")
    private int coste;
    @Column(name = "notas")
    private String notas;
    @Column(name = "equipadopor")
    private String equipadopor;

    public Armas() {
    }

    public Armas(String nombre, int ataque, String golpe, String materia, String materia2, String materia3, String materia4, String materia5, String materia6, String materia7, String materia8, String materia9, String localizacion, int coste, String notas, String equipadopor) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.golpe = golpe;
        this.materia = materia;
        this.materia2 = materia2;
        this.materia3 = materia3;
        this.materia4 = materia4;
        this.materia5 = materia5;
        this.materia6 = materia6;
        this.materia7 = materia7;
        this.materia8 = materia8;
        this.materia9 = materia9;
        this.localizacion = localizacion;
        this.coste = coste;
        this.notas = notas;
        this.equipadopor = equipadopor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getGolpe() {
        return this.golpe;
    }

    public void setGolpe(String golpe) {
        this.golpe = golpe;
    }

    public String getMateria() {
        return this.materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getMateria2() {
        return this.materia2;
    }

    public void setMateria2(String materia2) {
        this.materia2 = materia2;
    }

    public String getMateria3() {
        return this.materia3;
    }

    public void setMateria3(String materia3) {
        this.materia3 = materia3;
    }

    public String getMateria4() {
        return this.materia4;
    }

    public void setMateria4(String materia4) {
        this.materia4 = materia4;
    }

    public String getMateria5() {
        return this.materia5;
    }

    public void setMateria5(String materia5) {
        this.materia5 = materia5;
    }

    public String getMateria6() {
        return this.materia6;
    }

    public void setMateria6(String materia6) {
        this.materia6 = materia6;
    }

    public String getMateria7() {
        return this.materia7;
    }

    public void setMateria7(String materia7) {
        this.materia7 = materia7;
    }

    public String getMateria8() {
        return this.materia8;
    }

    public void setMateria8(String materia8) {
        this.materia8 = materia8;
    }

    public String getMateria9() {
        return this.materia9;
    }

    public void setMateria9(String materia9) {
        this.materia9 = materia9;
    }

    public String getLocalizacion() {
        return this.localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getCoste() {
        return this.coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public String getNotas() {
        return this.notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getEquipadopor() {
        return this.equipadopor;
    }

    public void setEquipadopor(String equipadopor) {
        this.equipadopor = equipadopor;
    }

}
