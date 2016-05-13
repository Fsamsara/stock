package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TmpRemailedStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmpRemailedStockExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWarehIdIsNull() {
            addCriterion("WAREH_ID is null");
            return (Criteria) this;
        }

        public Criteria andWarehIdIsNotNull() {
            addCriterion("WAREH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWarehIdEqualTo(String value) {
            addCriterion("WAREH_ID =", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotEqualTo(String value) {
            addCriterion("WAREH_ID <>", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdGreaterThan(String value) {
            addCriterion("WAREH_ID >", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdGreaterThanOrEqualTo(String value) {
            addCriterion("WAREH_ID >=", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLessThan(String value) {
            addCriterion("WAREH_ID <", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLessThanOrEqualTo(String value) {
            addCriterion("WAREH_ID <=", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLike(String value) {
            addCriterion("WAREH_ID like", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotLike(String value) {
            addCriterion("WAREH_ID not like", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdIn(List<String> values) {
            addCriterion("WAREH_ID in", values, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotIn(List<String> values) {
            addCriterion("WAREH_ID not in", values, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdBetween(String value1, String value2) {
            addCriterion("WAREH_ID between", value1, value2, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotBetween(String value1, String value2) {
            addCriterion("WAREH_ID not between", value1, value2, "warehId");
            return (Criteria) this;
        }

        public Criteria andRemailDateIsNull() {
            addCriterion("REMAIL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRemailDateIsNotNull() {
            addCriterion("REMAIL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRemailDateEqualTo(Date value) {
            addCriterion("REMAIL_DATE =", value, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateNotEqualTo(Date value) {
            addCriterion("REMAIL_DATE <>", value, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateGreaterThan(Date value) {
            addCriterion("REMAIL_DATE >", value, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateGreaterThanOrEqualTo(Date value) {
            addCriterion("REMAIL_DATE >=", value, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateLessThan(Date value) {
            addCriterion("REMAIL_DATE <", value, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateLessThanOrEqualTo(Date value) {
            addCriterion("REMAIL_DATE <=", value, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateIn(List<Date> values) {
            addCriterion("REMAIL_DATE in", values, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateNotIn(List<Date> values) {
            addCriterion("REMAIL_DATE not in", values, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateBetween(Date value1, Date value2) {
            addCriterion("REMAIL_DATE between", value1, value2, "remailDate");
            return (Criteria) this;
        }

        public Criteria andRemailDateNotBetween(Date value1, Date value2) {
            addCriterion("REMAIL_DATE not between", value1, value2, "remailDate");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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