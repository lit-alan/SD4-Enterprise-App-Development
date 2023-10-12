
## To Do: :grimacing:

*Before you start, make sure you have run the [books DB script](#bookssql) on your local machine*

1. &nbsp;Create an Enterprise project deployed on Tomcat 9.0.67.

2. &nbsp;When creating the project, ensure that you :white_check_mark: **Persistence JPA** from the *Specifications* list and :white_check_mark: **Eclipse Link** from the *Implementations* list. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; *this will ensure the dependencies for JPA and Eclipse Link will be added to your POM when the project is created.*

3. &nbsp;Add a [Dependency](#mysql-dependency-for-pom) for MySQL to the POM. Alternatively, press *alt+insert* to open the context menu and from there select *add dependency*. In the *dependency tool window* search for the dependency (MySQL) and then *add* it to your POM.

4. &nbsp;Create a connection to the Books DB within the IDE.

5. &nbsp;Note that a Persistence Unit (PU) has been added to the project. The name of this PU is *default*. You can change this if you like or add further PU's to the same project.

4. &nbsp;Add a class called [DBUtil](#dbutiljava) to your project.

5. &nbsp;Add a Servlet to your project.

6. &nbsp;Generate an (*Author*) entity class from DB for the *authors* table.

7. &nbsp;Add an *AuthorDB* class to your project.

8. &nbsp;Add a method to [retrieve an *Author* object by id](#getauthorbyid) to the *AuthorDB* class

9. &nbsp;Add a call to the Servlet to test this method and print the object it returns to the browser.

10. &nbsp;Add a method to [retrieve a list of *Author* objects](#getallauthors) to the *AuthorDB* class

11. &nbsp;Add a call to the Servlet to test this method and print the list it returns to the browser.

12. &nbsp;Add a method to [update an *Author* object](#updateauthor)  to the *AuthorDB* class

13. &nbsp;Update an *Author* object in the Servlet. Pass object to updateAuthor method in the *AuthorDB* class.

14. &nbsp;Add a method to [insert an *Author* object](#insertauthor)  to the *AuthorDB* class

15. &nbsp;Create an *Author* object in the Servlet. Pass object to insertAuthor method in the *AuthorDB* class.

## Snippets

### books.sql 
```sql
CREATE Database IF NOT EXISTS books;
USE books;

CREATE USER 'sduser'@'localhost' IDENTIFIED BY 'pass';GRANT ALL PRIVILEGES ON *.* TO 'sduser'@'localhost' IDENTIFIED BY 'pass' WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0; 

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
('0-13-010671-2', 'Java How to Program 2/e and Getting Started with Visual J++ 1.1 Tutorial', 2, 1998, 1, '29'),
('0-13-020522-2', 'Visual Basic 6 How to Program Instructor''s Manual with Solution Disk', 1, 1999, 1, '36'),
('0-13-082714-2', 'C++ How to Program 2/e and Getting Started with Visual C++ 5.0 Tutorial', 2, 1998, 1, '17'),
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
('0-13-565912-4', 'C++ How to Program Instructor''s Manual with Solutions Disk', 2, 1998, 1, '40'),
('0-13-899394-7', 'Java How to Program', 2, 1997, 1, '49'),
('0-13-904947-9', 'Java How to Program Instructor''s Manual with Solution Disk', 2, 1997, 1, '22'),
('0-13-GSVCPP-x', 'Getting Started with Visual C++ 6 with an Introduction to MFC', 1, 1999, 1, '20'),
('0-13-IWCTC-x', 'The Internet and World Wide Web How to Program Complete Training Course', 1, 1999, 2, '9'),
('0-13-IWWWIM-x', 'Internet and World Wide Web How to Program Instructor''s Manual with Solutions Disk', 1, 1999, 1, '9'),
('0-13-IWWW-x', 'Internet and World Wide Web How to Program', 1, 1999, 1, '20'),
('0-13-JAVA3-x', 'Java How to Program', 3, 1999, 1, '36'),
('0-13-JCTC2-x', 'The Complete Java Training Course', 3, 1999, 2, '20');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


```


### mysql dependency for POM
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.30</version>
</dependency>
```
### DBUtil.java 
```java

public class DBUtil {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
    
}
```

### getAuthorById
```java
public static Author getAuthorById(int id) {

        //get em
        EntityManager em = DBUtil.getEmf().createEntityManager();

        Author a = em.find(Author.class, id);

        em.close();

        return a;

    }//end getAuthorById
```

### getAllAuthors
```java
public static List<Author> getAllAuthors() {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        String q = "SELECT a from Author a"; //a JPQL query
        
        TypedQuery<Author> tq = em.createQuery(q, Author.class);
                
        List<Author> list;
        
        try {
            list = tq.getResultList();
            
            if (list == null || list.isEmpty())
                list = null;
            
        }
        finally {
            em.close();
        }

        return list;
        
    }//end getAllAuthors
 ``` 
 
 ### updateAuthor
```java
public static void updateAuthor(Author a) {

        EntityManager em = DBUtil.getEmf().createEntityManager();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(a);
            trans.commit();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

    }//end updateAuthor
   ```
     
 ### insertAuthor
```java
    public static void insertAuthor(Author a ) {
        
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(a);
            trans.commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
            em.close();
        }  
        
    }//end insertAuthor()
   
   ```
   
   ### Set POM repo to HTTPS
   ```xml
 <repositories>
   <repository>
      <id>Central Maven repository</id>
      <name>Central Maven repository https</name>
      <url>https://repo.maven.apache.org/maven2</url>
   </repository>
</repositories>
```
