CREATE TABLE Test.coupon ( couponid VARCHAR(45) PRIMARY KEY, total_num INT, couponname VARCHAR(45), commatch VARCHAR(45), type VARCHAR(45), discount DECIMAL(5, 2), `limit` DECIMAL(10, 2), special_offer DECIMAL(10, 2), cumulation BOOLEAN, datebegin DATE, dateend DATE );