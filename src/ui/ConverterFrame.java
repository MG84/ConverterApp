package ui;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ConverterFrame extends Frame{

	private static final long serialVersionUID = 11L;
	private String name;
	
	public String name() {
		return this.name;
	}

	public void setUp() {
		setTitle(name());
		setLayout(new FlowLayout());
		setSize(350, 200);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
		});
	}

	public void setVisible(){
		setVisible(true);
	}
}