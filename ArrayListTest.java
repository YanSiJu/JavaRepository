import java.util.ArrayList;

public class ArrayListTest {

	private ArrayList<String> linux = new ArrayList<>();
	{
		linux.add("centOS");
		linux.add("linux");
		String s = linux.get(0);
	}
	
}


/*
Compiled from "ArrayListTest.java"
public class ArrayListTest {
  public ArrayListTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: new           #2                  // class java/util/ArrayList
       8: dup
       9: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
      12: putfield      #4                  // Field linux:Ljava/util/ArrayList;
      15: aload_0
      16: getfield      #4                  // Field linux:Ljava/util/ArrayList;
      19: ldc           #5                  // String centOS
      21: invokevirtual #6                  // Method java/util/ArrayList.add:(Ljava/lang/Object;)Z
      24: pop
      25: aload_0
      26: getfield      #4                  // Field linux:Ljava/util/ArrayList;
      29: ldc           #7                  // String linux
      31: invokevirtual #6                  // Method java/util/ArrayList.add:(Ljava/lang/Object;)Z
      34: pop
      35: aload_0
      36: getfield      #4                  // Field linux:Ljava/util/ArrayList;
      39: iconst_0
      40: invokevirtual #8                  // Method java/util/ArrayList.get:(I)Ljava/lang/Object;
      43: checkcast     #9                  // class java/lang/String
      46: astore_1
      47: return
	  
}
*/