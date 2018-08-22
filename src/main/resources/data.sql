--SQL inserts for database--

--USER--
insert into tbl_user(id, email, name, password, role, active, deleted) values (1, 'u1@a.a', 'User1', 'pass', 0, true, false);

--ADMIN--
insert into tbl_admin(id, email, name, password, role) values (2, 'a1@a.a', 'Admin1', 'pass', 1);

--ACCOMMODATION--
insert into tbl_accommodation(id, id_agent, description, price, deleted) values (1, 1, 'One-bedroom studio', 10.00, false);

--AGENT--
insert into tbl_agent(id, email, name, password, role) values (1, 'ag1@a.a', 'Agent1', 'pass', 2);

