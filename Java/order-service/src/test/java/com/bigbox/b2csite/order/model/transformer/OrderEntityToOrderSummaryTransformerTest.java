package com.bigbox.b2csite.order.model.transformer;

import java.util.LinkedList;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bigbox.b2csite.order.model.domain.OrderSummary;
import com.bigbox.b2csite.order.model.entity.OrderEntity;
import com.bigbox.b2csite.order.model.entity.OrderItemEntity;

public class OrderEntityToOrderSummaryTransformerTest {
	
	private OrderEntityToOrderSummaryTransformer target = null;
	
	@Before
	public void setup() {
		
		target = new OrderEntityToOrderSummaryTransformer();
		
	}
	
	@Test
	public void test_transform_success() {
		
		String orderNumberFixture = UUID.randomUUID().toString();
		
		OrderEntity orderEntityFixture = new OrderEntity();
		orderEntityFixture.setOrderNumber(orderNumberFixture);
		orderEntityFixture.setOrderItemList(new LinkedList<OrderItemEntity>());
		
		OrderItemEntity itemFixture1 = new OrderItemEntity();
		itemFixture1.setQuantity(1);
		
		OrderSummary result = target.transform(orderEntityFixture);
		
		Assert.assertNotNull(result);
		Assert.assertEquals(orderNumberFixture, result.getOrderNumber());
		Assert.assertEquals(3, result.getItemCount());
		
	}
	
	@Test
	@Ignore
	public void test_transform_inputIsNull() {
		
	}

}
