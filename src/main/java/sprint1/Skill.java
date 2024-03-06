package sprint1;

public class Skill extends Page {
	private static final String[] roles = {"skill"};
	private static final String[] links = {"project","news","follower"};
	public Skill(String name) {
		super(name, links);
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
