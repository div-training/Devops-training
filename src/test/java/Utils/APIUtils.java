package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils {

    String Base_URL;
    RequestSpecification request=  RestAssured.given();;

    public  void set_uri(String endpoint)
    {
        try {
            Base_URL = ConfigUtil.getValue("Base_url1");
            request.baseUri(Base_URL+endpoint);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void setBase_URL(String baseUrl,String endpoint)
    {
            request.baseUri(baseUrl+endpoint);
    }
    public Response execute_api(String method)
    {
        Response response=null;
        request.contentType(ContentType.JSON);
        if(method.equalsIgnoreCase("GET"))
            response = request.get();
        else  if(method.equalsIgnoreCase("POST"))
            response = request.post();
        else  if(method.equalsIgnoreCase("PUT"))
            response = request.put();
        else  if(method.equalsIgnoreCase("DELETE"))
            response = request.delete();

        return response;

    }

    public  void set_request_body(String request_body)
    {
        request.body(request_body);
    }
}
