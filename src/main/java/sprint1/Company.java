package sprint1;


public class Company extends Page {
	private static final String[] rolesIs = {"contributor","follower"};
	private static final String[] linksHas = {"employee","project","job","news","editor","mentor","viewer"};
	public Company(String name) {
		super(name);
	}
	public Company(PageDesc p) {
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
