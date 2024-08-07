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
    return_date    DATE NOT NULL,
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
('978-0131166307', 'Effective Java', 'Joshua Bloch'),
('978-0592009205', 'Head First Java', 'Kathy Sierra'),
('978-0133757599', 'Java: The Complete Reference', 'Herbert Schildt'),
('978-0134685991', 'Clean Code', 'Robert C. Martin'),
('978-0135166308', 'Design Patterns', 'Erich Gamma'),
('978-0136350884', 'Introduction to Algorithms', 'Thomas H. Cormen'),
('978-0207633610', 'Refactoring', 'Martin Fowler'),
('978-0598007737', 'Head First Design Patterns', 'Eric Freeman'),
('978-0329356680', 'Java Concurrency in Practice', 'Brian Goetz'),
('978-0132675191', 'Spring in Action', 'Craig Walls'),
('978-0596009206', 'Effective Java', 'Joshua Bloch'),
('978-0131177355', 'Modern Operating Systems', 'Andrew S. Tanenbaum'),
('978-0133035401', 'Java Performance: The Definitive Guide', 'Scott Oaks'),
('978-0134454512', 'Pro Spring Boot 2', 'Felipe Gutierrez'),
('978-0134685671', 'Spring Boot in Action', 'Craig Walls'),
('978-0596007738', 'Head First Servlets and JSP', 'Bert Bates'),
('978-0132350884', 'Algorithms', 'Robert Sedgewick'),
('978-0112350883', 'Advanced Programming in the UNIX Environment', 'W. Richard Stevens'),
('978-0132166117', 'Java: A Beginner’s Guide', 'Herbert Schildt'),
('978-0124685922', 'Java SE 8 for the Really Impatient', 'Cay S. Horstmann');


INSERT INTO patron (name, phone, email, address) VALUES
('Alice Johnson', '555-1234', 'alice.johnson@example.com', '123 Elm St, Springfield'),
('Bob Smith', '555-5678', 'bob.smith@example.com', '456 Oak St, Springfield'),
('Carol Williams', '555-8765', 'carol.williams@example.com', '789 Pine St, Springfield'),
('David Brown', '555-4321', 'david.brown@example.com', '321 Maple St, Springfield'),
('Eve Davis', '555-6789', 'eve.davis@example.com', '654 Birch St, Springfield'),
('Frank Miller', '555-9876', 'frank.miller@example.com', '987 Cedar St, Springfield'),
('Grace Wilson', '555-1357', 'grace.wilson@example.com', '246 Elm St, Springfield'),
('Hannah Moore', '555-24patron60', 'hannah.moore@example.com', '135 Oak St, Springfield'),
('Ivy Taylor', '555-3570', 'ivy.taylor@example.com', '864 Pine St, Springfield'),
('Jack Anderson', '555-4681', 'jack.anderson@example.com', '579 Maple St, Springfield'),
('Kathy Lee', '555-5792', 'kathy.lee@example.com', '908 Birch St, Springfield'),
('Leo Martinez', '555-6803', 'leo.martinez@example.com', '741 Cedar St, Springfield'),
('Mia Thompson', '555-7914', 'mia.thompson@example.com', '852 Elm St, Springfield'),
('Noah Harris', '555-8025', 'noah.harris@example.com', '963 Oak St, Springfield'),
('Olivia Clark', '555-9136', 'olivia.clark@example.com', '147 Pine St, Springfield'),
('Paul Walker', '555-0247', 'paul.walker@example.com', '258 Maple St, Springfield'),
('Quinn Lewis', '555-1358', 'quinn.lewis@example.com', '369 Birch St, Springfield'),
('Riley Robinson', '555-2469', 'riley.robinson@example.com', '741 Cedar St, Springfield'),
('Sophie Young', '555-3571', 'sophie.young@example.com', '852 Elm St, Springfield'),
('Thomas Allen', '555-4682', 'thomas.allen@example.com', '963 Oak St, Springfield');

INSERT INTO borrowing_records (book_id, patron_id, return_date, borrowing_date) VALUES
(1, 1, '2024-08-15', '2024-08-01'),
(2, 2, '2024-08-20', '2024-08-05'),
(3, 3, '2024-08-25', '2024-08-10'),
(4, 4, '2024-08-30', '2024-08-15'),
(5, 5, '2024-09-05', '2024-08-20'),
(6, 6, '2024-09-10', '2024-08-25'),
(7, 7, '2024-09-15', '2024-09-01'),
(8, 8, '2024-09-20', '2024-09-05'),
(9, 9, '2024-09-25', '2024-09-10'),
(10, 10, '2024-09-30', '2024-09-15'),
(11, 11, '2024-10-05', '2024-09-20'),
(12, 12, '2024-10-10', '2024-09-25'),
(13, 13, '2024-10-15', '2024-10-01'),
(14, 14, '2024-10-20', '2024-10-05'),
(15, 15, '2024-10-25', '2024-10-10'),
(16, 16, '2024-10-30', '2024-10-15'),
(17, 17, '2024-11-04', '2024-10-20'),
(18, 18, '2024-11-09', '2024-10-25'),
(19, 19, '2024-11-14', '2024-11-01'),
(20, 20, '2024-11-19', '2024-11-05');



