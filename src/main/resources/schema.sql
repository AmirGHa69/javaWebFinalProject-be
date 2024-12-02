CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id VARCHAR(255) NOT NULL,
                       user_name VARCHAR(255) NOT NULL,
                       user_email VARCHAR(255) NOT NULL UNIQUE,
                       user_password VARCHAR(255) NOT NULL
);

CREATE TABLE posts (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       post_id VARCHAR(36) NOT NULL UNIQUE,
                       user_id BIGINT NOT NULL,
                       content VARCHAR(255) NOT NULL,
                       image_url VARCHAR(255),
                       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE likes (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       like_id BIGINT NOT NULL UNIQUE,
                       user_id BIGINT NOT NULL,
                       post_id BIGINT NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES users(id),
                       FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);

CREATE TABLE comments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          comment_id BIGINT NOT NULL UNIQUE,
                          user_id BIGINT NOT NULL,
                          post_id BIGINT NOT NULL,
                          content VARCHAR(255) NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users(id),
                          FOREIGN KEY (post_id) REFERENCES posts(id) ON DELETE CASCADE
);
