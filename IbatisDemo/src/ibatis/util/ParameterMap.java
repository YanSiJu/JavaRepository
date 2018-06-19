package ibatis.util;

import java.util.HashMap;

public class ParameterMap extends HashMap<Object, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParameterMap() {

	}

	public ParameterMap(Object... parameters) {
		for (int i = 0; i < parameters.length - 1; i += 2) {
			super.put(parameters[i], parameters[i + 1]);
		}
	}
	
	
}
