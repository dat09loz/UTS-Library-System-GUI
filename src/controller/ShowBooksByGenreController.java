package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowBooksByGenreController extends Controller<Catalogue> {
    @FXML private ListView<Genre> genresLv;
    @FXML private ListView<Book> selectedGenreLv;
    
    public void initialize() {
    }
    
    private Genre getSelectedGenre() { return genresLv.getSelectionModel().getSelectedItem();}
    
    @FXML public void handleDisplay() throws Exception {
        Genre genre = getSelectedGenre();
        if (genre != null)
            selectedGenreLv.setItems(model.getBooksInGenre(genre));
    }
    
    @FXML public void handleClose() throws Exception {
        stage.close();
    }
    
    public Catalogue getCatalogue() { return model; }
}
