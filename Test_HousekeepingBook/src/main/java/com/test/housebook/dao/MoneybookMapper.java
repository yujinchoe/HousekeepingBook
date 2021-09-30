package com.test.housebook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.housebook.vo.MoneybookVO;

public interface MoneybookMapper {

	//<SELECT> 회원별 가계부 목록 & id중복체크
	ArrayList<MoneybookVO> boardList(MoneybookVO moneybook);

	//<INSERT> 가계부 작성
	int write(MoneybookVO moneybook);

	//<UPDATE> 가계부 수정
	int update(MoneybookVO moneybook);

	//<DELETE> 가계부 삭제
	int delete(MoneybookVO moneybook);

	//<SELECT>가계부 검색
	ArrayList<MoneybookVO> search(HashMap<String, String> map);

	//<SELECT>ajax총수입
	int totalIncome(String acc_id);

	//<SELECT>ajax총지출
	int totalExpense(String acc_id);

	//<SELECT>MAX
	int max(String acc_id);

	//<SELECT>MIN
	int min(String acc_id);
}
