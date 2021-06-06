package com.project.virtuallab;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class DasboardPanelListRenderer implements ListCellRenderer{

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		JPanel panel = (JPanel) value;
		
		return panel;
	}

}
