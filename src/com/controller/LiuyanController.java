package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TLiuyan;
import com.pojo.TUser;
import com.service.TLiuyanService;
 
@Controller
@RequestMapping("/liuyan")
public class LiuyanController {
	@Autowired
	private TLiuyanService tLiuyanService;
	@RequestMapping(value="/liuyanAdd")
	public String liuyanAdd(TLiuyan liuyan,HttpServletRequest req,HttpServletResponse res) throws Exception 
	{
		init(req);
		String id=String.valueOf(new Date().getTime());
		liuyan.setId(id);
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String shijian=new Date().toLocaleString();
		liuyan.setShijian(shijian);
		String user_id="0";
		if(req.getSession().getAttribute("user")!=null)
		{
			TUser user=(TUser)req.getSession().getAttribute("user");
			user_id=user.getId();
			liuyan.setUserId(user_id);
		}
		
		tLiuyanService.insertTLiuyan(liuyan);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "liuyan/liuyanAll");
		return "/common/success.jsp";
        
	}
	@RequestMapping(value="/liuyanReply")
	public String liuyanReply(HttpServletRequest req,HttpServletResponse res)  throws Exception 
	{
		String id=req.getParameter("id");
		
		TLiuyan liuyan = tLiuyanService.queryTLiuyanById(id);
		String reply=req.getParameter("reply");
		init(req);
		
		liuyan.setReply(reply);
		tLiuyanService.updateTLiuyan(liuyan);
	 
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "liuyan/liuyanMana");
		return "/common/success.jsp";
	}
	
	@RequestMapping(value="/liuyanAll")
	public String liuyanAll(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		init(req);
		req.setAttribute("liuyanList", tLiuyanService.queryTLiuyanList(new TLiuyan()));
		return "/qiantai/liuyan/liuyanAll.jsp";
	}
	@RequestMapping(value="/liuyanDelFront")
	public String liuyanDelFront(HttpServletRequest req,HttpServletResponse res)  throws Exception 
	{
		String id=req.getParameter("id");
		init(req);
		tLiuyanService.deleteTLiuyan(id);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "liuyan/liuyanAll");
		return "/common/success.jsp";
	}
	
	@RequestMapping(value="/liuyanDel")
	public String liuyanDel(HttpServletRequest req,HttpServletResponse res)  throws Exception 
	{
		String id=req.getParameter("id");
		init(req);
		tLiuyanService.deleteTLiuyan(id);
 
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "liuyan/liuyanMana");
		return "/common/success.jsp";
	}
	@RequestMapping(value="/liuyanMana")
	public String liuyanMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		init(req);
		List liuyanList= tLiuyanService.queryTLiuyanList(new TLiuyan());
		req.setAttribute("liuyanList", liuyanList);
		return "/admin/liuyan/liuyanMana.jsp";
	}
	
	private void init(HttpServletRequest req){
	}
}
