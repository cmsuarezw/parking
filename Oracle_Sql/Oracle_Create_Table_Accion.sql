--------------------------------------------------------
-- Archivo creado  - lunes-mayo-18-2026   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for SEQUENCE ACCION
--------------------------------------------------------
CREATE SEQUENCE accion_seq
  START WITH 1
  INCREMENT BY 1
  MINVALUE 1
  NOMAXVALUE;
--------------------------------------------------------
--  DDL for Table ACCION
--------------------------------------------------------

  CREATE TABLE "PARKING"."ACCION" 
   (	"ID"  NUMBER DEFAULT "PARKING"."ACCION_SEQ"."NEXTVAL", 
	"CRUD" VARCHAR2(10 CHAR), 
	"ID_ACCION" NUMBER, 
	"MATRICULA" VARCHAR2(10 CHAR), 
	"FEC_ENTRADA" TIMESTAMP (6), 
	"FEC_SALIDA" TIMESTAMP (6), 
	"FEC_CREATE" DATE, 
	"DAT_CRE" DATE DEFAULT SYSDATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ACCION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PARKING"."ACCION_PK" ON "PARKING"."ACCION" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ACCION
--------------------------------------------------------

  ALTER TABLE "PARKING"."ACCION" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" MODIFY ("CRUD" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" MODIFY ("ID_ACCION" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" MODIFY ("MATRICULA" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" MODIFY ("FEC_ENTRADA" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" MODIFY ("FEC_CREATE" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" MODIFY ("DAT_CRE" NOT NULL ENABLE);
  ALTER TABLE "PARKING"."ACCION" ADD CONSTRAINT "ACCION_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
