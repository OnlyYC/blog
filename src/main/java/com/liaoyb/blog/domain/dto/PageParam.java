package com.liaoyb.blog.domain.dto;

import com.liaoyb.blog.util.Convert;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoyb
 */
public class PageParam {
	private PageDto pageDto;
	private List<OrderDto> orderDtos;

	public PageDto getPageDto() {
		return pageDto;
	}

	public void setPageDto(PageDto pageDto) {
		this.pageDto = pageDto;
	}

	public List<OrderDto> getOrderDtos() {
		return orderDtos;
	}

	public void setOrderDtos(List<OrderDto> orderDtos) {
		this.orderDtos = orderDtos;
	}

	public PageRequest convertToPageRequest(){
		PageParam2PageRequestConvert convert = new PageParam2PageRequestConvert();
		return convert.doForward(this);
	}


	//must set page、size
	public static Builder builder(){
		return new Builder();
	}
	//builder
	public static class Builder{
		private int page;
		private int size;
		private List<OrderDto> orderDtos;
		//page从0开始，size大于0
		public Builder page(int page,int size){
			this.page=page;
			this.size=size;
			return this;
		}
		public Builder order(Direction direction,String property){
			if(orderDtos==null){
				orderDtos=new ArrayList<>();
			}
			OrderDto orderDto=new OrderDto();
			orderDto.setDirection(direction.name());
			orderDto.setProperty(property);
			orderDtos.add(orderDto);
			return this;
		}
		public PageParam build(){
			PageParam pageParam=new PageParam();
			pageParam.setOrderDtos(orderDtos);
			PageDto pageDto=new PageDto();
			if(page<0||size<=0){
				throw new IllegalArgumentException("page or size not visible");
			}
			pageDto.setPage(page);
			pageDto.setSize(size);
			pageParam.setPageDto(pageDto);
			return pageParam;
		}
	}

	public static enum Direction{
		ASC, DESC;
	}

	public static class OrderDto {
		//DESC,ASC
		private String direction;
		private String property;

		public String getDirection() {
			return direction;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}

		public String getProperty() {
			return property;
		}

		public void setProperty(String property) {
			this.property = property;
		}
	}

	public static class PageDto {
		private int page;
		private int size;

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}
	}

	private static class PageParam2PageRequestConvert extends Convert<PageParam,PageRequest>{
		@Override
		protected PageRequest doForward(PageParam pageParam) {
			//pageDto、size
			int page=0;
			int size=10;
			if(pageParam.pageDto !=null){
				page= pageParam.pageDto.getPage();
				size= pageParam.pageDto.getSize();
			}

			//Sort
			Sort sort=null;
			if(!StringUtils.isEmpty(pageParam.orderDtos)){
				List<Sort.Order>orderList= new ArrayList<>();
				for(OrderDto orderDto : pageParam.orderDtos){
					Sort.Order order= new Sort.Order(Sort.Direction.valueOf(orderDto.getDirection()), orderDto.getProperty());
					orderList.add(order);
				}
				sort=new Sort(orderList);
			}
			return new PageRequest(page,size,sort);
		}

		@Override
		protected PageParam doBackward(PageRequest pageRequest) {
			throw new AssertionError("not support");
		}
	}
}
