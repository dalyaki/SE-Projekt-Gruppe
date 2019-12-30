package tools;
class MainFrame extends JFrame{
  MyFrame(){
      super(s); 
      JFrame.setDefaultLookAndFeelDecorated(true);
      this.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(300, 300);
      this.setLocation(1000, 50);
      //initialize the table somehow
      this.add(table);
      table.setVisible(true);
      MyTextField searchfield = new MyTextField(256);
		  searchfield.getDocument().addDocumentListener(new DocumentListener() {
			// Refilter Table after each change on searchfield
			@Override
			// when new symbol is typed
			public void insertUpdate(DocumentEvent e) {
				search(searchfield.getText());
			}

			@Override
			// when symbol is deleted
			public void removeUpdate(DocumentEvent e) {
				search(searchfield.getText());
			}

			@Override
			// other changes(pasted text, etc.)
			public void changedUpdate(DocumentEvent e) {
				search(searchfield.getText());
			}

			public void search(String str) {
				// show all rows
				if (str.length() == 0) {
					table.sorter.setRowFilter(null);
				} else if (str.length() > 2) {
					JOptionPane.showMessageDialog(frame, " Max Length arrived", "", JOptionPane.WARNING_MESSAGE);
				}
				// set filter to the string, case insensitive
				else {
						table.sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + str), 
            table.getSelectedColumns()));
					
					
				}

			}
		});
		// BUTTONPANEL
		JButton delete_button, add_button;
		delete_button = new JButton("Produkt entfernen");
		add_button = new JButton("Neues Produkt hinzufugen");
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // any row selected
				int row = table.getSelectedRow();
				if (row != -1) {
					JOptionPane.showMessageDialog(frame, table.getValueAt(row, 0) + " will be deleted", "",
							JOptionPane.WARNING_MESSAGE);
					((MyModel) table.getModel()).removeRow(row);
				}

			}
		});
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditingFrame(table.);
			}

		});

		JScrollPane scrollpane = new JScrollPane(table);
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(300, 400));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(delete_button);
		panel.add(add_button);
		panel.add(searchfield);
		
		for (JCheckBox box : table.getCheckboxes()) {
			panel.add(box);
		}
		
		scrollpane.setVisible(true);
		this.add(panel);
		this.add(scrollpane);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		table.setFillsViewportHeight(true);
  }



}
