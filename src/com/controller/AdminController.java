package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TAdmin;
import com.service.TAdminService;
 
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private TAdminService tAdminService;
	@RequestMapping(value="/adminMana")
	public String adminMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List adminList=tAdminService.queryTAdminList(new TAdmin());
		req.setAttribute("adminList",adminList );
		return "admin/adminMana.jsp";
		 
	}
	
	@RequestMapping(value="/adminAdd")
	public String adminAdd(HttpServletRequest req,HttpServletResponse res)  throws Exception
	{
		String userName=req.getParameter("userName");
		String userPw=req.getParameter("userPw");
		TAdmin admin = new TAdmin();
		admin.setUsername(userName);
		admin.setUserpw(userPw);
		tAdminService.insertTAdmin(admin);
		return "redirect:/admin/adminMana";
	}
	@RequestMapping(value="/adminDel")
	public String adminDel(HttpServletRequest req,HttpServletResponse res)  throws Exception
	{
		int id = Integer.parseInt(req.getParameter("userId"));
		tAdminService.deleteTAdmin(id);
		return "redirect:/admin/adminMana";
	}
}
