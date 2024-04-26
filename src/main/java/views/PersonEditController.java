package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.PersonModel;
import model.PersonTransitionModel;
import model.SessionSingleton;
import sprint1.Person;
import sprint1.Storage;

public class PersonEditController {
	PersonModel model;
	PersonTransitionModel transition;
    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField idField;

    @FXML
    private ChoiceBox<?> linksChoices;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField pronounsField;
    
    @FXML
    void onAddLinkClick(ActionEvent event) {

    }
    String undoName;
    String undoPronouns;
    String undoEmail;
    String undoPhone;
    String undoDescription;
    public void setModel(PersonModel newModel, PersonTransitionModel transitionModel)
    {
    	model = new PersonModel(newModel.getId().getValue());
    	transition = transitionModel;
    	
    	undoName = model.getName().getValue();
    	undoPronouns = model.getPronouns().getValue();
    	undoEmail = model.getEmail().getValue();
    	undoPhone = model.getPhone().getValue();
    	undoDescription = model.getDescription().getValue();

    	Bindings.bindBidirectional(nameField.textProperty(), model.getName());
    	Bindings.bindBidirectional(pronounsField.textProperty(), model.getPronouns());
    	Bindings.bindBidirectional(emailField.textProperty(), model.getEmail());
    	Bindings.bindBidirectional(phoneField.textProperty(), model.getPhone());
    	Bindings.bindBidirectional(descriptionField.textProperty(), model.getDescription());

    	
    }
    @FXML
    public void onUpdateClick(ActionEvent event) {
    	Storage.update(model.getPage());
    	Person user = (Person)Storage.pull(SessionSingleton.getInstance().getUserId());
    	if(user.getInternalLinks("follower").contains(model.getId().getValue())){
    		transition.showFollowed(model);
    	}
    	else {
    		transition.showUneditable(model);
    	}
    }
    public void onCancelClick(ActionEvent event) {
    	model.getName().setValue(undoName);
    	model.getPronouns().setValue(undoPronouns);
    	model.getEmail().setValue(undoEmail);
    	model.getPhone().setValue(undoPhone);
    	model.getDescription().setValue(undoDescription);
    	Person user = (Person)Storage.pull(SessionSingleton.getInstance().getUserId());
    	if(user.getInternalLinks("follower").contains(model.getId().getValue())){
    		transition.showFollowed(model);
    	}
    	else {
    		transition.showUneditable(model);
    	}
    }
}
