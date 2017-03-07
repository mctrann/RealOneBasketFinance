insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value 
('PT002',150.00,241.16,0.2480,12057.80, 55875.44);

insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value  
('PA100',100.00,1.27,0.5755,63.73,425.12);

insert into Person (personCode,lastName,firstName,secID,personType) value 
('57IPQ9','Neal','Maryjane',null,null);

insert into Person (personCode,lastName,firstName,secID,personType) value
('FVD101','Le','Eric','sec098','J');

insert into Person (personCode,lastName,firstName,secID,personType) value
('REV455','Baker','David',null,null);

insert into Person (personCode,lastName,firstName,secID,personType) value
('931570','Scholl','Tommy',null,null);

insert into Person (personCode,lastName,firstName,secID,personType) value
('8E57R6','Field','Joseph','sec789','J');

insert into Person (personCode,lastName,firstName,secID,personType) value
('01WR93','Braswell','Verna','sec897','E');

insert into Address (personID,street,city,state,country,zipcode) value
(1,'709 Diamond Cove','Providence','RI',null,null);

insert into Address (personID,street,city,state,country,zipcode) value
(2,'1040 Van Dorn St','Lincoln','NE','United States','68512');

insert into Address (personID,street,city,state,country,zipcode) value
(3,'3635 Simpson St','Green Rock','IL','United States','61244');

insert into Address (personID,street,city,state,country,zipcode) value
(4,'4095 Marion Drive','Tampa','FL','United States','33607');

insert into Address (personID,street,city,state,country,zipcode) value
(5,'3420 Grand Ave', 'Baton Rouge', 'LA', 'United States', '70810');

insert into Address (personID,street,city,state,country,zipcode) value
(6,'2554 Whitman Court','Wallinford','CT','United States','06492');

insert into EmailAddress (emailAddress,personID) value ('MJ_Oneal@yahoo.com',1);
insert into EmailAddress (emailAddress,personID) value ('mj@yahoo.com',1);

insert into EmailAddress (emailAddress,personID) value ('EricLe@email.com',2);

insert into EmailAddress (emailAddress,personID) value ('SchollT@email.com',4);
insert into EmailAddress (emailAddress,personID) value ('st@gmail.com',4);
insert into EmailAddress (emailAddress,personID) value ('lol@yahoo.com',4);

insert into EmailAddress (emailAddress,personID) value ('jField3@email.com',5);

insert into Asset (assetCode,assetName,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('CMRO1592','Apple',null,3.82,0.083,0.0022,null,'AAPL',null,128.75);
insert into Asset (assetCode,assetName,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('O3I4JTVJ','CD',0.0260,null,null,null,null,null,null,null);
insert into Asset (assetCode,assetName,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('EIEIO12','Old McDonald Farm',null,15.00,0.2324,null,0.0012,null,100600.38,null);

insert into Asset (assetCode,assetName,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('GH59T5U3','Intel Corp',null,1.27,0.015,0.0123,null,'INTC',null,36.68);
insert into Asset (assetCode,assetName,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('CH1LL0','Netflix Inc',null,2.34,0.098,0.0023,null,'NFLX',null,139.20);

insert into PortAsset (assetID,portfolioID,portAssetVal) value (1,1,20);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (2,1,3000.25);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (3,1,0.50);

insert into PortAsset (assetID,portfolioID,portAssetVal) value (4,2,4);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (5,2,2);

insert into PortPerson (personID,portfolioID) value (1,1);
insert into PortPerson (personID,portfolioID) value (2,1);
insert into PortPerson (personID,portfolioID) value (3,1);

insert into PortPerson (personID,portfolioID) value (4,2);
insert into PortPerson (personID,portfolioID) value (5,2);
insert into PortPerson (personID,portfolioID) value (6,2);















