package views;

import javafx.fxml.FXML;
import model.DirectoryTransitionModel;
import javafx.event.ActionEvent;

public class DirectoryController {

	DirectoryTransitionModel dirModel;
	
	public void setModel(DirectoryTransitionModel dirModel) {
		this.dirModel = dirModel;
	}
    @FXML
    void onClickAll(ActionEvent event) {
    	dirModel.showAllPages();
    }

    @FXML
    void onClickMyLinks(ActionEvent event) {
    	dirModel.showLinkPages();
    }

}
