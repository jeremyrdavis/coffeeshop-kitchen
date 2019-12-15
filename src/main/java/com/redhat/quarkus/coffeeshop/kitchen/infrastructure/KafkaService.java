package com.redhat.quarkus.coffeeshop.kitchen.infrastructure;

import com.redhat.quarkus.coffeeshop.kitchen.Kitchen;
import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class KafkaService {

    static final Logger logger = Logger.getLogger(KafkaService.class.getName());

    @Inject
    Kitchen kitchen;

    @Incoming("kitchen-in")
    @Outgoing("kitchen-out")
    public void orderIn(Order order) {
        logger.info("orderIn:" + order.toString());
        Order completedOrder = kitchen.orderIn(order);
        kitchen.orderIn(order);
    }
}
