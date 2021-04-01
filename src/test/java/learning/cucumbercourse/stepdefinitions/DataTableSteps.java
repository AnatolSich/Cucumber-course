package learning.cucumbercourse.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DataTableSteps {
   /* @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automation transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

		*//*String dishName = dataTable.cell(0,0);
		String amount = dataTable.cell(0,1);
		String price = dataTable.cell(0,2);
		System.out.println(dishName);
		System.out.println(amount);
		System.out.println(price);*//*
        List<List<String>> billData = dataTable.asLists();
        //	List<String> billData = dataTable.row(0);
        //	List<String> billData = dataTable.transpose().asList(String.class);

        for (List<String> billItem : billData) {
            System.out.println(billItem);
        }
    }*/

  /*  @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {

        List<List<String>> billData = dataTable.asLists();

        for (List<String> billRow : billData) {
            for (String billItem : billRow
            ) {
                System.out.print(billItem + " | ");
            }
            System.out.println();
        }
    }*/

    @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> billData = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> billRow : billData) {
            String itemName = billRow.get("ItemName");
            String units = billRow.get("Units");
            String unitPrice = billRow.get("UnitPrice");
            //we would skip the first row since Cucumber does not differentiate between headings and row data
            if (itemName != null) {
                System.out.println("Key: itemName | Value: " + itemName);
                System.out.println("Key: units | Value: " + units);
                System.out.println("Key: unitPrice | Value: " + unitPrice);
                System.out.println();
            }


        }
    }


    @When("I generate the bill")
    public void i_generate_the_bill() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("a bill for ${int} should be generated")
    public void a_bill_for_$_should_be_generated(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }
}
