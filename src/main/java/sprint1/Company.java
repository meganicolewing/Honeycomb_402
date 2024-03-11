package sprint1;

public class Company extends Page {
	private static final String[] roles = {"contributor"};
	private static final String[] links = {"employee","follower","project","job","editor","mentor","viewer"};
	public Company(String name) {
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
