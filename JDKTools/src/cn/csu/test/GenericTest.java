package cn.csu.test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	@SuppressWarnings("unused")
	public void genericwithArguementType() {
		List<String> list = new ArrayList<>();
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void genericwithoutArguementType() {
		List list = new ArrayList<>();
	}

}
/*Compiled from "GenericTest.java"
public class cn.csu.test.GenericTest {
  public cn.csu.test.GenericTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void genericwithArguementType();
    Code:
       0: new           #2                  // class java/util/ArrayList
       3: dup
       4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
       7: astore_1
       8: return

  public void genericwithoutArguementType();
    Code:
       0: new           #2                  // class java/util/ArrayList
       3: dup
       4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
       7: astore_1
       8: return
}*/
