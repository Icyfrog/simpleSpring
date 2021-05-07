package com.example.demo;

import com.example.demo.Mqtt.MqttConfiguration;
import com.example.demo.Mqtt.MqttPushClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoApplication implements ApplicationRunner {

    /**
     * 读取mqtt配置
     */
    @Autowired
    private MqttConfiguration mqttConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * mqtt 初始化
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(true){
            if (log.isInfoEnabled()){
                log.info("===============>>>Mqtt is run starting:<<==================");
            }
            MqttPushClient mqttPushClient = new MqttPushClient();
            mqttPushClient.connect(mqttConfiguration);
        }
    }



}
