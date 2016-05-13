package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockShopRemailTranExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockShopRemailTranExample() {
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

        public Criteria andLocIdIsNull() {
            addCriterion("loc_id is null");
            return (Criteria) this;
        }

        public Criteria andLocIdIsNotNull() {
            addCriterion("loc_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocIdEqualTo(String value) {
            addCriterion("loc_id =", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotEqualTo(String value) {
            addCriterion("loc_id <>", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdGreaterThan(String value) {
            addCriterion("loc_id >", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdGreaterThanOrEqualTo(String value) {
            addCriterion("loc_id >=", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLessThan(String value) {
            addCriterion("loc_id <", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLessThanOrEqualTo(String value) {
            addCriterion("loc_id <=", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLike(String value) {
            addCriterion("loc_id like", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotLike(String value) {
            addCriterion("loc_id not like", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdIn(List<String> values) {
            addCriterion("loc_id in", values, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotIn(List<String> values) {
            addCriterion("loc_id not in", values, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdBetween(String value1, String value2) {
            addCriterion("loc_id between", value1, value2, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotBetween(String value1, String value2) {
            addCriterion("loc_id not between", value1, value2, "locId");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockIsNull() {
            addCriterion("cell_remail_stock is null");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockIsNotNull() {
            addCriterion("cell_remail_stock is not null");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockEqualTo(Integer value) {
            addCriterion("cell_remail_stock =", value, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockNotEqualTo(Integer value) {
            addCriterion("cell_remail_stock <>", value, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockGreaterThan(Integer value) {
            addCriterion("cell_remail_stock >", value, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("cell_remail_stock >=", value, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockLessThan(Integer value) {
            addCriterion("cell_remail_stock <", value, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockLessThanOrEqualTo(Integer value) {
            addCriterion("cell_remail_stock <=", value, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockIn(List<Integer> values) {
            addCriterion("cell_remail_stock in", values, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockNotIn(List<Integer> values) {
            addCriterion("cell_remail_stock not in", values, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockBetween(Integer value1, Integer value2) {
            addCriterion("cell_remail_stock between", value1, value2, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailStockNotBetween(Integer value1, Integer value2) {
            addCriterion("cell_remail_stock not between", value1, value2, "cellRemailStock");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeIsNull() {
            addCriterion("cell_remail_order_type is null");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeIsNotNull() {
            addCriterion("cell_remail_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeEqualTo(String value) {
            addCriterion("cell_remail_order_type =", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeNotEqualTo(String value) {
            addCriterion("cell_remail_order_type <>", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeGreaterThan(String value) {
            addCriterion("cell_remail_order_type >", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cell_remail_order_type >=", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeLessThan(String value) {
            addCriterion("cell_remail_order_type <", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("cell_remail_order_type <=", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeLike(String value) {
            addCriterion("cell_remail_order_type like", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeNotLike(String value) {
            addCriterion("cell_remail_order_type not like", value, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeIn(List<String> values) {
            addCriterion("cell_remail_order_type in", values, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeNotIn(List<String> values) {
            addCriterion("cell_remail_order_type not in", values, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeBetween(String value1, String value2) {
            addCriterion("cell_remail_order_type between", value1, value2, "cellRemailOrderType");
            return (Criteria) this;
        }

        public Criteria andCellRemailOrderTypeNotBetween(String value1, String value2) {
            addCriterion("cell_remail_order_type not between", value1, value2, "cellRemailOrderType");
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

        public Criteria andRllNumIsNull() {
            addCriterion("rll_num is null");
            return (Criteria) this;
        }

        public Criteria andRllNumIsNotNull() {
            addCriterion("rll_num is not null");
            return (Criteria) this;
        }

        public Criteria andRllNumEqualTo(String value) {
            addCriterion("rll_num =", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumNotEqualTo(String value) {
            addCriterion("rll_num <>", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumGreaterThan(String value) {
            addCriterion("rll_num >", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumGreaterThanOrEqualTo(String value) {
            addCriterion("rll_num >=", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumLessThan(String value) {
            addCriterion("rll_num <", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumLessThanOrEqualTo(String value) {
            addCriterion("rll_num <=", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumLike(String value) {
            addCriterion("rll_num like", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumNotLike(String value) {
            addCriterion("rll_num not like", value, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumIn(List<String> values) {
            addCriterion("rll_num in", values, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumNotIn(List<String> values) {
            addCriterion("rll_num not in", values, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumBetween(String value1, String value2) {
            addCriterion("rll_num between", value1, value2, "rllNum");
            return (Criteria) this;
        }

        public Criteria andRllNumNotBetween(String value1, String value2) {
            addCriterion("rll_num not between", value1, value2, "rllNum");
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