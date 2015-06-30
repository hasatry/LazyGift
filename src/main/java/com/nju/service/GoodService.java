package com.nju.service;

import java.util.List;

import com.nju.data.dataobject.GoodsDO;
import com.nju.model.Good;

public interface GoodService {
	
	GoodsDO getGoodsList(int id);

	GoodsDO getGoodsByName(String orderGoodsName);

	List<GoodsDO> searchGoodsByName(String goodsName);

	void saveGoods(GoodsDO goods);
	
}
