--SQL inserts for database--

--USER--
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (1, 'u1@a.a', 'User1', 'pass', 0, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (4, 'u2@a.a', 'User2deleted', 'pass', 0, true, true, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (5, 'u3@a.a', 'User2blocked', 'pass', 0, false, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (6, 'u4@a.a', 'User2blockedAndDeleted', 'pass', 0, false, true, 'Novi Sad');

--ADMIN--
insert into tbl_admin(id, email, name, password, role, address) values (2, 'a1@a.a', 'Admin1', 'pass', 1, 'Beograd');

--AGENT--
insert into tbl_agent(id, email, name, password, role, tin, address) values (3, 'ag1@a.a', 'Agent1', 'pass', 2, 123456789, 'Banja Luka');

--ACCOMMODATION--
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom) 
values (1, 3, 1, 1, 'http://www.visitcentralpa.org/data/uploads/media/image/Lodging-Top-2.jpg', 'Two-bedroom studio', 10.00, 'Sarajevo', false, true, false, true, false, true, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom) 
values (2, 3, 1, 1, 'http://www.visitcentralpa.org/data/uploads/media/image/Lodging-Top-2.jpg', 'One-bedroom studio', 10.00, 'Novi Sad', false, false, false, false, false, false, false, false);
--COMMENT--
insert into tbl_comment(id, user_id, accommodation_id, text, approval_state, comment_time) values (1, 1, 1, 'This is comment text', 2, '2018-08-25 7:30');

--RESERVATION--
insert into tbl_reservation(id, client_id, accommodation_id, start_time, end_time, status) values (1, 1, 1, '2018-08-25 7:30', '2018-08-29 23:59', 0);