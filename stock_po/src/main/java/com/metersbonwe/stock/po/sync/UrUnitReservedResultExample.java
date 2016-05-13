package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UrUnitReservedResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UrUnitReservedResultExample() {
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

        public Criteria andUnitIdIsNull() {
            addCriterion("UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdIsNotNull() {
            addCriterion("UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdEqualTo(String value) {
            addCriterion("UNIT_ID =", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotEqualTo(String value) {
            addCriterion("UNIT_ID <>", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThan(String value) {
            addCriterion("UNIT_ID >", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_ID >=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThan(String value) {
            addCriterion("UNIT_ID <", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLessThanOrEqualTo(String value) {
            addCriterion("UNIT_ID <=", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdLike(String value) {
            addCriterion("UNIT_ID like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotLike(String value) {
            addCriterion("UNIT_ID not like", value, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdIn(List<String> values) {
            addCriterion("UNIT_ID in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotIn(List<String> values) {
            addCriterion("UNIT_ID not in", values, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdBetween(String value1, String value2) {
            addCriterion("UNIT_ID between", value1, value2, "unitId");
            return (Criteria) this;
        }

        public Criteria andUnitIdNotBetween(String value1, String value2) {
            addCriterion("UNIT_ID not between", value1, value2, "unitId");
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

        public Criteria andReservedQtyIsNull() {
            addCriterion("RESERVED_QTY is null");
            return (Criteria) this;
        }

        public Criteria andReservedQtyIsNotNull() {
            addCriterion("RESERVED_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andReservedQtyEqualTo(BigDecimal value) {
            addCriterion("RESERVED_QTY =", value, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyNotEqualTo(BigDecimal value) {
            addCriterion("RESERVED_QTY <>", value, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyGreaterThan(BigDecimal value) {
            addCriterion("RESERVED_QTY >", value, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_QTY >=", value, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyLessThan(BigDecimal value) {
            addCriterion("RESERVED_QTY <", value, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_QTY <=", value, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyIn(List<BigDecimal> values) {
            addCriterion("RESERVED_QTY in", values, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyNotIn(List<BigDecimal> values) {
            addCriterion("RESERVED_QTY not in", values, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_QTY between", value1, value2, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_QTY not between", value1, value2, "reservedQty");
            return (Criteria) this;
        }

        public Criteria andReservedTypeIsNull() {
            addCriterion("RESERVED_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReservedTypeIsNotNull() {
            addCriterion("RESERVED_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReservedTypeEqualTo(String value) {
            addCriterion("RESERVED_TYPE =", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeNotEqualTo(String value) {
            addCriterion("RESERVED_TYPE <>", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeGreaterThan(String value) {
            addCriterion("RESERVED_TYPE >", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RESERVED_TYPE >=", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeLessThan(String value) {
            addCriterion("RESERVED_TYPE <", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeLessThanOrEqualTo(String value) {
            addCriterion("RESERVED_TYPE <=", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeLike(String value) {
            addCriterion("RESERVED_TYPE like", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeNotLike(String value) {
            addCriterion("RESERVED_TYPE not like", value, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeIn(List<String> values) {
            addCriterion("RESERVED_TYPE in", values, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeNotIn(List<String> values) {
            addCriterion("RESERVED_TYPE not in", values, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeBetween(String value1, String value2) {
            addCriterion("RESERVED_TYPE between", value1, value2, "reservedType");
            return (Criteria) this;
        }

        public Criteria andReservedTypeNotBetween(String value1, String value2) {
            addCriterion("RESERVED_TYPE not between", value1, value2, "reservedType");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyIsNull() {
            addCriterion("ALLOCATED_QTY is null");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyIsNotNull() {
            addCriterion("ALLOCATED_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyEqualTo(BigDecimal value) {
            addCriterion("ALLOCATED_QTY =", value, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyNotEqualTo(BigDecimal value) {
            addCriterion("ALLOCATED_QTY <>", value, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyGreaterThan(BigDecimal value) {
            addCriterion("ALLOCATED_QTY >", value, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALLOCATED_QTY >=", value, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyLessThan(BigDecimal value) {
            addCriterion("ALLOCATED_QTY <", value, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALLOCATED_QTY <=", value, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyIn(List<BigDecimal> values) {
            addCriterion("ALLOCATED_QTY in", values, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyNotIn(List<BigDecimal> values) {
            addCriterion("ALLOCATED_QTY not in", values, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALLOCATED_QTY between", value1, value2, "allocatedQty");
            return (Criteria) this;
        }

        public Criteria andAllocatedQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALLOCATED_QTY not between", value1, value2, "allocatedQty");
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

        public Criteria andReservedAllocatedQtyIsNull() {
            addCriterion("RESERVED_ALLOCATED_QTY is null");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyIsNotNull() {
            addCriterion("RESERVED_ALLOCATED_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyEqualTo(BigDecimal value) {
            addCriterion("RESERVED_ALLOCATED_QTY =", value, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyNotEqualTo(BigDecimal value) {
            addCriterion("RESERVED_ALLOCATED_QTY <>", value, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyGreaterThan(BigDecimal value) {
            addCriterion("RESERVED_ALLOCATED_QTY >", value, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_ALLOCATED_QTY >=", value, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyLessThan(BigDecimal value) {
            addCriterion("RESERVED_ALLOCATED_QTY <", value, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_ALLOCATED_QTY <=", value, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyIn(List<BigDecimal> values) {
            addCriterion("RESERVED_ALLOCATED_QTY in", values, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyNotIn(List<BigDecimal> values) {
            addCriterion("RESERVED_ALLOCATED_QTY not in", values, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_ALLOCATED_QTY between", value1, value2, "reservedAllocatedQty");
            return (Criteria) this;
        }

        public Criteria andReservedAllocatedQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_ALLOCATED_QTY not between", value1, value2, "reservedAllocatedQty");
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