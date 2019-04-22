package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static sample.Main.users;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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
        try
        {
            File file;
            FileInputStream fileIn = new FileInputStream("./Users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException c)
        {
            System.out.println("Pirate class not found");
            c.printStackTrace();
            return;
        }
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).login.equals(login)){
                        if(users.get(i).password.getPasswords().get((users.get(i).password.getPasswords().size())-1).getPassword().equals(pass)) {
                                System.out.println("Login Ok");
                                break;
                            }
                        for (int k = 0; k < users.get(i).password.getPasswords().size() ; k++) {
                           if (users.get(i).password.getPasswords().get(k).isActive()){
                               if (users.get(i).password.getPasswords().get(k).getPassword().equals(pass)){
                                   System.out.println("Login Ok");
                               }
                        }
                }
            }
            System.out.println("Login Fail");
        }
        }

}
