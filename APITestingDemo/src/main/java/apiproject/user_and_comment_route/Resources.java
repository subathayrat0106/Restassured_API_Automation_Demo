package apiproject.user_and_comment_route;

public class Resources {

		public static String getAllUsersResource() {
			return "/user";
		}
		
		public static String postAUserResource() {
			return "/user";
		}
		
		public static String getAUserInfo(String userId) {
			return "/user/" + userId;
		}
		
		public static String updateAllUserInfo(String userId) {
			return "/user/update/" + userId;
		}
		
		public static String updateOneUserInfo(String userId) {
			return "/user/patch/" + userId;
		}
		
		public static String deleteOneUser(String userId) {
			return "/user/delete/" + userId;
		}
		 
		public static String postACommentToAUser(String userId) {
			return "/user/" + userId + "/comment";
		}
		
		public static String getACommentOfAUser(String userId, String commentId) {
			return "/user/" + userId + "/comment" + commentId;
		}
		
		public static String updateAComment(String userId, String commentId) {
			return "/user/" + userId + "/comment/update/" + commentId;
		}
		
		public static String deleteAComment(String userId, String commentId) {
			return "/user/" + userId + "/comment/delete/" + commentId;
		}
}
