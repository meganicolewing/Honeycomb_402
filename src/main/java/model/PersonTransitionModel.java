package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.PersonCanEditController;
import views.PersonEditController;

public class PersonTransitionModel extends RecommendationTransition
{
	public PersonTransitionModel(BorderPane view)
	{
		super(view);
	}
	
	public void showEditable(PersonModel model)
	{
		mainview.setBottom(null);
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonEditController cont = loader.getController();
			      cont.setModel(model,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showUneditable(PersonModel model)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonCanEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			      showRecommendations(model);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showFollowed(PersonModel model)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonFollowedCanEdit.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			      showRecommendations(model);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}	
	public void showFollowedNoEdit(PersonModel model)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonFollowedView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			      showRecommendations(model);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showNoEdit(PersonModel model)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonCanEditController cont = loader.getController();
			      cont.setModel(model,this);
			      showRecommendations(model);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
}
