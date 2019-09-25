package com.bigbox.b2csite.order.model.transformer;

import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.entity.OrderItemEntity;

public class OrderEntityToOrderSummaryTransformer {

	public OrderSummary transform(OrderEntity orderEntity) {
		
		OrderSummary orderSummaryResult = new OrderSummary();
		
		orderSummaryResult.setOrderNumber(orderEntity.getOrderNumber());
		
		return orderSummaryResult;
	}

}
