package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfStkDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfStkDtlExample() {
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

        public Criteria andSfWarehouseLocIdIsNull() {
            addCriterion("SF_WAREHOUSE_LOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdIsNotNull() {
            addCriterion("SF_WAREHOUSE_LOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_LOC_ID =", value, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdNotEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_LOC_ID <>", value, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdGreaterThan(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_LOC_ID >", value, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_LOC_ID >=", value, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdLessThan(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_LOC_ID <", value, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_LOC_ID <=", value, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdIn(List<BigDecimal> values) {
            addCriterion("SF_WAREHOUSE_LOC_ID in", values, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdNotIn(List<BigDecimal> values) {
            addCriterion("SF_WAREHOUSE_LOC_ID not in", values, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SF_WAREHOUSE_LOC_ID between", value1, value2, "sfWarehouseLocId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseLocIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SF_WAREHOUSE_LOC_ID not between", value1, value2, "sfWarehouseLocId");
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

        public Criteria andLastPickTimeIsNull() {
            addCriterion("LAST_PICK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeIsNotNull() {
            addCriterion("LAST_PICK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeEqualTo(Date value) {
            addCriterion("LAST_PICK_TIME =", value, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeNotEqualTo(Date value) {
            addCriterion("LAST_PICK_TIME <>", value, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeGreaterThan(Date value) {
            addCriterion("LAST_PICK_TIME >", value, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_PICK_TIME >=", value, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeLessThan(Date value) {
            addCriterion("LAST_PICK_TIME <", value, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_PICK_TIME <=", value, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeIn(List<Date> values) {
            addCriterion("LAST_PICK_TIME in", values, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeNotIn(List<Date> values) {
            addCriterion("LAST_PICK_TIME not in", values, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_PICK_TIME between", value1, value2, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLastPickTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_PICK_TIME not between", value1, value2, "lastPickTime");
            return (Criteria) this;
        }

        public Criteria andLockQtyIsNull() {
            addCriterion("LOCK_QTY is null");
            return (Criteria) this;
        }

        public Criteria andLockQtyIsNotNull() {
            addCriterion("LOCK_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andLockQtyEqualTo(BigDecimal value) {
            addCriterion("LOCK_QTY =", value, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyNotEqualTo(BigDecimal value) {
            addCriterion("LOCK_QTY <>", value, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyGreaterThan(BigDecimal value) {
            addCriterion("LOCK_QTY >", value, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCK_QTY >=", value, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyLessThan(BigDecimal value) {
            addCriterion("LOCK_QTY <", value, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCK_QTY <=", value, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyIn(List<BigDecimal> values) {
            addCriterion("LOCK_QTY in", values, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyNotIn(List<BigDecimal> values) {
            addCriterion("LOCK_QTY not in", values, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCK_QTY between", value1, value2, "lockQty");
            return (Criteria) this;
        }

        public Criteria andLockQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCK_QTY not between", value1, value2, "lockQty");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforIsNull() {
            addCriterion("STK_ON_HAND_BEFOR is null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforIsNotNull() {
            addCriterion("STK_ON_HAND_BEFOR is not null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND_BEFOR =", value, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforNotEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND_BEFOR <>", value, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforGreaterThan(BigDecimal value) {
            addCriterion("STK_ON_HAND_BEFOR >", value, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND_BEFOR >=", value, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforLessThan(BigDecimal value) {
            addCriterion("STK_ON_HAND_BEFOR <", value, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_ON_HAND_BEFOR <=", value, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforIn(List<BigDecimal> values) {
            addCriterion("STK_ON_HAND_BEFOR in", values, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforNotIn(List<BigDecimal> values) {
            addCriterion("STK_ON_HAND_BEFOR not in", values, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_ON_HAND_BEFOR between", value1, value2, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBeforNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_ON_HAND_BEFOR not between", value1, value2, "stkOnHandBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforIsNull() {
            addCriterion("EXPD_QTY_BEFOR is null");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforIsNotNull() {
            addCriterion("EXPD_QTY_BEFOR is not null");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY_BEFOR =", value, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforNotEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY_BEFOR <>", value, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforGreaterThan(BigDecimal value) {
            addCriterion("EXPD_QTY_BEFOR >", value, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY_BEFOR >=", value, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforLessThan(BigDecimal value) {
            addCriterion("EXPD_QTY_BEFOR <", value, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXPD_QTY_BEFOR <=", value, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforIn(List<BigDecimal> values) {
            addCriterion("EXPD_QTY_BEFOR in", values, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforNotIn(List<BigDecimal> values) {
            addCriterion("EXPD_QTY_BEFOR not in", values, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPD_QTY_BEFOR between", value1, value2, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andExpdQtyBeforNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXPD_QTY_BEFOR not between", value1, value2, "expdQtyBefor");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyIsNull() {
            addCriterion("STTK_LOCK_QTY is null");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyIsNotNull() {
            addCriterion("STTK_LOCK_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyEqualTo(BigDecimal value) {
            addCriterion("STTK_LOCK_QTY =", value, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyNotEqualTo(BigDecimal value) {
            addCriterion("STTK_LOCK_QTY <>", value, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyGreaterThan(BigDecimal value) {
            addCriterion("STTK_LOCK_QTY >", value, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STTK_LOCK_QTY >=", value, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyLessThan(BigDecimal value) {
            addCriterion("STTK_LOCK_QTY <", value, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STTK_LOCK_QTY <=", value, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyIn(List<BigDecimal> values) {
            addCriterion("STTK_LOCK_QTY in", values, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyNotIn(List<BigDecimal> values) {
            addCriterion("STTK_LOCK_QTY not in", values, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STTK_LOCK_QTY between", value1, value2, "sttkLockQty");
            return (Criteria) this;
        }

        public Criteria andSttkLockQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STTK_LOCK_QTY not between", value1, value2, "sttkLockQty");
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