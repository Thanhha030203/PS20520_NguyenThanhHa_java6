use master
go

if exists(select * from sys.databases where name = 'J6Security')
	drop database J6Security

create database J6Security
go
use J6Security
go
create table Roles(
	Id varchar(10) not null,
	Name nvarchar(50) not null,
	primary key (Id)
)

create table Accounts(
	Username varchar(20) not null,
	Password nvarchar(100) not null,
	Fullname nvarchar(50) not null,
	Email nvarchar(50) not null,
	Photo nvarchar(50),
	primary key (Username)
)

create table Authorities(
	Id int identity(1,1),
	Username varchar(20) not null,
	Role_Id varchar(10) not null,
	primary key (Id),
	constraint fk_Authorities_Accounts
	foreign key (Username) references Accounts(Username),
	constraint fk_Authorities_Roles
	foreign key (Role_Id) references Roles(Id)
)

insert into Roles
values
('ADMIN','Administrators'),
('GUEST','Guests'),
('USER','Users')

go

insert into Accounts
VALUES('user1','123',N'Nguyễn Văn User1','user1@fpt.edu.vn',null),
	  ('user2','123',N'Ân User2','user2@fpt.edu.vn',null),
	  ('user3','123',N'Khang User3','user3@fpt.edu.vn',null),
	  ('user4','123',N'Tiến Thịnh User4','user4@fpt.edu.vn',null)

go

insert into Authorities
Values('user1','GUEST'),
	  ('user2','ADMIN'),
	  ('user3','USER')