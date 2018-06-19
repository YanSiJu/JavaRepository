package cn.ccsu.subject;

public class SubjectAImplA implements ISubject {

	@Override
	public void request() {
		System.out.println("SubjectAImplA request class:"
				+ this.getClass().getName());
	}

}
