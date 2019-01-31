package chapter04;

/**
 * 6-10
 */
public class Synchronized {
    public static void main(String[] args) {
        // 对Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {

        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
}







//Compiled from "Synchronized.java"
//public class chapter04.Synchronized {
//  public chapter04.Synchronized();
//    Code:
//       0: aload_0
//       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//       4: return
//
//  public static void main(java.lang.String[]);
//    Code:
//       0: ldc           #2                  // class chapter04/Synchronized
//       2: dup
//       3: astore_1
//       4: monitorenter
//       5: aload_1
//       6: monitorexit
//       7: goto          15
//      10: astore_2
//      11: aload_1
//      12: monitorexit
//      13: aload_2
//      14: athrow
//      15: invokestatic  #3                  // Method m:()V
//      18: return
//    Exception table:
//       from    to  target type
//           5     7    10   any
//          10    13    10   any
//
//  public static synchronized void m();
//    Code:
//       0: return
//}
