--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id uuid NOT NULL,
    apellidos character varying(100) NOT NULL,
    nombres character varying(100) NOT NULL,
    dni character varying(9) NOT NULL,
    correo character varying(100) NOT NULL,
    telefono character varying(9) NOT NULL,
    activo boolean DEFAULT true,
    fecha_creacion timestamp without time zone NOT NULL,
    fecha_actualizacion timestamp without time zone NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- Name: productos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productos (
    id uuid NOT NULL,
    codigo character varying(50) NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text,
    precio numeric(10,2) NOT NULL,
    stock integer NOT NULL,
    categoria character varying(50),
    activo boolean DEFAULT true,
    fecha_creacion timestamp without time zone NOT NULL,
    fecha_actualizacion timestamp without time zone NOT NULL
);


ALTER TABLE public.productos OWNER TO postgres;

--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (id, apellidos, nombres, dni, correo, telefono, activo, fecha_creacion, fecha_actualizacion) FROM stdin;
550e8400-e29b-41d4-a716-666666000001	García	Juan	12345678	juan.garcia@example.com	612345678	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000002	Pérez	María	23456789	maria.perez@example.com	623456789	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000003	López	Carlos	34567890	carlos.lopez@example.com	634567890	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000004	Martínez	Ana	45678901	ana.martinez@example.com	645678901	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000005	Hernández	Luis	56789012	luis.hernandez@example.com	656789012	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000006	González	Laura	67890123	laura.gonzalez@example.com	667890123	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000007	Rodríguez	Pedro	78901234	pedro.rodriguez@example.com	678901234	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000008	Fernández	Sofía	89012345	sofia.fernandez@example.com	689012345	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000009	Ramírez	Javier	90123456	javier.ramirez@example.com	690123456	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
550e8400-e29b-41d4-a716-666666000010	Toledo	Marta	93116480	marta.toledo@example.com	696134587	t	2025-03-24 22:01:46.191058	2025-03-24 22:01:46.191058
\.


--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	<< Flyway Baseline >>	BASELINE	<< Flyway Baseline >>	\N	postgres	2025-03-24 19:38:31.898776	0	t
\.


--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productos (id, codigo, nombre, descripcion, precio, stock, categoria, activo, fecha_creacion, fecha_actualizacion) FROM stdin;
550e8400-e29b-41d4-a716-446655440001	PROD-001	Laptop Gamer	Laptop de alto rendimiento con GPU dedicada.	4599.99	10	Tecnología	t	2025-03-24 19:17:13.341446	2025-03-24 19:17:13.341446
550e8400-e29b-41d4-a716-446655440002	PROD-002	Smartphone 5G	Teléfono móvil con pantalla OLED y conectividad 5G.	1299.50	25	Electrónica	t	2025-03-24 19:17:13.341446	2025-03-24 19:17:13.341446
550e8400-e29b-41d4-a716-446655440003	PROD-003	Silla Ergonómica	Silla de oficina con soporte lumbar y ajuste de altura.	299.99	50	Muebles	t	2025-03-24 19:17:13.341446	2025-03-24 19:17:13.341446
550e8400-e29b-41d4-a716-446655440004	PROD-004	Monitor 4K	Monitor de 32 pulgadas con resolución 4K UHD.	749.00	15	Tecnología	t	2025-03-24 19:17:13.341446	2025-03-24 19:17:13.341446
550e8400-e29b-41d4-a716-446655440005	PROD-005	Auriculares Inalámbricos	Auriculares Bluetooth con cancelación de ruido.	199.99	40	Accesorios	t	2025-03-24 19:17:13.341446	2025-03-24 19:17:13.341446
\.


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: productos productos_codigo_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_codigo_key UNIQUE (codigo);


--
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: idx_productos_categoria; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_productos_categoria ON public.productos USING btree (categoria);


--
-- Name: idx_productos_codigo; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_productos_codigo ON public.productos USING btree (codigo);


--
-- Name: idx_productos_nombre; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idx_productos_nombre ON public.productos USING btree (nombre);


--
-- PostgreSQL database dump complete
--

