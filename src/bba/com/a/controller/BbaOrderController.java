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
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_OrderDto;
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
	 * 주문리스트로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "orderlist.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String orderList(HttpServletRequest request, Model model) throws Exception {
		logger.info("Welcome BbaMemberController adminList! "+ new Date());

	
		
		List<Bb_OrderDto> olist = bbaOrderService.getOrderList();
		
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
	
	
	
	
	
	

}













