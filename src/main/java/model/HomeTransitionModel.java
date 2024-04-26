package model;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.PersonCanEditController;
import views.DirectoryController;
import views.LoginPageController;

public class HomeTransitionModel {
	BorderPane mainview;
	
	public HomeTransitionModel(BorderPane view) {
		mainview = view;
	}
	
	public void showHome() {
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(HomeTransitionModel.class
	        .getResource("../views/PersonCanEditView.fxml"));
	    try {
	      Node view = (Node)loader.load();
	      PersonCanEditController cont = loader.getController();
	      SessionSingleton currentSession = SessionSingleton.getInstance();
		  PersonModel model = new PersonModel(currentSession.getUserId());
	  	  PersonTransitionModel personTransitionModel = new PersonTransitionModel(mainview);
	      cont.setModel(model,personTransitionModel);
	      mainview.setCenter(view);

	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
	public void showSearch() {
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(HomeTransitionModel.class
	        .getResource("../views/Directory.fxml"));
	    try {
	      Node view = (Node)loader.load();
	      DirectoryController cont = loader.getController();
	      DirectoryTransitionModel transitionModel = new DirectoryTransitionModel(mainview);
	      cont.setModel(transitionModel);
	      mainview.setCenter(view);
	      
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
	public void showLogin() {
	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(HomeTransitionModel.class
	        .getResource("../views/LoginPage.fxml"));
	    try {
	      Pane view = loader.load();

	      LoginPageController cont = loader.getController();
	  	  LoginNavigationModel loginNavigationModel = new LoginNavigationModel(mainview);
	      cont.setModel(loginNavigationModel);
	      mainview.setTop(null);
	      mainview.setCenter(view);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
}
