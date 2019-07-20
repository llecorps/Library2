CREATE SEQUENCE public.Utilisateur_id_seq;

CREATE TABLE public.Utilisateur (
                id INTEGER NOT NULL DEFAULT nextval('public.Utilisateur_id_seq'),
                login VARCHAR(20) NOT NULL,
                email VARCHAR(60) NOT NULL,
                password VARCHAR(20) NOT NULL,
                adress VARCHAR(100) NOT NULL,
                phone INTEGER,
                CONSTRAINT Utilisateur_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.Utilisateur_id_seq OWNED BY public.Utilisateur.id;

CREATE SEQUENCE public.Location_id_seq;

CREATE TABLE public.Location (
                id INTEGER NOT NULL DEFAULT nextval('public.Location_id_seq'),
                utilisateur_id INTEGER NOT NULL,
                livre_id INTEGER NOT NULL,
                expiredate DATE NOT NULL,
                prolongation BOOLEAN NOT NULL,
                CONSTRAINT Location_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.Location_id_seq OWNED BY public.Location.id;

CREATE SEQUENCE public.Livre_id_seq;

CREATE TABLE public.Livre (
                id INTEGER NOT NULL DEFAULT nextval('public.Livre_id_seq'),
                titre VARCHAR(45) NOT NULL,
                auteur_id INTEGER NOT NULL,
                genre VARCHAR(45) NOT NULL,
                exemplaire INTEGER NOT NULL,
                Description VARCHAR(200),
                CONSTRAINT Livre_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.Livre_id_seq OWNED BY public.Livre.id;

CREATE SEQUENCE public.Auteur_id_seq;

CREATE TABLE public.Auteur (
                id INTEGER NOT NULL DEFAULT nextval('public.Auteur_id_seq'),
                prenom VARCHAR(20) NOT NULL,
                nom VARCHAR(20) NOT NULL,
                genre VARCHAR(20) NOT NULL,
                CONSTRAINT Autheur_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.Auteur_id_seq OWNED BY public.Auteur.id;


ALTER TABLE public.Location ADD CONSTRAINT fk_utilisateur_id
FOREIGN KEY (utilisateur_id)
REFERENCES public.Utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Location ADD CONSTRAINT fk_livre_id
FOREIGN KEY (livre_id)
REFERENCES public.Livre (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;


ALTER TABLE public.Livre ADD CONSTRAINT fk_auteur_id
FOREIGN KEY (auteur_id)
REFERENCES public.Auteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Livre ADD CONSTRAINT fk_genre_id
FOREIGN KEY (auteur_genre)
REFERENCES public.Auteur (genre)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

CREATE SEQUENCE public.booking_id_seq;

CREATE TABLE public.booking (
                id INTEGER NOT NULL DEFAULT nextval('public.booking_id_seq'),
                user_id INTEGER NOT NULL,
                livre_id INTEGER NOT NULL,
                bookingdate DATE NOT NULL,
                position INTEGER NOT NULL,
                CONSTRAINT booking_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.booking_id_seq OWNED BY public.booking.id;


ALTER TABLE public.booking ADD CONSTRAINT fk_user_id
FOREIGN KEY (user_id)
REFERENCES public.Utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.booking ADD CONSTRAINT fk_livre_id
FOREIGN KEY (livre_id)
REFERENCES public.Livre (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
