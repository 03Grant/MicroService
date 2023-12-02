INSERT INTO Test.coupon (couponid, total_num, couponname, commatch, type, discount, `limit`, special_offer, cumulation, datebegin, dateend) VALUES
('COUPON1', 100, 'DiscountCoupon1', 'Intel', 'Discount', 0.9, NULL, NULL, 1, '2023-01-01', '2023-02-28'),
('COUPON2', 50, 'FullReductionCoupon1', 'AMD', 'FullReduction', NULL, 800, 50, 0, '2023-03-01', '2023-04-30'),
('COUPON3', 200, 'DiscountCoupon2', 'RTX 4050', 'Discount', 0.8, NULL, NULL, 1, '2023-02-15', '2023-03-31'),
('COUPON4', 150, 'FullReductionCoupon2', 'RTX 4060', 'FullReduction', NULL, 1000, 75, 1, '2023-05-01', '2023-06-30'),
('COUPON5', 80, 'DiscountCoupon3', 'RTX 4060', 'Discount', 0.85, NULL, NULL, 0, '2023-04-10', '2023-05-20'),
('COUPON6', 120, 'FullReductionCoupon3', 'Intel', 'FullReduction', NULL, 900, 60, 1, '2023-06-01', '2023-07-15'),
('COUPON7', 50, 'DiscountCoupon4', 'AMD', 'Discount', 0.75, NULL, NULL, 1, '2023-07-01', '2023-08-31'),
('COUPON8', 90, 'FullReductionCoupon4', 'RTX 4050', 'FullReduction', NULL, 1200, 80, 0, '2023-09-01', '2023-10-15');
