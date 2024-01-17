## Antoine HAZEBROUCK, BUT3

BDD = h2 in memory

Création automatique des tables : oui


Q1 fait
Q2 fait
Q3 fait
Q8 fait (il manque le default à zero pour nbchoix)
Q4 fait (il faut gerer le null lié au manque du default à zero pour nbchoix)


## Rattrapage

#### Problèmes rencontrés lors du CTP

- JSP trop chronophages, aucun outil adapté au développement de JSP (en tout cas sur VSCode)
- questions dans le mauvais ordre ? il faut logiquement JPA pour récuperer les données à afficher, sinon on pert du temps à intégrer un systeme temporaire
- trop de petits détails de configurations en concurrence selon les modules (comme la console H2 et security par example, ou csrf pour les formulaires, ...)

#### Remarques

- trop difficile de faire valider les questions aux encadrants trop occupés pendant le ctp
- Il y a un problème d'encodage des strings, c'est probablement lié à l'utilisation d'H2 in memory. Le mauvais encodage apparait même dans la console H2 ...
- les utilisateurs ne sont pas liés à JPA, les tables USERS/AUTHORITIES sont créées dans la base H2 dans schema.sql, les utilisateurs sont créés dans le code à l'initation de spring via ApplicationRunner

#### Questions

- Q1 fait
- Q2 fait
- Q3 fait
- Q4 fait
- Q5 fait
- Q6 fait
- Q7 fait
- Q8 fait
- endpoint "/test" fait
- endpoint "/questions" et "/choix" faits

#### Procedure

- mvn spring-boot:run
- localhost:8080/activer (login = admin/admin)
- on active une question
- on se trouve alors sur localhost:8080/voir, qui nous permet de visualiser les votes ainsi que le pourcentage de bonnes réponses
- en navigation privée -> localhost:8080/voter (login = user1/user1, user2/user2, user3/user3)
- on vote
- on peut visualiser les votes sur l'autre navigateur