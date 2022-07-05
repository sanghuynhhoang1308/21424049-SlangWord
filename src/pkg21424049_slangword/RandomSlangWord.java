/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21424049_slangword;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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
public class RandomSlangWord extends JFrame implements ActionListener {
	JButton btnReturn, btnReset;
	SlangWordDetail slangWord = SlangWordDetail.getInstance();
	JLabel lbel2, lbel4;

	RandomSlangWord() {
		
		Container con = this.getContentPane();

		// Title
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("On this day slang word");
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		titlePanel.add(titleLabel);
		titlePanel.setBackground(Color.GRAY);
		titleLabel.setForeground(Color.white);
		titlePanel.setMaximumSize(new Dimension(200, 200));

		// Slang word
		String s[] = slangWord.RandomSlang();
	
		JPanel slangPanel = new JPanel();
		
		JLabel lbel1 = new JLabel("SlangWord-- \t");
		lbel2 = new JLabel(s[0]);
		JLabel lbel3 = new JLabel("\n: \t");
		lbel4 = new JLabel(s[1]);
		lbel2.setForeground(Color.YELLOW);
		lbel4.setForeground(Color.red);
		lbel1.setFont(new Font("Serif", Font.PLAIN, 30));
		lbel2.setFont(new Font("Serif", Font.BOLD, 30));
		lbel3.setFont(new Font("Serif", Font.PLAIN, 30));
		lbel4.setFont(new Font("Serif", Font.ITALIC, 30));
		// slangLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		slangPanel.add(lbel1);
		slangPanel.add(lbel2);
		slangPanel.add(lbel3);
		slangPanel.add(lbel4);

		// Bottom btnback btnRenew
		btnReset = new JButton("Reset");
		btnReturn = new JButton("<-- Back");
		btnReturn.addActionListener(this);
		btnReset.addActionListener(this);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(btnReset);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(btnReturn);

		// Setting con
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(titlePanel);
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(slangPanel);
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(buttonPane);
		// Setting JFrame
		this.setTitle("Ramdom Slangwords");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(650, 400);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnReturn) {
			this.dispose();
			new Menu();
		} else if (e.getSource() == btnReset) {
			String s[] = slangWord.RandomSlang();
			lbel2.setText(s[0]);
			lbel4.setText(s[1]);
		}
	}

}

