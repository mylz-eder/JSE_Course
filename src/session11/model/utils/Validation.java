package session11.model.utils;


import java.util.regex.Pattern;

public class Validation {
    public String nameValidator(String name) throws Exception {
        if(Pattern.matches("^[a-zA-Z\\s]{3,30}$", name)){
            return name;
        }else{
            throw new Exception("Invalid Name");
        }
    }

    public int posNumValidator(int posNum) throws Exception {
        if (posNum > 0) {
            return posNum;
        } else {
            throw new Exception("Invalid Value: Number must be a positive integer. ");
        }
    }
    public long longvalidation(long longNum) throws Exception {
        if (longNum > 0) {
            return longNum;
        } else {
            throw new Exception("Invalid Value: Number must be a positive integer. ");
        }
    }
    public int negNumValidator(int negNum) throws Exception {
        if (negNum > 0) {
            return negNum;
        } else {
            throw new Exception("Invalid Count: Price must be a positive integer. ");
        }
    }
}
