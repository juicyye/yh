package hello.itemservice.web.validation.form;

import lombok.Data;

@Data
public class ItemSaveForm {
    private String itemName;
    private Integer price;
    private Integer quantity;
}
