package main;

import ui.ConverterFrameFactory;
import core.ConverterManager;

public class Application{

	
	public static void main(String[] args) {
		//start a new converter manager
		ConverterManager cm = new ConverterManager();
		//initialize Converters (little bit more coupled than the previous version, but it will
		//be overprovisioning)
		cm.initializeConverters();
		//start the ui with a new ConverterAdapter
		new ConverterFrameFactory(new ConverterAdapter(cm)).startConverterUI();
		
		
	}


}
