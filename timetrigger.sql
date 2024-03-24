CREATE OR REPLACE FUNCTION current_time_adjustment_func()
	Returns trigger AS
$$
BEGIN
	Update COMMENT SET comment_time = CURRENT_TIMESTAMP WHERE comment_id = NEW.comment_id;
RETURN NULL;
END;
$$
LANGUAGE 'plpgsql';
CREATE OR REPLACE TRIGGER current_time_adjustment
AFTER INSERT
ON comment
FOR EACH ROW
EXECUTE PROCEDURE current_time_adjustment_func();


CREATE OR REPLACE FUNCTION current_report_time_func()
	Returns trigger AS
$$
BEGIN
	Update report SET report_time = CURRENT_TIMESTAMP WHERE report_id = NEW.report_id;
RETURN NULL;
END;
$$
LANGUAGE 'plpgsql';
CREATE OR REPLACE TRIGGER current_report_time
AFTER INSERT
ON report
FOR EACH ROW
EXECUTE PROCEDURE current_report_time_func();


---------Review------
CREATE FUNCTION update_review_rate_func()
RETURNS TRIGGER AS $$
DECLARE
    total_rating_value INT;
    total_ratings_count INT;
BEGIN
    -- Вычисляем сумму значений полей rating_value для заданного review_id
    SELECT SUM(rating_value), COUNT(*) INTO total_rating_value, total_ratings_count
    FROM rating
    WHERE review_id = NEW.review_id;

    -- Если есть рейтинги для заданного review_id, то обновляем значение поля review_rate в таблице review
    IF total_ratings_count > 0 THEN
        UPDATE review SET review_rate = total_rating_value / total_ratings_count WHERE review_id = NEW.review_id;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_review_rate_trigger
AFTER INSERT 
ON rating
FOR EACH ROW
EXECUTE FUNCTION update_review_rate_func();
