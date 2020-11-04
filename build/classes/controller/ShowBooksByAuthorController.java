package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowBooksByAuthorController extends Controller<Catalogue> {
    @FXML private ListView<Author> authorsLv;
    @FXML private ListView<Book> selectedAuthorLv;
    
    public void initialize() {
    }
    
    private Author getSelectedAuthor() { return authorsLv.getSelectionModel().getSelectedItem();}
    
    @FXML public void handleDisplay() throws Exception {
        Author author = getSelectedAuthor();
        if (author != null)
            selectedAuthorLv.setItems(model.getBooksByAuthor(author));
    }
    
    @FXML public void handleClose() throws Exception {
        stage.close();
    }
    
    public Catalogue getCatalogue() { return model; }
}