--------------------------------------------------------
-- Archivo creado  - lunes-mayo-18-2026   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for SEQUENCE CLIENTE
--------------------------------------------------------
--
--CREATE SEQUENCE cliente_seq
--  START WITH 1      -- Número inicial
--  INCREMENT BY 1    -- Cantidad que se sumará en cada paso
--  MINVALUE 1        -- Valor mínimo
--  NOMAXVALUE;       -- Valor máximo (o NOMAXVALUE para infinito)
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "PARKING"."CLIENTE" 
   (--	"ID" NUMBER DEFAULT "PARKING"."CLIENTE_SEQ"."NEXTVAL", 
	"CRUD" VARCHAR2(50 CHAR), 
	"IDCLIENTE" VARCHAR2(20 CHAR), 
	"DNI" VARCHAR2(10 CHAR),
	"NOMBRE" VARCHAR2(50 CHAR), 
	"APELLIDOS" VARCHAR2(100 CHAR), 
	"EMAIL" VARCHAR2(100 CHAR), 
	"TELEFONO" VARCHAR2(10 CHAR), 
	"CIUDAD" VARCHAR2(5 CHAR), 
	--"FEC_BAJA" TIMESTAMP (6), 
	--"FEC_CREATE" TIMESTAMP (6),
	--"FEC_UPDATE" TIMESTAMP (6),
	--"DAT_CRE" DATE DEFAULT SYSDATE,
	--"DAT_UPD" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

--   COMMENT ON COLUMN "PARKING"."CLIENTE"."ID" IS 'Identificador interno secuencial';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."CRUD" IS 'Accion realizada';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."IDCLIENTE" IS 'Identificador de cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."DNI" IS 'DNI o NIE de cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."NOMBRE" IS 'Nombre de cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."APELLIDOS" IS 'Apellidos de cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."EMAIL" IS 'Email de cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."TELEFONO" IS 'Telefono de cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."CIUDAD" IS 'Ciudad de cliente en formato Aeropuerto. Ej. LPA, MAD, etc';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."FEC_BAJA" IS 'Fecha y Hora de baja del cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."FEC_CREATE" IS 'Fecha de creación del cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."FEC_CREATE" IS 'Fecha de actualización del cliente';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."DAT_CRE" IS 'Fecha de Auditoría';
--   COMMENT ON COLUMN "PARKING"."CLIENTE"."DAT_UPD" IS 'Fecha de Auditoría';
--------------------------------------------------------
--  DDL for Index CLIENTE_PK
--------------------------------------------------------

--  CREATE UNIQUE INDEX "PARKING"."CLIENTE_PK" ON "PARKING"."CLIENTE" ("ID") 
--  PCTFREE 10 INITRANS 2 MAXTRANS 255 
--  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("ID" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("CRUD" NOT NULL ENABLE);
--  -- ALTER TABLE "PARKING"."CLIENTE" MODIFY ("IDCLIENTE" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("DNI" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("NOMBRE" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("APELLIDOS" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("EMAIL" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("FEC_CREATE" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" MODIFY ("DAT_CRE" NOT NULL ENABLE);
--  ALTER TABLE "PARKING"."CLIENTE" ADD CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID")
--  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
--  TABLESPACE "USERS"  ENABLE;
