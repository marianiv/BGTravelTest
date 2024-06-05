package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private Long ID;
    private Integer stars;
    private String comment;
    private Reservation reservation;
}
