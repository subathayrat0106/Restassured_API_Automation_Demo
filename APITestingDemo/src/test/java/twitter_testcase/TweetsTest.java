package twitter_testcase;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import twitterAPI.tweetRequest.GETRequest;
import twitterAPI.tweetRequest.POSTRequest;
import utilities.JSONPath;

public class TweetsTest extends BaseTest{
	
	private String tweetID = "TweetID";

	@Test(enabled = true,
			priority = 1)
	public void postATweet() {
		Response response = POSTRequest.postATweet("this is for the like");
		String id = JSONPath.covertToJSON(response).get("id").toString();
		prop.setProperty(tweetID, id);			
	}
	
	@Test(enabled = true,
			priority = 2)
	public void showATweet() {
		Response response = GETRequest.getSingleTweet(prop.readProperty(tweetID));
		String text = JSONPath.covertToJSON(response).get("text").toString();
		System.out.println(text);
	}
	
	@Test(enabled = true,
			priority = 3)
	public void retweetATweet() {
		Response response = POSTRequest.retweetATweet(prop.readProperty(tweetID));
		String text = JSONPath.covertToJSON(response).get("retweeted_status").toString();
		System.out.println(text);
	}
	
	@Test(enabled = true,
			priority = 4)
	public void unretweetATweet() {
		Response response = POSTRequest.unRetweetATweet(prop.readProperty(tweetID));
		String text = JSONPath.covertToJSON(response).get("id").toString();
		System.out.println(text);
	}
	
	@Test(enabled = true,
			priority = 5)
	public void likeATweet() {
		Response response = POSTRequest.likeATweet(prop.readProperty(tweetID));
		String text = JSONPath.covertToJSON(response).get("user").toString();
		System.out.println(text);
	}
	
	@Test(enabled = true,
			priority = 6)
	public void unlikeATweet() {
		Response response = POSTRequest.unlikeATweet(prop.readProperty(tweetID));
		String text = JSONPath.covertToJSON(response).get("user").toString();
		System.out.println(text);
	}
	
	@Test(enabled = true,
			priority = 7)
	public void deleteATweet() {
		Response response = POSTRequest.deleteATweet(prop.readProperty(tweetID));
		String newassert = JSONPath.covertToJSON(response).get("truncated").toString();
		System.out.println(newassert);
	}
}
