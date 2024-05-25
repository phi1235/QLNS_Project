-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 25, 2024 lúc 02:42 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `book_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `books`
--

CREATE TABLE `books` (
  `book_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `publisher_id` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE books ADD COLUMN stock INT DEFAULT 0;


--
-- Đang đổ dữ liệu cho bảng `books`
--

INSERT INTO `books` (`book_id`, `title`, `publisher_id`, `publisher`, `author`, `price`) VALUES
('BK001', 'Harry Potter and the Philosopher\'s Stone', 'PB001', 'Bloomsbury Publishing', 'J.K. Rowling', 15.99),
('BK003', 'The Da Vinci Code', 'PB003', 'Doubleday', 'Dan Brown', 13.75),
('BK004', 'The Lord of the Rings', 'PB002', 'Allen & Unwin', 'J.R.R. Tolkien', 17.99),
('BK005', 'A Song of Ice and Firee', 'PB004', 'Bantam Books', 'George R.R. Martin', 18.00),
('BK006', 'The Chronicles of Narnia', 'PB005', 'HarperCollins', 'C.S. Lewis', 11.99),
('BK007', 'The Hunger Gamess', 'PB006', 'Scholastic Corporation', 'Suzanne Collins', 10.00),
('BK008', 'The Alchemist', 'PB007', 'HarperCollins', 'Paulo Coelho', 12.25),
('BK009', 'Gone with the Wind', 'PB008', 'Macmillan Publishers', 'Margaret Mitchell', 14.99),
('BK010', 'The Catcher in the Rye', 'PB009', 'Little, Brown and Company', 'J.D. Salinger', 9.75),
('BK011', 'The Picture of Dorian Gray', 'PB010', 'Ward, Lock & Co', 'Oscar Wilde', 8.99),
('BK012', 'Moby-Dick', 'PB011', 'Richard Bentley', 'Herman Melville', 13.50),
('BK013', 'Jane Eyre', 'PB012', 'Smith, Elder & Co.', 'Charlotte Brontë', 9.75),
('BK014', 'The Adventures of Sherlock Holmes', 'PB013', 'George Newnes', 'Arthur Conan Doyle', 11.25),
('BK015', 'Brave New World', 'PB014', 'Chatto & Windus', 'Aldous Huxley', 11.00),
('BK016', 'Brave New World', 'PB014', 'Chatto & Windus', 'Aldous Huxley', 11.00),
('BK012', 'Moby-Dick', 'PB011', 'Richard Bentley', 'Herman Melville', 14.00),
('BK002', 'The Da Vinci Code', 'PB003', 'Doubleday', 'Dan Brown', 14.00),
('BK0014', 'Harry Potter and the Philosopher\'s Stone', 'PB001', 'Bloomsbury Publishing', 'J.K. Rowling', 16.00);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
