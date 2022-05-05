package com.ssafy.web;

import java.io.BufferedReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.web.service.MemberService;
import com.ssafy.web.service.OrderService;
import com.ssafy.web.vo.MemberVO;
import com.ssafy.web.vo.OrderVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired MemberService memberService;
	
	@RequestMapping(value = "memberInsert.hch", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
			
	@ResponseBody
	public String memberInsert(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		System.out.println("memberInsert:"+id+"\t"+pw+"\t"+name);
	
		try {
			MemberVO m=new MemberVO(id,pw,name); 
			memberService.memberInsert(m);
			return name+"님 회원가입 되셨습니다";
		}catch(Exception e) {
			return e.getMessage();
		}	
		
	}
	
	@RequestMapping(value = "login.hch", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String login(HttpServletRequest request,
			HttpServletResponse response){
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");		
		
		JSONObject json=new JSONObject();
		try {
			MemberVO m=new MemberVO(id,pw); 
			String name=memberService.login(m);
			
			if(name!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("member", m);
				
				json.put("name", name);
				
			}else {
				json.put("msg", "로그인 실패");
			}
		}catch(Exception e) {
			json.put("msg", e.getMessage());
		}	
		return json.toJSONString();
	}


	@RequestMapping(value = "logout.hch", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String logout(HttpServletRequest request,
			HttpServletResponse response){
		
			HttpSession session=request.getSession(false);
			session.invalidate();
			return "";
		
	}

	 @Autowired OrderService orderService;
		
		
	///////////// 주문 처리 //////////////////
	@RequestMapping(value = "order.hch", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String order(HttpServletRequest request,
			HttpServletResponse response){
		JSONObject json=null;
		try {
			BufferedReader br=request.getReader();
			JSONParser parser=new JSONParser();
			json=(JSONObject) parser.parse(br);
			JSONArray array=(JSONArray) json.get("product");
			
			Object []array2=array.toArray();
			
			ArrayList<OrderVO> list=new ArrayList<OrderVO>();
			for(Object o : array2) {
				
				JSONObject j=(JSONObject) o;
				String prodname=(String) j.get("name");
				long quantity=(Long) j.get("quantity");
				OrderVO orderVO=new OrderVO("web",prodname,quantity);
				HttpSession session=request.getSession();
				MemberVO memberVO=(MemberVO) session.getAttribute("member");
				if(memberVO!=null) {//로그인 된 사용자라면 id를 추가해준다
					orderVO.setMemberid(memberVO.getId());
				}else {
					orderVO.setMemberid("");
				}
				
				list.add(orderVO);
			}
			
			System.out.println("총 "+list.size()+"개 품목을 주문합니다");
			long order_group_no=orderService.ordersInsert(list);
			
			json=new JSONObject();			
			
				
				
				json.put("order_group_no", order_group_no);
				
		}catch(Exception e) {
			e.printStackTrace();
			json.put("msg", e.getMessage());
		}	
		return json.toJSONString();		
	}

}
