package com.example.masksale.mqtt.mqtt_config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@MessagingGateway
@Component
public interface MqttGateway {
    /**
     * 发送消息
     *
     * @param topic 主题
     * @param msg   消息内容
     */
    @Gateway(requestChannel = "mqttOut")
    void send(@Header(MqttHeaders.TOPIC) String topic, String msg);
}

