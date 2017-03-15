package com.liaoyb.blog.domain.dto;

import com.liaoyb.blog.util.Convert;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author liaoyb
 */
public class PageDto<T> {
	private List<T> content;
	private long total;
	private long totalPages;
	private int number;
	private int size;
	private boolean first;
	private boolean last;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}


	/**
	 * convert Page to PageDto
	 *
	 * @param page page data
	 * @param <T> data
	 * @throws IllegalArgumentException if page is null
	 * @return PageDto
	 */
	public static <T> PageDto<T> convertFor(Page<T>page){
		Assert.notNull(page);
		PageDtoConvert<T> pageDtoConvert=new PageDtoConvert<>();
		return pageDtoConvert.doBackward(page);
	}
	private static  class  PageDtoConvert<T> extends Convert<PageDto<T>,Page<T>> {
		@Override
		protected Page<T> doForward(PageDto<T> tPageDto) {
			throw new AssertionError("not support");
		}

		@Override
		protected PageDto<T> doBackward(Page<T> ts) {
			PageDto<T> pageDto=new PageDto<>();
			pageDto.setContent(ts.getContent());
			pageDto.setTotal(ts.getTotalElements());
			pageDto.setTotalPages(ts.getTotalPages());
			pageDto.setNumber(ts.getNumber());
			pageDto.setSize(ts.getSize());
			pageDto.setFirst(ts.isFirst());
			pageDto.setLast(ts.isLast());
			return pageDto;
		}
	}
}
