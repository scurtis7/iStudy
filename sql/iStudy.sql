-- Save my bacon
SET NOEXEC ON
-- SET NOEXEC OFF

BEGIN TRAN
	DROP TABLE IF EXISTS istudy.study_note CASCADE;
	DROP TABLE IF EXISTS istudy.study CASCADE;
	DROP TABLE IF EXISTS istudy.study_category CASCADE;
	DROP TABLE IF EXISTS istudy.book CASCADE;
	DROP TABLE IF EXISTS public.migrations CASCADE;
	DROP SCHEMA IF EXISTS istudy CASCADE;
ROLLBACK
COMMIT

-- Don't execute the commands below.
-- Instead, open the scripts in resources/db/migration to the left and execute them

SELECT * FROM istudy.study_category;
SELECT * FROM istudy.book;
SELECT * FROM istudy.study;
SELECT * FROM istudy.study_note;




