package me.arthurlins.restaurant.tests;

import me.arthurlins.restaurant.model.ClientQueue;
import me.arthurlins.restaurant.services.ClientQueueService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientQueueServiceTest {

    @Test
    void add() {
        ClientQueueService service = new ClientQueueService();
        try {
            ClientQueue clientQueue = new ClientQueue("name", "phone", 5, "RAND");
            service.enqueue(clientQueue);
            assertFalse(service.viewQueue().isEmpty());
            assertNotEquals(-1, clientQueue.getId());
        } catch (Exception e) {
            fail(e.getCause());
        }
    }

    @Test
    void intelligentAppend() {
        try {
            ClientQueueService clientQueueService = new ClientQueueService();
            assertNull(clientQueueService.getBestClientQueueTo(5));
            ClientQueue model4 = new ClientQueue("name1", "phone", 4, "RAND");
            ClientQueue model5 = new ClientQueue("name", "phone", 5, "RAND");
            ClientQueue model6 = new ClientQueue("name", "phone", 6, "RAND");


            clientQueueService.enqueue(model6);
            clientQueueService.enqueue(model6);
            clientQueueService.enqueue(model6);
            clientQueueService.enqueue(model5);
            clientQueueService.enqueue(model4);

            ClientQueue result1 = clientQueueService.getBestClientQueueTo(6);
            clientQueueService.attend(result1);
            System.out.println("POPED: " + result1.getPersonQtd() + "|" + result1.getSkippedCount());
            ClientQueue result2 = clientQueueService.getBestClientQueueTo(6);
            clientQueueService.attend(result2);
            System.out.println("POPED: " + result2.getPersonQtd() + "|" + result2.getSkippedCount());
            ClientQueue result3 = clientQueueService.getBestClientQueueTo(6);
            clientQueueService.attend(result3);
            System.out.println("POPED: " + result3.getPersonQtd() + "|" + result3.getSkippedCount());
            assertEquals(4, result3.getPersonQtd());
            ClientQueue result4 = clientQueueService.getBestClientQueueTo(6);
            clientQueueService.attend(result4);
            System.out.println("POPED: " + result4.getPersonQtd() + "|" + result4.getSkippedCount());
            assertEquals(5, result4.getPersonQtd());

            ClientQueue result5 = clientQueueService.getBestClientQueueTo(6);
            clientQueueService.attend(result5);
            System.out.println("POPED: " + result5.getPersonQtd() + "|" + result5.getSkippedCount());
            assertEquals(6, result5.getPersonQtd());
            //System.out.println("R:"+result3.getPersonQtd());


            //System.out.println(clientQueue2.getId() + "| " + clientQueueService.getBestClientQueueTo(5).getId());
        } catch (Exception e) {
            fail(e);
        }

    }


}
