package Gui;

import javax.swing.*;
import java.awt.*;

public class MemberInfoGui extends AuthenticationGui{
    public MemberInfoGui(){}

    @Override
    public void Panel(JPanel panel) {
        originFrame.setBounds(150, 100, 800, 550);

        JLabel labelTitle = new JLabel("Personal Information");
        Font titlefont = new Font("Arial",Font.BOLD,30);
        labelTitle.setBounds(250, 30, 350, 40);
        labelTitle.setFont(titlefont);
        panel.add(labelTitle);

        JLabel label_LastName = new JLabel("Last Name:");
        Font labelfont = new Font("Arial",Font.PLAIN,18);
        label_LastName.setBounds(200, 120, 200, 30);
        label_LastName.setFont(labelfont);
        panel.add(label_LastName);

        JLabel label_FirstName = new JLabel("First Name:");
        label_FirstName.setBounds(200, 160, 200, 30);
        label_FirstName.setFont(labelfont);
        panel.add(label_FirstName);

        JLabel label_Email = new JLabel("Email:");
        label_Email.setBounds(200, 200, 200, 30);
        label_Email.setFont(labelfont);
        panel.add(label_Email);

        JLabel label_PhoneNo = new JLabel("Phone Number:");
        label_PhoneNo.setBounds(200, 240, 200, 30);
        label_PhoneNo.setFont(labelfont);
        panel.add(label_PhoneNo);

        JLabel label_Stamp = new JLabel("Current Stamp Number:");
        label_Stamp.setBounds(200, 280, 200, 30);
        label_Stamp.setFont(labelfont);
        panel.add(label_Stamp);

        JButton confirm_Btn = new JButton("Confirm");
        confirm_Btn.setBounds(280,400,200,40);
        panel.add(confirm_Btn);
    }

    public static void launcher(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    MemberInfoGui memberGui = new MemberInfoGui();
                    memberGui.Panel(contentPane);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args){
        try{
            MemberInfoGui memberGui = new MemberInfoGui();
            memberGui.Panel(contentPane);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
