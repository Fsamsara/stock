package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UdWarehParamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UdWarehParamExample() {
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

        public Criteria andOrgTypeIsNull() {
            addCriterion("ORG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("ORG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("ORG_TYPE =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("ORG_TYPE <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("ORG_TYPE >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("ORG_TYPE <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("ORG_TYPE <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("ORG_TYPE like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("ORG_TYPE not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("ORG_TYPE in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("ORG_TYPE not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("ORG_TYPE between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("ORG_TYPE not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdIsNull() {
            addCriterion("VIRTUAL_WAREHOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdIsNotNull() {
            addCriterion("VIRTUAL_WAREHOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdEqualTo(BigDecimal value) {
            addCriterion("VIRTUAL_WAREHOUSE_ID =", value, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdNotEqualTo(BigDecimal value) {
            addCriterion("VIRTUAL_WAREHOUSE_ID <>", value, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdGreaterThan(BigDecimal value) {
            addCriterion("VIRTUAL_WAREHOUSE_ID >", value, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VIRTUAL_WAREHOUSE_ID >=", value, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdLessThan(BigDecimal value) {
            addCriterion("VIRTUAL_WAREHOUSE_ID <", value, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VIRTUAL_WAREHOUSE_ID <=", value, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdIn(List<BigDecimal> values) {
            addCriterion("VIRTUAL_WAREHOUSE_ID in", values, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdNotIn(List<BigDecimal> values) {
            addCriterion("VIRTUAL_WAREHOUSE_ID not in", values, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VIRTUAL_WAREHOUSE_ID between", value1, value2, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andVirtualWarehouseIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VIRTUAL_WAREHOUSE_ID not between", value1, value2, "virtualWarehouseId");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyIsNull() {
            addCriterion("B2C_STARTING_QTY is null");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyIsNotNull() {
            addCriterion("B2C_STARTING_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyEqualTo(BigDecimal value) {
            addCriterion("B2C_STARTING_QTY =", value, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyNotEqualTo(BigDecimal value) {
            addCriterion("B2C_STARTING_QTY <>", value, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyGreaterThan(BigDecimal value) {
            addCriterion("B2C_STARTING_QTY >", value, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("B2C_STARTING_QTY >=", value, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyLessThan(BigDecimal value) {
            addCriterion("B2C_STARTING_QTY <", value, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("B2C_STARTING_QTY <=", value, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyIn(List<BigDecimal> values) {
            addCriterion("B2C_STARTING_QTY in", values, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyNotIn(List<BigDecimal> values) {
            addCriterion("B2C_STARTING_QTY not in", values, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2C_STARTING_QTY between", value1, value2, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cStartingQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2C_STARTING_QTY not between", value1, value2, "b2cStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueIsNull() {
            addCriterion("B2C_DIST_PEAK_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueIsNotNull() {
            addCriterion("B2C_DIST_PEAK_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueEqualTo(BigDecimal value) {
            addCriterion("B2C_DIST_PEAK_VALUE =", value, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueNotEqualTo(BigDecimal value) {
            addCriterion("B2C_DIST_PEAK_VALUE <>", value, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueGreaterThan(BigDecimal value) {
            addCriterion("B2C_DIST_PEAK_VALUE >", value, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("B2C_DIST_PEAK_VALUE >=", value, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueLessThan(BigDecimal value) {
            addCriterion("B2C_DIST_PEAK_VALUE <", value, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("B2C_DIST_PEAK_VALUE <=", value, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueIn(List<BigDecimal> values) {
            addCriterion("B2C_DIST_PEAK_VALUE in", values, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueNotIn(List<BigDecimal> values) {
            addCriterion("B2C_DIST_PEAK_VALUE not in", values, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2C_DIST_PEAK_VALUE between", value1, value2, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2cDistPeakValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2C_DIST_PEAK_VALUE not between", value1, value2, "b2cDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyIsNull() {
            addCriterion("B2B_STARTING_QTY is null");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyIsNotNull() {
            addCriterion("B2B_STARTING_QTY is not null");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyEqualTo(BigDecimal value) {
            addCriterion("B2B_STARTING_QTY =", value, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyNotEqualTo(BigDecimal value) {
            addCriterion("B2B_STARTING_QTY <>", value, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyGreaterThan(BigDecimal value) {
            addCriterion("B2B_STARTING_QTY >", value, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("B2B_STARTING_QTY >=", value, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyLessThan(BigDecimal value) {
            addCriterion("B2B_STARTING_QTY <", value, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("B2B_STARTING_QTY <=", value, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyIn(List<BigDecimal> values) {
            addCriterion("B2B_STARTING_QTY in", values, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyNotIn(List<BigDecimal> values) {
            addCriterion("B2B_STARTING_QTY not in", values, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2B_STARTING_QTY between", value1, value2, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bStartingQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2B_STARTING_QTY not between", value1, value2, "b2bStartingQty");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueIsNull() {
            addCriterion("B2B_DIST_PEAK_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueIsNotNull() {
            addCriterion("B2B_DIST_PEAK_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueEqualTo(BigDecimal value) {
            addCriterion("B2B_DIST_PEAK_VALUE =", value, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueNotEqualTo(BigDecimal value) {
            addCriterion("B2B_DIST_PEAK_VALUE <>", value, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueGreaterThan(BigDecimal value) {
            addCriterion("B2B_DIST_PEAK_VALUE >", value, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("B2B_DIST_PEAK_VALUE >=", value, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueLessThan(BigDecimal value) {
            addCriterion("B2B_DIST_PEAK_VALUE <", value, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("B2B_DIST_PEAK_VALUE <=", value, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueIn(List<BigDecimal> values) {
            addCriterion("B2B_DIST_PEAK_VALUE in", values, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueNotIn(List<BigDecimal> values) {
            addCriterion("B2B_DIST_PEAK_VALUE not in", values, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2B_DIST_PEAK_VALUE between", value1, value2, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andB2bDistPeakValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("B2B_DIST_PEAK_VALUE not between", value1, value2, "b2bDistPeakValue");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeIsNull() {
            addCriterion("ONLINE_SAFEQTY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeIsNotNull() {
            addCriterion("ONLINE_SAFEQTY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeEqualTo(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE =", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeNotEqualTo(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE <>", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeGreaterThan(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE >", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE >=", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeLessThan(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE <", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeLessThanOrEqualTo(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE <=", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeLike(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE like", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeNotLike(String value) {
            addCriterion("ONLINE_SAFEQTY_TYPE not like", value, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeIn(List<String> values) {
            addCriterion("ONLINE_SAFEQTY_TYPE in", values, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeNotIn(List<String> values) {
            addCriterion("ONLINE_SAFEQTY_TYPE not in", values, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeBetween(String value1, String value2) {
            addCriterion("ONLINE_SAFEQTY_TYPE between", value1, value2, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOnlineSafeqtyTypeNotBetween(String value1, String value2) {
            addCriterion("ONLINE_SAFEQTY_TYPE not between", value1, value2, "onlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeIsNull() {
            addCriterion("OFFLINE_SAFEQTY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeIsNotNull() {
            addCriterion("OFFLINE_SAFEQTY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeEqualTo(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE =", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeNotEqualTo(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE <>", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeGreaterThan(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE >", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE >=", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeLessThan(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE <", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeLessThanOrEqualTo(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE <=", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeLike(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE like", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeNotLike(String value) {
            addCriterion("OFFLINE_SAFEQTY_TYPE not like", value, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeIn(List<String> values) {
            addCriterion("OFFLINE_SAFEQTY_TYPE in", values, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeNotIn(List<String> values) {
            addCriterion("OFFLINE_SAFEQTY_TYPE not in", values, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeBetween(String value1, String value2) {
            addCriterion("OFFLINE_SAFEQTY_TYPE between", value1, value2, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andOfflineSafeqtyTypeNotBetween(String value1, String value2) {
            addCriterion("OFFLINE_SAFEQTY_TYPE not between", value1, value2, "offlineSafeqtyType");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("FLAG like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("FLAG not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andUpFlagIsNull() {
            addCriterion("UP_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUpFlagIsNotNull() {
            addCriterion("UP_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUpFlagEqualTo(String value) {
            addCriterion("UP_FLAG =", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagNotEqualTo(String value) {
            addCriterion("UP_FLAG <>", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagGreaterThan(String value) {
            addCriterion("UP_FLAG >", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagGreaterThanOrEqualTo(String value) {
            addCriterion("UP_FLAG >=", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagLessThan(String value) {
            addCriterion("UP_FLAG <", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagLessThanOrEqualTo(String value) {
            addCriterion("UP_FLAG <=", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagLike(String value) {
            addCriterion("UP_FLAG like", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagNotLike(String value) {
            addCriterion("UP_FLAG not like", value, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagIn(List<String> values) {
            addCriterion("UP_FLAG in", values, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagNotIn(List<String> values) {
            addCriterion("UP_FLAG not in", values, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagBetween(String value1, String value2) {
            addCriterion("UP_FLAG between", value1, value2, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUpFlagNotBetween(String value1, String value2) {
            addCriterion("UP_FLAG not between", value1, value2, "upFlag");
            return (Criteria) this;
        }

        public Criteria andUdOnlineIsNull() {
            addCriterion("UD_ONLINE is null");
            return (Criteria) this;
        }

        public Criteria andUdOnlineIsNotNull() {
            addCriterion("UD_ONLINE is not null");
            return (Criteria) this;
        }

        public Criteria andUdOnlineEqualTo(String value) {
            addCriterion("UD_ONLINE =", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineNotEqualTo(String value) {
            addCriterion("UD_ONLINE <>", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineGreaterThan(String value) {
            addCriterion("UD_ONLINE >", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("UD_ONLINE >=", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineLessThan(String value) {
            addCriterion("UD_ONLINE <", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineLessThanOrEqualTo(String value) {
            addCriterion("UD_ONLINE <=", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineLike(String value) {
            addCriterion("UD_ONLINE like", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineNotLike(String value) {
            addCriterion("UD_ONLINE not like", value, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineIn(List<String> values) {
            addCriterion("UD_ONLINE in", values, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineNotIn(List<String> values) {
            addCriterion("UD_ONLINE not in", values, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineBetween(String value1, String value2) {
            addCriterion("UD_ONLINE between", value1, value2, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOnlineNotBetween(String value1, String value2) {
            addCriterion("UD_ONLINE not between", value1, value2, "udOnline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineIsNull() {
            addCriterion("UD_OFFLINE is null");
            return (Criteria) this;
        }

        public Criteria andUdOfflineIsNotNull() {
            addCriterion("UD_OFFLINE is not null");
            return (Criteria) this;
        }

        public Criteria andUdOfflineEqualTo(String value) {
            addCriterion("UD_OFFLINE =", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineNotEqualTo(String value) {
            addCriterion("UD_OFFLINE <>", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineGreaterThan(String value) {
            addCriterion("UD_OFFLINE >", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineGreaterThanOrEqualTo(String value) {
            addCriterion("UD_OFFLINE >=", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineLessThan(String value) {
            addCriterion("UD_OFFLINE <", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineLessThanOrEqualTo(String value) {
            addCriterion("UD_OFFLINE <=", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineLike(String value) {
            addCriterion("UD_OFFLINE like", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineNotLike(String value) {
            addCriterion("UD_OFFLINE not like", value, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineIn(List<String> values) {
            addCriterion("UD_OFFLINE in", values, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineNotIn(List<String> values) {
            addCriterion("UD_OFFLINE not in", values, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineBetween(String value1, String value2) {
            addCriterion("UD_OFFLINE between", value1, value2, "udOffline");
            return (Criteria) this;
        }

        public Criteria andUdOfflineNotBetween(String value1, String value2) {
            addCriterion("UD_OFFLINE not between", value1, value2, "udOffline");
            return (Criteria) this;
        }

        public Criteria andShippingIdIsNull() {
            addCriterion("SHIPPING_ID is null");
            return (Criteria) this;
        }

        public Criteria andShippingIdIsNotNull() {
            addCriterion("SHIPPING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShippingIdEqualTo(BigDecimal value) {
            addCriterion("SHIPPING_ID =", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdNotEqualTo(BigDecimal value) {
            addCriterion("SHIPPING_ID <>", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdGreaterThan(BigDecimal value) {
            addCriterion("SHIPPING_ID >", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SHIPPING_ID >=", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdLessThan(BigDecimal value) {
            addCriterion("SHIPPING_ID <", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SHIPPING_ID <=", value, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdIn(List<BigDecimal> values) {
            addCriterion("SHIPPING_ID in", values, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdNotIn(List<BigDecimal> values) {
            addCriterion("SHIPPING_ID not in", values, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHIPPING_ID between", value1, value2, "shippingId");
            return (Criteria) this;
        }

        public Criteria andShippingIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHIPPING_ID not between", value1, value2, "shippingId");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocIsNull() {
            addCriterion("HAND_CREATE_DOC is null");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocIsNotNull() {
            addCriterion("HAND_CREATE_DOC is not null");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocEqualTo(String value) {
            addCriterion("HAND_CREATE_DOC =", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocNotEqualTo(String value) {
            addCriterion("HAND_CREATE_DOC <>", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocGreaterThan(String value) {
            addCriterion("HAND_CREATE_DOC >", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocGreaterThanOrEqualTo(String value) {
            addCriterion("HAND_CREATE_DOC >=", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocLessThan(String value) {
            addCriterion("HAND_CREATE_DOC <", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocLessThanOrEqualTo(String value) {
            addCriterion("HAND_CREATE_DOC <=", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocLike(String value) {
            addCriterion("HAND_CREATE_DOC like", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocNotLike(String value) {
            addCriterion("HAND_CREATE_DOC not like", value, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocIn(List<String> values) {
            addCriterion("HAND_CREATE_DOC in", values, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocNotIn(List<String> values) {
            addCriterion("HAND_CREATE_DOC not in", values, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocBetween(String value1, String value2) {
            addCriterion("HAND_CREATE_DOC between", value1, value2, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andHandCreateDocNotBetween(String value1, String value2) {
            addCriterion("HAND_CREATE_DOC not between", value1, value2, "handCreateDoc");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNull() {
            addCriterion("MIN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNotNull() {
            addCriterion("MIN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMinNumEqualTo(BigDecimal value) {
            addCriterion("MIN_NUM =", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotEqualTo(BigDecimal value) {
            addCriterion("MIN_NUM <>", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThan(BigDecimal value) {
            addCriterion("MIN_NUM >", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_NUM >=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThan(BigDecimal value) {
            addCriterion("MIN_NUM <", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MIN_NUM <=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumIn(List<BigDecimal> values) {
            addCriterion("MIN_NUM in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotIn(List<BigDecimal> values) {
            addCriterion("MIN_NUM not in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_NUM between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MIN_NUM not between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andProdSourceIsNull() {
            addCriterion("PROD_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andProdSourceIsNotNull() {
            addCriterion("PROD_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andProdSourceEqualTo(String value) {
            addCriterion("PROD_SOURCE =", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceNotEqualTo(String value) {
            addCriterion("PROD_SOURCE <>", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceGreaterThan(String value) {
            addCriterion("PROD_SOURCE >", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_SOURCE >=", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceLessThan(String value) {
            addCriterion("PROD_SOURCE <", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceLessThanOrEqualTo(String value) {
            addCriterion("PROD_SOURCE <=", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceLike(String value) {
            addCriterion("PROD_SOURCE like", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceNotLike(String value) {
            addCriterion("PROD_SOURCE not like", value, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceIn(List<String> values) {
            addCriterion("PROD_SOURCE in", values, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceNotIn(List<String> values) {
            addCriterion("PROD_SOURCE not in", values, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceBetween(String value1, String value2) {
            addCriterion("PROD_SOURCE between", value1, value2, "prodSource");
            return (Criteria) this;
        }

        public Criteria andProdSourceNotBetween(String value1, String value2) {
            addCriterion("PROD_SOURCE not between", value1, value2, "prodSource");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNull() {
            addCriterion("SAFETY_STOCK is null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIsNotNull() {
            addCriterion("SAFETY_STOCK is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyStockEqualTo(BigDecimal value) {
            addCriterion("SAFETY_STOCK =", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotEqualTo(BigDecimal value) {
            addCriterion("SAFETY_STOCK <>", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThan(BigDecimal value) {
            addCriterion("SAFETY_STOCK >", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SAFETY_STOCK >=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThan(BigDecimal value) {
            addCriterion("SAFETY_STOCK <", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SAFETY_STOCK <=", value, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockIn(List<BigDecimal> values) {
            addCriterion("SAFETY_STOCK in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotIn(List<BigDecimal> values) {
            addCriterion("SAFETY_STOCK not in", values, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAFETY_STOCK between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andSafetyStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAFETY_STOCK not between", value1, value2, "safetyStock");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehIsNull() {
            addCriterion("IS_TFO_DIST_WAREH is null");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehIsNotNull() {
            addCriterion("IS_TFO_DIST_WAREH is not null");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehEqualTo(String value) {
            addCriterion("IS_TFO_DIST_WAREH =", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehNotEqualTo(String value) {
            addCriterion("IS_TFO_DIST_WAREH <>", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehGreaterThan(String value) {
            addCriterion("IS_TFO_DIST_WAREH >", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TFO_DIST_WAREH >=", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehLessThan(String value) {
            addCriterion("IS_TFO_DIST_WAREH <", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehLessThanOrEqualTo(String value) {
            addCriterion("IS_TFO_DIST_WAREH <=", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehLike(String value) {
            addCriterion("IS_TFO_DIST_WAREH like", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehNotLike(String value) {
            addCriterion("IS_TFO_DIST_WAREH not like", value, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehIn(List<String> values) {
            addCriterion("IS_TFO_DIST_WAREH in", values, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehNotIn(List<String> values) {
            addCriterion("IS_TFO_DIST_WAREH not in", values, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehBetween(String value1, String value2) {
            addCriterion("IS_TFO_DIST_WAREH between", value1, value2, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andIsTfoDistWarehNotBetween(String value1, String value2) {
            addCriterion("IS_TFO_DIST_WAREH not between", value1, value2, "isTfoDistWareh");
            return (Criteria) this;
        }

        public Criteria andUsedMaIsNull() {
            addCriterion("USED_MA is null");
            return (Criteria) this;
        }

        public Criteria andUsedMaIsNotNull() {
            addCriterion("USED_MA is not null");
            return (Criteria) this;
        }

        public Criteria andUsedMaEqualTo(String value) {
            addCriterion("USED_MA =", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaNotEqualTo(String value) {
            addCriterion("USED_MA <>", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaGreaterThan(String value) {
            addCriterion("USED_MA >", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaGreaterThanOrEqualTo(String value) {
            addCriterion("USED_MA >=", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaLessThan(String value) {
            addCriterion("USED_MA <", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaLessThanOrEqualTo(String value) {
            addCriterion("USED_MA <=", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaLike(String value) {
            addCriterion("USED_MA like", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaNotLike(String value) {
            addCriterion("USED_MA not like", value, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaIn(List<String> values) {
            addCriterion("USED_MA in", values, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaNotIn(List<String> values) {
            addCriterion("USED_MA not in", values, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaBetween(String value1, String value2) {
            addCriterion("USED_MA between", value1, value2, "usedMa");
            return (Criteria) this;
        }

        public Criteria andUsedMaNotBetween(String value1, String value2) {
            addCriterion("USED_MA not between", value1, value2, "usedMa");
            return (Criteria) this;
        }

        public Criteria andCanadZonesIsNull() {
            addCriterion("CANAD_ZONES is null");
            return (Criteria) this;
        }

        public Criteria andCanadZonesIsNotNull() {
            addCriterion("CANAD_ZONES is not null");
            return (Criteria) this;
        }

        public Criteria andCanadZonesEqualTo(String value) {
            addCriterion("CANAD_ZONES =", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesNotEqualTo(String value) {
            addCriterion("CANAD_ZONES <>", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesGreaterThan(String value) {
            addCriterion("CANAD_ZONES >", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesGreaterThanOrEqualTo(String value) {
            addCriterion("CANAD_ZONES >=", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesLessThan(String value) {
            addCriterion("CANAD_ZONES <", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesLessThanOrEqualTo(String value) {
            addCriterion("CANAD_ZONES <=", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesLike(String value) {
            addCriterion("CANAD_ZONES like", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesNotLike(String value) {
            addCriterion("CANAD_ZONES not like", value, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesIn(List<String> values) {
            addCriterion("CANAD_ZONES in", values, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesNotIn(List<String> values) {
            addCriterion("CANAD_ZONES not in", values, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesBetween(String value1, String value2) {
            addCriterion("CANAD_ZONES between", value1, value2, "canadZones");
            return (Criteria) this;
        }

        public Criteria andCanadZonesNotBetween(String value1, String value2) {
            addCriterion("CANAD_ZONES not between", value1, value2, "canadZones");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osIsNull() {
            addCriterion("IS_STK_SYNC2OS is null");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osIsNotNull() {
            addCriterion("IS_STK_SYNC2OS is not null");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osEqualTo(String value) {
            addCriterion("IS_STK_SYNC2OS =", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osNotEqualTo(String value) {
            addCriterion("IS_STK_SYNC2OS <>", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osGreaterThan(String value) {
            addCriterion("IS_STK_SYNC2OS >", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osGreaterThanOrEqualTo(String value) {
            addCriterion("IS_STK_SYNC2OS >=", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osLessThan(String value) {
            addCriterion("IS_STK_SYNC2OS <", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osLessThanOrEqualTo(String value) {
            addCriterion("IS_STK_SYNC2OS <=", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osLike(String value) {
            addCriterion("IS_STK_SYNC2OS like", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osNotLike(String value) {
            addCriterion("IS_STK_SYNC2OS not like", value, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osIn(List<String> values) {
            addCriterion("IS_STK_SYNC2OS in", values, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osNotIn(List<String> values) {
            addCriterion("IS_STK_SYNC2OS not in", values, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osBetween(String value1, String value2) {
            addCriterion("IS_STK_SYNC2OS between", value1, value2, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsStkSync2osNotBetween(String value1, String value2) {
            addCriterion("IS_STK_SYNC2OS not between", value1, value2, "isStkSync2os");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedIsNull() {
            addCriterion("IS_DOUBLE_LOCKED is null");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedIsNotNull() {
            addCriterion("IS_DOUBLE_LOCKED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedEqualTo(String value) {
            addCriterion("IS_DOUBLE_LOCKED =", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedNotEqualTo(String value) {
            addCriterion("IS_DOUBLE_LOCKED <>", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedGreaterThan(String value) {
            addCriterion("IS_DOUBLE_LOCKED >", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DOUBLE_LOCKED >=", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedLessThan(String value) {
            addCriterion("IS_DOUBLE_LOCKED <", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedLessThanOrEqualTo(String value) {
            addCriterion("IS_DOUBLE_LOCKED <=", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedLike(String value) {
            addCriterion("IS_DOUBLE_LOCKED like", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedNotLike(String value) {
            addCriterion("IS_DOUBLE_LOCKED not like", value, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedIn(List<String> values) {
            addCriterion("IS_DOUBLE_LOCKED in", values, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedNotIn(List<String> values) {
            addCriterion("IS_DOUBLE_LOCKED not in", values, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedBetween(String value1, String value2) {
            addCriterion("IS_DOUBLE_LOCKED between", value1, value2, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andIsDoubleLockedNotBetween(String value1, String value2) {
            addCriterion("IS_DOUBLE_LOCKED not between", value1, value2, "isDoubleLocked");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderIsNull() {
            addCriterion("RELEASE_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderIsNotNull() {
            addCriterion("RELEASE_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderEqualTo(BigDecimal value) {
            addCriterion("RELEASE_ORDER =", value, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderNotEqualTo(BigDecimal value) {
            addCriterion("RELEASE_ORDER <>", value, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderGreaterThan(BigDecimal value) {
            addCriterion("RELEASE_ORDER >", value, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RELEASE_ORDER >=", value, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderLessThan(BigDecimal value) {
            addCriterion("RELEASE_ORDER <", value, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RELEASE_ORDER <=", value, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderIn(List<BigDecimal> values) {
            addCriterion("RELEASE_ORDER in", values, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderNotIn(List<BigDecimal> values) {
            addCriterion("RELEASE_ORDER not in", values, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RELEASE_ORDER between", value1, value2, "releaseOrder");
            return (Criteria) this;
        }

        public Criteria andReleaseOrderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RELEASE_ORDER not between", value1, value2, "releaseOrder");
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