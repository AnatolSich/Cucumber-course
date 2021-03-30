package learning.cucumbercourse.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import learning.cucumbercourse.RestaurantMenu;
import learning.cucumbercourse.RestaurantMenuItem;

public class MenuManagementSteps {
    RestaurantMenuItem NewMenuItem;
    RestaurantMenu LocationMenu = new RestaurantMenu();

    @Given("I have a menu item with name {string} and price ([$]*){int}")
    public void i_have_a_menu_item_with_name_and_price(String menuItemName, Integer price) {

        NewMenuItem = new RestaurantMenuItem(menuItemName, menuItemName, price);
        System.out.println("Step 1");
    }

    @When("I add that menu item")
    public void i_add_that_menu_item() {
        LocationMenu.addMenuItem(NewMenuItem);
        System.out.println("Step 2");
    }

    @Then("^Menu Item with name \"(.*?)\" should be added$")
    public void menu_Item_with_name_should_be_added(String string) {
        boolean Exists = LocationMenu.DoesItemExist(NewMenuItem);
        System.out.println("Step 3: " + Exists);
    }

}
