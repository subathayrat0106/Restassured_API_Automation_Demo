package twitterAPI.tweetRequest;

public class Resources {

		public static String postATweetResource() {
			return "/statuses/update.json";
		}
		
		public static String deleteATweetResource(String parametersName) {
			return String.format("/statuses/destroy/{%s}.json", parametersName);
		}
		
		public static String showAtweetResource() {
			return "/statuses/show.json";
		}
		
		public static String retweetResource(String parametersName) {
			return String.format("/statuses/retweet/{%s}.json", parametersName);
		}
		
		public static String unRetweetResource(String parametersName) {
			return String.format("/statuses/unretweet/{%s}.json", parametersName);
		}
		
		public static String likATweetResource() {
			return "/favorites/create.json";
		}
		
		public static String unlikATweetResource() {
			return "/favorites/destroy.json";
		}
}
