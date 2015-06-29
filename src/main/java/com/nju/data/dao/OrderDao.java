package com.nju.data.dao;

import java.util.List;

import com.nju.data.dataobject.OrderDO;

public interface OrderDao {

	public boolean addOrder(OrderDO orderDO);
	
	/**
	 * 根据工作人员和状态获得订单
	 * @param staffId
	 * @param states
	 * @return
	 */
	public List<OrderDO> getOrderByStaffIdandState(long staffId, int state);
	
	/**
	 * 改变订单号标识订单的状态,返回该订单的goodsId
	 * @param orderId
	 * @param state
	 * @return
	 */
	public long saveState(long orderId, int state);

	public void save(OrderDO order);
	
	public OrderDO findOrderById(int orderId);
	public String getHotLocation(int rankBegin, int rankEnd, String dateBegin, String dateEnd);
}
