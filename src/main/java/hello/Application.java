package hello;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            Application.startMQ();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SpringApplication.run(Application.class, args);
    }


    private static void startMQ() throws Exception {
        BrokerService broker = new BrokerService();
        
        broker.addConnector("tcp://localhost:61616");
        broker.addConnector("stomp://localhost:61613?transport.hbGracePeriodMultiplier=1.5");

        broker.start();
    }
}