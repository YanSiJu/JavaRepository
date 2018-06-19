package sample;

public class CounterBean {
	public CounterBean(){}
	public CounterBean(int count){
		this.count = count;
	}
	
	private int count=0;
	public int getCount(){
		return ++count;
	}
	
	public void setCount(int count){
		this.count=count;
	}
}

