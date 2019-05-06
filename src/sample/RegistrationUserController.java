package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.*;

import static sample.Main.users;


public class RegistrationUserController {

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
        User user = new User(loginNew, new Passwords(),"User");
        users.add(user);
        String writtenPass = Encrypt.MesUp(passwordNew, 3);
        users.get(users.size()-1).password.addPassword(writtenPass);
        try
        {
            FileOutputStream fileOut = new FileOutputStream("./Users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.flush();
            out.close();
            fileOut.flush();
            fileOut.close();
            System.out.println("Serialized data is saved in file");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        System.out.println("Total users: " + users.size());

    }
}
