package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static sample.Main.users;
import java.io.IOException;

public class WelcomeController
{
    @FXML
    TextField loginTxtFld;

    @FXML
    TextField passwordTxtFld;

    public void registration()
    {
        Parent registrationForm = null;
        try
        {
            registrationForm = FXMLLoader.load(getClass().getResource("registration.fxml"));
            Stage RegistrationStage = new Stage();

            RegistrationStage.setTitle("Registration form");
            RegistrationStage.setScene(new Scene(registrationForm, 600, 400));
            RegistrationStage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void tryToLogin(ActionEvent actionEvent)
    {
        String login = loginTxtFld.getText();
        String pass = passwordTxtFld.getText();
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).login.equals(login)){
                for (int j = 0; j <users.size() ; j++) {
                    for (int k = 0; k < users.get(j).password.getPasswords().size() ; k++) {
                        if(users.get(j).password.getPasswords().get(k).getPassword().equals(pass)) {
                            if (users.get(j).password.getPasswords().get(k).isActive()) {
                                System.out.println("Login Ok");
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Login Fail");
    }
}
