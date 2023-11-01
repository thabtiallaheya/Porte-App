package epsi.mspr.maintenance.based.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institution() {
    }

    public Institution(String code) {
        this.code = code;
    }

    @XmlElement(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "code='" + code + '\'' +
                '}';
    }
}
