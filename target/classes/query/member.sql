select * from member;

create table member(
	id varchar2(20) primary key,
	pw varchar2(20),
	name varchar2(20),
	reg_date varchar2(20),
	ssn varchar2(10),
	email varchar2(30),
	profile_img varchar2(100),
	phone varchar2(15)
);
-- CREATE
insert into member(id,pw,name,reg_date,ssn, email, profile_img, phone) values('lee','1','이순신','2016-07-01','800101-1', 'lee@test.com', 'lee.jpg', '010-1234-5678');
insert into member(id,pw,name,reg_date,ssn, email, profile_img, phone) values('hong','1','홍길동','2015-06-01','891201-1', 'hong@test.com', 'hong.jpg', '010-4912-2226');
insert into member(id,pw,name,reg_date,ssn, email, profile_img, phone) values('park','1','박지성','2014-05-01','901211-1', 'park@test.com', 'hong2.jpg', '010-4912-2226');
insert into member(id,pw,name,reg_date,ssn, email, profile_img, phone) values('ku','1','김구','2014-04-05','901211-1', 'ku@test.com', 'hong2.jpg', '010-4912-2226');
insert into member(id,pw,name,reg_date,ssn, email, profile_img, phone) values('jang','1','장종익','2014-04-05','940729-1', 'plus4912@gamil.com', 'jang.jpg', '010-4912-2226');
insert into member(id,pw,name,reg_date,ssn) values('hong3','1','홍길동','2016-04-01','880501-1');
insert into member(id,pw,name,reg_date,ssn) values('yu','1','유관순','2014-07-01','010701-1');
insert into member(id,pw,name,reg_date,ssn) values('jang','1','장종익','2014-07-05','940729-1');
-- READ
select * from MEMBER;	-- list
select * from MEMBER where id = 'hong';	-- findByPK
select * from MEMBER where name = '홍길동';	  -- findByNotPK	
select count(*) as count from MEMBER; -- count
-- UPDATE
update member set email = 'hong@test.com' where id = 'hong';
update member set email = 'plus4912@gmail.com';
update member set phone = '010-4912-2226';
update member set pw = '1' where id = 'hong';
update member set email = id || '@test.com';
update member set profile_img = 'lee.gif' where id = 'lee';
alter table member add email varchar2(30);
alter table member add profile_img varchar2(100);
alter table member add phone varchar2(15);
alter table member modify phone varchar2(20);
update member set reg_date = '2016-07-15' where reg_date is null;
update member set profile_img = id || '.jpg' where profile_img is null;
-- DELETE
delete from member where pw = '2';