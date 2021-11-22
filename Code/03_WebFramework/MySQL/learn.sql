-- DateTime
create table timestamp_n_datetime(
	id int primary key auto_increment,
	ts timestamp,
	dt datetime
);
insert into timestamp_n_datetime(ts,dt) values(now(),now());
select * from timestamp_n_datetime;