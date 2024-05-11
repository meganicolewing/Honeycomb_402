package model;

import java.util.ArrayList;

import sprint1.Page;
import sprint1.Storage;

public class RecommendationModel {
	String[] recommendedNames;
	String[] recommendedIds;
	
	public RecommendationModel(Page page) {
		recommendedIds = new String[5];
		recommendedNames = new String[5];
		ArrayList<String> recommendations = page.findRecommendations();
		Page user = Storage.pull(SessionSingleton.getInstance().getUserId());
		ArrayList<String> userFollows = user.getInternalLinks("follower");
		int index = 0;
		int i = 0;
		while(index<5 && i<recommendations.size()) {
			String rec = recommendations.get(i);
			i++;
			if(!userFollows.contains(rec)) {
				recommendedIds[index] = rec;
				Page recPage = Storage.pull(rec);
				//recommendedNames[index] = new SimpleStringProperty();
				//recommendedNames[index].setValue(recPage.getName());
				recommendedNames[index] = recPage.getName();
				index++;
			}
		}
	}

	public String[] getRecommendedNames() {
		return recommendedNames;
	}

	public void setRecommendedNames(String[] recommendedNames) {
		this.recommendedNames = recommendedNames;
	}

	public String[] getRecommendedIds() {
		return recommendedIds;
	}

	public void setRecommendedIds(String[] recommendedIds) {
		this.recommendedIds = recommendedIds;
	}
	

}
