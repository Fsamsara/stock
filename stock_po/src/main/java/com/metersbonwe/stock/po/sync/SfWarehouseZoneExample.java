package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SfWarehouseZoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfWarehouseZoneExample() {
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

        public Criteria andFloorIsNull() {
            addCriterion("FLOOR is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("FLOOR is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(Integer value) {
            addCriterion("FLOOR =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(Integer value) {
            addCriterion("FLOOR <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(Integer value) {
            addCriterion("FLOOR >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLOOR >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(Integer value) {
            addCriterion("FLOOR <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(Integer value) {
            addCriterion("FLOOR <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<Integer> values) {
            addCriterion("FLOOR in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<Integer> values) {
            addCriterion("FLOOR not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(Integer value1, Integer value2) {
            addCriterion("FLOOR between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(Integer value1, Integer value2) {
            addCriterion("FLOOR not between", value1, value2, "floor");
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

        public Criteria andMoveTypeIsNull() {
            addCriterion("MOVE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMoveTypeIsNotNull() {
            addCriterion("MOVE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMoveTypeEqualTo(String value) {
            addCriterion("MOVE_TYPE =", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotEqualTo(String value) {
            addCriterion("MOVE_TYPE <>", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeGreaterThan(String value) {
            addCriterion("MOVE_TYPE >", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MOVE_TYPE >=", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeLessThan(String value) {
            addCriterion("MOVE_TYPE <", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeLessThanOrEqualTo(String value) {
            addCriterion("MOVE_TYPE <=", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeLike(String value) {
            addCriterion("MOVE_TYPE like", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotLike(String value) {
            addCriterion("MOVE_TYPE not like", value, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeIn(List<String> values) {
            addCriterion("MOVE_TYPE in", values, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotIn(List<String> values) {
            addCriterion("MOVE_TYPE not in", values, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeBetween(String value1, String value2) {
            addCriterion("MOVE_TYPE between", value1, value2, "moveType");
            return (Criteria) this;
        }

        public Criteria andMoveTypeNotBetween(String value1, String value2) {
            addCriterion("MOVE_TYPE not between", value1, value2, "moveType");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoIsNull() {
            addCriterion("SATELLITE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoIsNotNull() {
            addCriterion("SATELLITE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoEqualTo(String value) {
            addCriterion("SATELLITE_INFO =", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoNotEqualTo(String value) {
            addCriterion("SATELLITE_INFO <>", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoGreaterThan(String value) {
            addCriterion("SATELLITE_INFO >", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoGreaterThanOrEqualTo(String value) {
            addCriterion("SATELLITE_INFO >=", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoLessThan(String value) {
            addCriterion("SATELLITE_INFO <", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoLessThanOrEqualTo(String value) {
            addCriterion("SATELLITE_INFO <=", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoLike(String value) {
            addCriterion("SATELLITE_INFO like", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoNotLike(String value) {
            addCriterion("SATELLITE_INFO not like", value, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoIn(List<String> values) {
            addCriterion("SATELLITE_INFO in", values, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoNotIn(List<String> values) {
            addCriterion("SATELLITE_INFO not in", values, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoBetween(String value1, String value2) {
            addCriterion("SATELLITE_INFO between", value1, value2, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andSatelliteInfoNotBetween(String value1, String value2) {
            addCriterion("SATELLITE_INFO not between", value1, value2, "satelliteInfo");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptIsNull() {
            addCriterion("IS_TRANS_LOCAREA_ADPT is null");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptIsNotNull() {
            addCriterion("IS_TRANS_LOCAREA_ADPT is not null");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptEqualTo(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT =", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptNotEqualTo(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT <>", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptGreaterThan(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT >", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT >=", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptLessThan(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT <", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptLessThanOrEqualTo(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT <=", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptLike(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT like", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptNotLike(String value) {
            addCriterion("IS_TRANS_LOCAREA_ADPT not like", value, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptIn(List<String> values) {
            addCriterion("IS_TRANS_LOCAREA_ADPT in", values, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptNotIn(List<String> values) {
            addCriterion("IS_TRANS_LOCAREA_ADPT not in", values, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptBetween(String value1, String value2) {
            addCriterion("IS_TRANS_LOCAREA_ADPT between", value1, value2, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andIsTransLocareaAdptNotBetween(String value1, String value2) {
            addCriterion("IS_TRANS_LOCAREA_ADPT not between", value1, value2, "isTransLocareaAdpt");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdIsNull() {
            addCriterion("SUP_TRANS_LOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdIsNotNull() {
            addCriterion("SUP_TRANS_LOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdEqualTo(BigDecimal value) {
            addCriterion("SUP_TRANS_LOC_ID =", value, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdNotEqualTo(BigDecimal value) {
            addCriterion("SUP_TRANS_LOC_ID <>", value, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdGreaterThan(BigDecimal value) {
            addCriterion("SUP_TRANS_LOC_ID >", value, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SUP_TRANS_LOC_ID >=", value, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdLessThan(BigDecimal value) {
            addCriterion("SUP_TRANS_LOC_ID <", value, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SUP_TRANS_LOC_ID <=", value, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdIn(List<BigDecimal> values) {
            addCriterion("SUP_TRANS_LOC_ID in", values, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdNotIn(List<BigDecimal> values) {
            addCriterion("SUP_TRANS_LOC_ID not in", values, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUP_TRANS_LOC_ID between", value1, value2, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andSupTransLocIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SUP_TRANS_LOC_ID not between", value1, value2, "supTransLocId");
            return (Criteria) this;
        }

        public Criteria andZoneTypeIsNull() {
            addCriterion("ZONE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andZoneTypeIsNotNull() {
            addCriterion("ZONE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andZoneTypeEqualTo(String value) {
            addCriterion("ZONE_TYPE =", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeNotEqualTo(String value) {
            addCriterion("ZONE_TYPE <>", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeGreaterThan(String value) {
            addCriterion("ZONE_TYPE >", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ZONE_TYPE >=", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeLessThan(String value) {
            addCriterion("ZONE_TYPE <", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeLessThanOrEqualTo(String value) {
            addCriterion("ZONE_TYPE <=", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeLike(String value) {
            addCriterion("ZONE_TYPE like", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeNotLike(String value) {
            addCriterion("ZONE_TYPE not like", value, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeIn(List<String> values) {
            addCriterion("ZONE_TYPE in", values, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeNotIn(List<String> values) {
            addCriterion("ZONE_TYPE not in", values, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeBetween(String value1, String value2) {
            addCriterion("ZONE_TYPE between", value1, value2, "zoneType");
            return (Criteria) this;
        }

        public Criteria andZoneTypeNotBetween(String value1, String value2) {
            addCriterion("ZONE_TYPE not between", value1, value2, "zoneType");
            return (Criteria) this;
        }

        public Criteria andPrivIsNull() {
            addCriterion("PRIV is null");
            return (Criteria) this;
        }

        public Criteria andPrivIsNotNull() {
            addCriterion("PRIV is not null");
            return (Criteria) this;
        }

        public Criteria andPrivEqualTo(Integer value) {
            addCriterion("PRIV =", value, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivNotEqualTo(Integer value) {
            addCriterion("PRIV <>", value, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivGreaterThan(Integer value) {
            addCriterion("PRIV >", value, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIV >=", value, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivLessThan(Integer value) {
            addCriterion("PRIV <", value, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivLessThanOrEqualTo(Integer value) {
            addCriterion("PRIV <=", value, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivIn(List<Integer> values) {
            addCriterion("PRIV in", values, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivNotIn(List<Integer> values) {
            addCriterion("PRIV not in", values, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivBetween(Integer value1, Integer value2) {
            addCriterion("PRIV between", value1, value2, "priv");
            return (Criteria) this;
        }

        public Criteria andPrivNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIV not between", value1, value2, "priv");
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