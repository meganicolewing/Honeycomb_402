package model;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.AllPageTypesFlowController;
import views.PersonLinksTypesFlowController;


public class DirectoryTransitionModel 
{
	BorderPane mainview;
	public DirectoryTransitionModel(BorderPane view) {
		mainview = view;
	}
	
	
	public void showAllPages() {
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/AllPageTypesFlowView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      AllPageTypesFlowController cont = loader.getController();
			      cont.setModel(new ListNavigationModel(mainview));
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}

	public void showLinkPages()
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PersonLinksTypesFlowView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PersonLinksTypesFlowController cont = loader.getController();
			      SessionSingleton currentSession = SessionSingleton.getInstance();
				  PersonModel model= new PersonModel(currentSession.getUserId());
				  ListNavigationModel navigation = new ListNavigationModel(mainview);
			      cont.setModel(model,navigation);
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
	}
	
}
