package testcase;
import base.AbstractApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ApiUtils;

public class ApiEndpointTest extends AbstractApi {

    @Test
    public void GetEndpoint() {
        Response response = ApiUtils.getRequest("/endpoint");
        Assert.assertEquals(response.getStatusCode(), 300);
    }
}