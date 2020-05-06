create table public.user_profile(
    id bigint,
    email_address varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    created timestamp,
    last_updated timestamp,
    constraint up_pk primary key (id),
    constraint email_address_uq unique (email_address)
);

create table public.appointments(
    id bigint,
    user_profile_id bigint not null,
    role_id bigint,
    role_description varchar(255),
    organisation_name varchar(255),
    constraint appointment_pk primary key (id)
);

create sequence public.user_id_seq start 1 increment 1;

create sequence public.appointment_id_seq start 1 increment 1;

alter table public.appointments add constraint fk_user_identifier foreign key (user_profile_id) references public.user_profile (id);
