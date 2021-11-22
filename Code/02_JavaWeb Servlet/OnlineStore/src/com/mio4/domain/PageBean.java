package com.mio4.domain;

import java.util.List;

/**
 * 分页展示时使用
 */
public class PageBean<E> {
	private List<E> list;
	private Integer currPage; //当前页
	private Integer pageSize; //页数
	private Integer totalPage; //页总数
	private Integer totalCount; //商品数量

	public void setList(List<E> list) {
		this.list = list;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

/*	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}*/

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getList() {
		return list;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getTotalPage() {
		return (int)Math.ceil(totalCount/pageSize);
		//return totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public PageBean(List<E> list, Integer currPage, Integer pageSize, Integer totalCount) {
		this.list = list;
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
}
