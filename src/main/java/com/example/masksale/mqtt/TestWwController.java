package com.example.masksale.mqtt;
import com.example.masksale.mqtt.mqtt_config.MqttGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestWwController {

    @Resource
    private MqttGateway mqttGateway;

    @PostMapping("mqttSend")
    public void mqtt() {
        String topic = "mask";
        String msg = "1";
        mqttGateway.send(topic, msg);
    }

}