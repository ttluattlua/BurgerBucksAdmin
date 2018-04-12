/* 관리자 사원 등록 테이블 생성 */

DROP TABLE BB_ADMIN
CASCADE CONSTRAINT;

DROP SEQUENCE BB_ADMIN_SEQ;

CREATE TABLE BB_ADMIN(
	SEQ NUMBER(10) PRIMARY KEY,
	ID VARCHAR2(20) UNIQUE,
	PASSWORD VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	PHONE VARCHAR2(20) NOT NULL,
	STORE_SEQ NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_ADMIN_SEQ
START WITH 1
INCREMENT BY 1;

SELECT SEQ, ID, PASSWORD, NAME, PHONE, STORE_SEQ, DEL
FROM BB_ADMIN
ORDER BY SEQ DESC


INSERT INTO BB_ADMIN(SEQ, ID, PASSWORD, NAME, PHONE, STORE_SEQ, DEL)
VALUES ( BB_ADMIN_SEQ.NEXTVAL,'admin', 'admin', 'admin', '111-1111-1111', 1, 0 )

SELECT * FROM BB_ADMIN;


/* 지점 테이블 생성 */

DROP TABLE BB_STORE
CASCADE CONSTRAINT;

DROP SEQUENCE BB_STORE_SEQ;


CREATE TABLE BB_STORE(
	SEQ NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	PHONE VARCHAR2(20) NOT NULL,
	ADDRESS VARCHAR2(200) NOT NULL,
	LAT VARCHAR2(100) NOT NULL,
	LNG VARCHAR2(100) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_STORE_SEQ
START WITH 1
INCREMENT BY 1;

INSERT INTO BB_STORE(SEQ, NAME, PHONE, ADDRESS, LAT, LNG, DEL)
VALUES ( BB_STORE_SEQ.NEXTVAL,'A', '123-1234-1234', '서울시', 1, 1, 0 )

SELECT * FROM BB_STORE;




/* 멤버 테이블 생성 */
DROP TABLE BB_MEMBER
CASCADE CONSTRAINT;

DROP SEQUENCE BB_MEMBER_SEQ;

CREATE TABLE BB_MEMBER(
	SEQ NUMBER(10) PRIMARY KEY,
	ID VARCHAR2(20) NOT NULL,
	PASSWORD VARCHAR2(20) NOT NULL,
	BDAY VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	PHONE VARCHAR2(20) NOT NULL,
	SEX NUMBER(1) NOT NULL,
	MILEAGE NUMBER(10) NOT NULL,
	GRADE NUMBER(10) NOT NULL,
	EXP NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_MEMBER_SEQ
START WITH 1
INCREMENT BY 1;


/* 주소 테이블 */
DROP TABLE BB_ADDR
CASCADE CONSTRAINT;

DROP SEQUENCE BB_ADDR_SEQ;

CREATE TABLE BB_ADDR(
	SEQ NUMBER(10) PRIMARY KEY,
	MEMBER_SEQ NUMBER(10) NOT NULL,
	ADDRESS VARCHAR2(100) NOT NULL,
	LAT VARCHAR2(100) NOT NULL,
	LNG VARCHAR2(100) NOT NULL,
	MEMO VARCHAR2(200),
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_ADDR_SEQ
START WITH 1
INCREMENT BY 1;


/* 주문 테이블 */
DROP TABLE BB_ORDER
CASCADE CONSTRAINT;

DROP SEQUENCE BB_ORDER_SEQ;

CREATE TABLE BB_ORDER(
	SEQ NUMBER(10) PRIMARY KEY,
	MEMBER_SEQ NUMBER(10) NOT NULL,
	MEMBER_ADDR NUMBER(10) NOT NULL,
	STORE_SEQ NUMBER(10) NOT NULL,
	ORDER_DATE DATE NOT NULL,
	STATUS NUMBER(1) NOT NULL,
	DEL NUMBER(1) NOT NULL
)
	
CREATE SEQUENCE BB_ORDER_SEQ
START WITH 1
INCREMENT BY 1;


/* 주문 상세 테이블 */
DROP TABLE BB_ORDERMENU
CASCADE CONSTRAINT;

DROP SEQUENCE BB_ORDERMENU_SEQ;

CREATE TABLE BB_ORDERMENU(
	SEQ NUMBER(10) PRIMARY KEY,
	ORDER_SEQ NUMBER(10) NOT NULL,
	MENU_SEQ NUMBER(10) NOT NULL,
	QUANTITY NUMBER(4) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_ORDERMENU_SEQ
START WITH 1
INCREMENT BY 1;


/* 즐겨찾기 테이블 생성 */
DROP TABLE BB_FAVORITE
CASCADE CONSTRAINT;

DROP SEQUENCE BB_FAVORITE_SEQ;

CREATE TABLE BB_FAVORITE(
	SEQ NUMBER(10) PRIMARY KEY,
	MEMBER_SEQ NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_FAVORITE_SEQ
START WITH 1
INCREMENT BY 1;


/* 즐겨찾기 테이블 상세 */
DROP TABLE BB_FAVORITEMENU
CASCADE CONSTRAINT;

DROP SEQUENCE BB_FAVORITEMENU_SEQ;

CREATE TABLE BB_FAVORITEMENU(
	SEQ NUMBER(10) PRIMARY KEY,
	FAVORITE_SEQ NUMBER(10) NOT NULL,
	MENU_SEQ NUMBER(10) NOT NULL,
	QUANTITY NUMBER(4) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_FAVORITEMENU_SEQ
START WITH 1
INCREMENT BY 1;



/* 메뉴 테이블 생성 */
DROP TABLE BB_MENU
CASCADE CONSTRAINT;

DROP SEQUENCE BB_MENU_SEQ;

CREATE TABLE BB_MENU(
	SEQ NUMBER(10) PRIMARY KEY,
	BURGER NUMBER(10) NOT NULL,
	SIDE NUMBER(10) NOT NULL,
	BEVERAGE NUMBER(10) NOT NULL,
	NAME VARCHAR2(100) NOT NULL,
	CREATOR NUMBER(20) NOT NULL,
	PRICE NUMBER(20) NOT NULL,
	CAL NUMBER(20) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_MENU_SEQ
START WITH 1
INCREMENT BY 1;


/* 버거 테이블 생성 */
DROP TABLE BB_BURGER
CASCADE CONSTRAINT;

DROP SEQUENCE BB_BURGER;

CREATE TABLE BB_BURGER(
	SEQ NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	INGREDIENT01 NUMBER(10) NOT NULL,
	INGREDIENT02 NUMBER(10) NOT NULL,
	INGREDIENT03 NUMBER(10) NOT NULL,
	INGREDIENT04 NUMBER(10) NOT NULL,
	INGREDIENT05 NUMBER(10) NOT NULL,
	INGREDIENT06 NUMBER(10) NOT NULL,
	INGREDIENT07 NUMBER(10) NOT NULL,
	INGREDIENT08 NUMBER(10) NOT NULL,
	INGREDIENT09 NUMBER(10) NOT NULL,
	INGREDIENT10 NUMBER(10) NOT NULL,
	CREATOR NUMBER(10) NOT NULL,
	PRICE NUMBER(20) NOT NULL,
	CAL NUMBER(20) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_BURGER_SEQ
START WITH 1
INCREMENT BY 1;


/* 재료 테이블 */
DROP TABLE BB_INGREDIENT
CASCADE CONSTRAINT;

DROP SEQUENCE BB_INGREDIENT;

CREATE TABLE BB_INGREDIENT(
	SEQ NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	INGREDIENT_TYPE NUMBER(1) NOT NULL,
	PRICE NUMBER(20) NOT NULL,
	CAL NUMBER(20) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_INGREDIENT_SEQ
START WITH 1
INCREMENT BY 1;


/* 음료 테이블 */
DROP TABLE BB_BEVERAGE
CASCADE CONSTRAINT;

DROP SEQUENCE BB_BEVERAGE;

CREATE TABLE BB_BEVERAGE(
	SEQ NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	PRICE NUMBER(20) NOT NULL,
	CAL NUMBER(20) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_BEVERAGE_SEQ
START WITH 1
INCREMENT BY 1;


/* 사이트 테이블 */
DROP TABLE BB_SIDE
CASCADE CONSTRAINT;

DROP SEQUENCE BB_SIDE;

CREATE TABLE BB_SIDE(
	SEQ NUMBER(10) PRIMARY KEY,
	NAME VARCHAR2(100) NOT NULL,
	PRICE NUMBER(20) NOT NULL,
	CAL NUMBER(20) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_SIDE_SEQ
START WITH 1
INCREMENT BY 1;


/* 햄버거 테이블 생성 */
DROP TABLE BB_BBS
CASCADE CONSTRAINT;

DROP SEQUENCE BB_BBS;

CREATE TABLE BB_BBS(
	SEQ NUMBER(10) PRIMARY KEY,
	BURGER_SEQ NUMBER(10) NOT NULL,
	ID VARCHAR2(20) NOT NULL,
	BBS_LIKE NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_BBS_SEQ
START WITH 1
INCREMENT BY 1;


/* 햄버거 테이블 좋아요 */
DROP TABLE BB_LIKE
CASCADE CONSTRAINT;

DROP SEQUENCE BB_LIKE;

CREATE TABLE BB_LIKE(
	SEQ NUMBER(10) PRIMARY KEY,
	ID VARCHAR2(20) NOT NULL,
	BBS_SEQ NUMBER(10) NOT NULL
)



/* 이미지 테이블 */
DROP TABLE BB_IMAGE
CASCADE CONSTRAINT;

DROP SEQUENCE BB_IMAGE;

CREATE TABLE BB_IMAGE(
	SEQ NUMBER(10) PRIMARY KEY,
	TABLE_NAME VARCHAR2(100) NOT NULL,
	WHAT_IMAGE VARCHAR2(100) NOT NULL,
	IMAGE_SRC VARCHAR2(100) NOT NULL,
	REF_SEQ NUMBER(10) NOT NULL,
	DEL NUMBER(1) NOT NULL
)

CREATE SEQUENCE BB_IMAGE_SEQ
START WITH 1
INCREMENT BY 1;




/* 외래키 */

ALTER TABLE BB_ADMIN
ADD CONSTRAINT FK_BB_STORE_SEQ FOREIGN KEY(STORE_SEQ)
REFERENCES BB_STORE(SEQ);

ALTER TABLE BB_ADDR
ADD CONSTRAINT FK_BB_M_ADDR_SEQ FOREIGN KEY(MEMBER_SEQ)
REFERENCES BB_MEMBER(SEQ);

ALTER TABLE BB_FAVORITE
ADD CONSTRAINT FK_BB_M_FAVORITE_SEQ FOREIGN KEY(MEMBER_SEQ)
REFERENCES BB_MEMBER(SEQ);

ALTER TABLE BB_FAVORITEMENU
ADD CONSTRAINT FK_BB_F_FAVORITEMENU_SEQ FOREIGN KEY(FAVORITE_SEQ)
REFERENCES BB_FAVORITE(SEQ);

ALTER TABLE BB_ORDER
ADD CONSTRAINT FK_BB_MS_ORDER_SEQ FOREIGN KEY(MEMBER_SEQ)
REFERENCES BB_MEMBER(SEQ);

ALTER TABLE BB_ORDER
ADD CONSTRAINT FK_BB_AS_ORDER_SEQ FOREIGN KEY(MEMBER_ADDR)
REFERENCES BB_ADDR(SEQ);

ALTER TABLE BB_ORDER
ADD CONSTRAINT FK_BB_SS_ORDER_SEQ FOREIGN KEY(STORE_SEQ)
REFERENCES BB_STORE(SEQ);

ALTER TABLE BB_ORDERMENU
ADD CONSTRAINT FK_BB_O_ORDERMENU_SEQ FOREIGN KEY(ORDER_SEQ)
REFERENCES BB_ORDER(SEQ);

ALTER TABLE BB_ORDERMENU
ADD CONSTRAINT FK_BB_M_ORDERMENU_SEQ FOREIGN KEY(MENU_SEQ)
REFERENCES BB_MENU(SEQ);

ALTER TABLE BB_MENU
ADD CONSTRAINT FK_BB_BURGER_MENU_SEQ FOREIGN KEY(BURGER)
REFERENCES BB_BURGER(SEQ);

ALTER TABLE BB_MENU
ADD CONSTRAINT FK_BB_SIDE_MENU_SEQ FOREIGN KEY(SIDE)
REFERENCES BB_SIDE(SEQ);

ALTER TABLE BB_MENU
ADD CONSTRAINT FK_BB_BEVERAGE_MENU_SEQ FOREIGN KEY(BEVERAGE)
REFERENCES BB_BEVERAGE(SEQ);

ALTER TABLE BB_BBS
ADD CONSTRAINT FK_BB_BURGER_BBS_SEQ FOREIGN KEY(BURGER_SEQ)
REFERENCES BB_BURGER(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE_BURGER_SEQ FOREIGN KEY(INGREDIENT01)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE02_BURGER_SEQ FOREIGN KEY(INGREDIENT02)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE03_BURGER_SEQ FOREIGN KEY(INGREDIENT03)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE04_BURGER_SEQ FOREIGN KEY(INGREDIENT04)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE05_BURGER_SEQ FOREIGN KEY(INGREDIENT05)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE06_BURGER_SEQ FOREIGN KEY(INGREDIENT06)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE_BURGER07_SEQ FOREIGN KEY(INGREDIENT07)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE_BURGER08_SEQ FOREIGN KEY(INGREDIENT08)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE_BURGER09_SEQ FOREIGN KEY(INGREDIENT09)
REFERENCES BB_INGREDIENT(SEQ);

ALTER TABLE BB_BURGER
ADD CONSTRAINT FK_BB_INGRE_BURGER10_SEQ FOREIGN KEY(INGREDIENT10)
REFERENCES BB_INGREDIENT(SEQ);