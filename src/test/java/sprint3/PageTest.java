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
import sprint1.Page;
import sprint1.PageDesc;
import sprint1.Person;
import sprint1.Storage;
import views.HomeBarController;
import views.PageCanEditController;

@ExtendWith(ApplicationExtension.class)
public class PageTest {
	BorderPane view;
	@Start //before
	private void start(Stage stage) {
		Reseter.reset();
		FXMLLoader loader = new FXMLLoader();
		view = new BorderPane();
		loader.setLocation(Main.class.getResource("../views/Home.fxml"));
		try {
			Node top = (Node)loader.load();
			view.setTop(top);
			HomeBarController cont = loader.getController();
			HomeTransitionModel navigation = new HomeTransitionModel(view);
			cont.setModel(navigation);
			newUser("5");
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEdit(FxRobot robot) {
		editSingles(robot);
	}
	
	@Test
	public void testCancel(FxRobot robot) {
		cancelSingles(robot);
	}
	
	@Test
	public void testEditAll(FxRobot robot) {
		editAll(robot);
	}
	
	@Test
	public void testCancelAll(FxRobot robot) {
		cancelAll(robot);
	}
	
	@Test
	public void testFollow(FxRobot robot) {
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("5");
		robot.clickOn("#followButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("5");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("5");
	}
	
	@Test
	public void testFollowEditSingles(FxRobot robot) {
		robot.clickOn("#followButton");
		editSingles(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("5");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("5");
	}
	
	@Test
	public void testFollowEditAll(FxRobot robot) {
		robot.clickOn("#followButton");
		editAll(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("5");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("5");
	}
	
	@Test
	public void testFollowCancelSingles(FxRobot robot) {
		robot.clickOn("#followButton");
		cancelSingles(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("5");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("5");
	}
	
	@Test
	public void testFollowCancelAll(FxRobot robot) {
		robot.clickOn("#followButton");
		cancelAll(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("5");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("5");
	}
	
	private void updateField(FxRobot robot, String field) {
		robot.clickOn("#editButton");
		editField(robot, field,field);
		robot.clickOn("#updateButton");
		Assertions.assertThat(robot.lookup("#"+field+"Label").queryAs(Label.class))
		.hasText(field);
	}
	
	private void cancelField(FxRobot robot, String field) {
		String before = robot.lookup("#"+field+"Label").queryAs(Label.class).getText();
		robot.clickOn("#editButton");
		editField(robot, field,"BhHhH");
		robot.clickOn("#cancelButton");
		Assertions.assertThat(robot.lookup("#"+field+"Label").queryAs(Label.class))
		.hasText(before);
	}
	
	private void editField(FxRobot robot, String field, String newValue) {
		robot.doubleClickOn("#"+field+"Field");
		robot.clickOn("#"+field+"Field");
		robot.write(newValue);
	}
	
	private void editSingles(FxRobot robot) {
		Page page = Storage.pull("5");
		updateField(robot,"name");
		page = Storage.pull("5");
		Assertions.assertThat(page.getName()).isEqualTo("name");
		updateField(robot,"description");
		page = Storage.pull("5");
		Assertions.assertThat(page.getDescription()).isEqualTo("description");
	}
	
	private void editAll(FxRobot robot) {
		robot.clickOn("#editButton");
		Page page;
		editField(robot,"name","zero");
		editField(robot,"description","hello i'm zero");
		
		robot.clickOn("#updateButton");
		
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText("zero");
		page = Storage.pull("5");
		Assertions.assertThat(page.getName()).isEqualTo("zero");

		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText("hello i'm zero");
		page = Storage.pull("5");
		Assertions.assertThat(page.getDescription()).isEqualTo("hello i'm zero");
	}
	
	private void cancelSingles(FxRobot robot) {
		Page page = Storage.pull("5");
		PageDesc initialVals = new PageDesc(page);
		cancelField(robot,"name");
		page = Storage.pull("5");
		Assertions.assertThat(page.getName()).isEqualTo(initialVals.name());
		cancelField(robot,"description");
		page = Storage.pull("5");
		Assertions.assertThat(page.getDescription()).isEqualTo(initialVals.description());
	
	}
	
	private void cancelAll(FxRobot robot) {
		robot.clickOn("#editButton");
		Page page = Storage.pull("5");
		PageDesc initial = new PageDesc(page);
		editField(robot,"name","hj ewl");
		editField(robot,"description","cgetrw");
		
		robot.clickOn("#cancelButton");
		
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText(initial.name());
		page = Storage.pull("5");
		Assertions.assertThat(page.getName()).isEqualTo(initial.name());

		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText(initial.description());
		page = Storage.pull("5");
		Assertions.assertThat(page.getDescription()).isEqualTo(initial.description());
	
	}
	
	private void newUser(String id) {
		SessionSingleton.getInstance().startSession("0", "0");
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
