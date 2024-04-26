package views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.LoginNavigationModelInterface;
import model.SessionSingleton;
import sprint1.Storage;
import javafx.event.ActionEvent;

public class LoginPageController {
	
	LoginNavigationModelInterface loginNavModel;
	
	public LoginPageController()
	{
		
	}
	
	public void setModel(LoginNavigationModelInterface model)
	{
		this.loginNavModel = model;
	}
	
	
    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordLabel;

    @FXML
    private TextField usernameLabel;
    
    
    
    @FXML
    void onLoginButtonClick(ActionEvent event) {
    	String username = usernameLabel.getText();
    	String password = passwordLabel.getText();
    	SessionSingleton currentSession = SessionSingleton.getInstance();
    	
    	if(currentSession.startSession(username, password)&&Storage.pull(username)!=null&&Storage.pull(username).getClass().getName().equals("sprint1.Person"))
    	{
    		if(this.loginNavModel != null)
    		{
        		this.loginNavModel.showHomepage();
    		}
    	}
    	else {
    		usernameLabel.textProperty().set("");
    		passwordLabel.textProperty().set("");

    	}
    }
    
}
