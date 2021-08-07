package springboot.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.service.ProposalQueryService;

public class Receiver {

	@Autowired
	ProposalQueryService proposalQueryService;

    @RabbitListener(queues = "proposal_queue_post")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        proposalQueryService.insertFromQueue(in);
    }

    @RabbitListener(queues = "proposal_queue_delete")
    public void receiveDelete(String in) {
        System.out.println(" [x] Received '" + in + "'");
        proposalQueryService.deleteFromQueue(in);
    }
	
}
