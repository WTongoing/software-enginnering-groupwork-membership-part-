package Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AuthenticationGui {
    public AuthenticationGui(){
        init(originFrame);
    }
    public JFrame originFrame = new JFrame();
    public static JPanel contentPane = new JPanel();
    public JLabel labelTitle, labelSubtitle, returnHome;
    public JButton buttonYes, buttonNo;

    // initialize default frame
    public void init(JFrame Jframe){
//      Jframe.setBounds(150, 100, 600, 500);
        Jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Jframe.setVisible(true);
        Jframe.setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    public void Panel(JPanel panel){
        originFrame.setBounds(150, 100, 600, 500);

        labelTitle = new JLabel("Identity Authentication");
        Font titlefont = new Font("Arial",Font.BOLD,30);
        labelTitle.setBounds(130, 40, 400, 50);
        labelTitle.setFont(titlefont);
        panel.add(labelTitle);

        labelSubtitle = new JLabel("Have you already signed up your membership?");
        Font subtitlefont = new Font("Arial",Font.ITALIC,18);
        labelSubtitle.setBounds(100, 100, 400, 40);
        labelSubtitle.setFont(subtitlefont);
        panel.add(labelSubtitle);

        buttonYes = new JButton("Yes, i'm already a member");
        buttonYes.setBounds(150, 200, 300, 40);
        panel.add(buttonYes);

        buttonNo = new JButton("No, i'm not a member yet");
        buttonNo.setBounds(150, 300, 300, 40);
        panel.add(buttonNo);

        buttonYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                originFrame.setVisible(false);
                LoginPageGui.launcher();
            }
        });

        buttonNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("skip to Join membership interface"+"\n");
            }
        });
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    AuthenticationGui Authengui = new AuthenticationGui();
                    Authengui.Panel(contentPane);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}
