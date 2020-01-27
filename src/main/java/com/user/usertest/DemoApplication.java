package com.user.usertest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableKafka
public class DemoApplication  {
	@Autowired
	private KafkaTemplate<String, String> template;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	private final CountDownLatch latch = new CountDownLatch(3);

//	@Override
//	public void run(String... args) throws Exception {
//		this.template.send("test", "foo1");
//		this.template.send("test", "foo2");
//		this.template.send("test", "foo3");
//		latch.await(60, TimeUnit.SECONDS);
//	}

	@KafkaListener(topics = "test")
	public void consume(String message, Acknowledgment ack) throws Exception {
		System.out.println(message);
		ack.acknowledge();

	}


}
