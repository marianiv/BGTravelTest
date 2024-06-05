package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Category {
    private Long ID;
    private String title;
    private String description;
    private Category parentCategory;
    private Set<Category> children;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;

        return Objects.equals(ID, category.ID) && Objects.equals(title, category.title);

    }

    @Override
    public int hashCode(){return Objects.hash(ID,title); }
}
