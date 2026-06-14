--
-- Script inicio Oracle dockerizado
-- 12/06/2026. CMSR
--

--
-- Crear Usuario Aplicacion
--
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER parking IDENTIFIED BY "pass";
GRANT ALL privileges to parking;
--