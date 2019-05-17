package apiproject_testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiproject.company_route.CompanyRouteRequests;
import apiproject.company_route.Payload;
import io.restassured.response.Response;
import utilities.JSONPath;

public class CompanyRouteTest extends BaseTest{
	
	private String company_id = "CompanyId";
	@Test(enabled = false,
			priority = 1)
	public void createACompany() {
		String body = Payload.companyPayload(
				getCompanyName(), getCompanySuffix(),
				getCompanyUrl(), getCompanyAccountName(), getCompanyAccountNumber());
		Response response = CompanyRouteRequests.createOneCompanyRequest(body);
		System.out.println(response.asString());
		String id = JSONPath.covertToJSON(response).get("createdUser._id").toString();
		prop.setProperty(company_id, id);	
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "Created company successfully");
	}
	
	@Test
	(enabled = true,
	priority = 2)
	public void getInfoOfACompany() {
		String companyId = prop.readProperty(company_id);
		Response response = CompanyRouteRequests.getOneCompanyInfoRequest(companyId);
		System.out.println(response.asString());
		String json_id = JSONPath.covertToJSON(response).get("company._id").toString();
		Assert.assertEquals(json_id, companyId);
	}
	
	@Test
	(enabled = false,
	priority = 3)
	public void updateACompany() {
		String companyId = prop.readProperty(company_id);
		String body = Payload.companyPayload_JsonObject(
				getCompanyName(), getCompanySuffix(),
				getCompanyUrl(), getCompanyAccountName(), getCompanyAccountNumber());
		System.out.println(body);
		Response response = CompanyRouteRequests.updateOneCompanyRequest(companyId, body);
		
		System.out.println(response.asString());
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "Company updated");
	}
	
	@Test
	(enabled = false,
	priority = 4)
	public void deleteACompany() {
		String companyId = prop.readProperty(company_id);
		Response response = CompanyRouteRequests.deleteOneCompanyRequest(companyId);
		System.out.println(response);
		System.out.println(response.asString());
		String message = JSONPath.covertToJSON(response).get("message").toString();
		Assert.assertEquals(message, "Company deleted");
	}
}
