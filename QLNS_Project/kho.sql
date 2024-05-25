-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 25, 2024 lúc 06:05 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

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
-- Cấu trúc bảng cho bảng `kho`
--

CREATE TABLE `kho` (
  `masach` varchar(255) NOT NULL,
  `tensach` varchar(255) NOT NULL,
  `tacgia` varchar(255) NOT NULL,
  `soluongtonkho` int(11) NOT NULL,
  `chuthich` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `kho`
--

INSERT INTO `kho` (`masach`, `tensach`, `tacgia`, `soluongtonkho`, `chuthich`) VALUES
('BK001', 'Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling', 77, 'Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts. Even as he escapes a dreary life and enters a world of magic, he finds trouble awaiting him.'),
('BK0010', 'The Catcher in the Rye', 'J.D. Salinger\r\n', 76, 'sach van hoc'),
('BK0011', 'The Picture of Dorian Gray', 'Oscar Wilde\r\n', 45, 'sach van hoc'),
('BK0012', 'Moby-Dick', 'Herman Melville\r\n', 54, 'sach van hoc'),
('BK0013', 'Jane Eyre\r\n', 'Charlotte Brontë\r\n', 43, 'sach van hoc'),
('BK0014', 'The Adventures of Sherlock Holmes\r\n', 'Arthur Conan Doyle\r\n', 32, 'sach trinh tham'),
('BK0015', 'Brave New World\r\n', 'Aldous Huxley\r\n', 24, 'sach trinh tham'),
('BK002', 'The Da Vinci Code', 'Dan Brown', 77, 'sach van hoc'),
('BK003', 'The Da Vinci Code', 'Dan Brown', 77, 'sach van hoc'),
('BK004', 'The Lord of the Rings', 'J.R.R. Tolkien', 77, 'sach vien tuong phieu luu'),
('BK005', 'A Song of Ice and Firee', 'George R.R. Martin\r\n', 77, 'sach vien tuong phieu luu'),
('BK006', 'The Chronicles of Narnia', 'C.S. Lewis', 88, 'sach vien tuong phieu luu'),
('BK007', 'The Hunger Gamess', 'Suzanne Collins', 8, 'sach sinh ton phieu luu'),
('BK008', 'The Alchemist', 'Paulo Coelho', 67, 'khoa hoc vien tuong'),
('BK009', 'Gone with the Wind', 'Margaret Mitchell', 65, 'sach van hoc');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`masach`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
