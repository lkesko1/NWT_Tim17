create user nwt;
alter user nwt WITH ENCRYPTED PASSWORD 'nwt';

CREATE DATABASE "nwt-cinema-auth";
CREATE DATABASE "nwt-cinema-movies";
CREATE DATABASE "nwt-cinema-projections";
CREATE DATABASE "nwt-cinema-reservations";
CREATE DATABASE "nwt-cinema-upcomings";

grant all PRIVILEGES on DATABASE "nwt-cinema-auth" to nwt;
grant all PRIVILEGES on DATABASE "nwt-cinema-movies" to nwt;
grant all PRIVILEGES on DATABASE "nwt-cinema-projections" to nwt;
grant all PRIVILEGES on DATABASE "nwt-cinema-reservations" to nwt;
grant all PRIVILEGES on DATABASE "nwt-cinema-upcomings" to nwt;
