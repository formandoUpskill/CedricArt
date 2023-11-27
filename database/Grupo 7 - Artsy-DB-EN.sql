SELECT @@sql_mode;


-- 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'


SET SQL_SAFE_UPDATES = 0;
delete from gene;
SET SQL_SAFE_UPDATES = 1;

select count(*) from gene;
select count(*) from artist;
select count(*) from artwork;


select * from gene;

select * from artist;
select * from artwork;

select * from gene where Id_gene = '4f99da92d8f65a0001000732';


SET SQL_SAFE_UPDATES = 1;


SET sql_mode='ANSI_QUOTES';

SELECT UUID();

insert into Gene (id_gene, name, description) values ('e4e02c6b-8d34-11ee-8122-d0395752c1b8', 'teste', 'desc teste');






CREATE TABLE GeneTeste
(
  id_Gene Binary(16)  NOT NULL ,
  name VARCHAR(150) NOT NULL,
  description VARCHAR(5000),
  PRIMARY KEY (id_Gene)
);




select * from gene where name='painting';

insert into Artwork (id_Artwork, title, created_at, updated_at, date, thumbnail, url, id_Gene) values 
('4eb2fc2d6e2a5c000100d12d','The Grotto of Neptune in Tivoli','2011-11-03T20:40:13','2021-05-17T19:51:40','1812','null','null')