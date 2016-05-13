package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TmpFreeStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmpFreeStockExample() {
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

        public Criteria andQtyCommittedIsNull() {
            addCriterion("QTY_COMMITTED is null");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedIsNotNull() {
            addCriterion("QTY_COMMITTED is not null");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedEqualTo(BigDecimal value) {
            addCriterion("QTY_COMMITTED =", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedNotEqualTo(BigDecimal value) {
            addCriterion("QTY_COMMITTED <>", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedGreaterThan(BigDecimal value) {
            addCriterion("QTY_COMMITTED >", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_COMMITTED >=", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedLessThan(BigDecimal value) {
            addCriterion("QTY_COMMITTED <", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_COMMITTED <=", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedIn(List<BigDecimal> values) {
            addCriterion("QTY_COMMITTED in", values, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedNotIn(List<BigDecimal> values) {
            addCriterion("QTY_COMMITTED not in", values, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_COMMITTED between", value1, value2, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_COMMITTED not between", value1, value2, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andFreeStockIsNull() {
            addCriterion("FREE_STOCK is null");
            return (Criteria) this;
        }

        public Criteria andFreeStockIsNotNull() {
            addCriterion("FREE_STOCK is not null");
            return (Criteria) this;
        }

        public Criteria andFreeStockEqualTo(BigDecimal value) {
            addCriterion("FREE_STOCK =", value, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockNotEqualTo(BigDecimal value) {
            addCriterion("FREE_STOCK <>", value, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockGreaterThan(BigDecimal value) {
            addCriterion("FREE_STOCK >", value, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREE_STOCK >=", value, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockLessThan(BigDecimal value) {
            addCriterion("FREE_STOCK <", value, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREE_STOCK <=", value, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockIn(List<BigDecimal> values) {
            addCriterion("FREE_STOCK in", values, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockNotIn(List<BigDecimal> values) {
            addCriterion("FREE_STOCK not in", values, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREE_STOCK between", value1, value2, "freeStock");
            return (Criteria) this;
        }

        public Criteria andFreeStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREE_STOCK not between", value1, value2, "freeStock");
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

        public Criteria andDataSourceIsNull() {
            addCriterion("DATA_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("DATA_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(String value) {
            addCriterion("DATA_SOURCE =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(String value) {
            addCriterion("DATA_SOURCE <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(String value) {
            addCriterion("DATA_SOURCE >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_SOURCE >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(String value) {
            addCriterion("DATA_SOURCE <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(String value) {
            addCriterion("DATA_SOURCE <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLike(String value) {
            addCriterion("DATA_SOURCE like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotLike(String value) {
            addCriterion("DATA_SOURCE not like", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<String> values) {
            addCriterion("DATA_SOURCE in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<String> values) {
            addCriterion("DATA_SOURCE not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(String value1, String value2) {
            addCriterion("DATA_SOURCE between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(String value1, String value2) {
            addCriterion("DATA_SOURCE not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedIsNull() {
            addCriterion("IS_FREE_CHANGED is null");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedIsNotNull() {
            addCriterion("IS_FREE_CHANGED is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedEqualTo(String value) {
            addCriterion("IS_FREE_CHANGED =", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedNotEqualTo(String value) {
            addCriterion("IS_FREE_CHANGED <>", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedGreaterThan(String value) {
            addCriterion("IS_FREE_CHANGED >", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FREE_CHANGED >=", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedLessThan(String value) {
            addCriterion("IS_FREE_CHANGED <", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedLessThanOrEqualTo(String value) {
            addCriterion("IS_FREE_CHANGED <=", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedLike(String value) {
            addCriterion("IS_FREE_CHANGED like", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedNotLike(String value) {
            addCriterion("IS_FREE_CHANGED not like", value, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedIn(List<String> values) {
            addCriterion("IS_FREE_CHANGED in", values, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedNotIn(List<String> values) {
            addCriterion("IS_FREE_CHANGED not in", values, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedBetween(String value1, String value2) {
            addCriterion("IS_FREE_CHANGED between", value1, value2, "isFreeChanged");
            return (Criteria) this;
        }

        public Criteria andIsFreeChangedNotBetween(String value1, String value2) {
            addCriterion("IS_FREE_CHANGED not between", value1, value2, "isFreeChanged");
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