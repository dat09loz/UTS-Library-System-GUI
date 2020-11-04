package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowAllBooksController extends Controller<Catalogue> {
    @FXML private TableView<Book> allBooksTv;
    @FXML private Button closeBtn;
    
    public void initialize() {
        allBooksTv.setItems(model.getAllBooks());
    }
    
    @FXML public void handleClose() throws Exception {
        stage.close();
    }    
    
    public Catalogue getCatalogue() { return model; }
}
