package com.nju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nju.model.Good;
import com.nju.service.GoodService;
import com.nju.data.dao.GoodsDao;
import com.nju.data.dataobject.GoodsDO;

public class GoodServiceImpl implements GoodService{

	@Autowired
	private GoodsDao goodsDao;


	@Override
	public GoodsDO getGoodsByName(String orderGoodsName) {
		// TODO Auto-generated method stub
		return goodsDao.findGoodsByGoodsName(orderGoodsName);
 	}

	@Override
	public List<GoodsDO> searchGoodsByName(String goodsName) {
		// TODO Auto-generated method stub
		List<GoodsDO> searchedGoodsList = goodsDao.getGoodsBySearchName(goodsName);
		return searchedGoodsList;
	}

	@Override
	public void saveGoods(GoodsDO goods) {
		// TODO Auto-generated method stub
		goodsDao.save(goods);
	}

	@Override
	public List<Good> getGoodsList() {
		// TODO Auto-generated method stub
		List<Good> list = goodsDao.getGoodsList();
		return list;
	}
	
}
