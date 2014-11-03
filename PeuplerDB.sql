INSERT INTO jebouquine.CATEGORY (NAME)
VALUES ('Informatique'), ('Dessin'), ('Jardinage');
INSERT INTO jebouquine.LANGUAGE (NAME)
VALUES ('fr'), ('en'), ('ndls');
INSERT INTO jebouquine.PUBLISHER (NAME)
VALUES ('Manning'), ('Del Rey'), ('Atlas'), ('Hachette'), ('Gallimard');
INSERT INTO jebouquine.AUTHOR (FIRSTNAME, LASTNAME)
VALUES ('Chaouki', 'Dhib'), ('Claude', 'Francois'), ('Abra', 'Cadabra'), ('Jean', 'Valjean'), ('Gaston', 'Lagaffe');

INSERT INTO jebouquine.BOOK (TITLE, YEAR, PRICE, ISBN, AVAILABLE, NOVELTY, BESTSALES, author_ID, category_ID, publisher_ID, IMAGE, IMAGE_MINI)
VALUES ('Un long dimanche de fiancailles', 2014, 20.99, '1786', TRUE, TRUE, FALSE, 5, 2, 2, 'https://i.imgur.com/kmvxYCQ.jpg', 'http://i.imgur.com/uPGib88.jpg?1'),
('La huitième couleur', 1997, 12.99, '1477', TRUE, FALSE, TRUE, 1, 1, 3,'https://i.imgur.com/zIRZ4k8.jpg', 'http://i.imgur.com/y8bY45m.jpg?1' ),
('Des souris et des hommes', 1989, 11.49, '2473', TRUE, TRUE, TRUE, 3, 3, 1, 'https://i.imgur.com/schujsE.jpg', 'http://i.imgur.com/TkkYco8.jpg?1' ),
('Des souris et des hommes 2, le retour', 2014, 15.49, '1893', TRUE, FALSE, FALSE, 3, 3, 1, 'https://i.imgur.com/schujsE.jpg', 'http://i.imgur.com/TkkYco8.jpg?1' ),
('Outrage et Rebellion', 2006, 17.49, '3532', TRUE, FALSE, TRUE, 2, 2, 4, 'https://i.imgur.com/5xjTwMz.jpg', 'http://i.imgur.com/6dIyXqw.jpg?1' ),
('Comment devenir un prince charmant en 10 leçons', 2014, 18.99, '8676', TRUE, TRUE, FALSE, 2, 2, 4, 'https://i.imgur.com/yn8aRMO.jpg', 'http://i.imgur.com/mgGopso.jpg?1' ),
('Struts pour les nuls', 2003, 32.29, '3889', TRUE, FALSE, TRUE, 1, 1, 5, 'https://imgur.com/Ky0kXJs.jpg', 'http://i.imgur.com/ZrPDyLm.png?1' ),
('La mer du nord', 1992, 9.99, '8925', TRUE, TRUE, TRUE, 4, 3, 5, 'https://imgur.com/g4frZtG.jpg', 'http://i.imgur.com/aynAe5Y.jpg?1' );

INSERT INTO jebouquine.CLIENT (LOGIN, PASSWORD, EMAIL, FIRSTNAME, LASTNAME)
VALUES('Annie', 'password', 'anne.onyme@gmail.com', 'Anne', 'Onyme');

INSERT INTO jebouquine.ORDERSTATE(NAME)
VALUES('En attente'),('Preparation'),('Livraison'),('Recue'),('Annulée');

INSERT INTO jebouquine.COMMENT (CONTENT, book_ID, client_ID)
VALUES ('Super bouquin! 10/10', 1, 1),('Ma foi, ce fut une sympathique lecture', 2, 1);


