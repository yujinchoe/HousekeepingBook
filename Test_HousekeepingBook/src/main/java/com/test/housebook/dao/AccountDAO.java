package com.test.housebook.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.housebook.vo.AccountVO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession session;

	//<INSERT>회원가입
	public int join(AccountVO account) {
		int result = 0;
		AccountMapper mapper = null;
		
		try {
			mapper = session.getMapper(AccountMapper.class);
			result = mapper.join(account);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//<SELECT>로그인
	public String login(AccountVO account) {
		String result = null;
		AccountMapper mapper = null;
		
		try {
			mapper = session.getMapper(AccountMapper.class);
			result = mapper.login(account);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
