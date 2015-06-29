package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;
import com.nju.util.data.Position;

public interface OrderManagerService {

	/**
	 * 根据工作人员id获得未处理订单
	 * @param staffId
	 * @return
	 */
	public List<Order> getUntreatedOrder(long staffId);
	
	/**
	 * 购买商品操作
	 * @param orderId
	 * @param pos
	 * @return
	 */
	public boolean savePurchaseGoods(long orderId, Position pos);

	public boolean saveOrder(OrderDO order);
	
	public String findOrder(int OrderId);
}
