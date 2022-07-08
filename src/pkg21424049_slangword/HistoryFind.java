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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Huynh Hoang Sang
 */
public class HistoryFind extends JFrame implements ActionListener {
	JButton btnBack, btnExit;
	SlangWordDetail slangWord = SlangWordDetail.getInstance();

	HistoryFind() {
		Container con = this.getContentPane();

		// History
		JLabel historyLabel = new JLabel();
		historyLabel.setText("History Slagword Found");
		historyLabel.setForeground(Color.green);
		historyLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 35));
		historyLabel.setAlignmentX(CENTER_ALIGNMENT);
		// Table
		JPanel panelTable = new JPanel();
		panelTable.setBackground(Color.black);

		String data[][] = slangWord.readHistory();
		String column[] = { "STT", "Slang Word", "Definition" };
		JTable jt = new JTable(data, column);
		jt.setRowHeight(30);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		jt.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		jt.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		jt.setEnabled(false);
		JScrollPane sp = new JScrollPane(jt);
		panelTable.setLayout(new GridLayout(1, 1));
		panelTable.add(sp);

		// 2 Button
		JPanel bottomPanel = new JPanel();
		btnBack = new JButton("Return");
		btnExit = new JButton("Exit");
		btnBack.addActionListener(this);
		btnExit.addActionListener(this);
		Dimension size2 = new Dimension(700, 50);
		bottomPanel.setMaximumSize(size2);
		bottomPanel.setPreferredSize(size2);
		bottomPanel.setMinimumSize(size2);
		bottomPanel.setLayout(new GridLayout(1, 2));
		bottomPanel.add(btnBack);
		bottomPanel.add(btnExit);

		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(historyLabel);
		con.add(Box.createRigidArea(new Dimension(0, 50)));
		con.add(panelTable);
		con.add(Box.createRigidArea(new Dimension(0, 50)));
		con.add(bottomPanel);

		// Setting JFrame
		this.setTitle("History Find Form");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(700, 700);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnExit) {
			System.exit(0);
		} else if (e.getSource() == btnBack) {
			this.dispose();
			new Menu();
		}
	}

}
