package springboot.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

	@Bean
    public Queue configQueuePost() {
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
    public Sender sender() {
        return new Sender();
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}
