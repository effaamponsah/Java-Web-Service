package iot.turntabl.springweb;

import iot.turntabl.springweb.utils.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch){
        this.latch=latch;
    }

    public void addedMessage(String message) {
        try {
            LOGGER.info("New user added <" + message + ">");
            Logs.writeToFile(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }

    public void removeMessage(String message) {
        try {
            LOGGER.info("New user removed <" + message + ">");
            latch.countDown();
            Logs.writeToFile(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
