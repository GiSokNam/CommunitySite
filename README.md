## 프로젝트 소개
- 학습을 진행 후 커뮤니티 사이트를 만들어보면서 부족한 부분을 알아가고 다시 학습 및 정리를 위한 프로젝트입니다.

### 개발환경
- IntelliJ IDEA Community Edition 2023.3.3
- Amazon Corretto 21
- H2 database 2.2.224
- Spring Boot 3.2.3
- Mybatis Framework 3.0.3
- Thymeleaf

## dependencies
- Spring Web
- Lombok
- Thymeleaf
- MyBatis Framework
- h2 database
- Validation
- Spring Security

### 프로젝트 구성
- 메인 페이지
- 회원
  - 회원가입 페이지
  - 프로필
  - 계정관리
  - 활동내역
  - 로그아웃
- 게시판
  - Q&A
  - 지식
  - 커뮤니티
  - 이벤트
  - 공지사항

### 회원가입 기능
- 회원가입
- 회원정보 수정
- 회원 탈퇴

### 게시판 기능
- 게시글 등록/ 수정/ 삭제
- 게시글 검색 기능
- 게시글 좋아요/ 싫어요
- 게시글 좋아요 갯수 표시
- 게시글 페이징 처리
- 게시글 댓글 등록/ 수정/ 삭제
- 게시글 댓글 갯수 표시
- 게시글 추천

### 프로젝트 구조
- config
  - SecurityConfig
- domain
  - QuestionBoard
  - knowledgeBoard
  - BulletinBoard
  - EventBoard
  - NoticeBoard
  - Comment
  - AmityUser
- controller
  - QuestionBoardController
  - knowledgeBoardController
  - BulletinBoardController
  - EventBoardController
  - NoticeBoardController
  - AmityUserController
- service
  - QuestionBoardService
  - knowledgeBoardService
  - BulletinBoardService
  - EventBoardService
  - NoticeBoardService
  - AmityUserService
- repository
  - amityuser
    - AmityUserMapper
    - AmityUserRepository
  - question
    - QuestionBoardMapper
    - QuestionBoardRepository
  - knowledge
    - knowledgeBoardMapper
    - knowledgeBoardRepository
  - bulletin
    - BulletinBoardMapper
    - BulletinBoardRepository
  - event
    - EventBoardMapper
    - EventBoardRepository
  - notice
    - NoticeBoardMapper    
    - NoticeBoardRepository
- mapper
  - QuestionBoardMapper.xml
  - knowledgeBoardMapper.xml
  - BulletinBoardMapper.xml
  - EventBoardMapper.xml
  - NoticeBoardMapper.xml
  - AmityUserMapper.xml


### DB sql
```
-- 게시판 테이블
drop table if exists question CASCADE;
create table question (
    id bigint auto_increment primary key,
    content varchar(500),
    create_date timestamp,
    modify_date timestamp,
    subject varchar(200),
    author_id bigint,
    foreign key (author_id) references amityuser(id)
);

-- 게시판 좋아요 테이블
drop table if exists question_voter CASCADE;
create table question_voter (
    question_id bigint not null,
    voter_id bigint not null,
    primary key (question_id, voter_id),
    foreign key (question_id) references question(id),
    foreign key (voter_id) references amityuser(id)
);

-- 댓글 테이블
drop table if exists answer CASCADE;
create table answer (
    id bigint auto_increment primary key,
    content varchar(500),
    create_date timestamp,
    modify_date timestamp,
    author_id bigint,
    question_id bigint,
    foreign key (author_id) references amityuser(id),
    foreign key (question_id) references question(id)
);

-- 댓글 좋아요 테이블
drop table if exists answer_voter CASCADE;
create table answer_voter (
    question_id bigint not null,
    voter_id bigint not null,
    primary key (question_id, voter_id),
    foreign key (question_id) references question(id),
    foreign key (voter_id) references amityuser(id)
);

-- 회원 테이블
drop table if exists AmityUser CASCADE;
create table AmityUser (
    id bigint auto_increment primary key,
    email varchar(255) unique,
    password varchar(255),
    username varchar(255) unique
);
```