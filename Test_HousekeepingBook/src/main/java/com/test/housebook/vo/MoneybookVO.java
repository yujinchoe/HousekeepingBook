package com.test.housebook.vo;

import lombok.Data;

@Data
public class MoneybookVO {
	private int moneybook_no;
	private String acc_id;
	private String moneybook_memo;
	private String moneybook_type;
	private int moneybook_amount;
	private String moneybook_indate;
}
