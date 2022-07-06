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
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Huynh Hoang Sang
 */
public class Menu extends JFrame implements ActionListener{
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,btn9;
	//SlangWord slangWord;

	Menu() {
		//slangWord = SlangWord.getInstance();
		// A Label
		JLabel label = new JLabel("21424049- SlangWord");
		label.setForeground(Color.red);
		label.setFont(new Font("Serif", Font.PLAIN, 25));
		label.setAlignmentX(CENTER_ALIGNMENT);
		// label.addMouseListener(this);
		// A Grid
		btn1 = new JButton("1. List SlangWords");
                btn1.addActionListener(this);
		btn1.setFont(new Font("Serif", Font.PLAIN, 14));
		btn1.setFocusable(false);

		btn2 = new JButton("2. Find SlangWord");
		btn2.addActionListener(this);
		btn2.setFont(new Font("Serif", Font.PLAIN, 14));
		btn2.setFocusable(false);

		btn3 = new JButton("3. Add New SlangWord");
		btn3.addActionListener(this);
		btn3.setFont(new Font("Serif", Font.PLAIN, 14));
		btn3.setFocusable(false);

		btn4 = new JButton("4. Random SlangWord");
		btn4.addActionListener(this);
		btn4.setFont(new Font("Serif", Font.PLAIN, 14));
		btn4.setFocusable(false);

		btn5 = new JButton("5. History Search");
		//btn5.addActionListener(this);
		btn5.setFont(new Font("Serif", Font.PLAIN, 14));
		btn5.setFocusable(false);

		btn6 = new JButton("6. Delete SlangWord");
		btn6.addActionListener(this);
		btn6.setFont(new Font("Serif", Font.PLAIN, 14));
		btn6.setFocusable(false);

		btn7 = new JButton("7. Reset SlangWord");
		//btn7.addActionListener(this);
		btn7.setFont(new Font("Serif", Font.PLAIN, 14));
		btn7.setFocusable(false);

		btn8 = new JButton("8. Quiz");
		//btn8.addActionListener(this);
		btn8.setFont(new Font("Serif", Font.PLAIN, 14));
		btn8.setFocusable(false);
                
                
                btn9 = new JButton("9. Edit Slang");
		//btn8.addActionListener(this);
		btn9.setFont(new Font("Serif", Font.PLAIN, 14));
		btn9.setFocusable(false);

		JPanel panelCenter = new JPanel();
		// panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(new GridLayout(4, 4, 10, 10));
		panelCenter.add(btn1);
		panelCenter.add(btn2);
		panelCenter.add(btn3);
		panelCenter.add(btn4);
		panelCenter.add(btn5);
		panelCenter.add(btn6);
		panelCenter.add(btn7);
		panelCenter.add(btn8);
                panelCenter.add(btn9);

		Dimension size2 = new Dimension(500, 500);
		panelCenter.setMaximumSize(size2);
		panelCenter.setPreferredSize(size2);
		panelCenter.setMinimumSize(size2);
		Container con = this.getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(Box.createRigidArea(new Dimension(0, 15)));
		con.add(label);
		con.add(Box.createRigidArea(new Dimension(0, 32)));
		con.add(panelCenter);

		// Setting Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Menu Form");
		this.setVisible(true);
		this.setSize(800, 650);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
                if (e.getSource() == btn1) {
			this.dispose();
			try {
				new ListSlangWord();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
                else if (e.getSource() == btn2) {
			System.out.println("Change Actitity");
			this.dispose();
			try {
				new FindSlangWord();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                }
                
                 else if (e.getSource() == btn3) {
			this.dispose();
			new AddSlangWord();}
                
                
                
                
                else if (e.getSource() == btn2) {
			System.out.println("Find SlangWord");
			this.dispose();
			try {
				//new FindSWFrame();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource() == btn4) {
			this.dispose();
			new RandomSlangWord();

		}
                else if (e.getSource() == btn6) {
			this.dispose();
			try {
				new DeleteSlangWord();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
                }}

}
