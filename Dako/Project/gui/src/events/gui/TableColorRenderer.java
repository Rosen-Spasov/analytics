package events.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableColorRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	private int VALIDATION_COLUMN = 4;

	public TableColorRenderer() {
		setOpaque(true);
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		Component comp = table.getDefaultRenderer(table.getModel().getColumnClass(col)).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col); 

		String s = table.getModel().getValueAt(row, VALIDATION_COLUMN).toString();

		if (s.equalsIgnoreCase("pos")) {
			comp.setBackground(Color.GREEN);
		} else if (s.equalsIgnoreCase("neg")) {
			comp.setBackground(Color.RED);
		} else if (s.equalsIgnoreCase("neu")) {
			comp.setBackground(null);
		}
		return (comp);
	}
}