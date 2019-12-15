package com.redhat.quarkus.coffeeshop.kitchen.domain;

public class KitchenOrder {

    String orderNumber;

    String name;

    MenuItem menuItem;

    OrderStatus status;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Order[")
                .append("orderNumber=")
                .append(orderNumber)
                .append(",name=")
                .append(name)
                .append(",menuItem=")
                .append(menuItem)
                .append(",status=")
                .append(status).toString();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
