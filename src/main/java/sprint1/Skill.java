package sprint1;


public class Skill extends Page {
	private static final String[] rolesIs = {"skill","follower"};
	private static final String[] linksHas = {"editor","mentor","viewer"};
	public Skill(String name) {
		super(name);
	}
	public Skill(PageDesc p) {
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
