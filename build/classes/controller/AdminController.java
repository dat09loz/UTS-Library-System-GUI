package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.stage.*;
import model.*;

public class AdminController extends Controller<Library> {
    
    public void initialize() {
    }
    
    //testing
    public void handleAddPatron() throws Exception {
        ViewLoader.showStage(model, "/view/addPatron.fxml", "Add Patron", new Stage());
    }
    
    //testing
    public void handleRemovePatron() throws Exception {
        ViewLoader.showStage(model, "/view/removePatron.fxml", "Remove Patron", new Stage());
    }
    
    //testing 
    public void handleAddBook() throws Exception {
        ViewLoader.showStage(model.getCatalogue(), "/view/addBook.fxml", "Add Book", new Stage());
    }
    
    //testing
    public void handleRemoveBook() throws Exception {
        ViewLoader.showStage(model.getCatalogue(), "/view/removeBook.fxml", "Remove Book", new Stage());
    }
    
    //completed
    public void handleExitAdmin() throws Exception {
        stage.close();
    }
    
    public final Library getLibrary() {
        return model;
    } 
}