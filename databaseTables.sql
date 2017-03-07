#version 1.0 of DataTables 
drop table if exists Person;
drop table if exists Asset;
drop table if exists Address;
drop table if exists Portfolio;
drop table if exists PortAsset;
drop table if exists PortPerson;
drop table if exists EmailAddress;

create table Person ( 
personID Integer auto_increment not null primary key unique,
personCode varchar(20), 
lastName varchar(255) not null, 
firstName varchar(255)not null,
secID varchar(20), #?? 
personType varchar(1) #?? 
)engine=InnoDB,collate=latin1_general_cs; 

create table Asset( 
assetID integer not null primary key auto_increment unique, 
assetCode varchar(20) not null,
assetName varchar(50) not null,
apr double,
quartDiv double,
BRR double,
beta double,
omega double,
stockSymbol varchar(50),
constraint uniqueValues unique (assetCode,assetName,stockSymbol),
totalValue double,
sharePrice double
)engine=InnoDB,collate=latin1_general_cs; 
 
create table Address ( 
addressID integer not null primary key auto_increment unique, 
personID Integer not null, 
street varchar(255), #null allowed? 
city varchar(100) , 
state varchar(100), 
country varchar(100), 
zipcode int, 
foreign key (personID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 

create table Portfolio ( 
portfolioID Integer not null primary key auto_increment unique,
portCode varchar(20) not null,
totalFee double not null,
commissions double not null,
weightedRisk double not null,
totalReturnVal double not null,
totalPortVal double not null
)engine=InnoDB,collate=latin1_general_cs; 

create table PortAsset (
portAssetID Integer not null primary key auto_increment unique,
assetID integer not null,
portfolioID integer not null,
portAssetVal double not null, #for share price or percent investment or totalval of deposit
foreign key (assetID) references Asset(assetID),
foreign key (portfolioID) references Portfolio(portfolioID)
) engine=InnoDB,collate=latin1_general_cs; 

create table PortPerson (
portPersonID integer not null primary key auto_increment unique,
personID integer not null,
portfolioID integer not null,
foreign key (personID) references Person(personID),
foreign key (portfolioID) references Portfolio(portfolioID)
)engine=InnoDB,collate=latin1_general_cs; 
 
create table EmailAddress( 
emailAddressID integer not null primary key auto_increment unique,
emailAddress varchar(100) not null unique, 
personID integer not null,
foreign key (personID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 
 

 
 