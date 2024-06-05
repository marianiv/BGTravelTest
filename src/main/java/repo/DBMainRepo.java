package repo;

import models.Category;
import models.Rating;
import models.Reservation;
import models.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DBMainRepo {
    private static List<Transport> transportList = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();

    private static List<Reservation> reservations = new ArrayList<>();
    private static List<Rating> ratings = new ArrayList<>();

    static {
        Category cat1 = new Category(1l, "Автобус", "Пътуване с автобус", null, null);
        Category cat2 = new Category(2l, "Влак", "Пътуване с влак", null,null);
        Category cat3 = new Category(3l, "Ферибот", "Пътуване с ферибот", null, null);

        transportList.add(new Transport(1l,"Автобуси до София","", 3, 10.99d, Set.of(cat1)));
        transportList.add(new Transport(2l,"Автобуси до Пловдив","", 3, 12.45d, Set.of(cat1)));
        transportList.add(new Transport(3l,"Автобуси до Варна","", 2, 15.55d, Set.of(cat1)));
        transportList.add(new Transport(4l,"Влакове до София","", 5, 5.99d, Set.of(cat2)));
        transportList.add(new Transport(5l,"Влакове до Бургас","", 3, 8.99d, Set.of(cat2)));
        transportList.add(new Transport(6l,"Фериботи до Варна","", 2, 20.99d, Set.of(cat3)));
        transportList.add(new Transport(7l,"Фериботи до Бургас","", 2, 20.99d, Set.of(cat3)));

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);



    }

    static {
        Reservation reservation1 = new Reservation(1l, "резервация1", "описание1",  null );
        Reservation reservation2 = new Reservation(2l, "резервация2", "описание2",  null );
        Reservation reservation3 = new Reservation(3l, "резервация3", "описание3",  null );

        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
    }

    public static List<Category> getCategories(){return categories;};

    public static List<Transport> getTransportList(){return transportList;};

    public static List<Reservation> getReservations(){return reservations;};

    public static List<Rating> getRatings(){return ratings;};

}
