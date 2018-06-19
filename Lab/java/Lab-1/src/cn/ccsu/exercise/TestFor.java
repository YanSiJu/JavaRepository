package cn.ccsu.exercise;

public class TestFor {
	
    public static void main(String[] args){
        String[] str = new String[5];
        for(String myStr : str){
               myStr = "atguigu";
               System.out.println(myStr);
         }
        for(int i = 0;i < str.length;i++){
               System.out.println(str[i]);
        }
  }


}
