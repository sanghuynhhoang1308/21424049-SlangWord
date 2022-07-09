/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21424049_slangword;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Huynh Hoang Sang
 */
public class QuizzSlangWord extends JFrame implements ActionListener {

    JButton btnFindDef, btnFindSlang, btnBack;

    QuizzSlangWord() {

        JLabel label = new JLabel("DO VUI");
        label.setForeground(Color.red);
        label.setFont(new Font("Serif", Font.PLAIN, 35));
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setAlignmentY(-100);

        btnFindDef = new JButton("1. Find Definition");
        btnFindDef.addActionListener(this);
        btnFindDef.setFont(new Font("Serif", Font.PLAIN, 18));
        JPanel panelCenter = new JPanel();
        btnFindDef.setBackground(Color.getHSBColor(85, 162, 221));
        panelCenter.setLayout(new GridLayout(1, 2, 10, 10));
        panelCenter.add(btnFindDef);
        btnFindSlang = new JButton("2. Find SlangWord");
        btnFindSlang.addActionListener(this);
        btnFindSlang.setFont(new Font("Serif", Font.PLAIN, 18));
        btnFindSlang.setBackground(Color.getHSBColor(85, 162, 221));
        panelCenter.add(btnFindSlang);
        Dimension size2 = new Dimension(500, 200);
        panelCenter.setMaximumSize(size2);
        panelCenter.setPreferredSize(size2);
        panelCenter.setMinimumSize(size2);

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);

        JPanel buttonPane = new JPanel();
        buttonPane.add(btnBack);

        Container con = this.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 100)));
        con.add(label);
        con.add(Box.createRigidArea(new Dimension(0, 100)));
        con.add(panelCenter);
        con.add(Box.createRigidArea(new Dimension(0, 100)));
        con.add(buttonPane);

        this.setTitle("Quizz Form");
        this.setVisible(true);
        this.setSize(600, 650);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnFindDef) {
            this.dispose();
            new OptionQuizz(1);
        } else if (e.getSource() == btnFindSlang) {
            this.dispose();
            new OptionQuizz(2);
        } else if (e.getSource() == btnBack) {
            this.dispose();
            new Menu();
        }
    }

}
