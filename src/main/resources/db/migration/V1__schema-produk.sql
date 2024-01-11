create table merchants
(
    id       character varying(64)  not null primary key,
    name     character varying(100) not null,
    level    character varying(5)   not null default 'local',
    location text
);

create table warehouse
(
    id       character varying(64) primary key not null,
    name     character varying(100)            not null,
    location text
);

create table products
(
    id               character varying(64) primary key not null,
    name             character varying(100)            not null,
    price_bill       numeric(8, 2)                     not null default 0,
    price_sell       numeric(8, 2)                     not null default 0,
    merchant_id      character varying(64)             not null,
    warehouse_id     character varying(64)             not null,
    description      text,
    created_date     timestamp                         not null default now(),
    last_update_date timestamp
);

alter table products
    add constraint fk_product_merchant_id foreign key (merchant_id)
        REFERENCES merchants (id) on DELETE cascade on UPDATE cascade;

alter table products
    add constraint fk_product_warehouse foreign key (warehouse_id)
        references merchants (id) on DELETE cascade on UPDATE cascade;

create table categories
(
    id          character varying(64)  not null primary key,
    name        character varying(100) not null,
    description text
);

create table product_categories
(
    id          character varying(64) not null primary key,
    product_id  character varying(64) not null,
    category_id character varying(64) not null,
    constraint uq_product_category unique (product_id, category_id),
    constraint fk_group_category_id foreign key (category_id)
        references categories (id) on DELETE cascade on UPDATE cascade,
    constraint fk_group_product_id foreign key (product_id)
        references products (id) on UPDATE cascade on DELETE cascade
);
