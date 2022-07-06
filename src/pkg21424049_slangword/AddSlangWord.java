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
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Huynh Hoang Sang
 */
public class AddSlangWord extends JFrame implements ActionListener {

    SlangWordDetail slangWord;
    JButton btnBack, btnAdd;
    JTextField tfMean, tfSlang;

    AddSlangWord() {
        
        slangWord = SlangWordDetail.getInstance();
        Container con = this.getContentPane();
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Add SlangWord");
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 35));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setPreferredSize(new Dimension(300, 100));

        // Form
        JPanel form = new JPanel();

        JPanel pnlslang = new JPanel();
        form.setBackground(Color.CYAN);
        SpringLayout layoutSlang = new SpringLayout();
        pnlslang.setLayout(layoutSlang);
        JLabel labelForSlang = new JLabel("Slang: ");
        tfSlang = new JTextField("", 20);
        labelForSlang.setPreferredSize(new Dimension(100, 20));
        pnlslang.add(labelForSlang);
        pnlslang.add(tfSlang);
        layoutSlang.putConstraint(SpringLayout.WEST, labelForSlang, 6, SpringLayout.WEST, pnlslang);
        layoutSlang.putConstraint(SpringLayout.NORTH, labelForSlang, 6, SpringLayout.NORTH, pnlslang);
        layoutSlang.putConstraint(SpringLayout.WEST, tfSlang, 6, SpringLayout.EAST, labelForSlang);
        layoutSlang.putConstraint(SpringLayout.NORTH, tfSlang, 6, SpringLayout.NORTH, pnlslang);
        layoutSlang.putConstraint(SpringLayout.EAST, pnlslang, 6, SpringLayout.EAST, tfSlang);
        layoutSlang.putConstraint(SpringLayout.SOUTH, pnlslang, 6, SpringLayout.SOUTH, tfSlang);

        JPanel pnlmean = new JPanel();
        SpringLayout layoutSlangMean = new SpringLayout();
        pnlmean.setLayout(layoutSlangMean);
        JLabel lblMean = new JLabel("Mean: ");
        lblMean.setPreferredSize(new Dimension(100, 20));
        tfMean = new JTextField("", 20);
        pnlmean.add(lblMean);
        pnlmean.add(tfMean);
        layoutSlangMean.putConstraint(SpringLayout.WEST, lblMean, 6, SpringLayout.WEST, pnlmean);
        layoutSlangMean.putConstraint(SpringLayout.NORTH, lblMean, 6, SpringLayout.NORTH, pnlmean);
        layoutSlangMean.putConstraint(SpringLayout.WEST, tfMean, 6, SpringLayout.EAST, lblMean);
        layoutSlangMean.putConstraint(SpringLayout.NORTH, tfMean, 6, SpringLayout.NORTH, pnlmean);
        layoutSlangMean.putConstraint(SpringLayout.EAST, pnlmean, 6, SpringLayout.EAST, tfMean);
        layoutSlangMean.putConstraint(SpringLayout.SOUTH, pnlmean, 6, SpringLayout.SOUTH, tfMean);

        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(pnlslang);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        form.add(pnlmean);
        
        JPanel bottomPanel = new JPanel();
        btnBack = new JButton("Back ");
        
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnAdd = new JButton("Add");
        // btnBack.addActionListener(this);
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(this);
        btnAdd.setAlignmentX(CENTER_ALIGNMENT);
        bottomPanel.add(btnBack);
        bottomPanel.add(btnAdd);

        // Setting content
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(titleLabel);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(form);
        con.add(Box.createRigidArea(new Dimension(0, 10)));
        con.add(bottomPanel);
        // Setting Frame
        this.setTitle("Add SlangWord");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
