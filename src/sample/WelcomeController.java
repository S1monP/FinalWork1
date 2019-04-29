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
    private boolean LoginOk = false;
    @FXML
    TextField loginTxtFld;

    @FXML
    TextField passwordTxtFld;

   public void LoginOk(){
        Parent LoginOkForm = null;
        try
        {
            LoginOkForm = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage RegistrationStage = new Stage();
            RegistrationStage.setTitle("Welcome");
            RegistrationStage.setScene(new Scene(LoginOkForm, 600, 400));
            RegistrationStage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

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
                        if(Encrypt.DeMes(users.get(i).password.getPasswords().get((users.get(i).password.getPasswords().size())-1).getPassword(),3).equals(pass)) {
                                System.out.println("Login Ok " + users.get(i).login);
                                LoginOk();
                                LoginOk = true;
                                break;
                            }
                        for (int k = 0; k < users.get(i).password.getPasswords().size() ; k++) {
                           if (users.get(i).password.getPasswords().get(k).isActive()){
                               if (Encrypt.DeMes(users.get(i).password.getPasswords().get(k).getPassword(), 3).equals(pass)){
                                   System.out.println("Login Ok");
                                   LoginOk();
                                   LoginOk = true;
                                   break;
                               }
                        }
                }
            }
        }
        if (!LoginOk) System.out.println("Login fail");
    }
}
