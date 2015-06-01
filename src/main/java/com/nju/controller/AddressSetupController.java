package com.nju.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nju.service.UserService;
import com.nju.util.ResponseBuilder;

@Controller
public class AddressSetupController {

	@RequestMapping(value = "/MyAddrSet",method = RequestMethod.POST)
	public void addressSave(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		ResponseBuilder rb = new ResponseBuilder();
		
		String username = request.getParameter("ID");
		String street = request.getParameter("STREET");
		String building = request.getParameter("BUILDING");
		String room = request.getParameter("ROOM");
		
		System.out.println(username + ": " + street + "," + building + "," + room);
		
		try {
			rb.writeJsonResponse(response, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
	}
}
