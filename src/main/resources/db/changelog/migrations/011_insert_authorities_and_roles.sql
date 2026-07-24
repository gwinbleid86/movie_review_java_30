insert into authorities (authority)
values ('READ'),
       ('WRITE'),
       ('EDIT'),
       ('DELETE'),
       ('FULL');

insert into roles (role, authority_id)
values ('ADMIN', (select id from authorities where authority = 'FULL')),
       ('MODERATOR', (select id from authorities where authority = 'EDIT')),
       ('USER', (select id from authorities where authority = 'READ'));

update customers t
set t.role_id = (select r.id from roles r where r.role = 'ADMIN')
where t.email like 'qwe@qwe.qwe';