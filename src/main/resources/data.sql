
INSERT INTO users (user_id, user_name, user_email, user_password)
VALUES
    ('1', 'JohnDoe', 'johndoe@example.com', 'password123'),
    ('2', 'JaneSmith', 'janesmith@example.com', 'mypassword456'),
    ('3', 'AliceJohnson', 'alicejohnson@example.com', 'alicepass789');



INSERT INTO posts (post_id, user_id, content, image_url)
VALUES
    ('1', '1', 'Just went for a run in the park!', 'https://example.com/posts/park_run.jpg'),
    ('2', '2', 'Loving this new book I started reading!', 'https://example.com/posts/book_reading.jpg'),
    ('3', '3', 'Had a fantastic dinner with friends!', 'https://example.com/posts/friends_dinner.jpg');



INSERT INTO likes (like_id, user_id, post_id)
VALUES
    ('1', '1', '2'),
    ('2', '2', '1'),
    ('3', '3', '2'),
    ('4', '1', '3'),
    ('5', '2', '3');



INSERT INTO comments (comment_id, user_id, post_id, content)
VALUES
    ('1', '1', '1', 'Great run, John!'),
    ('2', '2', '1', 'Sounds like fun, John!'),
    ('3', '3', '2', 'I love that book too!'),
    ('4', '1', '2', 'What’s the title of the book?'),
    ('5', '2', '3', 'Looks like a great evening!'),
    ('6', '3', '1', 'Amazing, John! Keep it up!');
