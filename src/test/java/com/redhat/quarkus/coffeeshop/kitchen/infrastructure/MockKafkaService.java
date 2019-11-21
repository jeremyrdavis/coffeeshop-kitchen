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
    public void updateOrder(Order order) {

        logger.info("mock: " + order.toString());
        switch (order.getMenuItem()) {
            case PANINI:
                assertEquals(OrderStatus.IN_PROGRESS, order.getStatus());
                break;
            case COOKIE:
                assertEquals(OrderStatus.READY, order.getStatus());
                break;
            case MUFFIN:
                assertEquals(OrderStatus.READY, order.getStatus());
                break;
            default:
                assertTrue(false);
        }
    }
}
