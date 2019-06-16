
--- ================================================================================
--- utilisateur
--- ================================================================================

INSERT INTO public.utilisateur (login, email, password, adress, phone )
        VALUES ('mike', 'mike@mail', crypt('root', gen_salt('bf')), '24 rue de genève - Lyon', '0666887755');

INSERT INTO public.utilisateur (login, email, password, adress, phone )
        VALUES ('rachel', 'rachel@mail', crypt('root', gen_salt('bf')), '10 rue de genève - Annemasse', '0666887744');
--- ================================================================================
--- auteur
--- ================================================================================

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
--- ================================================================================
--- livre
--- ================================================================================


INSERT INTO public.livre (titre, auteur_id, exemplaire, genre, description)
        VALUES ('L''arabe du futur', 5, 2, 'comic', 'Une jeunesse au Moyen-Orient (1978-1984)');

INSERT INTO public.livre (titre, auteur_id, exemplaire, genre, description)
        VALUES ('Le musée de l''innocence', 4, 1, 'roman', 'Un grand roman nostalgique sur la passion');

INSERT INTO public.livre (titre, auteur_id, exemplaire, genre, description)
        VALUES ('Le prince', 3, 1, 'politique', 'Traité politique écrit au début du XVIe siécle');

INSERT INTO public.livre (titre, auteur_id, exemplaire, genre, description)
        VALUES ('La nausée', 1, 1, 'philosophie', 'Roman philosophique publié en 1938');

INSERT INTO public.livre (titre, auteur_id, exemplaire, genre, description)
        VALUES ('Le Père Goriot', 2, 2, 'littérature', 'Oeuvre de la comédie humaine');
--- ================================================================================
--- location
--- ================================================================================

INSERT INTO public.location (utilisateur_id, livre_id, expiredate, prolongation)
        VALUES (1, 1, '2019-01-31', 'false' );

INSERT INTO public.location (utilisateur_id, livre_id, expiredate, prolongation)
        VALUES (2, 2, '2019-01-05', 'true' );
