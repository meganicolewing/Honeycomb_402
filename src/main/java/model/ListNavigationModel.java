package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import views.PersonCanEditController;
import views.PageCanEditController;
import sprint1.Page;
import sprint1.Person;
import sprint1.Storage;


public class ListNavigationModel extends RecommendationTransition{
	public ListNavigationModel(BorderPane view) {
		super(view);
	}
	public void showPage(Page p) {
	    SessionSingleton current = SessionSingleton.getInstance();
	    PageModel model;
		if(p.getClass().getName().equals("sprint1.Person")) {
			model = new PersonModel(p.getId());
		}
		else {
			model = new PageModel(p.getId());
		}
		Person user = (Person)Storage.pull(current.getUserId());

		if(!user.canView(p)) {
			showNoView();
		}
		else {
			if(user.canEdit(p)) {
				if(user.getInternalLinks("follower").contains(p.getId())) {
					showFollowed(model);
				}
				else {
					showUneditable(model);
				}
			}
			else if(user.getInternalLinks("follower").contains(p.getId())) {
				showFollowedNoEdit(model);
			}
			else {
				showNoEdit(model);
			}
			showRecommendations(p);
		}
	}
	public void showUneditable(PageModel p)
	{
		String filepath = "../views/PageCanEdit.fxml";
		boolean isPerson = false;
		if(p.getClass().getName().equals("model.PersonModel")) {
			filepath = "../views/PersonCanEditView.fxml";
			isPerson = true;
		}
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource(filepath));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      if(isPerson) {
			    	  PersonCanEditController cont = loader.getController();
			    	  PersonTransitionModel transition = new PersonTransitionModel(mainview);
				      cont.setModel((PersonModel)p,transition);	
			      }
			      else {
				      PageCanEditController cont = loader.getController();
				      PageTransitionModel transition = new PageTransitionModel(mainview);
				      cont.setModel(p,transition);	
			      }
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showFollowed(PageModel p)
	{
		String filepath = "../views/PageFollowedCanEditView.fxml";
		boolean isPerson = false;
		if(p.getClass().getName().equals("model.PersonModel")) {
			filepath = "../views/PersonFollowedCanEdit.fxml";
			isPerson = true;
		}
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource(filepath));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      if(isPerson) {
			    	  PersonCanEditController cont = loader.getController();
			    	  PersonTransitionModel transition = new PersonTransitionModel(mainview);
				      cont.setModel((PersonModel)p,transition);	
			      }
			      else {
				      PageCanEditController cont = loader.getController();
				      PageTransitionModel transition = new PageTransitionModel(mainview);
				      cont.setModel(p,transition);	
			      }
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}	
	public void showFollowedNoEdit(PageModel p)
	{
		String filepath = "../views/PageFollowedView.fxml";
		boolean isPerson = false;
		if(p.getClass().getName().equals("model.PersonModel")) {
			filepath = "../views/PersonFollowedView.fxml";
			isPerson = true;
		}
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource(filepath));
		 
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      if(isPerson) {
			    	  PersonCanEditController cont = loader.getController();
			    	  PersonTransitionModel transition = new PersonTransitionModel(mainview);
				      cont.setModel((PersonModel)p,transition);	
			      }
			      else {
				      PageCanEditController cont = loader.getController();
				      PageTransitionModel transition = new PageTransitionModel(mainview);
				      cont.setModel(p,transition);	
			      }
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showNoEdit(PageModel p)
	{
		String filepath = "../views/PageView.fxml";
		boolean isPerson = false;
		if(p.getClass().getName().equals("model.PersonModel")) {
			filepath = "../views/PersonView.fxml";
			isPerson = true;
		}
		FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(PersonTransitionModel.class
			        .getResource(filepath));
			    try {
			      Node view = loader.load();
			      mainview.setCenter(view);
			      if(isPerson) {
			    	  PersonCanEditController cont = loader.getController();
			    	  PersonTransitionModel transition = new PersonTransitionModel(mainview);
				      cont.setModel((PersonModel)p,transition);	
			      }
			      else {
				      PageCanEditController cont = loader.getController();
				      PageTransitionModel transition = new PageTransitionModel(mainview);
				      cont.setModel(p,transition);	
			      }
			    } catch (IOException e) {
			      // TODO Auto-generated catch block
			      e.printStackTrace();
			    }		
	}
	public void showNoView() {
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
