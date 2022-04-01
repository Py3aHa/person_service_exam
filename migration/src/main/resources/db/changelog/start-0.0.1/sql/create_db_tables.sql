create table person_data
(
    id         bigserial primary key,
    last_name  varchar(255) not null,
    first_name varchar(255) not null,
    email      varchar(255) not null unique,
    password   varchar(128) not null,
    disabled   bool         not null,
    birth_dt   date         not null,
    age        smallint,
    sex        char         not null
);

create table roles
(
    id   bigserial primary key,
    role varchar(128)
);

create table log_entity
(
    id          bigserial primary key,
    date_tame   date,
    method_name text,
    class_name  text,
    user_name   text
);

create table purchases(
    id bigserial primary key ,
    person_id bigint not null unique ,
    item_id bigint not null unique ,
    quantity integer not null ,
    price_per_unit integer not null ,
    is_active bool not null ,
    created_at date,
    updated_at date
);

insert into person_data (last_name, first_name, email, password, disabled, birth_dt, age, sex)
values ('ivanov', 'ivan', 'ivanov@mail.com', 'ivanov', true, '1990-03-07', '31', 'm');

insert into roles (role) values ('ROLE_USER');

insert into users_roles (user_id, role_id) values ('1', '3');