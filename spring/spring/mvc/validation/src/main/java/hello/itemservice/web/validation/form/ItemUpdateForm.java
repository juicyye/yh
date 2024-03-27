package hello.itemservice.web.validation.form;

import lombok.Data;

@Data
public class ItemUpdateForm {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
}
