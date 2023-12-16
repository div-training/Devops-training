package Steps;

import Utils.APIUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiSteps {

    Response response;
    APIUtils obj = new APIUtils();

    @When("User sends {string} request to {string} endpoint")
    public void user_sends_request_to_endpoint(String method, String endpoint)
    {
        obj.set_uri(endpoint);
        response=obj.execute_api(method);
    }
    
    @Then("User verifies Status code is {int}")
    public void user_verifies_status_code_is(Integer status_code) {
        Assert.assertEquals(response.statusCode(),status_code);

    }

    @Then("User verifies response body contains following details")
    public void user_verifies_response_body_contains_following_details(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertEquals(response.body().jsonPath().getString("booking." + dataTable.cell(0, 0)), dataTable.cell(1, 0));
        Assert.assertEquals(response.body().jsonPath().getString("booking."+dataTable.cell(0,1)),dataTable.cell(1,1));
        Assert.assertEquals(response.body().jsonPath().getString("booking."+dataTable.cell(0,2)),dataTable.cell(1,2));
        Assert.assertEquals(response.body().jsonPath().getString("booking."+dataTable.cell(0,3)),dataTable.cell(1,3));
    }

    @Then("User verifies the response body contains following details")
    public void user_the_verifies_response_body_contains_following_details(io.cucumber.datatable.DataTable dataTable)
    {
        System.out.println(response.asString());
        Assert.assertEquals(response.body().jsonPath().getString(dataTable.cell(0,0)),dataTable.cell(1,0));
        Assert.assertEquals(response.body().jsonPath().getString(dataTable.cell(0,1)),dataTable.cell(1,1));
    }

    @When("User sets following details in request body")
    public void user_sets_follwing_details_in_request_body(io.cucumber.datatable.DataTable dataTable) {
        String request_body = "{\"" + dataTable.cell(0, 0) + "\":\"" + dataTable.cell(1, 0) + "\",\"" + dataTable.cell(0, 1) + "\":\"" + dataTable.cell(1, 1) + "\"}";
        System.out.println(request_body);
        obj.set_request_body(request_body);
    }

    @When("User sets the following details in booking request body")
    public void userSetsTheFollowingDetailsInRequestBody(DataTable dataTable) {
        String requestBody = "{\""+dataTable.cell(0,0)+"\":\""+dataTable.cell(1,0)+"\",\""+dataTable.cell(0,1)+"\":\""+dataTable.cell(1,1)+"\",\""+dataTable.cell(0,2)+"\":"+Integer.parseInt(dataTable.cell(1,2))+",\""+dataTable.cell(0,3)+"\":"+Boolean.valueOf(dataTable.cell(1,3))+",\"bookingdates\":{\""+dataTable.cell(0,4)+"\":\""+dataTable.cell(1,4)+"\",\""+dataTable.cell(0,5)+"\":\""+dataTable.cell(1,5)+"\"},\""+dataTable.cell(0,6)+"\":\""+dataTable.cell(1,6)+"\"}";
         obj.set_request_body(requestBody);
    }
}
