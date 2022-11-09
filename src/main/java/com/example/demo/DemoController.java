package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private final DemoService demoService;

	public DemoController(final DemoService demoService) {
		this.demoService = demoService;
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String processOrder(@RequestBody Order order) {
		if (order.getSource().equals("prestashop") || order.getSource().equals("as400") || order.getSource().equals("oneshop") || order.getSource().equals("ordpress") || order.getSource().equals("wix") || order.getSource().equals("decathlon") || (order.getSource().equals("adeo") && order.getTotal() > 1_000_000)) {
			demoService.processSpecificOrder(order);
			String receipt = "";
			receipt += order.getEmail();
			receipt += " - ";
			receipt += order.getCity();
			receipt += " - ";
			receipt += order.getAddress();
			receipt += " - ";
			receipt += order.getPhoneNumber();
			receipt += " - ";
			receipt += order.getPostalCode();
			receipt += " - ";
			receipt += order.getClientName();
			receipt += " - ";
			receipt += order.getClientSurname();
			receipt += " - ";
			receipt += order.getTotal();
			return receipt;
		} else {
			String receipt = "";
			receipt += order.getEmail();
			receipt += " - ";
			receipt += order.getCity();
			receipt += " - ";
			receipt += order.getAddress();
			receipt += " - ";
			order.setSpecific(false);
			receipt += order.getPhoneNumber();
			receipt += " - ";
			receipt += order.getPostalCode();
			receipt += " - ";
			receipt += order.getClientName();
			receipt += " - ";
			receipt += order.getClientSurname();
			receipt += " - ";
			receipt += order.getTotal();
			return receipt;
		}
	}
}
