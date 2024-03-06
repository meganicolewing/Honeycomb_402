package sprint1;

public class NewsArticle extends Page {
	private static final String[] roles = {"news"};
	private static final String[] links = {"contributor"};
	public NewsArticle(String name) {
		super(name, links);
	}
	public String[] getRoles() {
		return roles;
	}
	@Override
	public String[] getLinks() {
		return links;
	}
}
