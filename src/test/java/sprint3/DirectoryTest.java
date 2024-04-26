package sprint3;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Set;
import main.Main;
import model.DirectoryTransitionModel;
import model.HomeTransitionModel;
import model.SessionSingleton;
import views.DirectoryController;
import views.HomeBarController;

@ExtendWith(ApplicationExtension.class)
public class DirectoryTest {
	BorderPane view;
	@Start //before
	private void start(Stage stage) {
		Reseter.reset();
		SessionSingleton.getInstance().startSession("0", "0");
		FXMLLoader loader = new FXMLLoader();
		view = new BorderPane();
		loader.setLocation(Main.class.getResource("../views/Home.fxml"));
		try {
			Node top = (Node)loader.load();
			view.setTop(top);
			HomeBarController cont = loader.getController();
			HomeTransitionModel navigation = new HomeTransitionModel(view);
			cont.setModel(navigation);
			loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../views/Directory.fxml"));
			Node center = (Node)loader.load();
			DirectoryController cont2 = loader.getController();
			DirectoryTransitionModel navigation2 = new DirectoryTransitionModel(view);
			cont2.setModel(navigation2);
			view.setCenter(center);
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAllPages(FxRobot robot) {
		Set<Label> linkLabels;
		ArrayList<String> linkStrings;
		robot.clickOn("#allButton");
		robot.clickOn("#companyButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			int mod = i%5;
			if(i>4 && mod==0) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}
		}
		robot.clickOn("#personButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i<5) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#jobButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			int mod = i%5;
			if(i>4 && mod==1) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#skillButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			int mod = i%5;
			if(i>4 && mod==4) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#projectButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			int mod = i%5;
			if(i>4 && mod==3) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#newsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			int mod = i%5;
			if(i>4 && mod==2) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
	}
	@Test
	public void testMyLinksList(FxRobot robot) {
		Set<Label> linkLabels;
		ArrayList<String> linkStrings;
		robot.clickOn("#linksButton");
		robot.clickOn("#friendsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==4) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}
		}
		robot.clickOn("#followingButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if((i%5) == 1) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#mentorsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==1) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#skillsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==9) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#jobsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==26) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#projectsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==8) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#newsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==7) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#recommendedButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			if(i==6) {
				Assertions.assertThat(linkStrings).contains(i+"");
			}
			else {
				Assertions.assertThat(linkStrings).doesNotContain(i+"");
			}		
		}
		robot.clickOn("#viewersButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			Assertions.assertThat(linkStrings).doesNotContain(i+"");	
		}
		robot.clickOn("#editorsButton");
		linkLabels = (robot.lookup(".linkLabel").queryAllAs(Label.class));
		linkStrings = new ArrayList<String>();
		for(Label l:linkLabels) {
			linkStrings.add(l.getText());
		}
		for(int i = 0; i < 30; i++) {
			Assertions.assertThat(linkStrings).doesNotContain(i+"");	
		}
	}
	
	@Test
	public void testClickLink(FxRobot robot) {
		robot.clickOn("#allButton");
		robot.clickOn("#companyButton");
		robot.clickOn(".linkButton");
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText("25");
	}
}
