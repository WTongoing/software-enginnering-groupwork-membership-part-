package Gui;

import org.dom4j.DocumentException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class control {
    //verify email format
    //[a-z0-9A-Z]+@[a-z0-9A-Z]+\.(.*)
    public boolean isEmail(String EmailFormat){
        if(EmailFormat.equals("")){
            System.out.println("input field is null");
            return  false;
        }
        String ExpectedFormat = "^([a-z0-9A-Z]+)@([a-z0-9A-Z]+)\\.(.*)$";
        Pattern pEmail = Pattern.compile(ExpectedFormat);
        Matcher matchEmail = pEmail.matcher(EmailFormat);
        if(matchEmail.matches()){
            return true;
        }else{
            return false;
        }
    }

    //verify phone format
    public boolean isPhoneNo(String PhoneNoFormat){
        if(PhoneNoFormat.equals("")){
            System.out.println("input field is null");
            return  false;
        }
        String ExpectedFormat = "^[1][0-9]{10}$";
        Pattern pPhoneNo = Pattern.compile(ExpectedFormat);
        Matcher matchPhoneNo = pPhoneNo.matcher(PhoneNoFormat);
        if(matchPhoneNo.matches()){
            return true;
        }else{
            return false;
        }
    }

    // judge input account format, PhoneNo or Email
    public ArrayList<String> JudgeInputFormat(String PhoneOrEmail){
        ArrayList<String> list = new ArrayList<>();
            if(isPhoneNo(PhoneOrEmail)){
                try{
                list = XmlHandler.HasUserPhoneNo(PhoneOrEmail);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(isEmail(PhoneOrEmail)){
                try {
                list = XmlHandler.HasUserEmail(PhoneOrEmail);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("input format wrong");
                return null;
            }
            return list;
    }

    public static void main(String[] args){
        control verify = new control();
        System.out.println(verify.JudgeInputFormat("12345678902"));
    }
}
