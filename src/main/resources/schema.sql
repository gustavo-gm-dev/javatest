-- DROP TABLE IF EXISTS public.tb_profile;
CREATE TABLE IF NOT EXISTS tb_profile (
    id serial PRIMARY KEY,
    role varchar(250) NOT NULL UNIQUE
);

-- DROP TABLE IF EXISTS public.tb_user;
CREATE TABLE IF NOT EXISTS tb_user (
    id serial PRIMARY KEY,
    login varchar(250) NOT NULL,
    profile_id integer REFERENCES tb_profile (id),
    email varchar(250),
    password varchar(250)
);
