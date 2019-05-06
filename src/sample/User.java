package sample;

import java.io.Serializable;

public class User implements Serializable
{
    String login;
    String type;
    Passwords password;

    public User(String login, Passwords password, String type)
    {
        this.login = login;
        this.password = password;
        this.type = type;
    }
}
