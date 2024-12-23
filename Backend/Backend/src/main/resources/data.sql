drop table if exists account;
drop table if exists message;
drop table if exists likes;
drop table if exists comment;
drop table if exists follow;

create table account (
    accountId int primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255),
    followId int auto_increment
);
create table message (
    messageId int primary key auto_increment,
    postedBy int,
    messageText varchar(255),
    timePostedEpoch bigint,
    foreign key (postedBy) references account(accountId)
);

create table likes(
    likeId int primary key auto_increment,
    accountLikes int,
    messageLikes int,
    foreign key (accountLikes) references account(accountId),
    foreign key (messageLikes) references message(messageId)
);

create table comment(
    commentId int primary key auto_increment,
    sentBy int,
    replyTo int,
    commentText varchar(255)
    foreign key (sentBy) references account(accountId),
    foreign key (replyTo) references message(messageId)
)

create table follow(
    --needs a foreign key that references accountId
    followId int primary key auto_increment,
    followerId int,
    followedId int,
    foreign key (followerId) references account(accountId),
    foreign key (followedId) references account(accountId) 
)

-- Starting test values with ids of 9999 to avoid test issues
insert into account values (9999, 'testuser1', 'password');
insert into account values (9998, 'testuser2', 'password');
insert into account values (9997, 'testuser3', 'password');
insert into account values (9996, 'testuser4', 'password');

insert into message values (9999, 9999,'test message 1',1669947792);
insert into message values (9997, 9997,'test message 2',1669947792);
insert into message values (9996, 9996,'test message 3',1669947792);