import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	
	
	
	


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
	//Will later implement the checkbox selection
	public int[] getSelectedColumns(){
		int[] columns= {0};
		return columns;
		
	}
	public static void main(String[] Args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame=new JFrame("Mytable");
		frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
	    frame.setLocation(1000,50);
	    Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
	    String[] columnNames = {"First Name",
	            "Last Name",
	            "Sport",
	            "# of Years",
	            "Vegetarian"};
	    JTextField searchfield =new JTextField(10);
	    MyTable table= new MyTable(data, columnNames);
		table.setVisible(true);
	    searchfield.getDocument().addDocumentListener(new DocumentListener(){
	    	//Refilter Table after each change on searchfield
	    	 @Override
	    	 //when new symbol is typed
	         public void insertUpdate(DocumentEvent e) {
	           search(searchfield.getText());
	         }
	         @Override
	         //when symbol is deleted
	         public void removeUpdate(DocumentEvent e) {
	            search(searchfield.getText());
	         }
	         @Override
	         //other changes(pasted text, etc.)
	         public void changedUpdate(DocumentEvent e) {
	            search(searchfield.getText());
	         }
	         public void search(String str) {
	        	 //show all rows
	            if (str.length() == 0) {
	               table.sorter.setRowFilter(null);
	            } 
	            //set filter to the string, case insensitive
	            else {
	               table.sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + str)/*, table.getSelectedColumns() */));
	            }
	    	
	    	
	    }
	    });
		//BUTTONPANEL
	    JButton delPB, addPB;
		delPB= new JButton("Produkt entfernen");
		delPB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
		     {		//any row selected
				int row=table.getSelectedRow();
		        if (row!=-1) {
		        	JOptionPane.showMessageDialog(frame,table.getValueAt(row, 0)+ " will be deleted", "", JOptionPane.WARNING_MESSAGE);
		           }
		          
		         }
		       });
			
	    
		
		JScrollPane scrollpane = new JScrollPane(table);
	    JPanel panel= new JPanel();
	    panel.setMaximumSize(new Dimension(300,400));
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.add(delPB);
	    panel.add(searchfield);
	    scrollpane.setVisible(true);
	    frame.add(panel);
		frame.add(scrollpane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//table.setFillsViewportHeight(true);
	}
	
	
}
