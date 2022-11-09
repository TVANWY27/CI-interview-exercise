package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class RandomClass {

    public void processSpecificOrder(Order order) {
        order.setSpecific(true);
        // do many things...
    }

}
