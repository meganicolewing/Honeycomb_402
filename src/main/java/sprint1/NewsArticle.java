package sprint1;


public class NewsArticle extends Page {
	private static final String[] rolesIs = {"news"};
	private static final String[] linksHas = {"contributor","editor","mentor","viewer"};
	public NewsArticle(String name) {
		super(name);
	}
	public NewsArticle(PageDesc p) {
		super(p);
	}
	@Override
	public String[] getRolesIs() {
		return rolesIs;
	}
	@Override
	public String[] getLinksHas() {
		return linksHas;
	}
}
