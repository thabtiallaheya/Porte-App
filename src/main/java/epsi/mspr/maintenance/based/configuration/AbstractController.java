package epsi.mspr.maintenance.based.configuration;


import org.springframework.http.HttpHeaders;

public class AbstractController<T> {

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        return headers;
    }
}
