package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StkDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StkDtlExample() {
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

        public Criteria andLocIdIsNull() {
            addCriterion("LOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocIdIsNotNull() {
            addCriterion("LOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocIdEqualTo(String value) {
            addCriterion("LOC_ID =", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotEqualTo(String value) {
            addCriterion("LOC_ID <>", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdGreaterThan(String value) {
            addCriterion("LOC_ID >", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_ID >=", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLessThan(String value) {
            addCriterion("LOC_ID <", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLessThanOrEqualTo(String value) {
            addCriterion("LOC_ID <=", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdLike(String value) {
            addCriterion("LOC_ID like", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotLike(String value) {
            addCriterion("LOC_ID not like", value, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdIn(List<String> values) {
            addCriterion("LOC_ID in", values, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotIn(List<String> values) {
            addCriterion("LOC_ID not in", values, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdBetween(String value1, String value2) {
            addCriterion("LOC_ID between", value1, value2, "locId");
            return (Criteria) this;
        }

        public Criteria andLocIdNotBetween(String value1, String value2) {
            addCriterion("LOC_ID not between", value1, value2, "locId");
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

        public Criteria andProdIdEqualTo(String value) {
            addCriterion("PROD_ID =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(String value) {
            addCriterion("PROD_ID <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(String value) {
            addCriterion("PROD_ID >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_ID >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(String value) {
            addCriterion("PROD_ID <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_ID <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLike(String value) {
            addCriterion("PROD_ID like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotLike(String value) {
            addCriterion("PROD_ID not like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<String> values) {
            addCriterion("PROD_ID in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<String> values) {
            addCriterion("PROD_ID not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(String value1, String value2) {
            addCriterion("PROD_ID between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(String value1, String value2) {
            addCriterion("PROD_ID not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIsNull() {
            addCriterion("STK_ON_HAND is null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIsNotNull() {
            addCriterion("STK_ON_HAND is not null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND =", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND <>", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandGreaterThan(BigDecimal value) {
            addCriterion("STK_ON_HAND >", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND >=", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandLessThan(BigDecimal value) {
            addCriterion("STK_ON_HAND <", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND <=", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIn(List<BigDecimal> values) {
            addCriterion("STK_ON_HAND in", values, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotIn(List<BigDecimal> values) {
            addCriterion("STK_ON_HAND not in", values, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_ON_HAND between", value1, value2, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_ON_HAND not between", value1, value2, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andAllocQtyIsNull() {
            addCriterion("ALLOC_QTY is null");
            return (Criteria) this;
        }

        public Criteria andAllocQtyIsNotNull() {
            addCriterion("ALLOC_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andAllocQtyEqualTo(BigDecimal value) {
            addCriterion("ALLOC_QTY =", value, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyNotEqualTo(BigDecimal value) {
            addCriterion("ALLOC_QTY <>", value, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyGreaterThan(BigDecimal value) {
            addCriterion("ALLOC_QTY >", value, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALLOC_QTY >=", value, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyLessThan(BigDecimal value) {
            addCriterion("ALLOC_QTY <", value, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALLOC_QTY <=", value, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyIn(List<BigDecimal> values) {
            addCriterion("ALLOC_QTY in", values, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyNotIn(List<BigDecimal> values) {
            addCriterion("ALLOC_QTY not in", values, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALLOC_QTY between", value1, value2, "allocQty");
            return (Criteria) this;
        }

        public Criteria andAllocQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALLOC_QTY not between", value1, value2, "allocQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyIsNull() {
            addCriterion("EXPD_QTY is null");
            return (Criteria) this;
        }

        public Criteria andExpdQtyIsNotNull() {
            addCriterion("EXPD_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andExpdQtyEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY =", value, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyNotEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY <>", value, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyGreaterThan(BigDecimal value) {
            addCriterion("EXPD_QTY >", value, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY >=", value, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyLessThan(BigDecimal value) {
            addCriterion("EXPD_QTY <", value, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY <=", value, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyIn(List<BigDecimal> values) {
            addCriterion("EXPD_QTY in", values, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyNotIn(List<BigDecimal> values) {
            addCriterion("EXPD_QTY not in", values, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPD_QTY between", value1, value2, "expdQty");
            return (Criteria) this;
        }

        public Criteria andExpdQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPD_QTY not between", value1, value2, "expdQty");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateIsNull() {
            addCriterion("STK_CHANGE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateIsNotNull() {
            addCriterion("STK_CHANGE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateEqualTo(Date value) {
            addCriterion("STK_CHANGE_DATE =", value, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateNotEqualTo(Date value) {
            addCriterion("STK_CHANGE_DATE <>", value, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateGreaterThan(Date value) {
            addCriterion("STK_CHANGE_DATE >", value, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("STK_CHANGE_DATE >=", value, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateLessThan(Date value) {
            addCriterion("STK_CHANGE_DATE <", value, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateLessThanOrEqualTo(Date value) {
            addCriterion("STK_CHANGE_DATE <=", value, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateIn(List<Date> values) {
            addCriterion("STK_CHANGE_DATE in", values, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateNotIn(List<Date> values) {
            addCriterion("STK_CHANGE_DATE not in", values, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateBetween(Date value1, Date value2) {
            addCriterion("STK_CHANGE_DATE between", value1, value2, "stkChangeDate");
            return (Criteria) this;
        }

        public Criteria andStkChangeDateNotBetween(Date value1, Date value2) {
            addCriterion("STK_CHANGE_DATE not between", value1, value2, "stkChangeDate");
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