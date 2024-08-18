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

    public int countValidator(int count) throws Exception {
        if (count > 0) {
            return count;
        } else {
            throw new Exception("Invalid Count: Count must be a positive integer. ");
        }
    }
    public int priceValidator(int price) throws Exception {
        if (price > 0) {
            return price;
        } else {
            throw new Exception("Invalid Count: Price must be a positive integer. ");
        }
    }
}
