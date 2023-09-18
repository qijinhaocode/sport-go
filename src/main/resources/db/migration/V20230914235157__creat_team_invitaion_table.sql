CREATE TABLE team_invitation (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 team_name VARCHAR(255) NOT NULL,
                                 field VARCHAR(255) NOT NULL,
                                 time TIMESTAMP NOT NULL,
                                 cost DECIMAL(10, 2) NOT NULL
);