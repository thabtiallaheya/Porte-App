package epsi.mspr.maintenance.based.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Res {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String uniqueId;

    @Column
    private boolean ouvert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Res() {
    }

    public Res(String uniqueId, boolean ouvert) {
        this.uniqueId = uniqueId;
        this.ouvert = ouvert;
    }

    @XmlElement(name = "UniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @XmlElement(name = "Ouvert")
    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    @Override
    public String toString() {
        return "Res{" +
                "id=" + id +
                ", uniqueId='" + uniqueId + '\'' +
                ", ouvert=" + ouvert +
                '}';
    }


}
