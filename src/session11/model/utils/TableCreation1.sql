-- this is the process of starting a database that this program can interact with
--
--     Enter Username: sys as sysdba
--     Enter Password:
--
--     ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--     CREATE USER INTERNALLOGIN IDENTIFIED BY INTERNALLOGIN1234;
--     GRANT DBA TO INTERNALLOGIN;
--     QUIT
--
--     TERMINAL: SQL-PLUS
--
--     Enter Username: INTERNALLOGIN
--     Enter Password: INTERNALLOGIN1234
--
-- Connected to:
-- Oracle Database 21c Express Edition Release 21.0.0.0.0 - Production
-- Version 21.3.0.0.0
--


-- CREATE TABLE SIMCARD (
-- ID NUMBER(10) PRIMARY KEY,
-- NAME NVARCHAR2(15) NOT NULL,
-- PHONE_NUMBER NUMBER(10) NOT NULL,
-- PLAN NVARCHAR2(10) NOT NULL,
-- COMPANY NVARCHAR2(10) NOT NULL,
-- PURCHASE_DATE DATE NOT NULL
-- );
--
-- CREATE SEQUENCE SIMCARD_SEQ START WITH 1 INCREMENT BY 1;
-- INSERT INTO SIMCARD VALUES (3, 'JOHN', 4441236231, 'MANUAL', 'MCI', TO_DATE('14/10/2024', 'DD/MM/YYYY'));