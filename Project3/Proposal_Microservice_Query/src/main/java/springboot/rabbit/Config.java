package springboot.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Queue configQueue() {
        return new Queue("proposal_queue_post");
    }

    @Bean
    public Queue configQueueDelete() {
        return new Queue("proposal_queue_delete");
    }

    @Bean
    public Queue configErrorsQueue() {
        return new Queue("proposal_errors_queue");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}
