package com.nju.data.dao;

 import java.util.List;

import com.nju.data.dataobject.GoodsDO;
import com.nju.model.Good;
import com.nju.util.data.Position;

public interface GoodsDao {
	List<Good> getGoodsList();

	GoodsDO findGoodsByGoodsName(String orderGoodsName);

	List<GoodsDO> getGoodsBySearchName(String goodsName);

	void save(GoodsDO goods);

	/**
	 * 更新商品的地理位置信息，包括可能的计算。未完成。
	 * @param goodsId
	 * @param pos
	 * @return
	 */
	boolean updateGoodsWithPos(long goodsId, Position pos);
}
