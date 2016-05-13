package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockChannelProdSubExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockChannelProdSubExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andSixProdIdIsNull() {
            addCriterion("six_prod_id is null");
            return (Criteria) this;
        }

        public Criteria andSixProdIdIsNotNull() {
            addCriterion("six_prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andSixProdIdEqualTo(String value) {
            addCriterion("six_prod_id =", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdNotEqualTo(String value) {
            addCriterion("six_prod_id <>", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdGreaterThan(String value) {
            addCriterion("six_prod_id >", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("six_prod_id >=", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdLessThan(String value) {
            addCriterion("six_prod_id <", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdLessThanOrEqualTo(String value) {
            addCriterion("six_prod_id <=", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdLike(String value) {
            addCriterion("six_prod_id like", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdNotLike(String value) {
            addCriterion("six_prod_id not like", value, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdIn(List<String> values) {
            addCriterion("six_prod_id in", values, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdNotIn(List<String> values) {
            addCriterion("six_prod_id not in", values, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdBetween(String value1, String value2) {
            addCriterion("six_prod_id between", value1, value2, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andSixProdIdNotBetween(String value1, String value2) {
            addCriterion("six_prod_id not between", value1, value2, "sixProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdIsNull() {
            addCriterion("eight_prod_id is null");
            return (Criteria) this;
        }

        public Criteria andEightProdIdIsNotNull() {
            addCriterion("eight_prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andEightProdIdEqualTo(String value) {
            addCriterion("eight_prod_id =", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdNotEqualTo(String value) {
            addCriterion("eight_prod_id <>", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdGreaterThan(String value) {
            addCriterion("eight_prod_id >", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("eight_prod_id >=", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdLessThan(String value) {
            addCriterion("eight_prod_id <", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdLessThanOrEqualTo(String value) {
            addCriterion("eight_prod_id <=", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdLike(String value) {
            addCriterion("eight_prod_id like", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdNotLike(String value) {
            addCriterion("eight_prod_id not like", value, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdIn(List<String> values) {
            addCriterion("eight_prod_id in", values, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdNotIn(List<String> values) {
            addCriterion("eight_prod_id not in", values, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdBetween(String value1, String value2) {
            addCriterion("eight_prod_id between", value1, value2, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdNotBetween(String value1, String value2) {
            addCriterion("eight_prod_id not between", value1, value2, "eightProdId");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("prod_id is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(String value) {
            addCriterion("prod_id =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(String value) {
            addCriterion("prod_id <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(String value) {
            addCriterion("prod_id >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("prod_id >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(String value) {
            addCriterion("prod_id <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(String value) {
            addCriterion("prod_id <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLike(String value) {
            addCriterion("prod_id like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotLike(String value) {
            addCriterion("prod_id not like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<String> values) {
            addCriterion("prod_id in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<String> values) {
            addCriterion("prod_id not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(String value1, String value2) {
            addCriterion("prod_id between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(String value1, String value2) {
            addCriterion("prod_id not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockIsNull() {
            addCriterion("order_private_total_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockIsNotNull() {
            addCriterion("order_private_total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockEqualTo(Integer value) {
            addCriterion("order_private_total_stock =", value, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockNotEqualTo(Integer value) {
            addCriterion("order_private_total_stock <>", value, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockGreaterThan(Integer value) {
            addCriterion("order_private_total_stock >", value, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_private_total_stock >=", value, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockLessThan(Integer value) {
            addCriterion("order_private_total_stock <", value, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_private_total_stock <=", value, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockIn(List<Integer> values) {
            addCriterion("order_private_total_stock in", values, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockNotIn(List<Integer> values) {
            addCriterion("order_private_total_stock not in", values, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("order_private_total_stock between", value1, value2, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_private_total_stock not between", value1, value2, "orderPrivateTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockIsNull() {
            addCriterion("order_shop_group_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockIsNotNull() {
            addCriterion("order_shop_group_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockEqualTo(Integer value) {
            addCriterion("order_shop_group_stock =", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockNotEqualTo(Integer value) {
            addCriterion("order_shop_group_stock <>", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockGreaterThan(Integer value) {
            addCriterion("order_shop_group_stock >", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_shop_group_stock >=", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockLessThan(Integer value) {
            addCriterion("order_shop_group_stock <", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_shop_group_stock <=", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockIn(List<Integer> values) {
            addCriterion("order_shop_group_stock in", values, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockNotIn(List<Integer> values) {
            addCriterion("order_shop_group_stock not in", values, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockBetween(Integer value1, Integer value2) {
            addCriterion("order_shop_group_stock between", value1, value2, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_shop_group_stock not between", value1, value2, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockIsNull() {
            addCriterion("order_share_total_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockIsNotNull() {
            addCriterion("order_share_total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockEqualTo(Integer value) {
            addCriterion("order_share_total_stock =", value, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockNotEqualTo(Integer value) {
            addCriterion("order_share_total_stock <>", value, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockGreaterThan(Integer value) {
            addCriterion("order_share_total_stock >", value, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_share_total_stock >=", value, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockLessThan(Integer value) {
            addCriterion("order_share_total_stock <", value, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_share_total_stock <=", value, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockIn(List<Integer> values) {
            addCriterion("order_share_total_stock in", values, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockNotIn(List<Integer> values) {
            addCriterion("order_share_total_stock not in", values, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("order_share_total_stock between", value1, value2, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_share_total_stock not between", value1, value2, "orderShareTotalStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockIsNull() {
            addCriterion("pre_private_stock is null");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockIsNotNull() {
            addCriterion("pre_private_stock is not null");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockEqualTo(Integer value) {
            addCriterion("pre_private_stock =", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockNotEqualTo(Integer value) {
            addCriterion("pre_private_stock <>", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockGreaterThan(Integer value) {
            addCriterion("pre_private_stock >", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_private_stock >=", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockLessThan(Integer value) {
            addCriterion("pre_private_stock <", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockLessThanOrEqualTo(Integer value) {
            addCriterion("pre_private_stock <=", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockIn(List<Integer> values) {
            addCriterion("pre_private_stock in", values, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockNotIn(List<Integer> values) {
            addCriterion("pre_private_stock not in", values, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockBetween(Integer value1, Integer value2) {
            addCriterion("pre_private_stock between", value1, value2, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_private_stock not between", value1, value2, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockIsNull() {
            addCriterion("pre_order_total_stock is null");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockIsNotNull() {
            addCriterion("pre_order_total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockEqualTo(Integer value) {
            addCriterion("pre_order_total_stock =", value, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockNotEqualTo(Integer value) {
            addCriterion("pre_order_total_stock <>", value, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockGreaterThan(Integer value) {
            addCriterion("pre_order_total_stock >", value, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_order_total_stock >=", value, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockLessThan(Integer value) {
            addCriterion("pre_order_total_stock <", value, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("pre_order_total_stock <=", value, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockIn(List<Integer> values) {
            addCriterion("pre_order_total_stock in", values, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockNotIn(List<Integer> values) {
            addCriterion("pre_order_total_stock not in", values, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("pre_order_total_stock between", value1, value2, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andPreOrderTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_order_total_stock not between", value1, value2, "preOrderTotalStock");
            return (Criteria) this;
        }

        public Criteria andIsPreIsNull() {
            addCriterion("is_pre is null");
            return (Criteria) this;
        }

        public Criteria andIsPreIsNotNull() {
            addCriterion("is_pre is not null");
            return (Criteria) this;
        }

        public Criteria andIsPreEqualTo(Byte value) {
            addCriterion("is_pre =", value, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreNotEqualTo(Byte value) {
            addCriterion("is_pre <>", value, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreGreaterThan(Byte value) {
            addCriterion("is_pre >", value, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_pre >=", value, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreLessThan(Byte value) {
            addCriterion("is_pre <", value, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreLessThanOrEqualTo(Byte value) {
            addCriterion("is_pre <=", value, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreIn(List<Byte> values) {
            addCriterion("is_pre in", values, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreNotIn(List<Byte> values) {
            addCriterion("is_pre not in", values, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreBetween(Byte value1, Byte value2) {
            addCriterion("is_pre between", value1, value2, "isPre");
            return (Criteria) this;
        }

        public Criteria andIsPreNotBetween(Byte value1, Byte value2) {
            addCriterion("is_pre not between", value1, value2, "isPre");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}