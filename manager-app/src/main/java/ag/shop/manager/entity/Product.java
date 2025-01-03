package ag.shop.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Integer id;

    private String title;

    private String description;
}
