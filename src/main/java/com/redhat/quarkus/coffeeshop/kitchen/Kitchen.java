package com.redhat.quarkus.coffeeshop.kitchen;

import com.redhat.quarkus.coffeeshop.kitchen.domain.KitchenOrder;
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
    public KitchenOrder orderIn(KitchenOrder kitchenOrder) {

        LOGGER.info("Received order: " + kitchenOrder.toString());
        LOGGER.info("Sending order at " + Instant.now().toString() + " " + kitchenOrder.toString());

        switch (kitchenOrder.getMenuItem()) {
            case  COOKIE:
                prepare(2);
                kitchenOrder.setStatus(OrderStatus.READY);
                break;
            case MUFFIN:
                prepare(3);
                kitchenOrder.setStatus(OrderStatus.READY);
                break;
            case PANINI:
                prepare(10);
                kitchenOrder.setStatus(OrderStatus.READY);
                break;
            default:
                kitchenOrder.setStatus(OrderStatus.READY);
        }

        return kitchenOrder;
    }

    private void prepare(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



}
