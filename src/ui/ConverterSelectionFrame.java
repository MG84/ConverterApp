package ui;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConverterSelectionFrame extends Frame implements ItemListener{

	private static final long serialVersionUID = 1L;
	private Choice converterChoice;
	private Label chooseLabel;
	private ConverterFrameFactory manager;
	
	public ConverterSelectionFrame(ConverterFrameFactory frameFactory) {
		this.manager = frameFactory;
		setTitle("Converter App");
		setLayout(new FlowLayout());
		initializeElements();
		
		setSize(350, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	private void initializeElements() {
		chooseLabel = new Label("Choose a Converter");
		converterChoice = new Choice();
		
		int counter = 0;
		for (String converter: this.manager.getConvertersName()){
			converterChoice.insert(converter, counter++);
		}
		converterChoice.addItemListener(this);
		add(chooseLabel);
		add(converterChoice);
		
		addWindowListener(new WindowAdapter(){
			  public void windowClosing(WindowEvent we){
			    System.exit(0);
			  }
			});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.manager.startConverterFrame(converterChoice.getSelectedItem());
	}

}
