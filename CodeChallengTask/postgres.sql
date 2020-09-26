--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2020-09-26 22:46:05

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 206 (class 1259 OID 16753)
-- Name: dependent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dependent (
    id integer NOT NULL,
    dob character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    health_id bigint
);


ALTER TABLE public.dependent OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16751)
-- Name: dependent_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dependent_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dependent_id_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 205
-- Name: dependent_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dependent_id_seq OWNED BY public.dependent.id;


--
-- TOC entry 208 (class 1259 OID 16764)
-- Name: enroll; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enroll (
    health_id bigint NOT NULL,
    activationstatus boolean NOT NULL,
    dob character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phonenumber character varying(255) NOT NULL
);


ALTER TABLE public.enroll OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16661)
-- Name: enroll_dependent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enroll_dependent (
    enroll_id bigint NOT NULL,
    dependents_id integer NOT NULL
);


ALTER TABLE public.enroll_dependent OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16762)
-- Name: enroll_health_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enroll_health_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enroll_health_id_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 207
-- Name: enroll_health_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.enroll_health_id_seq OWNED BY public.enroll.health_id;


--
-- TOC entry 200 (class 1259 OID 16693)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 201
-- Name: people_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.people_id_seq OWNED BY public.people.id;

--
-- TOC entry 2723 (class 2604 OID 16756)
-- Name: dependent id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dependent ALTER COLUMN id SET DEFAULT nextval('public.dependent_id_seq'::regclass);


--
-- TOC entry 2724 (class 2604 OID 16767)
-- Name: enroll health_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enroll ALTER COLUMN health_id SET DEFAULT nextval('public.enroll_health_id_seq'::regclass);


--
-- TOC entry 2740 (class 2606 OID 16761)
-- Name: dependent dependent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dependent
    ADD CONSTRAINT dependent_pkey PRIMARY KEY (id);


--
-- TOC entry 2726 (class 2606 OID 16665)
-- Name: enroll_dependent enroll_dependent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enroll_dependent
    ADD CONSTRAINT enroll_dependent_pkey PRIMARY KEY (enroll_id, dependents_id);


--
-- TOC entry 2742 (class 2606 OID 16772)
-- Name: enroll enroll_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enroll
    ADD CONSTRAINT enroll_pkey PRIMARY KEY (health_id);


--
-- TOC entry 2730 (class 2606 OID 16687)
-- Name: marks_details marks_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marks_details
    ADD CONSTRAINT marks_details_pkey PRIMARY KEY (test_id);


--
-- TOC entry 2728 (class 2606 OID 16667)
-- Name: enroll_dependent uk_s2xkyuqdxg4f10w3xe5k05p28; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enroll_dependent
    ADD CONSTRAINT uk_s2xkyuqdxg4f10w3xe5k05p28 UNIQUE (dependents_id);


--
-- TOC entry 2745 (class 2606 OID 16773)
-- Name: dependent fkeapq1pwvxguvtb5rh7yqy4uk3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dependent
    ADD CONSTRAINT fkeapq1pwvxguvtb5rh7yqy4uk3 FOREIGN KEY (health_id) REFERENCES public.enroll(health_id);



-- Completed on 2020-09-26 22:46:14

--
-- PostgreSQL database dump complete
--

