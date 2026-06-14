-- Table: public.vehiculo

-- DROP TABLE IF EXISTS public.vehiculo;

CREATE TABLE IF NOT EXISTS public.vehiculo
(
    matricula character varying(10) COLLATE pg_catalog."default" NOT NULL,
    "idCliente" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    marca character varying(10)[] COLLATE pg_catalog."default" NOT NULL,
    modelo character varying(20)[] COLLATE pg_catalog."default" NOT NULL,
    baja character varying(1) COLLATE pg_catalog."default" NOT NULL DEFAULT 'N'::character varying,
    "fecBaja" date,
    "fecCreate" date NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT vehiculo_pkey PRIMARY KEY (matricula)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vehiculo
    OWNER to parking;