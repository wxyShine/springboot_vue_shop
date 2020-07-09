-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2020-01-21 17:32:16
-- 服务器版本： 5.5.57-log
-- PHP Version: 5.4.45

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- 表的结构 `s_menu`
--

CREATE TABLE IF NOT EXISTS `s_menu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT '0',
  `path` varchar(255) DEFAULT NULL,
  `queue` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `s_menu`
--

INSERT INTO `s_menu` (`id`, `name`, `parent_id`, `path`, `queue`) VALUES
(1, '用户管理', 0, 'users', 1),
(2, '用户列表', 1, 'users', 0),
(3, '权限管理', 0, 'rights', 2),
(4, '角色管理', 3, 'roles', 0),
(5, '权限列表', 3, 'rights', 0),
(6, '商品管理', 0, 'goods', 3),
(7, '商品列表', 6, 'goods', 0),
(8, '分类参数', 6, 'params', 0),
(9, '商品分类', 6, 'categories', 0),
(10, '订单管理', 0, 'orders', 4),
(11, '订单列表', 10, 'orders', 0),
(12, '数据统计', 0, 'reports', 5),
(13, '统计报表', 12, 'reports', 0);

-- --------------------------------------------------------

--
-- 表的结构 `s_rights`
--

CREATE TABLE IF NOT EXISTS `s_rights` (
  `id` int(11) NOT NULL,
  `auth_name` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `s_rights`
--

INSERT INTO `s_rights` (`id`, `auth_name`, `level`, `path`, `pid`) VALUES
(1, '商品管理', '0', 'goods', 0),
(2, '订单管理', '0', 'orders', 0),
(3, '权限管理', '0', 'rights', 0),
(4, '用户管理', '0', 'users', 0),
(5, '数据统计', '0', 'reports', 0),
(6, '商品列表', '1', 'goods', 1),
(7, '分类参数', '1', 'params', 1),
(8, '商品分类', '1', 'categories', 1),
(9, '添加商品', '2', 'goods', 6),
(10, '商品修改', '2', 'goods', 6),
(11, '商品删除', '2', 'goods', 6),
(12, '更新商品图片', '2', 'goods', 6),
(13, '更新商品属性', '2', 'goods', 6),
(14, '更新商品状态', '2', 'goods', 6),
(15, '获取商品详情', '2', 'goods', 6),
(16, '获取参数列表', '2', 'params', 7),
(17, '创建商品参数', '2', 'params', 7),
(18, '删除商品参数', '2', 'params', 7),
(19, '添加分类', '2', 'categories', 8),
(20, '删除分类', '2', 'categories', 8),
(21, '获取分类详情', '2', 'categories', 8);

-- --------------------------------------------------------

--
-- 表的结构 `s_role`
--

CREATE TABLE IF NOT EXISTS `s_role` (
  `id` int(11) NOT NULL,
  `d_esc` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `s_role`
--

INSERT INTO `s_role` (`id`, `d_esc`, `name`) VALUES
(1, '管理员', '管理员'),
(2, '普通', '普通用户');

-- --------------------------------------------------------

--
-- 表的结构 `s_role_right`
--

CREATE TABLE IF NOT EXISTS `s_role_right` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `right_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `s_role_right`
--

INSERT INTO `s_role_right` (`id`, `role_id`, `right_id`) VALUES
(1, 1, 1),
(2, 1, 6),
(3, 1, 7),
(4, 2, 1);

-- --------------------------------------------------------

--
-- 表的结构 `s_user`
--

CREATE TABLE IF NOT EXISTS `s_user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `mg_state` bit(1) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `rid` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- 转存表中的数据 `s_user`
--

INSERT INTO `s_user` (`id`, `email`, `mg_state`, `name`, `password`, `tel`, `username`, `rid`) VALUES
(1, 'wxyrrcj@gmail.com', b'0', '若如初见', '3579c5bed0f11113ebfbbcfb9371eeb5', '1566666666', 'wxy', NULL),
(3, '11aa@qq.com', b'0', '啊啊', '啊 啊啊啊1', ' 啊啊', '啊啊', NULL),
(4, '123@qq.com', b'0', '123', '123', '123', '添加测试', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `s_menu`
--
ALTER TABLE `s_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `s_rights`
--
ALTER TABLE `s_rights`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `s_role`
--
ALTER TABLE `s_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `s_role_right`
--
ALTER TABLE `s_role_right`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK33j8vu3m6ps0gdq1yofaeaol7` (`right_id`),
  ADD KEY `FKopajvv2w93mnwwwerf72w8h6m` (`role_id`);

--
-- Indexes for table `s_user`
--
ALTER TABLE `s_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb66umb8i6jord32jk70vmbsqd` (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `s_menu`
--
ALTER TABLE `s_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `s_rights`
--
ALTER TABLE `s_rights`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `s_role`
--
ALTER TABLE `s_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `s_role_right`
--
ALTER TABLE `s_role_right`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `s_user`
--
ALTER TABLE `s_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- 限制导出的表
--

--
-- 限制表 `s_role_right`
--
ALTER TABLE `s_role_right`
  ADD CONSTRAINT `FK33j8vu3m6ps0gdq1yofaeaol7` FOREIGN KEY (`right_id`) REFERENCES `s_rights` (`id`),
  ADD CONSTRAINT `FKopajvv2w93mnwwwerf72w8h6m` FOREIGN KEY (`role_id`) REFERENCES `s_role` (`id`);

--
-- 限制表 `s_user`
--
ALTER TABLE `s_user`
  ADD CONSTRAINT `FKb66umb8i6jord32jk70vmbsqd` FOREIGN KEY (`rid`) REFERENCES `s_role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
