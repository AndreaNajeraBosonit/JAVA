package block6pathvariableheaders.model;

import java.util.List;

public class DatosEntrada {
    private String body;
    private List<String> headers;
    private List<String> requestParams;

    // Constructores, getters y setters
    public List<String> getRequestParams() {
        return requestParams;
    }
    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public void setRequestParams(List<String> requestParams) {
        this.requestParams = requestParams;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }


}



