create database commute default character set UTF8;

-- 팀(팀이름)
create table team(
	id bigint auto_increment,
    name varchar(50) not null,
    primary key (id)
);

-- 직원(직원이름, 팀이름, 매니저인지 아닌지 여부, 회사에 들어온 일자, 생일)
create table employee(
	id bigint auto_increment,
    name varchar(100) not null,
    team_id bigint,
    is_manager tinyint(1),
    work_start_date date,
    birthday date,
    primary key(id)
);