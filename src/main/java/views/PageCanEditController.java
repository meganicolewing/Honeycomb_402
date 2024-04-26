package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.PageModel;
import model.PageTransitionModel;
import model.SessionSingleton;
import sprint1.InvalidLinkException;
import sprint1.Person;
import sprint1.Storage;

public class PageCanEditController
{
	PageTransitionModel transition;
	PageModel page;
	public void setModel(PageModel newModel, PageTransitionModel transitionModel) {
		transition = transitionModel;
		this.page = new PageModel(newModel.getId().getValue());
    	Bindings.bindBidirectional(nameLabel.textProperty(), page.getName());
    	Bindings.bindBidirectional(descriptionLabel.textProperty(), page.getDescription());
	}
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label nameLabel;
    
    @FXML
    public void onEditClick(ActionEvent event) {
    	SessionSingleton current = SessionSingleton.getInstance();
    	Person user = (Person)Storage.pull(current.getUserId());
    	if(user.canEdit(page.getPage())) {
    		if(Storage.pull(page.getId().getValue()).getClass().getName().equals("sprint1.JobPosting")) {
    			transition.showJobPostEditable(page);
    		}
    		else {
    		transition.showEditable(page);
    		}
    	}
    	else if(user.getInternalLinks("follower").contains(page.getPage().getId())){
    		transition.showFollowedNoEdit(page);
    	}
    	else {
    		transition.showNoEdit(page);
    	}
    }
    @FXML
    public void onFollowClick(ActionEvent event) {
    	SessionSingleton currentSession = SessionSingleton.getInstance();
    	Person user = (Person)Storage.pull(currentSession.getUserId());
    	try {
			user.addInternalLink("follower", page.getPage());
		} catch (InvalidLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Storage.update(user);
    	user = (Person)Storage.pull(currentSession.getUserId());
    	System.out.println(user.getInternalLinks("follower"));
    	if(user.canEdit(page.getPage())) {
    		transition.showFollowed(page);
    	}
    	else {
    		transition.showFollowedNoEdit(page);
    	}
    }
    @FXML
    public void onUnfollowClick(ActionEvent event) {
      	SessionSingleton currentSession = SessionSingleton.getInstance();
    	Person user = (Person)Storage.pull(currentSession.getUserId());
    	try {
			user.removeInternalLink("follower", page.getPage());
		} catch (InvalidLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Storage.update(user);
    	if(user.canEdit(page.getPage())) {
		    transition.showUneditable(page);
    	}
    	else {
    		transition.showNoEdit(page);
    	}    
    }
}
