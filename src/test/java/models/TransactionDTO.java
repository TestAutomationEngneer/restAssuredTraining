package models;

public class TransactionDTO {
    private String type;
    private String transactionID;
    private String description;
    private String cardNetwork;
    private String cardDetails;
    private String tokenizationDatatype;
    private String token;

    public TransactionDTO(String type, String transactionID, String description, String cardNetwork, String cardDetails, String tokenizationDatatype, String token) {
        this.type = type;
        this.transactionID = transactionID;
        this.description = description;
        this.cardNetwork = cardNetwork;
        this.cardDetails = cardDetails;
        this.tokenizationDatatype = tokenizationDatatype;
        this.token = token;
    }

    public TransactionDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCardNetwork() {
        return cardNetwork;
    }

    public void setCardNetwork(String cardNetwork) {
        this.cardNetwork = cardNetwork;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public String getTokenizationDatatype() {
        return tokenizationDatatype;
    }

    public void setTokenizationDatatype(String tokenizationDatatype) {
        this.tokenizationDatatype = tokenizationDatatype;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
