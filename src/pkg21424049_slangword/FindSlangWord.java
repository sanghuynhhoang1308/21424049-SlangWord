/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg21424049_slangword;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huynh Hoang Sang
 */
public class FindSlangWord extends JFrame implements ActionListener {
	JButton btnBack, btnFind;
	JTextField tf;
	JTable jt;
	DefaultTableModel model;
	SlangWordDetail slangword;
	String[][] result;
	
	String data[][] = { { "", "", "" } };

	FindSlangWord() throws Exception {
		Container con = this.getContentPane();
		slangword = SlangWordDetail.getInstance();
		// Title Label
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Find SlangWord");
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);



		// Form
		JPanel form = new JPanel();
		// form.setBackground(Color.black);
		JLabel formLabel = new JLabel("Input");
		tf = new JTextField();
		btnFind = new JButton("Find");
		btnFind.addActionListener(this);
		btnFind.setMnemonic(KeyEvent.VK_ENTER);
		// SpringLayout layout = new SpringLayout();
		form.setLayout(new BorderLayout(10, 10));

		form.add(formLabel, BorderLayout.LINE_START);
		form.add(tf, BorderLayout.CENTER);
		form.add(btnFind, BorderLayout.LINE_END);
		Dimension size = new Dimension(700, 50);
		form.setMaximumSize(size);
		form.setPreferredSize(size);
		form.setMinimumSize(size);
		// Table result
		JPanel panelTable = new JPanel();
		panelTable.setBackground(Color.black);

		String column[] = { "STT", "Slag", "Meaning" };

		jt = new JTable(new DefaultTableModel(column, 0));
		jt.setRowHeight(30);
		model = (DefaultTableModel) jt.getModel();
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jt.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jt.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		jt.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
//		jt.getModel().addTableModelListener(this);
		JScrollPane sp = new JScrollPane(jt);

		panelTable.setLayout(new GridLayout(1, 1));
		panelTable.add(sp);

		// Button Back
		JPanel bottomPanel = new JPanel();
		btnBack = new JButton("Back ");
		// btnBack.addActionListener(this);
		btnBack.setFocusable(false);
		bottomPanel.add(btnBack);
		btnBack.addActionListener(this);
		btnBack.setAlignmentX(CENTER_ALIGNMENT);

		// Setting Content
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(titleLabel);
		
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(form);
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(panelTable);
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(btnBack);
		// Setting JFrame
		this.setTitle("Find Slang Form");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(800, 600);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
