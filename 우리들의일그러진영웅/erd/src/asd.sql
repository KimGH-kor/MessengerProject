
/* Drop Tables */

DROP TABLE USERS CASCADE CONSTRAINTS;




/* Create Tables */

-- 유저
CREATE TABLE USERS
(
	-- 유저번호
	USER_CODE varchar2(3) NOT NULL,
	-- 유저 ID
	USER_ID varchar2(20) NOT NULL UNIQUE,
	-- 비밀번호
	USER_PW varchar2(20) NOT NULL,
	-- 이름
	USER_NAME varchar2(15) NOT NULL,
	-- 전화번호
	PHONE varchar2(15) NOT NULL,
	PRIMARY KEY (USER_CODE)
);



/* Comments */

COMMENT ON TABLE USERS IS '유저';
COMMENT ON COLUMN USERS.USER_CODE IS '유저번호';
COMMENT ON COLUMN USERS.USER_ID IS '유저 ID';
COMMENT ON COLUMN USERS.USER_PW IS '비밀번호';
COMMENT ON COLUMN USERS.USER_NAME IS '이름';
COMMENT ON COLUMN USERS.PHONE IS '전화번호';



