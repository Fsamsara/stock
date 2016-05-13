package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfWarehProdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfWarehProdExample() {
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

        public Criteria andBfProductIdIsNull() {
            addCriterion("BF_PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfProductIdIsNotNull() {
            addCriterion("BF_PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfProductIdEqualTo(BigDecimal value) {
            addCriterion("BF_PRODUCT_ID =", value, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_PRODUCT_ID <>", value, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdGreaterThan(BigDecimal value) {
            addCriterion("BF_PRODUCT_ID >", value, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PRODUCT_ID >=", value, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdLessThan(BigDecimal value) {
            addCriterion("BF_PRODUCT_ID <", value, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PRODUCT_ID <=", value, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdIn(List<BigDecimal> values) {
            addCriterion("BF_PRODUCT_ID in", values, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_PRODUCT_ID not in", values, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PRODUCT_ID between", value1, value2, "bfProductId");
            return (Criteria) this;
        }

        public Criteria andBfProductIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PRODUCT_ID not between", value1, value2, "bfProductId");
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

        public Criteria andQtyOnOrderIsNull() {
            addCriterion("QTY_ON_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderIsNotNull() {
            addCriterion("QTY_ON_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_ORDER =", value, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderNotEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_ORDER <>", value, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderGreaterThan(BigDecimal value) {
            addCriterion("QTY_ON_ORDER >", value, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_ORDER >=", value, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderLessThan(BigDecimal value) {
            addCriterion("QTY_ON_ORDER <", value, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_ORDER <=", value, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderIn(List<BigDecimal> values) {
            addCriterion("QTY_ON_ORDER in", values, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderNotIn(List<BigDecimal> values) {
            addCriterion("QTY_ON_ORDER not in", values, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_ON_ORDER between", value1, value2, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyOnOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_ON_ORDER not between", value1, value2, "qtyOnOrder");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitIsNull() {
            addCriterion("QTY_IN_TRANSIT is null");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitIsNotNull() {
            addCriterion("QTY_IN_TRANSIT is not null");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT =", value, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitNotEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT <>", value, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitGreaterThan(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT >", value, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT >=", value, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitLessThan(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT <", value, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT <=", value, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_TRANSIT in", values, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitNotIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_TRANSIT not in", values, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_TRANSIT between", value1, value2, "qtyInTransit");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_TRANSIT not between", value1, value2, "qtyInTransit");
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

        public Criteria andQtyInDoubtIsNull() {
            addCriterion("QTY_IN_DOUBT is null");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtIsNotNull() {
            addCriterion("QTY_IN_DOUBT is not null");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_DOUBT =", value, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtNotEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_DOUBT <>", value, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtGreaterThan(BigDecimal value) {
            addCriterion("QTY_IN_DOUBT >", value, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_DOUBT >=", value, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtLessThan(BigDecimal value) {
            addCriterion("QTY_IN_DOUBT <", value, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_DOUBT <=", value, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_DOUBT in", values, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtNotIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_DOUBT not in", values, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_DOUBT between", value1, value2, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andQtyInDoubtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_DOUBT not between", value1, value2, "qtyInDoubt");
            return (Criteria) this;
        }

        public Criteria andStkPublishedIsNull() {
            addCriterion("STK_PUBLISHED is null");
            return (Criteria) this;
        }

        public Criteria andStkPublishedIsNotNull() {
            addCriterion("STK_PUBLISHED is not null");
            return (Criteria) this;
        }

        public Criteria andStkPublishedEqualTo(BigDecimal value) {
            addCriterion("STK_PUBLISHED =", value, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedNotEqualTo(BigDecimal value) {
            addCriterion("STK_PUBLISHED <>", value, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedGreaterThan(BigDecimal value) {
            addCriterion("STK_PUBLISHED >", value, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_PUBLISHED >=", value, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedLessThan(BigDecimal value) {
            addCriterion("STK_PUBLISHED <", value, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_PUBLISHED <=", value, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedIn(List<BigDecimal> values) {
            addCriterion("STK_PUBLISHED in", values, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedNotIn(List<BigDecimal> values) {
            addCriterion("STK_PUBLISHED not in", values, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_PUBLISHED between", value1, value2, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andStkPublishedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_PUBLISHED not between", value1, value2, "stkPublished");
            return (Criteria) this;
        }

        public Criteria andMinStkIsNull() {
            addCriterion("MIN_STK is null");
            return (Criteria) this;
        }

        public Criteria andMinStkIsNotNull() {
            addCriterion("MIN_STK is not null");
            return (Criteria) this;
        }

        public Criteria andMinStkEqualTo(BigDecimal value) {
            addCriterion("MIN_STK =", value, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkNotEqualTo(BigDecimal value) {
            addCriterion("MIN_STK <>", value, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkGreaterThan(BigDecimal value) {
            addCriterion("MIN_STK >", value, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_STK >=", value, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkLessThan(BigDecimal value) {
            addCriterion("MIN_STK <", value, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_STK <=", value, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkIn(List<BigDecimal> values) {
            addCriterion("MIN_STK in", values, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkNotIn(List<BigDecimal> values) {
            addCriterion("MIN_STK not in", values, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_STK between", value1, value2, "minStk");
            return (Criteria) this;
        }

        public Criteria andMinStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_STK not between", value1, value2, "minStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkIsNull() {
            addCriterion("MAX_STK is null");
            return (Criteria) this;
        }

        public Criteria andMaxStkIsNotNull() {
            addCriterion("MAX_STK is not null");
            return (Criteria) this;
        }

        public Criteria andMaxStkEqualTo(BigDecimal value) {
            addCriterion("MAX_STK =", value, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkNotEqualTo(BigDecimal value) {
            addCriterion("MAX_STK <>", value, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkGreaterThan(BigDecimal value) {
            addCriterion("MAX_STK >", value, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_STK >=", value, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkLessThan(BigDecimal value) {
            addCriterion("MAX_STK <", value, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_STK <=", value, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkIn(List<BigDecimal> values) {
            addCriterion("MAX_STK in", values, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkNotIn(List<BigDecimal> values) {
            addCriterion("MAX_STK not in", values, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_STK between", value1, value2, "maxStk");
            return (Criteria) this;
        }

        public Criteria andMaxStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_STK not between", value1, value2, "maxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkIsNull() {
            addCriterion("ALERT_MIN_STK is null");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkIsNotNull() {
            addCriterion("ALERT_MIN_STK is not null");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkEqualTo(BigDecimal value) {
            addCriterion("ALERT_MIN_STK =", value, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkNotEqualTo(BigDecimal value) {
            addCriterion("ALERT_MIN_STK <>", value, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkGreaterThan(BigDecimal value) {
            addCriterion("ALERT_MIN_STK >", value, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALERT_MIN_STK >=", value, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkLessThan(BigDecimal value) {
            addCriterion("ALERT_MIN_STK <", value, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALERT_MIN_STK <=", value, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkIn(List<BigDecimal> values) {
            addCriterion("ALERT_MIN_STK in", values, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkNotIn(List<BigDecimal> values) {
            addCriterion("ALERT_MIN_STK not in", values, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALERT_MIN_STK between", value1, value2, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMinStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALERT_MIN_STK not between", value1, value2, "alertMinStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkIsNull() {
            addCriterion("ALERT_MAX_STK is null");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkIsNotNull() {
            addCriterion("ALERT_MAX_STK is not null");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkEqualTo(BigDecimal value) {
            addCriterion("ALERT_MAX_STK =", value, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkNotEqualTo(BigDecimal value) {
            addCriterion("ALERT_MAX_STK <>", value, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkGreaterThan(BigDecimal value) {
            addCriterion("ALERT_MAX_STK >", value, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALERT_MAX_STK >=", value, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkLessThan(BigDecimal value) {
            addCriterion("ALERT_MAX_STK <", value, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALERT_MAX_STK <=", value, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkIn(List<BigDecimal> values) {
            addCriterion("ALERT_MAX_STK in", values, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkNotIn(List<BigDecimal> values) {
            addCriterion("ALERT_MAX_STK not in", values, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALERT_MAX_STK between", value1, value2, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andAlertMaxStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALERT_MAX_STK not between", value1, value2, "alertMaxStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkIsNull() {
            addCriterion("MIN_AD_STK is null");
            return (Criteria) this;
        }

        public Criteria andMinAdStkIsNotNull() {
            addCriterion("MIN_AD_STK is not null");
            return (Criteria) this;
        }

        public Criteria andMinAdStkEqualTo(BigDecimal value) {
            addCriterion("MIN_AD_STK =", value, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkNotEqualTo(BigDecimal value) {
            addCriterion("MIN_AD_STK <>", value, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkGreaterThan(BigDecimal value) {
            addCriterion("MIN_AD_STK >", value, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_AD_STK >=", value, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkLessThan(BigDecimal value) {
            addCriterion("MIN_AD_STK <", value, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_AD_STK <=", value, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkIn(List<BigDecimal> values) {
            addCriterion("MIN_AD_STK in", values, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkNotIn(List<BigDecimal> values) {
            addCriterion("MIN_AD_STK not in", values, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_AD_STK between", value1, value2, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMinAdStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_AD_STK not between", value1, value2, "minAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkIsNull() {
            addCriterion("MAX_AD_STK is null");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkIsNotNull() {
            addCriterion("MAX_AD_STK is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkEqualTo(BigDecimal value) {
            addCriterion("MAX_AD_STK =", value, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkNotEqualTo(BigDecimal value) {
            addCriterion("MAX_AD_STK <>", value, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkGreaterThan(BigDecimal value) {
            addCriterion("MAX_AD_STK >", value, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_AD_STK >=", value, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkLessThan(BigDecimal value) {
            addCriterion("MAX_AD_STK <", value, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MAX_AD_STK <=", value, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkIn(List<BigDecimal> values) {
            addCriterion("MAX_AD_STK in", values, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkNotIn(List<BigDecimal> values) {
            addCriterion("MAX_AD_STK not in", values, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_AD_STK between", value1, value2, "maxAdStk");
            return (Criteria) this;
        }

        public Criteria andMaxAdStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MAX_AD_STK not between", value1, value2, "maxAdStk");
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

        public Criteria andStdLocCapIsNull() {
            addCriterion("STD_LOC_CAP is null");
            return (Criteria) this;
        }

        public Criteria andStdLocCapIsNotNull() {
            addCriterion("STD_LOC_CAP is not null");
            return (Criteria) this;
        }

        public Criteria andStdLocCapEqualTo(Integer value) {
            addCriterion("STD_LOC_CAP =", value, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapNotEqualTo(Integer value) {
            addCriterion("STD_LOC_CAP <>", value, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapGreaterThan(Integer value) {
            addCriterion("STD_LOC_CAP >", value, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("STD_LOC_CAP >=", value, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapLessThan(Integer value) {
            addCriterion("STD_LOC_CAP <", value, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapLessThanOrEqualTo(Integer value) {
            addCriterion("STD_LOC_CAP <=", value, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapIn(List<Integer> values) {
            addCriterion("STD_LOC_CAP in", values, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapNotIn(List<Integer> values) {
            addCriterion("STD_LOC_CAP not in", values, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapBetween(Integer value1, Integer value2) {
            addCriterion("STD_LOC_CAP between", value1, value2, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStdLocCapNotBetween(Integer value1, Integer value2) {
            addCriterion("STD_LOC_CAP not between", value1, value2, "stdLocCap");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeIsNull() {
            addCriterion("STK_JUST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeIsNotNull() {
            addCriterion("STK_JUST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeEqualTo(BigDecimal value) {
            addCriterion("STK_JUST_TIME =", value, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeNotEqualTo(BigDecimal value) {
            addCriterion("STK_JUST_TIME <>", value, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeGreaterThan(BigDecimal value) {
            addCriterion("STK_JUST_TIME >", value, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_JUST_TIME >=", value, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeLessThan(BigDecimal value) {
            addCriterion("STK_JUST_TIME <", value, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STK_JUST_TIME <=", value, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeIn(List<BigDecimal> values) {
            addCriterion("STK_JUST_TIME in", values, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeNotIn(List<BigDecimal> values) {
            addCriterion("STK_JUST_TIME not in", values, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_JUST_TIME between", value1, value2, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andStkJustTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STK_JUST_TIME not between", value1, value2, "stkJustTime");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommIsNull() {
            addCriterion("QTY_CUR_COMM is null");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommIsNotNull() {
            addCriterion("QTY_CUR_COMM is not null");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommEqualTo(BigDecimal value) {
            addCriterion("QTY_CUR_COMM =", value, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommNotEqualTo(BigDecimal value) {
            addCriterion("QTY_CUR_COMM <>", value, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommGreaterThan(BigDecimal value) {
            addCriterion("QTY_CUR_COMM >", value, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_CUR_COMM >=", value, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommLessThan(BigDecimal value) {
            addCriterion("QTY_CUR_COMM <", value, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_CUR_COMM <=", value, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommIn(List<BigDecimal> values) {
            addCriterion("QTY_CUR_COMM in", values, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommNotIn(List<BigDecimal> values) {
            addCriterion("QTY_CUR_COMM not in", values, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_CUR_COMM between", value1, value2, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyCurCommNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_CUR_COMM not between", value1, value2, "qtyCurComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommIsNull() {
            addCriterion("QTY_FUC_COMM is null");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommIsNotNull() {
            addCriterion("QTY_FUC_COMM is not null");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommEqualTo(BigDecimal value) {
            addCriterion("QTY_FUC_COMM =", value, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommNotEqualTo(BigDecimal value) {
            addCriterion("QTY_FUC_COMM <>", value, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommGreaterThan(BigDecimal value) {
            addCriterion("QTY_FUC_COMM >", value, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_FUC_COMM >=", value, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommLessThan(BigDecimal value) {
            addCriterion("QTY_FUC_COMM <", value, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_FUC_COMM <=", value, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommIn(List<BigDecimal> values) {
            addCriterion("QTY_FUC_COMM in", values, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommNotIn(List<BigDecimal> values) {
            addCriterion("QTY_FUC_COMM not in", values, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_FUC_COMM between", value1, value2, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyFucCommNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_FUC_COMM not between", value1, value2, "qtyFucComm");
            return (Criteria) this;
        }

        public Criteria andQtyTypeIsNull() {
            addCriterion("QTY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQtyTypeIsNotNull() {
            addCriterion("QTY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQtyTypeEqualTo(String value) {
            addCriterion("QTY_TYPE =", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeNotEqualTo(String value) {
            addCriterion("QTY_TYPE <>", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeGreaterThan(String value) {
            addCriterion("QTY_TYPE >", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("QTY_TYPE >=", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeLessThan(String value) {
            addCriterion("QTY_TYPE <", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeLessThanOrEqualTo(String value) {
            addCriterion("QTY_TYPE <=", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeLike(String value) {
            addCriterion("QTY_TYPE like", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeNotLike(String value) {
            addCriterion("QTY_TYPE not like", value, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeIn(List<String> values) {
            addCriterion("QTY_TYPE in", values, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeNotIn(List<String> values) {
            addCriterion("QTY_TYPE not in", values, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeBetween(String value1, String value2) {
            addCriterion("QTY_TYPE between", value1, value2, "qtyType");
            return (Criteria) this;
        }

        public Criteria andQtyTypeNotBetween(String value1, String value2) {
            addCriterion("QTY_TYPE not between", value1, value2, "qtyType");
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

        public Criteria andQtyOnLockIsNull() {
            addCriterion("QTY_ON_LOCK is null");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockIsNotNull() {
            addCriterion("QTY_ON_LOCK is not null");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_LOCK =", value, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockNotEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_LOCK <>", value, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockGreaterThan(BigDecimal value) {
            addCriterion("QTY_ON_LOCK >", value, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_LOCK >=", value, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockLessThan(BigDecimal value) {
            addCriterion("QTY_ON_LOCK <", value, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_ON_LOCK <=", value, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockIn(List<BigDecimal> values) {
            addCriterion("QTY_ON_LOCK in", values, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockNotIn(List<BigDecimal> values) {
            addCriterion("QTY_ON_LOCK not in", values, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_ON_LOCK between", value1, value2, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andQtyOnLockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_ON_LOCK not between", value1, value2, "qtyOnLock");
            return (Criteria) this;
        }

        public Criteria andInRcvStkIsNull() {
            addCriterion("IN_RCV_STK is null");
            return (Criteria) this;
        }

        public Criteria andInRcvStkIsNotNull() {
            addCriterion("IN_RCV_STK is not null");
            return (Criteria) this;
        }

        public Criteria andInRcvStkEqualTo(BigDecimal value) {
            addCriterion("IN_RCV_STK =", value, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkNotEqualTo(BigDecimal value) {
            addCriterion("IN_RCV_STK <>", value, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkGreaterThan(BigDecimal value) {
            addCriterion("IN_RCV_STK >", value, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("IN_RCV_STK >=", value, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkLessThan(BigDecimal value) {
            addCriterion("IN_RCV_STK <", value, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("IN_RCV_STK <=", value, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkIn(List<BigDecimal> values) {
            addCriterion("IN_RCV_STK in", values, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkNotIn(List<BigDecimal> values) {
            addCriterion("IN_RCV_STK not in", values, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IN_RCV_STK between", value1, value2, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andInRcvStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("IN_RCV_STK not between", value1, value2, "inRcvStk");
            return (Criteria) this;
        }

        public Criteria andCurCostIsNull() {
            addCriterion("CUR_COST is null");
            return (Criteria) this;
        }

        public Criteria andCurCostIsNotNull() {
            addCriterion("CUR_COST is not null");
            return (Criteria) this;
        }

        public Criteria andCurCostEqualTo(BigDecimal value) {
            addCriterion("CUR_COST =", value, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostNotEqualTo(BigDecimal value) {
            addCriterion("CUR_COST <>", value, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostGreaterThan(BigDecimal value) {
            addCriterion("CUR_COST >", value, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CUR_COST >=", value, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostLessThan(BigDecimal value) {
            addCriterion("CUR_COST <", value, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CUR_COST <=", value, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostIn(List<BigDecimal> values) {
            addCriterion("CUR_COST in", values, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostNotIn(List<BigDecimal> values) {
            addCriterion("CUR_COST not in", values, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUR_COST between", value1, value2, "curCost");
            return (Criteria) this;
        }

        public Criteria andCurCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CUR_COST not between", value1, value2, "curCost");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgIsNull() {
            addCriterion("QTY_IN_TRANSIT_AG is null");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgIsNotNull() {
            addCriterion("QTY_IN_TRANSIT_AG is not null");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT_AG =", value, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgNotEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT_AG <>", value, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgGreaterThan(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT_AG >", value, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT_AG >=", value, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgLessThan(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT_AG <", value, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY_IN_TRANSIT_AG <=", value, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_TRANSIT_AG in", values, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgNotIn(List<BigDecimal> values) {
            addCriterion("QTY_IN_TRANSIT_AG not in", values, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_TRANSIT_AG between", value1, value2, "qtyInTransitAg");
            return (Criteria) this;
        }

        public Criteria andQtyInTransitAgNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY_IN_TRANSIT_AG not between", value1, value2, "qtyInTransitAg");
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

        public Criteria andReservedCommittedQtyIsNull() {
            addCriterion("RESERVED_COMMITTED_QTY is null");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyIsNotNull() {
            addCriterion("RESERVED_COMMITTED_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyEqualTo(BigDecimal value) {
            addCriterion("RESERVED_COMMITTED_QTY =", value, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyNotEqualTo(BigDecimal value) {
            addCriterion("RESERVED_COMMITTED_QTY <>", value, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyGreaterThan(BigDecimal value) {
            addCriterion("RESERVED_COMMITTED_QTY >", value, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_COMMITTED_QTY >=", value, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyLessThan(BigDecimal value) {
            addCriterion("RESERVED_COMMITTED_QTY <", value, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RESERVED_COMMITTED_QTY <=", value, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyIn(List<BigDecimal> values) {
            addCriterion("RESERVED_COMMITTED_QTY in", values, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyNotIn(List<BigDecimal> values) {
            addCriterion("RESERVED_COMMITTED_QTY not in", values, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_COMMITTED_QTY between", value1, value2, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andReservedCommittedQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RESERVED_COMMITTED_QTY not between", value1, value2, "reservedCommittedQty");
            return (Criteria) this;
        }

        public Criteria andLockStockinIsNull() {
            addCriterion("LOCK_STOCKIN is null");
            return (Criteria) this;
        }

        public Criteria andLockStockinIsNotNull() {
            addCriterion("LOCK_STOCKIN is not null");
            return (Criteria) this;
        }

        public Criteria andLockStockinEqualTo(BigDecimal value) {
            addCriterion("LOCK_STOCKIN =", value, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinNotEqualTo(BigDecimal value) {
            addCriterion("LOCK_STOCKIN <>", value, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinGreaterThan(BigDecimal value) {
            addCriterion("LOCK_STOCKIN >", value, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCK_STOCKIN >=", value, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinLessThan(BigDecimal value) {
            addCriterion("LOCK_STOCKIN <", value, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOCK_STOCKIN <=", value, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinIn(List<BigDecimal> values) {
            addCriterion("LOCK_STOCKIN in", values, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinNotIn(List<BigDecimal> values) {
            addCriterion("LOCK_STOCKIN not in", values, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCK_STOCKIN between", value1, value2, "lockStockin");
            return (Criteria) this;
        }

        public Criteria andLockStockinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOCK_STOCKIN not between", value1, value2, "lockStockin");
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

        public Criteria andStockinFreeIsNull() {
            addCriterion("STOCKIN_FREE is null");
            return (Criteria) this;
        }

        public Criteria andStockinFreeIsNotNull() {
            addCriterion("STOCKIN_FREE is not null");
            return (Criteria) this;
        }

        public Criteria andStockinFreeEqualTo(BigDecimal value) {
            addCriterion("STOCKIN_FREE =", value, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeNotEqualTo(BigDecimal value) {
            addCriterion("STOCKIN_FREE <>", value, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeGreaterThan(BigDecimal value) {
            addCriterion("STOCKIN_FREE >", value, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STOCKIN_FREE >=", value, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeLessThan(BigDecimal value) {
            addCriterion("STOCKIN_FREE <", value, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STOCKIN_FREE <=", value, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeIn(List<BigDecimal> values) {
            addCriterion("STOCKIN_FREE in", values, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeNotIn(List<BigDecimal> values) {
            addCriterion("STOCKIN_FREE not in", values, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STOCKIN_FREE between", value1, value2, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andStockinFreeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STOCKIN_FREE not between", value1, value2, "stockinFree");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyIsNull() {
            addCriterion("B2B_LOCKED_QTY is null");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyIsNotNull() {
            addCriterion("B2B_LOCKED_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyEqualTo(BigDecimal value) {
            addCriterion("B2B_LOCKED_QTY =", value, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyNotEqualTo(BigDecimal value) {
            addCriterion("B2B_LOCKED_QTY <>", value, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyGreaterThan(BigDecimal value) {
            addCriterion("B2B_LOCKED_QTY >", value, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("B2B_LOCKED_QTY >=", value, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyLessThan(BigDecimal value) {
            addCriterion("B2B_LOCKED_QTY <", value, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("B2B_LOCKED_QTY <=", value, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyIn(List<BigDecimal> values) {
            addCriterion("B2B_LOCKED_QTY in", values, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyNotIn(List<BigDecimal> values) {
            addCriterion("B2B_LOCKED_QTY not in", values, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2B_LOCKED_QTY between", value1, value2, "b2bLockedQty");
            return (Criteria) this;
        }

        public Criteria andB2bLockedQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2B_LOCKED_QTY not between", value1, value2, "b2bLockedQty");
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