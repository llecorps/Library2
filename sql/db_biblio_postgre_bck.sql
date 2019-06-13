--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.7

-- Started on 2019-02-20 19:34:21

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13920)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3873 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 2 (class 3079 OID 16543)
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- TOC entry 3874 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 204 (class 1259 OID 16513)
-- Name: auteur; Type: TABLE; Schema: public; Owner: admbiblio
--

CREATE TABLE public.auteur (
    id integer NOT NULL,
    prenom character varying(20) NOT NULL,
    nom character varying(20) NOT NULL,
    genre character varying(20) NOT NULL
);


ALTER TABLE public.auteur OWNER TO admbiblio;

--
-- TOC entry 203 (class 1259 OID 16511)
-- Name: auteur_id_seq; Type: SEQUENCE; Schema: public; Owner: admbiblio
--

CREATE SEQUENCE public.auteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.auteur_id_seq OWNER TO admbiblio;

--
-- TOC entry 3875 (class 0 OID 0)
-- Dependencies: 203
-- Name: auteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admbiblio
--

ALTER SEQUENCE public.auteur_id_seq OWNED BY public.auteur.id;


--
-- TOC entry 202 (class 1259 OID 16505)
-- Name: livre; Type: TABLE; Schema: public; Owner: admbiblio
--

CREATE TABLE public.livre (
    id integer NOT NULL,
    titre character varying(45) NOT NULL,
    auteur_id integer NOT NULL,
    exemplaire integer NOT NULL,
    description character varying(200),
    genre character varying NOT NULL
);


ALTER TABLE public.livre OWNER TO admbiblio;

--
-- TOC entry 201 (class 1259 OID 16503)
-- Name: livre_id_seq; Type: SEQUENCE; Schema: public; Owner: admbiblio
--

CREATE SEQUENCE public.livre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.livre_id_seq OWNER TO admbiblio;

--
-- TOC entry 3876 (class 0 OID 0)
-- Dependencies: 201
-- Name: livre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admbiblio
--

ALTER SEQUENCE public.livre_id_seq OWNED BY public.livre.id;


--
-- TOC entry 200 (class 1259 OID 16497)
-- Name: location; Type: TABLE; Schema: public; Owner: admbiblio
--

CREATE TABLE public.location (
    id integer NOT NULL,
    utilisateur_id integer NOT NULL,
    livre_id integer NOT NULL,
    expiredate date NOT NULL,
    prolongation boolean NOT NULL
);


ALTER TABLE public.location OWNER TO admbiblio;

--
-- TOC entry 199 (class 1259 OID 16495)
-- Name: location_id_seq; Type: SEQUENCE; Schema: public; Owner: admbiblio
--

CREATE SEQUENCE public.location_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.location_id_seq OWNER TO admbiblio;

--
-- TOC entry 3877 (class 0 OID 0)
-- Dependencies: 199
-- Name: location_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admbiblio
--

ALTER SEQUENCE public.location_id_seq OWNED BY public.location.id;


--
-- TOC entry 198 (class 1259 OID 16489)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: admbiblio
--

CREATE TABLE public.utilisateur (
    id integer NOT NULL,
    login character varying(20) NOT NULL,
    email character varying(60) NOT NULL,
    password character varying(100) NOT NULL,
    adress character varying(100) NOT NULL,
    phone integer
);


ALTER TABLE public.utilisateur OWNER TO admbiblio;

--
-- TOC entry 197 (class 1259 OID 16487)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: admbiblio
--

CREATE SEQUENCE public.utilisateur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO admbiblio;

--
-- TOC entry 3878 (class 0 OID 0)
-- Dependencies: 197
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: admbiblio
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;


--
-- TOC entry 3724 (class 2604 OID 16516)
-- Name: auteur id; Type: DEFAULT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.auteur ALTER COLUMN id SET DEFAULT nextval('public.auteur_id_seq'::regclass);


--
-- TOC entry 3723 (class 2604 OID 16508)
-- Name: livre id; Type: DEFAULT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.livre ALTER COLUMN id SET DEFAULT nextval('public.livre_id_seq'::regclass);


--
-- TOC entry 3722 (class 2604 OID 16500)
-- Name: location id; Type: DEFAULT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.location ALTER COLUMN id SET DEFAULT nextval('public.location_id_seq'::regclass);


--
-- TOC entry 3721 (class 2604 OID 16492)
-- Name: utilisateur id; Type: DEFAULT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 3864 (class 0 OID 16513)
-- Dependencies: 204
-- Data for Name: auteur; Type: TABLE DATA; Schema: public; Owner: admbiblio
--

COPY public.auteur (id, prenom, nom, genre) FROM stdin;
1	jean-paul	Sartre	philosophie
2	honoré	Balzac	littérature
3	nicolas	Machiavel	politique
4	orhan	Pamuk	roman
5	riad	Sattouf	comic
\.


--
-- TOC entry 3862 (class 0 OID 16505)
-- Dependencies: 202
-- Data for Name: livre; Type: TABLE DATA; Schema: public; Owner: admbiblio
--

COPY public.livre (id, titre, auteur_id, exemplaire, description, genre) FROM stdin;
1	L'arabe du futur	5	2	Une jeunesse au Moyen-Orient (1978-1984)	comic
2	Le musée de l'innocence	4	1	Un grand roman nostalgique sur la passion	roman
3	Le prince	3	1	Traité politique écrit au début du XVIe siécle	politique
4	La nausée	1	1	Roman philosophique publié en 1938	philosophie
5	Le Père Goriot	2	2	Oeuvre de la comédie humaine	littérature
\.


--
-- TOC entry 3860 (class 0 OID 16497)
-- Dependencies: 200
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: admbiblio
--

COPY public.location (id, utilisateur_id, livre_id, expiredate, prolongation) FROM stdin;
1	1	1	2019-01-31	f
2	2	2	2019-01-05	t
14	1	3	2019-03-20	f
\.


--
-- TOC entry 3858 (class 0 OID 16489)
-- Dependencies: 198
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: admbiblio
--

COPY public.utilisateur (id, login, email, password, adress, phone) FROM stdin;
1	mike	mike@mail	$2a$06$IkCItz/PID/Ae7xYNoEh4.twSXXoOFg.5vUfl8vgTFWuy.1zjpDtG	24 rue de genève - Lyon	666887755
2	rachel	rachel@mail	$2a$06$TirkmR1Hx4WzYf0KDvvlLOXIpIfpjxGp8h.dpUfuH1gvr6KW0Ea.i	10 rue de genève - Annemasse	666887744
4	joe	joe@mail	$2a$06$uwzHEpoSipgwZVSGgl3X5ur6ciIcpEF/8OZx6kVA4UWtQ0Gfwzxge	10 rue de genève - Annemasse	666887744
\.


--
-- TOC entry 3879 (class 0 OID 0)
-- Dependencies: 203
-- Name: auteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admbiblio
--

SELECT pg_catalog.setval('public.auteur_id_seq', 5, true);


--
-- TOC entry 3880 (class 0 OID 0)
-- Dependencies: 201
-- Name: livre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admbiblio
--

SELECT pg_catalog.setval('public.livre_id_seq', 5, true);


--
-- TOC entry 3881 (class 0 OID 0)
-- Dependencies: 199
-- Name: location_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admbiblio
--

SELECT pg_catalog.setval('public.location_id_seq', 14, true);


--
-- TOC entry 3882 (class 0 OID 0)
-- Dependencies: 197
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: admbiblio
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 4, true);


--
-- TOC entry 3732 (class 2606 OID 16518)
-- Name: auteur auteur_pk; Type: CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.auteur
    ADD CONSTRAINT auteur_pk PRIMARY KEY (id);


--
-- TOC entry 3730 (class 2606 OID 16510)
-- Name: livre livre_pk; Type: CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT livre_pk PRIMARY KEY (id);


--
-- TOC entry 3728 (class 2606 OID 16502)
-- Name: location location_pk; Type: CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pk PRIMARY KEY (id);


--
-- TOC entry 3726 (class 2606 OID 16494)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id);


--
-- TOC entry 3735 (class 2606 OID 16538)
-- Name: livre fk_auteur_id; Type: FK CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.livre
    ADD CONSTRAINT fk_auteur_id FOREIGN KEY (auteur_id) REFERENCES public.auteur(id);


--
-- TOC entry 3734 (class 2606 OID 16524)
-- Name: location fk_livre_id; Type: FK CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fk_livre_id FOREIGN KEY (livre_id) REFERENCES public.livre(id);


--
-- TOC entry 3733 (class 2606 OID 16519)
-- Name: location fk_utilisateur_id; Type: FK CONSTRAINT; Schema: public; Owner: admbiblio
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT fk_utilisateur_id FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3872 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: admbiblio
--

REVOKE ALL ON SCHEMA public FROM rdsadmin;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO admbiblio;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-02-20 19:34:47

--
-- PostgreSQL database dump complete
--

