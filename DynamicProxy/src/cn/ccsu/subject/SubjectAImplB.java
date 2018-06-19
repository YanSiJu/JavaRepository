package cn.ccsu.subject;

public class SubjectAImplB implements ISubject {

	@Override
	public void request() {
		System.out.println("SubjectAImplB request class:"
				+ this.getClass().getName());
	}

}
