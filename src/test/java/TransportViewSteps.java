import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Category;
import models.Transport;
import services.CategoryService;
import services.TransportService;

import java.util.List;

import static org.junit.Assert.*;

public class TransportViewSteps {
    private String category;
    private String transportName;
    private List<Transport> transportList;

    @When("Отваряне на приложението")
    public void openApp(){

    }

    @When("Натиска бутона за търсене")
    public void clickSearchButton(){
        TransportService transportService = new TransportService();
        transportList = transportService.load(category,transportName);
    }

    @Then("Визуализира се списък с категории")
    public void checkCategories(){
        CategoryService categoryService = new CategoryService();
        List<Category> categories = categoryService.load();
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Автобус")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Влак")));
        assertTrue(categories.stream().anyMatch(c -> c.getTitle().equals("Ферибот")));
        assertEquals(3,categories.size());
    }

    @When("Потребителят избере категория {string}")
    public void chooseCategory(String category){this.category = category;}

    @Then("Визуализира се списък с наличните {int} оферти")
    public void checkTransportList(int expectedTransportCount){
        if (null == transportList){
            TransportService transportService = new TransportService();
            transportList = transportService.load(category,transportName);

        }
        assertNotNull(transportList);
        assertEquals(expectedTransportCount, transportList.size());
    }

    @When("Потребителят въвежда {string} в полето за търсене")
    public void addTransportNameInSearchField(String transportName){this.transportName= transportName;}
}
