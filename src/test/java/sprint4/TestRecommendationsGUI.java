package sprint4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import model.LoginNavigationModel;
import views.LoginPageController;

@ExtendWith(ApplicationExtension.class)
public class TestRecommendationsGUI {
	@Start
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
	public void test0(FxRobot robot) {
		login(robot,0+"","h");
		String[] recommendations = {"2p","","","",""};
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button1");
		recommendations[0] = "0p";
		recommendations[1] = "";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#personButton");
		clickOnItemInList(robot,"4p");
		recommendations[0] = "0p";
		recommendations[1] = "2p";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#companyButton");
		clickOnItemInList(robot,"0c");
		recommendations[0] = "2c";
		recommendations[1] = "1c";
		recommendations[2] = "3c";
		recommendations[3] = "4c";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button3");
		recommendations[0] = "4c";
		recommendations[1] = "2c";
		recommendations[2] = "1c";
		recommendations[3] = "0c";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#skillButton");
		clickOnItemInList(robot,"0s");
		recommendations[0] = "4s";
		recommendations[1] = "2s";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button1");
		recommendations[0] = "2s";
		recommendations[1] = "";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#jobButton");
		clickOnItemInList(robot,"2j");
		recommendations[0] = "4j";
		recommendations[1] = "1j";
		recommendations[2] = "0j";
		recommendations[3] = "3j";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button1");
		recommendations[0] = "3j";
		recommendations[1] = "2j";
		recommendations[2] = "1j";
		recommendations[3] = "0j";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#projectButton");
		clickOnItemInList(robot,"2r");
		recommendations[0] = "1r";
		recommendations[1] = "3r";
		recommendations[2] = "4r";
		recommendations[3] = "0r";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button4");
		recommendations[0] = "1r";
		recommendations[1] = "3r";
		recommendations[2] = "2r";
		recommendations[3] = "4r";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#newsButton");
		clickOnItemInList(robot,"4n");
		recommendations[0] = "0n";
		recommendations[1] = "1n";
		recommendations[2] = "3n";
		recommendations[3] = "2n";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button3");
		recommendations[0] = "1n";
		recommendations[1] = "2n";
		recommendations[2] = "0n";
		recommendations[3] = "4n";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
	}
	
	@Test
	public void test1(FxRobot robot) {
		login(robot,6+"","h");
		String[] recommendations = {"3p","","","",""};
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button1");
		recommendations[0] = "1p";
		recommendations[1] = "";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#personButton");
		clickOnItemInList(robot,"4p");
		recommendations[0] = "1p";
		recommendations[1] = "3p";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#companyButton");
		clickOnItemInList(robot,"0c");
		recommendations[0] = "2c";
		recommendations[1] = "1c";
		recommendations[2] = "3c";
		recommendations[3] = "4c";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button3");
		recommendations[0] = "4c";
		recommendations[1] = "2c";
		recommendations[2] = "1c";
		recommendations[3] = "0c";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#skillButton");
		clickOnItemInList(robot,"0s");
		recommendations[0] = "1s";
		recommendations[1] = "";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button1");
		recommendations[0] = "0s";
		recommendations[1] = "";
		recommendations[2] = "";
		recommendations[3] = "";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#jobButton");
		clickOnItemInList(robot,"2j");
		recommendations[0] = "4j";
		recommendations[1] = "1j";
		recommendations[2] = "0j";
		recommendations[3] = "3j";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button1");
		recommendations[0] = "3j";
		recommendations[1] = "2j";
		recommendations[2] = "1j";
		recommendations[3] = "0j";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#projectButton");
		clickOnItemInList(robot,"2r");
		recommendations[0] = "1r";
		recommendations[1] = "3r";
		recommendations[2] = "4r";
		recommendations[3] = "0r";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button4");
		recommendations[0] = "1r";
		recommendations[1] = "3r";
		recommendations[2] = "2r";
		recommendations[3] = "4r";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		
		robot.clickOn("#searchButton");
		robot.clickOn("#allButton");
		robot.clickOn("#newsButton");
		clickOnItemInList(robot,"4n");
		recommendations[0] = "0n";
		recommendations[1] = "1n";
		recommendations[2] = "3n";
		recommendations[3] = "2n";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
		robot.clickOn("#button3");
		recommendations[0] = "1n";
		recommendations[1] = "2n";
		recommendations[2] = "0n";
		recommendations[3] = "4n";
		recommendations[4] = "";		
		lookupRecommendations(robot,recommendations);
	}
	
	private void lookupRecommendations(FxRobot robot, String[] recommendations) {
		for(int i = 1; i<6; i++) {
			Assertions.assertThat(robot.lookup("#label"+i).queryAs(Label.class))
			.hasText(recommendations[i-1]);
		}
	}

	private void login(FxRobot robot, String id, String password) {
		robot.clickOn("#usernameField");
		robot.write(id);
		robot.clickOn("#passwordField");
		robot.write(password);
		robot.clickOn("#loginButton");
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
			}
		}
	}
}
