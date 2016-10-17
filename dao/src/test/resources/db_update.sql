ALTER TABLE `stock_indicator`
ADD COLUMN `avg_val`  float NULL AFTER `val`,
ADD COLUMN `sum_val`  float NULL AFTER `avg_val`,
ADD COLUMN `pre_val`  float NULL AFTER `sum_val`,
ADD COLUMN `pre_avg_val`  float NULL AFTER `pre_val`,
ADD COLUMN `pre_sum_val`  float NULL AFTER `pre_avg_val`;

