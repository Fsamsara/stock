package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.List;

public class TmpStockTableSumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmpStockTableSumExample() {
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

        public Criteria andFreeNumIsNull() {
            addCriterion("free_num is null");
            return (Criteria) this;
        }

        public Criteria andFreeNumIsNotNull() {
            addCriterion("free_num is not null");
            return (Criteria) this;
        }

        public Criteria andFreeNumEqualTo(Integer value) {
            addCriterion("free_num =", value, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumNotEqualTo(Integer value) {
            addCriterion("free_num <>", value, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumGreaterThan(Integer value) {
            addCriterion("free_num >", value, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_num >=", value, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumLessThan(Integer value) {
            addCriterion("free_num <", value, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumLessThanOrEqualTo(Integer value) {
            addCriterion("free_num <=", value, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumIn(List<Integer> values) {
            addCriterion("free_num in", values, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumNotIn(List<Integer> values) {
            addCriterion("free_num not in", values, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumBetween(Integer value1, Integer value2) {
            addCriterion("free_num between", value1, value2, "freeNum");
            return (Criteria) this;
        }

        public Criteria andFreeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("free_num not between", value1, value2, "freeNum");
            return (Criteria) this;
        }

        public Criteria andLockNumIsNull() {
            addCriterion("lock_num is null");
            return (Criteria) this;
        }

        public Criteria andLockNumIsNotNull() {
            addCriterion("lock_num is not null");
            return (Criteria) this;
        }

        public Criteria andLockNumEqualTo(Integer value) {
            addCriterion("lock_num =", value, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumNotEqualTo(Integer value) {
            addCriterion("lock_num <>", value, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumGreaterThan(Integer value) {
            addCriterion("lock_num >", value, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_num >=", value, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumLessThan(Integer value) {
            addCriterion("lock_num <", value, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumLessThanOrEqualTo(Integer value) {
            addCriterion("lock_num <=", value, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumIn(List<Integer> values) {
            addCriterion("lock_num in", values, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumNotIn(List<Integer> values) {
            addCriterion("lock_num not in", values, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumBetween(Integer value1, Integer value2) {
            addCriterion("lock_num between", value1, value2, "lockNum");
            return (Criteria) this;
        }

        public Criteria andLockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_num not between", value1, value2, "lockNum");
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