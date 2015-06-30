package com.nju.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.data.dataobject.GoodsDO;
import com.nju.model.Good;
import com.nju.service.GoodService;
import com.nju.util.ResponseBuilder;

@Controller
public class GoodsListController {
	
	@Autowired
	private GoodService goodService;
	
	
	@RequestMapping(value = "/getGoods",method = RequestMethod.POST)
	public void getGoods(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		ResponseBuilder rb = new ResponseBuilder();
		int id = Integer.parseInt(request.getParameter("Goods_ID"));
		
		GoodsDO gd = goodService.getGoodsList(id);
		String name = gd.getName();
		try{
			rb.writeJsonResponse(response, name);
		}catch(IOException e){
			
		}
	}
	

}
