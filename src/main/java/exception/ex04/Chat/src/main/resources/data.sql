insert into "user" (login, password)
VALUES ('vydii', '12345');
insert into "user" (login, password)
VALUES ('qwerty', '54321');
insert into "user" (login, password)
VALUES ('buldog', '33333');

insert into "user" (login, password)
VALUES ('joker', '11111');

insert into "user"(login, password)
VALUES ('zoomer', '22222');

insert into "user" (login, password)
VALUES ('king', '66666');

insert into chat_room (name, owner)
VALUES ('room_1', 'vydii');

insert into chat_room (name, owner)
VALUES ('room_2', 'buldog');

insert into chat_room (name, owner)
VALUES ('room_3', 'joker');

insert into chat_room (name, owner)
VALUES ('room_4', 'zoomer');

insert into chat_room (name, owner)
VALUES ('room_5', 'king');

insert into messages (author, room, text, date_time, user_id, room_id)
VALUES ('vydii', 'room_1', 'hi', current_timestamp, 1, 1);

insert into messages (author, room, text, date_time, user_id, room_id)
VALUES ('qwerty', 'room_1', 'hi!!!', current_timestamp(1), 2, 1);

insert into messages (author, room, text, date_time, user_id, room_id)
VALUES ('vydii', 'room_1', 'how are u?', current_timestamp(1), 1, 1);

insert into messages (author, room, text, date_time, user_id, room_id)
VALUES ('qwerty', 'room_1', 'good!', current_timestamp(2), 2, 1);

insert into messages (author, room, text, date_time, user_id, room_id)
VALUES ('vydii', 'room_1', 'bye)', current_timestamp(2), 1, 1);

insert into messages (author, room, text, date_time, user_id, room_id)
VALUES ('qwerty', 'room_1', 'bye!', current_timestamp(3), 2, 1);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (1, 1);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (1, 2);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (2, 3);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (3, 4);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (4, 5);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (5, 6);

insert into user_chat_rooms (chat_room_id, user_id)
VALUES (2, 1);

