package hello.hellojpa.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Order {
    private Long id;
    private String itemName;
    private int price;
    private int discountPrice;

    public int calculatePrice() {
        return price - discountPrice;
    }

}
