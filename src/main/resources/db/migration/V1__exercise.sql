CREATE TABLE exercise (
  exercise_id CHAR(36) NOT NULL,
   person_id CHAR(36) NOT NULL,
   datetime datetime NOT NULL,
   type VARCHAR(20) NOT NULL,
   minutes DOUBLE NOT NULL,
   CONSTRAINT pk_exercise PRIMARY KEY (exercise_id)
);