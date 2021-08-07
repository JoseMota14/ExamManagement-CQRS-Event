package springboot.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

	@Bean
    public Queue configQueuePost() {
        return new Queue("room_queue_post");
    }

    @Bean
    public Queue configQueueDelete() {
        return new Queue("room_queue_delete");
    }

    @Bean
    public Queue configQueue2() {
        return new Queue("reservation_queue_post");
    }

    @Bean
    public Queue configQueueDelete2() {
        return new Queue("reservation_queue_delete");
    }

    @Bean
    public Queue configUpdateScore() {
        return new Queue("reservation_queue_update");
    }

    @Bean
    public Queue configErrorsQueue() {
        return new Queue("provas_errors_queue");
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
