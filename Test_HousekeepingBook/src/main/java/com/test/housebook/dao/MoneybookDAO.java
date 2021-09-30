package com.test.housebook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.housebook.vo.MoneybookVO;

@Repository
public class MoneybookDAO {

	@Autowired
	private SqlSession session;

	//<SELECT>회원별 가계부 목록 & id중복체크
	public ArrayList<MoneybookVO> boardList(MoneybookVO moneybook) {
		ArrayList<MoneybookVO> result = new ArrayList<>();
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.boardList(moneybook);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//<INSERT> 가계부 작성
	public int write(MoneybookVO moneybook) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.write(moneybook);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//<UPDATE> 가계부 수정
	public int update(MoneybookVO moneybook) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.update(moneybook);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//<DELETE>가계부 삭제
	public int delete(MoneybookVO moneybook) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.delete(moneybook);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//<SELECT>가계부 검색
	public ArrayList<MoneybookVO> search(HashMap<String, String> map) {
		ArrayList<MoneybookVO> result = new ArrayList<>();
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.search(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//<SELECT>ajax총수입
	public int totalIncome(String acc_id) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.totalIncome(acc_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//<SELECT>ajax총지출
	public int totalExpense(String acc_id) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.totalExpense(acc_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//<SELECT>MAX
	public int max(String acc_id) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.max(acc_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//<SELECT>MIN
	public int min(String acc_id) {
		int result = 0;
		MoneybookMapper mapper = null;
		try {
			mapper = session.getMapper(MoneybookMapper.class);
			result = mapper.min(acc_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
