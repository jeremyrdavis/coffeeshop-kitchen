package com.redhat.quarkus.coffeeshop.kitchen;

import com.redhat.quarkus.coffeeshop.kitchen.domain.MenuItem;
import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import io.quarkus.test.junit.QuarkusTest;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.awaitility.Awaitility.await;

@QuarkusTest
public class KitchenTest {

    static final Logger logger = Logger.getLogger(KitchenTest.class.getName());

    @Inject
    Kitchen kitchen;

    @Test
    public void testOrderCookie() {

        logger.info("Test that a Cookie is ready instantly");

        Order order = new Order();
        order.setMenuItem(MenuItem.COOKIE);
        order.setName("Jeremy");
        order.setOrderNumber("1234567");

        kitchen.orderIn(order);
        await()
                .atLeast(Duration.TWO_SECONDS)
                .atMost(Duration.FIVE_SECONDS);
    }

    @Test
    public void testOrderPanini() {

        logger.info("Test that a Panini takes 5 seconds");

        Order order = new Order();
        order.setMenuItem(MenuItem.PANINI);
        order.setName("Jeremy");
        order.setOrderNumber("1234567");

        kitchen.orderIn(order);
        await()
                .atLeast(Duration.TEN_SECONDS)
                .atMost(Duration.ONE_MINUTE);
    }
}
