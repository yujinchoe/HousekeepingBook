package com.test.housebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.housebook.dao.AccountDAO;
import com.test.housebook.vo.AccountVO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO dao;

	//<INSERT>회원가입
	public boolean join(AccountVO account) {
		return dao.join(account) > 0 ? true : false;
	}
	
	//<SELECT>로그인
	public String login(String add_id, String add_pw) {
		AccountVO account = new AccountVO();
		account.setAcc_id(add_id);
		account.setAcc_pw(add_pw);
		
		return dao.login(account);
	}
	
}
