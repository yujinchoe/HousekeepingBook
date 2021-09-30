package com.test.housebook.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.housebook.service.MoneybookService;
import com.test.housebook.vo.MoneybookVO;

@Controller
@RequestMapping(value="/moneybook")
public class MoneybookController {
	private static final Logger logger = LoggerFactory.getLogger(MoneybookController.class);
	
	@Autowired
	private MoneybookService service;
	//***페이지이동 GET
	//메인에서 쿼리스트링방식으로 이동하면 주소에 다른 ID로 바꿔치면 페이지 이동 돼버리니까
	//쿼리스트링방식말고 HttpSession방식으로 이동하도록 바꿈.
	@RequestMapping(value="/moneybook", method = RequestMethod.GET)
	public String moneybook(Model model, HttpSession session) {
		logger.info("moneybook 메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		ArrayList<MoneybookVO> boardList = service.boardList(acc_id, 0);
		logger.info("boardList:{}", boardList);
		
		model.addAttribute("id", acc_id);
		model.addAttribute("board", boardList);
		
		return "moneybook/moneybook";
	}
	
	//가계부작성 페이지 이동 GET
	@RequestMapping(value="write", method = RequestMethod.GET)
	public String write(HttpSession session) {
		logger.info("write메소드 실행(GET)");
		
		return "moneybook/write";
	}
	
	//가계부작성기능 POST
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String write(MoneybookVO moneybook, HttpSession session) {
		logger.info("write 메소드 실행(POST)");
		logger.info("memo:{}", moneybook.getMoneybook_memo());
		logger.info("type:{}", moneybook.getMoneybook_type());
		logger.info("amount:{}", moneybook.getMoneybook_amount());
		String acc_id = (String)session.getAttribute("loginid");
		logger.info("id:{}", acc_id);
		moneybook.setAcc_id(acc_id);
		logger.info("moneybook:{}", moneybook);
		
		boolean result = service.write(moneybook);
        
		String returnUrl = null;
		if(result) {
			logger.info("가계부작성 성공");
			returnUrl="redirect:/moneybook/moneybook?acc_id=" + acc_id;
		}else {
			logger.info("가계부작성 실패");
			returnUrl = "moneybook/write";
		}
		
		return returnUrl;
	}
	
	//가계부수정 페이지 이동 GET
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String update(int moneybook_no, HttpSession session, Model model) {
		logger.info("update메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		logger.info("moneybook_no:{}", moneybook_no);
		logger.info("acc_id:{}", acc_id);
		
		ArrayList<MoneybookVO> boardList= service.boardList(acc_id, moneybook_no);

		logger.info("boardList:{}", boardList);
		MoneybookVO board= boardList.get(0);
		logger.info("board:{}", board);
		model.addAttribute("board", board);
		
		return "moneybook/update";
	}
	
	//가계부수정기능 POST
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(MoneybookVO moneybook) {
		logger.info("update 메소드 실행(POST)");
		logger.info("bno:{}", moneybook.getMoneybook_no());
		logger.info("memo:{}", moneybook.getMoneybook_memo());
		logger.info("type:{}", moneybook.getMoneybook_type());
		logger.info("amount:{}", moneybook.getMoneybook_amount());
		logger.info("id:{}", moneybook.getAcc_id());
			
		boolean result = service.update(moneybook);

		if(result) {logger.info("가계부수정 성공");}
		else {logger.info("가계부수정 실패");}
			
		return "redirect:/moneybook/moneybook?acc_id=" + moneybook.getAcc_id();
	}
	
	//가계부삭제 기능 GET
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int moneybook_no, HttpSession session) {
		logger.info("update메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		logger.info("moneybook_no:{}", moneybook_no);
		logger.info("acc_id:{}", acc_id);
			
		boolean result = service.delete(moneybook_no, acc_id);
		
		if(result) {logger.info("가계부삭제 성공");}
		else {logger.info("가계부삭제 실패");}
			
		return "redirect:/moneybook/moneybook?acc_id=" + acc_id;
	}
	
	//가계부 조회 GET
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search(String condition, String searchWord, String acc_id, Model model) {
		logger.info("search메소드 실행(GET)");
		logger.info("id:{}",acc_id);
		logger.info("condition:{}", condition);
		logger.info("searchWord:{}", searchWord);
		
		ArrayList<MoneybookVO> boardList = service.search(acc_id, condition, searchWord);
		logger.info("boardList:{}", boardList);
		
		model.addAttribute("id", acc_id);
		model.addAttribute("board", boardList);
		
		return "moneybook/moneybook";
	}
	
	//ajax총수입 get
	@ResponseBody
	@RequestMapping(value="/totalIncome", method = RequestMethod.GET)
	public int totalIncome(HttpSession session) {
		logger.info("totalIncome메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		int data = service.totalIncome(acc_id);

		//String data = String.valueOf(result);
		return data;
	}
		
	//ajax총지출 get
	@ResponseBody
	@RequestMapping(value="/totalExpense", method = RequestMethod.GET)
	public String totalExpense(HttpSession session) {
		logger.info("totalExpense메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		int result = service.totalExpense(acc_id);
		
		String data = String.valueOf(result);
		return data;
	}
	
	//ajax최대값 get
	@ResponseBody
	@RequestMapping(value="/max", method = RequestMethod.GET)
	public String max(HttpSession session) {
		logger.info("max메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		int result = service.max(acc_id);

		String data = String.valueOf(result);
		return data;
	}
	
	//ajax최소값 get
	@ResponseBody
	@RequestMapping(value="/min", method = RequestMethod.GET)
	public String min(HttpSession session) {
		logger.info("min메소드 실행(GET)");
		String acc_id = (String)session.getAttribute("loginid");
		int result = service.min(acc_id);

		String data = String.valueOf(result);
		return data;
	}
		
}
