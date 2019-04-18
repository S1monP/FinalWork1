package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static sample.Main.users;

public class RegistrationController
{
    @FXML
    TextField regLogin;

    @FXML
    TextField regPassword;

    public void registration()
    {
        String loginNew = regLogin.getText();
        String passwordNew = regPassword.getText();


        // check if login exists
            for (User user:users)
            {
                if (user.login.equals(loginNew))
                {
                    System.out.println("This login is already taken!");
                    return;
                }
            }
        System.out.println("User is new");

        // check if password valid
        int errCode = Password.isValid(passwordNew);

        if (errCode > 0)
        {
            System.out.println(ErrorsInfo.getMessage(errCode));
            return;
        }

        User user = new User(loginNew, new Passwords());
        users.add(user);
        users.get(users.size()-1).password.addPassword(passwordNew);
        System.out.println("Total users: " + users.size());

    }
}