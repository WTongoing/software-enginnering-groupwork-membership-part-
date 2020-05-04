package Gui;

import com.sun.xml.internal.bind.v2.runtime.output.NamespaceContextImpl;
import org.dom4j.DocumentException;
import org.dom4j.Document;
import org.dom4j.io.*;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class XmlHandler {

    public static Document XmlHandling() throws DocumentException {
        InputStream dataFlow = XmlHandler.class.getResourceAsStream("Member.xml");
        SAXReader saxreader = new SAXReader();
        Document document = saxreader.read(dataFlow);
        return document;
    }

    //read from xml file
    public static MemberInfo ReturnInfo(Element element){
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setUserNo(Integer.parseInt(element.attribute("userNo").getValue()));
        memberInfo.setLastName(element.element("lastName").getText());
        memberInfo.setFirstName(element.element("firstName").getText());
        memberInfo.setEmail(element.element("email").getText());
        memberInfo.setPhoneNo(element.element("phoneNo").getText());
        memberInfo.setStampNum(Integer.parseInt((element.element("stampNum").getText())));
        return memberInfo;
    }

    // iterate each <member> record
    public static ArrayList<MemberInfo> getMemberInfo() throws DocumentException{
        MemberInfo memberinfo;
        Document document = XmlHandling();
        Element rootEle = document.getRootElement();

        ArrayList<MemberInfo> list = new ArrayList<MemberInfo>();

        for (Iterator i = rootEle.elementIterator();i.hasNext();){
           Element element = (Element)i.next();
           memberinfo = ReturnInfo(element);
           list.add(memberinfo);
        }
        return list;
    }

    // read all info in a particular member element
    public static ArrayList<String> InfoToString(int pointer) throws DocumentException{
        ArrayList<String> attribute = new ArrayList<String>();
        //for(int i=0;i<getMemberInfo().size();i++) {
            String userNo = String.valueOf(getMemberInfo().get(pointer).userNo);
            String lastName = getMemberInfo().get(pointer).lastName;
            String firstName = getMemberInfo().get(pointer).firstName;
            String email = getMemberInfo().get(pointer).email;
            String phoneNo = getMemberInfo().get(pointer).phoneNo;
            String stampNum = String.valueOf(getMemberInfo().get(pointer).stampNum);
            attribute.add(userNo);
            attribute.add(lastName);
            attribute.add(firstName);
            attribute.add(email);
            attribute.add(phoneNo);
            attribute.add(stampNum);
       //}
        return attribute;
    }

    public static ArrayList<String> HasUserPhoneNo(String PhoneNo) throws DocumentException{
        Document document = XmlHandling();
        ArrayList<String> datalist = new ArrayList<String>();

        Element rootEle = document.getRootElement();
        List<Element> memberEle = rootEle.elements("Member");
        int pointer =0;
        //遍历所有<member>根节点
        for (Element memberEleList: memberEle) {
            Element phoneNoEle = memberEleList.element("phoneNo");
            String strUserPhoneEle = phoneNoEle.getText();
            System.out.println(strUserPhoneEle);
            if (PhoneNo.equals(strUserPhoneEle)) {
//              Element UserPhoneEle = rootEle.element("Member").getParent();
                datalist = InfoToString(pointer);
                break;
            }
            pointer ++;
        }
        if(datalist.isEmpty()){
            System.out.println("The account has not exist!");
            return null;
        }
        return datalist;
    }

    public static ArrayList<String> HasUserEmail(String UserEmail) throws DocumentException{
        Document document = XmlHandling();
        ArrayList<String> datalist = new ArrayList<String>();

        Element rootEle = document.getRootElement();
        List<Element> memberEle = rootEle.elements("Member");
        int pointer =0;
        //遍历所有<member>根节点
        for (Element memberEleList: memberEle) {
            Element emailEle = memberEleList.element("email");
            String strUserEmailEle = emailEle.getText();
            System.out.println(strUserEmailEle);
            if (UserEmail.equals(strUserEmailEle)) {
                datalist = InfoToString(pointer);
                break;
            }
            pointer ++;
        }
        if(datalist.isEmpty()){
            System.out.println("The account has not exist!");
            return null;
        }
        return datalist;
    }

    public static void main(String[] args){
        XmlHandler result = new XmlHandler();
        try{
            System.out.println(result.HasUserPhoneNo("12345678903"));
            System.out.println(result.HasUserEmail("Lily@qmul.ac.uk"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
