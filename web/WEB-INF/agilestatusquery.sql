-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-06-11 14:40:02
-- 服务器版本： 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agilestatusquery`
--

-- --------------------------------------------------------

--
-- 表的结构 `tb_info`
--

CREATE TABLE `tb_info` (
  `id` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jobConfId` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `arguments` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='标注每一条查询';

--
-- 转存表中的数据 `tb_info`
--

INSERT INTO `tb_info` (`id`, `name`, `jobConfId`, `arguments`) VALUES
(1, '第一条查询', '778153', '{\"jobConfId\":\"778153\",\"jobName\":\"编译\",\"status\":\"SUCC\",\"startTime\":\"2018-06-07 19:34:01\",\"endTime\":\"2018-06-07 19:38:34\",\"duration\":\"4m33s\",\"triggerUser\":\"wangcaixia01\"}'),
(2, '第二条记录', '803611', '{\"jobConfId\":\"803611\",\"jobName\":\"猫头鹰源码安全扫描\",\"status\":\"CANCEL\",\"startTime\":\"2018-06-07 19:38:35\",\"endTime\":\"2018-06-07 19:50:48\",\"duration\":\"12m13s\",\"triggerUser\":\"wangcaixia01\"}'),
(3, '第三条查询', '803611,778153', '[{\"jobConfId\":\"778153\",\"jobName\":\"编译\",\"status\":\"SUCC\",\"startTime\":\"2018-06-07 19:34:01\",\"endTime\":\"2018-06-07 19:38:34\",\"duration\":\"4m33s\",\"triggerUser\":\"wangcaixia01\"},{\"jobConfId\":\"803611\",\"jobName\":\"猫头鹰源码安全扫描\",\"status\":\"CANCEL\",\"startTime\":\"2018-06-07 19:38:35\",\"endTime\":\"2018-06-07 19:50:48\",\"duration\":\"12m13s\",\"triggerUser\":\"wangcaixia01\"}]');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_info`
--
ALTER TABLE `tb_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `jobConfId` (`jobConfId`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `tb_info`
--
ALTER TABLE `tb_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
