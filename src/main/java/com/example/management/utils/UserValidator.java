package com.example.management.utils;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public static boolean isValidDate(String d)
    {
        String regex = "^(1[0-2]|0[1-9])-(3[01]"
                + "|[12][0-9]|0[1-9])-[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
    public static  boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean isValidPhoneNo(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);

        return (m.matches());
    }
    public static List<String> isValidUser(JSONObject json){
        List<String> error=new ArrayList<>();
        if(!json.has("userName")){
            error.add("userName");
        }
        if(!json.has("email")){
            if(!isValidEmail(json.getString("email")))
                error.add("email");
        }
        if(!json.has("phoneNo")){
            if(!isValidPhoneNo(json.getString("phoneNo")));
            error.add("PhoneNo");
        }
        if(!json.has("dateOfBirth")){
            if(!isValidDate(json.getString("dateOfBirth")))
                error.add("dateOfBirth");
        }
        return error;
    }
}
