package services;

import models.Rating;
import models.Reservation;
import repo.DBMainRepo;


public class RatingService {

    public String rateReservation(String reservationName, Integer stars, String comment){
        String errorMessage = validate(stars,comment);
        if (errorMessage != null){
            return errorMessage;
        }
        Reservation reservation = getReservation(reservationName);
        DBMainRepo.getRatings().add(new Rating(1l, stars, comment, reservation));

        return "Оценихте " + reservationName + " с " + stars + " звезди";
    }

    public static Reservation getReservation(String reservationName){
        Reservation reservation = DBMainRepo.getReservations()
                .stream()
                .filter(s -> s.getName().equals(reservationName))
                .findFirst()
                .orElse(null);
        return reservation;
    }

    private static String validate(Integer stars, String comment){
        if (stars == null){
            return "Моля, оценете резервацията";
        }
        if (stars <1 || stars > 5){
            return "Звездите трябва да са между 1 и 5";
        }
        if (null != comment && comment.length() > 60){
            return "Коментарът трябва да е под 60 символа!";
        }
        return null;
    }
}
