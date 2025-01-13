package com.gcu.business;

import java.util.ArrayList;
import java.util.List;
import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessInterface 
{

	@Override
	public void test() 
	{
		// TODO Auto-generated method stub
		System.out.println("Hello from the AnotherOrdersBusinessService");
	}

	@Override
	public List<OrderModel> getOrders() 
	{
		// TODO Auto-generated method stub
		List<OrderModel> AOBSorders = new ArrayList<OrderModel>();
		AOBSorders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
		AOBSorders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
		AOBSorders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
		AOBSorders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
		AOBSorders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));
		return AOBSorders;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init method called from AnotherOrdersBusinessService");	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method called from AnotherOrdersBusinessService");
	}

}
