CREATE TABLE Sys_Atta(
id NUMBER(16) primary key ,
fileType VARCHAR2(5) NOT NULL,
fileSize NUMBER(16) NOT NULL,
rawName VARCHAR2(512) NOT NULL,
filePath VARCHAR2(1024) NOT NULL,
extName VARCHAR2(12),
mime VARCHAR2(128),
notes VARCHAR2(500),
entityName VARCHAR2(50),
entityAttaField VARCHAR2(50),
entityId NUMBER(16),
userId NUMBER(16),
userName VARCHAR2(50),
onTime DATE);


CREATE TABLE Sys_DictItem(
id NUMBER(16) primary key ,
typeId NUMBER(16) NOT NULL,
text VARCHAR2(200) NOT NULL,
orders INTEGER,
notes VARCHAR2(200));

CREATE TABLE Sys_DictType(
id NUMBER(16) primary key ,
code VARCHAR2(50) NOT NULL,
text VARCHAR2(50) NOT NULL,
orders INTEGER,
notes VARCHAR2(200));

CREATE TABLE Sys_User(
id NUMBER(16) primary key ,
department VARCHAR2(50),
username VARCHAR2(50) NOT NULL,
password VARCHAR2(50) NOT NULL,
salt VARCHAR2(50),
admin CHAR(1) DEFAULT '0' NOT NULL,
enable CHAR(1) DEFAULT '1' NOT NULL,
idNumber VARCHAR2(18),
email VARCHAR2(50),
gender CHAR(1) DEFAULT '1',
dateOfBirth DATE,
lastLogin DATE,
attaIds VARCHAR2(500)
);


CREATE TABLE Sys_Role(
id NUMBER(16) primary key ,
name VARCHAR2(200),
description VARCHAR2(500),
isSystem VARCHAR2(3));

CREATE TABLE Sys_Log(
id NUMBER(16) primary key ,
onTime DATE NOT NULL,
action VARCHAR2(50) NOT NULL,
userId NUMBER(16) NOT NULL,
userName VARCHAR2(50) NOT NULL,
msg VARCHAR2(4000),
ip VARCHAR2(50) NOT NULL,
companyName VARCHAR2(50),
companyCode VARCHAR2(50),
departmentName VARCHAR2(200),
departmentId NUMBER(16));

create table SYS_PERMISSION
(
  ID          NUMBER(16) not null,
  CODE        VARCHAR2(100) not null,
  NAME        VARCHAR2(200) not null,
  MODULE      VARCHAR2(5) not null,
  DESCRIPTION VARCHAR2(500),
  ORDERS      NUMBER(8)
);

CREATE TABLE mmsg_push_batch(
id NUMBER(16) primary key ,
title VARCHAR2(50),
type VARCHAR2(10),
groups VARCHAR2(4000),
msgTitle VARCHAR2(2000),
msgContent VARCHAR2(2000),
msgTime VARCHAR2(2000),
msgLocation VARCHAR2(2000),
msgAddress VARCHAR2(2000),
msgRemark VARCHAR2(2000),
msgField1 VARCHAR2(2000),
msgField2 VARCHAR2(2000),
msgField3 VARCHAR2(2000),
msgField4 VARCHAR2(2000),
msgField5 VARCHAR2(2000),
msgField6 VARCHAR2(2000),
status NUMBER,
control NUMBER DEFAULT '0',
priority NUMBER,
count NUMBER DEFAULT '0',
describe VARCHAR2(2000),
inputName VARCHAR2(50),
onTime DATE);

CREATE TABLE mmsg_push_detail(
id NUMBER(16) primary key ,
pid NUMBER(16),
content VARCHAR2(2000),
state NUMBER(8) DEFAULT '0');

CREATE TABLE mmsg_template_type(
id NUMBER(16) primary key ,
text VARCHAR2(50) NOT NULL UNIQUE,
path VARCHAR2(200),
txid VARCHAR2(200));

CREATE TABLE mmsg_employee(
id NUMBER(16) primary key ,
certNo VARCHAR2(18) NOT NULL UNIQUE,
name VARCHAR2(30),
groups VARCHAR2(50));

create sequence seq_atta;
create sequence seq_dicitem;
create sequence seq_dictype;
create sequence seq_perm;
create sequence seq_role;
create sequence seq_syslog;
create sequence seq_user;
create sequence seq_pbash;
create sequence seq_pdetail;