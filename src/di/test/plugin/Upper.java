package di.test.plugin;

import di.test.IF.Convert;

public class Upper implements Convert {

	@Override
	public String convert(String s) {

		return s.toLowerCase();
	}

}
