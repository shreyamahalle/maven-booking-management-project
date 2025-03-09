package com.shreya.maven.impl;
import com.shreya.maven.service.OrderNumberService;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderNumberImpl implements OrderNumberService {

    @Override
    public void createOrderNo() {
        AtomicInteger orderNumberCounter = new AtomicInteger(100);
    }
    }

