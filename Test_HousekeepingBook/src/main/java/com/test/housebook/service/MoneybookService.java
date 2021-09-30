package com.test.housebook.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.housebook.dao.MoneybookDAO;
import com.test.housebook.vo.MoneybookVO;

@Service
public class MoneybookService {
	
	@Autowired
	private MoneybookDAO dao;

	//<SELECT>회원별 가계부 목록 & id중복체크
	public ArrayList<MoneybookVO> boardList(String acc_id, int moneybook_no) {
		MoneybookVO moneybook = new MoneybookVO();
		moneybook.setAcc_id(acc_id);
		moneybook.setMoneybook_no(moneybook_no);
		return dao.boardList(moneybook);
	}

	//<INSERT> 가계부 작성
	public boolean write(MoneybookVO moneybook) {
		return dao.write(moneybook) > 0 ? true : false;
	}

	//<UPDATE> 가계부 수정
	public boolean update(MoneybookVO moneybook) {
		return dao.update(moneybook) > 0 ? true : false;
	}

	//<DELETE> 가계부 삭제
	public boolean delete(int moneybook_no, String acc_id) {
		MoneybookVO moneybook = new MoneybookVO();
		moneybook.setAcc_id(acc_id);
		moneybook.setMoneybook_no(moneybook_no);
		return dao.delete(moneybook) > 0 ? true : false;
	}

	//<SELECT>가계부 검색
	public ArrayList<MoneybookVO> search(String acc_id, String condition, String searchWord) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("acc_id", acc_id);
		map.put("condition", condition);
		map.put("searchWord", searchWord);
		return dao.search(map);
	}

	//<SELECT>ajax총수입
	public int totalIncome(String acc_id) {
		return dao.totalIncome(acc_id);
	}
	
	//<SELECT>ajax총지출
	public int totalExpense(String acc_id) {
		return dao.totalExpense(acc_id);
	}

	//<SELECT>MAX
	public int max(String acc_id) {
		return dao.max(acc_id);
	}

	//<SELECT>MIN
	public int min(String acc_id) {
		return dao.min(acc_id);
	}
	
}
