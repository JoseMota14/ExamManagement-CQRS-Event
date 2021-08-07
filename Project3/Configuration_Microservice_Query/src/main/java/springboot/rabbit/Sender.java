package springboot.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Sender {
	
	@Autowired
    private RabbitTemplate template;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(String message) {
        this.template.convertAndSend("config_errors_queue", message);
        System.out.println(" [x] Sent '" + message + " to errors queue'");
    }
}
