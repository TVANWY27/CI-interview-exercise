package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DemoController.class})
class DemoControllerTest {

    @MockBean
    private DemoService demoService;

    private DemoController demoController;

    @BeforeEach
    void setUp() {
        this.demoController = new DemoController(demoService);
    }

    @Test
    void processOrder_shouldReturnReceipt() {
        Order order = new Order();
        order.setId("1");
        order.setCity("lille");
        order.setEmail("toto@gmail.com");
        order.setTotal(42);
        order.setSource("adao");
        order.setPhoneNumber("0632198634");
        order.setClientName("toto");
        order.setClientSurname("tata");

        var result = demoController.processOrder(order);

        assertEquals("toto@gmail.com - lille - null - 0632198634 - null - tutu - tata - 42.0", result);
    }

    @Test
    void processOrder_shouldTestSpecificOrder() {

    }

}