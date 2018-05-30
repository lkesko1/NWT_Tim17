package ba.unsa.etf.nwtcinemamovies.dto;

import java.io.Serializable;

public class RMQTransferObject implements Serializable {
    private String sender;

    private String routingKey;

    private String payload;

    public RMQTransferObject(String sender, String routingKey, String payload) {
        this.sender = sender;
        this.routingKey = routingKey;
        this.payload = payload;
    }

    public String getSender() {
        return sender;
    }

    public RMQTransferObject() {
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
