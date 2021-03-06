package zztest.controller;

import com.google.gson.Gson;
import com.zz.KafkaProducer;
import com.zz.vo.SendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqy
 * @version 1.0
 * @date 2020/8/28 14:35
 */
@Controller
@RequestMapping(value = "/test")
public class Test{

    @Autowired
    private KafkaProducer kafkaProducer;

    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    @ResponseBody
    public void sendMessage1(@PathVariable("message") String normalMessage) {

        SendData<String> stringSendData = new SendData<>("topic.test",null);

        stringSendData.setData("这是一个测试数据");
        stringSendData.setTopic("topic.test");

        kafkaProducer.sendMsg(stringSendData);
    }

    @RequestMapping(value = "/te")
    @ResponseBody
    public String test(){

        String s = "";

        for(int i = 0;i<100;i++){
            s = s + i;
        }

        List<List<List<String>>> lists = new ArrayList<>();

        Gson gson = new Gson();

        gson.fromJson("",lists.getClass());

        return "这是test服务";





    }

}
