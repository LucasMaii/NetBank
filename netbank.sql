use netbank;

create table trade
(
  cardId      varchar(30) not null ,
  AmountTransferred double not null,
  payee varchar(10),
  cardIdOfPayee varchar(30) not null,
  remarks varchar(30) null,
  transferTime datetime null
);

create table bankAdmin
(
     AdminId      varchar(30) not null ,
     AdminPassword varchar(30) not null
);

create table account
(
    cardID varchar(30) not null,
    status varchar(10) default "正常",
    credit int default 100,
    balance double not null

);

create table depositor
(
  id  int  auto_increment  primary key,
  username    varchar(30) not null,
  password    varchar(20) not null,
  name        varchar(10) not null,
  tel         varchar(11) not null,
  cardid      varchar(30) not null,
  pid         varchar(30) not null,
  gender      varchar(6)  not null,
  address     varchar(45) null
);

insert into depositor(username,password,name,tel,cardid,pid,gender,address) values ("ShanShan","123123","成莉莉","13800123000","6217280742900642000","44078019900205333X","女","湖北武汉市");
insert into depositor(username,password,name,tel,cardid,pid,gender,address) values ("ZhangShan","123123","张珊","13800123001","6217280742900642001","44078019900205331X","女","海南省");
insert into depositor(username,password,name,tel,cardid,pid,gender,address) values ("LIliJun","123123","李丽君","13800123002","6217280742900642002","44078019900205335X","女","广东省江门市");
insert into depositor(username,password,name,tel,cardid,pid,gender,address) values ("Chuchu","123123","欧楚楚","13800123003","6217280742900642003","440780199002053335","女","广州市");


insert into bankAdmin(AdminId, adminpassword) values ("#SCOTT", "tiger");
insert into bankAdmin(AdminId, adminpassword) values ("#SYSTEM", "root");

insert into account(cardID,balance) values("6217280937373828274", 50400);
insert into account(cardID,balance) values("6217280937375294751", 50000);
insert into account(cardID,balance) values("6217280937373820000", 25000);
insert into account(cardID,balance) values("6217280937300009494", 18500);
insert into account(cardID,balance) values("6217280937111111111", 185000);
insert into account(cardID,balance) values("6217280937222222222", 1800);
insert into account(cardID,balance) values("6217280000000000000", 1000);
insert into account(cardID,balance) values("6217280742900642000", 1000);
insert into account(cardID,balance) values("6217280742900642001", 1000);
insert into account(cardID,balance) values("6217280742900642002", 1000);
insert into account(cardID,balance) values("6217280742900642003", 1000);