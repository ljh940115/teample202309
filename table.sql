- ȸ��
create table member(
      userid varchar2(50),
      userpw varchar2(100) not null,
      username varchar2(100) not null,
	  userphone varchar2(30) not null,
      regdate date default sysdate,
      updatedate date default sysdate
);

-- �⺻Ű ���� ���Ǹ� : pk_member_userid, --ȸ���� ���õ� ��� ���� ����
alter table member add constraint pk_member_userid primary key (userid);

-- ȸ������ ���� Ȯ��
insert into member(userid, userpw, username, userphone) values('�׽�Ʈ', '1234', '�׽�Ʈ', '1234');
insert into member(userid, userpw, username, userphone) values('�׽�Ʈ2', '1234', '�׽�Ʈ2', '1234');
insert into member(userid, userpw, username, userphone) values('�׽�Ʈ3', '1234', '�׽�Ʈ3', '1234');
insert into member(userid, userpw, username, userphone) values('�׽�Ʈ4', '1234', '�׽�Ʈ4', '1234');
select * from MEMBER;

- �Խ���
-- �Խ��� �Ϸù�ȣ ����
create sequence seq_board;

create table board (
  bno number(10,0),--�Խñ� ��ȣ
  title varchar2(200) not null,--�Խñ� ����
  content varchar2(2000) not null,--�Խñ� ����
  userid varchar2(50) not null,--�Խñ� �ۼ���
  visitcount number(10) not null,--��ȸ��
  regdate date default sysdate,--�Խñ� ���� �ۼ���
  updatedate date default sysdate--�Խñ� ������
);

-- �⺻Ű ���� ���Ǹ� : pk_board_bno
alter table board add constraint pk_board_bno primary key (bno);
-- ����Ű ���� ���Ǹ� : pk_member_userid
alter table board add constraint fk_member_userid foreign key (userid) references member(userid) on delete cascade;


-- ���� ������ �߰�
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '���� �Խñ� ����', '���� �Խñ� ����', '�׽�Ʈ', 0);
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '���� �Խñ� ����2', '���� �Խñ� ����2', '�׽�Ʈ2', 0);
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '���� �Խñ� ����3', '���� �Խñ� ����3', '�׽�Ʈ3', 0);
insert into board (bno, title, content, userid, visitcount) values (seq_board.nextval, '���� �Խñ� ����4', '���� �Խñ� ����4', '�׽�Ʈ4', 0);
select * from board;


- ���
-- ��� �Ϸù�ȣ ����
create sequence seq_reply;

create table reply (
  rno number(10,0), 
  bno number(10,0) not null,
  reply varchar2(1000) not null,
  replyer varchar2(50) not null, 
  replyDate date default sysdate, 
  updateDate date default sysdate
);

-- ��� �⺻Ű ���� ���Ǹ� : pk_reply_rno
alter table reply add constraint pk_reply_rno primary key (rno);
-- ��� ����Ű ���� ���Ǹ� : fk_reply_board_bno
alter table reply  add constraint fk_reply_board foreign key (bno) references board (bno) on delete cascade; 

insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 2, '����', '�׽�Ʈ2');
insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 2, '����', '�׽�Ʈ2');
insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 3, '����', '�׽�Ʈ3');
insert into reply (rno, bno, reply, replyer) values (seq_reply.nextval, 4, '����', '�׽�Ʈ4');

select userid, userpw, username, userphone from MEMBER where userid='�׽�Ʈ' and userpw='1234';