CREATE DATABASE irctc_db;
USE irctc_db;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(256)
);

CREATE TABLE trains (
    train_id INT PRIMARY KEY AUTO_INCREMENT,
    train_name VARCHAR(100),
    source VARCHAR(100),
    destination VARCHAR(100),
    total_seats INT,
    available_seats INT
);

CREATE TABLE tickets (
    pnr VARCHAR(20) PRIMARY KEY,
    user_id INT,
    train_id INT,
    seat_number INT,
    status VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (train_id) REFERENCES trains(train_id)
);