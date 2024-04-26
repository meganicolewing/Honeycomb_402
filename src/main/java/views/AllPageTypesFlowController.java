package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.ListNavigationModel;
import sprint1.Page;
import sprint1.Storage;

public class AllPageTypesFlowController implements ShowItemInterface {
	
    ListNavigationModel navigation;

    @FXML
    private ListView<Page> allPagesListView;
    
    private final ShowItemInterface itemShower;
    
    
    public AllPageTypesFlowController()
    {
    	itemShower = this;
    }
    
    public void setModel(ListNavigationModel navigationModel)
    {
    	navigation = navigationModel;
		allPagesListView.setItems(FXCollections.observableArrayList());
    	allPagesListView.setCellFactory(new Callback<ListView<Page>, ListCell<Page>>()
		  {

			@Override
			public ListCell<Page> call(ListView<Page> lv)
			{
				return new ItemListCell(lv,itemShower);
			}
		  });
    }

    @FXML
    void onCompanyPageClick(ActionEvent event) {
    	Page[] companies = Storage.pullAll("Company");
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	if(companies!=null) {
	    	for(Page c:companies) {
	    		pages.add(c);
	    	}
    	}
    	allPagesListView.setItems(pages);
    }

    @FXML
    void onJobPostingPageClick(ActionEvent event) {
    	Page[] jobs = Storage.pullAll("JobPosting");
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	if(jobs!=null) {
	    	for(Page j:jobs) {
	    		pages.add(j);
	    	}
    	}
    	allPagesListView.setItems(pages);
    }

    @FXML
    void onNewsArticlePageClick(ActionEvent event) {
    	Page[] companies = Storage.pullAll("NewsArticle");
    	ObservableList<Page> pages = FXCollections.observableArrayList();
    	if(companies!=null) {
	    	for(Page c:companies) {
	    		pages.add(c);
	    	}
    	}
    	allPagesListView.setItems(pages);
    }

    @FXML
    void onPersonPageClick(ActionEvent event) {
    	Page[] companies = Storage.pullAll("Person");
    	ObservableList<Page> names = FXCollections.observableArrayList();
    	if(companies!=null) {
	    	for(Page c:companies) {
	    		names.add(c);
	    	}
    	}
    	allPagesListView.setItems(names);
    }

    @FXML
    void onProjectPageClick(ActionEvent event) {
    	Page[] companies = Storage.pullAll("Project");
    	ObservableList<Page> names = FXCollections.observableArrayList();
    	if(companies != null) {
	    	for(Page c:companies) {
	    		names.add(c);
	    	}
    	}
    	allPagesListView.setItems(names);
    }

    @FXML
    void onSkillPageClick(ActionEvent event) {
    	Page[] companies = Storage.pullAll("Skill");
    	ObservableList<Page> names = FXCollections.observableArrayList();
    	if(companies!=null) {
	    	for(Page c:companies) {
	    		names.add(c);
	    	}
    	}
    	allPagesListView.setItems(names);
    }
	
	@Override
	public void showItem(Page item)
	{
		navigation.showPage(item);
	}

}