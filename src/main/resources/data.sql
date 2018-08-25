--SQL inserts for database--

--USER--
insert into tbl_user(id, email, name, password, role, active, deleted) values (1, 'u1@a.a', 'User1', 'pass', 0, true, false);

--ADMIN--
insert into tbl_admin(id, email, name, password, role) values (2, 'a1@a.a', 'Admin1', 'pass', 1);

--AGENT--
insert into tbl_agent(id, email, name, password, role, tin) values (3, 'ag1@a.a', 'Agent1', 'pass', 2, 123456789);

--ACCOMMODATION--
insert into tbl_accommodation(id, agent_id, description, price, address) values (1, 3, 'One-bedroom studio', 10.00, 'This is address');

--COMMENT--
insert into tbl_comment(id, user_id, accommodation_id, text, status, comment_time) values (1, 1, 1, 'This is comment text', 2, '2018-08-25 7:30');

--RESERVATION--
insert into tbl_reservation(id, client_id, accommodation_id, start_time, end_time, status) values (1, 1, 1, '2018-08-25 7:30', '2018-08-29 23:59', 2);