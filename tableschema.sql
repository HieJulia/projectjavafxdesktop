--
-- Table structure for table `face_bio`
--

CREATE TABLE IF NOT EXISTS `face_bio` (
  `id` int(11) NOT NULL,
  `code` int(10) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `reg` int(10) NOT NULL,
  `age` int(10) NOT NULL,
  `section` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




-- create indexes for dump table



--
ALTER TABLE `face_bio`
  ADD PRIMARY KEY (`id`);




-- Modify table
ALTER TABLE `face_bio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;






--- Create database