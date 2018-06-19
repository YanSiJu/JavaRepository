package cn.ccsu.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class LambdaTest {

	
//	@SuppressWarnings("unused")
	public static void main(String[] args){
		
		Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
		System.out.println(comparator.compare(5, 20));
		int n = 100;
		Runnable r = ()->{
			
			for(int i=0; i<n; i++){
				
				System.out.println(Thread.currentThread().getName()+":"+(i+1));
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		
	}
	
	
	
	@Test
	public void test(){
		
		
		List<String> list = Arrays.asList("Java","Linus","cobol","Haskel","python");
		list.forEach(System.out::println);
	}
	
}
