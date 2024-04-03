package sprint1;

import java.util.ArrayList;

public class FollowingRecommender implements Recommender {

	@Override
	public boolean isQualified(JobPosting j, Person p) {
		ArrayList<String> jobCompany = j.getInternalLinks("contributor");
		ArrayList<String> personCompany = p.getInternalLinks("follower");
		for(String c: jobCompany) {
			if(!personCompany.contains(c)) {
				return false;
			}
		}
		return true;
	}

}
