-- CREATE
DROP SEQUENCE grade_seq;
DROP SEQUENCE art_seq;
DROP SEQUENCE subj_seq;
DROP SEQUENCE major_seq;
DROP SEQUENCE exam_seq;

CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

-- SELECT SEQUENCE_OWNER, SEQUENCE_NAME FROM ALL_SEQUENCES WHERE SEQUENCE_OWNER = 'HANBIT';

DROP TABLE Major CASCADE CONSTRAINT;
DROP TABLE Member CASCADE CONSTRAINT;
DROP TABLE Grade CASCADE CONSTRAINT;
DROP TABLE Board CASCADE CONSTRAINT;
DROP TABLE Subject CASCADE CONSTRAINT;
DROP TABLE Exam CASCADE CONSTRAINT;

CREATE TABLE Major(
	major_seq INT PRIMARY KEY,
	title VARCHAR2(20) NOT NULL
);
CREATE TABLE Member(
	mem_id VARCHAR2(20) PRIMARY KEY,
	pw VARCHAR2(20) NOT NULL,
	name VARCHAR2(20) NOT NULL,
	gender VARCHAR2(10) NOT NULL,
	reg_date VARCHAR2(20) NOT NULL,
	ssn VARCHAR2(10) NOT NULL,
	email VARCHAR2(30),
	profile_img VARCHAR2(100) DEFAULT 'default.jpg',
	role VARCHAR2(10) DEFAULT 'STUDENT',
	phone VARCHAR2(13) NOT NULL,
	major_seq INT,
	CONSTRAINT gender_ck CHECK (gender IN ('MALE', 'FEMALE')),
	CONSTRAINT major_member_fk FOREIGN KEY (major_seq) REFERENCES Major(major_seq) ON DELETE CASCADE
--				부모_자식_fk				    자식 major_seq			  부모 major_seq	
);
CREATE TABLE Grade(
	grade_seq INT PRIMARY KEY,
	grade VARCHAR2(5) NOT NULL,
	term VARCHAR2(10) NOT NULL,
	mem_id VARCHAR2(20) NOT NULL,
	CONSTRAINT member_grade_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
create table Board(
	art_seq INT PRIMARY KEY,
	category VARCHAR2(20) NOT NULL,
	title VARCHAR2(30) DEFAULT 'NO TITLE',
	reg_date VARCHAR2(20) NOT NULL,
	content VARCHAR2(100) DEFAULT 'NO CONTENT',
	mem_id VARCHAR2(20),
	CONSTRAINT member_board_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
create table Subject(
	subj_seq INT PRIMARY KEY,
	subj_name VARCHAR2(20) NOT NULL,
	mem_id VARCHAR2(20) NOT NULL,
	CONSTRAINT member_subject_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
create table Exam(
	exam_seq INT PRIMARY KEY,
	term VARCHAR2(10) NOT NULL,
	score INT DEFAULT 0,
	subj_seq INT,
	mem_id VARCHAR2(20),
	CONSTRAINT subject_exam_fk FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
	CONSTRAINT member_exam_fk FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE OR REPLACE VIEW Major_view 
AS 
SELECT 
	m.major_seq as major_seq,
	m.title AS major_title,
	u.mem_id AS mem_id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS reg_date,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profime_img,
	u.role AS role,
	u.phone AS phone
FROM Major m, Member u 
WHERE m.major_seq = u.major_seq; 

CREATE OR REPLACE VIEW Grade_view
AS
SELECT 
	u.mem_id AS mem_id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS reg_date,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profime_img,
	u.role AS role,
	u.phone AS phone,
	g.grade_seq AS grade_seq,
	g.grade AS grade,
	g.term AS term,
	s.subj_seq AS subj_seq,
	s.subj_name AS subj_name,
	x.exam_seq AS exam_seq,
	x.score AS score
FROM Member u, Grade g, Subject s, Exam x 
WHERE u.mem_id = g.mem_id AND u.mem_id = s.mem_id AND u.mem_id = x.mem_id;

CREATE OR REPLACE VIEW Board_view
AS
SELECT 
	u.mem_id AS mem_id,
	u.pw AS pw,
	u.name AS name,
	u.gender AS gender,
	u.reg_date AS reg_date,
	u.ssn AS ssn,
	u.email AS email,
	u.profile_img AS profime_img,
	u.role AS role,
	u.phone AS phone,
	b.title AS title,
	b.art_seq AS art_seq,
	b.category AS category,
	b.reg_date AS write_date,
	b.content AS content
FROM Member u, Board b  
WHERE u.mem_id = b.mem_id;

CREATE OR REPLACE PROCEDURE insertMajor(
	sp_title IN Major.title%TYPE
) AS
BEGIN 
	INSERT INTO Major(major_seq, title) 
	VALUES(major_seq.NEXTVAL, sp_title)
END insertMajor;

CREATE OR REPLACE PROCEDURE insertMember(
	sp_mem_id IN Member.mem_id%TYPE, 
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_phone IN Member.phone%TYPE,
	sp_role IN Member.role%TYPE,
	sp_major_seq IN Member.major_seq%TYPE
) AS
BEGIN 
	INSERT INTO Member(mem_id, pw, name, gender, reg_date, ssn, email, profile_img, phone, role, major_seq) 
	VALUES(sp_mem_id, sp_pw, sp_name, sp_gender, sp_reg_date, sp_ssn, sp_email, sp_profile_img, sp_phone, sp_role, sp_major_seq)
END insertMember;

CREATE OR REPLACE PROCEDURE insertGrade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS
BEGIN 
	INSERT INTO Grade(grade_seq, grade, term, mem_id) 
	VALUES(sp_grade_seq, sp_grade, sp_term, sp_mem_id)
END insertGrade;

CREATE OR REPLACE PROCEDURE insertBoard(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS
BEGIN 
	INSERT INTO Board(art_seq, category, title, reg_date, content, mem_id) 
	VALUES(sp_art_seq, sp_category, sp_title, sp_reg_date, sp_content, sp_mem_id)
END insertBoard;

CREATE OR REPLACE PROCEDURE insertSubject(
	sp_subj_seq IN Subject.subj_seq%TYPE,
	sp_subj_name IN Subject.subj_name%TYPE,
	sp_mem_id IN Subject.mem_id%TYPE
) AS
BEGIN 
	INSERT INTO Subject(subj_seq, subj_name, mem_id) 
	VALUES(sp_subj_seq, sp_subj_name, sp_mem_id)
END insertSubject;

CREATE OR REPLACE PROCEDURE insertExam(
	sp_exam_seq IN Exam.exam_seq%TYPE,
	sp_term IN Exam.term%TYPE,
	sp_score IN Exam.score%TYPE,
	sp_subj_seq IN Exam.subj_seq%TYPE,
	sp_mem_id IN Exam.mem_id%TYPE
) AS
BEGIN 
	INSERT INTO Exam(exam_seq, term, score, subj_seq, mem_id) 
	VALUES(sp_exam_seq, sp_term, sp_score, sp_subj_seq, sp_mem_id)
END insertExam;

EXEC insertMajor(major_seq.NEXTVAL, '컴퓨터공학');
EXEC insertMember('hong', '1', '홍길동', 'MALE', '2015-06-01', '891201-1', 'hong@test.com', 'hong.jpg', '010-4912-2226', 'STUDENT', 1000);

SELECT * FROM tab;

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

-- grade 

create sequence seq increment by 1 start with 1000 nocycle;

drop table grade;

alter table grade add exam_date varchar2(10);

--CREATE
insert into grade(
	seq, grade, java, sql, html, javascript, id, exam_date
)values(
	seq.nextval, 'C', 75, 78, 72, 70, 'hong', '2016-06'
);

--READ : list
select * from grade;

--READ : findByPK 중복이 불가능한 PK
select * from grade where seq = 1000;

--READ : findByID 중복이 가능한 FK
select * from grade where id = 'hong';

--READE : count
select count(*) from grade where exam_date = '2016-06';

--UPDATE : update
update grade set java = 20, grade = 'A' where seq = 1000;

--DELETE : delete
delete from grade where seq = 1007;

select count(*) as count from grade where exam_date = '2016-06';

----------------------------------------------------------------

-- 뷰 권한주기
sqlplus system/hanbit;
grant dba to hanbit;

create view grade_view as select * from grade;

select * from grade_view;

-- join 조인
create view grade_member as
select 
	g.seq as seq,
	g.grade as grade,
	g.java as java,
	g.sql as sql,
	g.html as html,
	g.javascript as js,
	g.exam_date as exam_date,
	m.id as id,
	m.pw as pw,
	m.name as name,
	m.reg_date as reg_date,
	m.ssn as ssn
from member m, grade g 
where m.id = g.id;

select * from grade_member;