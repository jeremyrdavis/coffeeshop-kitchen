package com.redhat.quarkus.coffeeshop.kitchen;

import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import com.redhat.quarkus.coffeeshop.kitchen.domain.OrderStatus;
import com.redhat.quarkus.coffeeshop.kitchen.infrastructure.KafkaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.logging.Logger;

@ApplicationScoped
public class Kitchen {

    static final Logger LOGGER = Logger.getLogger(Kitchen.class.getName());

    @Inject
    KafkaService kafkaService;

    @Transactional
    public Order orderIn(Order order) {

        LOGGER.info("Received order: " + order.toString());
        LOGGER.info("Sending order at " + Instant.now().toString() + " " + order.toString());

        switch (order.getMenuItem()) {
            case  COOKIE:
                prepare(2);
                order.setStatus(OrderStatus.READY);
                break;
            case MUFFIN:
                prepare(3);
                order.setStatus(OrderStatus.READY);
                break;
            case PANINI:
                prepare(10);
                order.setStatus(OrderStatus.READY);
                break;
            default:
                order.setStatus(OrderStatus.READY);
        }

        return order;
    }

    private void prepare(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



}
