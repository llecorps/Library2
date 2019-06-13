## Mettez en oeuvre la SOA pour le nouveau système d’information de la bibliothèque d’une grande ville

### Contexte

Le service culturel d’une grande ville souhaite moderniser la gestion de ses bibliothèques. Pour cela, elle désire mettre à disposition de ses usagers, un système de suivi des prêts de leurs ouvrages.

Ce système comprendra :

un site web (en responsive design) accessible aux usagers et permettant :
de rechercher des ouvrages et voir le nombre d’exemplaires disponibles.
de suivre leurs prêts en cours. Les prêts sont pour une période de 4 semaines.
de prolonger un prêt. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.
une application mobile iOS et Android fournissant les mêmes services que le site web.
une application spécifique pour le personnel des bibliothèque permettant, entre autres, de gérer les emprunts et le livres rendus.
un batch lancé régulièrement et qui enverra des mails de relance aux usagers n’ayant pas rendu les livres en fin de période de prêt.
À vous de réaliser ce système !


### Contenu

-   `biblio` : les sources du projet de bibliothèque

### Installation

- `Unzip`le package biblio-delivery.zip.
- Déployer biblio-service.war sur le serveur Glassfih via l'interface Administrateur.
- Déployer biblio-webapp.war sur le serveur Tomcat.
- Sur linux :
  -> déployer biblio-batch-1.0-SNAPSHOT-archive-deploy.tar.gz.
  -> Livrer les fichiers de configuration : config.properties, db-biblio.properties.
  -> Lancer le script batch-export-emprunt-statut.sh
  
### Crontab

- crontab -e pour éditer la crontab.
- exemple pour un batch journalier lancé à 02:00 AM:
# Minute   Hour   Day of Month       Month          Day of Week        Command    
# (0-59)  (0-23)     (1-31)    (1-12 or Jan-Dec)  (0-6 or Sun-Sat)                
    0        2          *             *                *            batch-export-emprunt-statut.sh