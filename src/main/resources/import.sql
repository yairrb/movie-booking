

INSERT INTO movie (title, description, genre, YEAR_OF_PRODUCTION, duration, enable) VALUES ('The Simpsons', 'best family comedy adventure', 'Comedy', '2001-01-01', 2.5,1);
INSERT INTO movie (title, description, genre, YEAR_OF_PRODUCTION, duration, enable) VALUES ('Spirited away', 'masterpiece of miyasaki', 'Animated', '2001-01-01', 2.5,1);
INSERT INTO movie (title, description, genre, YEAR_OF_PRODUCTION, duration, enable) VALUES ('Howls moving castle', 'masterpiece of miyasaki', 'Adventure', '2001-01-01', 2.5, 1);

INSERT INTO showtime (start_date, room, movie_id) VALUES (NOW(), 1, 1);
INSERT INTO showtime (start_date, room, movie_id) VALUES (NOW(), 2, 2);
INSERT INTO showtime (start_date, room, movie_id) VALUES (NOW(), 3, 2);
INSERT INTO showtime (start_date, room, movie_id) VALUES (NOW(), 3, 1);

INSERT INTO ticket (room,seat_number, user_id, showtime_id) VALUES (1,12,5,1);