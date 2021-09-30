drop sequence moneybook_tb_seq;
drop table moneybook_tb;
drop table account_tb;

create table account_tb(
    acc_id      varchar2(30)        primary key
    ,acc_nm     varchar2(30)        not null
    ,acc_pw     varchar2(30)        not null
);

create table moneybook_tb(
    moneybook_no        number          primary key
    ,acc_id             varchar2(30)    references account_tb(acc_id) not null
    ,moneybook_memo     varchar2(1000)  not null
    ,moneybook_type     varchar2(20)    not null
    ,moneybook_amount   number          default 0
    ,moneybook_indate   date            default sysdate
);

create sequence moneybook_tb_seq nocache;