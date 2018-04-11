package bba.com.a.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bba.com.a.arrow.StoreMapParcing;
import bba.com.a.model.Bb_AddrDto;
import bba.com.a.model.Bb_AdminDto;
import bba.com.a.model.Bb_BeverageDto;
import bba.com.a.model.Bb_BurgerDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_MenuTableDto;
import bba.com.a.model.Bb_OrderDto;
import bba.com.a.model.Bb_OrderMenuDto;
import bba.com.a.model.Bb_SideDto;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaMemberSerivce;
import bba.com.a.service.BbaOrderService;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaOrderController {
	private static final Logger logger = LoggerFactory.getLogger(BbaOrderController.class);
	
	@Autowired
	BbaOrderService bbaOrderService;

	
	/*--------------------------------------------------------------------------------------------
	 * 주문 리스트로 이동 ( 주문리스트에 맞춰서 멤버, 주소, 점포 상세 리스트 가져오기 )
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "orderlist.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String orderList(HttpServletRequest request, Model model) throws Exception {
		logger.info("Welcome BbaOrderController orderlist! "+ new Date());
		
		List<Bb_OrderDto> olist = bbaOrderService.getOrderList();
		
		for (int i = 0; i < olist.size(); i++) {
			System.out.println("olist에 있는 seq : " + olist.get(i).getSeq());
		}
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		//버거 리스트 가져오기
		List<Bb_BurgerDto> burgerList = bbaOrderService.getBurgerList();
		
		//음료 리스트 가져오기
		List<Bb_BeverageDto> beverageList = bbaOrderService.getBeverageList();
		
		//음료 리스트 가져오기
		List<Bb_SideDto> sideList = bbaOrderService.getSideList();
		
				
		
		//주문 상세 가져오기 (ordermenu)
		Bb_OrderMenuDto orderMenuDto = null;
		List<Bb_OrderMenuDto> orderMenuList=null;
		for (int i = 0; i < olist.size(); i++) {
			orderMenuList = bbaOrderService.getOrderMenuList(olist.get(i).getSeq());
		}
		
		for (int i = 0; i < orderMenuList.size(); i++) {
			System.out.println("ordeMenuList에 있는 seq : " + orderMenuList.get(i).getSeq());
			System.out.println("ordeMenuList에 있는 order_seq : " + orderMenuList.get(i).getOrder_seq());
			System.out.println("ordeMenuList에 있는 menu_seq : " + orderMenuList.get(i).getMenu_seq());

			
		}
		
		
		//주문 상세에 있는 메뉴 시퀀스를 이용해서 메뉴 테이블 가져오기
		List<Bb_MenuTableDto> menuList=null;
		for (int i = 0; i < orderMenuList.size(); i++) {
			menuList = bbaOrderService.getMenuList(orderMenuList.get(i).getMenu_seq());
		}
		
	
		
		//Bb_OrderMenuDto에 있는 Bb_MenuTableDto menu; 부분 DTO로 넣기
		for (int i = 0; i < orderMenuList.size(); i++) {
			orderMenuList.get(i).setMenu(new Bb_MenuTableDto(
						orderMenuList.get(i).getSeq(),	//int seq;
						
						menuList.get(i).getBurger(),	//burger seq
						menuList.get(i).getSide(),		//side seq
						menuList.get(i).getBeverage(),	//beverage seq
						menuList.get(i).getName(),		//String name;
						menuList.get(i).getCreator(),	//int creator;
						menuList.get(i).getPrice(),		//int price;
						menuList.get(i).getCal(),		//int cal;
						menuList.get(i).getDel()		//int del;
					));
		}
		
		System.out.println("메뉴에 있는 name : " + menuList.get(0).getName());


		////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		//멤버 dto 가져오기
		List<Bb_MemberDto> memberList=null;
		for (int i = 0; i < olist.size(); i++) {
			memberList = bbaOrderService.getMemberList(olist.get(i).getMember_seq());
		}
		
		//주소 상세 가져오기
		List<Bb_AddrDto> addrList=null;
		for (int i = 0; i < olist.size(); i++) {
			addrList = bbaOrderService.getAddrList(olist.get(i).getMember_addr());
		}
		
		//점포 dto 가져오기
		List<Bb_StoreDto> storeList=null;
		for (int i = 0; i < olist.size(); i++) {
			storeList = bbaOrderService.getStoreList(olist.get(i).getStore_seq());
		}
		
		
		model.addAttribute("olist", olist); 			//order list
		model.addAttribute("orderMenuList", orderMenuList); 			//order menu list
		
		model.addAttribute("memberList", memberList);	//member list
		model.addAttribute("addrList", addrList);		//address list
		model.addAttribute("storeList", storeList);		//store list
		
		model.addAttribute("doc_title", "주문관리");
		model.addAttribute("doc_menu", "주문관리");
		
		return "orderlist.tiles";
		
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 주문 OrderMenu 가져오기 (버거, 사이드, 음료 DTO에 저장)
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "orderMenulist.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String orderMenuList(HttpServletRequest request, Model model) throws Exception {
		logger.info("Welcome BbaOrderController orderMenulist! "+ new Date());
	
		
		//버거 리스트 가져오기
		List<Bb_BurgerDto> burgerList = bbaOrderService.getBurgerList();
		
		//음료 리스트 가져오기
		List<Bb_BeverageDto> beverageList = bbaOrderService.getBeverageList();
		
		//음료 리스트 가져오기
		List<Bb_SideDto> sideList = bbaOrderService.getSideList();
		
				
		
		
		//order 가져오기
		List<Bb_OrderDto> olist = bbaOrderService.getOrderList();
		
		for (int i = 0; i < olist.size(); i++) {
			System.out.println("olist에 있는 seq : " + olist.get(i).getSeq());
		}
		
		//주문 상세 가져오기 (ordermenu)
		Bb_OrderMenuDto orderMenuDto = null;
		List<Bb_OrderMenuDto> orderMenuList=null;
		for (int i = 0; i < olist.size(); i++) {
			orderMenuList = bbaOrderService.getOrderMenuList(olist.get(i).getSeq());
		}
		
		for (int i = 0; i < orderMenuList.size(); i++) {
			System.out.println("ordeMenuList에 있는 seq : " + orderMenuList.get(i).getSeq());
			System.out.println("ordeMenuList에 있는 order_seq : " + orderMenuList.get(i).getOrder_seq());
			System.out.println("ordeMenuList에 있는 menu_seq : " + orderMenuList.get(i).getMenu_seq());

			
		}
		
		
		//주문 상세에 있는 메뉴 시퀀스를 이용해서 메뉴 테이블 가져오기
		List<Bb_MenuTableDto> menuList=null;
		for (int i = 0; i < orderMenuList.size(); i++) {
			menuList = bbaOrderService.getMenuList(orderMenuList.get(i).getMenu_seq());
		}
		
		
		//Bb_OrderMenuDto에 있는 Bb_MenuTableDto menu; 부분 DTO로 넣기
		for (int i = 0; i < orderMenuList.size(); i++) {
			orderMenuList.get(i).setMenu(new Bb_MenuTableDto(
						orderMenuList.get(i).getSeq(),	//int seq;
						menuList.get(i).getBurger(),	//** Bb_BurgerDto burger;
						menuList.get(i).getSide(),		//** Bb_SideDto side;
						menuList.get(i).getBeverage(),	//** Bb_BeverageDto beverage;
						menuList.get(i).getName(),		//String name;
						menuList.get(i).getCreator(),	//int creator;
						menuList.get(i).getPrice(),		//int price;
						menuList.get(i).getCal(),		//int cal;
						menuList.get(i).getDel()		//int del;
					));
		}
		


		
		
		
		
		 /* Bb_MenuTableDto 
		   
		  private int seq;
		  private Bb_BurgerDto burger;
		  private Bb_SideDto side;
		  private Bb_BeverageDto beverage;
		  private String name;
		  private int creator;
		  private int price;
		  private int cal;
		  private int del;*/
		
		
		
		
		
	/*	
		
		//음료 seq (key, value)
		HashMap<String , Integer> beverageSeqList = new HashMap<String , Integer>();
		for (int i = 0; i < menuList.size(); i++) {
			beverageSeqList.put("beverageSeq", menuList.get(i).getSide().getSeq());
		}
		
		//사이드 seq
		HashMap<String , Integer> sideSeqList = new HashMap<String , Integer>();
		
		//버거 seq
		HashMap<String , Integer> burgerSeqList = new HashMap<String , Integer>();
		
		
		
		//메뉴 테이블을 이용해서 음료 가져오기
		HashMap<Bb_BeverageDto , Object> beverage = new HashMap<Bb_BeverageDto , Object>();

		*/
		
		
		
		return null;
	}

}













