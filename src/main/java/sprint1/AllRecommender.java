package sprint1;

public class AllRecommender implements Recommender {

	@Override
	public boolean isQualified(JobPosting j, Person p) {
		return true;
	}

}
