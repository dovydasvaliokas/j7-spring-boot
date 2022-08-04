package lt.viltiesziedas.receptai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredientas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String pavadinimas;
    double kaina;
    int kalorijosPer100g;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "recepto_ingredientai",
            joinColumns = @JoinColumn(name = "ingrediento_id"),
            inverseJoinColumns = @JoinColumn(name = "recepto_id")
    )
    Set<Receptas> receptaiKuriuoseYraSitasIngredientas;

    public Ingredientas() {
    }

    public Ingredientas(int id, String pavadinimas, double kaina, int kalorijosPer100g, Set<Receptas> receptaiKuriuoseYraSitasIngredientas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.kalorijosPer100g = kalorijosPer100g;
        this.receptaiKuriuoseYraSitasIngredientas = receptaiKuriuoseYraSitasIngredientas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public int getKalorijosPer100g() {
        return kalorijosPer100g;
    }

    public void setKalorijosPer100g(int kalorijosPer100g) {
        this.kalorijosPer100g = kalorijosPer100g;
    }

    public Set<Receptas> getReceptaiKuriuoseYraSitasIngredientas() {
        return receptaiKuriuoseYraSitasIngredientas;
    }

    public void setReceptaiKuriuoseYraSitasIngredientas(Set<Receptas> receptaiKuriuoseYraSitasIngredientas) {
        this.receptaiKuriuoseYraSitasIngredientas = receptaiKuriuoseYraSitasIngredientas;
    }

    @Override
    public String toString() {
        return "Ingredientas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kaina=" + kaina +
                ", kalorijosPer100g=" + kalorijosPer100g +
                '}';
    }
}
