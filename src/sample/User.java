package sample;

import java.io.Serializable;

public class User implements Serializable
{
    String login;
    Passwords password;

    public User(String login, Passwords password)
    {
        this.login = login;
        this.password = password;
    }
}
