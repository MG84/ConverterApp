package ui;

import java.util.HashMap;
import java.util.Set;

import main.ConverterAdapter;

public class ConverterFrameFactory {

	private HashMap<String, ConverterFrame> frameConverters;
	
	public ConverterFrameFactory(ConverterAdapter adapter) {
		this.frameConverters = new HashMap<String, ConverterFrame>();
		addCoverter(new CelsiusFahrenheitFrame(adapter));
		addCoverter(new FizzBuzzFrame(adapter));
	}
	
	private void addCoverter(ConverterFrame converterFrame) {
		this.frameConverters.put(converterFrame.name(), converterFrame);
	}

	public Set<String> getConvertersName() {
		return this.frameConverters.keySet();
	}

	public void startConverterFrame(String converterName) {
		ConverterFrame converterFrame = (ConverterFrame) this.frameConverters.get(converterName);
		converterFrame.setVisible();
	}

	public void startConverterUI() {
		new ConverterSelectionFrame(this);
	}
}
