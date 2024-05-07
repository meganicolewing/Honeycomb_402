package model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import sprint1.Page;
import sprint1.Storage;
import views.RecommendationsController;

public abstract class RecommendationTransition {
	BorderPane mainview;
	public RecommendationTransition(BorderPane view) {
		mainview = view;
	}
	protected void showRecommendations(Page p) {
		 FXMLLoader linksloader = new FXMLLoader();
		 linksloader.setLocation(PersonTransitionModel.class
				 .getResource("../views/RecommendationsView.fxml"));
		 try {
		      Node bottom = linksloader.load();
		      mainview.setBottom(bottom);
		      RecommendationsController rec = linksloader.getController();
		      ListNavigationModel nav = new ListNavigationModel(mainview);
		      rec.setModel(p, nav);
		 }catch(IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
	}
	protected void showRecommendations(PageModel p) {
		Page thisPage = Storage.pull(p.getId().getValue());
		showRecommendations(thisPage);
	}
}
