
 DROP Database if exists artsydb;
 
 create database artsydb;

use  artsydb;


CREATE TABLE User
(
  id_User INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(150),
  Email VARCHAR(100) NOT NULL,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_User),
  UNIQUE (Email),
  UNIQUE (username)
);

CREATE TABLE Country
(
  country_code INT NOT NULL AUTO_INCREMENT,
  nationality VARCHAR(100) NOT NULL,
  PRIMARY KEY (country_code)
);

CREATE TABLE Gene
(
  id_Gene CHAR(32)  NOT NULL ,
  name VARCHAR(150) NOT NULL,
  description VARCHAR(5000),
  PRIMARY KEY (id_Gene)
);

CREATE TABLE Gallerist
(
  id_Gallerist INT NOT NULL AUTO_INCREMENT,
  start_at DATE NOT NULL,
  end_at DATE,
  PRIMARY KEY (id_Gallerist),
  FOREIGN KEY (id_Gallerist) REFERENCES User(id_User)
);

CREATE TABLE Coordinator
(
  id_Coordinator INT NOT NULL AUTO_INCREMENT,
  start_at DATE NOT NULL,
  end_at DATE,
  PRIMARY KEY (id_Coordinator),
  FOREIGN KEY (id_Coordinator) REFERENCES User(id_User)
);

CREATE TABLE Partner
(
  id_Partner CHAR(32) NOT NULL,
  region VARCHAR(250),
  url VARCHAR(250),
  name VARCHAR(250) NOT NULL,
  website VARCHAR(250),
  id_Gallerist INT NOT NULL,
  id_Coordinator INT NOT NULL,
  PRIMARY KEY (id_Partner),
  FOREIGN KEY (id_Gallerist) REFERENCES Gallerist(id_Gallerist),
  FOREIGN KEY (id_Coordinator) REFERENCES Coordinator(id_Coordinator)
);

CREATE TABLE Artist
(
  id_Artist CHAR(32) NOT NULL,
  location VARCHAR(250),
  hometown VARCHAR(250),
  name VARCHAR(150),
  biography VARCHAR(5000),
  slug VARCHAR(150),
  birthyear VARCHAR(4) NOT NULL,
  deathyear VARCHAR(4),
  thumbnail VARCHAR(250),
  url VARCHAR(250),
  nationality VARCHAR(250),
  country_code INT,
  PRIMARY KEY (id_Artist),
  FOREIGN KEY (country_code) REFERENCES Country(country_code)
);

CREATE TABLE Exhibition
(
  id_Exhibition CHAR(32) NOT NULL,
  end_at DATE,
  start_at DATE NOT NULL,
  image VARCHAR(250),
  description VARCHAR(5000),
  name VARCHAR(150) NOT NULL,
  url VARCHAR(250),
  id_Partner CHAR(32) NOT NULL,
  PRIMARY KEY (id_Exhibition),
  FOREIGN KEY (id_Partner) REFERENCES Partner(id_Partner)
);

CREATE TABLE Artwork
(
  id_Artwork CHAR(32) NOT NULL,
  title VARCHAR(100) NOT NULL,
  created_at datetime,
  updated_at datetime,
  date varchar(15),
  thumbnail VARCHAR(250) ,
  url VARCHAR(250),
  id_Exhibition CHAR(32),
  id_Gene CHAR(32)  NOT NULL,
  PRIMARY KEY (id_Artwork),
  FOREIGN KEY (id_Exhibition) REFERENCES Exhibition(id_Exhibition),
  FOREIGN KEY (id_Gene) REFERENCES Gene(id_Gene)
);

CREATE TABLE Created_By
(
  id_Artist CHAR(32) NOT NULL,
  id_Artwork CHAR(32) NOT NULL,
  PRIMARY KEY (id_Artist, id_Artwork),
  FOREIGN KEY (id_Artist) REFERENCES Artist(id_Artist),
  FOREIGN KEY (id_Artwork) REFERENCES Artwork(id_Artwork)
);


select * from User;
INSERT INTO User (Email,username,password) values ('gallerist@cedricArt.pt', 'gallerist', 'password' );
INSERT INTO User (Email,username,password) values ('coordinator@cedricArt.pt', 'coordinator', 'password' );

insert into Gallerist (id_Gallerist,start_at) values (1, '2023-11-20');
insert into Coordinator (id_Coordinator,start_at) values (2,'2023-11-21');





