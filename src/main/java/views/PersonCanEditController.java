package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.PersonModel;
import model.PersonTransitionModel;
import model.SessionSingleton;
import sprint1.InvalidLinkException;
import sprint1.Person;
import sprint1.Storage;

public class PersonCanEditController {

	PersonTransitionModel transitionModel;
	PersonModel model;
	
    @FXML
    private Label descriptionLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label pronounsLabel;

    public void setModel(PersonModel newModel, PersonTransitionModel newTransitionModel)
    {
    	transitionModel = newTransitionModel;
    	model = new PersonModel(newModel.getId().getValue());
    	Bindings.bindBidirectional(nameLabel.textProperty(), model.getName());
    	Bindings.bindBidirectional(pronounsLabel.textProperty(), model.getPronouns());
    	Bindings.bindBidirectional(emailLabel.textProperty(), model.getEmail());
    	Bindings.bindBidirectional(phoneLabel.textProperty(), model.getPhone());
    	Bindings.bindBidirectional(descriptionLabel.textProperty(), model.getDescription());
    }
    @FXML
    public void onEditClick(ActionEvent event) {
    	SessionSingleton current = SessionSingleton.getInstance();
    	Person user = (Person)Storage.pull(current.getUserId());
    	if(user.canEdit(model.getPage())) {
    		transitionModel.showEditable(model);
    	}
    	else if(user.getInternalLinks("follower").contains(model.getId().getValue())){
    		transitionModel.showFollowedNoEdit(model);
    	}
    	else {
    		transitionModel.showNoEdit(model);
    	}
    }
    @FXML
    public void onFollowClick(ActionEvent event) {
    	SessionSingleton currentSession = SessionSingleton.getInstance();
    	Person user = (Person)Storage.pull(currentSession.getUserId());
    	try {
			user.addInternalLink("follower", model.getPage());
		} catch (InvalidLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Storage.update(user);
    	user = (Person)Storage.pull(currentSession.getUserId());
    	System.out.println(user.getInternalLinks("follower"));
    	if(user.canEdit(model.getPage())) {
    		transitionModel.showFollowed(model);
    	}
    	else {
    		transitionModel.showFollowedNoEdit(model);
    	}
    }
    @FXML
    public void onUnfollowClick(ActionEvent event) {
      	SessionSingleton currentSession = SessionSingleton.getInstance();
    	Person user = (Person)Storage.pull(currentSession.getUserId());
    	try {
			user.removeInternalLink("follower", model.getPage());
		} catch (InvalidLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Storage.update(user);
    	if(user.canEdit(model.getPage())) {
		    transitionModel.showUneditable(model);
    	}
    	else {
    		transitionModel.showNoEdit(model);
    	}    
    }
}
