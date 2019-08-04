package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Pinglun;
import com.pojo.TOrder;
import com.pojo.TUser;
import com.service.PinglunService;
import com.service.TOrderService;
@Controller
@RequestMapping("/pinglun")
public class PinglunController
{
       

    @Autowired
	private PinglunService pinglunService;
	@Autowired
	private TOrderService tOrderService;
    @RequestMapping(value="/pinglunAdd")
    public String pinglunAdd(HttpServletRequest req, HttpServletResponse res)throws Exception {
		int gsize = req.getParameter("gsize") == null ? 0 : Integer.parseInt(req.getParameter("gsize"));
		HttpSession session = req.getSession();
		TUser user = (TUser) session.getAttribute("user");
		String plr = user.getName();
		String plsj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		for (int i = 0; i < gsize; i++) {
			String plnr = req.getParameter("plnr" + i);
			String gid = req.getParameter("gid" + i);
            Pinglun pl = new Pinglun();
            pl.setGid(new Long(gid));
            pl.setPlnr(plnr);
            pl.setUid(user.getId());
            pl.setPlsj(plsj);
            pl.setPlr(plr);
            pinglunService.insertPinglun(pl);
		}
		String oid = req.getParameter("oid");
		if(oid!=null && !"".equals(oid)){
			TOrder order = tOrderService.queryTOrderById(oid);
			order.setPjstate(1);
			tOrderService.updateTOrder(order);
		}
		req.setAttribute("msg", "操作成功");
		return "/common/add_success.jsp";
	}
	@RequestMapping(value="/pinglunList")
	public String pinglunList(HttpServletRequest request) throws Exception
	{
		Pinglun pinglun = new Pinglun();
		List pinglunList=pinglunService.queryPinglunList(pinglun);
		request.setAttribute("pinglunList", pinglunList);
		return "/admin/pinglun/pinglunMana.jsp";
	}
 
	
	
	@RequestMapping(value="/pinglunWzAdd")
    public String pinglunWzAdd(HttpServletRequest req, HttpServletResponse res)throws Exception {
	 
		HttpSession session = req.getSession();
		TUser user = (TUser) session.getAttribute("user");
		String plr = user.getName();
		String plsj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	 
		String plnr = req.getParameter("plnr");
		String gid = req.getParameter("gid");
        Pinglun pl = new Pinglun();
        pl.setGid(new Long(gid));
        pl.setPlnr(plnr);
        pl.setUid(user.getId());
        pl.setPlsj(plsj);
        pl.setPlr(plr);
        pl.setCtype(1);
        pinglunService.insertPinglun(pl);
	
    	req.setAttribute("message", "操作成功");
		req.setAttribute("path", "wenzhangView.action?id="+gid);
		return "/common/success.jsp";
	}
	
	
	@RequestMapping(value="/pinglunReplay")
	public String pinglunReplay(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		Pinglun pl = pinglunService.queryPinglunById(id);
		String replays = req.getParameter("replays");
		pl.setReplays(replays);
		pinglunService.updatePinglun(pl);
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "pinglun/pinglunList");
		return "/common/success.jsp";
	}
	 
	@RequestMapping(value="/pinglunDel")
	public String pinglunDel(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		 
		pinglunService.deletePinglun(id);
		request.setAttribute("message","操作成功");
		request.setAttribute("path","pinglunList.action");
		 
		return "common/succeed.jsp";
	}
	
	@RequestMapping(value="/pinglunEditPre")
	public String pinglunEditPre(HttpServletRequest request) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Pinglun pinglun=pinglunService.queryPinglunById(id);
	    request.setAttribute("pinglun", pinglun);
		return "/admin/pinglun/pinglunEdit.jsp";
	}


}
