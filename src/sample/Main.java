package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Main extends Application {
    public static ArrayList<User> users;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        users = new ArrayList<>();
        System.out.println(Encrypt.MesUp("Hello", 3));
        String a = Encrypt.MesUp("Hello", 3);
        System.out.println(Encrypt.DeMes(a, 3));
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
            System.out.println("User class not found");
            c.printStackTrace();
            return;
        }
        launch(args);
    }
}
