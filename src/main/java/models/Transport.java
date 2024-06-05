package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter@AllArgsConstructor

public class Transport {
    private Long ID;
    private String title;
    private String description;
    private int quantity;
    private double price;
    private Set<Category> categories;
}
