package com.codenotfound.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codenotfound.kafka.producer.Sender;


@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaWebController {

	@Autowired
	Sender kafkaSender;
	
	private static String BOOT_TOPIC = "boot.t";
	private static String msg = "Hello Boot!";

	@GetMapping(value = "/producer")
	public String producer() {
		
		kafkaSender.send(BOOT_TOPIC, msg);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}

}