package ba.unsa.etf.nwtcinemareservations.dto;

import java.io.Serializable;

public class RMQTransferObject implements Serializable {
    private String sender;

    private String routingKey;

    public RMQTransferObject(String sender, String routingKey, Object payload) {
        this.sender = sender;
        this.routingKey = routingKey;
        this.payload = payload;
    }

    private Object payload;

    public String getSender() {
        return sender;
    }

    public RMQTransferObject() {
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
