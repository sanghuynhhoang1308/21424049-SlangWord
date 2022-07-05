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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huynh Hoang Sang
 */
public class DeleteSlangWord extends JFrame implements ActionListener {
	JButton btnBack;
	JTable jtbl;
	SlangWordDetail slangWord;
	DefaultTableModel model;
	String data[][];

	public DeleteSlangWord() throws Exception {
		Container con = this.getContentPane();
		slangWord = SlangWordDetail.getInstance();
                String data[][] = slangWord.getData();
		data = slangWord.getData();
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Chon slangword muon xoa");
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JLabel resultLabel = new JLabel();
		resultLabel.setForeground(Color.black);
		resultLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		resultLabel.setAlignmentX(CENTER_ALIGNMENT);
		

		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(Color.black);
		data = slangWord.getData();
		String column[] = { "STT", "Slang", "Mean" };
		
		jtbl = new JTable(new DefaultTableModel(data, column));
		model = (DefaultTableModel) jtbl.getModel();
		jtbl.setRowHeight(30);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jtbl.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jtbl.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		jtbl.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                ///
		
                
                ///////
		JScrollPane sp = new JScrollPane(jtbl);
		panelTable.setLayout(new BoxLayout(panelTable, BoxLayout.X_AXIS));
		panelTable.add(sp);

		
		JPanel bottomPanel = new JPanel();
		btnBack = new JButton("Back ");
		btnBack.addActionListener(this);
		btnBack.setFocusable(false);
		btnBack.setAlignmentX(CENTER_ALIGNMENT);
		bottomPanel.add(btnBack);

	
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(Box.createRigidArea(new Dimension(0, 10)));
		con.add(titleLabel);
		con.add(Box.createRigidArea(new Dimension(0, 20)));
		con.add(resultLabel);
		con.add(Box.createRigidArea(new Dimension(0, 20)));
		con.add(panelTable);
		con.add(Box.createRigidArea(new Dimension(0, 20)));
		con.add(bottomPanel);
		// Setting JFrame
		this.setTitle("Form Delete");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(600, 750);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnBack) {
			this.dispose();
			new Menu();
		}
	}

	

	
}
