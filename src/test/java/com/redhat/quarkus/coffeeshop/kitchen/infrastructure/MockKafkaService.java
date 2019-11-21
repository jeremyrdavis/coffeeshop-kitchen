package com.redhat.quarkus.coffeeshop.kitchen.infrastructure;

import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import com.redhat.quarkus.coffeeshop.kitchen.domain.OrderStatus;
import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Mock
@ApplicationScoped
public class MockKafkaService extends KafkaService{

    @Override
    public void orderUp(Order order) {

        logger.info("MockKafkaService received: " + order.toString());
        assertEquals(OrderStatus.READY, order.getStatus());
    }
}
