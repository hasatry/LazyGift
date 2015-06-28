package com.nju.data.dao;

 import java.util.List;

import com.nju.data.dataobject.GoodsDO;

public interface GoodsDao {
	List<String> getGoodsList();

	GoodsDO findGoodsByGoodsName(String orderGoodsName);

	List<GoodsDO> getGoodsBySearchName(String goodsName);

	void save(GoodsDO goods);

}
