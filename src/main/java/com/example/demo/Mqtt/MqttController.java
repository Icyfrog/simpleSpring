package com.example.demo.Mqtt;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@ResponseBody
@RequestMapping("/mqtt")
public class MqttController {

    //发送逻辑
    @Autowired
    private MqttSender mqttSender;

    //订阅逻辑
    @Autowired
    private MqttPushClient mqttPushClient;

    @RequestMapping("/sendmqtt")
    public String sendmqtt(){
        String TOPIC1="testtest1";
        String JSON = "{'gender':'man','hobby':'girl'}";
        log.info("    本机主题:"+TOPIC1+" 发送数据为:"+ JSONObject.toJSONString(JSON));
        mqttSender.send(TOPIC1, JSON);
        log.info("     发送结束");
        return "发送结束";
    }

    @RequestMapping("/subscriptionmqtt")
    public String subscriptionmqtt(){
        int Qos=1;
        String TOPIC1="testtest1";
        String[] topics={TOPIC1};
        int[] qos={Qos};
        mqttPushClient.subscribe(topics,qos);
        return "订阅主题";
    }
}
