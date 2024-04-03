package sprint1;


public class Project extends Page {
	private static final String[] rolesIs = {"project","follower"};
	private static final String[] linksHas = {"contributor","editor","mentor","viewer"};
	public Project(String name) {
		super(name);
	}
	public Project(PageDesc p) {
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
