CREATE TABLE state (
 
	state_id int(11) AUTO_INCREMENT,
 
	state_name varchar(45) UNIQUE NOT NULL,
 
	PRIMARY KEY (StateId)
); 



CREATE TABLE city (
 
	city_id int(11) AUTO_INCREMENT,
 
	city_name varchar(45) NOT NULL,
 
	zip_code int(11) NOT NULL,
 
	state_id int(11) NOT NULL,
 
	PRIMARY KEY (CityId),
 
	KEY state_id (StateId),
 
	FOREIGN KEY (state_id) REFERENCES state (state_id)
) ;



INSERT INTO state (state_name) VALUES ('Rajasthan');
INSERT INTO state (state_name) VALUES ('UP');
INSERT INTO state (state_name) VALUES ('Gujrat');
INSERT INTO state (state_name) VALUES ('Uttarakhand');
INSERT INTO state (state_name) VALUES ('MP');

INSERT INTO city (city_name,zipcode,state_id) VALUES ('Jaipur',302033,1);
INSERT INTO city (city_name,zipcode,state_id) VALUES ('UP',302093,2);
INSERT INTO city (city_name,zipcode,state_id) VALUES ('Gujarat',262033,3);	
INSERT INTO city (city_name,zipcode,state_id) VALUES ('Indor',226017,5);

SELECT city.zip_code AS zip_code, city.city_name AS city_name , state.state_name AS state_name
	FROM city INNER JOIN state ON city.state_id = state.state_id 
	ORDER BY state.state_name,city.city_name;
