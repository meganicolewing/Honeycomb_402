package sprint1;


public class JobPosting extends Page {
	private static final String[] rolesIs = {"job","recommended"};
	private static final String[] linksHas = {"skill","contributor","applicant","editor","mentor","viewer"};
	public JobPosting(String name) {
		super(name);
	}
	public JobPosting(PageDesc p) {
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
	public void recommend(Recommender r) throws InvalidLinkException {
		Person[] people = Storage.pullPeople();
		for(int i = 0; i<people.length; i++) {
			System.out.println(people[i].getId());
			if(r.isQualified(this, people[i])) {
				people[i].addInternalLink("recommended", this);
			}
		}
		System.out.println(people[0].getInternalLinks());
	}
}
