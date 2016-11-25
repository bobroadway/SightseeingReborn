DROP DATABASE SSR;
CREATE DATABASE SSR;
USE SSR;

DROP TABLE SIGHT;
DROP TABLE ZONE;
DROP TABLE USER;
DROP TABLE USER_ROLE;

CREATE TABLE SIGHT 
	( ID	        INT(4)	    	    NOT NULL  AUTO_INCREMENT
    , ZONE_ID		INT(4)				NOT NULL
    , NAME			VARCHAR(25)		    NOT NULL
    , DESCRIPTION   VARCHAR(140)
    , CORD_X        INT(3)				NOT NULL
    , CORD_Y		INT(3)				NOT NULL
    , CORD_Z	    INT(3)
    , SS_URL		VARCHAR(100)
    , USER_NAME     VARCHAR(25)	     	NOT NULL
    , CREATED	    TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	, PRIMARY KEY (ID)
    );

CREATE TABLE ZONE
	( ZONE_ID       INT(3)				NOT NULL  AUTO_INCREMENT
	, EXPANSION     VARCHAR(25)			NOT NULL
	, REGION		VARCHAR(25)			NOT NULL
	, NAME			VARCHAR(30)			NOT NULL
	, PRIMARY KEY (ZONE_ID)
	);

CREATE TABLE USER
	( USER_NAME     VARCHAR(25)			NOT NULL
	, PASSWORD      VARCHAR(25)			NOT NULL
	, CREATED       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	, PIC_URL       VARCHAR(100)
	, PRIMARY KEY (USER_NAME)
	);

CREATE TABLE USER_ROLE
    ( USER_NAME		VARCHAR(25)		    NOT NULL
	, ROLE_NAME     VARCHAR(25)         NOT NULL
	, PRIMARY KEY (USER_NAME, ROLE_NAME)
	);

ALTER TABLE SIGHT
	ADD FOREIGN KEY (ZONE_ID)
	REFERENCES ZONE(ZONE_ID);

ALTER TABLE SIGHT
	ADD FOREIGN KEY (USER_NAME)
	REFERENCES USER(USER_NAME);

CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'tomcat';
GRANT SELECT ON SSR.* TO 'tomcat'@'localhost';

INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , "Ul'dah - Steps of Nald");
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , "Ul'dah - Steps of Thal");
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'The Goblet');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Central Thanalan');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Western Thanalan');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Eastern Thanalan');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Southern Thanalan');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Northern Thanalan');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'The Gold Saucer');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'Old Gridania');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'New Gridania');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'Lavender Beds');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'Central Shroud');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'East Shroud');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'South Shroud');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'North Shroud');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Limsa Lominsa Upper Decks');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Limsa Lominsa Lower Decks');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'The Mist');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Middle La Noscea');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Western La Noscea');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Eastern La Noscea');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Lower La Noscea');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Upper La Noscea');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Outer La Noscea');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'La Noscea'
				 , "The Wolves' Den");
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Mor Dhona'
				 , 'Mor Dhona');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'A Realm Reborn'
				 , 'Coerthas'
				 , 'Coerthas Central Highlands');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Coerthas'
				 , 'Ishgard - Foundation');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Coerthas'
				 , 'Ishgard - The Pillars');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Coerthas'
				 , 'Coerthas Western Highlands');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Dravania'
				 , 'Idyllshire');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Dravania'
				 , 'The Dravanian Forelands');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Dravania'
				 , 'The Dravanian Hinterlands');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Dravania'
				 , 'The Churning Mists');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Abalathia'
				 , 'The Sea of Clouds');
INSERT INTO ZONE ( EXPANSION
                 , REGION
				 , NAME)
		  VALUES ( 'Heavensward'
				 , 'Abalathia'
				 , 'Azys Lla');

INSERT INTO USER ( USER_NAME, PASSWORD ) VALUES ('admin', 'iamadmin');
INSERT INTO USER ( USER_NAME, PASSWORD ) VALUES ('bo', 'iambo');

INSERT INTO USER_ROLE VALUES ('admin', 'admin');
INSERT INTO USER_ROLE VALUES ('admin', 'registeredUser');
INSERT INTO USER_ROLE VALUES ('bo', 'registeredUser');
	