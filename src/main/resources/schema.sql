CREATE TABLE juttu (
	juttuid INTEGER AUTO_INCREMENT NOT NULL,
	nimi CHAR(40),
	PRIMARY KEY(juttuid)
);

CREATE TABLE henkilo (
	henkiloid INTEGER AUTO_INCREMENT NOT NULL,
	juttuid INTEGER,
	etunimi CHAR(40),
	sukunimi CHAR(40),
	PRIMARY KEY(henkiloid),
	FOREIGN KEY(juttuid) REFERENCES juttu(juttuid)
);