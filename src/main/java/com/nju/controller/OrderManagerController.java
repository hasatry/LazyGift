package com.nju.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.model.Order;
import com.nju.service.OrderManagerService;
import com.nju.util.ResponseBuilder;

@Controller
public class OrderManagerController {
	
	@Autowired
	private OrderManagerService orderService;
	
	private List<Order> list = null;
	
	@RequestMapping(value = "/getorderlist",method = RequestMethod.POST)
	public void getOrderList(HttpServletRequest request, HttpServletResponse response, ModelMap model){		
		ResponseBuilder rb = new ResponseBuilder();
		
		if(list == null){
			intialize();
		}
		
		orderService.BuyGoods(1, null);
		List<Order> re = new ArrayList<Order>();
		for(Order o : list){
			if(o.getState().equals("������")){
				re.add(o);
			}
		}
		
		try {
			rb.writeJsonResponse(response, re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/buyorder",method = RequestMethod.POST)
	public void buyOrder(HttpServletRequest request, HttpServletResponse response, ModelMap model){		
		ResponseBuilder rb = new ResponseBuilder();
		
		boolean re = true;
		
		String id = request.getParameter("id");
		
		int i = Integer.parseInt(id);
		list.get(i+1).setState("�ѹ���");
		
		try {
			rb.writeJsonResponse(response, re);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void intialize(){
		list = new ArrayList<Order>();
		
		list.add(new Order(1,"����",5.0,"6.1 15:24","������"));
		list.add(new Order(2,"С��ܸɴ���",3.0,"3.06.1 15:32","������"));
		list.add(new Order(3,"ѩ��",6.0,"6.1 15:34","������"));
		list.add(new Order(4,"ɳ��С�� ±�ⷹ",16.0,"6.1 15:35","������"));
		list.add(new Order(5,"5�ŵ��",6.0, "9:26","������"));
	}
}
