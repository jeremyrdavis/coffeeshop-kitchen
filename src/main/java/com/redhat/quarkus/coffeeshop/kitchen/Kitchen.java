package com.redhat.quarkus.coffeeshop.kitchen;

import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import com.redhat.quarkus.coffeeshop.kitchen.domain.OrderStatus;
import com.redhat.quarkus.coffeeshop.kitchen.infrastructure.KafkaService;
import sun.rmi.runtime.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@ApplicationScoped
public class Kitchen {

    static final Logger LOGGER = Logger.getLogger(Kitchen.class.getName());

    @Inject
    KafkaService kafkaService;

    @Transactional
    public void orderIn(Order order) {

        LOGGER.info(order.toString());

        switch (order.getMenuItem()) {
            case  COOKIE:
                order.setStatus(OrderStatus.READY);
                break;
            case MUFFIN:
                order.setStatus(OrderStatus.READY);
                break;
            case PANINI:
                order.setStatus(OrderStatus.ACCEPTED);
                break;
            default:
                order.setStatus(OrderStatus.IN_PROGRESS);
        }
        kafkaService.updateOrder(order);
    }

}
