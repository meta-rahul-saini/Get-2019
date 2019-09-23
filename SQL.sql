
drop database metaparking;
create database metaparking;

use metaparking;

CREATE  TABLE IF NOT EXISTS Employee (

  empId INT UNSIGNED NOT NULL AUTO_INCREMENT unique,

  fullName VARCHAR(100) NOT NULL ,

  gender VARCHAR(10) NOT NULL ,

  email VARCHAR(100) NOT NULL unique,
  
  password VARCHAR(100) NOT NULL ,
  
  contactNumber long NULL ,
  
  organization VARCHAR(100) NOT NULL,
  
  profile Varchar(200) DEFAULT "user.png",

  PRIMARY KEY (empId) 

);

select * from employee;

  
CREATE  TABLE IF NOT EXISTS Vehicle (

  vehicleId INT UNSIGNED NOT NULL AUTO_INCREMENT,

  vehicleName VARCHAR(100) NOT NULL,

  vehicleType VARCHAR(20) NOT NULL ,

  vehicleNumber VARCHAR(20) NOT NULL,
  
  empId INT UNSIGNED NOT NULL  ,
  
  identification TEXT ,

  PRIMARY KEY (vehicleId) ,
  
  FOREIGN KEY(empId) REFERENCES Employee(empId) ON DELETE CASCADE ON UPDATE CASCADE
  );

select * from vehicle;

select vehicleId from vehicle where vehicleNumber = 'RJ14MM1255';


CREATE  TABLE IF NOT EXISTS priceList (

  priceListId INT UNSIGNED AUTO_INCREMENT,

  vehicleType VARCHAR(30) NOT NULL,
  
  daily INT UNSIGNED NOT NULL,
  
  monthly INT UNSIGNED NOT NULL,
  
  yearly INT UNSIGNED NOT NULL,

  PRIMARY KEY (priceListId)
  
);

  INSERT INTO priceList VALUES(1, "cycle", 5,100,500);
  INSERT INTO priceList VALUES(2, "twoWheeler", 10,200,1000);
  INSERT INTO priceList VALUES(3, "fourWheeler", 20,500,3500);

select * from priceList;

select * from priceList where vehicleType = 'fourWheeler';


CREATE  TABLE IF NOT EXISTS PassDetail (

  passId INT UNSIGNED NOT NULL AUTO_INCREMENT,

  empId int UNSIGNED NOT NULL,
  
  vehicleId INT UNSIGNED NOT NULL  ,
  
  amount DOUBLE UNSIGNED NOT NULL,
  
  plan VARCHAR(20) NOT NULL, 
  
  generationTime DATETIME,
  
  PRIMARY KEY (passId) ,
  
  FOREIGN KEY(vehicleId) REFERENCES Vehicle(vehicleId) ON DELETE CASCADE ON UPDATE CASCADE
  );


CREATE  TABLE IF NOT EXISTS FriendsList (

  empId INT UNSIGNED NOT NULL,

  friendId INT UNSIGNED NOT NULL,
                     
  PRIMARY KEY (friendId, empId)
  
);

insert into FriendsList values(1, 2);
insert into FriendsList values(1, 3);

select * from employee;

select * from employee where empId in (select friendId from FriendsList where empId = 1);
