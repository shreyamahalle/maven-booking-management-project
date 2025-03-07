package org.example.exception;

public class DeliveryAgentNotFound extends RuntimeException {
    public DeliveryAgentNotFound(String message) {

        super(message);
    }
}
