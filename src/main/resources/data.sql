
--SQL inserts for database--

--USER--
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (1, 'u1@a.a', 'User1', 'pass', 0, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (4, 'u2@a.a', 'User2deleted', 'pass', 0, true, true, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (5, 'u3@a.a', 'User2blocked', 'pass', 0, false, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (6, 'u4@a.a', 'User2blockedAndDeleted', 'pass', 0, false, true, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (7, 'admin@mail.com', 'admin', 'pass', 1, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (8, 'jovo@mail.com', 'jovo', 'pass', 0, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (9, 'pero@mail.com', 'pero', 'pass', 0, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (10, 'simo@mail.com', 'simo', 'pass', 0, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (11, 'miro@mail.com', 'miro', 'pass', 0, true, false, 'Novi Sad');
insert into tbl_user(id, email, name, password, role, active, deleted, address) values (12, 'miko@mail.com', 'miko', 'pass', 0, true, false, 'Novi Sad');

--ADMIN--
insert into tbl_admin(id, email, name, password, role, address) values (2, 'a1@a.a', 'Admin1', 'pass', 1, 'Beograd');

--AGENT--
insert into tbl_agent(id, email, name, password, role, tin, address) values (3, 'ag1@a.a', 'Agent1', 'pass', 2, 123456789, 'Banja Luka');

--ACCOMMODATION--
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom) 
values (1, 3, 1, 1, 'http://www.visitcentralpa.org/data/uploads/media/image/Lodging-Top-2.jpg', 'Two-bedroom studio', 10.00, 'Novi Grad', false, true, false, true, false, true, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom) 
values (2, 3, 1, 1, 'http://www.visitcentralpa.org/data/uploads/media/image/Lodging-Top-2.jpg', 'One-bedroom studio', 10.00, 'Novi Sad', false, false, false, false, false, false, false, false);

--My Values
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (3, 3, 3,  1, 'https://cdn.sandals.com/sandals/v12/images/resorts/all-resorts-sliders/sbd/sandals-barbados-pool.jpg', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mattis rhoncus urna neque viverra justo nec ultrices. ', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (4, 3, 3, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Town_and_Country_fh000023.jpg/1200px-Town_and_Country_fh000023.jpg', 'Vel pharetra vel turpis nunc eget lorem dolor. Ac felis donec et odio pellentesque diam volutpat commodo sed. Gravida cum sociis natoque penatibus et. Blandit turpis cursus in hac habitasse platea dictumst. Rutrum tellus pellentesque eu tincidunt. ', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (5, 3, 3, 1, 'http://static.asiawebdirect.com/m/bangkok/portals/pattaya-bangkok-com/homepage/10-family-resorts/pagePropertiesImage/top10-family-resorts-pattaya.jpg', 'Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing elit. ', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (6, 3, 3, 1, 'https://imgcld.yatra.com/ytimages/image/upload/t_seo_Hotel_w_930_h_550_c_fill_g_auto_q_40_f_jpg/v1497586632/Hotel/Thekkady/00002140/swimming_pool__(2)_kxWktR.jpg', 'Ultricies leo integer malesuada nunc vel risus commodo viverra maecenas. Eu lobortis elementum nibh tellus molestie nunc. Mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus. Laoreet sit amet cursus sit amet.', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (7, 3, 3, 1, 'https://cdn.sandals.com/sandals/v12/images/resorts/all-resorts-sliders/sbd/sandals-barbados-pool.jpg', 'Nibh ipsum consequat nisl vel. Leo urna molestie at elementum eu. Faucibus ornare suspendisse sed nisi lacus sed. Egestas dui id ornare arcu.', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (8, 3, 3, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Town_and_Country_fh000023.jpg/1200px-Town_and_Country_fh000023.jpg', 'Ultricies tristique nulla aliquet enim tortor at auctor urna nunc. Leo integer malesuada nunc vel. Ac auctor augue mauris augue neque gravida. Pellentesque eu tincidunt tortor aliquam nulla. ', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (9, 3, 3, 1, 'http://static.asiawebdirect.com/m/bangkok/portals/pattaya-bangkok-com/homepage/10-family-resorts/pagePropertiesImage/top10-family-resorts-pattaya.jpg', 'Nunc lobortis mattis aliquam faucibus purus in massa tempor. Elementum curabitur vitae nunc sed. Feugiat sed lectus vestibulum mattis ullamcorper. Sit amet dictum sit amet justo donec. Faucibus et molestie ac feugiat sed lectus vestibulum mattis.', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (10, 3, 3, 1, 'https://imgcld.yatra.com/ytimages/image/upload/t_seo_Hotel_w_930_h_550_c_fill_g_auto_q_40_f_jpg/v1497586632/Hotel/Thekkady/00002140/swimming_pool__(2)_kxWktR.jpg', 'Proin fermentum leo vel orci porta non pulvinar. Scelerisque purus semper eget duis at tellus at. Aliquam purus sit amet luctus venenatis lectus magna fringilla urna. ', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (11, 3, 3, 1, 'https://cdn.sandals.com/sandals/v12/images/resorts/all-resorts-sliders/sbd/sandals-barbados-pool.jpg', 'Neque ornare aenean euismod elementum. Consectetur adipiscing elit ut aliquam. Morbi tristique senectus et netus et. Velit laoreet id donec ultrices tincidunt arcu non sodales neque. Varius sit amet mattis vulputate enim nulla. ', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (12, 3, 3, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Town_and_Country_fh000023.jpg/1200px-Town_and_Country_fh000023.jpg', 'Nunc scelerisque viverra mauris in aliquam sem fringilla. Vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt. Amet est placerat in egestas erat imperdiet.', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (13, 3, 3, 1, 'http://static.asiawebdirect.com/m/bangkok/portals/pattaya-bangkok-com/homepage/10-family-resorts/pagePropertiesImage/top10-family-resorts-pattaya.jpg', 'Bla bla bla', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (14, 3, 3, 1, 'https://imgcld.yatra.com/ytimages/image/upload/t_seo_Hotel_w_930_h_550_c_fill_g_auto_q_40_f_jpg/v1497586632/Hotel/Thekkady/00002140/swimming_pool__(2)_kxWktR.jpg', 'Bla bla bla', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (15, 3, 3, 1, 'https://cdn.sandals.com/sandals/v12/images/resorts/all-resorts-sliders/sbd/sandals-barbados-pool.jpg', 'Bla bla bla', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (16, 3, 3, 1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Town_and_Country_fh000023.jpg/1200px-Town_and_Country_fh000023.jpg', 'Bla bla bla', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (17, 3, 3, 1, 'http://static.asiawebdirect.com/m/bangkok/portals/pattaya-bangkok-com/homepage/10-family-resorts/pagePropertiesImage/top10-family-resorts-pattaya.jpg', 'Bla bla bla', 200, 'XX YY', true, false, true, false, false, false, false, true);
insert into tbl_accommodation(id, agent_id, category, accommodation_type, image_uri, description, daily_price, address, parking, wifi, breakfast, half_board, full_board, tv, kitchen, private_bathroom)
values (18, 3, 3, 1, 'https://imgcld.yatra.com/ytimages/image/upload/t_seo_Hotel_w_930_h_550_c_fill_g_auto_q_40_f_jpg/v1497586632/Hotel/Thekkady/00002140/swimming_pool__(2)_kxWktR.jpg', 'Bla bla bla', 200, 'XX YY', true, false, true, false, false, false, false, true);

--COMMENT--
insert into tbl_comment(id, user_id, accommodation_id, text, approval_state, comment_time) values (1, 1, 1, 'This is comment text', 2, '2018-08-25 7:30');

--RESERVATION--
--insert into tbl_reservation(id, client_id, accommodation_id, start_time, end_time, status) values (1, 1, 1, '2018-08-25 7:30', '2018-08-29 23:59', 0);
insert into tbl_reservation(id, client_id, accommodation_id, start_time, end_time, status) values (2, 7, 2, '2018-08-29 7:30', '2018-08-31 23:59', 0);
insert into tbl_reservation(id, client_id, accommodation_id, start_time, end_time, status) values (3, 1, 1, '2018-09-01 7:30', '2018-09-10 23:59', 0);
insert into tbl_reservation(id, client_id, accommodation_id, start_time, end_time, status) values (4, 8, 2, '2018-09-01 7:30', '2018-09-15 23:59', 0);





--