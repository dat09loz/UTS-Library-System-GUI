package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ReturnController extends Controller<Catalogue>{
    @FXML private ListView<Book> borrowedBooksLv;
    @FXML private Button selectPatronBtn;
    @FXML private Button returnSeletedBookBtn;
    @FXML private Button closeBtn;
    @FXML private TextField patronIDTf;
    
    public void initialize() {
        //resize the button
        returnSeletedBookBtn.setMaxWidth(210);
        closeBtn.setMaxWidth(210);
        //select patron button
        BooleanBinding patronIDTfEmpty = Bindings.isEmpty(patronIDTf.textProperty());
        selectPatronBtn.disableProperty().bind(patronIDTfEmpty);
        //return selected book button
        returnSeletedBookBtn.disableProperty().bind(Bindings.isEmpty(borrowedBooksLv.getSelectionModel().getSelectedItems()));
    }
    
    private Book getSelectedBook() { return borrowedBooksLv.getSelectionModel().getSelectedItem();}
    
    @FXML public void handleSelectPatron(ActionEvent e) throws Exception {
        if (isInt(patronIDTf.getText())) {
            int ID = getID();
            if (model.getPatron(ID) != null) {
                Patron patron = model.getPatron(ID);
                borrowedBooksLv.setItems(patron.currentlyBorrowed());
            }
        }
    }
    
    @FXML public void handleReturnBook(ActionEvent e) throws Exception {           
        Book book = getSelectedBook();
        int ID = getID();
        Patron patron = model.getPatron(ID);
        model.returnBookFromPatron(book, patron);
        borrowedBooksLv.setItems(patron.currentlyBorrowed());
    }
    
    private int getID() {
        return Integer.parseInt(patronIDTf.getText());
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
    
    @FXML public void handleClose() throws Exception {
        stage.close();
    }
    
    public Catalogue getCatalogue() { return model; }
}
