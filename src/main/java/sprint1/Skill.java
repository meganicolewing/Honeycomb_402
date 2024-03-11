package sprint1;

public class Skill extends Page {
	private static final String[] roles = {"skill"};
	private static final String[] links = {"project","news","follower","editor","mentor","viewer"};
	public Skill(String name) {
		super(name);
	}
	@Override
	public String[] getRoles() {
		return roles;
	}
	@Override
	public String[] getLinks() {
		return links;
	}

}
