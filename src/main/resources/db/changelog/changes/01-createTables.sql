create table web_ui.country
(
    id       bigint       not null  primary key,
    district varchar(255) not null,
    locality varchar(255) not null,
    region   varchar(255) not null
);

create table web_ui.employee
(
    id            bigint       not null
        primary key,
    date_of_birth date         not null,
    education     varchar(255) not null,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    second_name   varchar(255) not null
);

create table web_ui.license
(
    id                bigint       not null
        primary key,
    date_of_issue     date         not null,
    issuing_authority varchar(255) not null,
    number_license    integer      not null,
    status            boolean      not null,
    terminated        boolean      not null,
    id_employee       bigint
        constraint empl_fk references web_ui.employee
);

create table web_ui.office
(
    id                  bigint       not null
        primary key,
    dining_room         boolean      not null,
    flor                integer      not null,
    house               integer      not null,
    location            varchar(255) not null,
    number_of_computers integer      not null,
    ramp                boolean      not null,
    residential         boolean      not null,
    rest_room           boolean      not null,
    room                integer      not null,
    sanitary_room       boolean      not null,
    status              varchar(255) not null,
    street              varchar(255) not null,
    telephone           integer      not null,
    year_of_repair      date         not null,
    id_country          bigint
        constraint conuntry_fk
            references web_ui.country
);

create table web_ui."order"
(
    id                      bigint       not null
        primary key,
    content_order           varchar(255) not null,
    issuing_authority_order varchar(255) not null,
    order_date              date         not null,
    order_number            varchar(255) not null,
    start_date              date         not null,
    id_employee             bigint
        constraint order_empl_fk
            references web_ui.employee
);

create table web_ui.notarial_office
(
    id_office   bigint not null
        constraint not_of_office_fk
            references web_ui.office,
    id_employee bigint not null
        constraint not_of_empl_fk
            references web_ui.employee
);

create sequence web_ui.seq_country start 30 INCREMENT BY 1;
create sequence web_ui.seq_emloyee start 30 INCREMENT BY 1;
create sequence web_ui.seq_license start 30 INCREMENT BY 1;
create sequence web_ui.seq_office start 30 INCREMENT BY 1;
create sequence web_ui.seq_entities start 30 INCREMENT BY 1;
