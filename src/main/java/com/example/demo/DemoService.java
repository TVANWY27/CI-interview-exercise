package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void processSpecificOrder(Order order) {
        order.setSpecific(true);
        // do many things...
    }

}
