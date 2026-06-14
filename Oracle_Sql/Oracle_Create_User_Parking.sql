ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER parking IDENTIFIED BY pass;
GRANT ALL privileges to parking;

-- Cuando estemos conectados como el usuario SYSTEM, en el SQL ponemos lo siguiente:
alter session set "_ORACLE_SCRIPT"=true;
 
create user tu_usuario identified by tu_password;
 
grant all privileges to tu_usuario;

Por ejemplo,
PgSQL
alter session set "_ORACLE_SCRIPT"=true;
 
create user DDR identified by 123456;
 
grant all privileges to DDR;