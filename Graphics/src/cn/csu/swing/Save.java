package cn.csu.swing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.junit.Test;

public class Save {
	
	@Test
	public void saveFile() {  
	    //弹出文件选择框  
	    JFileChooser chooser = new JFileChooser();  
	      
	    //后缀名过滤器  
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(  
	            "通讯录文件(*.con)", "con");  
	    chooser.setFileFilter(filter);  
	      
	    //下面的方法将阻塞，直到【用户按下保存按钮且“文件名”文本框不为空】或【用户按下取消按钮】  
	    int option = chooser.showSaveDialog(null);  
	    if(option==JFileChooser.APPROVE_OPTION){    //假如用户选择了保存  
	        File file = chooser.getSelectedFile();  
	          
	        String fname = chooser.getName(file);   //从文件名输入框中获取文件名  
	          
	        //假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀  
	        if(fname.indexOf(".con")==-1){  
	            file=new File(chooser.getCurrentDirectory(),fname+".con");  
	            System.out.println("renamed");  
	            System.out.println(file.getName());  
	        }  
	          
	        try {  
	            FileOutputStream fos = new FileOutputStream(file);  
	              
	            //写文件操作……  
	              
	            fos.close();  
	              
	        } catch (IOException e) {  
	            System.err.println("IO异常");  
	            e.printStackTrace();  
	        }     
	    }  
	}  


}
