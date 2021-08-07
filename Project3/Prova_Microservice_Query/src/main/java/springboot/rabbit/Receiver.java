package springboot.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.service.ReservationService;
import springboot.service.RoomService;

public class Receiver {

	@Autowired
    RoomService roomService;

    @Autowired
    ReservationService reservationService;

    @RabbitListener(queues = "room_queue_post")
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        roomService.insertFromQueue(in);
    }

    @RabbitListener(queues = "room_queue_delete")
    public void receiveDelete(String in) {
        System.out.println(" [x] Received '" + in + "'");
        roomService.deleteFromQueue(in);
    }

    @RabbitListener(queues = "reservation_queue_post")
    public void receive2(String in) {
        System.out.println(" [x] Received '" + in + "'");
        reservationService.insertFromQueue(in);
    }

    @RabbitListener(queues = "reservation_queue_delete")
    public void receiveDelete2(String in) {
        System.out.println(" [x] Received '" + in + "'");
        reservationService.deleteFromQueue(in);
    }

    @RabbitListener(queues = "reservation_queue_update")
    public void receiveUpdate(String in) {
        System.out.println(" [x] Received '" + in + "'");
        reservationService.updateScoreById(in);
    }
	
}
