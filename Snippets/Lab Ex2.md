## To Do: :point_down:

1. Before you start, make sure you have run the [books DB script](#bookssql) on your local machine.

2. Create a Jakarta/Enterprise project in IntelliJ. Make sure that the build system you use is **Maven**. 

3. Open the **POM.xml** and add the following [dependencies](#dependencies) to it.

4. Add a class to your project called [**Title**](#titlejava). This class will act as an entity class (aka a domain class) for your application and will model the structure of the **Titles** table in the DB.

5. Add a class to your project called **TitleDB**. This class will contain three methods. One to connect to the DB, another to disconnect from it and another method to retrieve all records from the _titles_ table. These methods will be called from within your **Servlet**. Check out the proposed signatures for these methods [here](#titledbjava). _These methods are static so they can be invoked using the following systax ClassName.methodName()_

_The strucure of my project is a follows; with seperate packages for the Controller (Servlet) and the Model (Title and TitleDB)_.

![](/images/structure.JPG)

_The desired output is as follows: for every record displayed in the HTML table, highlight in red each cell where the YearPublished is 2019._.

![](/images/table.JPG)

## Snippets



### books.sql 
```sql
CREATE Database IF NOT EXISTS books;
USE books;

CREATE USER 'sduser'@'localhost' IDENTIFIED BY 'pass';GRANT ALL PRIVILEGES ON *.* TO 'sduser'@'localhost' IDENTIFIED BY 'pass' WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0; *

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `books`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllAuthors`()
    READS SQL DATA
SELECT * from authors$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAuthorByID`(IN `id` INT(2))
    READS SQL DATA
SELECT * from authors where AuthorID = id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `authorisbn`
--

CREATE TABLE IF NOT EXISTS `authorisbn` (
  `ISBN` text NOT NULL,
  `AuthorID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorisbn`
--

INSERT INTO `authorisbn` (`ISBN`, `AuthorID`) VALUES
('0-13-010671-2', 1),
('0-13-010671-2', 2),
('0-13-020522-2', 1),
('0-13-020522-2', 2),
('0-13-020522-2', 3),
('0-13-082714-2', 1),
('0-13-082714-2', 2),
('0-13-082925-0', 1),
('0-13-082925-0', 2),
('0-13-082927-7', 1),
('0-13-082927-7', 2),
('0-13-082928-5', 1),
('0-13-082928-5', 2),
('0-13-082928-5', 3),
('0-13-083054-2', 1),
('0-13-083054-2', 2),
('0-13-083055-0', 1),
('0-13-083055-0', 2),
('0-13-118043-6', 1),
('0-13-118043-6', 2),
('0-13-226119-7', 1),
('0-13-226119-7', 2),
('0-13-271974-6', 1),
('0-13-271974-6', 2),
('0-13-456955-5', 1),
('0-13-456955-5', 2),
('0-13-456955-5', 3),
('0-13-528910-6', 1),
('0-13-528910-6', 2),
('0-13-565912-4', 1),
('0-13-565912-4', 2),
('0-13-565912-4', 3),
('0-13-899394-7', 1),
('0-13-899394-7', 2),
('0-13-904947-9', 1),
('0-13-904947-9', 2),
('0-13-904947-9', 3),
('0-13-GSVCPP-x', 1),
('0-13-GSVCPP-x', 2),
('0-13-IWCTC-x', 1),
('0-13-IWCTC-x', 2),
('0-13-IWCTC-x', 3),
('0-13-IWWW-x', 1),
('0-13-IWWW-x', 2),
('0-13-IWWW-x', 3),
('0-13-IWWWIM-x', 1),
('0-13-IWWWIM-x', 2),
('0-13-IWWWIM-x', 3),
('0-13-JAVA3-x', 1),
('0-13-JAVA3-x', 2),
('0-13-JCTC2-x', 1),
('0-13-JCTC2-x', 2);

-- --------------------------------------------------------

--
-- Table structure for table `authors`
--

CREATE TABLE IF NOT EXISTS `authors` (
  `AuthorID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` text,
  `LastName` text,
  `YearBorn` int(11) DEFAULT NULL,
  PRIMARY KEY (`AuthorID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=239997790 ;

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`AuthorID`, `FirstName`, `LastName`, `YearBorn`) VALUES
(1, 'Harvey', 'Deitel', 1946),
(2, 'Paul', 'Deitel', 1968),
(3, 'Tem', 'Nieto', 1969);

-- --------------------------------------------------------

--
-- Table structure for table `publishers`
--

CREATE TABLE IF NOT EXISTS `publishers` (
  `PublisherID` int(11) NOT NULL,
  `PublisherName` text,
  PRIMARY KEY (`PublisherID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `publishers`
--

INSERT INTO `publishers` (`PublisherID`, `PublisherName`) VALUES
(1, 'Prentice Hall'),
(2, 'Prentice Hall PTR');

-- --------------------------------------------------------

--
-- Table structure for table `titles`
--

CREATE TABLE IF NOT EXISTS `titles` (
  `ISBN` text NOT NULL,
  `Title` text NOT NULL,
  `EditionNumber` int(11) NOT NULL,
  `YearPublished` int(11) NOT NULL,
  `PublisherID` int(11) NOT NULL,
  `Price` decimal(10,0) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `titles`
--

INSERT INTO `titles` (`ISBN`, `Title`, `EditionNumber`, `YearPublished`, `PublisherID`, `Price`) VALUES
('0-13-010671-2', 'Java How to Program 2/e and Getting Started with Visual J++ 1.1 Tutorial', 2, 2019, 1, '29'),
('0-13-020522-2', 'Visual Basic 6 How to Program Instructor''s Manual with Solution Disk', 1, 2018, 1, '36'),
('0-13-082714-2', 'C++ How to Program 2/e and Getting Started with Visual C++ 5.0 Tutorial', 2, 2019, 1, '17'),
('0-13-082925-0', 'The Complete C++ Training Course', 2, 1998, 2, '13'),
('0-13-082927-7', 'The Complete Java Training Course', 2, 1997, 2, '30'),
('0-13-082928-5', 'The Complete Visual Basic 6 Training Course', 1, 1999, 2, '21'),
('0-13-083054-2', 'The Complete C++ Training Course 2/e and Getting Started with Visual C++ 5.0 Tutorial', 2, 1998, 1, '25'),
('0-13-083055-0', 'The Complete Java Training Course 2/e and Getting Started with Visual J++ 1.1 Tutorial', 2, 1998, 1, '20'),
('0-13-118043-6', 'C How to Program', 1, 1992, 1, '43'),
('0-13-226119-7', 'C How to Program', 2, 1994, 1, '17'),
('0-13-271974-6', 'Java Multimedia Cyber Classroom', 1, 1996, 2, '25'),
('0-13-456955-5', 'Visual Basic 6 How to Program', 1, 1998, 1, '12'),
('0-13-528910-6', 'C++ How to Program', 2, 1997, 1, '15'),
('0-13-565912-4', 'C++ How to Program Instructor''s Manual with Solutions Disk', 2, 2019, 1, '40'),
('0-13-899394-7', 'Java How to Program', 2, 1997, 1, '49'),
('0-13-904947-9', 'Java How to Program Instructor''s Manual with Solution Disk', 2, 2019, 1, '22'),
('0-13-GSVCPP-x', 'Getting Started with Visual C++ 6 with an Introduction to MFC', 1, 1999, 1, '20'),
('0-13-IWCTC-x', 'The Internet and World Wide Web How to Program Complete Training Course', 1, 1999, 2, '9'),
('0-13-IWWWIM-x', 'Internet and World Wide Web How to Program Instructor''s Manual with Solutions Disk', 1, 2017, 1, '9'),
('0-13-IWWW-x', 'Internet and World Wide Web How to Program', 1, 1999, 1, '20'),
('0-13-JAVA3-x', 'Java How to Program', 3, 1999, 1, '36'),
('0-13-JCTC2-x', 'The Complete Java Training Course', 3, 1999, 2, '20');

```

### Dependencies

```xml
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>8.0.30</version>
</dependency>

<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <version>1.18.24</version>
   <scope>provided</scope>
</dependency>

<!-- You will only need the DBUtil dependency if you intend on using the DBUtil library -->
<dependency>
    <groupId>commons-dbutils</groupId>
    <artifactId>commons-dbutils</artifactId>
    <version>1.7</version>
</dependency>

<!-- This is the dependency you need for JSTL if you are using Tomcat 10 -->
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>2.0.0</version>
</dependency>

<!-- This is the dependency you need for JSTL if you are using Tomcat 9 or earlier -->
<dependency>
   <groupId>javax.servlet</groupId>
   <artifactId>jstl</artifactId>
   <version>1.2</version>
</dependency>

```

### Title.java

```java
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Title {
    private String ISBN;
    private String title;
    private int editionNumber;
    private int yearPublished;
    private int publisherID;
    private double price;
}
```


### TitleDB.java

```java

  public static void connectToDB() { // your code here }  

  public static void disconnectFromDB() { // your code here }

  public static List<Title> getAlltitles() { // your code here }       
       
```
