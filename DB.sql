DROP DATABASE IF EXISTS `crossjoin`;
CREATE DATABASE `crossjoin`;
USE `crossjoin`;
#--------------------------------------------
#--------------------------------------------
#------------member 테이블 관련
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    email CHAR(50) NOT NULL,
    loginPw CHAR(100) NOT NULL,
    authLevel SMALLINT UNSIGNED DEFAULT 3 COMMENT '권한 레벨 (3=일반, 7=관리자)',
    nickname CHAR(20) NOT NULL,
    delStatus TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴 여부 (0=탈퇴 전, 1=탈퇴 후)',
    delDate DATETIME COMMENT '탈퇴 날짜'
);
#--------------------------------------------
DESC `member`;  
SELECT * FROM `member`;

#테스트 데이터
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
email = 'admin@test.com',
loginPw = 'admin',
authLevel = 7,
nickname = '관리자';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
email = 'test1@test.com',
loginPw = 'test1',
authLevel = 3,
nickname = '테스트닉네임1';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
email = 'test2@test.com',
loginPw = 'test2',
authLevel = 3,
nickname = '테스트닉네임2';

#--------------------------------------------
DELETE FROM `member` WHERE id = 7;
#--------------------------------------------
#--------------------------------------------
#------------article 테이블 관련
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    boardGroup ENUM('GENERAL', 'GATHERING'),
    memberId INT UNSIGNED NOT NULL,
    boardId INT UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);
#--------------------------------------------
DESC `article`;
SELECT * FROM `article`;
INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 1',
`body` = '테스트 게시글 내용 1';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 2',
`body` = '테스트 게시글 내용 2';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
boardGroup = 'general',
boardId = 2,
title = '테스트 게시글 제목 3',
`body` = '테스트 게시글 내용 3';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 1,
boardGroup = 'general',
boardId = 2,
title = '테스트 게시글 제목 4',
`body` = '테스트 게시글 내용 4';

INSERT INTO `article`
SET regDate = NOW(),
updateDate = NOW(),
memberId = 2,
boardGroup = 'general',
boardId = 1,
title = '테스트 게시글 제목 5',
`body` = '테스트 게시글 내용 5';

DELETE FROM `article` WHERE id >= 6;
#--------------------------------------------
SELECT *
FROM article
WHERE id = 1
ORDER BY id DESC;
		
SELECT *
FROM article
WHERE boardGroup = 'GENERAL'
ORDER BY id DESC
LIMIT 0, 10;

SELECT COUNT(*)
FROM article
WHERE boardGroup = 'GENERAL';
#--------------------------------------------
#--------------------------------------------
#------------gathering 테이블 관련
CREATE TABLE `gathering`(
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL,
    gatheringStatus ENUM('RECRUITING', 'ONGOING', 'COMPLETED'),
    boardId INT UNSIGNED NOT NULL,
    title CHAR(100) NOT NULL
);

INSERT INTO `gathering`
SET regDate = NOW(),
startDate = '2023-01-01 00:00:00',
endDate = '2023-12-31 23:59:59',
gatheringStatus = 'ONGOING',
boardId = 1001,
title = '모임1';

INSERT INTO `gathering`
SET regDate = NOW(),
startDate = '2023-01-01 00:00:00',
endDate = '2023-12-31 23:59:59',
gatheringStatus = 'ONGOING',
boardId = 1002,
title = '모임2';

INSERT INTO `gathering`
SET regDate = NOW(),
startDate = '2023-01-01 00:00:00',
endDate = '2023-12-31 23:59:59',
gatheringStatus = 'ONGOING',
boardId = 1003,
title = '모임3';
#--------------------------------------------
SELECT * FROM `gathering`;
#--------------------------------------------
#--------------------------------------------
#------------member_gathering 테이블 관련
CREATE TABLE `member_gathering`(
    memberId INT UNSIGNED NOT NULL,
    gatheringId INT UNSIGNED NOT NULL,
    `host` BOOLEAN
);

INSERT INTO `member_gathering`
SET memberId = 1,
gatheringId = 1,
`host` = 1;

INSERT INTO `member_gathering`
SET memberId = 1,
gatheringId = 2,
`host` = 0;

INSERT INTO `member_gathering`
SET memberId = 1,
gatheringId = 3,
`host` = 1;

INSERT INTO `member_gathering`
SET memberId = 2,
gatheringId = 2,
`host` = 1;
#--------------------------------------------
SELECT * FROM `member_gathering`;

SELECT *
FROM member_gathering
WHERE memberId = 1
AND gatheringId = 1;

SELECT COUNT(*)
FROM member_gathering
WHERE memberId = 1
AND gatheringId = 1;