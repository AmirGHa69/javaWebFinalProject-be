
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id VARCHAR(255) NOT NULL,
                       user_name VARCHAR(255) NOT NULL,
                       user_email VARCHAR(255) NOT NULL UNIQUE,
                       user_password VARCHAR(255) NOT NULL
);



CREATE TABLE posts (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       post_id VARCHAR(255) NOT NULL,
                       user_id INT NOT NULL,
                       content TEXT NOT NULL,
                       image_url VARCHAR(255),
                       timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);



CREATE TABLE likes (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       like_id INT NOT NULL, -- Like identifier
                       user_id INT NOT NULL, -- Foreign key to User table
                       post_id INT NOT NULL, -- Foreign key to Post table
                       timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES users(id),
                       FOREIGN KEY (post_id) REFERENCES posts(id)
);



CREATE TABLE comments (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          comment_id INT NOT NULL, -- Comment identifier
                          user_id INT NOT NULL, -- Foreign key to User table
                          post_id INT NOT NULL, -- Foreign key to Post table
                          content TEXT NOT NULL,
                          timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES users(id),
                          FOREIGN KEY (post_id) REFERENCES posts(id)
);
