package com.nju.data.dao.impl;

import java.util.List;

import com.nju.data.dao.GoodsDao;
import com.nju.data.dataobject.GoodsDO;
import com.nju.model.Good;
import com.nju.util.data.Position;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class GoodsDaoImpl extends HibernateDaoSupport implements GoodsDao{

	@Override
	public List<Good> getGoodsList() {
		
		String sql = "from Goods";
		Session se = this.currentSession();
		Query qu = se.createQuery(sql);
		List<Good> list = (List<Good>)qu.list();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public GoodsDO findGoodsByGoodsName(String goodsName) {
		// TODO Auto-generated method stub
		String sql = "from GoodsDO where name = '"+goodsName+"'";
		Session se = this.currentSession();
		Query qu = se.createQuery(sql);
 		List<GoodsDO> list = qu.list();
		return list.size()==0?null:list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsDO> getGoodsBySearchName(String goodsName) {
		// TODO Auto-generated method stub
		Session se = this.currentSession();
		String sql = "from GoodsDO as model where model.name like :goodsName";
		Query query = se.createQuery(sql);
		query.setString("goodsName", "%"+goodsName+"%");
		List<GoodsDO> searchedGoodsList = query.list();
		return searchedGoodsList.size()==0?null:searchedGoodsList;
	}

	@Override
	public void save(GoodsDO goods) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(goods);
		
	}

	@Override
	public boolean updateGoodsWithPos(long goodsId, Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

}
