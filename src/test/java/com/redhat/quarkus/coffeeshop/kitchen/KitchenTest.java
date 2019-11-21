package com.redhat.quarkus.coffeeshop.kitchen;

import com.redhat.quarkus.coffeeshop.kitchen.domain.MenuItem;
import com.redhat.quarkus.coffeeshop.kitchen.domain.Order;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.logging.Logger;

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
    }
}
