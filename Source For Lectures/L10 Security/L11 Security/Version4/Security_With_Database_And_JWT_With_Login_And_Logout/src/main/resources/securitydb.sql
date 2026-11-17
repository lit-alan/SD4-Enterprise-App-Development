create database securitydb;
use securitydb;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `securitydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `refresh_token`
--

CREATE TABLE `refresh_token` (
                                 `id` bigint(20) NOT NULL,
                                 `token` varchar(255) NOT NULL,
                                 `expiry_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                                 `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `refresh_token`
--

INSERT INTO `refresh_token` (`id`, `token`, `expiry_date`, `user_id`) VALUES
                                                                          (15, '6d43401c-07ec-4747-89f5-db1b3ea805f5', '2025-02-23 19:32:14', 2),
                                                                          (16, '150def2b-9b14-4091-8cc3-d70da9a24375', '2025-02-23 19:32:33', 2),
                                                                          (17, '6f9c374b-c314-4b85-8b5e-17531e45e5dd', '2025-02-23 19:42:40', 2),
                                                                          (18, 'dca57e25-d222-4e4c-8ed2-9d63224b4d3d', '2025-02-23 19:43:19', 2),
                                                                          (19, '2f4dd847-27fc-466a-a27a-8308772c7d6d', '2025-02-23 19:51:18', 2),
                                                                          (21, '02294d6c-9979-4a73-8690-cf00dce41e6d', '2025-02-23 19:57:51', 2),
                                                                          (22, '10fdd243-345e-41b3-8f1b-87ecc0338a07', '2025-02-23 20:01:03', 2),
                                                                          (24, 'ebbf9a8b-cc4c-4ac5-861c-ba7e654745da', '2025-02-23 20:30:42', 2),
                                                                          (25, '1a232b51-e6d5-4fc2-800d-1c46f1ba39ec', '2025-02-23 21:44:22', 2),
                                                                          (26, '53f9ebd8-5985-4d70-b832-1c7b74e0360c', '2025-02-23 21:50:56', 2),
                                                                          (27, 'c088613a-7206-479c-83a7-880e7b6b42a0', '2025-02-23 21:51:27', 2),
                                                                          (28, '55d39082-1de9-4dab-a94b-6246b73de68a', '2025-02-23 21:51:49', 2),
                                                                          (29, '777df6c0-d14e-48dc-8cc7-778c2f6f501b', '2025-02-23 21:52:04', 2),
                                                                          (30, 'b67c2888-9d09-4746-9d00-20ef00889896', '2025-02-23 21:52:07', 2),
                                                                          (31, '118a2ce2-ad19-4b76-8035-b27c05b9d7a9', '2025-02-23 21:52:08', 2),
                                                                          (32, '56492941-978e-4725-abcd-e15b2bde45dc', '2025-02-23 21:52:12', 2),
                                                                          (33, '2ef38e6e-e70d-42bb-9474-8cf31fc308fb', '2025-02-23 21:52:13', 2),
                                                                          (34, '5f2da2ed-a12e-4de6-9018-142d55064341', '2025-02-23 21:52:20', 2),
                                                                          (35, 'ce2e25b2-c014-4aa7-b663-5a304a2667e6', '2025-02-23 21:52:22', 2),
                                                                          (36, '98ae722f-9a11-4dd2-8604-ba80ac74de36', '2025-02-23 21:52:24', 2),
                                                                          (37, '0daf8105-8bde-4166-81b3-ec22e61bdfa9', '2025-02-23 21:52:26', 2),
                                                                          (38, '00d50d49-32cb-452c-bb32-a492a0643872', '2025-02-24 11:04:05', 2),
                                                                          (40, '9e07ecae-eee3-46cb-af05-4f739a3d5cc2', '2025-02-24 11:17:41', 2),
                                                                          (41, 'f472703e-98e7-4c2e-8e92-6bfa6450965f', '2025-02-24 11:41:23', 2);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
                         `id` bigint(20) NOT NULL,
                         `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
                                       (2, 'ADMIN'),
                                       (1, 'CUSTOMER');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
                         `user_id` int(11) NOT NULL,
                         `first_name` varchar(100) NOT NULL,
                         `last_name` varchar(100) NOT NULL,
                         `email` varchar(150) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `phone` varchar(20) DEFAULT NULL,
                         `created_at` datetime DEFAULT current_timestamp(),
                         `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
                         `secret_key` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `email`, `password`, `phone`, `created_at`, `updated_at`, `secret_key`) VALUES
    (1, 'Sean', 'O\'Brien', 'sean.obrien@hotmail.com', '$2a$10$oEOtxZC.RmLoxxrkqCcuFerCYLc7o8AGwUUcmu0w50dEDDTWx7jVa', '086 123 4567', '2024-09-16 10:43:50', '2025-02-07 16:26:50', NULL),
(2, 'Aoife', 'Murphy', 'aoife_murphy78@gmail.com', '$2a$10$Y6QEkJNBL9qDsyy30/yWH.6bGNZ6yGjJgA3WeVq/hagbmwkOiUMxm', '089 234 5678', '2024-09-16 10:43:50', '2025-02-07 16:26:50', 'TKTWUKQVFX2D47L6J67VW7XEKMYQUNO3'),
(3, 'Patrick', 'Ryan', 'paddy_ry@outlook.com', '$2a$10$J/c.3pyyZUxEpqYCI0orde7Xr9dmgWsME7DZCGUeQXhiHBYIlwpnu', '087 345 6789', '2024-09-16 10:43:50', '2025-02-10 15:48:54', NULL),
(4, 'Emma', 'Doyle', 'emma.doyle@eircom.ie', '$2a$10$B.STii5/ITAixS1FdIIhOOZMsQtTXxr1j6cFCYKd6WwvP0R75L1C2', '089 456 7890', '2024-09-16 10:43:50', '2025-02-07 16:26:50', NULL),
(5, 'Ciarán', 'O\'Connor', 'coconnor@gmail.com', '$2a$10$sLQMfac9DboFKN5fyzXd4O2QglmvhtQhX8DPR6XOJbpK2pADJ9yoq', '089 567 8901', '2024-09-16 10:43:50', '2025-02-07 16:26:50', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
                              `user_id` int(11) NOT NULL,
                              `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
                                                    (1, 1),
                                                    (2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `refresh_token`
--
ALTER TABLE `refresh_token`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `token` (`token`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
    ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `user_roles_ibfk_2` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `refresh_token`
--
ALTER TABLE `refresh_token`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
    MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `refresh_token`
--
ALTER TABLE `refresh_token`
    ADD CONSTRAINT `refresh_token_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
    ADD CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
