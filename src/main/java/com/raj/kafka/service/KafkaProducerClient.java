/**
 * 
 */
package com.raj.kafka.service;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import com.raj.kafka.api.IKafkaClient;
import com.raj.kafka.constants.IKafkaConstant.IProducer;

/**
 * @author Rajendar
 *
 */
public class KafkaProducerClient implements IKafkaClient<Producer<String, String>>{

	public KafkaProducerClient() {
	}
	

	@Override
	public Producer<String, String> getClient() {
		
		Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IProducer.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, IProducer.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
	}
}
