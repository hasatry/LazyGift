package com.nju.model.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.nju.data.dataobject.OrderDO;
import com.nju.model.Order;

public class OrderConventer {

	public static List<Order> ConvertFromOrderDOList(List<OrderDO> list){
		List<Order> result = new ArrayList<Order>();
		
		for(OrderDO od : list){
			result.add(ConvertFromOrderDO(od));
		}
	
		return result;
	}
	
	public static Order ConvertFromOrderDO(OrderDO od){
		
		int state = od.getState();
		String stateStr = "";
		if(state == 0)
			stateStr = "´ý¹ºÂò";
		else if(state == 1)
			stateStr = "ÒÑ¹ºÂò";
		
		String tsStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm"); 
        tsStr = sdf.format(od.getCreateTime());   
		
		return new Order(od.getId(), od.getRemark(), od.getTotalPrice(), tsStr ,stateStr);
	}
}
