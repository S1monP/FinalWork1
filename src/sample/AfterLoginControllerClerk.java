package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AfterLoginControllerClerk {

    @FXML
    TextField nameTXTField;

    @FXML
    TextField DolBuy;

    @FXML
    TextField DolSell;

    @FXML
    TextField EurBuy;

    @FXML
    TextField EurSell;

    public void start(){

    EurBuy.setText("25.00");
    EurSell.setText("26.00");
    DolBuy.setText("27.00");
    DolSell.setText("28.00");
    nameTXTField.setText("Добро пожаловать " + Constants.ID);
}
}
