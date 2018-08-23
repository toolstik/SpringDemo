DROP DATABASE IF EXISTS Products;

CREATE DATABASE Products;

USE Products;

CREATE TABLE ProductType
(
    Id INT PRIMARY KEY
    , Name VARCHAR(255)
);

CREATE TABLE Product
(
    Id INT PRIMARY KEY
    , Name VARCHAR(255)  
    , Price DECIMAL(10, 2)
    , Descr VARCHAR(1000)
    , Qty INT
    , CreateDate DATETIME
    , ProductTypeId INT
    , FOREIGN KEY (ProductTypeId) REFERENCES ProductType(Id)
);

CREATE TABLE Roles
(
    Id INT PRIMARY KEY
    , Name VARCHAR(255)
);

CREATE TABLE User
(
    Id INT PRIMARY KEY
    , Name VARCHAR(255)  
    , Pwd VARCHAR(255)  
    , CreateDate DATETIME
    , Gender BIT(1)
);

CREATE TABLE UserRoles
(
    UserId INT
    , RoleId INT
    , PRIMARY KEY (UserId, RoleId)
    , FOREIGN KEY (UserId) REFERENCES User(Id)
    , FOREIGN KEY (RoleId) REFERENCES Roles(Id)
);      