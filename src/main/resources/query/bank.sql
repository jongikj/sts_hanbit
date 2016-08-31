----------------------[내부 스키마 (물리적)]---------------------------
create table account(
	account_no int primary key,  
	money int, 
	id varchar2(20),
	constraint account_member_fk foreign key (id) references member(id) on delete cascade
);

insert into account(account_no, money, id) values(987654, 1000000, 'hong');

-----------------------[외부 스키마 (논리적[가상])]------------------------------
create view account_member as 
select 
	a.account_no as account_no,  --이름이 같으면 as 생략가능.  
	a.money as money, 
    m.id as id,
	m.pw as pw, 
    m.name as name,
    m.reg_date as reg_date,
    m.ssn as ssn
from member m, account a where m.id = a.id;

select * from account_member;

drop table account;
drop view account_member;

select 
	account_no as acc,
	id as id,
	name as name,
	money as money,
	ssn as birth
from account_member;