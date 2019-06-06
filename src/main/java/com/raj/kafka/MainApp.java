package com.raj.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;

import com.raj.kafka.api.IKafkaClient;
import com.raj.kafka.service.KafkaConsumerClient;
import com.raj.kafka.service.KafkaProducerClient;

public class MainApp {

	public static void main(String[] args) {
		
		  IKafkaClient<Producer<String,String>> kafkaProducerClient = new
		  KafkaProducerClient();
		  
		  Producer<String, String> client = kafkaProducerClient.getClient();
		  
		  KafkaMsgProducer kafkaMsgProducer = new KafkaMsgProducer(client); new
		  Thread(kafkaMsgProducer).start();
		 
		KafkaConsumerClient kafkaConsumerClient = new KafkaConsumerClient();
		Consumer<String,String> consumer = kafkaConsumerClient.getClient();
		KafkaMsgConsumer kafkaMsgConsumer = new KafkaMsgConsumer(consumer);

		new Thread(kafkaMsgConsumer).start();
	}

}
