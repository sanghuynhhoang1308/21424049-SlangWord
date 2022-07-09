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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Huynh Hoang Sang
 */
public class OptionQuizz extends JFrame implements ActionListener {

    JButton btnTL1, btnTL2, btnTL3, btnTL4, btnBack;
    // final int type;
    String s[];

    OptionQuizz(int type) {
        s = (SlangWordDetail.getInstance()).quizSlang(type);
        // A Label

        JLabel questionLabel;
        if (type == 1) {
            questionLabel = new JLabel("SlangWord " + " ||  " + s[0] + "  || " + "co nghia la?");
        } else {
            questionLabel = new JLabel("  || " + s[0] + "  || " + " co slangword la gi?");
        }
        questionLabel.setForeground(Color.black);
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        questionLabel.setAlignmentX(CENTER_ALIGNMENT);

        btnTL1 = new JButton("A." + s[1]);
        btnTL1.addActionListener(this);
        btnTL1.setFont(new Font("Serif", Font.PLAIN, 14));
        btnTL2 = new JButton("B." + s[2]);
        btnTL2.addActionListener(this);
        btnTL2.setFont(new Font("Serif", Font.PLAIN, 14));
        btnTL3 = new JButton("C." + s[3]);
        btnTL3.addActionListener(this);
        btnTL3.setFont(new Font("Serif", Font.PLAIN, 14));
        btnTL4 = new JButton("D. " + s[4]);
        btnTL4.addActionListener(this);
        btnTL4.setFont(new Font("Serif", Font.PLAIN, 14));
        btnTL1.setBackground(Color.getHSBColor(85, 162, 221));
        btnTL2.setBackground(Color.getHSBColor(85, 162, 221));
        btnTL3.setBackground(Color.getHSBColor(85, 162, 221));
        btnTL4.setBackground(Color.getHSBColor(85, 162, 221));
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(4, 1, 10, 10));
        panelCenter.add(btnTL1);
        panelCenter.add(btnTL2);
        panelCenter.add(btnTL3);
        panelCenter.add(btnTL4);
        Dimension size2 = new Dimension(600, 200);
        panelCenter.setMaximumSize(size2);
        panelCenter.setPreferredSize(size2);
        panelCenter.setMinimumSize(size2);
        // Button back

        btnBack = new JButton("Back");
        btnBack.addActionListener(this);

        JPanel buttonPane = new JPanel();
        buttonPane.add(btnBack);

        Container con = this.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 100)));

        con.add(Box.createRigidArea(new Dimension(0, 30)));
        con.add(questionLabel);
        con.add(Box.createRigidArea(new Dimension(0, 50)));
        con.add(panelCenter);
        con.add(Box.createRigidArea(new Dimension(0, 50)));
        con.add(buttonPane);
        this.setTitle("Question Quiz");
        this.setVisible(true);
        this.setSize(700, 700);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == btnTL1) {
            this.RightandWrong(1);
        } else if (e.getSource() == btnTL2) {
            this.RightandWrong(2);
        } else if (e.getSource() == btnTL3) {
            this.RightandWrong(3);
        } else if (e.getSource() == btnTL4) {
            this.RightandWrong(4);
        } else if (e.getSource() == btnBack) {
            this.dispose();
            new QuizzSlangWord();
        }
    }

    public void RightandWrong(int ans) {
        if (s[ans].equals(s[5])) {
            // default title and icon
            JOptionPane.showMessageDialog(this, "CHUC MUNG BAN DA TRA L:OI DUNG.");

        } else {
            JOptionPane.showMessageDialog(this, "CAU TRA LOI CUA BAN SAI !!!", "Inane error", JOptionPane.ERROR_MESSAGE);
            if (ans == 1) {
                btnTL1.setBackground(Color.red);
            } else if (ans == 2) {
                btnTL2.setBackground(Color.red);
            } else if (ans == 3) {
                btnTL3.setBackground(Color.red);
            } else if (ans == 4) {
                btnTL4.setBackground(Color.red);
            }
        }
        if (s[1].equals(s[5])) {
            btnTL1.setEnabled(false);
            btnTL1.setBackground(Color.green);
        } else {
            btnTL1.setEnabled(false);
        }
        if (s[2].equals(s[5])) {
            btnTL2.setEnabled(false);
            btnTL2.setBackground(Color.green);
        } else {
            btnTL2.setEnabled(false);
        }
        if (s[3].equals(s[5])) {
            btnTL3.setEnabled(false);
            btnTL3.setBackground(Color.green);
        } else {
            btnTL3.setEnabled(false);
        }
        if (s[4].equals(s[5])) {
            btnTL4.setEnabled(false);
            btnTL4.setBackground(Color.green);
        } else {
            btnTL4.setEnabled(false);
        }
    }

}
