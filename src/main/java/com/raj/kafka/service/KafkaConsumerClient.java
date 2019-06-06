/**
 * 
 */
package com.raj.kafka.service;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.raj.kafka.api.IKafkaClient;
import com.raj.kafka.constants.IKafkaConstant.IConsumer;

/**
 * @author Rajendar
 *
 */
public class KafkaConsumerClient implements IKafkaClient<Consumer<String, String>>{

	public KafkaConsumerClient() {
	}


	@Override
	public Consumer<String, String> getClient() {

		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IConsumer.KAFKA_BROKERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, IConsumer.GROUP_ID_CONFIG);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IConsumer.MAX_POLL_RECORDS);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IConsumer.OFFSET_RESET_EARLIER);
		Consumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList( IConsumer.TOPIC_NAME));
		return consumer;
	}
}
