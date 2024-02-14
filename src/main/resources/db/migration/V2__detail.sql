CREATE TABLE exercise_detail (
  exercise_id CHAR(36) NOT NULL,
   created_at datetime NOT NULL,
   origin VARCHAR(20) NOT NULL,
   external_id VARCHAR(20) NULL,
   CONSTRAINT pk_exercise_detail PRIMARY KEY (exercise_id)
);

ALTER TABLE exercise_detail ADD CONSTRAINT FK_EXERCISE_DETAIL_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (exercise_id);