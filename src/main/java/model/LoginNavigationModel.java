package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import views.HomeBarController;
import views.LoginPageController;
import views.PersonCanEditController;

public class LoginNavigationModel extends RecommendationTransition implements LoginNavigationModelInterface 
{
	
	 public LoginNavigationModel(BorderPane view)
	 {
	    super(view);
	 }
	@Override
	public void showLogin()
	{
			    FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(LoginNavigationModel.class
			        .getResource("../views/LoginPage.fxml"));
			    try {
			      Pane view = loader.load();
			      mainview.setCenter(view);
			      LoginPageController cont = loader.getController();
			      cont.setModel(this);
			      
			      
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
	}
	
	@Override
	public void showHomepage()
	{
	    FXMLLoader homeLoader = new FXMLLoader();
	    FXMLLoader personLoader = new FXMLLoader();

	    
	    try {
	    	
	    //set top
		  homeLoader.setLocation(LoginNavigationModel.class
			      .getResource("../views/Home.fxml"));

	      Pane topBanner = homeLoader.load();
	      HomeBarController cont = homeLoader.getController();
	  	  HomeTransitionModel homeTransitionModel = new HomeTransitionModel(mainview);
	      cont.setModel(homeTransitionModel);
	      mainview.setTop(topBanner);
	      
	    //set center
		  personLoader.setLocation(LoginNavigationModel.class
			      .getResource("../views/PersonCanEditView.fxml"));

	      Node center = (Node)personLoader.load();
	      PersonCanEditController personCont = personLoader.getController();
	      SessionSingleton currentSession = SessionSingleton.getInstance();
	      //System.out.println(currentSession.getUserId());
		  PersonModel personModel = new PersonModel(currentSession.getUserId());
	  	  PersonTransitionModel personTransitionModel = new PersonTransitionModel(mainview);
	      personCont.setModel(personModel, personTransitionModel);
	      mainview.setCenter(center);	      
	      showRecommendations(personModel);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}

}
