package tools;

//Panel with textfield, label
class TextPanel extends JPanel{
	JLabel label;
	Mytextfield textfield;
	TextPanel(String str){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		label = new JLabel(str);
		textfield = new MyTextField();
		this.add(label);
		this.add(textfield);
	}
}
//subwindowtoberefined
//frame with textfield for eaxh columnname
class EditingFrame extends JFrame {
  ArrayList<TextPanel> panelList
  JButton button;
	EditingFrame(String[] columnNames) {
		super();
    setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		panel=new ArrayList<TextPanel>();
    
    //for each columname add textfield
		for (String name : columnNames) {
			panelList.add(new TextPanel(name));
		}
		for (TextPanel p: panelList) {
			this.add(p);
		}
    JButton button=new JButton("hinzufugen");
    //button function to be added
    
		setSize(300, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
