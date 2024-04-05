package com.orange.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.orange.model.OrderInfo;
import com.orange.model.OrderItem;


@Mapper
public interface OrderMapper {

	int count();

	void save(OrderInfo orderInfo);
	
	void saveOrderInfo(OrderInfo orderInfo);
	
	void saveOrderItems(List<OrderItem> selectedItems);
	
	 List<OrderItem> getOrderItemsByOrderId(Long orderId);
}
