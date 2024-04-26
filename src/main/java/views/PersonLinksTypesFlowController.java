package views;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.ListNavigationModel;
import model.PersonModel;
import sprint1.Page;
import sprint1.Person;
import sprint1.Storage;

public class PersonLinksTypesFlowController implements ShowItemInterface{
	Person user;

    @FXML
    private ListView<Page> allLinksListView;
    
    ListNavigationModel navigation;
    
    private final ShowItemInterface itemShower;
    
    
    public PersonLinksTypesFlowController()
    {
    	itemShower = this;
    }
    
    public void setModel(PersonModel model, ListNavigationModel navigationModel)
    {
    	user = model.getPage();
    	navigation = navigationModel;
		allLinksListView.setItems(FXCollections.observableArrayList());
    	allLinksListView.setCellFactory(new Callback<ListView<Page>, ListCell<Page>>()
		  {

			@Override
			public ListCell<Page> call(ListView<Page> lv)
			{
				return new ItemListCell(lv,itemShower);
			}
		  });
    }

    @FXML
    void onClickEditors(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("editor");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);
    }

    @FXML
    void onClickFollowers(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("follower");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickFriends(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("friend");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickJobs(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("job");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickMentors(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("mentor");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickNews(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("news");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickProjects(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("project");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickRecommended(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("recommended");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);    
    }

    @FXML
    void onClickSkills(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("skill");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);
    }

    @FXML
    void onClickViewers(ActionEvent event) {
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	ArrayList<String> idNumbers = user.getInternalLinks("viewer");
    	for(String id:idNumbers) {
    		pages.add(Storage.pull(id));
    	}
    	allLinksListView.setItems(pages);
    }
	@Override
	public void showItem(Page item)
	{
		System.out.println(item.getName());
		navigation.showPage(item);
	}

}

