package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.*;
import model.Library;

public class LibraryController extends Controller<Library> {

    @FXML private Button exploreCatalogueBtn;
    @FXML private Button patronRecordBtn;
    @FXML private Button favouriteBooksBtn;
    @FXML private Button adminModeBtn;
    @FXML private Button exitBtn;
    
    public void initialize() {

    }
    
    //completed
    public void handleCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(model.getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }
    
    //completed
    public void handlePatronRecord()throws Exception {
        ViewLoader.showStage(model, "/view/record.fxml", "Patron Record", new Stage());
    }
    
    //worked
    public void handleFavorite() throws Exception {
        ViewLoader.showStage(model, "/view/favourites.fxml", "Favourites", new Stage());
    }
    
    //worked
    public void handleAdmin() throws Exception {
        ViewLoader.showStage(model, "/view/admin.fxml", "Administration Menu", new Stage());
    }
    
    //completed
    public void handleExitMain() throws Exception {
        System.exit(0);
    }
    
    public final Library getLibrary() {
        return model;
    }

}
