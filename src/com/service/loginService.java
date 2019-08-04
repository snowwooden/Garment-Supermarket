package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.TAdmin;
import com.pojo.TCatelog;
import com.pojo.TUser;
import com.util.Cart;
@Service
public class loginService
{
	@Autowired
	private TAdminService  tAdminService;
	@Autowired
	private TUserService tUserService;
	@Autowired
	private TCatelogService tCatelogService;
	public String login(String userName,String userPw,int userType)
	{
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)//系统管理员登陆
		{
			TAdmin admin = new TAdmin();
			admin.setUsername(userName);
			admin.setUserpw(userPw);
			
			try 
			{
				List<TAdmin> alist = tAdminService.queryTAdminList(admin);
				 
				boolean mark=(alist==null||alist.size()==0?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 admin=alist.get(0);
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 0);
		             session.setAttribute("admin", admin);
				}
				 
			} 
			catch ( Exception e)
			{
				System.out.println("登录失败！");
				e.printStackTrace();
			}
			 
			
		}
		
		
		if(userType==1)
		{
			TUser user = new TUser();
			user.setLoginname(userName);
			user.setLoginpw(userPw);
			
			 
			try
			{
				List<TUser> ulist = tUserService.queryTUserList(user);
				boolean mark=(ulist==null||ulist.size()==0?false:true);
				if(mark==false)
				{
					result="no";
				}
				if(mark==true)
				{
					 result="yes";
					 user = ulist.get(0);
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 
					 session.setAttribute("userType", 1);
		             session.setAttribute("user", user);
		             
		             Cart cart=new Cart();
					 session.setAttribute("cart", cart);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			 
		}
		 
		return result;
	}

    public String adminPwEdit(String userPwNew) 
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session=ctx.getSession(); 
			TAdmin admin=(TAdmin)session.getAttribute("admin");
			admin.setUserpw(userPwNew);
			tAdminService.updateTAdmin(admin);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
		return "yes";
    }
    
    
    public List catelogAll()
    {
    	List rlist=new ArrayList();
    	try
		{
			Thread.sleep(700);
			List<TCatelog> catelogList=new ArrayList();
	    	catelogList = tCatelogService.queryTCatelogList(new TCatelog());
	    	for (TCatelog tCatelog : catelogList) {
				if(tCatelog.getFid()!=0){
					rlist.add(tCatelog);
				}
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		 
		return rlist;
    }
}
