package sprint1;

public class Project extends Page {
	private static final String[] roles = {"project"};
	private static final String[] links = {"contributor","follower","editor","mentor","viewer"};
	public Project(String name) {
		super(name);
	}
	public String[] getRoles() {
		return roles;
	}
	@Override
	public String[] getLinks() {
		return links;
	}
}
