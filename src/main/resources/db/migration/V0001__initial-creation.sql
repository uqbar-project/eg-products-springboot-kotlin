-- Table: public.fabricante
CREATE TABLE IF NOT EXISTS public.fabricante
(
    id bigint NOT NULL,
    nombre character varying(150) COLLATE pg_catalog."default",
    CONSTRAINT fabricante_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.fabricante
    OWNER to postgres;

-- Table: public.producto

CREATE TABLE IF NOT EXISTS public.producto
(
    id bigint NOT NULL,
    fecha_ingreso date,
    nombre character varying(150) COLLATE pg_catalog."default",
    CONSTRAINT producto_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.producto
    OWNER to postgres;

-- Table: public.producto_fabricantes

CREATE TABLE IF NOT EXISTS public.producto_fabricantes
(
    producto_id bigint NOT NULL,
    fabricantes_id bigint NOT NULL,
    CONSTRAINT producto_fabricantes_pkey PRIMARY KEY (producto_id, fabricantes_id),
    CONSTRAINT fk8at7803m4v5kfnme7fiqj037y FOREIGN KEY (producto_id)
    REFERENCES public.producto (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkhypiunlgnw6cq9hx7n5crgu9t FOREIGN KEY (fabricantes_id)
    REFERENCES public.fabricante (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.producto_fabricantes
    OWNER to postgres;

-- SEQUENCE: public.fabricante_seq
CREATE SEQUENCE IF NOT EXISTS public.fabricante_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.fabricante_seq
    OWNER TO postgres;

-- SEQUENCE: public.producto_seq

CREATE SEQUENCE IF NOT EXISTS public.producto_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.producto_seq
    OWNER TO postgres;