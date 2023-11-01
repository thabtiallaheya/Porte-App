package epsi.mspr.maintenance.based.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Req {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String uniqueId;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "plage_id")
    private Plage plage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Req() {
    }

    public Req(String uniqueId, Institution institution, Plage plage) {
        this.uniqueId = uniqueId;
        this.institution = institution;
        this.plage = plage;
    }

    @XmlElement(name = "UniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @XmlElement(name = "Institution")
    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @XmlElement(name = "Plage")
    public Plage getPlage() {
        return plage;
    }

    public void setPlage(Plage plage) {
        this.plage = plage;
    }

    @Override
    public String toString() {
        return "Req{" +
                "id=" + id +
                ", uniqueId='" + uniqueId + '\'' +
                ", institution=" + institution +
                ", plage=" + plage +
                '}';
    }
}
