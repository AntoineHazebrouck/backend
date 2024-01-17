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
- trop de petits détails de configurations en concurrence selon les modules (comme la console H2 et security par example)

#### Remarques

- Il y a un problème d'encodage des strings, c'est probablement lié à l'utilisation d'H2 in memory. Le mauvais encodage apparait même dans la console H2 ...
- les utilisateurs ne sont pas liés à JPA, les tables USERS/AUTHORITIES sont créées dans schema.sql

Q1 fait
Q2 fait
Q3 fait
Q4 fait
Q5 fait
Q6 fait
Q7 fait
Q8 fait
endpoint "/test" fait