package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;


public class RemovePatronController extends Controller<Library> {   
    @FXML private ListView<Patron> patronsLv;
    
    public final Library getLibrary() { return model; }
    
    public void initialize() {
    }
    
    private Patron getSelectedPatron() { return patronsLv.getSelectionModel().getSelectedItem(); }
    
    @FXML public void handleRemovePatron(ActionEvent e) throws Exception {
        model.removePatron(getSelectedPatron());
    }
    
    public void handleClose() {
        stage.close();
    }
}