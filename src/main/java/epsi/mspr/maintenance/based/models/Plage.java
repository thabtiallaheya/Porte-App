package epsi.mspr.maintenance.based.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Plage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String jour;

    @Column
    private String horaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plage() {
    }

    public Plage(String jour, String horaire) {
        this.jour = jour;
        this.horaire = horaire;
    }

    @XmlElement(name = "Jour")
    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    @XmlElement(name = "Horaire")
    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    @Override
    public String toString() {
        return "Plage{" +
                "id=" + id +
                ", jour='" + jour + '\'' +
                ", horaire='" + horaire + '\'' +
                '}';
    }
}
