package com.example.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.constants.KafkaConstants;
import com.example.demo.model.Message;


@Component
public class MessageListener {
    @Autowired
    SimpMessagingTemplate template;
    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message) {
    	 logger.info(String.format("Message sent -> %s", message));
        template.convertAndSend("/topic/group", message);
    }
}