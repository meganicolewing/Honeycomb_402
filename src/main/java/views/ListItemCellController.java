package views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import sprint1.Page;

public class ListItemCellController
{

    @FXML
    private Label buttonLabel;

    @FXML
    private Button button;
    
    ItemListCell model;
    
    public void setModel(ItemListCell cell)
    {
    	model = cell;
    	updateView(cell.getItem());
    }
    
    public void updateView(Page item)
    {
    	if(item ==null)
    	{
    		buttonLabel.setText("");
    		button.setVisible(false);
    	}
    	else
    	{
    		buttonLabel.setText(item.getName());
    		button.setVisible(true);
    	}
    }
    
    
    @FXML
    void onLinkClick(ActionEvent event) 
    {
    	model.showItem();
    }

}