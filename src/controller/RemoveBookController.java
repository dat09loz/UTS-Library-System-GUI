package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;


public class RemoveBookController extends Controller<Catalogue> {   
    @FXML private ListView<Book> booksLv;

    public final Catalogue getCatalogue() { return model; }

    public void initialize() {
    }
    
    private Book getSelectedBook() { return booksLv.getSelectionModel().getSelectedItem(); }
    
    @FXML public void handleRemoveBook(ActionEvent e) throws Exception {
        if (getSelectedBook() != null)
            model.removeBook(getSelectedBook());
    }
    
    public void handleClose() {
        stage.close();
    }
}
