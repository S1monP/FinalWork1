package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    @FXML
    TextField ErrorTxtFld;

    @FXML
    Button registreClercBtn;

    @FXML
    Button registreUserBtn;


    private void LoginOk(String type){
        String fileName = (type.equals("Clerk") ? "LoginClerk" : "LoginUser");
        Parent LoginOkForm;
        try
        {
            LoginOkForm = FXMLLoader.load(getClass().getResource((fileName + ".fxml")));
            Stage LoginOkStage = new Stage();
            LoginOkStage.setTitle("Welcome " + Constants.ID);
            LoginOkStage.setScene(new Scene(LoginOkForm, 600, 400));
            LoginOkStage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void registration(ActionEvent actionEvent)
    {
        String fileName = ((actionEvent.getSource() == registreClercBtn) ? "registrationClerc" : "registrationUser");
        Parent registrationForm;
        try
        {
            registrationForm = FXMLLoader.load(getClass().getResource(fileName + ".fxml"));
            Stage RegistrationStage = new Stage();
            RegistrationStage.setTitle("Registration form");
            RegistrationStage.setScene(new Scene(registrationForm, 600, 400));
            RegistrationStage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void tryToLogin()
    {
        String login = loginTxtFld.getText();
        String pass = passwordTxtFld.getText();
        for (int i = 0; i <users.size() ; i++) {
            if (users.get(i).login.equals(login)){
                        if(Encrypt.DeMes(users.get(i).password.getPasswords().get((users.get(i).password.getPasswords().size())-1).getPassword(),3).equals(pass)) {
                                ErrorTxtFld.setText("Login Ok " + users.get(i).login);
                                Constants.ID = users.get(i).login;
                                LoginOk(users.get(i).type);
                                LoginOk = true;
                                break;
                            }
                        for (int k = 0; k < users.get(i).password.getPasswords().size() ; k++) {
                           if (users.get(i).password.getPasswords().get(k).isActive()){
                               if (Encrypt.DeMes(users.get(i).password.getPasswords().get(k).getPassword(), 3).equals(pass)){
                                   ErrorTxtFld.setText("Login Ok" + users.get(i).login);
                                   Constants.ID = users.get(i).login;
                                   LoginOk(users.get(i).type);
                                   LoginOk = true;
                                   break;
                               }
                        }
                }
            }
        }
        if (!LoginOk){
            ErrorTxtFld.setText("Неправильный логин или пороль");
            loginTxtFld.clear();
            passwordTxtFld.clear();
        }
    }
}
