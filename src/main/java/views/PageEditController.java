package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.PageModel;
import model.PageTransitionModel;
import model.SessionSingleton;
import sprint1.Person;
import sprint1.Storage;
public class PageEditController{
    @FXML
    private TextArea descriptionField;

    @FXML
    private TextField nameField;
    
    String undoName;
    String undoDescription;
	PageTransitionModel transitionModel;
	PageModel page;
	public void setModel(PageModel newModel, PageTransitionModel transition) {
		transitionModel = transition;
		this.page = new PageModel(newModel.getId().getValue());
    	undoName = page.getName().getValue();
    	undoDescription = page.getDescription().getValue();
		Bindings.bindBidirectional(nameField.textProperty(), page.getName());
    	Bindings.bindBidirectional(descriptionField.textProperty(), page.getDescription());
	}
    @FXML
    public void onUpdateClick(ActionEvent event) {
    	Storage.update(page.getPage());
    	Person user = (Person)Storage.pull(SessionSingleton.getInstance().getUserId());
    	if(user.getInternalLinks("follower").contains(page.getId().getValue())){
    		transitionModel.showFollowed(page);
    	}
    	else {
    		transitionModel.showUneditable(page);
    	}
    }
    public void onCancelClick(ActionEvent event) {
    	page.getName().setValue(undoName);
    	page.getDescription().setValue(undoDescription);
    	Person user = (Person)Storage.pull(SessionSingleton.getInstance().getUserId());
    	if(user.getInternalLinks("follower").contains(page.getId().getValue())){
    		transitionModel.showFollowed(page);
    	}
    	else {
    		transitionModel.showUneditable(page);
    	}
    }
    @FXML
    public void onAddLinkClick(ActionEvent event) {
    	
    }
}
