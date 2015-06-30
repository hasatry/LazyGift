package com.nju.controller;

import com.nju.service.NoticeService;
import com.nju.service.impl.NoticeServiceImpl;
import com.nju.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liveangel on 15-6-29.
 */

@Controller
public class NoticeController {
    //@Autowired
    private NoticeService noticeService = new NoticeServiceImpl();

    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public void getLocationRank(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        ResponseBuilder rb = new ResponseBuilder();
        String rankTop = request.getParameter("rankTop")==null?"":request.getParameter("rankTop");
        String rankEnd = request.getParameter("rankEnd")==null?"":request.getParameter("rankEnd");
        String beginDate = request.getParameter("beginDate")==null?"":request.getParameter("beginDated");
        String endDate = request.getParameter("endDate")==null?"":request.getParameter("endDate");

        //String result = "rankTop"+rankTop+"rankEnd"+rankEnd+"beginDate"+beginDate+"endDate"+endDate;
        String result = noticeService.getHistoryLocation(Integer.parseInt(rankTop),Integer.parseInt(rankEnd),beginDate,endDate);

        try {
            rb.writeJsonResponse(response, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public void getTest(HttpServletRequest request, HttpServletResponse response, ModelMap model){
        ResponseBuilder rb = new ResponseBuilder();
        Boolean isSuccess = true;


        String rankTop = request.getParameter("rankTop");
        String rankEnd = request.getParameter("rankEnd");
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String result = noticeService.getHistoryLocation(Integer.parseInt(rankTop),Integer.parseInt(rankEnd),beginDate,endDate);
        if(result==null){
            result="查找不到数据";
        }
        try {
            rb.writeJsonResponse(response, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
