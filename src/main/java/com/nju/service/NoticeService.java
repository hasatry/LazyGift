package com.nju.service;

import com.nju.model.Order;

import java.util.List;

/**
 * Created by liveangel on 15-6-29.
 */
public interface NoticeService {
    public List<Order> getHistoryLocation(int begin, int end, String dateBegin, String dateEnd);
}
