package sample;

import java.io.Serializable;
import java.util.HashMap;

public class Passwords implements Serializable
{
    public HashMap<Integer, Password> getPasswords()
    {
        return passwords;
    }

    private HashMap<Integer, Password> passwords;

    public Passwords()
    {
        passwords = new HashMap<>();
    }
    /**
     *
     * @param password - New user password
     * @return true if password succesfully added
     */
    public boolean addPassword(String password)
    {
        // todo Check if password is valid (Password.isValid)
        if (Password.isValid(password) == 0){
            // todo create new Password
            Password newPass = new Password(password);
            // todo make all previous passwords inactive
            for (int i = 0; i < passwords.size(); i++) {
                passwords.get(i).setActive(false);
            }
            // todo add to current list
            passwords.put(passwords.size(), newPass);
        }



        return true;
    }

    public boolean checkPassword(String password)
    {
        //todo check if this password equals to active
        for (int i = 0; i < passwords.size() ; i++) {
            if(password.equals(passwords.get(i).getPassword())){
                if(passwords.get(i).isActive())
                    return true;
            }
        }
        return false;
    }
}
