create user nwt;
alter user nwt WITH ENCRYPTED PASSWORD 'nwt';

CREATE DATABASE "nwt-cinema-auth";
CREATE DATABASE "nwt-cinema-movies";

grant all PRIVILEGES on DATABASE "nwt-cinema-auth" to nwt;
grant all PRIVILEGES on DATABASE "nwt-cinema-movies" to nwt;

commit;