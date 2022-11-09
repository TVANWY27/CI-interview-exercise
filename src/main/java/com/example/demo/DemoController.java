package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class DemoController {

	private final RandomClass randomClass;

	public DemoController(final RandomClass fakeClass) {
		this.randomClass = fakeClass;
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public String processOrder(@RequestBody Order order) {
		if (order.getSource().equals("prestashop") || order.getSource().equals("as400") || order.getSource().equals("oneshop") || order.getSource().equals("wordpress") || order.getSource().equals("decathlon") || (order.getSource().equals("adeo") && order.getTotal() >= 1_000)) {
			randomClass.processSpecificOrder(order);
			String summary = "";
			summary += order.getEmail();
			summary += " - ";
			summary += order.getPhoneNumber();
			summary += " - ";
			summary += order.getPostalCode();
			summary += " - ";
			summary += order.getClientName();
			summary += " - ";
			summary += order.getSpecific();
			summary += " - ";
			summary += order.getTotal();
			return summary;
		} else {
			String receipt = "";
			receipt += order.getEmail();
			receipt += " - ";
			receipt += order.getPhoneNumber();
			receipt += " - ";
			order.setSpecific(false);
			receipt += order.getPostalCode();
			receipt += " - ";
			receipt += order.getClientName();
			receipt += " - ";
			receipt += order.getSpecific();
			receipt += " - ";
			receipt += order.getTotal();
			return receipt;
		}
	}
}
