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




INSERT INTO public.utilisateur (login, email, password, adress, phone )
        VALUES ('mike', 'mike@mail', 'root', '24 rue de genève - Lyon', '0666887755');

INSERT INTO public.utilisateur (login, email, password, adress, phone )
        VALUES ('rachel', 'rachel@mail', 'root', '10 rue de genève - Annemasse', '0666887744');


INSERT INTO public.auteur (prenom, nom, genre)
        VALUES ('jean-paul', 'Sartre', 'philosophie');

INSERT INTO public.auteur (prenom, nom, genre)
        VALUES ('honoré', 'Balzac', 'littérature');

INSERT INTO public.auteur (prenom, nom, genre)
        VALUES ('nicolas', 'Machiavel', 'politique');

INSERT INTO public.auteur (prenom, nom, genre)
        VALUES ('orhan', 'Pamuk', 'roman');

INSERT INTO public.auteur (prenom, nom, genre)
        VALUES ('riad', 'Sattouf', 'comic');




INSERT INTO public.livre (titre, autheur_id, exemplaire, genre, description)
        VALUES ('L''arabe du futur', 5, 2, 'comic', 'Une jeunesse au Moyen-Orient (1978-1984)');

INSERT INTO public.livre (titre, autheur_id, exemplaire, genre, description)
        VALUES ('Le musée de l''innocence', 4, 1, 'roman', 'Un grand roman nostalgique sur la passion');

INSERT INTO public.livre (titre, autheur_id, exemplaire, genre, description)
        VALUES ('Le prince', 3, 1, 'politique', 'Traité politique écrit au début du XVIe siécle');

INSERT INTO public.livre (titre, autheur_id, exemplaire, genre, description)
        VALUES ('La nausée', 1, 1, 'philosophie', 'Roman philosophique publié en 1938');

INSERT INTO public.livre (titre, autheur_id, exemplaire, genre, description)
        VALUES ('Le Père Goriot', 2, 2, 'littérature', 'Oeuvre de la comédie humaine');



INSERT INTO public.location (utilisateur_id, livre_id, expiredate, prolongation)
        VALUES (1, 1, '2019-01-31', 'false' );

INSERT INTO public.location (utilisateur_id, livre_id, expiredate, prolongation)
        VALUES (2, 2, '2019-01-05', 'true' );