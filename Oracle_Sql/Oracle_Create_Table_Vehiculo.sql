--------------------------------------------------------
-- Archivo creado  - lunes-mayo-18-2026   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for SEQUENCE VEHICULO
--------------------------------------------------------

CREATE SEQUENCE vehiculo_seq
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  NOMAXVALUE;
--------------------------------------------------------
--  DDL for Table VEHICULO
--------------------------------------------------------

  CREATE TABLE "PARKING"."VEHICULO" 
   (	"ID" NUMBER DEFAULT "PARKING"."VEHICULO_SEQ"."NEXTVAL", 
	"CRUD" VARCHAR2(50 CHAR), 
	"ID_VEHICULO" NUMBER, 
	"MATRICULA" VARCHAR2(10 CHAR), 
	"ID_CLIENTE" VARCHAR2(100 CHAR), 
	"MARCA" VARCHAR2(10 CHAR), 
	"MODELO" VARCHAR2(20 CHAR), 
	"FEC_BAJA" TIMESTAMP (6), 
	"FEC_CREATE" TIMESTAMP (6), 
	"DAT_CRE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index VEHICULO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PARKING"."VEHICULO_PK" ON "PARKING"."VEHICULO" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table VEHICULO
--------------------------------------------------------

  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("CRUD" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("ID_VEHICULO" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("MATRICULA" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("ID_CLIENTE" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("MARCA" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("MODELO" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("FEC_CREATE" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" MODIFY ("DAT_CRE" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."VEHICULO" ADD CONSTRAINT "VEHICULO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
