package bba.com.a.controller;

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
		
		//주문 상세 가져오기 (ordermenu)
		Bb_OrderMenuDto orderMenuDto = new Bb_OrderMenuDto();
		List<Bb_OrderMenuDto> orderMenuList=null;
		for (int i = 0; i < olist.size(); i++) {
			orderMenuList = bbaOrderService.getOrderMenuList(olist.get(i).getSeq());
		}
		
		//주문 상세에 있는 메뉴 시퀀스를 이용해서 메뉴 테이블 가져오기
		List<Bb_MenuTableDto> menuList=null;
		for (int i = 0; i < orderMenuList.size(); i++) {
			menuList = bbaOrderService.getMenuList(orderMenuList.get(i).getMenu().getSeq());
			orderMenuDto.setMenu(new Bb_MenuTableDto(
					0, 								//seq
					menuList.get(i).getBurger(), 	//Bb_BurgerDto burger
					menuList.get(i).getSide(), 		//Bb_SideDto side
					menuList.get(i).getBeverage(), 	//Bb_BeverageDto beverage
					menuList.get(i).getName(), 		//String name
					menuList.get(i).getCreatorSeq(),//creatorSeq
					menuList.get(i).getPrice(), 	//price
					menuList.get(i).getCalorie(), 	//calorie
					menuList.get(i).getDel()		//del
					));
		}
				
				
				for (int i = 0; i < menuList.size(); i++) {
					System.out.println("주문 상세를 통해 얻어온 메뉴 시퀀스 : "  + menuList.get(i).getSeq());
				}
				
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
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("olist", olist);
		model.addAttribute("memberList", memberList);
		model.addAttribute("addrList", addrList);
		model.addAttribute("storeList", storeList);
		
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
	
	
		List<Bb_OrderDto> olist = bbaOrderService.getOrderList();
		
		//주문 상세 가져오기 (ordermenu)
		List<Bb_OrderMenuDto> orderMenuList=null;
		for (int i = 0; i < olist.size(); i++) {
			orderMenuList = bbaOrderService.getOrderMenuList(olist.get(i).getSeq());
		}
		
		
		//주문 상세에 있는 메뉴 시퀀스를 이용해서 메뉴 테이블 가져오기
		List<Bb_MenuTableDto> menuList=null;
		for (int i = 0; i < orderMenuList.size(); i++) {
			menuList = bbaOrderService.getMenuList(orderMenuList.get(i).getMenu().getSeq());
		}
		
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

		
		
		
		return null;
	}

}













