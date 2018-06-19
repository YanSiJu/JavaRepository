

public class StringTest {

	public static void main(String[] args) {
		String str1 = "Ubuntu " + "Linux " + "Deepin " + "NLP";
	}

	public void reflectTest() {
		String str2 = "Ubuntu ";
		String str4 = "Linux ";
		String str6 = str2 + str4;
	}

}




C:\Users\Bill\Desktop>javap -c StringTest
Compiled from "StringTest.java"
public class StringTest {
  public StringTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String Ubuntu Linux Deepin NLP
       2: astore_1
       3: return

  public void reflectTest();
    Code:
       0: ldc           #3                  // String Ubuntu
       2: astore_1
       3: ldc           #4                  // String Linux
       5: astore_2
       6: new           #5                  // class java/lang/StringBuilder
       9: dup
      10: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
      13: aload_1
      14: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      17: aload_2
      18: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      21: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      24: astore_3
      25: return
}