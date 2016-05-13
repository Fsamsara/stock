package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SfWarehouseLocExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfWarehouseLocExample() {
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

        public Criteria andSfWarehouseZoneIdIsNull() {
            addCriterion("SF_WAREHOUSE_ZONE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdIsNotNull() {
            addCriterion("SF_WAREHOUSE_ZONE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_ZONE_ID =", value, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdNotEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_ZONE_ID <>", value, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdGreaterThan(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_ZONE_ID >", value, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_ZONE_ID >=", value, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdLessThan(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_ZONE_ID <", value, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SF_WAREHOUSE_ZONE_ID <=", value, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdIn(List<BigDecimal> values) {
            addCriterion("SF_WAREHOUSE_ZONE_ID in", values, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdNotIn(List<BigDecimal> values) {
            addCriterion("SF_WAREHOUSE_ZONE_ID not in", values, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SF_WAREHOUSE_ZONE_ID between", value1, value2, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andSfWarehouseZoneIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SF_WAREHOUSE_ZONE_ID not between", value1, value2, "sfWarehouseZoneId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andLocPropIsNull() {
            addCriterion("LOC_PROP is null");
            return (Criteria) this;
        }

        public Criteria andLocPropIsNotNull() {
            addCriterion("LOC_PROP is not null");
            return (Criteria) this;
        }

        public Criteria andLocPropEqualTo(String value) {
            addCriterion("LOC_PROP =", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropNotEqualTo(String value) {
            addCriterion("LOC_PROP <>", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropGreaterThan(String value) {
            addCriterion("LOC_PROP >", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_PROP >=", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropLessThan(String value) {
            addCriterion("LOC_PROP <", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropLessThanOrEqualTo(String value) {
            addCriterion("LOC_PROP <=", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropLike(String value) {
            addCriterion("LOC_PROP like", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropNotLike(String value) {
            addCriterion("LOC_PROP not like", value, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropIn(List<String> values) {
            addCriterion("LOC_PROP in", values, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropNotIn(List<String> values) {
            addCriterion("LOC_PROP not in", values, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropBetween(String value1, String value2) {
            addCriterion("LOC_PROP between", value1, value2, "locProp");
            return (Criteria) this;
        }

        public Criteria andLocPropNotBetween(String value1, String value2) {
            addCriterion("LOC_PROP not between", value1, value2, "locProp");
            return (Criteria) this;
        }

        public Criteria andDimensionIsNull() {
            addCriterion("DIMENSION is null");
            return (Criteria) this;
        }

        public Criteria andDimensionIsNotNull() {
            addCriterion("DIMENSION is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionEqualTo(BigDecimal value) {
            addCriterion("DIMENSION =", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotEqualTo(BigDecimal value) {
            addCriterion("DIMENSION <>", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionGreaterThan(BigDecimal value) {
            addCriterion("DIMENSION >", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DIMENSION >=", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionLessThan(BigDecimal value) {
            addCriterion("DIMENSION <", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DIMENSION <=", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionIn(List<BigDecimal> values) {
            addCriterion("DIMENSION in", values, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotIn(List<BigDecimal> values) {
            addCriterion("DIMENSION not in", values, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIMENSION between", value1, value2, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIMENSION not between", value1, value2, "dimension");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("DESCRIPTION =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("DESCRIPTION <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("DESCRIPTION >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("DESCRIPTION <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("DESCRIPTION <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("DESCRIPTION like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("DESCRIPTION not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("DESCRIPTION in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("DESCRIPTION not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("DESCRIPTION between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("DESCRIPTION not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLocDescIsNull() {
            addCriterion("LOC_DESC is null");
            return (Criteria) this;
        }

        public Criteria andLocDescIsNotNull() {
            addCriterion("LOC_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andLocDescEqualTo(String value) {
            addCriterion("LOC_DESC =", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescNotEqualTo(String value) {
            addCriterion("LOC_DESC <>", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescGreaterThan(String value) {
            addCriterion("LOC_DESC >", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescGreaterThanOrEqualTo(String value) {
            addCriterion("LOC_DESC >=", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescLessThan(String value) {
            addCriterion("LOC_DESC <", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescLessThanOrEqualTo(String value) {
            addCriterion("LOC_DESC <=", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescLike(String value) {
            addCriterion("LOC_DESC like", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescNotLike(String value) {
            addCriterion("LOC_DESC not like", value, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescIn(List<String> values) {
            addCriterion("LOC_DESC in", values, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescNotIn(List<String> values) {
            addCriterion("LOC_DESC not in", values, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescBetween(String value1, String value2) {
            addCriterion("LOC_DESC between", value1, value2, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocDescNotBetween(String value1, String value2) {
            addCriterion("LOC_DESC not between", value1, value2, "locDesc");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdIsNull() {
            addCriterion("LOC_TRANS_LOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdIsNotNull() {
            addCriterion("LOC_TRANS_LOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdEqualTo(BigDecimal value) {
            addCriterion("LOC_TRANS_LOC_ID =", value, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdNotEqualTo(BigDecimal value) {
            addCriterion("LOC_TRANS_LOC_ID <>", value, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdGreaterThan(BigDecimal value) {
            addCriterion("LOC_TRANS_LOC_ID >", value, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOC_TRANS_LOC_ID >=", value, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdLessThan(BigDecimal value) {
            addCriterion("LOC_TRANS_LOC_ID <", value, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOC_TRANS_LOC_ID <=", value, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdIn(List<BigDecimal> values) {
            addCriterion("LOC_TRANS_LOC_ID in", values, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdNotIn(List<BigDecimal> values) {
            addCriterion("LOC_TRANS_LOC_ID not in", values, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOC_TRANS_LOC_ID between", value1, value2, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andLocTransLocIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOC_TRANS_LOC_ID not between", value1, value2, "locTransLocId");
            return (Criteria) this;
        }

        public Criteria andFloorNumIsNull() {
            addCriterion("FLOOR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFloorNumIsNotNull() {
            addCriterion("FLOOR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFloorNumEqualTo(String value) {
            addCriterion("FLOOR_NUM =", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotEqualTo(String value) {
            addCriterion("FLOOR_NUM <>", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumGreaterThan(String value) {
            addCriterion("FLOOR_NUM >", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumGreaterThanOrEqualTo(String value) {
            addCriterion("FLOOR_NUM >=", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumLessThan(String value) {
            addCriterion("FLOOR_NUM <", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumLessThanOrEqualTo(String value) {
            addCriterion("FLOOR_NUM <=", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumLike(String value) {
            addCriterion("FLOOR_NUM like", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotLike(String value) {
            addCriterion("FLOOR_NUM not like", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumIn(List<String> values) {
            addCriterion("FLOOR_NUM in", values, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotIn(List<String> values) {
            addCriterion("FLOOR_NUM not in", values, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumBetween(String value1, String value2) {
            addCriterion("FLOOR_NUM between", value1, value2, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotBetween(String value1, String value2) {
            addCriterion("FLOOR_NUM not between", value1, value2, "floorNum");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("LOCK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("LOCK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(String value) {
            addCriterion("LOCK_STATUS =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(String value) {
            addCriterion("LOCK_STATUS <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(String value) {
            addCriterion("LOCK_STATUS >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_STATUS >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(String value) {
            addCriterion("LOCK_STATUS <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(String value) {
            addCriterion("LOCK_STATUS <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLike(String value) {
            addCriterion("LOCK_STATUS like", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotLike(String value) {
            addCriterion("LOCK_STATUS not like", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<String> values) {
            addCriterion("LOCK_STATUS in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<String> values) {
            addCriterion("LOCK_STATUS not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(String value1, String value2) {
            addCriterion("LOCK_STATUS between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(String value1, String value2) {
            addCriterion("LOCK_STATUS not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLanewayIsNull() {
            addCriterion("LANEWAY is null");
            return (Criteria) this;
        }

        public Criteria andLanewayIsNotNull() {
            addCriterion("LANEWAY is not null");
            return (Criteria) this;
        }

        public Criteria andLanewayEqualTo(String value) {
            addCriterion("LANEWAY =", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayNotEqualTo(String value) {
            addCriterion("LANEWAY <>", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayGreaterThan(String value) {
            addCriterion("LANEWAY >", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayGreaterThanOrEqualTo(String value) {
            addCriterion("LANEWAY >=", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayLessThan(String value) {
            addCriterion("LANEWAY <", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayLessThanOrEqualTo(String value) {
            addCriterion("LANEWAY <=", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayLike(String value) {
            addCriterion("LANEWAY like", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayNotLike(String value) {
            addCriterion("LANEWAY not like", value, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayIn(List<String> values) {
            addCriterion("LANEWAY in", values, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayNotIn(List<String> values) {
            addCriterion("LANEWAY not in", values, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayBetween(String value1, String value2) {
            addCriterion("LANEWAY between", value1, value2, "laneway");
            return (Criteria) this;
        }

        public Criteria andLanewayNotBetween(String value1, String value2) {
            addCriterion("LANEWAY not between", value1, value2, "laneway");
            return (Criteria) this;
        }

        public Criteria andSequenceNumIsNull() {
            addCriterion("SEQUENCE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSequenceNumIsNotNull() {
            addCriterion("SEQUENCE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceNumEqualTo(Long value) {
            addCriterion("SEQUENCE_NUM =", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumNotEqualTo(Long value) {
            addCriterion("SEQUENCE_NUM <>", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumGreaterThan(Long value) {
            addCriterion("SEQUENCE_NUM >", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_NUM >=", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumLessThan(Long value) {
            addCriterion("SEQUENCE_NUM <", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumLessThanOrEqualTo(Long value) {
            addCriterion("SEQUENCE_NUM <=", value, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumIn(List<Long> values) {
            addCriterion("SEQUENCE_NUM in", values, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumNotIn(List<Long> values) {
            addCriterion("SEQUENCE_NUM not in", values, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_NUM between", value1, value2, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andSequenceNumNotBetween(Long value1, Long value2) {
            addCriterion("SEQUENCE_NUM not between", value1, value2, "sequenceNum");
            return (Criteria) this;
        }

        public Criteria andRowCodeIsNull() {
            addCriterion("ROW_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRowCodeIsNotNull() {
            addCriterion("ROW_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRowCodeEqualTo(String value) {
            addCriterion("ROW_CODE =", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeNotEqualTo(String value) {
            addCriterion("ROW_CODE <>", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeGreaterThan(String value) {
            addCriterion("ROW_CODE >", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ROW_CODE >=", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeLessThan(String value) {
            addCriterion("ROW_CODE <", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeLessThanOrEqualTo(String value) {
            addCriterion("ROW_CODE <=", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeLike(String value) {
            addCriterion("ROW_CODE like", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeNotLike(String value) {
            addCriterion("ROW_CODE not like", value, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeIn(List<String> values) {
            addCriterion("ROW_CODE in", values, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeNotIn(List<String> values) {
            addCriterion("ROW_CODE not in", values, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeBetween(String value1, String value2) {
            addCriterion("ROW_CODE between", value1, value2, "rowCode");
            return (Criteria) this;
        }

        public Criteria andRowCodeNotBetween(String value1, String value2) {
            addCriterion("ROW_CODE not between", value1, value2, "rowCode");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumIsNull() {
            addCriterion("PICK_TRACE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumIsNotNull() {
            addCriterion("PICK_TRACE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumEqualTo(Long value) {
            addCriterion("PICK_TRACE_NUM =", value, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumNotEqualTo(Long value) {
            addCriterion("PICK_TRACE_NUM <>", value, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumGreaterThan(Long value) {
            addCriterion("PICK_TRACE_NUM >", value, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumGreaterThanOrEqualTo(Long value) {
            addCriterion("PICK_TRACE_NUM >=", value, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumLessThan(Long value) {
            addCriterion("PICK_TRACE_NUM <", value, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumLessThanOrEqualTo(Long value) {
            addCriterion("PICK_TRACE_NUM <=", value, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumIn(List<Long> values) {
            addCriterion("PICK_TRACE_NUM in", values, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumNotIn(List<Long> values) {
            addCriterion("PICK_TRACE_NUM not in", values, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumBetween(Long value1, Long value2) {
            addCriterion("PICK_TRACE_NUM between", value1, value2, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andPickTraceNumNotBetween(Long value1, Long value2) {
            addCriterion("PICK_TRACE_NUM not between", value1, value2, "pickTraceNum");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNull() {
            addCriterion("FLOW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNotNull() {
            addCriterion("FLOW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeEqualTo(String value) {
            addCriterion("FLOW_TYPE =", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotEqualTo(String value) {
            addCriterion("FLOW_TYPE <>", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThan(String value) {
            addCriterion("FLOW_TYPE >", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FLOW_TYPE >=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThan(String value) {
            addCriterion("FLOW_TYPE <", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThanOrEqualTo(String value) {
            addCriterion("FLOW_TYPE <=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLike(String value) {
            addCriterion("FLOW_TYPE like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotLike(String value) {
            addCriterion("FLOW_TYPE not like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIn(List<String> values) {
            addCriterion("FLOW_TYPE in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotIn(List<String> values) {
            addCriterion("FLOW_TYPE not in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeBetween(String value1, String value2) {
            addCriterion("FLOW_TYPE between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotBetween(String value1, String value2) {
            addCriterion("FLOW_TYPE not between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumIsNull() {
            addCriterion("ON_SHELF_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumIsNotNull() {
            addCriterion("ON_SHELF_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumEqualTo(String value) {
            addCriterion("ON_SHELF_NUM =", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumNotEqualTo(String value) {
            addCriterion("ON_SHELF_NUM <>", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumGreaterThan(String value) {
            addCriterion("ON_SHELF_NUM >", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumGreaterThanOrEqualTo(String value) {
            addCriterion("ON_SHELF_NUM >=", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumLessThan(String value) {
            addCriterion("ON_SHELF_NUM <", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumLessThanOrEqualTo(String value) {
            addCriterion("ON_SHELF_NUM <=", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumLike(String value) {
            addCriterion("ON_SHELF_NUM like", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumNotLike(String value) {
            addCriterion("ON_SHELF_NUM not like", value, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumIn(List<String> values) {
            addCriterion("ON_SHELF_NUM in", values, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumNotIn(List<String> values) {
            addCriterion("ON_SHELF_NUM not in", values, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumBetween(String value1, String value2) {
            addCriterion("ON_SHELF_NUM between", value1, value2, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andOnShelfNumNotBetween(String value1, String value2) {
            addCriterion("ON_SHELF_NUM not between", value1, value2, "onShelfNum");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeIsNull() {
            addCriterion("LAST_CTRLR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeIsNotNull() {
            addCriterion("LAST_CTRLR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeEqualTo(Date value) {
            addCriterion("LAST_CTRLR_TIME =", value, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeNotEqualTo(Date value) {
            addCriterion("LAST_CTRLR_TIME <>", value, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeGreaterThan(Date value) {
            addCriterion("LAST_CTRLR_TIME >", value, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_CTRLR_TIME >=", value, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeLessThan(Date value) {
            addCriterion("LAST_CTRLR_TIME <", value, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_CTRLR_TIME <=", value, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeIn(List<Date> values) {
            addCriterion("LAST_CTRLR_TIME in", values, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeNotIn(List<Date> values) {
            addCriterion("LAST_CTRLR_TIME not in", values, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_CTRLR_TIME between", value1, value2, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLastCtrlrTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_CTRLR_TIME not between", value1, value2, "lastCtrlrTime");
            return (Criteria) this;
        }

        public Criteria andLockTypeIsNull() {
            addCriterion("LOCK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLockTypeIsNotNull() {
            addCriterion("LOCK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLockTypeEqualTo(String value) {
            addCriterion("LOCK_TYPE =", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotEqualTo(String value) {
            addCriterion("LOCK_TYPE <>", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeGreaterThan(String value) {
            addCriterion("LOCK_TYPE >", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LOCK_TYPE >=", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLessThan(String value) {
            addCriterion("LOCK_TYPE <", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLessThanOrEqualTo(String value) {
            addCriterion("LOCK_TYPE <=", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLike(String value) {
            addCriterion("LOCK_TYPE like", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotLike(String value) {
            addCriterion("LOCK_TYPE not like", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeIn(List<String> values) {
            addCriterion("LOCK_TYPE in", values, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotIn(List<String> values) {
            addCriterion("LOCK_TYPE not in", values, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeBetween(String value1, String value2) {
            addCriterion("LOCK_TYPE between", value1, value2, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotBetween(String value1, String value2) {
            addCriterion("LOCK_TYPE not between", value1, value2, "lockType");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedIsNull() {
            addCriterion("BOX_ADOPTED is null");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedIsNotNull() {
            addCriterion("BOX_ADOPTED is not null");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedEqualTo(String value) {
            addCriterion("BOX_ADOPTED =", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedNotEqualTo(String value) {
            addCriterion("BOX_ADOPTED <>", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedGreaterThan(String value) {
            addCriterion("BOX_ADOPTED >", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedGreaterThanOrEqualTo(String value) {
            addCriterion("BOX_ADOPTED >=", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedLessThan(String value) {
            addCriterion("BOX_ADOPTED <", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedLessThanOrEqualTo(String value) {
            addCriterion("BOX_ADOPTED <=", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedLike(String value) {
            addCriterion("BOX_ADOPTED like", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedNotLike(String value) {
            addCriterion("BOX_ADOPTED not like", value, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedIn(List<String> values) {
            addCriterion("BOX_ADOPTED in", values, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedNotIn(List<String> values) {
            addCriterion("BOX_ADOPTED not in", values, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedBetween(String value1, String value2) {
            addCriterion("BOX_ADOPTED between", value1, value2, "boxAdopted");
            return (Criteria) this;
        }

        public Criteria andBoxAdoptedNotBetween(String value1, String value2) {
            addCriterion("BOX_ADOPTED not between", value1, value2, "boxAdopted");
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