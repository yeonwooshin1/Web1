drop database if exists assessment;
create database assessment;
use assessment;


create table MEMBER_TBL_02(
	CUSTNO int not null auto_increment , -- 번호	
    CUSTNAME varchar(20) ,		-- 성명
    PHONE varchar(13) ,		-- 연락처
    ADDRESS varchar(60) ,	-- 주소	
    JOINDATE date ,			 -- 가입일자
    GRADE char(1)  ,		-- 고객등급	
    CITY char(2) ,			-- 거주도시 코드	
    constraint primary key (CUSTNO)			
) ENGINE=InnoDB AUTO_INCREMENT=100001;

create table MONEY_TBL_02(
	CUSTNO INT NOT NULL ,
    SALENO INT not null auto_increment  , -- 번호	
	PCOST	int ,
    AMOUNT int ,
    PRICE int ,
    PCODE varchar(4),
    SDATE date , 
	constraint primary key (SALENO) ,	
	constraint foreign key (CUSTNO) references MEMBER_TBL_02(CUSTNO)
)ENGINE=InnoDB AUTO_INCREMENT=20160001;

INSERT INTO MEMBER_TBL_02 
(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
VALUES
(100001, '김행복', '010-1111-2222', '서울 동대문구 휘경동', '2015-12-02', 'A', '01'),
(100002, '이축복', '010-1111-3333', '서울 동대문구 휘경동', '2015-12-06', 'B', '01'),
(100003, '장믿음', '010-1111-4444', '울릉군 독도리', '2015-10-01', 'B', '30'),
(100004, '조인환', '010-1111-5555', '울릉군 독도리', '2015-11-13', 'A', '30'),
(100005, '진평화', '010-1111-6666', '제주도 제주시 외나무골', '2015-12-25', 'B', '60'),
(100006, '차공단', '010-1111-7777', '제주도 제주시 감나무골', '2015-12-11', 'C', '60');

-- 판매 샘플 (SALENO는 생략하면 자동 생성됨)
INSERT INTO MONEY_TBL_02
(CUSTNO, PCOST, AMOUNT, PRICE, PCODE, SDATE)
VALUES
(100001,  500, 5,  2500, 'A001', '2016-01-01'),
(100001, 1000, 4,  4000, 'A002', '2016-01-01'),
(100002,  500, 3,  1500, 'A008', '2016-01-01'),
(100002, 1500, 1,  1500, 'A001', '2016-01-03'),
(100003,  500, 2,  1000, 'A003', '2016-01-03'),
(100004,  300, 5,  1500, 'A001', '2016-01-04'),
(100004,  600, 1,   600, 'A005', '2016-01-04'),
(100004, 3000, 1,  3000, 'A006', '2016-01-04'),
(100004, 3000, 1,  3000, 'A007', '2016-01-05');

SELECT
  MEMBER_TBL_02.CUSTNO   AS CustomerNo,
  MEMBER_TBL_02.CUSTNAME AS CustomerName,
  MEMBER_TBL_02.GRADE    AS Grade,
  SUM(MONEY_TBL_02.PRICE) AS Sales
FROM MEMBER_TBL_02
INNER JOIN MONEY_TBL_02
  ON MONEY_TBL_02.CUSTNO = MEMBER_TBL_02.CUSTNO  -- 매출 테이블을 회원번호로 내부조인.
GROUP BY
  MEMBER_TBL_02.CUSTNO,
  MEMBER_TBL_02.CUSTNAME,
  MEMBER_TBL_02.GRADE -- 회원번호/회원명/등급 단위로 묶어서 집계 수행.
ORDER BY
  Sales DESC, -- 먼저 총매출(Sales) 내림차순으로 정렬(매출 높은 순)
  MEMBER_TBL_02.CUSTNO ASC; -- 매출이 같으면 회원번호 오름차순으로 두 번째 정렬.
select * from MEMBER_TBL_02;