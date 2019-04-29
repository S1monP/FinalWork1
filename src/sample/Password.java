package sample;

import java.io.Serializable;
import java.util.Date;

public class Password implements Serializable
{
    public Date getRegistrationDate()
    {
        return registrationDate;
    }

    Date registrationDate;

    public String getPassword()
    {
        return password;
    }

    public boolean isActive()
    {
        return isActive;
    }

    private String password;

    public void setActive(boolean active)
    {
        isActive = active;
    }

    private boolean isActive;

    public Password(String password)
    {
        this.password = password;
        this.isActive = true;
        this.registrationDate = new Date();
    }

    public static int isValid(String password)
    {
        int counter = 0;

        //todo check minimal length
        if (password.length() < Constants.PASSWORD_LENGTH)
            return 1;

        //todo Validation UpperCase
        for (char c: password.toCharArray())
        {
            if (Constants.UpperCaseSymbols.contains(c + ""))
            {
                counter++;
                break;
            }
        }
        if (counter == 0)
            return 2;

        //todo Validation LowerCase
        counter = 0;
        for (char c: password.toCharArray())
        {
            if (Character.isLowerCase(c))
            {
                counter++;
                break;
            }
        }
        if (counter == 0)
            return 3;


        //todo Validation Number
        counter = 0;
        for (char c: password.toCharArray())
        {
            if (Character.isDigit(c))
            {
                counter++;
                break;
            }
        }
        if (counter == 0)
            return 4;

        //todo Validation NonAlphaAndNonNumber
        counter = 0;
        for (char c: password.toCharArray())
        {
            if (!Character.isAlphabetic(c) && !Character.isDigit(c))
            {
                counter++;
                break;
            }
        }
        if (counter == 0)
            return 5;

        return 0;
    }
}
