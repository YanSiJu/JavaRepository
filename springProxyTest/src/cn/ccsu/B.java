package cn.ccsu;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class B extends A {

	public B() {

	}

	@Transactional
	public void testAnno() {
	}
}
