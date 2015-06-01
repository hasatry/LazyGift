package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;
import com.nju.util.data.Position;

public interface OrderManagerService {

	/**
	 * ���ݹ�����Աid�Ͷ���״̬������ڸ�Ա���ض�״̬�Ķ���
	 * @param staffId
	 * @param states
	 * @return
	 */
	public List<Order> getOrdersByStaffId(long staffId, int[] states);
	
	/**
	 * ������Ʒ����
	 * @param orderId
	 * @param pos
	 * @return
	 */
	public boolean BuyGoods(long orderId, Position pos);

	public boolean saveOrder(OrderDO order);
}
