/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lth.conf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author lth7p
 */
public class RegexCheck {
    public static boolean checkLogin(String user,String pwd){
        if(checkUser(user)==true && checkPassword(pwd)==true)
            return true;
        else{
            Utils.getBox("Tài khoản hoặc mật khẩu không hợp lệ!!", Alert.AlertType.WARNING).show();
            return false;
        }
    }
    public static boolean checkUser(String user){
        String regExpn =
            "^(?=.*[0-9])(?=.*[a-z])$";
        CharSequence inputStr = user;
        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();  
    }
    public static boolean checkPassword(String pwd){
        String regExpn =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        CharSequence inputStr = pwd;
        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();  
    }
}
