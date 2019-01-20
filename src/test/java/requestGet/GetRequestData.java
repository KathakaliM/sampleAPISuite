package requestGet;

import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRequestData<url> {
	String access_key = "4dcbd1fc3bb1d2d379d43405d0a28804";

	String url = "http://apilayer.net/api/validate?access_key=" + access_key + "&number=918147923712&format=1";
	String url2 = "http://apilayer.net/api/validate?access_key=" + access_key + "&number=918040298481&format=1";
	String url3 = "http://apilayer.net/api/validate?access_key=" + access_key + "&number=18001021122&format=1";

	String urlJSONP = "http://apilayer.net/api/validate?access_key=" + access_key
			+ "&number=918147923712&callback=CALLBACK_FUNCTION&format=1";
	String countryEndpoint = "http://apilayer.net/api/countries?access_key=" + access_key
			+ "&number=14158586273&format=1";
	String countryNational_local = "http://apilayer.net/api/validate?access_key=" + access_key
			+ "&number=4158586273&country_code=US&format=1";
	String responseBody;

	@Test(priority = 1)
	public void numberValidation() {
		//validate number(mobile,landline,toll-free) and country_location data
		responseBody = get(url).asString();
		int code = get(url).getStatusCode();
		System.out.println("Status code: " + code);
		System.out.println("Response body: " + responseBody);
		Reporter.log("Response body :" + responseBody);
		Reporter.log("Status Code : " + code);
		boolean mob_num = responseBody.contains("\"line_type\":\"mobile\"");
		System.out.println("line_type is 'mobile':" + mob_num);
		Reporter.log("Verify line_type feature is 'mobile': " + mob_num);
		boolean count_loc_data = responseBody
				.contains("\"country_name\":\"India (Republic of)\",\r\n" + "  \"location\":\"Karnataka\",");
		Reporter.log("Verify country and location data feature :" + count_loc_data);
		Reporter.log("-----------------------------------------------------");

		responseBody = get(url2).asString();
		int code1 = get(url2).getStatusCode();
		System.out.println("Code " + code1);
		System.out.println("Code " + responseBody);
		Reporter.log("Response body :" + responseBody);
		Reporter.log("Status code :" + code1);
		boolean land_num = responseBody.contains("\"line_type\":\"landline\"");
		System.out.println("line_type is 'mobile':" + land_num);
		Reporter.log("Verify line_type is 'landline': " + land_num);
		Reporter.log("-----------------------------------------------------");

		responseBody = get(url3).asString();
		int code2 = get(url3).getStatusCode();
		System.out.println("Code " + code2);
		System.out.println("Code " + responseBody);
		Reporter.log("Response body :" + responseBody);
		Reporter.log("Status code :" + code2);
		boolean toolfree_num = responseBody.contains("\"line_type\":\"toll_free\"");
		System.out.println("line_type is 'mobile':" + toolfree_num);
		Reporter.log("Verify line_type is 'landline': " + toolfree_num);
		Reporter.log("-----------------------------------------------------");

	}

	@Test(priority = 2)
	public void testJSONP_Feature() {
		
		responseBody = get(urlJSONP).asString();
		System.out.println("Response is: " + responseBody);

		Reporter.log("JSONP  Response is: " + responseBody);

		boolean call_back = responseBody.contains("CALLBACK_FUNCTION(");

		if (call_back = true && call_back != false) {
			Reporter.log("Response body is wrapped with CALLBACK_FUNCTION specified: " + call_back);
		} else {
			System.out.println("false");
		}
		
	}

	 @Test(priority = 3)
	public void test_CountryEndpoint_Feature() {
		responseBody = get(countryEndpoint).asString();
		int code3 = get(countryEndpoint).getStatusCode();
		Reporter.log("Status Code : " + code3);
		System.out.println("Response is: " + responseBody);

		Reporter.log("Country endpoint  Response is: " + responseBody);

		
	}

	@Test(priority = 4)
	public void test_Local_Num_Feature() {
		responseBody = get(countryNational_local).asString();
		int code4 = get(countryNational_local).getStatusCode();
		Reporter.log("Status Code : " + code4);
		System.out.println("Response is: " + responseBody);

		Reporter.log(" Response is: " + responseBody);
		boolean national_num = responseBody.contains("\"local_format\":\"4158586273\"");
		Reporter.log("Verify National (Local) Numbers feature: " + national_num);
		
	}

}
