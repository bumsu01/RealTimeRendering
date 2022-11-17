
DROP TABLE IF EXISTS member;
CREATE TABLE member COMMENT '회원' (
      id                bigint  generated by default as identity COMMENT '회원 ID'
    , name              VARCHAR(100)          COMMENT '회원 명'
    , tel               VARCHAR(100)          COMMENT '전화번호'
    , password          VARCHAR(100)          COMMENT '비밀번호'
    , price             bigint                COMMENT '잔액'
    , delete_flag       int                   COMMENT '삭제 여부 : 0 not delete ; 1 delete'
    , create_time       date                  COMMENT 'create_time'
    , update_time       date                  COMMENT 'update_time'
    , create_id         bigint                COMMENT 'create_id'
    , update_id         bigint                COMMENT 'update_id'
    , primary key (id)
);

DROP TABLE IF EXISTS stock;
CREATE TABLE stock COMMENT '종목' (
      id                bigint generated by default as identity COMMENT '종목 ID'
    , code              VARCHAR(100)          COMMENT '종목 코드'
    , name              VARCHAR(100)          COMMENT '종목 명'
    , start_price       bigint                COMMENT '개시 가격'
    , now_price         bigint                COMMENT '현재 가격'
    , end_price         bigint                COMMENT '마지막 가격'
    , view_count        integer               COMMENT '조회수'
    , trade_count       bigint                COMMENT '거래량'
    , delete_flag       int                   COMMENT '삭제 여부 : 0 not delete ; 1 delete'
    , create_time       date                  COMMENT 'create_time'
    , update_time       date                  COMMENT 'update_time'
    , create_id         bigint                COMMENT 'create_id'
    , update_id         bigint                COMMENT 'update_id'
    , primary key (id)
);

DROP TABLE IF EXISTS trade_history;
CREATE TABLE trade_history COMMENT '거래 기록' (
      id                bigint generated by default as identity COMMENT '거래 기록 ID'
    , member_id         bigint                COMMENT '회원 id'
    , stock_id        bigint                COMMENT '종목 id'
    , trade_price       bigint                COMMENT '거래 금액'
    , delete_flag       int                   COMMENT '삭제 여부 : 0 not delete ; 1 delete'
    , create_time       date                  COMMENT 'create_time'
    , update_time       date                  COMMENT 'update_time'
    , create_id         bigint                COMMENT 'create_id'
    , update_id         bigint                COMMENT 'update_id'
    , primary key (id)
    );
