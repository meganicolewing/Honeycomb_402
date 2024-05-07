package views;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.ListNavigationModel;
import model.PageModel;
import model.RecommendationModel;
import sprint1.Page;
//import model.RecommendationTransitionModel;
import sprint1.Storage;

public class RecommendationsController {
	
	RecommendationModel model;
	ListNavigationModel transition;
	
	public void setModel(Page page, ListNavigationModel navigation) {
		model = new RecommendationModel(page);
		transition = navigation;
		String[] names = model.getRecommendedNames();
		if(names[0]!=null) {
			label1.setText(names[0]);
			button1.setVisible(true);
		}
		else {
			label1.setText("");
			button1.setVisible(false);
		}
		if(names[1]!=null) {
			label2.setText(names[1]);
			button2.setVisible(true);
		}
		else {
			label2.setText("");
			button2.setVisible(false);
		}
		if(names[2]!=null) {
			label3.setText(names[2]);
			button3.setVisible(true);
		}
		else {
			label3.setText("");
			button3.setVisible(false);
		}
		if(names[3]!=null) {
			label4.setText(names[3]);
			button4.setVisible(true);
		}
		else {
			label4.setText("");
			button4.setVisible(false);
		}
		if(names[4]!=null) {
			label5.setText(names[4]);
			button5.setVisible(true);
		}
		else {
			label5.setText("");
			button5.setVisible(false);
		}
			

	}
	
	public void setModel(PageModel page, ListNavigationModel nav) {
		Page thisPage = Storage.pull(page.getId().getValue());
		this.setModel(thisPage, nav);
	}


    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;
	
    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

	
    @FXML
    void onClickRecommendation1(ActionEvent event) {
    	transition.showPage(Storage.pull(model.getRecommendedIds()[0]));
    }

    @FXML
    void onClickRecommendation2(ActionEvent event) {
    	transition.showPage(Storage.pull(model.getRecommendedIds()[1]));
    }

    @FXML
    void onClickRecommendation3(ActionEvent event) {
    	transition.showPage(Storage.pull(model.getRecommendedIds()[2]));
    }

    @FXML
    void onClickRecommendation4(ActionEvent event) {
    	transition.showPage(Storage.pull(model.getRecommendedIds()[3]));
    }

    @FXML
    void onClickRecommendation5(ActionEvent event) {
    	transition.showPage(Storage.pull(model.getRecommendedIds()[4]));
    }

}
