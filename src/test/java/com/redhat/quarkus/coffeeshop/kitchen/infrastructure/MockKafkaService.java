package com.redhat.quarkus.coffeeshop.kitchen.infrastructure;

import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import com.redhat.quarkus.coffeeshop.kitchen.domain.OrderStatus;
import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Mock
@ApplicationScoped
public class MockKafkaService extends KafkaService{

    @Override
    public void orderUp(Order order) {

        logger.info("MockKafkaService received at " + Instant.now().toString() + " " + order.toString());
        assertEquals(OrderStatus.READY, order.getStatus());
    }
}
