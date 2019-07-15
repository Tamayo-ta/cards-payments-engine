

--
-- Database: `app-cards`
--
CREATE SCHEMA appCards AUTHORIZATION sa;

-- --------------------------------------------------------

--
-- Table structure for table `Card`
--

CREATE TABLE `Card` (
  `Id` bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `Country` varchar(2) NOT NULL,
  `Status` int(11) NOT NULL,
  `OwnerId` int(11) NOT NULL,
  `Number` bigint(20) UNIQUE NOT NULL,
  `Cvv` smallint(6) NOT NULL,
  `Pin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;



