package epsi.mspr.maintenance.based.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Req request;

    @ManyToOne
    @JoinColumn(name = "response_id")
    private Res response;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document() {
    }

    public Document(String url, Req request, Res response) {
        this.url = url;
        this.request = request;
        this.response = response;
    }

    @XmlAttribute(name = "xmlns:xsi")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(name = "Req")
    public Req getRequest() {
        return request;
    }

    public void setRequest(Req request) {
        this.request = request;
    }

    @XmlElement(name = "Res")
    public Res getResponse() {
        return response;
    }

    public void setResponse(Res response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", request=" + request +
                ", response=" + response +
                '}';
    }
}
