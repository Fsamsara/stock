package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehProdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WarehProdExample() {
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

        public Criteria andDfltZoneIdIsNull() {
            addCriterion("DFLT_ZONE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdIsNotNull() {
            addCriterion("DFLT_ZONE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdEqualTo(String value) {
            addCriterion("DFLT_ZONE_ID =", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdNotEqualTo(String value) {
            addCriterion("DFLT_ZONE_ID <>", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdGreaterThan(String value) {
            addCriterion("DFLT_ZONE_ID >", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdGreaterThanOrEqualTo(String value) {
            addCriterion("DFLT_ZONE_ID >=", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdLessThan(String value) {
            addCriterion("DFLT_ZONE_ID <", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdLessThanOrEqualTo(String value) {
            addCriterion("DFLT_ZONE_ID <=", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdLike(String value) {
            addCriterion("DFLT_ZONE_ID like", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdNotLike(String value) {
            addCriterion("DFLT_ZONE_ID not like", value, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdIn(List<String> values) {
            addCriterion("DFLT_ZONE_ID in", values, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdNotIn(List<String> values) {
            addCriterion("DFLT_ZONE_ID not in", values, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdBetween(String value1, String value2) {
            addCriterion("DFLT_ZONE_ID between", value1, value2, "dfltZoneId");
            return (Criteria) this;
        }

        public Criteria andDfltZoneIdNotBetween(String value1, String value2) {
            addCriterion("DFLT_ZONE_ID not between", value1, value2, "dfltZoneId");
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

        public Criteria andDfltLocIdIsNull() {
            addCriterion("DFLT_LOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdIsNotNull() {
            addCriterion("DFLT_LOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdEqualTo(String value) {
            addCriterion("DFLT_LOC_ID =", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdNotEqualTo(String value) {
            addCriterion("DFLT_LOC_ID <>", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdGreaterThan(String value) {
            addCriterion("DFLT_LOC_ID >", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdGreaterThanOrEqualTo(String value) {
            addCriterion("DFLT_LOC_ID >=", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdLessThan(String value) {
            addCriterion("DFLT_LOC_ID <", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdLessThanOrEqualTo(String value) {
            addCriterion("DFLT_LOC_ID <=", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdLike(String value) {
            addCriterion("DFLT_LOC_ID like", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdNotLike(String value) {
            addCriterion("DFLT_LOC_ID not like", value, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdIn(List<String> values) {
            addCriterion("DFLT_LOC_ID in", values, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdNotIn(List<String> values) {
            addCriterion("DFLT_LOC_ID not in", values, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdBetween(String value1, String value2) {
            addCriterion("DFLT_LOC_ID between", value1, value2, "dfltLocId");
            return (Criteria) this;
        }

        public Criteria andDfltLocIdNotBetween(String value1, String value2) {
            addCriterion("DFLT_LOC_ID not between", value1, value2, "dfltLocId");
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

        public Criteria andBgrStkIsNull() {
            addCriterion("BGR_STK is null");
            return (Criteria) this;
        }

        public Criteria andBgrStkIsNotNull() {
            addCriterion("BGR_STK is not null");
            return (Criteria) this;
        }

        public Criteria andBgrStkEqualTo(BigDecimal value) {
            addCriterion("BGR_STK =", value, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkNotEqualTo(BigDecimal value) {
            addCriterion("BGR_STK <>", value, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkGreaterThan(BigDecimal value) {
            addCriterion("BGR_STK >", value, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BGR_STK >=", value, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkLessThan(BigDecimal value) {
            addCriterion("BGR_STK <", value, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BGR_STK <=", value, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkIn(List<BigDecimal> values) {
            addCriterion("BGR_STK in", values, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkNotIn(List<BigDecimal> values) {
            addCriterion("BGR_STK not in", values, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BGR_STK between", value1, value2, "bgrStk");
            return (Criteria) this;
        }

        public Criteria andBgrStkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BGR_STK not between", value1, value2, "bgrStk");
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