package cn.csu.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoopDelete {
	public void name() {
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer x = (Integer) it.next();
			if ("".equals(x)) {
				it.remove();
			}
		}

	}

	public void deleteWithForeach() {
		List<String> list = new ArrayList<String>();
		for (String e : list) {
			if ("".equals(e)) {
				list.remove(e);
			}
		}

	}
}














public class cn.csu.list.LoopDelete {
  public cn.csu.list.LoopDelete();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public void name();
    Code:
       0: new           #2                  // class java/util/ArrayList
       3: dup
       4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
       7: astore_1
       8: aload_1
       9: invokeinterface #4,  1            // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
      14: astore_2
      15: aload_2
      16: invokeinterface #5,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
      21: ifeq          52
      24: aload_2
      25: invokeinterface #6,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
      30: checkcast     #7                  // class java/lang/Integer
      33: astore_3
      34: ldc           #8                  // String
      36: aload_3
      37: invokevirtual #9                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      40: ifeq          49
      43: aload_2
      44: invokeinterface #10,  1           // InterfaceMethod java/util/Iterator.remove:()V
      49: goto          15
      52: return

  public void deleteWithForeach();
    Code:
       0: new           #2                  // class java/util/ArrayList
       3: dup
       4: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
       7: astore_1
       8: aload_1
       9: invokeinterface #4,  1            // InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
      14: astore_2
      15: aload_2
      16: invokeinterface #5,  1            // InterfaceMethod java/util/Iterator.hasNext:()Z
      21: ifeq          54
      24: aload_2
      25: invokeinterface #6,  1            // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
      30: checkcast     #11                 // class java/lang/String
      33: astore_3
      34: ldc           #8                  // String
      36: aload_3
      37: invokevirtual #9                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      40: ifeq          51
      43: aload_1
      44: aload_3
      45: invokeinterface #12,  2           // InterfaceMethod java/util/List.remove:(Ljava/lang/Object;)Z
      50: pop
      51: goto          15
      54: return
}
