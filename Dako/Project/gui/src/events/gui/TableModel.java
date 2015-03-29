package events.gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] columnNames = { "#", "Timestamp", "User Id", "Message", "Sentiment", "Geolocated" };
	
	private ArrayList<DataEntry> data;	
	public TableModel(){
		data = new ArrayList<DataEntry>();
	}
	
	public void addEntry(DataEntry newEntry){
		data.add(newEntry);
		fireTableDataChanged();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		Object result = null;
		DataEntry entry = data.get(row);
		switch (col) {
		case 0:
			result = new Integer(entry.getNumber());
			break;
		case 1:
			result = entry.getTimeStamp();
			break;
		case 2:
			result = entry.getUserId();
			break;
		case 3:
			result = entry.getMessage();
			break;
		case 4:
			result = entry.getSentiment();
			break;
		case 5:
			result = new Boolean(entry.isGeolocated());
			break;
		}
		return result;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex==0){
			return Integer.class;
		} else if (columnIndex==5){
			return Boolean.class;
		} else {
			return String.class;
		}
	}
}
