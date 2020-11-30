package automation.tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import automation.utils.Helper;
import automation.utils.models.User;
import static io.restassured.RestAssured.*;
import org.apache.http.HttpStatus;

public class ApiTest {

	private String user = "automation@keepitqa.com";
	private String password = "E#*b2wGIbFHz";
	private String userId = "zhc4v6-5ev7di-9hhhlm";
	private String url = String.format("https://ws-test.keepit.com/users/%s", userId);

	private User expectedUser = User.newBuilder()
			.setEnabled(true)
			.setCreated("2019-02-28T13:07:49Z")
			.setProduct("7dwqnq-5cvrcm-1z3ehj")
			.setParent("80ltks-yhfls5-24zyf2")
			.setSubscribed(true)
			.build();

	@Test
	public void getRespseBody() {

		String responseString = 
				given()
					.auth()
					.basic(user, password)
				.when()
					.get(url)
				.then()
					.assertThat()
					.statusCode(HttpStatus.SC_OK)
					.extract()
					.asString();
		
		User user = Helper.converXmlToUser(responseString);

		Assert.assertEquals(user, expectedUser);
	}
}
