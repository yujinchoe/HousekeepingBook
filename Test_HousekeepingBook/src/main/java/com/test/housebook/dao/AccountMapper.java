package com.test.housebook.dao;

import com.test.housebook.vo.AccountVO;

public interface AccountMapper {

	//<INSERT>회원가입
	int join(AccountVO account);

	//<SELECT>로그인
	String login(AccountVO account);

}
