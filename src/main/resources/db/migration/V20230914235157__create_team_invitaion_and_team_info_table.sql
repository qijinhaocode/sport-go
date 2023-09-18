CREATE TABLE team_info
(
    team_name VARCHAR(255) PRIMARY KEY,
    sport VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    founding_year INT,
    coach_name VARCHAR(255)
);


CREATE TABLE team_invitation
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    team_name VARCHAR(255) NOT NULL,
    field VARCHAR(255) NOT NULL,
    time TIMESTAMP NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (team_name) REFERENCES team_info(team_name)
);