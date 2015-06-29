package com.nju.data.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
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

	public String getHotLocation(int rankBegin, int rankEnd, String dateBegin, String dateEnd) {
		Session sess = this.currentSession();
		List list = null;
		String result = "";
		List l1 = null;
		if (sess != null) {
			String sql = "from OrderDO o where o.createTime between :firstDate and :endDate";
			String sql1 = "select o.remark, count(*) from OrderDO o where createTime between :firstDate and :endDate group by o.remark order by count(*) desc";
			l1 = sess.createQuery(sql1).setString("firstDate", dateBegin).setString("endDate", dateEnd).list();


		}
		if (l1!=null){
			Iterator iter =l1.iterator();
			if(!iter.hasNext()){
				System.out.println("No objects to display.");
			}
			while(iter.hasNext()){
				System.out.println("New object");
				Object[] obj = (Object[]) iter.next();
				for (int i = 0; i < obj.length; i++) {
					result+=obj[i];
				}
			}

		}
		return result;
	}

}
