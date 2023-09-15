package com.ankita.rabitMq.service;

import com.ankita.rabitMq.model.Hospital;
import com.ankita.rabitMq.model.Patient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
  @Autowired
  private AmqpTemplate rabbitTemplate;

  @Value("${rabbitmq.exchange.name}")
  private String exchange;

  @Value("${rabbitmq.routingkey.name}")
  private String routingkey;

  public void send(Hospital hospital) {
    rabbitTemplate.convertAndSend(exchange, routingkey, hospital);
    System.out.println("Send messageg = " + hospital);
  }
    public void send(Patient patient) {
      rabbitTemplate.convertAndSend(exchange, routingkey, patient);
      System.out.println("Send messageg = " + patient);

  }
}
