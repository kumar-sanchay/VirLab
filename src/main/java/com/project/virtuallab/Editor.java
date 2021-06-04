package com.project.virtuallab;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Editor {

	private JFrame frame;
	private int currline = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor window = new Editor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(false);
		splitPane.setDividerLocation(150);
		splitPane.setDividerSize(0);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setRowHeaderView(panel);
		panel.setBackground(new Color(105, 105, 105));
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(200, 200, 200));
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBorder(new EmptyBorder(2, 10, 2, 10));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		
		final JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(105, 105, 105));
		textArea.setForeground(Color.white);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);
		
		
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			public void insertUpdate(DocumentEvent e) {
				
				int totalLineNum = textArea.getLineCount();
				
				int diff = totalLineNum - currline;
				
				for(int idx=currline+1; idx<=totalLineNum; idx++) {
					JLabel lblNewLabel = new JLabel(String.valueOf(idx));
					lblNewLabel.setBorder(new EmptyBorder(2, 5, 2, 5));
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.gridx = 0;
					gbc_lblNewLabel.gridy = idx-1;
					panel_1.add(lblNewLabel, gbc_lblNewLabel);
				}
				
				currline = totalLineNum;
				
			}

			public void removeUpdate(DocumentEvent e) {
				int totalLineNum = textArea.getLineCount();
				int diff = currline - totalLineNum;
				Component comp[] = panel_1.getComponents();
				
				int idx = comp.length - 1;
				
				while(diff>0) {
					panel_1.remove(comp[idx]);
					idx--;
					diff--;
				}
				
				currline = totalLineNum;
				
			}

			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(150, 150, 150));
		splitPane.setLeftComponent(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_3.add(panel_4, gbc_panel_4);
		
		JButton btnNewButton = new JButton("End Meet");
		btnNewButton.setBackground(new Color(255,99,71));
		btnNewButton.setForeground(Color.WHITE);
		panel_4.add(btnNewButton);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/person.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_3.add(panel_5, gbc_panel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Sanchay Kumar");
		lblNewLabel_2.setBackground(new Color(200, 200, 200));
		lblNewLabel_2.setIcon(imageIcon);
		panel_5.add(lblNewLabel_2);
		
		JPopupMenu popupMenu = new JPopupMenu("ffffff");
		JMenuItem removeOpt = new JMenuItem("Remove");  
        JMenuItem inShareOpt = new JMenuItem("Access Share");  
        JMenuItem  outShareOpt = new JMenuItem("Revoke Share");
        
        popupMenu.add(removeOpt);
        popupMenu.add(inShareOpt);
        popupMenu.add(outShareOpt);
        
		addPopup(lblNewLabel_2, popupMenu);
		

		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenu detailsMenu = new JMenu("Details");
		menuBar.add(detailsMenu);
		
		JMenu runMenu = new JMenu("Run");
		menuBar.add(runMenu);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
