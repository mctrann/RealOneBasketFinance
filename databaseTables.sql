#version 1.0 of DataTables 
create table Portfolio ( 
portfolioID varchar(20) not null primary key, #what else? 
portVal double not null #manyto Many need portfolio to have person and ass id? 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table Person ( 
personID varchar(20) not null primary key, 
portfolioID varchar(20) not null,  
lastName varchar(255) not null, 
firstName varchar(255)not null, 
secID varchar(20), #?? 
personType varchar(1), #?? 
foreign key (portofolioID) references Portolio (portfolioID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table address ( 
addressID int not null primary key auto_increment, 
personID varchar(20) not null, 
street varchar(255), #null allowed? 
city varchar(100) , 
state varchar(100), 
country varchar(100), 
zipcode int, 
foreign key (personID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table emailAddress( 
emailAddressID int not null primary key auto_increment, 
personID varchar(20) not null, 
email varchar(100), 
foreign key (perosnID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table asset( 
assetID varchar(20) not null primary key, 
PortfolioID varchar (50) not null, 
assName varchar(50) not null, 
foreign key (portofolioID) references Portolio (portfolioID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table deposit( 
depositID int not null primary key auto_increment, 
assetID varchar (50) not null, 
apr double not null, 
foreign key (assetID) references asset (assetID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table stocks( 
stocksID int not null primary key auto_increment, 
assetID varchar (50) not null, 
sharePrice double not null, 
symbol varchar(20) not null, 
beta double not null, 
baseRate double not null, 
quartDiv double not null, 
foreign key (assetID) references asset (assetID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table privateInvest( 
privateIvestID int not null primary key auto_increment, 
assetID varchar (50) not null, 
propValue double not null, 
omega double not null, 
baseRate double not null, 
quartDiv double not null, 
foreign key (assetID) references asset (assetID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
 
SQL database

file has the created tables...this is the 'first draft'
mctrann
authored3/6/2017 @ 11:32 AM
commit:774afd
parent:b04d2a
1 added
2 deleted
Name
Full Path
ass4.sql
data
/Portfolio.dat
data
/output1.txt
File History: ass4.sql
Diff View
File View
SQL database
6 minutes ago by mctrann
774afd
ADDED ass4.sql
End of History
@@ -0,0 +1,70 @@
#version 1.0 of DataTables 
create table Portfolio ( 
portfolioID varchar(20) not null primary key, #what else? 
portVal double not null #manyto Many need portfolio to have person and ass id? 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table Person ( 
personID varchar(20) not null primary key, 
portfolioID varchar(20) not null,  
lastName varchar(255) not null, 
firstName varchar(255)not null, 
secID varchar(20), #?? 
personType varchar(1), #?? 
foreign key (portofolioID) references Portolio (portfolioID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table address ( 
addressID int not null primary key auto_increment, 
personID varchar(20) not null, 
street varchar(255), #null allowed? 
city varchar(100) , 
state varchar(100), 
country varchar(100), 
zipcode int, 
foreign key (personID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table emailAddress( 
emailAddressID int not null primary key auto_increment, 
personID varchar(20) not null, 
email varchar(100), 
foreign key (perosnID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table asset( 
assetID varchar(20) not null primary key, 
PortfolioID varchar (50) not null, 
assName varchar(50) not null, 
foreign key (portofolioID) references Portolio (portfolioID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table deposit( 
depositID int not null primary key auto_increment, 
assetID varchar (50) not null, 
apr double not null, 
foreign key (assetID) references asset (assetID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table stocks( 
stocksID int not null primary key auto_increment, 
assetID varchar (50) not null, 
sharePrice double not null, 
symbol varchar(20) not null, 
beta double not null, 
baseRate double not null, 
quartDiv double not null, 
foreign key (assetID) references asset (assetID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
create table privateInvest( 
privateIvestID int not null primary key auto_increment, 
assetID varchar (50) not null, 
propValue double not null, 
omega double not null, 
baseRate double not null, 
quartDiv double not null, 
foreign key (assetID) references asset (assetID) 
)engine=InnoDB,collate=latin1_general_cs; 
 
 