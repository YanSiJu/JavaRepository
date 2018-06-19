package com.alibaba.cglib;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.Properties;
import net.sf.cglib.proxy.CallbackFilter;

public class CallbackFilterImpl implements CallbackFilter {

	public CallbackFilterImpl() {

	}

	private static String methodName;

	static {
		InputStream in = null;
		try {
			ClassLoader loader = CallbackFilterImpl.class.getClassLoader();
			in = loader.getResourceAsStream("proxy.properties");
			Properties pros = new Properties();
			pros.load(in);
			methodName = pros.getProperty("methodName");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public int accept(Method method) {
		if (Optional.ofNullable(methodName).orElse("").equals(method.getName())) {
			return 1;
		}
		return 0;
	}

}
