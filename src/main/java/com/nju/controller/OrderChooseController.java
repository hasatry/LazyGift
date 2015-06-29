package com.nju.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.GoodsDO;
import com.nju.service.GoodService;
import com.nju.util.ResponseBuilder;

@Controller
public class OrderChooseController {
	
	@Autowired
	private GoodService goodsService;
	
	@RequestMapping(value = "/orderChoose",method = RequestMethod.POST)
	public void getOrder(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {		
		
        ResponseBuilder rb = new ResponseBuilder();
        String orderGoodsName = request.getParameter("goodsName");
        GoodsDO orderGoods = goodsService.getGoodsByName(orderGoodsName);
        System.out.println("Get Orderlist!");
		
		try {
			rb.writeJsonResponse(response,"Get Orderlist!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
}
