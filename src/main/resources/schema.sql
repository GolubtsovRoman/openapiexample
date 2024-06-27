create table if not exists worker (
    id bigserial primary key,
    full_name varchar(255),
    job_title varchar(255)
);
