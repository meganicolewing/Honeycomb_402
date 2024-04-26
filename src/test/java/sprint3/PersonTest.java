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
import model.PersonModel;
import model.PersonTransitionModel;
import model.SessionSingleton;
import sprint1.Person;
import sprint1.PersonDesc;
import sprint1.Storage;
import views.HomeBarController;
import views.PersonCanEditController;

@ExtendWith(ApplicationExtension.class)
public class PersonTest {
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
			newUser("0");
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
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("0");
		robot.clickOn("#followButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("0");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("0");
	}
	
	@Test
	public void testFollowEditSingles(FxRobot robot) {
		robot.clickOn("#followButton");
		editSingles(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("0");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("0");
	}
	
	@Test
	public void testFollowEditAll(FxRobot robot) {
		robot.clickOn("#followButton");
		editAll(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("0");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("0");
	}
	
	@Test
	public void testFollowCancelSingles(FxRobot robot) {
		robot.clickOn("#followButton");
		cancelSingles(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("0");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("0");
	}
	
	@Test
	public void testFollowCancelAll(FxRobot robot) {
		robot.clickOn("#followButton");
		cancelAll(robot);
		Person user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).contains("0");
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull("0");
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain("0");
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
		Person person = (Person)Storage.pull("0");
		updateField(robot,"name");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getName()).isEqualTo("name");
		updateField(robot,"pronouns");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPronouns()).isEqualTo("pronouns");
		updateField(robot,"phone");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPhoneNumber()).isEqualTo("phone");
		updateField(robot,"email");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getEmail()).isEqualTo("email");
		updateField(robot,"description");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getDescription()).isEqualTo("description");
	}
	
	private void editAll(FxRobot robot) {
		robot.clickOn("#editButton");
		Person person;
		editField(robot,"name","zero");
		editField(robot,"pronouns","he/they");
		editField(robot,"email","zero@gmail.com");
		editField(robot,"phone","0000000000");
		editField(robot,"description","hello i'm zero");
		
		robot.clickOn("#updateButton");
		
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText("zero");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getName()).isEqualTo("zero");
		
		Assertions.assertThat(robot.lookup("#pronounsLabel").queryAs(Label.class))
		.hasText("he/they");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPronouns()).isEqualTo("he/they");
		
		Assertions.assertThat(robot.lookup("#emailLabel").queryAs(Label.class))
		.hasText("zero@gmail.com");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getEmail()).isEqualTo("zero@gmail.com");
		
		Assertions.assertThat(robot.lookup("#phoneLabel").queryAs(Label.class))
		.hasText("0000000000");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPhoneNumber()).isEqualTo("0000000000");
		
		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText("hello i'm zero");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getDescription()).isEqualTo("hello i'm zero");
	}
	
	private void cancelSingles(FxRobot robot) {
		Person person = (Person)Storage.pull("0");
		PersonDesc initialVals = new PersonDesc(person);
		cancelField(robot,"name");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getName()).isEqualTo(initialVals.name());
		cancelField(robot,"pronouns");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPronouns()).isEqualTo(initialVals.pronouns());
		cancelField(robot,"phone");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPhoneNumber()).isEqualTo(initialVals.phoneNumber());
		cancelField(robot,"email");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getEmail()).isEqualTo(initialVals.email());
		cancelField(robot,"description");
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getDescription()).isEqualTo(initialVals.description());
	
	}
	
	private void cancelAll(FxRobot robot) {
		robot.clickOn("#editButton");
		Person person = (Person)Storage.pull("0");
		PersonDesc initial = new PersonDesc(person);
		editField(robot,"name","hj ewl");
		editField(robot,"pronouns","heqtv");
		editField(robot,"email","cvgteq");
		editField(robot,"phone","cfeqgr");
		editField(robot,"description","cgetrw");
		
		robot.clickOn("#cancelButton");
		
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText(initial.name());
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getName()).isEqualTo(initial.name());
		
		Assertions.assertThat(robot.lookup("#pronounsLabel").queryAs(Label.class))
		.hasText(initial.pronouns());
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPronouns()).isEqualTo(initial.pronouns());
		
		Assertions.assertThat(robot.lookup("#emailLabel").queryAs(Label.class))
		.hasText(initial.email());
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getEmail()).isEqualTo(initial.email());
		
		Assertions.assertThat(robot.lookup("#phoneLabel").queryAs(Label.class))
		.hasText(initial.phoneNumber());
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getPhoneNumber()).isEqualTo(initial.phoneNumber());
		
		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText(initial.description());
		person = (Person)Storage.pull("0");
		Assertions.assertThat(person.getDescription()).isEqualTo(initial.description());
	
	}
	
	private void newUser(String id) {
		SessionSingleton.getInstance().startSession(id, id);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/PersonCanEditView.fxml"));
		try {
			Node center = (Node)loader.load();
			PersonCanEditController cont2 = loader.getController();
			PersonModel model = new PersonModel(id);
			PersonTransitionModel navigation2 = new PersonTransitionModel(view);
			cont2.setModel(model,navigation2);
			view.setCenter(center);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
