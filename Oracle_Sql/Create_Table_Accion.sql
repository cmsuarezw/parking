CREATE TABLE public.accion
(
    "idAccion" integer NOT NULL DEFAULT nextval('accion_seq'::regclass),
    matricula character varying(10) NOT NULL,
    fecha timestamp(3) without time zone NOT NULL,
    accion character varying(1) NOT NULL,
    baja character varying(1) NOT NULL DEFAULT 'N',
    "fecBaja" date,
    "fecCreate" date NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT accion_pk PRIMARY KEY ("idAccion"),
    CONSTRAINT accion_fx FOREIGN KEY (matricula)
        REFERENCES public."VEHICULO" (matricula) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.accion
    OWNER to parking;
--
--

-- SEQUENCE: public.accion_seq

-- DROP SEQUENCE IF EXISTS public.accion_seq;

CREATE SEQUENCE IF NOT EXISTS public.accion_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

nextval('accion_seq'::regclass)