package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.TAddress;
import com.pojo.TAdmin;
import com.pojo.TUser;
import com.service.TAddressService;
import com.service.TAdminService;
import com.service.TUserService;
 
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private TAdminService tAdminService;
	@Autowired
	private TUserService tUserService;
	@Autowired
	private TAddressService tAddressService;
	@RequestMapping(value="/adminMana")
	public String adminMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List adminList= tAdminService.queryTAdminList(new TAdmin());
		req.setAttribute("adminList", adminList);
		return "admin/adminMana.jsp";
		 
	}
	@RequestMapping(value="/userReg")
	public String userReg(TUser tuser, HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=String.valueOf(new Date().getTime());
		tuser.setId(id);
		tUserService.insertTUser(tuser);
        return "/qiantai/default.jsp";
	}
	
	
	@RequestMapping(value="/userLogout")
	public String userLogout(HttpServletRequest req,HttpServletResponse res)
	{
		req.getSession().setAttribute("user", null);
		 return "/qiantai/default.jsp";	
	}
	
	
	@RequestMapping(value="/setVip")
	public String setVip(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		String vip=req.getParameter("vip");
		TUser user = tUserService.queryTUserById(id);
		user.setVip(vip);
		tUserService.updateTUser(user);
		return userMana(req,res);
	}
	@RequestMapping(value="/userEdit")
	public String userEdit(TUser tuser,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		tUserService.updateTUser(tuser);
		req.getSession().setAttribute("user", tuser);
		req.setAttribute("msg", "操作成功");
        return "/common/add_success.jsp";
	}
	
	@RequestMapping(value="/mpwd")
	public String mpwd(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		String oldpwd=req.getParameter("oldpwd");
		String loginpw=req.getParameter("loginpw");
		TUser user= (TUser) req.getSession().getAttribute("user");
		if(!oldpwd.equals(user.getLoginpw())){
			req.setAttribute("message", "原密码错误");
			req.setAttribute("path", "user/userInfo");
	        return "/common/success.jsp";
		}else{
			String sql="update t_user set loginpw=?  where id=?";
			user = tUserService.queryTUserById(id);
			user.setLoginpw(loginpw);
			tUserService.updateTUser(user);
 
			
			req.getSession().setAttribute("user", user);
			 
			req.setAttribute("message", "操作成功");
			req.setAttribute("path", "user/userInfo");
	        return "/common/success.jsp";
			
		}
 
	}
	@RequestMapping(value="/userEditInfo")
	public String userEditInfo(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
 
		TUser user  = tUserService.queryTUserById(id);
		user.setName(name);
		user.setSex(sex);
		tUserService.updateTUser(user);
 
 
		req.getSession().setAttribute("user", user);
		
 
 
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user/userInfo");
        return "/common/success.jsp";
	}
	@RequestMapping(value="/userDel")
	public String userDel(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		tUserService.deleteTUser(id);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user/userMana");
        return "/common/success.jsp";
	}
	@RequestMapping(value="/userMana")
	public String userMana(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		List userList= tUserService.queryTUserList(new TUser());
		req.setAttribute("userList", userList);
		 return "/admin/user/userMana.jsp";
	}
	
	@RequestMapping(value="/userAddress")
	public String userAddress(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		TAddress tAddress = new TAddress();
		TUser user  = (TUser) req.getSession().getAttribute("user");
		tAddress.setUid(user.getId());
		req.setAttribute("addressList", tAddressService.queryTAddressList(tAddress));
		 return "/qiantai/userinfo/userAddress.jsp";
	}
	@RequestMapping(value="/toeadress")
	public String toeadress(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		
		String id=req.getParameter("id");
		 
		TAddress address=tAddressService.queryTAddressById(Integer.parseInt(id));
		 
		req.setAttribute("address", address);
		 return "/qiantai/userinfo/modifyAddress.jsp";
 
	}
	
	
	@RequestMapping(value="/saveAddress")
	public String saveAddress(TAddress address,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		TUser user  = (TUser) req.getSession().getAttribute("user");
		address.setUid(user.getId());
		tAddressService.insertTAddress(address);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user/userAddress");
        return "/common/success.jsp";
	}
	@RequestMapping(value="/editAddress")
	public String editAddress(TAddress address,HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		tAddressService.updateTAddress(address);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user/userAddress");
        return "/common/success.jsp";
	}
	@RequestMapping(value="/delAddress")
	public String delAddress(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		tAddressService.deleteTAddress(Integer.parseInt(id));
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user/userAddress");
        return "/common/success.jsp";
	}
	
	@RequestMapping(value="/selectmradress")
	public String selectmradress(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		
		TUser user  = (TUser) req.getSession().getAttribute("user");
		 
		TAddress tAddress = new TAddress();
		tAddress.setUid(user.getId());
		tAddress.setMr(1l);
		List<TAddress> alist=tAddressService.queryTAddressList(tAddress);
		if(alist!=null && alist.size()>0){
			tAddress = alist.get(0);
		}else{
			tAddress.setName(user.getName());
			tAddress.setAddress(user.getAddress());
			tAddress.setTelphone(user.getTel());
		}
		req.setAttribute("address", tAddress);
		 return "/qiantai/order/orderQueren.jsp";
	}
	@RequestMapping(value="/mrAddress")
	public String mrAddress(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("id");
		TUser user  = (TUser) req.getSession().getAttribute("user");
		TAddress adds = new TAddress();
		adds.setUid(user.getId());
		List<TAddress> alist = tAddressService.queryTAddressList(adds);
		if(alist!=null && alist.size()>0){
			for (TAddress tAddress : alist) {
				tAddress.setMr(0l);
				tAddressService.updateTAddress(tAddress);
			}
		}
		TAddress address = tAddressService.queryTAddressById(Integer.parseInt(id));
		address.setMr(1l);
		tAddressService.updateTAddress(address);
	 
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "user/userAddress");
        return "/common/success.jsp";
	}
	@RequestMapping(value="/userXinxi")
	public String userXinxi(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("user_id");
		
		List userList=new ArrayList();
		TUser user = new TUser();
		user.setId(id);
		userList = tUserService.queryTUserList(user);
	 
		req.setAttribute("userList", userList);
		return "/admin/order/userXinxi.jsp";
	}
	
	
	@RequestMapping(value="/userInfo")
	public String userInfo(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		TUser user  = (TUser) req.getSession().getAttribute("user");
		user = tUserService.queryTUserById(user.getId());
		req.setAttribute("uinfo", user);
		return "/qiantai/userinfo/userInfo.jsp";
	}
}
