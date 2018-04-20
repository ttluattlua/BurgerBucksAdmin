package bba.com.a.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import java.io.Serializable;
import java.util.ArrayList;
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
import bba.com.a.model.Bb_OrderDetailDto;
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
		System.out.println("olist (order) : " + olist.toString());
		
		//멤버 dto 가져오기
		List<Bb_MemberDto> memberList = new ArrayList<Bb_MemberDto>();
		for (int i = 0; i < olist.size(); i++) {
			memberList.add(bbaOrderService.getMemberList(olist.get(i).getMember_seq()));
		}
		
		//주소 상세 가져오기
		List<Bb_AddrDto> addrList = new ArrayList<Bb_AddrDto>();
		for (int i = 0; i < olist.size(); i++) {
			addrList.add(bbaOrderService.getAddrList(olist.get(i).getMember_addr()));
		}
		
		//점포 dto 가져오기
		List<Bb_StoreDto> storeList = new ArrayList<Bb_StoreDto>();
		for (int i = 0; i < olist.size(); i++) {
			storeList.add(bbaOrderService.getStoreList(olist.get(i).getStore_seq()));
		}
		
		model.addAttribute("olist", olist); 			//order list
		model.addAttribute("memberList", memberList);	//member list
		model.addAttribute("addrList", addrList);		//address list
		model.addAttribute("storeList", storeList);		//store list
		
		model.addAttribute("doc_title", "주문관리");
		model.addAttribute("doc_menu", "주문관리");
		
		return "orderlist.tiles";
		
	}
	
	
	
	/*--------------------------------------------------------------------------------------------
	 * 주문 상태 변경
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value = "changeOrder.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public Bb_OrderDto changeOrder(@RequestParam("seq") int seq, @RequestParam("status") int status, 
			HttpServletRequest request, Model model) throws Exception {
		logger.info("Welcome BbaOrderController changeOrder! "+ new Date());
		
		Bb_OrderDto orderDto = new Bb_OrderDto();
		orderDto.setSeq(seq);
		orderDto.setStatus(status);
		System.out.println("orderDto changeOrder로 들어온 것 : "+orderDto.toString());
		
		bbaOrderService.changeOrder(orderDto);
		
		
		
		return bbaOrderService.getOrder(seq);
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 주문 상세보기
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value = "orderDetail.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public List<Bb_OrderDetailDto> orderDetail(@RequestParam("seq") int seq, 
			HttpServletRequest request, Model model) throws Exception {
		logger.info("Welcome BbaOrderController orderDetail! "+ new Date());
		
		//버거 리스트 가져오기
		List<Bb_BurgerDto> burgerList = bbaOrderService.getBurgerList();
		
		//음료 리스트 가져오기
		List<Bb_BeverageDto> beverageList = bbaOrderService.getBeverageList();
		
		//음료 리스트 가져오기
		List<Bb_SideDto> sideList = bbaOrderService.getSideList();
		
				
		
		//주문 상세 가져오기 (ordermenu)
		//DB에서 전체 주문상세 (OrderMenu) 가져오기
		List<Bb_OrderMenuDto> orderMenuList = bbaOrderService.getOrderMenuList(); 
		//seq 와 일치하는 부분 뽑아서 따로 리스트에 정리
		List<Bb_OrderMenuDto> orderDetail = new ArrayList<Bb_OrderMenuDto>();
		
		for (int i = 0; i < orderMenuList.size(); i++) {
			if(orderMenuList.get(i).getOrder_seq()==seq) {
				orderDetail.add(orderMenuList.get(i));
			}
		}
		
		
		//주문 상세에 있는 메뉴 시퀀스를 이용해서 메뉴 테이블 가져오기
		List<Bb_MenuTableDto> menuList= new ArrayList<Bb_MenuTableDto>();
		for (int i = 0; i < orderDetail.size(); i++) {
			menuList.add(bbaOrderService.getMenuList(orderDetail.get(i).getMenu_seq()));
		}
		

		//Bb_OrderMenuDto에 있는 Bb_MenuTableDto menu; 부분 DTO로 넣기
		for (int i = 0; i < orderDetail.size(); i++) {
			orderDetail.get(i).setMenu(new Bb_MenuTableDto(
					orderDetail.get(i).getSeq(),	//int seq;
						
						menuList.get(i).getBurger(),	//burger seq
						menuList.get(i).getSide(),		//side seq
						menuList.get(i).getBeverage(),	//beverage seq
						menuList.get(i).getName(),		//String name;
						menuList.get(i).getCreator(),	//int creator;
						menuList.get(i).getPrice(),		//int price;
						menuList.get(i).getCal(),		//int cal;
						menuList.get(i).getDel()		//int del;
					));
			
			System.out.println("orderDetail : " + orderDetail.get(i).toString());
		}
		
		
		//메뉴 테이블 (menuList) 에 있는 버거, 사이드, 음료 디티오 형식으로 넣기 
		
		/* 
		 private int order_seq;				//주문 시퀀스
		 
		 private int orderMenu_price;		//가격
		 private int orderMenu_quantity;	//수량
		 
		 private int menu_seq;				//주문 메뉴 seq
		 private String menu_name;			//-주문 메뉴 이름
		 
		 private int burger_seq;			//-버거 seq
		 private String burger_name;		//--버거명
		 private String burger_Ingredient;	//--버거 재료 순서
		 
		 private String beverage_name;		//-음료
		 private String side_name;			//-사이드
		*/
		
		
		List<Bb_OrderDetailDto> odList = new ArrayList<Bb_OrderDetailDto>();
		for (int i = 0; i < orderDetail.size(); i++) {
			
			//버거 찾기
			String burgerName = "";
			String sideName = "";
			String beverageName = "";
			
			for(int j = 0; j < burgerList.size(); j++) {
				if(orderDetail.get(i).getMenu().getBurger()==burgerList.get(j).getSeq()) {
					burgerName = burgerList.get(j).getName();
				}
			}
			
			for(int j = 0; j < beverageList.size(); j++) {
				if(orderDetail.get(i).getMenu().getBeverage()==beverageList.get(j).getSeq()) {
					beverageName = beverageList.get(j).getName();
				}
			}
			
			for(int j = 0; j < sideList.size(); j++) {
				if(orderDetail.get(i).getMenu().getSide()==sideList.get(j).getSeq()) {
					sideName = sideList.get(j).getName();
				}
			}
			
			odList.add(new Bb_OrderDetailDto(
					orderDetail.get(i).getOrder_seq(),	//order_seq
					orderDetail.get(i).getPrice(), 		//orderMenu_price 
					orderDetail.get(i).getQuantity(),		//orderMenu_quantity 
					orderDetail.get(i).getMenu_seq(), 	//menu_seq
					orderDetail.get(i).getMenu().getName(), //menu_name
					orderDetail.get(i).getMenu().getBurger(), //burger_seq,
					burgerName, //burger_name,
					"", //재료
					beverageName, //beverage_name
					sideName //side_name
					));
		}
		
		for(int i = 0; i < odList.size(); i++) {
			System.out.println("odList 최종 : " + odList.get(i).toString());
		}
		
		//정리 된 리스트를 한번에 출력
		model.addAttribute("odList", odList);
		
		return odList;
	}
}

