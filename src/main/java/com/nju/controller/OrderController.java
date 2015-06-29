package com.nju.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.GoodsDO;
import com.nju.data.dataobject.OrderDO;
import com.nju.service.GoodService;
import com.nju.service.OrderManagerService;
import com.nju.util.DateUtil;
import com.nju.util.ResponseBuilder;


@Controller
public class OrderController {
	
	@Autowired
	private OrderManagerService orderService;
	@Autowired
	private GoodService goodsService;
	
	@RequestMapping(value = "/confirmOrderSubmit",method = RequestMethod.POST) 
	public void confirmOrderSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		ResponseBuilder rb = new ResponseBuilder();
		long userId = 0 ;
		double total_price = 0.0;
		Timestamp deliveryTime = null;
		long goods_id = 1;
		int state = 1;//代表订单生成
		String totalPrice = request.getParameter("totalPrice");
		if(!totalPrice.equals(null)&&!totalPrice.equals("")){
			total_price = Double.parseDouble(totalPrice);
		}else{
			try {
				rb.writeJsonResponse(response, "价格不能为空");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
 		}
  		String deliveryTimeStr = request.getParameter("deliveryTime");
		if(!deliveryTimeStr.equals(null)&&!deliveryTimeStr.equals("")){
			System.out.println("货物需要送达时间为："+deliveryTimeStr);
	 		deliveryTime = DateUtil.getTime(deliveryTimeStr);//格式如下："2015-06-01 15:50"
		}else{
			try {
				rb.writeJsonResponse(response, "送达时间不能为空");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
 		} 		
		String orderDestiantion = request.getParameter("destination");
		if(orderDestiantion.equals(null)||orderDestiantion.equals("")){
			try {
				rb.writeJsonResponse(response, "目的地址不能为空");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String orderGoodsName = request.getParameter("goodsName");
		if(!orderGoodsName.equals(null)&&!orderGoodsName.equals("")){
			System.out.println("需要购买的货物名称为："+orderGoodsName);
			GoodsDO orderGoods = goodsService.getGoodsByName(orderGoodsName);
			goods_id = (orderGoods==null)?0:orderGoods.getId();
		}else{
			try {
				rb.writeJsonResponse(response, "要购买的货物名称不能为空");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
 		}


		Timestamp orderStartTime = new Timestamp(new Date().getTime());
		String remark = request.getParameter("remarks");
 		OrderDO order = new OrderDO(userId,total_price,deliveryTime,orderDestiantion,goods_id,state,orderStartTime,remark);
         try {
        	System.out.println("保存新的订单到数据库");
        	orderService.saveOrder(order);	
			rb.writeJsonResponse(response, order);//第二位参数不能为字符串
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
