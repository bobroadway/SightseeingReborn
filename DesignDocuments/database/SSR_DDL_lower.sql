drop database SSR;
drop database ssr;
create database ssr;
use ssr;

drop table sight;
drop table zone;
drop table user;
drop table user_role;

create table sight 
	( id	        int(4)	    	    not null  auto_increment
    , zone_id		int(4)				not null
    , name			varchar(25)		    not null
    , description   varchar(140)
    , cord_x        int(3)				not null
    , cord_y		int(3)				not null
    , cord_z	    int(3)
    , ss_url		varchar(100)
    , user_name     varchar(25)	     	not null
    , created	    timestamp default current_timestamp on update current_timestamp
	, primary key (id)
    );

create table zone
	( zone_id       int(3)				not null  auto_increment
	, expansion     varchar(25)			not null
	, region		varchar(25)			not null
	, name			varchar(30)			not null
	, primary key (zone_id)
	);

create table user
	( user_name     varchar(25)			not null
	, password      varchar(25)			not null
	, created       timestamp default current_timestamp on update current_timestamp
	, pic_url       varchar(100)
	, primary key (user_name)
	);

create table user_role
    ( user_name		varchar(25)		    not null
	, role_name     varchar(25)         not null
	, primary key (user_name, role_name)
	);

alter table sight
	add foreign key (zone_id)
	references zone(zone_id);

alter table sight
	add foreign key (user_name)
	references user(user_name);

create user 'tomcat'@'localhost' identified by 'tomcat';
grant select on ssr.* to 'tomcat'@'localhost';

insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , "Ul'dah - Steps of Nald");
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , "Ul'dah - Steps of Thal");
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'The Goblet');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Central Thanalan');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Western Thanalan');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Eastern Thanalan');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Southern Thanalan');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'Northern Thanalan');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Thanalan'
				 , 'The Gold Saucer');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'Old Gridania');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'New Gridania');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'Lavender Beds');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'Central Shroud');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'East Shroud');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'South Shroud');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'The Black Shroud'
				 , 'North Shroud');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Limsa Lominsa Upper Decks');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Limsa Lominsa Lower Decks');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'The Mist');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Middle La Noscea');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Western La Noscea');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Eastern La Noscea');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Lower La Noscea');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Upper La Noscea');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , 'Outer La Noscea');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'La Noscea'
				 , "The Wolves' Den");
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Mor Dhona'
				 , 'Mor Dhona');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'A Realm Reborn'
				 , 'Coerthas'
				 , 'Coerthas Central Highlands');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Coerthas'
				 , 'Ishgard - Foundation');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Coerthas'
				 , 'Ishgard - The Pillars');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Coerthas'
				 , 'Coerthas Western Highlands');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Dravania'
				 , 'Idyllshire');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Dravania'
				 , 'The Dravanian Forelands');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Dravania'
				 , 'The Dravanian Hinterlands');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Dravania'
				 , 'The Churning Mists');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Abalathia'
				 , 'The Sea of Clouds');
insert into zone ( expansion
                 , region
				 , name)
		  values ( 'Heavensward'
				 , 'Abalathia'
				 , 'Azys Lla');

insert into user ( user_name, password ) values ('admin', 'iamadmin');
insert into user ( user_name, password ) values ('bo', 'iambo');

insert into user_role values ('admin', 'admin');
insert into user_role values ('admin', 'registereduser');
insert into user_role values ('bo', 'registereduser');
	