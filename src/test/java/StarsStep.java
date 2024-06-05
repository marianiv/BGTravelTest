import io.cucumber.java.en.When;

public class StarsStep {
    private final StarModel starModel;

    public StarsStep(StarModel starModel){this.starModel = starModel;}

    @When("Избира {int} звезди")
    public void selectStars(Integer stars){this.starModel.setStars(stars);}
}
