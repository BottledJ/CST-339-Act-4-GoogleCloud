package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>
{
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default constructor for constructor injection.
	 */
	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) 
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * CRUD: Finder to return all entities
	 */
	@Override
	public List<OrderEntity> findAll() 
	{
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		try 
		{
			// Get all the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		// Return the List
		return orders;
	}

	/**
	 * CRUD: Finder to return a single entity
	 */
	@Override
	public OrderEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * CRUD: Create an entity
	 */
	@Override
	public boolean create(OrderEntity order) 
	{
		// Example of "overriding" the CrudRepository save() because it simply is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
		try 
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql, order.getOrderNo(),
										   order.getProductName(),
										   order.getPrice(),
										   order.getQuantity());
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(OrderEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

}
