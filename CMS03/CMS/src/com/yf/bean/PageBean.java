package com.yf.bean;

import java.util.List;

public class PageBean<T> {
     private int count;//�ܼ�¼��
     private int page=1;//��ǰҳ��
     private int pageSize=5;//ÿҳ��ʾ�ļ�¼��
     private List<T> list;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
