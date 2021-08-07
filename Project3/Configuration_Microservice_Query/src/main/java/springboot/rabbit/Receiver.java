package springboot.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.service.ConfigQueryService;

public class Receiver {

	@Autowired
    ConfigQueryService configQueryService;

    @RabbitListener(queues = "config_queue_post")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        configQueryService.insertFromQueue(in);
    }

    @RabbitListener(queues = "config_queue_delete")
    public void receiveDelete(String in) {
        System.out.println(" [x] Received '" + in + "'");
        configQueryService.deleteFromQueue(in);
    }
	
}
