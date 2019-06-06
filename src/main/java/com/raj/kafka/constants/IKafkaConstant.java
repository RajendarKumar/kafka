package com.raj.kafka.constants;

public interface IKafkaConstant {

	public interface IProducer {

		//multiple brokers can be configured with , separator localhost:9093,localhost:9094
		String KAFKA_BROKERS = "localhost:9092";
		Integer MESSAGE_COUNT = 1000;
		String CLIENT_ID = "client1";
		String TOPIC_NAME = "newtest";
		String GROUP_ID_CONFIG = "consGroup1";
		Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
		String OFFSET_RESET_LATEST = "latest";
		String OFFSET_RESET_EARLIER = "earliest";
		Integer MAX_POLL_RECORDS = 1;

	}
	
	public interface IConsumer {

		//multiple brokers can be configured with , separator
		String KAFKA_BROKERS = "localhost:9092";
		Integer MESSAGE_COUNT = 1000;
		String CLIENT_ID = "client1";
		String TOPIC_NAME = "newtest";
		String GROUP_ID_CONFIG = "consGroup1";
		Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
		String OFFSET_RESET_LATEST = "latest";
		String OFFSET_RESET_EARLIER = "earliest";
		Integer MAX_POLL_RECORDS = 1;

	}
}
