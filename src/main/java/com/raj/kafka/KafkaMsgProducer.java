package com.raj.kafka;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.raj.kafka.constants.IKafkaConstant;
import com.raj.kafka.constants.IKafkaConstant.IProducer;

/**
 * 
 * @author Rajendar
 *
 */
public class KafkaMsgProducer implements Runnable{

	private Producer<String, String> producer;
	public KafkaMsgProducer(Producer<String, String> producer) {
		this.producer =producer;
	}
	@Override
	public void run() {
		for (int index = 0; index < IKafkaConstant.IProducer.MESSAGE_COUNT; index++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(IProducer.TOPIC_NAME,  "This is record No. : " + index);
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
				+ " with offset " + metadata.offset());
			} 
			catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} 
			catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}
