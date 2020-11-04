package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import model.*;

public class RecordController extends Controller<Library>{
    @FXML private ListView<Book> currentlyBorrowedLv;
    @FXML private ListView<Book> borrowingHistoryLv;
    @FXML private TextField patronIDTf;
    @FXML private Text resultTxt;
    @FXML private Button showRecordBtn;
    
    @FXML public void initialize() {
        BooleanBinding patronIDTfEmpty = Bindings.isEmpty(patronIDTf.textProperty());
        showRecordBtn.disableProperty().bind(patronIDTfEmpty);
    }
    
    public final Library getLibrary() { return model; }
    
    @FXML public void handleShowRecord(ActionEvent e) throws Exception {
        Patron patron = model.getPatron(getID());
        if (patron == null)
            resultTxt.setText("Patron not exists!");
        else {
            resultTxt.setText(patron.toString());
            currentlyBorrowedLv.setItems(patron.currentlyBorrowed());
            borrowingHistoryLv.setItems(patron.borrowingHistory());
        }
    }
    
    private int getID() {
        return Integer.parseInt(patronIDTf.getText());
    }
    
    public void handleClose() throws Exception {
        stage.close();
    }
}
