package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class PlaceHoldController extends Controller<Catalogue> {
    @FXML private ListView<Book> allBooksLv;
    @FXML private Button holdSelectedBookBtn;
    @FXML private Button selectPatronBtn;
    @FXML private Button closeBtn;
    @FXML private TextField patronIDTf;
    @FXML private Text resultTxt;
    
    public void initialize() {
        //resize the button
        holdSelectedBookBtn.setMaxWidth(210);
        closeBtn.setMaxWidth(210);
        //select patron button
        BooleanBinding patronIDTfEmpty = Bindings.isEmpty(patronIDTf.textProperty());
        selectPatronBtn.disableProperty().bind(patronIDTfEmpty);
        //return selected book button
        holdSelectedBookBtn.disableProperty().bind(Bindings.isEmpty(allBooksLv.getSelectionModel().getSelectedItems()));        
    }
    
    private Book getSelectedBook() { return allBooksLv.getSelectionModel().getSelectedItem();}
    
    //done
    @FXML public void handleSelectPatron(ActionEvent e) throws Exception {
        if (isInt(patronIDTf.getText())) {
            int ID = getID();
            if (model.getPatron(ID) != null) {
                resultTxt.setText("");
                Patron patron = model.getPatron(ID);
                allBooksLv.setItems(model.getAllBooks());
            }
            else
                resultTxt.setText("No Patron selected");
        }
    }
    
    
    public void handlePlaceHold(ActionEvent e) throws Exception {
        Book book = getSelectedBook();
        Patron patron = model.getPatron(getID());
        if (!book.isHeldBy(patron)) {
            book.addHold(patron);
            resultTxt.setText("Hold placed on " + book + " for " + patron);
        }
        else
            resultTxt.setText(patron + " has already placed a hold on " + book);
    }
    
    private int getID() {
        return Integer.parseInt(patronIDTf.getText());
    }
    
    @FXML public void handleClose() throws Exception {
        stage.close();
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
    
    public Catalogue getCatalogue() { return model; }
}
