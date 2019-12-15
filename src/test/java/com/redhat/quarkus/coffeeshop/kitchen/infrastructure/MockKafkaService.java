package com.redhat.quarkus.coffeeshop.kitchen.infrastructure;

import com.redhat.quarkus.coffeeshop.kitchen.domain.KitchenOrder;
import com.redhat.quarkus.coffeeshop.kitchen.domain.OrderStatus;
import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Mock
@ApplicationScoped
public class MockKafkaService extends KafkaService{

    @Override
    public void orderIn(KitchenOrder kitchenOrder) {

        logger.info("MockKafkaService received at " + Instant.now().toString() + " " + kitchenOrder.toString());
        assertEquals(OrderStatus.READY, kitchenOrder.getStatus());
        kitchenOrder.setStatus(OrderStatus.READY);
    }
}
