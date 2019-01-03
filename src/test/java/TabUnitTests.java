import com.jayway.restassured.RestAssured;
import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import com.jayway.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class TabUnitTests {
    public String xUserId = "5ba8b2e23e46833651fdf9f9";


    @Before
    public void setBaseUri(){
        RestAssured.baseURI = "http://10.81.2.222:8181";
    }

    @Test
    public void getTabUnAuth(){
    /*    given().log().all().when().get("/api/traffic/v1/tab").then().statusCode(400).assertThat()
                .body(equalTo("Request is missing required HTTP header 'X-User-Id'"));
*/
       Response response =  given().log().all().when().header("X-User_Id","").get("/api/traffic/v1/tab").then()
                .log().all().statusCode(400).extract().response();
        System.out.println(response.asString());




    }

    @Test
    public void getAuthTab(){
        File f = File("")
        JsonSchemaValidator asd =  matchesJsonSchemaInClasspath("C:\\Users\\Faiyyaz.Shaik\\restassuredwithoutbdd\\src\\test\\java\\resources\\schema\\Tab.json");
//        System.out.println(this.getClass().getResource("/").getPath());
        given().log().all().when().header("X-User-Id", xUserId).get("/api/traffic/v1/tab").then()
            //  .log().all().assertThat().body(matchesJsonSchemaInClasspath("C:\\Users\\Faiyyaz.Shaik\\restassuredwithoutbdd\\src\\test\\java\\resources\\schema\\Tab.json"));
                .log().all().assertThat().body(matchesJsonSchemaInClasspath("C:\\Users\\Faiyyaz.Shaik\\restassuredwithoutbdd\\src\\test\\java\\resources\\schema\\Tab.json"));
                //.body(matchesJsonSchemaInClasspath(System.getProperty("user.dir")+"\\Tab.json"));

    //    C:\Users\Faiyyaz.Shaik\restassuredwithoutbdd\src\test\java\resources\schema\Tab.json

    }









}
