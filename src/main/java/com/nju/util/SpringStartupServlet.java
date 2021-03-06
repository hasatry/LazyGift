package com.nju.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nju.data.dataobject.GoodsDO;
import com.nju.service.GoodService;
import com.nju.service.UserAddressService;

@Controller
public class SpringStartupServlet extends HttpServlet {
	/**
	 * tomcat启动后，spring实例化所需对象
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private GoodService goodsService;
	@Override
	public void init() throws ServletException {
//		String user, String street, String building,String room
		if(userAddressService.getDefaultAddress("admin")==null){
			userAddressService.setDefaultAddress("admin", "汉口路", "1舍", "603");			
		}
		
//		long id, int level, long parentId, String name, String pos, String remark,int num
		if(goodsService.getGoodsByName("ABC")==null){			
			GoodsDO goods = new GoodsDO();
			goods.setLevel(1);
			goods.setParentId(0);
			goods.setName("ABC");
			goods.setPos("好又多");
			goods.setRemark("货物Goods,root，无父类");
			goods.setNum(12);
			goodsService.saveGoods(goods);
		}
		
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest reqquest,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendError(1001, "本页面不允许发送请求");
	}
	

}
