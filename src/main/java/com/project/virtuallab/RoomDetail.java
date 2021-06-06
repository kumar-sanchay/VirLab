package com.project.virtuallab;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;

public class RoomDetail {

	private JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RoomDetail window = new RoomDetail();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public RoomDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JPanel initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 20));
		panel.setLayout(null);
		
		ImageIcon roomIcon = new ImageIcon(new ImageIcon(getClass().getResource("/meeting-room.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		JLabel lblNewLabel = new JLabel("Meeting Room");
		lblNewLabel.setIcon(roomIcon);
		lblNewLabel.setBounds(5, 5, 300, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("6 June 2021");
		lblNewLabel_1.setBounds(40, 29, 300, 15);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		panel.add(lblNewLabel_1);
		
		return panel;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
}
