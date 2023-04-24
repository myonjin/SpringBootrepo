INSERT INTO article( title, content) VALUES('가가가가', '1111');
INSERT INTO article(title, content) VALUES('나나나나', '2222');
INSERT INTO article(title, content) VALUES('다다다다', '3333');

--article 더미 데이터
INSERT INTO article(id, title, content) VALUES (4,'당신의 인생 영화는 ?', '1111');
INSERT INTO article(id, title, content) VALUES (5,'당신의 ㅁㅁㅁㅁ ?', '2222');
INSERT INTO article(id, title, content) VALUES (6,'당신의 ㅋㅋㅋㅋ ?', '3333');

--4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'park', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'kim', '아이 엠 셈');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'choi', '쇼생크 탈출');

INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'park', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'kim', '아이 엠 셈');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'choi', '쇼생크 탈출');

INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'park', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'kim', '아이 엠 셈');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'choi', '쇼생크 탈출');

