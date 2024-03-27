package jpabook.jpashop.repository.order.query;

import lombok.Data;

@Data
public class OrderItemQueryDto {
    private Long orderId;

    public OrderItemQueryDto(Long orderId, String itemName, int orderPrice, int price) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.price = price;
    }

    private String itemName;
    private int orderPrice;
    private int price;
}
