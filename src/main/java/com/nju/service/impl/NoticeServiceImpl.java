package com.nju.service.impl;

import com.nju.data.dao.OrderDao;
import com.nju.data.dao.impl.OrderDaoImpl;
import com.nju.model.Order;
import com.nju.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liveangel on 15-6-29.
 */
public class NoticeServiceImpl implements NoticeService {
    //@Autowired
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public String getHistoryLocation(int begin, int end, String dateBegin, String dateEnd) {
        return orderDao.getHotLocation(begin,end,dateBegin,dateEnd);
    }
}
