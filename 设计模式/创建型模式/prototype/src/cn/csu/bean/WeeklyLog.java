package cn.csu.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class WeeklyLog implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WeeklyLog(){
		
	}
	
	public WeeklyLog(String content, String name, String date) {
		super();
		this.content = content;
		this.name = name;
		this.date = date;
	}

	private String content;
	private String name;
	private String date;
	private int[] a = new int[2];

	@Override
	public String toString() {
		return "WeeklyLog [content=" + content + ", date=" + date + ", name="
				+ name + "]";
	}

	//Éî¿ËÂ¡
	public Object deepClone() throws IOException, ClassNotFoundException {

		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;

		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);
			
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			return ois.readObject();

		} finally {
			if (bos != null) {
				bos.close();
			}
			if (oos != null) {
				oos.close();
			}
			if (ois != null) {
				ois.close();
			}
			if (bis != null) {
				bis.close();
			}
		}
	}

	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public int[] disPlayArray() {

		return a;

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
