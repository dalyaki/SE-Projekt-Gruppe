package tools;
import javax.swing.text.*;
import javax.swing.*;


//Textfield with character limit
class FixedSizeDocument extends PlainDocument{
	private int max = 256;
	public FixedSizeDocument(int max){
		this.max = max;
		}
	@Override
	public void insertString(int offs, String str, AttributeSet a)throws BadLocationException{
		if (getLength()+str.length()>max){
			str = str.substring(0, max - getLength());
		}

		super.insertString(offs, str, a);

	}

}

public class MyTextField extends JTextField{

	MyTextField(){
		super();
		setDocument(new FixedSizeDocument(256));
    }
	
	MyTextField(int x){
		super(x);
		setDocument(new FixedSizeDocument(int x));
    }
	
	void remove_all() {
		this.setText("");	
	}
}
