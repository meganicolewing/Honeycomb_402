package sprint3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxRobotException;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.service.query.EmptyNodeQueryException;
import javafx.geometry.VerticalDirection;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import model.LoginNavigationModel;
import model.SessionSingleton;
import sprint1.Page;
import sprint1.Person;
import sprint1.Storage;
import views.LoginPageController;

@ExtendWith(ApplicationExtension.class)
public class NavigationTest {
	String pageID;
	String userID;
	@Start //before
	private void start(Stage stage) {
		Reseter.reset();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/LoginPage.fxml"));
		try {
			BorderPane view = loader.load();
			LoginPageController cont = loader.getController();
			LoginNavigationModel navigation = new LoginNavigationModel(view);
			cont.setModel(navigation);
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testNavigation(FxRobot robot) {
	
		checkLogin(robot,"0");
		updateField(robot,"phone");
		cancelField(robot,"email");
		robot.clickOn("#searchButton");	
		robot.clickOn("#allButton");
		robot.clickOn("#companyButton");
		clickOnItemInList(robot,"5");
		testFollowEdit(robot);
		testFollowCancel(robot);
		
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		clickOnItemInList(robot,"1");
		try {
			robot.clickOn("#editButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		try {
			robot.clickOn("#followButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#unfollowButton");
		Person user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain(pageID);

		
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#recommendedButton");
		clickOnItemInList(robot,"1");
		clickOnItemInList(robot,"6");
		try {
			robot.clickOn("#editButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		try {
			robot.clickOn("#followButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain(pageID);
		
		robot.clickOn("#searchButton");	
		robot.clickOn("#allButton");
		robot.clickOn("#personButton");
		clickOnItemInList(robot,"3");
		Assertions.assertThat(robot.lookup("#permissionLabel").queryAs(Label.class))
		.hasText("Sorry, you don't have permission to view this page :(");
		
		robot.clickOn("#searchbutton2");	
		robot.clickOn("#allButton");
		robot.clickOn("#newsButton");
		clickOnItemInList(robot,"7");
		try {
			robot.clickOn("#followButton");
		}
		catch(FxRobotException e) {
			assert(false);
		}
		try {
			robot.lookup("#nameLabel").queryAs(Label.class);
		}
		catch(EmptyNodeQueryException e) {
			assert(false);
		}
		try {
			robot.lookup("#descriptionLabel").queryAs(Label.class);
		}
		catch(EmptyNodeQueryException e) {
			assert(false);
		}
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		clickOnItemInList(robot,"7");
		
		
		robot.clickOn("#searchButton");	
		robot.clickOn("#allButton");
		robot.clickOn("#personButton");
		clickOnItemInList(robot,"4");
		updateField(robot,"pronouns");
		try {
			robot.clickOn("#unfollowButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#followButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).contains(pageID);

		robot.clickOn("#searchButton");	
		robot.clickOn("#allButton");
		robot.clickOn("#personButton");
		clickOnItemInList(robot,"2");
		try {
			robot.clickOn("#unfollowButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#followButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).contains(pageID);
	
		
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		clickOnItemInList(robot,"17");
		updateField(robot,"name");
		try {
			robot.clickOn("#followButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain(pageID);
	
		robot.clickOn("#homeButton");
		pageID = userID;
		testFollowEdit(robot);
		testFollowCancel(robot);
		robot.clickOn("#logoutButton");
		Assertions.assertThat(SessionSingleton.getInstance().getUserId()).isEqualTo("");
	
		checkLogin(robot,"1");
		updateField(robot,"phone");
		cancelField(robot,"email");
		robot.clickOn("#searchButton");	
		robot.clickOn("#allButton");
		robot.clickOn("#jobButton");
		clickOnItemInList(robot,"6");
		testFollowEdit(robot);
		testFollowCancel(robot);
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		robot.moveTo("#list");
		robot.scroll(5,VerticalDirection.DOWN);
		clickOnItemInList(robot,"3");
		updateField(robot,"name");
		robot.clickOn("#editButton");
		editField(robot,"name","3");
		robot.clickOn("#updateButton");
		try {
			robot.clickOn("#followButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain(pageID);
		robot.clickOn("#followButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).contains(pageID);

		
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#skillsButton");
		clickOnItemInList(robot,"14");
		try {
			robot.clickOn("#editButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		try {
			robot.clickOn("#unfollowButton");
			assert(false);
		}
		catch(FxRobotException e) {}
		robot.clickOn("#followButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).contains(pageID);
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		clickOnItemInList(robot,"7");
		Assertions.assertThat(robot.lookup("#permissionLabel").queryAs(Label.class))
		.hasText("Sorry, you don't have permission to view this page :(");
		robot.clickOn("#searchButton");	
		robot.clickOn("#allButton");
		robot.clickOn("#personButton");
		clickOnItemInList(robot,"3");
		try {
			robot.clickOn("#unfollowButton");
		}
		catch(FxRobotException e) {
			assert(false);
		}
		try {
			robot.lookup("#nameLabel").queryAs(Label.class);
		}
		catch(EmptyNodeQueryException e) {
			assert(false);
		}
		try {
			robot.lookup("#descriptionLabel").queryAs(Label.class);
		}
		catch(EmptyNodeQueryException e) {
			assert(false);
		}
		robot.clickOn("#searchButton");	
		robot.clickOn("#linksButton");
		robot.clickOn("#followingButton");
		clickOnItemInList(robot,"3");
		robot.clickOn("#homeButton");
		pageID = userID;
		testFollowEdit(robot);
		testFollowCancel(robot);
		robot.clickOn("#logoutButton");
		Assertions.assertThat(SessionSingleton.getInstance().getUserId()).isEqualTo("");
	}
	

	private void clickOnItemInList(FxRobot robot, String name) {
		Set<Label> listLabels = robot.lookup(".linkLabel").queryAllAs(Label.class);
		Set<Button> listButtons = robot.lookup(".linkButton").queryAllAs(Button.class);
		ArrayList<String> listStrings = new ArrayList<String>();
		ArrayList<Button> arrayListButtons = new ArrayList<Button>();
		for(Label l: listLabels) {
			listStrings.add(l.getText());
		}
		for(Button b:listButtons) {
			arrayListButtons.add(b);
		}
		for(int i = 0; i<listStrings.size(); i++) {
			if(listStrings.get(i).equals(name)) {
				robot.clickOn(arrayListButtons.get(i));
				pageID = name;
			}
		}
	}
	
	private void updateField(FxRobot robot, String field) {
		robot.clickOn("#editButton");
		editField(robot, field,field);
		robot.clickOn("#updateButton");
		Assertions.assertThat(robot.lookup("#"+field+"Label").queryAs(Label.class))
		.hasText(field);
	}
	
	private void editField(FxRobot robot, String field, String newValue) {
		robot.doubleClickOn("#"+field+"Field");
		robot.clickOn("#"+field+"Field");
		robot.write(newValue);
	}
	
	
	private void cancelField(FxRobot robot, String field) {
		String before = robot.lookup("#"+field+"Label").queryAs(Label.class).getText();
		robot.clickOn("#editButton");
		editField(robot, field,"BhHhH");
		robot.clickOn("#cancelButton");
		Assertions.assertThat(robot.lookup("#"+field+"Label").queryAs(Label.class))
		.hasText(before);
	}
	
	private void login(FxRobot robot, String id, String password) {
		pageID = id;
		userID = id;
		robot.clickOn("#usernameField");
		robot.write(id);
		robot.clickOn("#passwordField");
		robot.write(password);
		robot.clickOn("#loginButton");
	}
	
	private void checkLogin(FxRobot robot, String id) {
		login(robot,id,id);
		checkFields(robot,id);
	}
	
	
	private void checkFieldsPerson(FxRobot robot, Page person) {
		Person p = (Person)person;
		Assertions.assertThat(robot.lookup("#pronounsLabel").queryAs(Label.class))
		.hasText(p.getPronouns());
		Assertions.assertThat(robot.lookup("#emailLabel").queryAs(Label.class))
		.hasText(p.getEmail());
		Assertions.assertThat(robot.lookup("#phoneLabel").queryAs(Label.class))
		.hasText(p.getPhoneNumber());
	}
	
	private void checkFields(FxRobot robot, String id) {
		SessionSingleton current = SessionSingleton.getInstance();
		Assertions.assertThat(current.getUserId()).isEqualTo(id);
		Page page = Storage.pull(id);
		if(page.getClass().getName().equals("sprint1.Person")) {
			checkFieldsPerson(robot,page);
		}
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText(page.getId());
		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText(page.getDescription());
	}

	public void testFollowEdit(FxRobot robot) {
		robot.clickOn("#followButton");
		updateField(robot,"name");
		Person user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).contains(pageID);
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain(pageID);
	}
	
	public void testFollowCancel(FxRobot robot) {
		robot.clickOn("#followButton");
		cancelField(robot,"description");
		Person user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).contains(pageID);
		robot.clickOn("#unfollowButton");
		user = (Person)Storage.pull(userID);
		Assertions.assertThat(user.getInternalLinks("follower")).doesNotContain(pageID);
	}
}
