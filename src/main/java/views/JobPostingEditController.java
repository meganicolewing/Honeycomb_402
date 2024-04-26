package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import sprint1.AllRecommender;
import sprint1.FollowingRecommender;
import sprint1.InvalidLinkException;
import sprint1.JobPosting;
import sprint1.Recommender;
import sprint1.SkillsRecommender;


public class JobPostingEditController extends PageEditController {

    @FXML
    private RadioButton noneRadio;

    @FXML
    private RadioButton skillsRadio;
    
    @FXML
    private RadioButton followingRadio;
    
    @FXML
    private RadioButton allRadio;
    
    @Override
    public void onUpdateClick(ActionEvent event) {
    	if(!noneRadio.isSelected()) {
	    	JobPosting job = (JobPosting)this.page.getPage();
	    	Recommender recommender;
	    	if(skillsRadio.isSelected()) {
	    		recommender = new SkillsRecommender();
	    	}
	    	else if(followingRadio.isSelected()) {
	    		recommender = new FollowingRecommender();
	    	}
	    	else{
	    		recommender = new AllRecommender();
	    	}
	    	try {
				job.recommend(recommender);
			} catch (InvalidLinkException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	super.onUpdateClick(event);
    }
}
