create schema if not exists projectdb;

create table user_profile(
    user_identifier bigint,
    email_address varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    created timestamp,
    last_updated timestamp,
    constraint up_pk primary key (user_identifier)
);

create table appointments(
    id bigint,
    user_profile_id bigint,
    role_id bigint,
    role_description varchar(255),
    organisation_name(255),
    constraint appointment_pk primary key (id)
);

alter table appointments add constraint fk_user_identifier foreign key (user_profile_id) references user_profile(user_identifier);