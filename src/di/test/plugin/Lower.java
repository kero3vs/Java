package di.test.plugin;

import di.test.IF.Convert;

public class Lower implements Convert {

	@Override
	public String convert(String s) {

		return s.toUpperCase();
	}

}
