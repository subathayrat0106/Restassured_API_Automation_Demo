package apiproject.admin_route;

public class Resources {

		public static String signUpResource() {
			return "/admin/signUp";
		}
		
		public static String loginResource() {
			return "/admin/login";
		}
		
		public static String deleteResource(String adminId) {
			return "/admin/delete/" + adminId;
		}
}
