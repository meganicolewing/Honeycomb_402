package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.JobPostingEditController;
import views.PageCanEditController;
import views.PageEditController;

public class PageTransitionModel extends RecommendationTransition{
	public PageTransitionModel(BorderPane view) {
		super(view);
	}

	public void showEditable(PageModel page)
	{
		mainview.setBottom(null);
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PageEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageEditController cont = loader.getController();
			      cont.setModel(page,this);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showJobPostEditable(PageModel page)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/JobPostingEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      JobPostingEditController cont = loader.getController();
			      cont.setModel(page,this);
			      showRecommendations(page);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showUneditable(PageModel page)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PageCanEdit.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(page,this);
			      showRecommendations(page);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showFollowed(PageModel page)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PageFollowedCanEditView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(page,this);
			      showRecommendations(page);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}	
	public void showFollowedNoEdit(PageModel page)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PageFollowedView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(page,this);
			      showRecommendations(page);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showNoEdit(PageModel page)
	{
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/PageView.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      PageCanEditController cont = loader.getController();
			      cont.setModel(page,this);
			      showRecommendations(page);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showNoView(PageModel page) {
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource("../views/NoPermissionPage.fxml"));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }
	}

}
