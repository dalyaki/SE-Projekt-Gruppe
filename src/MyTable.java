import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
	
	
	
	


//TableModel that returns the actual class and not String
//May or may not be needed
class MyModel extends DefaultTableModel{
	Class[] columnClass= new Class[] {String.class, String.class, String.class, Integer.class, String.class};
	
	MyModel(Object[][] data, String[] columnNames){
		super(data, columnNames);
	}
	@Override
	public Class getColumnClass(int column){
		return columnClass[column];
	}
}

//Non-editable JTable of MyTableModel with RowSorter
public class MyTable extends JTable{
	
	MyModel model;
	TableRowSorter sorter;
	ArrayList<JCheckBox> searchCheckboxes = new ArrayList<>();
	
	MyTable(Object[][] data, String[] columnNames){
		model= new MyModel(data, columnNames);
		setModel(model);
		sorter = new TableRowSorter<>(model);
		setRowSorter(sorter);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		
	}
	@Override
	//make all cells non-editable
	public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	
	@Override
	// returns selected checkboxes
	public int[] getSelectedColumns() {
		//System.out.println("Hello from selection");
		ArrayList<Integer> indexesOfSelected = new ArrayList<Integer>();
		for (int i = 0; i < this.searchCheckboxes.size(); ++i) {
			JCheckBox box = this.searchCheckboxes.get(i);
			//System.out.println(box.isSelected());
			if (box.isSelected()) {
				indexesOfSelected.add(i);
			}
		}
		
		int[] rv = new int[indexesOfSelected.size()];
		// java is stupid
		for (int i = 0; i < rv.length; i++) {
			rv[i] = indexesOfSelected.get(i);
		}
		return rv;

	}
	}
	ArrayList<JCheckBox> getCheckboxes() {
		return this.searchCheckboxes;
	}
	
}
