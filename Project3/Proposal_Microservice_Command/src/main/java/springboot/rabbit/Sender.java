package springboot.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.google.gson.Gson;

import springboot.model.*;

public class Sender {
	
	@Autowired
    private RabbitTemplate template;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(String message) {
        this.template.convertAndSend("proposal_queue_post", message);
        System.out.println(" [x] Sent '" + message + "'");
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendDelete(String message) {
        this.template.convertAndSend("proposal_queue_delete", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
