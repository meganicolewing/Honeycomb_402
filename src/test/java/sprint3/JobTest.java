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
import main.Main;
import model.HomeTransitionModel;
import model.PageModel;
import model.PageTransitionModel;
import model.SessionSingleton;
import sprint1.InvalidLinkException;
import sprint1.Page;
import sprint1.PageDesc;
import sprint1.Person;
import sprint1.Storage;
import views.HomeBarController;
import views.PageCanEditController;

@ExtendWith(ApplicationExtension.class)
public class JobTest {
	BorderPane view;
	@Start //before
	private void start(Stage stage) {
		Reseter.reset();
		Person user0 = (Person)Storage.pull("0");
		Page thisPage = Storage.pull("6");
		try {
			user0.removeInternalLink("recommended",thisPage);
		} catch (InvalidLinkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FXMLLoader loader = new FXMLLoader();
		view = new BorderPane();
		loader.setLocation(Main.class.getResource("../views/Home.fxml"));
		try {
			Node top = (Node)loader.load();
			view.setTop(top);
			HomeBarController cont = loader.getController();
			HomeTransitionModel navigation = new HomeTransitionModel(view);
			cont.setModel(navigation);
			newUser("6");
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAllRecommend(FxRobot robot) {
		editAll(robot,"all");
		for(int i = 0; i<5; i++) {
			Person person = (Person)Storage.pull(i+"");
			Assertions.assertThat(person.getInternalLinks("recommended")).contains("6");
		}
	}
	
	@Test
	public void testSkillRecommend(FxRobot robot) {
		editAll(robot,"skills");
		for(int i = 0; i<5; i++) {
			Person person = (Person)Storage.pull(i+"");
			if(i == 2 || i == 3) {
				Assertions.assertThat(person.getInternalLinks("recommended")).contains("6");
			}
			else {
				Assertions.assertThat(person.getInternalLinks("recommended")).doesNotContain("6");
			}
		}
	}
	
	@Test
	public void testFollowingRecommend(FxRobot robot) {
		editAll(robot,"following");
		for(int i = 0; i<5; i++) {
			Person person = (Person)Storage.pull(i+"");
			if(i==4 || i==3) {
				Assertions.assertThat(person.getInternalLinks("recommended")).contains("6");
			}
			else {
				Assertions.assertThat(person.getInternalLinks("recommended")).doesNotContain("6");

			}
		}
	}
	
	@Test
	public void testNoneRecommend(FxRobot robot) {
		editAll(robot,"none");
		for(int i = 0; i<5; i++) {
			Person person = (Person)Storage.pull(i+"");
			Assertions.assertThat(person.getInternalLinks("recommended")).doesNotContain("6");
		}
	}
	
	@Test
	public void testCancelRecommend(FxRobot robot) {
		cancelAll(robot,"all");
		for(int i = 0; i<5; i++) {
			Person person = (Person)Storage.pull(i+"");
			//System.out.println(i+" "+person.getInternalLinks("recommended"));
			Assertions.assertThat(person.getInternalLinks("recommended")).doesNotContain("6");
		}
	}
	
	private void editField(FxRobot robot, String field, String newValue) {
		robot.doubleClickOn("#"+field+"Field");
		robot.clickOn("#"+field+"Field");
		robot.write(newValue);
	}
	
	private void editAll(FxRobot robot,String recommend) {
		robot.clickOn("#editButton");
		Page page;
		editField(robot,"name","zero");
		editField(robot,"description","hello i'm zero");
		robot.clickOn("#"+recommend+"Radio");
		
		robot.clickOn("#updateButton");
		
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText("zero");
		page = Storage.pull("6");
		Assertions.assertThat(page.getName()).isEqualTo("zero");

		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText("hello i'm zero");
		page = Storage.pull("6");
		Assertions.assertThat(page.getDescription()).isEqualTo("hello i'm zero");
	}
	
	private void cancelAll(FxRobot robot,String recommend) {
		robot.clickOn("#editButton");
		Page page = Storage.pull("6");
		PageDesc initial = new PageDesc(page);
		editField(robot,"name","hj ewl");
		editField(robot,"description","cgetrw");
		robot.clickOn("#"+recommend+"Radio");
		robot.clickOn("#cancelButton");
		
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText(initial.name());
		page = Storage.pull("6");
		Assertions.assertThat(page.getName()).isEqualTo(initial.name());

		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText(initial.description());
		page = Storage.pull("6");
		Assertions.assertThat(page.getDescription()).isEqualTo(initial.description());
	
	}
	
	private void newUser(String id) {
		SessionSingleton.getInstance().startSession("1", "1");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/PageCanEdit.fxml"));
		try {
			Node center = (Node)loader.load();
			PageCanEditController cont2 = loader.getController();
			PageModel model = new PageModel(id);
			PageTransitionModel navigation2 = new PageTransitionModel(view);
			cont2.setModel(model,navigation2);
			view.setCenter(center);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
