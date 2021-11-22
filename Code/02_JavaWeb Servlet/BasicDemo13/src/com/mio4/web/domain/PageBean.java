package com.mio4.web.domain;

import java.util.List;

public class PageBean<T> {
	private List<T> list; //当前页的内容
	private int currPage; //当前页码
	private int pageSize; //每页显示的数据条数
	private int totalCount; //总条数
	private int totalPage; //总页数

	public PageBean(){
		super();
	}

	public PageBean(List<T> list, int currPage, int pageSize, int totalCount){
		super();
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

/*	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}*/

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return (int) Math.ceil(totalCount*1.0/pageSize);
	}
}
