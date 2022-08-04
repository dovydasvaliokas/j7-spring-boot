package lt.viltiesziedas.receptai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Receptas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String pavadinimas;
    @Column(length = 3000, name = "recepto_nurodymai")
    String nurodymai;
    double kaina;
    int kalorijosPer100g;

    @ManyToMany
    @JoinTable(
            name = "recepto_ingredientai",
            joinColumns = @JoinColumn(name = "recepto_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediento_id")
    )
    Set<Ingredientas> receptoIngredientai;

    @ManyToOne
    @JoinColumn(name = "vartotojo_id")
    Vartotojas receptoKurejas;

    public Receptas() {
    }

    public Receptas(int id, String pavadinimas, String nurodymai, double kaina, int kalorijosPer100g, Set<Ingredientas> receptoIngredientai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.nurodymai = nurodymai;
        this.kaina = kaina;
        this.kalorijosPer100g = kalorijosPer100g;
        this.receptoIngredientai = receptoIngredientai;
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

    public String getNurodymai() {
        return nurodymai;
    }

    public void setNurodymai(String nurodymai) {
        this.nurodymai = nurodymai;
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

    public Set<Ingredientas> getReceptoIngredientai() {
        return receptoIngredientai;
    }

    public void setReceptoIngredientai(Set<Ingredientas> receptoIngredientai) {
        this.receptoIngredientai = receptoIngredientai;
    }

    @Override
    public String toString() {
        return "Receptas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", nurodymai='" + nurodymai + '\'' +
                ", kaina=" + kaina +
                ", kalorijosPer100g=" + kalorijosPer100g +
                '}';
    }
}
