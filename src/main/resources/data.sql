
INSERT INTO users (user_id, user_name, user_email, user_password)
VALUES
    ('1', 'JohnDoe', 'johndoe@example.com', 'password123'),
    ('2', 'JaneSmith', 'janesmith@example.com', 'mypassword456'),
    ('3', 'AliceJohnson', 'alicejohnson@example.com', 'alicepass789');



INSERT INTO posts (post_id, user_id, content, image_url)
VALUES
    ('1', '1', 'Just went for a run in the park!', 'https://www.planetware.com/wpimages/2021/08/canada-montreal-best-parks-westmount.jpg'),
    ('2', '1', 'Having thanksgiving with the family.', 'https://www.sunset.com/wp-content/uploads/aldi-thanksgiving-dinner-1200x600.jpg'),
    ('3', '1', 'Watching new spider man movie this weekend, cant wait.', 'https://cdn.celluloidjunkie.com/wp-content/uploads/2021/12/23041503/unnamed-20-2.jpg'),
    ('4', '1', 'Save the trees!!!', 'https://easy-peasy.ai/cdn-cgi/image/quality=80,format=auto,width=700/https://fdczvxmwwjwpwbeeqcth.supabase.co/storage/v1/object/public/images/8e3105b3-70ef-40ce-95d3-3dee17c315ae/65d2d273-b321-4560-ad89-3402036afeba.png'),
    ('5', '1', 'Thank you montreal hospital for your help.', 'https://muhc.ca/sites/default/files/2022-01/Lachine-Hospital.jpg'),
    ('6', '2', 'Loving this new book I started reading!', 'https://www.publicbooks.org/wp-content/uploads/2017/01/book-e1484158615982-810x327.jpg'),
    ('7', '2', 'Finally joined the book club!!', 'https://pharmabay.ng/wp-content/uploads/2023/10/Book-Clubs.jpg'),
    ('8', '2', 'Voluntered at an elementary school today.', 'https://www.stgeorges.qc.ca/wp-content/uploads/2024/03/Bread_Beyond_Img.jpg'),
    ('9', '2', 'I just watched the F1 race and it was anamzing!', 'https://f1chronicle.com/wp-content/uploads/2020/07/M234838-1.jpg'),
    ('10', '2', 'My dog is sick today, please send your love his way.', 'https://www.papayapet.com/wp-content/uploads/2023/06/how-to-care-for-your-sick-dog-or-cat-header_66628_13728.jpg'),
    ('11', '3', 'Me and the boys went to Angrignon today, the park there was amazing', 'https://upload.wikimedia.org/wikipedia/commons/f/fb/Lake_in_Angrignon_park_-_panoramio.jpg'),
    ('12', '3', 'I went to an aquarium today, the fish were amazing!', 'https://offloadmedia.feverup.com/montrealsecret.co/wp-content/uploads/2024/03/01100921/Design-sans-titre-28.jpg'),
    ('13', '3', 'Cant wait for the new update for Star Citizens.', 'https://external-preview.redd.it/star-citizen-pyro-system-guide-v0-BNNLocTf5iNXE5m1tfmpRw7QFRS6dGmOyM7DctpU1lM.jpg?width=640&crop=smart&auto=webp&s=656badb8aeae2db8beee45bc899135f708a5ddda'),
    ('14', '3', 'Just saw End Game and im crying :(', 'https://i.ytimg.com/vi/ExOxd9lx9bc/hq720.jpg?sqp=-oaymwEXCK4FEIIDSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLD-ndPpDuR22OjVK1nDSFbI22d2jg'),
    ('15', '3', 'The new pc just got finished, im itching to try it out.', 'https://www.neweggbusiness.com/smartbuyer/wp-content/uploads/DARK_FLASH_TOWER_WEBREADY-08678.jpg');
    



INSERT INTO likes (like_id, user_id, post_id)
VALUES
    ('1', '2', '1'),
    ('2', '3', '2'),
    ('3', '3', '3'),
    ('4', '2', '4'),
    ('5', '3', '4'),
    ('6', '2', '5'),
    ('7', '1', '6'),
    ('8', '1', '7'),
    ('9', '3', '7'),
    ('10', '3', '8'),
    ('11', '3', '9'),
    ('12', '1', '9'),
    ('13', '3', '10'),
    ('14', '2', '11'),
    ('16', '1', '11'),
    ('17', '1', '12'),
    ('18', '1', '13'),
    ('19', '2', '13'),
    ('20', '2', '14'),
    ('21', '2', '15'),
    ('22', '1', '15');




INSERT INTO comments (comment_id, user_id, post_id, content)
VALUES
    ('1', '2', '1', 'Great run, John!'),
    ('2', '3', '1', 'Sounds like fun, John!'),
    ('3', '3', '2', 'Im so jealous, looks amazing!'),
    ('4', '2', '2', 'Wish i could be there.'),
    ('5', '2', '3', 'Im going to watch it too :)'),
    ('6', '3', '4', 'Yes!! We need them to live.'),
    ('7', '2', '4', 'Im donating to the foundation.'),
    ('8', '1', '4', 'Thats a good idea Jane, ill start donating too.'),
    ('9', '2', '5', 'Hope you get better soon!'),
    ('10', '3', '5', 'Were all rooting for you!'),
    ('11', '1', '5', 'Thanks guys.'),
    ('12', '1', '6', 'Whats it called'),
    ('13', '2', '6', 'Its called: Surrounded by Idiots: The Four Types of Human Behavior and How to Effectively Communicate with Each in Business (and in Life)'),
    ('14', '1', '6', 'Thanks'),
    ('15', '3', '7', 'Finally, we can read together!'),
    ('16', '2', '7', 'Yes!'),
    ('17', '1', '7', 'Ive been meaning to join.'),
    ('18', '3', '7', 'You should, its so much fun.'),
    ('19', '3', '8', 'You''re so kind'),
    ('20', '1', '9', 'Must have been cool to watch.'),
    ('21', '2', '9', 'It was!'),
    ('22', '1', '10', 'Hope he gets better soon.'),
    ('23', '3', '10', 'Poor dog.'),
    ('24', '2', '11', 'The park there is really nice.'),
    ('25', '1', '12', 'Its always so relaxing and calming when you go to an aquarium.'),
    ('26', '2', '12', 'Its one of my favorite places to visit.'),
    ('27', '1', '13', 'I''ve been waiting so long for the update!'),
    ('28', '2', '13', 'It should come out some time in december.'),
    ('29', '2', '14', 'I did too :(, the ending is too sad'),
    ('30', '1', '15', 'You gotta let me come over and try it out some time.'),
    ('31', '3', '15', 'Sure, just let me know when your free.');


