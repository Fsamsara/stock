package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockWarehProdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String tableNum;

    public StockWarehProdExample() {
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

    public String getTableNum() {
        return tableNum;
    }

    public void setTableNum(String tableNum) {
        this.tableNum = tableNum;
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
                throw new RuntimeException(
                        "Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException(
                        "Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException(
                        "Between values for " + property + " cannot be null");
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

        public Criteria andWarehIdIsNull() {
            addCriterion("wareh_id is null");
            return (Criteria) this;
        }

        public Criteria andWarehIdIsNotNull() {
            addCriterion("wareh_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehIdEqualTo(String value) {
            addCriterion("wareh_id =", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotEqualTo(String value) {
            addCriterion("wareh_id <>", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdGreaterThan(String value) {
            addCriterion("wareh_id >", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdGreaterThanOrEqualTo(String value) {
            addCriterion("wareh_id >=", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLessThan(String value) {
            addCriterion("wareh_id <", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLessThanOrEqualTo(String value) {
            addCriterion("wareh_id <=", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLike(String value) {
            addCriterion("wareh_id like", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotLike(String value) {
            addCriterion("wareh_id not like", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdIn(List<String> values) {
            addCriterion("wareh_id in", values, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotIn(List<String> values) {
            addCriterion("wareh_id not in", values, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdBetween(String value1, String value2) {
            addCriterion("wareh_id between", value1, value2, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotBetween(String value1, String value2) {
            addCriterion("wareh_id not between", value1, value2, "warehId");
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
            addCriterion(
                    "six_prod_id not between",
                    value1,
                    value2,
                    "sixProdId");
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
            addCriterion(
                    "eight_prod_id between",
                    value1,
                    value2,
                    "eightProdId");
            return (Criteria) this;
        }

        public Criteria andEightProdIdNotBetween(String value1, String value2) {
            addCriterion(
                    "eight_prod_id not between",
                    value1,
                    value2,
                    "eightProdId");
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

        public Criteria andStkOnHandIsNull() {
            addCriterion("stk_on_hand is null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIsNotNull() {
            addCriterion("stk_on_hand is not null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandEqualTo(Integer value) {
            addCriterion("stk_on_hand =", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotEqualTo(Integer value) {
            addCriterion("stk_on_hand <>", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandGreaterThan(Integer value) {
            addCriterion("stk_on_hand >", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandGreaterThanOrEqualTo(Integer value) {
            addCriterion("stk_on_hand >=", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandLessThan(Integer value) {
            addCriterion("stk_on_hand <", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandLessThanOrEqualTo(Integer value) {
            addCriterion("stk_on_hand <=", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIn(List<Integer> values) {
            addCriterion("stk_on_hand in", values, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotIn(List<Integer> values) {
            addCriterion("stk_on_hand not in", values, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBetween(Integer value1, Integer value2) {
            addCriterion("stk_on_hand between", value1, value2, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotBetween(Integer value1, Integer value2) {
            addCriterion(
                    "stk_on_hand not between",
                    value1,
                    value2,
                    "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockIsNull() {
            addCriterion("free_share_stock is null");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockIsNotNull() {
            addCriterion("free_share_stock is not null");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockEqualTo(Integer value) {
            addCriterion("free_share_stock =", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockNotEqualTo(Integer value) {
            addCriterion("free_share_stock <>", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockGreaterThan(Integer value) {
            addCriterion("free_share_stock >", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_share_stock >=", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockLessThan(Integer value) {
            addCriterion("free_share_stock <", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockLessThanOrEqualTo(Integer value) {
            addCriterion("free_share_stock <=", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockIn(List<Integer> values) {
            addCriterion("free_share_stock in", values, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockNotIn(List<Integer> values) {
            addCriterion("free_share_stock not in", values, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "free_share_stock between",
                    value1,
                    value2,
                    "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockNotBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "free_share_stock not between",
                    value1,
                    value2,
                    "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockIsNull() {
            addCriterion("final_free_share_stock is null");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockIsNotNull() {
            addCriterion("final_free_share_stock is not null");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockEqualTo(Integer value) {
            addCriterion(
                    "final_free_share_stock =",
                    value,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockNotEqualTo(Integer value) {
            addCriterion(
                    "final_free_share_stock <>",
                    value,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockGreaterThan(Integer value) {
            addCriterion(
                    "final_free_share_stock >",
                    value,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockGreaterThanOrEqualTo(
                Integer value) {
            addCriterion(
                    "final_free_share_stock >=",
                    value,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockLessThan(Integer value) {
            addCriterion(
                    "final_free_share_stock <",
                    value,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockLessThanOrEqualTo(Integer value) {
            addCriterion(
                    "final_free_share_stock <=",
                    value,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockIn(List<Integer> values) {
            addCriterion(
                    "final_free_share_stock in",
                    values,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockNotIn(List<Integer> values) {
            addCriterion(
                    "final_free_share_stock not in",
                    values,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "final_free_share_stock between",
                    value1,
                    value2,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andFinalFreeShareStockNotBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "final_free_share_stock not between",
                    value1,
                    value2,
                    "finalFreeShareStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockIsNull() {
            addCriterion("online_safe_stock is null");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockIsNotNull() {
            addCriterion("online_safe_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockEqualTo(Integer value) {
            addCriterion("online_safe_stock =", value, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockNotEqualTo(Integer value) {
            addCriterion("online_safe_stock <>", value, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockGreaterThan(Integer value) {
            addCriterion("online_safe_stock >", value, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("online_safe_stock >=", value, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockLessThan(Integer value) {
            addCriterion("online_safe_stock <", value, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockLessThanOrEqualTo(Integer value) {
            addCriterion("online_safe_stock <=", value, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockIn(List<Integer> values) {
            addCriterion("online_safe_stock in", values, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockNotIn(List<Integer> values) {
            addCriterion("online_safe_stock not in", values, "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "online_safe_stock between",
                    value1,
                    value2,
                    "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeStockNotBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "online_safe_stock not between",
                    value1,
                    value2,
                    "onlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockIsNull() {
            addCriterion("offline_safe_stock is null");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockIsNotNull() {
            addCriterion("offline_safe_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockEqualTo(Integer value) {
            addCriterion("offline_safe_stock =", value, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockNotEqualTo(Integer value) {
            addCriterion("offline_safe_stock <>", value, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockGreaterThan(Integer value) {
            addCriterion("offline_safe_stock >", value, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("offline_safe_stock >=", value, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockLessThan(Integer value) {
            addCriterion("offline_safe_stock <", value, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockLessThanOrEqualTo(Integer value) {
            addCriterion("offline_safe_stock <=", value, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockIn(List<Integer> values) {
            addCriterion("offline_safe_stock in", values, "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockNotIn(List<Integer> values) {
            addCriterion(
                    "offline_safe_stock not in",
                    values,
                    "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "offline_safe_stock between",
                    value1,
                    value2,
                    "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeStockNotBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "offline_safe_stock not between",
                    value1,
                    value2,
                    "offlineSafeStock");
            return (Criteria) this;
        }

        public Criteria andShopRemailIsNull() {
            addCriterion("shop_remail is null");
            return (Criteria) this;
        }

        public Criteria andShopRemailIsNotNull() {
            addCriterion("shop_remail is not null");
            return (Criteria) this;
        }

        public Criteria andShopRemailEqualTo(Integer value) {
            addCriterion("shop_remail =", value, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailNotEqualTo(Integer value) {
            addCriterion("shop_remail <>", value, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailGreaterThan(Integer value) {
            addCriterion("shop_remail >", value, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_remail >=", value, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailLessThan(Integer value) {
            addCriterion("shop_remail <", value, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailLessThanOrEqualTo(Integer value) {
            addCriterion("shop_remail <=", value, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailIn(List<Integer> values) {
            addCriterion("shop_remail in", values, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailNotIn(List<Integer> values) {
            addCriterion("shop_remail not in", values, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailBetween(Integer value1, Integer value2) {
            addCriterion("shop_remail between", value1, value2, "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopRemailNotBetween(Integer value1,
                Integer value2) {
            addCriterion(
                    "shop_remail not between",
                    value1,
                    value2,
                    "shopRemail");
            return (Criteria) this;
        }

        public Criteria andShopDameIsNull() {
            addCriterion("shop_dame is null");
            return (Criteria) this;
        }

        public Criteria andShopDameIsNotNull() {
            addCriterion("shop_dame is not null");
            return (Criteria) this;
        }

        public Criteria andShopDameEqualTo(Integer value) {
            addCriterion("shop_dame =", value, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameNotEqualTo(Integer value) {
            addCriterion("shop_dame <>", value, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameGreaterThan(Integer value) {
            addCriterion("shop_dame >", value, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_dame >=", value, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameLessThan(Integer value) {
            addCriterion("shop_dame <", value, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameLessThanOrEqualTo(Integer value) {
            addCriterion("shop_dame <=", value, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameIn(List<Integer> values) {
            addCriterion("shop_dame in", values, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameNotIn(List<Integer> values) {
            addCriterion("shop_dame not in", values, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameBetween(Integer value1, Integer value2) {
            addCriterion("shop_dame between", value1, value2, "shopDame");
            return (Criteria) this;
        }

        public Criteria andShopDameNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_dame not between", value1, value2, "shopDame");
            return (Criteria) this;
        }

        public Criteria andLockStockIsNull() {
            addCriterion("lock_stock is null");
            return (Criteria) this;
        }

        public Criteria andLockStockIsNotNull() {
            addCriterion("lock_stock is not null");
            return (Criteria) this;
        }

        public Criteria andLockStockEqualTo(Integer value) {
            addCriterion("lock_stock =", value, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockNotEqualTo(Integer value) {
            addCriterion("lock_stock <>", value, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockGreaterThan(Integer value) {
            addCriterion("lock_stock >", value, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_stock >=", value, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockLessThan(Integer value) {
            addCriterion("lock_stock <", value, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockLessThanOrEqualTo(Integer value) {
            addCriterion("lock_stock <=", value, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockIn(List<Integer> values) {
            addCriterion("lock_stock in", values, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockNotIn(List<Integer> values) {
            addCriterion("lock_stock not in", values, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockBetween(Integer value1, Integer value2) {
            addCriterion("lock_stock between", value1, value2, "lockStock");
            return (Criteria) this;
        }

        public Criteria andLockStockNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_stock not between", value1, value2, "lockStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockIsNull() {
            addCriterion("wms_stock is null");
            return (Criteria) this;
        }

        public Criteria andWmsStockIsNotNull() {
            addCriterion("wms_stock is not null");
            return (Criteria) this;
        }

        public Criteria andWmsStockEqualTo(Integer value) {
            addCriterion("wms_stock =", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockNotEqualTo(Integer value) {
            addCriterion("wms_stock <>", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockGreaterThan(Integer value) {
            addCriterion("wms_stock >", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("wms_stock >=", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockLessThan(Integer value) {
            addCriterion("wms_stock <", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockLessThanOrEqualTo(Integer value) {
            addCriterion("wms_stock <=", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockIn(List<Integer> values) {
            addCriterion("wms_stock in", values, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockNotIn(List<Integer> values) {
            addCriterion("wms_stock not in", values, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockBetween(Integer value1, Integer value2) {
            addCriterion("wms_stock between", value1, value2, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockNotBetween(Integer value1, Integer value2) {
            addCriterion("wms_stock not between", value1, value2, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andIsShopIsNull() {
            addCriterion("is_shop is null");
            return (Criteria) this;
        }

        public Criteria andIsShopIsNotNull() {
            addCriterion("is_shop is not null");
            return (Criteria) this;
        }

        public Criteria andIsShopEqualTo(Byte value) {
            addCriterion("is_shop =", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotEqualTo(Byte value) {
            addCriterion("is_shop <>", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopGreaterThan(Byte value) {
            addCriterion("is_shop >", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_shop >=", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopLessThan(Byte value) {
            addCriterion("is_shop <", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopLessThanOrEqualTo(Byte value) {
            addCriterion("is_shop <=", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopIn(List<Byte> values) {
            addCriterion("is_shop in", values, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotIn(List<Byte> values) {
            addCriterion("is_shop not in", values, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopBetween(Byte value1, Byte value2) {
            addCriterion("is_shop between", value1, value2, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotBetween(Byte value1, Byte value2) {
            addCriterion("is_shop not between", value1, value2, "isShop");
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
            addCriterion(
                    "update_time not between",
                    value1,
                    value2,
                    "updateTime");
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

        protected Criterion(String condition, Object value,
                String typeHandler) {
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

        protected Criterion(String condition, Object value, Object secondValue,
                String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value,
                Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
