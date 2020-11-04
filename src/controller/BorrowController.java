package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class BorrowController extends Controller<Catalogue>{
    @FXML private ListView<Book> availableBooksLv;
    @FXML private Button selectPatronBtn;
    @FXML private Button borrowSeletedBookBtn;
    @FXML private Button closeBtn;
    @FXML private TextField patronIDTf;
    
    public void initialize() {
        //resize the button
        borrowSeletedBookBtn.setMaxWidth(210);
        closeBtn.setMaxWidth(210);
        //select patron button
        BooleanBinding patronIDTfEmpty = Bindings.isEmpty(patronIDTf.textProperty());
        selectPatronBtn.disableProperty().bind(patronIDTfEmpty);
        //borrow selected book button
        borrowSeletedBookBtn.disableProperty().bind(Bindings.isEmpty(availableBooksLv.getSelectionModel().getSelectedItems()));
    }
    
    private Book getSelectedBook() { return availableBooksLv.getSelectionModel().getSelectedItem();}
    
    @FXML public void handleSelectPatron(ActionEvent e) throws Exception {
        if (isInt(patronIDTf.getText())) {
            int ID = getID();
            if (model.getPatron(ID) != null) {
                Patron patron = model.getPatron(ID);
                availableBooksLv.setItems(model.getBorrowableBooks(patron));
            }
        }
    }
    
    @FXML public void handleBorrowBook(ActionEvent e) throws Exception {           
        Book book = getSelectedBook();
        int ID = getID();
        Patron patron = model.getPatron(ID);
        model.loanBookToPatron(book, patron);
        availableBooksLv.setItems(model.getBooksOnShelf());
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
