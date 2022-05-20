package com.example.masksale.mqtt.mqtt_config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.AbstractMqttMessageHandler;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * MQTT配置
 */
@Slf4j
@Configuration
@IntegrationComponentScan
public class MqttReceiveConfig {

    public String username = "mask";

    public String password = "ljhLJH080230.";

    //树莓派公网ip
    public String hostUrl = "tcp://123.9.177.248:1883";

    public String inputClientId = "maskId";

    public String outClientId = "maskId";

    public int completionTimeout = 2000;   //连接超时

    /**
     * 连接配置
     */
    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 用户名
        mqttConnectOptions.setUserName(username);
        // 密码
        mqttConnectOptions.setPassword(password.toCharArray());
        // 服务器地址
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        // 心跳检测时间
        mqttConnectOptions.setKeepAliveInterval(2);
        return mqttConnectOptions;
    }

    /**
     * 初始化工厂
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(getMqttConnectOptions());
        return factory;
    }




    /**
     * 发送通道
     */
    @Bean(value = "mqttOut")
    public MessageChannel mqttOutChannel() {
        return new DirectChannel();
    }



    /**
     * 发送消息通道
     */
    @Bean
    @ServiceActivator(inputChannel = "mqttOut")
    public AbstractMqttMessageHandler mqttSend() {
        //创建一个新的出站管道，由于MQTT的发布与订阅是两个独立的连接，
        // 因此客户端的ID(即APPID）不能与订阅时所使用的ID一样，否则在服务端会认为是同一个客户端，而造成连接失败
        MqttPahoMessageHandler outGate = new MqttPahoMessageHandler(outClientId, mqttClientFactory());
        DefaultPahoMessageConverter converter = new DefaultPahoMessageConverter();
        converter.setPayloadAsBytes(false);//bytes类型接收
        outGate.setConverter(converter);
        outGate.setAsync(true);
        outGate.setCompletionTimeout(completionTimeout);//设置连接超时时时
        outGate.setDefaultQos(2);//设置通信质量
        return outGate;
    }

    /**
     * 监听通道消息
     * 通过通道获取数据
     */
    @Bean
    @ServiceActivator(inputChannel = "input")
    public MessageHandler handler() {
        return message -> {
            log.info("message:\n{}", message);
            String topic = message.getHeaders().get("mqtt_receivedTopic").toString();
            if ("hello".equalsIgnoreCase(topic)) {
                log.info("hello:{}", message.getPayload());
            } else if ("hello1".equalsIgnoreCase(topic)) {
                log.info("hello1:{}", message.getPayload());
            }
        };
    }
}

