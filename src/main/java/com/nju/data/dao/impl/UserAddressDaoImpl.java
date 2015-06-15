package com.nju.data.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import com.nju.data.dao.UserAddressDao;
import com.nju.data.dataobject.UserAddressDO;

public class UserAddressDaoImpl extends HibernateDaoSupport implements UserAddressDao{
	protected static Logger log = LoggerFactory.getLogger(UserAddressDao.class);
	@SuppressWarnings("unchecked")
	@Override
	public UserAddressDO getDefaultAddress(String user) {
		// TODO Auto-generated method stub
		String sql = "from UserAddressDO where username = '"+user+"' AND isDefault = 1";
		try{
			Session se = this.currentSession();
			Query q = se.createQuery(sql);
			
			List<UserAddressDO> result = q.list();
			return result.size()==0?null:result.get(0);
		}catch(RuntimeException re){
			log.error("Save default address is failed!");
			throw re;
		}
	}

	@Override
	public UserAddressDO[] getAllAddresses(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveAddress(String user, String street, String building,
			String room, boolean isDefault) {
		// TODO Auto-generated method stub
		log.debug("save default user address for " + user +"; Address: "+street+", "
				+ building + "¥, " + room+"��");
		UserAddressDO default_addr = this.getDefaultAddress(user);
		if(default_addr != null){
			default_addr.setStreet(street);
			default_addr.setBuilding(building);
			default_addr.setRoom(room);
		}else{
			default_addr = new UserAddressDO(user,street,building,room,true);
		}
		
		try{
			Session se = this.currentSession();
			Transaction transaction = se.beginTransaction();
			se.saveOrUpdate(default_addr);
			transaction.commit();
			se.flush();
		}catch(RuntimeException re){
			log.error("Save default address is failed!");
			throw re;
		}
		
		return true;
	}


}
