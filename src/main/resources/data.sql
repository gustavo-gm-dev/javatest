INSERT INTO tb_profile(name) values ('USER_ADMIN');
INSERT INTO tb_profile(name) values ('USER');

INSERT INTO tb_user(name, profile_id, email, password) values ('Admin', (SELECT id FROM tb_profile WHERE name = 'USER_ADMIN'), 'javatest@java.com', encode(sha256('Admin1234$'), 'hex'));

