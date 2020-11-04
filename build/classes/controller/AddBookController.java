package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;


public class AddBookController extends Controller<Catalogue>{
    @FXML private Text resultTxt;    
    @FXML private TextField titleTf;
    @FXML private TextField genreTf;
    @FXML private TextField authorTf;
    
    public void initialize() {
    }
    
    public void handleAddBook() throws Exception {
        if (!titleTf.getText().isEmpty() && !genreTf.getText().isEmpty() && !authorTf.getText().isEmpty()) {
            resultTxt.setText("");
            String title = getTitle();
            String author = getAuthor();
            String genre = getGenre();
            if (model.hasBook(title, author))
                resultTxt.setText("That book is already in the Catalogue.");
            else {
                model.addBook(title, author, genre);
                resultTxt.setText("Book added to Catalogue.");
            }
        }
    }
        
    private String getTitle() {
        return titleTf.getText();
    }
    
    private String getAuthor() {
        return authorTf.getText();
    }
    
    private String getGenre() {
        return genreTf.getText();
    }
    
    public void handleClose() throws Exception {
        stage.close();
    }
    
    public final Catalogue getCatalogue() { return model; }
}
