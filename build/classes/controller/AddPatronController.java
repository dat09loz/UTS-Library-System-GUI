package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.Library;

public class AddPatronController extends Controller<Library> {
    @FXML private Text resultTxt;    
    @FXML private TextField patronIDTf;
    @FXML private TextField patronNameTf;
    
    public void initialize() {
    }
    
    public void handleAddPatron() throws Exception {
        if (!patronIDTf.getText().isEmpty() && !patronNameTf.getText().isEmpty()) {
            if (isInt(patronIDTf.getText())) {
                resultTxt.setText("");
                int ID = getID();
                String name = getName();
                if (model.getPatron(ID) == null) {
                    model.addPatron(ID, name);
                    resultTxt.setText("Patron added.");
                }
                else 
                    resultTxt.setText("Patron already exists!");
            }
        }
    }
    
    private int getID() {
        return Integer.parseInt(patronIDTf.getText());
    }
    
    private String getName() {
        return patronNameTf.getText();
    }
    
    public boolean isInt(String s) {
        try { 
            Integer.parseInt(s); 
        } 
        catch(NumberFormatException e) {
            return false; 
        }
        return true;
    }
    
    public void handleClose() throws Exception {
        stage.close();
    }
    
    public final Library getLibrary() { return model; }    
}
