package com.nju.data.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.nju.data.dao.OrderDao;
import com.nju.data.dataobject.OrderDO;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{

	protected static Logger log = LoggerFactory.getLogger(OrderDao.class);
	
	@Override
	public boolean addOrder(OrderDO orderDO) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDO> getOrderByStaffIdandState(long staffId, int state) {
		// TODO Auto-generated method stub
		
		String sql = "from OrderDO where staffId = "+staffId+" and state = "+state;
		Session se = this.currentSession();	
		Query q = se.createQuery(sql);		
		List<OrderDO> result = q.list();
		
		return result;
	}
	

	@Override
	public long saveState(long orderId, int state) {
		// TODO Auto-generated method stub		
		try {
        	OrderDO instance = (OrderDO) getHibernateTemplate()
                    .get("com.nju.data.dataobject.OrderDO", orderId);
        	if(instance == null)
        		return -1;
        	else{
        		instance.setState(state);
        		getHibernateTemplate().save(instance);
        		return instance.getGoodsId();
        	}
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
	}

	@Override
	public void save(OrderDO order) {
		log.debug("saving Order instance");
		try {
			getHibernateTemplate().save(order);
			log.debug("save successful");
 		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public OrderDO findOrderById(int orderId) {
		long id = (long) orderId;
		String sql = "from OrderDO where id = '"+id+"'";
		// String sql = "from OrderDO where id = 1";
		Session se = this.currentSession();	
		Query q = se.createQuery(sql);		
		List<OrderDO> result = q.list();
		System.out.println(result.get(0));
		
		return result.size()==0?null:result.get(0);
	}
	
}
