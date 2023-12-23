INSERT INTO users (username, password, enabled) VALUES ('user', '{bcrypt}$2a$12$I1nYVDDWB5.hRUB.QHtp5eMGe6kTqceUK28nBNWyDIQ2VFxwPIiRa', true); 
INSERT INTO authorities (username, authority) VALUES ('user', 'ADMIN');

-- data.sql
INSERT INTO users VALUES ('pierre','{noop}pierre',TRUE);
INSERT INTO authorities VALUES ('pierre', 'USER');

INSERT INTO users VALUES ('paul','{MD5}6c63212ab48e8401eaf6b59b95d816a9',TRUE);
INSERT INTO authorities VALUES ('paul', 'USER');