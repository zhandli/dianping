package com.example.dianping.utils;

import lombok.Data;

import java.util.List;

/**
 * 分页结果封装
 * @author zh
 * @date 2021/7/10 13:55
 */

@Data
public class PagedGridResult {
	/**
	 * 当前页数
	 */
	private int page;

	/**
	 * 总页数
	 */
	private int total;

	/**
	 * 总记录数
	 */
	private long records;

	/**
	 * 每行显示的内容
	 */
	private List<?> rows;


}
