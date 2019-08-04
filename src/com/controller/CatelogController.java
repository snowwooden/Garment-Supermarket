package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TCatelog;
import com.service.TCatelogService;
 
@Controller
@RequestMapping("/catelog")
public class CatelogController {
	@Autowired
	private TCatelogService tCatelogService;
	@RequestMapping("/catelogAdd")
	public String catelogAdd(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String name=req.getParameter("name").trim();
		int fid=Integer.parseInt(req.getParameter("fid"));
		String del="no";
		TCatelog tcatelog = new TCatelog();
		tcatelog.setDel(del);
		tcatelog.setFid(new Long(fid));
		tcatelog.setName(name);
		tCatelogService.insertTCatelog(tcatelog);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "catelog/catelogMana");
		return "/common/success.jsp";
	}
	@RequestMapping("/catelogUpdate") 
	public String catelogUpdate(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		 
		String name=req.getParameter("name").trim();
		String id=req.getParameter("id");
		int fid=Integer.parseInt(req.getParameter("fid"));
		
		TCatelog tcatelog = new TCatelog();
		tcatelog.setDel("no");
		tcatelog.setFid(new Long(fid));
		tcatelog.setName(name);
		tcatelog.setId(Long.valueOf(id));
		tCatelogService.updateTCatelog(tcatelog);
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "catelog/catelogMana");
		return "/common/success.jsp";
        
	}
	@RequestMapping("/catelogDel")
	public String catelogDel(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		tCatelogService.deleteTCatelog(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "catelog/catelogMana");
		return "/common/success.jsp";
	}
	@RequestMapping("/catelogMana")
	public String catelogMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List catelogList=new ArrayList();
		TCatelog tcatelog = new TCatelog();
		catelogList = tCatelogService.queryTCatelogList(tcatelog);
		req.setAttribute("catelogList", catelogList);
		return "/admin/catelog/catelogMana.jsp";
	}
	
	@RequestMapping("/tocatelogAdd")
	public String tocatelogAdd(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List catelogList=new ArrayList();
		TCatelog tcatelog = new TCatelog();
		tcatelog.setFid(0l);
		catelogList = tCatelogService.queryTCatelogList(tcatelog);
		req.setAttribute("catelogList", catelogList);
		return "/admin/catelog/catelogAdd.jsp";
	}
	@RequestMapping("/catelogEditPre")
	public String catelogEditPre(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List catelogList=new ArrayList();
		TCatelog tcatelog = new TCatelog();
		tcatelog.setFid(0l);
		catelogList = tCatelogService.queryTCatelogList(tcatelog);
		req.setAttribute("catelog", tCatelogService.queryTCatelogById(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("catelogList", catelogList);
 
		return "/admin/catelog/catelogEdit.jsp";
	}
}
