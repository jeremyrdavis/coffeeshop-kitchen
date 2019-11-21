package com.redhat.quarkus.coffeeshop.kitchen.infrastructure;

import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class KafkaService {

    static final Logger logger = Logger.getLogger(KafkaService.class.getName());

    public void updateOrder(Order order) {

        logger.info(order.toString());
    }
}
