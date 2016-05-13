package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfWarehLockedLstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfWarehLockedLstExample() {
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

        public Criteria andBfOrgIdIsNull() {
            addCriterion("BF_ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdIsNotNull() {
            addCriterion("BF_ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_ID =", value, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_ID <>", value, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdGreaterThan(BigDecimal value) {
            addCriterion("BF_ORG_ID >", value, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_ID >=", value, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdLessThan(BigDecimal value) {
            addCriterion("BF_ORG_ID <", value, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_ID <=", value, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdIn(List<BigDecimal> values) {
            addCriterion("BF_ORG_ID in", values, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_ORG_ID not in", values, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_ORG_ID between", value1, value2, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andBfOrgIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_ORG_ID not between", value1, value2, "bfOrgId");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("PROD_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("PROD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(BigDecimal value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(BigDecimal value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(BigDecimal value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(BigDecimal value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<BigDecimal> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<BigDecimal> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andLockedQtyIsNull() {
            addCriterion("LOCKED_QTY is null");
            return (Criteria) this;
        }

        public Criteria andLockedQtyIsNotNull() {
            addCriterion("LOCKED_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andLockedQtyEqualTo(BigDecimal value) {
            addCriterion("LOCKED_QTY =", value, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyNotEqualTo(BigDecimal value) {
            addCriterion("LOCKED_QTY <>", value, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyGreaterThan(BigDecimal value) {
            addCriterion("LOCKED_QTY >", value, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCKED_QTY >=", value, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyLessThan(BigDecimal value) {
            addCriterion("LOCKED_QTY <", value, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCKED_QTY <=", value, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyIn(List<BigDecimal> values) {
            addCriterion("LOCKED_QTY in", values, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyNotIn(List<BigDecimal> values) {
            addCriterion("LOCKED_QTY not in", values, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCKED_QTY between", value1, value2, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCKED_QTY not between", value1, value2, "lockedQty");
            return (Criteria) this;
        }

        public Criteria andLockedTypeIsNull() {
            addCriterion("LOCKED_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLockedTypeIsNotNull() {
            addCriterion("LOCKED_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLockedTypeEqualTo(String value) {
            addCriterion("LOCKED_TYPE =", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeNotEqualTo(String value) {
            addCriterion("LOCKED_TYPE <>", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeGreaterThan(String value) {
            addCriterion("LOCKED_TYPE >", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCKED_TYPE >=", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeLessThan(String value) {
            addCriterion("LOCKED_TYPE <", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeLessThanOrEqualTo(String value) {
            addCriterion("LOCKED_TYPE <=", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeLike(String value) {
            addCriterion("LOCKED_TYPE like", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeNotLike(String value) {
            addCriterion("LOCKED_TYPE not like", value, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeIn(List<String> values) {
            addCriterion("LOCKED_TYPE in", values, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeNotIn(List<String> values) {
            addCriterion("LOCKED_TYPE not in", values, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeBetween(String value1, String value2) {
            addCriterion("LOCKED_TYPE between", value1, value2, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLockedTypeNotBetween(String value1, String value2) {
            addCriterion("LOCKED_TYPE not between", value1, value2, "lockedType");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserIsNull() {
            addCriterion("LAST_MODIFIED_USER is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserIsNotNull() {
            addCriterion("LAST_MODIFIED_USER is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER =", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER <>", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserGreaterThan(String value) {
            addCriterion("LAST_MODIFIED_USER >", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER >=", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserLessThan(String value) {
            addCriterion("LAST_MODIFIED_USER <", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserLessThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER <=", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserLike(String value) {
            addCriterion("LAST_MODIFIED_USER like", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotLike(String value) {
            addCriterion("LAST_MODIFIED_USER not like", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserIn(List<String> values) {
            addCriterion("LAST_MODIFIED_USER in", values, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotIn(List<String> values) {
            addCriterion("LAST_MODIFIED_USER not in", values, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIED_USER between", value1, value2, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIED_USER not between", value1, value2, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIsNull() {
            addCriterion("LAST_MODIFIED_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIsNotNull() {
            addCriterion("LAST_MODIFIED_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateEqualTo(Date value) {
            addCriterion("LAST_MODIFIED_DATE =", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotEqualTo(Date value) {
            addCriterion("LAST_MODIFIED_DATE <>", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateGreaterThan(Date value) {
            addCriterion("LAST_MODIFIED_DATE >", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFIED_DATE >=", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateLessThan(Date value) {
            addCriterion("LAST_MODIFIED_DATE <", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateLessThanOrEqualTo(Date value) {
            addCriterion("LAST_MODIFIED_DATE <=", value, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateIn(List<Date> values) {
            addCriterion("LAST_MODIFIED_DATE in", values, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotIn(List<Date> values) {
            addCriterion("LAST_MODIFIED_DATE not in", values, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFIED_DATE between", value1, value2, "lastModifiedDate");
            return (Criteria) this;
        }

        public Criteria andLastModifiedDateNotBetween(Date value1, Date value2) {
            addCriterion("LAST_MODIFIED_DATE not between", value1, value2, "lastModifiedDate");
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