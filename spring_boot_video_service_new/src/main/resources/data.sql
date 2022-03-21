insert into users(username, password, enabled) values ('misa','$2a$12$JXIPwqCv0BzC5a.N1qSxOOLUwfTV9EFClREOJlnrbLMxFlYz8hg8O',true)
insert into users(username, password, enabled) values ('stefan','test123',true)
insert into users(username, password, enabled) values ('zoran','test123',true)

insert into authorities(username, authority) values ('misa','ROLE_EMPLOYEE')
insert into authorities(username, authority) values ('stefan','ROLE_MANAGER')
insert into authorities(username, authority) values ('zoran','ROLE_ADMIN')