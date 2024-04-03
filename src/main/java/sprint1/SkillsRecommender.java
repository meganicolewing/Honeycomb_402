package sprint1;

import java.util.ArrayList;


public class SkillsRecommender implements Recommender {

	@Override
	public boolean isQualified(JobPosting j, Person p) {
		boolean hasSkills = true;
		ArrayList<String> jobSkills = j.getInternalLinks("skill");
		ArrayList<String> personSkills = p.getInternalLinks("skill");
		for(String skill: jobSkills) {
			hasSkills = hasSkills & personSkills.contains(skill);
		}
		return hasSkills;
	}

}
