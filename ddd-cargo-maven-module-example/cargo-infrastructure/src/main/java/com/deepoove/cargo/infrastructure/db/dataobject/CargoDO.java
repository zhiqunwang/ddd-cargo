package com.deepoove.cargo.infrastructure.db.dataobject;

public class CargoDO {

    private String id;
    private String senderPhone;
    private String description;
    private String originLocationCode;
    private String destinationLocationCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

}
