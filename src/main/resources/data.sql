INSERT INTO role (id,role) VALUES (1,'ROLE_USER');
INSERT INTO role (id,role) VALUES (2,'ROLE_ADMIN');
INSERT INTO user (id, login, active, password) VALUES (1, 'user', 1, '$2a$10$/dDnN6EMs7e4z81dNYEWcOr2pN/EJO0QE2W3fOnkm2V79gKjRLGyK'); -- password: user123
INSERT INTO user (id, login, active, password) VALUES (2, 'admin', 1, '$2a$10$3LMfyfUrdsg81gpv6mMBSOdI1OTqHyGQbauUkDPgsj7BzZcdrcFU2'); -- password: admin123
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);