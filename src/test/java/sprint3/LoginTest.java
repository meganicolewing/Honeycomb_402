package sprint3;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.assertions.api.Assertions;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import model.LoginNavigationModel;
import model.SessionSingleton;
import views.LoginPageController;

@ExtendWith(ApplicationExtension.class)
public class LoginTest {
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
	public void testButton(FxRobot robot) {
		login(robot,"","hi");
		login(robot,"5","hi");
		login(robot,"4","");
		for(int i = 0; i<5; i++) {
			checkLogin(robot,i+"");
		}
	}
	
	private void login(FxRobot robot, String id, String password) {
		robot.clickOn("#usernameField");
		robot.write(id);
		robot.clickOn("#passwordField");
		robot.write(password);
		robot.clickOn("#loginButton");
	}
	
	private void checkLogin(FxRobot robot, String id) {
		login(robot,id,id);
		checkFields(robot,id);
		robot.clickOn("#logoutButton");
	}
	
	private void checkFields(FxRobot robot, String id) {
		SessionSingleton current = SessionSingleton.getInstance();
		Assertions.assertThat(current.getUserId()).isEqualTo(id);
		Assertions.assertThat(robot.lookup("#nameLabel").queryAs(Label.class))
		.hasText(id);
		Assertions.assertThat(robot.lookup("#pronounsLabel").queryAs(Label.class))
		.hasText("she/her");
		Assertions.assertThat(robot.lookup("#emailLabel").queryAs(Label.class))
		.hasText(id+"@gmail.com");
		Assertions.assertThat(robot.lookup("#phoneLabel").queryAs(Label.class))
		.hasText(id+"555555555");
		Assertions.assertThat(robot.lookup("#descriptionLabel").queryAs(Label.class))
		.hasText("hello "+id);
	}
	
}
