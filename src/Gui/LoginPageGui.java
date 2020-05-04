package Gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPageGui extends AuthenticationGui{
    public LoginPageGui(){}

    public void Panel(JPanel panel){
        originFrame.setBounds(150, 100, 600, 500);

        JLabel labelTitle = new JLabel("Login");
        Font titlefont = new Font("Arial",Font.BOLD,30);
        labelTitle.setBounds(250, 40, 350, 50);
        labelTitle.setFont(titlefont);
        panel.add(labelTitle);

        JLabel label_1 = new JLabel("Email/Phone No:");
        Font labelfont = new Font("Arial",Font.PLAIN,18);
        label_1.setBounds(100, 150, 150, 40);
        label_1.setFont(labelfont);
        panel.add(label_1);

        JLabel label_2 = new JLabel("password:");
        label_2.setBounds(120, 250, 150, 40);
        label_2.setFont(labelfont);
        panel.add(label_2);

        JTextField EmailPhone_No = new JTextField();
        EmailPhone_No.setBounds(270, 150, 150, 40);
        panel.add(EmailPhone_No);

        JPasswordField password = new JPasswordField();
        password.setBounds(270, 250, 150, 40);
        panel.add(password);

        JButton ConfirmBtn = new JButton("confirm");
        ConfirmBtn.setBounds(180, 350, 200, 40);
        panel.add(ConfirmBtn);

        ConfirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                originFrame.setVisible(false);
                MemberInfoGui.launcher();
            }
        });
    }

    public static void launcher(){
    EventQueue.invokeLater(new Runnable(){
        public void run(){
            try{
                LoginPageGui loginGui = new LoginPageGui();
                loginGui.Panel(contentPane);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    });
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    LoginPageGui loginGui = new LoginPageGui();
                    loginGui.Panel(contentPane);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
