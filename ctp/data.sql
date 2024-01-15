drop table if exists choix cascade;
drop table if exists question cascade;

create table question (
       qno serial,
       libquest text,
       active boolean default false,
       constraint pk_question primary key(qno)
);

create table choix (
       cno serial,
       libchoix text,
       statut boolean,
       nbchoix int default 0,
       qno int,
       constraint pk_reponse primary key (cno),
       constraint fk_question foreign key (qno) references question(qno)
);

insert into question(libquest) values
       ('Date de la bataille de Marignan ?'),
       ('Quel est le président de la république actuel ?'),
       ('Qui a découvert la péniciline ?');

insert into choix(qno,libchoix,statut) values
       (1,'1313',false),(1,'1414',false),(1,'1515',true),(1,'1616',false);
insert into choix(qno,libchoix,statut) values
       (2,'Chirac',false),(2,'Sarkozy',false),(2,'Hollande',false),(2,'Macron',true);
insert into choix(qno,libchoix,statut) values
       (3,'Darwin',false),(3,'Pasteur',false),(3,'Fleming',true),(3,'Watson',false);
       
	
-- select * from question natural join choix;
-- select libquest, count(*) from question natural join choix group by libquest;
-- select * from question natural join choix where statut=true;


