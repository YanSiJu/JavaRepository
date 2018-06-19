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
	    //�����ļ�ѡ���  
	    JFileChooser chooser = new JFileChooser();  
	      
	    //��׺��������  
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(  
	            "ͨѶ¼�ļ�(*.con)", "con");  
	    chooser.setFileFilter(filter);  
	      
	    //����ķ�����������ֱ�����û����±��水ť�ҡ��ļ������ı���Ϊ�ա����û�����ȡ����ť��  
	    int option = chooser.showSaveDialog(null);  
	    if(option==JFileChooser.APPROVE_OPTION){    //�����û�ѡ���˱���  
	        File file = chooser.getSelectedFile();  
	          
	        String fname = chooser.getName(file);   //���ļ���������л�ȡ�ļ���  
	          
	        //�����û���д���ļ������������ƶ��ĺ�׺������ô���Ǹ������Ϻ�׺  
	        if(fname.indexOf(".con")==-1){  
	            file=new File(chooser.getCurrentDirectory(),fname+".con");  
	            System.out.println("renamed");  
	            System.out.println(file.getName());  
	        }  
	          
	        try {  
	            FileOutputStream fos = new FileOutputStream(file);  
	              
	            //д�ļ���������  
	              
	            fos.close();  
	              
	        } catch (IOException e) {  
	            System.err.println("IO�쳣");  
	            e.printStackTrace();  
	        }     
	    }  
	}  


}
