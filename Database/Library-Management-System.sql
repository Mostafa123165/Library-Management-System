CREATE DATABASE IF NOT EXISTS LibraryManagementSystemDB ;
USE LibraryManagementSystemDB;

CREATE TABLE IF NOT EXISTS book (
	id BIGINT  PRIMARY KEY AUTO_INCREMENT,
    ISBN   VARCHAR(20)   NOT NULL,
    title  VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    CONSTRAINT unique_isbn UNIQUE(ISBN)
);

CREATE TABLE IF NOT EXISTS patron (
	id BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
    phone   VARCHAR(30)  NOT NULL,
    CONSTRAINT unique_phone UNIQUE(phone),
    CONSTRAINT unique_email UNIQUE(email)
);

CREATE TABLE IF NOT EXISTS borrowing_records(
	id BIGINT  PRIMARY KEY AUTO_INCREMENT,
    book_id     BIGINT ,
    patron_id   BIGINT ,
    return_date    DATE DEFAULT NULL ,
    borrowing_date DATE NOT NULL,
    CONSTRAINT foreign_key_book_id   FOREIGN KEY (book_id)   REFERENCES book(id),
    CONSTRAINT foreign_key_patron_id FOREIGN KEY (patron_id) REFERENCES patron(id)
);

create table liberian(
	id BIGINT  PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role Enum('ROLE_ADMIN','ROLE_USER'),
	access_token VARCHAR(255),
    CONSTRAINT unique_email UNIQUE(email)
);


-- demo data 


INSERT INTO book (ISBN, title, author) VALUES
('978-3-16-148410-0', 'The Catcher in the Rye', 'J.D. Salinger'),
('978-0-06-112008-4', 'To Kill a Mockingbird', 'Harper Lee'),
('978-0-452-28423-4', '1984', 'George Orwell'),
('978-0-7432-7356-5', 'The Road', 'Cormac McCarthy'),
('978-0-14-303943-3', 'Pride and Prejudice', 'Jane Austen'),
('978-1-4516-7321-6', 'The Great Gatsby', 'F. Scott Fitzgerald'),
('978-0-316-76948-0', 'The Da Vinci Code', 'Dan Brown'),
('978-0-14-018739-6', 'Lord of the Flies', 'William Golding'),
('978-0-06-231500-7', 'The Hobbit', 'J.R.R. Tolkien'),
('978-0-15-101026-4', 'The Book Thief', 'Markus Zusak'),
('978-0-307-74368-5', 'Gone Girl', 'Gillian Flynn'),
('978-1-4028-9462-6', 'The Hunger Games', 'Suzanne Collins'),
('978-0-06-245773-8', 'Big Little Lies', 'Liane Moriarty'),
('978-1-5247-6543-9', 'Divergent', 'Veronica Roth'),
('978-0-385-35181-6', 'A Game of Thrones', 'George R.R. Martin'),
('978-0-14-303972-5', 'The Alchemist', 'Paulo Coelho'),
('978-0-452-28425-8', 'Brave New World', 'Aldous Huxley'),
('978-0-06-059394-0', 'Fahrenheit 451', 'Ray Bradbury'),
('978-1-56865-784-5', 'The Maze Runner', 'James Dashner'),
('978-0-345-39180-3', 'The Shining', 'Stephen King');

INSERT INTO patron (name, email, address, phone) VALUES
('John Doe', 'john.doe@example.com', '123 Main St, Springfield, IL', '123-456-7890'),
('Jane Smith', 'jane.smith@example.com', '456 Elm St, Springfield, IL', '234-567-8901'),
('Jim Brown', 'jim.brown@example.com', '789 Oak St, Springfield, IL', '345-678-9012'),
('Judy White', 'judy.white@example.com', '101 Maple St, Springfield, IL', '456-789-0123'),
('Jack Black', 'jack.black@example.com', '202 Pine St, Springfield, IL', '567-890-1234'),
('Janet Green', 'janet.green@example.com', '303 Cedar St, Springfield, IL', '678-901-2345'),
('Jerry Blue', 'jerry.blue@example.com', '404 Birch St, Springfield, IL', '789-012-3456'),
('Jessica Yellow', 'jessica.yellow@example.com', '505 Walnut St, Springfield, IL', '890-123-4567'),
('Jeremy Purple', 'jeremy.purple@example.com', '606 Ash St, Springfield, IL', '901-234-5678'),
('Joy Brown', 'joy.brown@example.com', '707 Redwood St, Springfield, IL', '012-345-6789'),
('Jason Orange', 'jason.orange@example.com', '808 Cypress St, Springfield, IL', '123-567-8901'),
('Jasmine Pink', 'jasmine.pink@example.com', '909 Magnolia St, Springfield, IL', '234-678-9012'),
('Jordan Gray', 'jordan.gray@example.com', '1010 Hickory St, Springfield, IL', '345-789-0123'),
('Jillian Silver', 'jillian.silver@example.com', '1111 Sycamore St, Springfield, IL', '456-890-1234'),
('Jeff Gold', 'jeff.gold@example.com', '1212 Cherry St, Springfield, IL', '567-901-2345'),
('Janice Bronze', 'janice.bronze@example.com', '1313 Fir St, Springfield, IL', '678-012-3456'),
('Jake Copper', 'jake.copper@example.com', '1414 Spruce St, Springfield, IL', '789-123-4567'),
('Joan Diamond', 'joan.diamond@example.com', '1515 Redwood St, Springfield, IL', '890-234-5678'),
('Jared Silver', 'jared.silver@example.com', '1616 Elm St, Springfield, IL', '901-345-6789'),
('Jill Amber', 'jill.amber@example.com', '1717 Oak St, Springfield, IL', '012-456-7890');

INSERT INTO borrowing_records (book_id, patron_id, borrowing_date) VALUES
(1, 1, '2023-08-01'),
(2, 2, '2023-08-02'),
(3, 3, '2023-08-03'),
(4, 4, '2023-08-04'),
(5, 5, '2023-08-05'),
(6, 6, '2023-08-06'),
(7, 7, '2023-08-07'),
(8, 8, '2023-08-08'),
(9, 9, '2023-08-09'),
(10, 10, '2023-08-10'),
(11, 11, '2023-08-11'),
(12, 12, '2023-08-12'),
(13, 13, '2023-08-13'),
(14, 14, '2023-08-14'),
(15, 15, '2023-08-15'),
(16, 16, '2023-08-16'),
(17, 17, '2023-08-17'),
(18, 18, '2023-08-18'),
(19, 19, '2023-08-19'),
(20, 20, '2023-08-20');



