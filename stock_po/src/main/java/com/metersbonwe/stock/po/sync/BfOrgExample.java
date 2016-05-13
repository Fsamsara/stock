package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BfOrgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BfOrgExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
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

        public Criteria andOldIdIsNull() {
            addCriterion("OLD_ID is null");
            return (Criteria) this;
        }

        public Criteria andOldIdIsNotNull() {
            addCriterion("OLD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOldIdEqualTo(String value) {
            addCriterion("OLD_ID =", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotEqualTo(String value) {
            addCriterion("OLD_ID <>", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThan(String value) {
            addCriterion("OLD_ID >", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_ID >=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThan(String value) {
            addCriterion("OLD_ID <", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThanOrEqualTo(String value) {
            addCriterion("OLD_ID <=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLike(String value) {
            addCriterion("OLD_ID like", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotLike(String value) {
            addCriterion("OLD_ID not like", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdIn(List<String> values) {
            addCriterion("OLD_ID in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotIn(List<String> values) {
            addCriterion("OLD_ID not in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdBetween(String value1, String value2) {
            addCriterion("OLD_ID between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotBetween(String value1, String value2) {
            addCriterion("OLD_ID not between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andInputCodeIsNull() {
            addCriterion("INPUT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInputCodeIsNotNull() {
            addCriterion("INPUT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInputCodeEqualTo(String value) {
            addCriterion("INPUT_CODE =", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotEqualTo(String value) {
            addCriterion("INPUT_CODE <>", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeGreaterThan(String value) {
            addCriterion("INPUT_CODE >", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_CODE >=", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLessThan(String value) {
            addCriterion("INPUT_CODE <", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLessThanOrEqualTo(String value) {
            addCriterion("INPUT_CODE <=", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeLike(String value) {
            addCriterion("INPUT_CODE like", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotLike(String value) {
            addCriterion("INPUT_CODE not like", value, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeIn(List<String> values) {
            addCriterion("INPUT_CODE in", values, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotIn(List<String> values) {
            addCriterion("INPUT_CODE not in", values, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeBetween(String value1, String value2) {
            addCriterion("INPUT_CODE between", value1, value2, "inputCode");
            return (Criteria) this;
        }

        public Criteria andInputCodeNotBetween(String value1, String value2) {
            addCriterion("INPUT_CODE not between", value1, value2, "inputCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeIsNull() {
            addCriterion("SORT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSortCodeIsNotNull() {
            addCriterion("SORT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSortCodeEqualTo(String value) {
            addCriterion("SORT_CODE =", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotEqualTo(String value) {
            addCriterion("SORT_CODE <>", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeGreaterThan(String value) {
            addCriterion("SORT_CODE >", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SORT_CODE >=", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeLessThan(String value) {
            addCriterion("SORT_CODE <", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeLessThanOrEqualTo(String value) {
            addCriterion("SORT_CODE <=", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeLike(String value) {
            addCriterion("SORT_CODE like", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotLike(String value) {
            addCriterion("SORT_CODE not like", value, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeIn(List<String> values) {
            addCriterion("SORT_CODE in", values, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotIn(List<String> values) {
            addCriterion("SORT_CODE not in", values, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeBetween(String value1, String value2) {
            addCriterion("SORT_CODE between", value1, value2, "sortCode");
            return (Criteria) this;
        }

        public Criteria andSortCodeNotBetween(String value1, String value2) {
            addCriterion("SORT_CODE not between", value1, value2, "sortCode");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdIsNull() {
            addCriterion("BF_ORG_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdIsNotNull() {
            addCriterion("BF_ORG_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_TYPE_ID =", value, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_TYPE_ID <>", value, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdGreaterThan(BigDecimal value) {
            addCriterion("BF_ORG_TYPE_ID >", value, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_TYPE_ID >=", value, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdLessThan(BigDecimal value) {
            addCriterion("BF_ORG_TYPE_ID <", value, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_ORG_TYPE_ID <=", value, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdIn(List<BigDecimal> values) {
            addCriterion("BF_ORG_TYPE_ID in", values, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_ORG_TYPE_ID not in", values, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_ORG_TYPE_ID between", value1, value2, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andBfOrgTypeIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_ORG_TYPE_ID not between", value1, value2, "bfOrgTypeId");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("COUNTRY =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("COUNTRY <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("COUNTRY >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRY >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("COUNTRY <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("COUNTRY <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("COUNTRY like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("COUNTRY not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("COUNTRY in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("COUNTRY not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("COUNTRY between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("COUNTRY not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("PROVINCE =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("PROVINCE <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("PROVINCE >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("PROVINCE <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("PROVINCE like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("PROVINCE not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("PROVINCE in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("PROVINCE not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("PROVINCE between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("PROVINCE not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("POSTCODE =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("POSTCODE <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("POSTCODE >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("POSTCODE >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("POSTCODE <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("POSTCODE <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("POSTCODE like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("POSTCODE not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("POSTCODE in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("POSTCODE not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("POSTCODE between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("POSTCODE not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPhNumIsNull() {
            addCriterion("PH_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPhNumIsNotNull() {
            addCriterion("PH_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPhNumEqualTo(String value) {
            addCriterion("PH_NUM =", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotEqualTo(String value) {
            addCriterion("PH_NUM <>", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumGreaterThan(String value) {
            addCriterion("PH_NUM >", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumGreaterThanOrEqualTo(String value) {
            addCriterion("PH_NUM >=", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumLessThan(String value) {
            addCriterion("PH_NUM <", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumLessThanOrEqualTo(String value) {
            addCriterion("PH_NUM <=", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumLike(String value) {
            addCriterion("PH_NUM like", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotLike(String value) {
            addCriterion("PH_NUM not like", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumIn(List<String> values) {
            addCriterion("PH_NUM in", values, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotIn(List<String> values) {
            addCriterion("PH_NUM not in", values, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumBetween(String value1, String value2) {
            addCriterion("PH_NUM between", value1, value2, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotBetween(String value1, String value2) {
            addCriterion("PH_NUM not between", value1, value2, "phNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumIsNull() {
            addCriterion("FAX_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFaxNumIsNotNull() {
            addCriterion("FAX_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFaxNumEqualTo(String value) {
            addCriterion("FAX_NUM =", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumNotEqualTo(String value) {
            addCriterion("FAX_NUM <>", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumGreaterThan(String value) {
            addCriterion("FAX_NUM >", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumGreaterThanOrEqualTo(String value) {
            addCriterion("FAX_NUM >=", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumLessThan(String value) {
            addCriterion("FAX_NUM <", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumLessThanOrEqualTo(String value) {
            addCriterion("FAX_NUM <=", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumLike(String value) {
            addCriterion("FAX_NUM like", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumNotLike(String value) {
            addCriterion("FAX_NUM not like", value, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumIn(List<String> values) {
            addCriterion("FAX_NUM in", values, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumNotIn(List<String> values) {
            addCriterion("FAX_NUM not in", values, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumBetween(String value1, String value2) {
            addCriterion("FAX_NUM between", value1, value2, "faxNum");
            return (Criteria) this;
        }

        public Criteria andFaxNumNotBetween(String value1, String value2) {
            addCriterion("FAX_NUM not between", value1, value2, "faxNum");
            return (Criteria) this;
        }

        public Criteria andEmailAddrIsNull() {
            addCriterion("EMAIL_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddrIsNotNull() {
            addCriterion("EMAIL_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddrEqualTo(String value) {
            addCriterion("EMAIL_ADDR =", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrNotEqualTo(String value) {
            addCriterion("EMAIL_ADDR <>", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrGreaterThan(String value) {
            addCriterion("EMAIL_ADDR >", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_ADDR >=", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrLessThan(String value) {
            addCriterion("EMAIL_ADDR <", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_ADDR <=", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrLike(String value) {
            addCriterion("EMAIL_ADDR like", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrNotLike(String value) {
            addCriterion("EMAIL_ADDR not like", value, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrIn(List<String> values) {
            addCriterion("EMAIL_ADDR in", values, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrNotIn(List<String> values) {
            addCriterion("EMAIL_ADDR not in", values, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrBetween(String value1, String value2) {
            addCriterion("EMAIL_ADDR between", value1, value2, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andEmailAddrNotBetween(String value1, String value2) {
            addCriterion("EMAIL_ADDR not between", value1, value2, "emailAddr");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("WEBSITE is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("WEBSITE is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("WEBSITE =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("WEBSITE <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("WEBSITE >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("WEBSITE >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("WEBSITE <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("WEBSITE <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("WEBSITE like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("WEBSITE not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("WEBSITE in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("WEBSITE not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("WEBSITE between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("WEBSITE not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("REGION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("REGION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("REGION_CODE =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("REGION_CODE <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("REGION_CODE >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_CODE >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("REGION_CODE <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("REGION_CODE <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("REGION_CODE like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("REGION_CODE not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("REGION_CODE in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("REGION_CODE not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("REGION_CODE between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("REGION_CODE not between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrIsNull() {
            addCriterion("SIMPLE_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrIsNotNull() {
            addCriterion("SIMPLE_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrEqualTo(String value) {
            addCriterion("SIMPLE_ADDR =", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrNotEqualTo(String value) {
            addCriterion("SIMPLE_ADDR <>", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrGreaterThan(String value) {
            addCriterion("SIMPLE_ADDR >", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrGreaterThanOrEqualTo(String value) {
            addCriterion("SIMPLE_ADDR >=", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrLessThan(String value) {
            addCriterion("SIMPLE_ADDR <", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrLessThanOrEqualTo(String value) {
            addCriterion("SIMPLE_ADDR <=", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrLike(String value) {
            addCriterion("SIMPLE_ADDR like", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrNotLike(String value) {
            addCriterion("SIMPLE_ADDR not like", value, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrIn(List<String> values) {
            addCriterion("SIMPLE_ADDR in", values, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrNotIn(List<String> values) {
            addCriterion("SIMPLE_ADDR not in", values, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrBetween(String value1, String value2) {
            addCriterion("SIMPLE_ADDR between", value1, value2, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andSimpleAddrNotBetween(String value1, String value2) {
            addCriterion("SIMPLE_ADDR not between", value1, value2, "simpleAddr");
            return (Criteria) this;
        }

        public Criteria andDetaAddressIsNull() {
            addCriterion("DETA_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andDetaAddressIsNotNull() {
            addCriterion("DETA_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andDetaAddressEqualTo(String value) {
            addCriterion("DETA_ADDRESS =", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressNotEqualTo(String value) {
            addCriterion("DETA_ADDRESS <>", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressGreaterThan(String value) {
            addCriterion("DETA_ADDRESS >", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressGreaterThanOrEqualTo(String value) {
            addCriterion("DETA_ADDRESS >=", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressLessThan(String value) {
            addCriterion("DETA_ADDRESS <", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressLessThanOrEqualTo(String value) {
            addCriterion("DETA_ADDRESS <=", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressLike(String value) {
            addCriterion("DETA_ADDRESS like", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressNotLike(String value) {
            addCriterion("DETA_ADDRESS not like", value, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressIn(List<String> values) {
            addCriterion("DETA_ADDRESS in", values, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressNotIn(List<String> values) {
            addCriterion("DETA_ADDRESS not in", values, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressBetween(String value1, String value2) {
            addCriterion("DETA_ADDRESS between", value1, value2, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andDetaAddressNotBetween(String value1, String value2) {
            addCriterion("DETA_ADDRESS not between", value1, value2, "detaAddress");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("OWNER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("OWNER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(BigDecimal value) {
            addCriterion("OWNER_ID =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(BigDecimal value) {
            addCriterion("OWNER_ID <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(BigDecimal value) {
            addCriterion("OWNER_ID >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OWNER_ID >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(BigDecimal value) {
            addCriterion("OWNER_ID <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OWNER_ID <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<BigDecimal> values) {
            addCriterion("OWNER_ID in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<BigDecimal> values) {
            addCriterion("OWNER_ID not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OWNER_ID between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OWNER_ID not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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

        public Criteria andCountyIsNull() {
            addCriterion("COUNTY is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("COUNTY is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("COUNTY =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("COUNTY <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("COUNTY >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("COUNTY <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("COUNTY <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("COUNTY like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("COUNTY not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("COUNTY in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("COUNTY not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("COUNTY between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("COUNTY not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andActProvinceIsNull() {
            addCriterion("ACT_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andActProvinceIsNotNull() {
            addCriterion("ACT_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andActProvinceEqualTo(String value) {
            addCriterion("ACT_PROVINCE =", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceNotEqualTo(String value) {
            addCriterion("ACT_PROVINCE <>", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceGreaterThan(String value) {
            addCriterion("ACT_PROVINCE >", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_PROVINCE >=", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceLessThan(String value) {
            addCriterion("ACT_PROVINCE <", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceLessThanOrEqualTo(String value) {
            addCriterion("ACT_PROVINCE <=", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceLike(String value) {
            addCriterion("ACT_PROVINCE like", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceNotLike(String value) {
            addCriterion("ACT_PROVINCE not like", value, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceIn(List<String> values) {
            addCriterion("ACT_PROVINCE in", values, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceNotIn(List<String> values) {
            addCriterion("ACT_PROVINCE not in", values, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceBetween(String value1, String value2) {
            addCriterion("ACT_PROVINCE between", value1, value2, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActProvinceNotBetween(String value1, String value2) {
            addCriterion("ACT_PROVINCE not between", value1, value2, "actProvince");
            return (Criteria) this;
        }

        public Criteria andActCityIsNull() {
            addCriterion("ACT_CITY is null");
            return (Criteria) this;
        }

        public Criteria andActCityIsNotNull() {
            addCriterion("ACT_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andActCityEqualTo(String value) {
            addCriterion("ACT_CITY =", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityNotEqualTo(String value) {
            addCriterion("ACT_CITY <>", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityGreaterThan(String value) {
            addCriterion("ACT_CITY >", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_CITY >=", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityLessThan(String value) {
            addCriterion("ACT_CITY <", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityLessThanOrEqualTo(String value) {
            addCriterion("ACT_CITY <=", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityLike(String value) {
            addCriterion("ACT_CITY like", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityNotLike(String value) {
            addCriterion("ACT_CITY not like", value, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityIn(List<String> values) {
            addCriterion("ACT_CITY in", values, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityNotIn(List<String> values) {
            addCriterion("ACT_CITY not in", values, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityBetween(String value1, String value2) {
            addCriterion("ACT_CITY between", value1, value2, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCityNotBetween(String value1, String value2) {
            addCriterion("ACT_CITY not between", value1, value2, "actCity");
            return (Criteria) this;
        }

        public Criteria andActCountyIsNull() {
            addCriterion("ACT_COUNTY is null");
            return (Criteria) this;
        }

        public Criteria andActCountyIsNotNull() {
            addCriterion("ACT_COUNTY is not null");
            return (Criteria) this;
        }

        public Criteria andActCountyEqualTo(String value) {
            addCriterion("ACT_COUNTY =", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyNotEqualTo(String value) {
            addCriterion("ACT_COUNTY <>", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyGreaterThan(String value) {
            addCriterion("ACT_COUNTY >", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_COUNTY >=", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyLessThan(String value) {
            addCriterion("ACT_COUNTY <", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyLessThanOrEqualTo(String value) {
            addCriterion("ACT_COUNTY <=", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyLike(String value) {
            addCriterion("ACT_COUNTY like", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyNotLike(String value) {
            addCriterion("ACT_COUNTY not like", value, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyIn(List<String> values) {
            addCriterion("ACT_COUNTY in", values, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyNotIn(List<String> values) {
            addCriterion("ACT_COUNTY not in", values, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyBetween(String value1, String value2) {
            addCriterion("ACT_COUNTY between", value1, value2, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActCountyNotBetween(String value1, String value2) {
            addCriterion("ACT_COUNTY not between", value1, value2, "actCounty");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressIsNull() {
            addCriterion("ACT_DTL_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressIsNotNull() {
            addCriterion("ACT_DTL_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressEqualTo(String value) {
            addCriterion("ACT_DTL_ADDRESS =", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressNotEqualTo(String value) {
            addCriterion("ACT_DTL_ADDRESS <>", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressGreaterThan(String value) {
            addCriterion("ACT_DTL_ADDRESS >", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_DTL_ADDRESS >=", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressLessThan(String value) {
            addCriterion("ACT_DTL_ADDRESS <", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressLessThanOrEqualTo(String value) {
            addCriterion("ACT_DTL_ADDRESS <=", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressLike(String value) {
            addCriterion("ACT_DTL_ADDRESS like", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressNotLike(String value) {
            addCriterion("ACT_DTL_ADDRESS not like", value, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressIn(List<String> values) {
            addCriterion("ACT_DTL_ADDRESS in", values, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressNotIn(List<String> values) {
            addCriterion("ACT_DTL_ADDRESS not in", values, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressBetween(String value1, String value2) {
            addCriterion("ACT_DTL_ADDRESS between", value1, value2, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andActDtlAddressNotBetween(String value1, String value2) {
            addCriterion("ACT_DTL_ADDRESS not between", value1, value2, "actDtlAddress");
            return (Criteria) this;
        }

        public Criteria andToUserIsNull() {
            addCriterion("TO_USER is null");
            return (Criteria) this;
        }

        public Criteria andToUserIsNotNull() {
            addCriterion("TO_USER is not null");
            return (Criteria) this;
        }

        public Criteria andToUserEqualTo(String value) {
            addCriterion("TO_USER =", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotEqualTo(String value) {
            addCriterion("TO_USER <>", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThan(String value) {
            addCriterion("TO_USER >", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThanOrEqualTo(String value) {
            addCriterion("TO_USER >=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThan(String value) {
            addCriterion("TO_USER <", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThanOrEqualTo(String value) {
            addCriterion("TO_USER <=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLike(String value) {
            addCriterion("TO_USER like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotLike(String value) {
            addCriterion("TO_USER not like", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserIn(List<String> values) {
            addCriterion("TO_USER in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotIn(List<String> values) {
            addCriterion("TO_USER not in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserBetween(String value1, String value2) {
            addCriterion("TO_USER between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotBetween(String value1, String value2) {
            addCriterion("TO_USER not between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserTelIsNull() {
            addCriterion("TO_USER_TEL is null");
            return (Criteria) this;
        }

        public Criteria andToUserTelIsNotNull() {
            addCriterion("TO_USER_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andToUserTelEqualTo(String value) {
            addCriterion("TO_USER_TEL =", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelNotEqualTo(String value) {
            addCriterion("TO_USER_TEL <>", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelGreaterThan(String value) {
            addCriterion("TO_USER_TEL >", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("TO_USER_TEL >=", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelLessThan(String value) {
            addCriterion("TO_USER_TEL <", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelLessThanOrEqualTo(String value) {
            addCriterion("TO_USER_TEL <=", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelLike(String value) {
            addCriterion("TO_USER_TEL like", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelNotLike(String value) {
            addCriterion("TO_USER_TEL not like", value, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelIn(List<String> values) {
            addCriterion("TO_USER_TEL in", values, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelNotIn(List<String> values) {
            addCriterion("TO_USER_TEL not in", values, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelBetween(String value1, String value2) {
            addCriterion("TO_USER_TEL between", value1, value2, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserTelNotBetween(String value1, String value2) {
            addCriterion("TO_USER_TEL not between", value1, value2, "toUserTel");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneIsNull() {
            addCriterion("TO_USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneIsNotNull() {
            addCriterion("TO_USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneEqualTo(String value) {
            addCriterion("TO_USER_PHONE =", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneNotEqualTo(String value) {
            addCriterion("TO_USER_PHONE <>", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneGreaterThan(String value) {
            addCriterion("TO_USER_PHONE >", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("TO_USER_PHONE >=", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneLessThan(String value) {
            addCriterion("TO_USER_PHONE <", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("TO_USER_PHONE <=", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneLike(String value) {
            addCriterion("TO_USER_PHONE like", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneNotLike(String value) {
            addCriterion("TO_USER_PHONE not like", value, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneIn(List<String> values) {
            addCriterion("TO_USER_PHONE in", values, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneNotIn(List<String> values) {
            addCriterion("TO_USER_PHONE not in", values, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneBetween(String value1, String value2) {
            addCriterion("TO_USER_PHONE between", value1, value2, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andToUserPhoneNotBetween(String value1, String value2) {
            addCriterion("TO_USER_PHONE not between", value1, value2, "toUserPhone");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNull() {
            addCriterion("FROM_USER is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNotNull() {
            addCriterion("FROM_USER is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserEqualTo(String value) {
            addCriterion("FROM_USER =", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotEqualTo(String value) {
            addCriterion("FROM_USER <>", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThan(String value) {
            addCriterion("FROM_USER >", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThanOrEqualTo(String value) {
            addCriterion("FROM_USER >=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThan(String value) {
            addCriterion("FROM_USER <", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThanOrEqualTo(String value) {
            addCriterion("FROM_USER <=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLike(String value) {
            addCriterion("FROM_USER like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotLike(String value) {
            addCriterion("FROM_USER not like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserIn(List<String> values) {
            addCriterion("FROM_USER in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotIn(List<String> values) {
            addCriterion("FROM_USER not in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserBetween(String value1, String value2) {
            addCriterion("FROM_USER between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotBetween(String value1, String value2) {
            addCriterion("FROM_USER not between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserTelIsNull() {
            addCriterion("FROM_USER_TEL is null");
            return (Criteria) this;
        }

        public Criteria andFromUserTelIsNotNull() {
            addCriterion("FROM_USER_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserTelEqualTo(String value) {
            addCriterion("FROM_USER_TEL =", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelNotEqualTo(String value) {
            addCriterion("FROM_USER_TEL <>", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelGreaterThan(String value) {
            addCriterion("FROM_USER_TEL >", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("FROM_USER_TEL >=", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelLessThan(String value) {
            addCriterion("FROM_USER_TEL <", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelLessThanOrEqualTo(String value) {
            addCriterion("FROM_USER_TEL <=", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelLike(String value) {
            addCriterion("FROM_USER_TEL like", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelNotLike(String value) {
            addCriterion("FROM_USER_TEL not like", value, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelIn(List<String> values) {
            addCriterion("FROM_USER_TEL in", values, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelNotIn(List<String> values) {
            addCriterion("FROM_USER_TEL not in", values, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelBetween(String value1, String value2) {
            addCriterion("FROM_USER_TEL between", value1, value2, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andFromUserTelNotBetween(String value1, String value2) {
            addCriterion("FROM_USER_TEL not between", value1, value2, "fromUserTel");
            return (Criteria) this;
        }

        public Criteria andActCountryIsNull() {
            addCriterion("ACT_COUNTRY is null");
            return (Criteria) this;
        }

        public Criteria andActCountryIsNotNull() {
            addCriterion("ACT_COUNTRY is not null");
            return (Criteria) this;
        }

        public Criteria andActCountryEqualTo(String value) {
            addCriterion("ACT_COUNTRY =", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryNotEqualTo(String value) {
            addCriterion("ACT_COUNTRY <>", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryGreaterThan(String value) {
            addCriterion("ACT_COUNTRY >", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_COUNTRY >=", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryLessThan(String value) {
            addCriterion("ACT_COUNTRY <", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryLessThanOrEqualTo(String value) {
            addCriterion("ACT_COUNTRY <=", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryLike(String value) {
            addCriterion("ACT_COUNTRY like", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryNotLike(String value) {
            addCriterion("ACT_COUNTRY not like", value, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryIn(List<String> values) {
            addCriterion("ACT_COUNTRY in", values, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryNotIn(List<String> values) {
            addCriterion("ACT_COUNTRY not in", values, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryBetween(String value1, String value2) {
            addCriterion("ACT_COUNTRY between", value1, value2, "actCountry");
            return (Criteria) this;
        }

        public Criteria andActCountryNotBetween(String value1, String value2) {
            addCriterion("ACT_COUNTRY not between", value1, value2, "actCountry");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeIsNull() {
            addCriterion("BUSINESS_RANGE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeIsNotNull() {
            addCriterion("BUSINESS_RANGE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeEqualTo(String value) {
            addCriterion("BUSINESS_RANGE =", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotEqualTo(String value) {
            addCriterion("BUSINESS_RANGE <>", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeGreaterThan(String value) {
            addCriterion("BUSINESS_RANGE >", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_RANGE >=", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeLessThan(String value) {
            addCriterion("BUSINESS_RANGE <", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_RANGE <=", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeLike(String value) {
            addCriterion("BUSINESS_RANGE like", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotLike(String value) {
            addCriterion("BUSINESS_RANGE not like", value, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeIn(List<String> values) {
            addCriterion("BUSINESS_RANGE in", values, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotIn(List<String> values) {
            addCriterion("BUSINESS_RANGE not in", values, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeBetween(String value1, String value2) {
            addCriterion("BUSINESS_RANGE between", value1, value2, "businessRange");
            return (Criteria) this;
        }

        public Criteria andBusinessRangeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_RANGE not between", value1, value2, "businessRange");
            return (Criteria) this;
        }

        public Criteria andProfitCenterIsNull() {
            addCriterion("PROFIT_CENTER is null");
            return (Criteria) this;
        }

        public Criteria andProfitCenterIsNotNull() {
            addCriterion("PROFIT_CENTER is not null");
            return (Criteria) this;
        }

        public Criteria andProfitCenterEqualTo(String value) {
            addCriterion("PROFIT_CENTER =", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterNotEqualTo(String value) {
            addCriterion("PROFIT_CENTER <>", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterGreaterThan(String value) {
            addCriterion("PROFIT_CENTER >", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterGreaterThanOrEqualTo(String value) {
            addCriterion("PROFIT_CENTER >=", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterLessThan(String value) {
            addCriterion("PROFIT_CENTER <", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterLessThanOrEqualTo(String value) {
            addCriterion("PROFIT_CENTER <=", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterLike(String value) {
            addCriterion("PROFIT_CENTER like", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterNotLike(String value) {
            addCriterion("PROFIT_CENTER not like", value, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterIn(List<String> values) {
            addCriterion("PROFIT_CENTER in", values, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterNotIn(List<String> values) {
            addCriterion("PROFIT_CENTER not in", values, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterBetween(String value1, String value2) {
            addCriterion("PROFIT_CENTER between", value1, value2, "profitCenter");
            return (Criteria) this;
        }

        public Criteria andProfitCenterNotBetween(String value1, String value2) {
            addCriterion("PROFIT_CENTER not between", value1, value2, "profitCenter");
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