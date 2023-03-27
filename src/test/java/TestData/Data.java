package TestData;

public class Data {
    private int port;
    private String baseURI;
    private String astanabaseURI;
    private String astanabasePath;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAstanabaseURI() {
        return astanabaseURI;
    }

    public void setAstanabaseURI(String astanabaseURI) {
        this.astanabaseURI = astanabaseURI;
    }

    public String getAstanabasePath() {
        return astanabasePath;
    }

    public void setAstanabasePath(String astanabasePath) {
        this.astanabasePath = astanabasePath;
    }

    private String basePath;
    private int statusCode;
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getBaseURI() {
        return baseURI;
    }
    public void setBaseURI(String baseURI) {
        this.baseURI = baseURI;
    }
    public String getBasePath() {
        return basePath;
    }
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
