package springboot.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.model.Event;
import springboot.repository.EventRepository;

public class Receiver {

    @Autowired
    private EventRepository repository;

    @RabbitListener(queues = "provas_errors_queue")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        repository.save(new Event("Error", in));
    }
	
}
