package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DemoController.class, RandomClass.class})
class DemoControllerTest {

    @Autowired
    private RandomClass fakeClass;
    private DemoController demoController;

    @BeforeEach
    void setUp() {
        this.demoController = new DemoController(fakeClass);
    }

    @Test
    void shouldReturnReceipt_whenOrderNotSpecific() {
        Order order = new Order();
        order.setId("1");
        order.setCity("lille");
        order.setEmail("toto@gmail.com");
        order.setTotal(42);
        order.setSource("test");
        order.setPhoneNumber("0632198634");
        order.setClientName("toto");
        order.setSpecific(false);

        var result = demoController.processOrder(order);

        assertEquals("toto@gmail.com - 0632198634 - null - tata - false - 42.0", result);
    }

    @Test
    void shouldReturnReceipt_whenSourceIsPrestashop() {
        Order order = new Order();
        order.setId("1");
        order.setCity("lille");
        order.setEmail("toto@gmail.com");
        order.setTotal(42);
        order.setSource("prestashop");
        order.setPhoneNumber("0632198634");
        order.setClientName("toto");
        order.setSpecific(false);

        var result = demoController.processOrder(order);

        assertEquals("toto@gmail.com - 0632198634 - null - toto - true - 42.0", result);
    }

    @Test
    void shouldReturnReceipt_whenSourceIsAdeoAndTotalLessThan1000() {
        Order order = new Order();
        order.setId("1");
        order.setCity("lille");
        order.setEmail("toto@gmail.com");
        order.setTotal(42);
        order.setSource("adeo");
        order.setPhoneNumber("0632198634");
        order.setClientName("toto");
        order.setSpecific(false);

        var result = demoController.processOrder(order);

        assertEquals("toto@gmail.com - 0632198634 - null - toto - false - 42.0", result);
    }

    @Test
    void shouldReturnReceipt_whenSourceIsAdeoAndTotalMoreThan1000() {
        Order order = new Order();
        order.setId("1");
        order.setCity("lille");
        order.setEmail("toto@gmail.com");
        order.setTotal(2_000);
        order.setSource("adeo");
        order.setPhoneNumber("0632198634");
        order.setClientName("toto");
        order.setSpecific(false);

        var result = demoController.processOrder(order);

        assertEquals("toto@gmail.com - 0632198634 - null - toto - true - 2000.0", result);
    }

}