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
import com.nju.service.GoodService;
import com.nju.util.ResponseBuilder;

/**
 * @author Wangy
 *
 */
@Controller
public class GoodManagerController {
	
	@Autowired
	private GoodService goodsService;
	
	@RequestMapping(value="/goods/goodsSearchByName",method = RequestMethod.GET)
	public void goodsSearchByName(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		ResponseBuilder rb = new ResponseBuilder();
		String goodsName = request.getParameter("searchGoodsName");
		if(goodsName==null||goodsName.equals("")){
			System.out.println("goodsName ²»ÄÜÎª¿Õ");
			try {
				rb.writeJsonResponse(response, "goodsName is null");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			List<GoodsDO> searchGoodsList = goodsService.searchGoodsByName(goodsName);
			try {
				rb.writeJsonResponse(response, searchGoodsList);
			} catch (IOException e) {
 				e.printStackTrace();
			}
		}
	}

}
