package com.using.abstraction.exception;

public class DeliveryAgentNotFound extends RuntimeException {
    public DeliveryAgentNotFound(String message) {

        super(message);
    }
}
