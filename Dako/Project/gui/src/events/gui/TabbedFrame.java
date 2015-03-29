package events.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.TableCellRenderer;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

class TabbedFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JPanel panel2;
	private TableModel tableModel;
	private JMapViewer map;

	public TabbedFrame(TableModel tableModel, JMapViewer map) {
		this.tableModel = tableModel;
		this.map = map;
		setTitle("Events Monitor");
		setSize(640, 480);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		createTab1();
		createTab2();

		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Event", panel1);
		tabbedPane.addTab("Map", panel2);
		topPanel.add(tabbedPane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void createTab1() {
		JTable table = new JTable(tableModel);
		table.setFillsViewportHeight(true);
		
		TableCellRenderer renderer = new TableColorRenderer();
		
		for (int i =0; i < table.getColumnCount(); i++){
			table.getColumnModel().getColumn(i).setCellRenderer(renderer);
		}

		JScrollPane scrollPane = new JScrollPane(table);
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,0));
		panel1.add(scrollPane);
	}

	public void createTab2() {
        map.setBounds(0, 0, 640, 480);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,0));
		panel2.add(map);
	}
}