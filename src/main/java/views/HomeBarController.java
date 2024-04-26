package views;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import model.HomeTransitionModel;
import model.SessionSingleton;

public class HomeBarController {

	HomeTransitionModel model;
	
	public void setModel(HomeTransitionModel newModel) {
		model = newModel;
	}
	
    @FXML
    void onClickHome(ActionEvent event) {
    	model.showHome();
    }

    @FXML
    void onClickLogout(ActionEvent event) {
    	SessionSingleton currentSession = SessionSingleton.getInstance();
    	currentSession.endSession();
    	model.showLogin();
    }

    @FXML
    void onClickSearch(ActionEvent event) {
    	model.showSearch();
    }

}
