package sample;

import java.util.SplittableRandom;

public class Encrypt {

    public static String MesUp (String pass, int key){
        String result = "";
        for (int i = 0; i < pass.length() ; i++) {
            result += (char)((int)pass.charAt(i) + key);
        }
        return result;
    }
    public static String DeMes (String pass, int key) {
        return MesUp(pass, - key);
    }
}
