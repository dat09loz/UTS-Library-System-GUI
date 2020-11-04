package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.*;
import model.*;

public class CatalogueController extends Controller<Catalogue>{
    @FXML private Button addBookBtn;
    @FXML private Button closeBtn;
    
    public void initialize() {
        
    }
    
    public void handleAllBooks(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }
    
    public void handleAvailableBooks(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }
    
    public void handleBooksByGenre(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/showBooksByGenre.fxml", "Browse By Genre", new Stage());
    }
    
    public void handleBooksByAuthor(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/showBooksByAuthor.fxml", "Browse By Author", new Stage());
    }
    
    public void handleBorrowBooks(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/borrow.fxml", "Borrow a Book", new Stage());
    }
    
    public void handleReturnBooks(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/return.fxml", "Return a Book", new Stage());
    }
    
    public void handlePlaceHold(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/placeHold.fxml", "Place a Hold", new Stage());
    }
    
    public void handleExitCatalogue(ActionEvent event) throws Exception {
        stage.close();
    }
    
    public final Catalogue getCatalogue() {
        return model;
    }
}
