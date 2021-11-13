
/* Drop Tables */

DROP TABLE USERS CASCADE CONSTRAINTS;




/* Create Tables */

-- ����
CREATE TABLE USERS
(
	-- ������ȣ
	USER_CODE varchar2(3) NOT NULL,
	-- ���� ID
	USER_ID varchar2(20) NOT NULL UNIQUE,
	-- ��й�ȣ
	USER_PW varchar2(20) NOT NULL,
	-- �̸�
	USER_NAME varchar2(15) NOT NULL,
	-- ��ȭ��ȣ
	PHONE varchar2(15) NOT NULL,
	PRIMARY KEY (USER_CODE)
);



/* Comments */

COMMENT ON TABLE USERS IS '����';
COMMENT ON COLUMN USERS.USER_CODE IS '������ȣ';
COMMENT ON COLUMN USERS.USER_ID IS '���� ID';
COMMENT ON COLUMN USERS.USER_PW IS '��й�ȣ';
COMMENT ON COLUMN USERS.USER_NAME IS '�̸�';
COMMENT ON COLUMN USERS.PHONE IS '��ȭ��ȣ';



