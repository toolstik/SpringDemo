DROP DATABASE IF EXISTS Products;

CREATE DATABASE Products;

USE Products;

CREATE TABLE ProductType
(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    , Name VARCHAR(255)
    , INDEX (Name)
);

CREATE TABLE Product
(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY 
    , Name VARCHAR(255)  
    , Price DECIMAL(10, 2)
    , Descr VARCHAR(1000)
    , Qty INT
    , CreateDate datetime DEFAULT CURRENT_TIMESTAMP
    , ProductTypeId INT
    , FOREIGN KEY (ProductTypeId) REFERENCES ProductType(Id)
);

CREATE TABLE Role
(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    , Name VARCHAR(255)
    , INDEX (Name)
);

CREATE TABLE User
(
    Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    , Name VARCHAR(255)  
    , Pwd VARCHAR(255)  
    , CreateDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    , Gender BIT(1)
    , INDEX (Name)
);

CREATE TABLE UserRoles
(
    UserId INT NOT NULL
    , RoleId INT NOT NULL
    , PRIMARY KEY (UserId, RoleId)
    , FOREIGN KEY (UserId) REFERENCES User(Id)
    , FOREIGN KEY (RoleId) REFERENCES Role(Id)
    , INDEX (UserId)
);

########## INSERT DATA ############

INSERT Role (Name)
VALUES 
  ('ADMIN')
 ,('USER')
;

INSERT User (Name, Pwd, Gender)
VALUES 
      ('admin', 'admin', 1)
    , ('user', 'user', 0)
    , ('user_admin', 'ua', 1)
;

INSERT UserRoles
SELECT u.Id, r.Id
FROM (
                  SELECT 'admin', 'ADMIN'
        UNION ALL SELECT 'user', 'USER'
        UNION ALL SELECT 'user_admin', 'ADMIN'
        UNION ALL SELECT 'user_admin', 'USER'
    ) names(user_name, role_name)
    LEFT JOIN User u on u.Name = names.user_name
    LEFT JOIN Role r on r.Name = names.role_name
;

INSERT ProductType (Name)
VALUES
  ('Meal')
 ,('Health')
 ,('Books')
;

INSERT Product(Name, Descr, Price, Qty, ProductTypeId)
SELECT items.name,
       items.descr,
       items.price,
       items.qty,
       pt.Id
FROM (
                  SELECT 'Bread',                   'Fresh tasty bread',            15.5, 100, 'Meal'
        UNION ALL SELECT 'Milk',                    'cow''s milk 2.5%',             36.7, 10,  'Meal'
        UNION ALL SELECT 'Strepsils',               'pills for cough',              52,   5,   'Health'
        UNION ALL SELECT 'Harry Potter, 7 volumes', 'Harry Potter full collection', 2999, 3,   'Books'
    ) items(name, descr, price, qty, type)
    LEFT JOIN ProductType pt on pt.Name = items.type
;