create table "user"
(
    id       bigserial    not null,
    login    varchar(255) not null,
    password varchar(255) not null,
    primary key (id)
);



create table chat_room
(
    id    bigserial    not null,
    name  varchar(255) not null,
    owner varchar(255) not null,
    primary key (id)
);

create table user_chat_rooms
(
    chat_room_id bigint not null,
    user_id      bigint not null,
    primary key (user_id, chat_room_id),
    foreign key (user_id) references "user" (id),
    foreign key (chat_room_id) references chat_room (id)
);



create table messages
(
    id           bigserial    not null,
    author       varchar(255) ,
    room         varchar(255) ,
    text         varchar      ,
    date_time    timestamp,
    user_id bigint not null ,
    room_id bigint not null ,
    primary key (id),
    foreign key (user_id) references "user" (id),
    foreign key (room_id) references chat_room (id)
);
