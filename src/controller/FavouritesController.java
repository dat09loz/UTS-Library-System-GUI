package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class FavouritesController extends Controller<Library> {
    @FXML private ListView<Book> favouritesLv;
    @FXML private TextField patronIDTf;
    @FXML private Text resultTxt;
    @FXML private Button showFavouritesBtn;
    
    public void initialize() {
        BooleanBinding patronIDTfEmpty = Bindings.isEmpty(patronIDTf.textProperty());
        showFavouritesBtn.disableProperty().bind(patronIDTfEmpty);        
    }
    
    public final Library getLibrary() { return model; }
    
    @FXML public void handleFavourites() throws Exception {
        Patron patron = model.getPatron(getID());
        if (patron == null)
            resultTxt.setText("Patron not exists!");
        else {
            resultTxt.setText(patron.toString());
            favouritesLv.setItems(patron.favourites());
        }
    }
    
    private int getID() {
        return Integer.parseInt(patronIDTf.getText());
    }
    
    public void handleClose() throws Exception {
        stage.close();
    }
}