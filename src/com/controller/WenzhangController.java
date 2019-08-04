package com.controller;

import com.pojo.Pinglun;
import com.pojo.TUser;
import com.pojo.Wenzhang;
import com.service.PinglunService;
import com.service.TUserService;
import com.service.WenzhangService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WenzhangController
{
       

    @Autowired
	private WenzhangService wenzhangService;
	@Autowired
	private TUserService tUserService;
    @Autowired
	private PinglunService pinglunService;
 
	@RequestMapping(value="/wenzhangList")
	public String wenzhangList(HttpServletRequest request) throws Exception
	{
		Wenzhang wenzhang = new Wenzhang();
		List<Wenzhang> wenzhangList=wenzhangService.queryWenzhangList(wenzhang);
		if(wenzhangList!=null && wenzhangList.size()>0){
			for (Wenzhang wenzhang2 : wenzhangList) {
				if("0".equals(wenzhang2.getUid())){
					wenzhang2.setFbr("管理员");
				}else{
					TUser user = tUserService.queryTUserById(wenzhang2.getUid()+"");
					wenzhang2.setFbr(user.getLoginname());
				}
			}
		}
		request.setAttribute("wenzhangList", wenzhangList);
		return "/admin/wenzhang/wenzhang_list.jsp";
	}
 
	@RequestMapping(value="/wenzhangAdd")
	public String wenzhangAdd(Wenzhang wenzhang,HttpServletRequest request) throws Exception
	{
		wenzhang.setFbsj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		wenzhang.setState("通过");
		wenzhang.setGlfb("是");
		wenzhang.setZhiding("0");
		wenzhang.setUid("0");
	 
	    wenzhangService.insertWenzhang(wenzhang);
		request.setAttribute("message","操作成功");
		request.setAttribute("path","wenzhangList.action");
		return "common/success.jsp";
	}
	
	
	@RequestMapping(value="/fabuWenzhang")
	public String fabuWenzhang(Wenzhang wenzhang,HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		TUser user = (TUser) session.getAttribute("user");
		wenzhang.setFbsj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		wenzhang.setState("待审核");
		wenzhang.setGlfb("否");
		wenzhang.setZhiding("0");
		wenzhang.setUid(user.getId());
	    wenzhangService.insertWenzhang(wenzhang);
		request.setAttribute("message","发布成功，等待管理员审核");
		request.setAttribute("path","qiantai/wenzhang/fabu.jsp");
		return "common/success.jsp";
	}
	
	@RequestMapping(value="/wenzhangAll")
	public String wenzhangAll(HttpServletRequest request) throws Exception
	{
		Wenzhang wenzhang = new Wenzhang();
		wenzhang.setState("通过");
		List<Wenzhang> wenzhangList=wenzhangService.queryWenzhangList(wenzhang);
		if(wenzhangList!=null && wenzhangList.size()>0){
			for (Wenzhang wenzhang2 : wenzhangList) {
				if("0".equals(wenzhang2.getUid())){
					wenzhang2.setFbr("管理员");
				}else{
					TUser user = tUserService.queryTUserById(wenzhang2.getUid()+"");
					wenzhang2.setFbr(user.getLoginname());
				}
			}
		}
		request.setAttribute("wenzhangList", wenzhangList);
		return "/qiantai/wenzhang/wenzhangall.jsp";
	}
	
	@RequestMapping(value="/wenzhangView")
	public String wenzhangView(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Wenzhang wenzhang=wenzhangService.queryWenzhangById(id);
		
		if("0".equals(wenzhang.getUid())){
			wenzhang.setFbr("管理员");
		}else{
			TUser user = tUserService.queryTUserById(wenzhang.getUid()+"");
			wenzhang.setFbr(user.getLoginname());
		}
		if("通过".equals(wenzhang.getState())){
			wenzhang.setVcount(wenzhang.getVcount()+1);
			wenzhangService.updateWenzhang(wenzhang);
		}
		Pinglun pl = new Pinglun();
	    pl.setGid(new Long(wenzhang.getId()));
	    request.setAttribute("pinglunList", pinglunService.queryWz(pl));
		
	    request.setAttribute("wenzhang", wenzhang);
		return "/qiantai/wenzhang/wenzhang.jsp";
	}
	
	
	
	@RequestMapping(value="/wenzhangZan")
	public String wenzhangZan(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Wenzhang wenzhang = new Wenzhang();
		wenzhang = wenzhangService.queryWenzhangById(id);
		wenzhang.setZcount(wenzhang.getZcount()+1);
		wenzhangService.updateWenzhang(wenzhang);
		request.setAttribute("message","操作成功");
		request.setAttribute("path","wenzhangView.action?id=" + id);
		return "common/success.jsp";
	}
	
	
	@RequestMapping(value="/mywenzhang")
	public String mywenzhang(HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();
		TUser user = (TUser) session.getAttribute("user");
		Wenzhang wenzhang = new Wenzhang();
		wenzhang.setUid(user.getId());
		List<Wenzhang> wenzhangList=wenzhangService.queryWenzhangList(wenzhang);
		request.setAttribute("wenzhangList", wenzhangList);
		return "/qiantai/wenzhang/mywenzhang.jsp";
	}
	
	@RequestMapping(value="/mydelwenzhang")
	public String mydelwenzhang(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		 
		wenzhangService.deleteWenzhang(id);
		request.setAttribute("message","操作成功");
		request.setAttribute("path","mywenzhang.action");
		return "common/success.jsp";
	}
	
	@RequestMapping(value="/wenzhangDel")
	public String wenzhangDel(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		 
		wenzhangService.deleteWenzhang(id);
		request.setAttribute("message","操作成功");
		request.setAttribute("path","wenzhangList.action");
		 
		return "common/success.jsp";
	}
	
	@RequestMapping(value="/wenzhangEditPre")
	public String wenzhangEditPre(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Wenzhang wenzhang=wenzhangService.queryWenzhangById(id);
	    request.setAttribute("wenzhang", wenzhang);
		return "/admin/wenzhang/wenzhang_edit.jsp";
	}
	
	@RequestMapping(value="/wenzhangEdit")
	public String wenzhangEdit(Wenzhang wenzhang,HttpServletRequest request) throws Exception
	{
		wenzhangService.updateWenzhang(wenzhang);
		request.setAttribute("message","操作成功");
		request.setAttribute("path","wenzhangList.action");
		return "common/success.jsp";
	}

	@RequestMapping(value="/wenzhangZhiding")
	public String wenzhangZhiding(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		int ty = Integer.parseInt(request.getParameter("ty"));
		if(ty==1){
			Wenzhang wenzhang = new Wenzhang();
			wenzhang.setZhiding("1");
			List<Wenzhang> wenzhangList=wenzhangService.queryWenzhangList(wenzhang);
			if(wenzhangList!=null){
				if(wenzhangList.size()>=4){
					request.setAttribute("message","置顶数量最多为4个");
				}else{
					wenzhang = wenzhangService.queryWenzhangById(id);
					wenzhang.setZhiding("1");
					wenzhangService.updateWenzhang(wenzhang);
					request.setAttribute("message","操作成功");
				}
			}else{
				wenzhang = wenzhangService.queryWenzhangById(id);
				wenzhang.setZhiding("1");
				wenzhangService.updateWenzhang(wenzhang);
				request.setAttribute("message","操作成功");
			}
		}else{
			Wenzhang wenzhang = wenzhangService.queryWenzhangById(id);
			wenzhang.setZhiding("0");
			wenzhangService.updateWenzhang(wenzhang);
			request.setAttribute("message","操作成功");
		}
		
		
		request.setAttribute("path","wenzhangList.action");
		return "common/success.jsp";
	}
	
	
	
	
	@RequestMapping(value="/wenzhangAudit")
	public String wenzhangAudit(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		int ty = Integer.parseInt(request.getParameter("ty"));
		if(ty==1){
			Wenzhang wenzhang = new Wenzhang();
			wenzhang = wenzhangService.queryWenzhangById(id);
			wenzhang.setState("通过");
			wenzhangService.updateWenzhang(wenzhang);
			request.setAttribute("message","操作成功");
		}else{
			Wenzhang wenzhang = wenzhangService.queryWenzhangById(id);
			wenzhang.setState("不通过");
			wenzhangService.updateWenzhang(wenzhang);
			request.setAttribute("message","操作成功");
		}
		
		
		request.setAttribute("path","wenzhangList.action");
		return "common/success.jsp";
	}
 
}
