package com.test.housebook.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.housebook.service.AccountService;
import com.test.housebook.vo.AccountVO;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService service;

	// 회원가입 페이지이동 GET
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		logger.info("join 메소드 실행(GET)");
		return "account/join";
	}

	// 회원가입 기능 POST
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(AccountVO account) {
		logger.info("join 메소드 실행(POST)");
		logger.info("id:{}", account.getAcc_id());
		logger.info("pw:{}", account.getAcc_pw());
		logger.info("nm:{}", account.getAcc_nm());

		//id중복체크
		String idCheck = service.login(account.getAcc_id(), null);
		String returnUrl;
		if(idCheck==null) {//중복ID없을시
			//회원가입
			boolean result = service.join(account); 
			if(result) {
				logger.info("회원가입성공"); 
				returnUrl = "account/login";
			}else {
				logger.info("회원가입 실패"); 
				returnUrl = "account/join"; 
			}

		}else {//중복ID있을시
			logger.info("중복ID. 회원가입 실패"); 
			returnUrl = "account/join"; 
		}
		
		return returnUrl;
	}

	// 로그인 페이지이동 GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		logger.info("login 메소드 실행(GET)");
        
		return "account/login";
	}

	// 로그인기능 POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String acc_id, String acc_pw, HttpSession session) {
		logger.info("login 메소드 실행(POST)");
		logger.info("id:{}", acc_id);
		logger.info("pw:{}", acc_pw);
		
		String loginid = service.login(acc_id, acc_pw);
		
		String returnUrl;
		if(loginid != null) {
			logger.info("로그인 성공"); 
			session.setAttribute("loginid", loginid);
			returnUrl = "redirect:/"; 
		}else {
			logger.info("로그인 실패"); 
			returnUrl = "account/login"; 
		}
		return returnUrl;
	}

	// 로그아웃GET
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout 메소드 실행(GET)");
		session.removeAttribute("loginid");
		return "redirect:/";
	}

}
