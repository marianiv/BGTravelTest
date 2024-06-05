import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.RatingService;

import static org.junit.Assert.assertEquals;

public class RatingSteps {

    private final StarModel starModel;
    private String reservationName;

    private String comment;
    private String message;

    public RatingSteps(StarModel starModel){
        this.starModel = starModel;
    }

    @Given("Потребителят отваря детайлите на {string}")
    public void openReservationDetails(String reservationName){this.reservationName = reservationName;}

    @When("Напише коментар {string}")
    public void addComment(String comment){this.comment = comment;}


    @When("Натисне бутона за оценка")
    public void submitRating(){
        RatingService ratingService = new RatingService();
        message = ratingService.rateReservation(reservationName, starModel.getStars(),comment);

    }
    @Then("Визуализира се съобщение {string}")
    public void
    checkMessage(String expectedMessage){assertEquals(expectedMessage, message);}
}
