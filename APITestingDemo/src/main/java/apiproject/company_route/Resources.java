package apiproject.company_route;

public class Resources {
	public static String get_and_postCompanyResource() {
		return "/company";
	}
	
	public static String getOneCompanyResource(String companyId) {
		return "/company/" + companyId;
	}
	
	public static String updateOneCompanyResource(String companyId) {
		return "/company/update/" + companyId;
	}
	
	public static String deleteOneCompanyResource(String companyId) {
		return "/company/delete/" + companyId;
	}
}
