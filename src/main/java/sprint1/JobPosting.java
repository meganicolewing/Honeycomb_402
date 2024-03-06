package sprint1;

public class JobPosting extends Page {
	private static final String[] roles = {"job"};
	private static final String[] links = {"skill","contributor","applicant"};
	public JobPosting(String name) {
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
