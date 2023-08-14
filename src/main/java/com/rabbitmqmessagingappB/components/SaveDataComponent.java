package com.rabbitmqmessagingappB.components;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rabbitmqmessagingappB.entites.ReceievedData;
import com.rabbitmqmessagingappB.repositories.DbRepositories;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveDataComponent {
    @Autowired
    private DbRepositories dbRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues ="QueueforRabbitMQ")
    public void  handleMessage(String jsonMessage){

        JsonObject jsonObject = JsonParser.parseString(jsonMessage).getAsJsonObject();

        ReceievedData receivedData = new ReceievedData();
        receivedData.setApiName(jsonObject.get("api_name").getAsString());
        receivedData.setCreateDate(jsonObject.get("createdate").getAsString());
        receivedData.setEmail(jsonObject.get("email").getAsString());
        receivedData.setId(jsonObject.get("userid").getAsString());
        receivedData.setName(jsonObject.get("name").getAsString());
        receivedData.setPassword(jsonObject.get("password").getAsString());
        receivedData.setSurname(jsonObject.get("surname").getAsString());

        dbRepository.save(receivedData);

        String responseMessage = "Data is received by RabbitMqMessagingApp-A & B Project.\nAll data are saved to db for each project.\nThis message came from RabbitMqMesaaingApp-B Project via RabbitMQ. ";
        System.out.println( "Here is the data from RabbitMQMessagingApp-A: " + jsonMessage);

        rabbitTemplate.convertAndSend("ListenerExchange", "routingKeyListener", responseMessage);

    }
}
