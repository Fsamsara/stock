package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BfOrgShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BfOrgShopExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andShopTypeIsNull() {
            addCriterion("SHOP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("SHOP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(String value) {
            addCriterion("SHOP_TYPE =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(String value) {
            addCriterion("SHOP_TYPE <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(String value) {
            addCriterion("SHOP_TYPE >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_TYPE >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(String value) {
            addCriterion("SHOP_TYPE <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(String value) {
            addCriterion("SHOP_TYPE <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLike(String value) {
            addCriterion("SHOP_TYPE like", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotLike(String value) {
            addCriterion("SHOP_TYPE not like", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<String> values) {
            addCriterion("SHOP_TYPE in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<String> values) {
            addCriterion("SHOP_TYPE not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(String value1, String value2) {
            addCriterion("SHOP_TYPE between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(String value1, String value2) {
            addCriterion("SHOP_TYPE not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andManCodeIsNull() {
            addCriterion("MAN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andManCodeIsNotNull() {
            addCriterion("MAN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andManCodeEqualTo(String value) {
            addCriterion("MAN_CODE =", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeNotEqualTo(String value) {
            addCriterion("MAN_CODE <>", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeGreaterThan(String value) {
            addCriterion("MAN_CODE >", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MAN_CODE >=", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeLessThan(String value) {
            addCriterion("MAN_CODE <", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeLessThanOrEqualTo(String value) {
            addCriterion("MAN_CODE <=", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeLike(String value) {
            addCriterion("MAN_CODE like", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeNotLike(String value) {
            addCriterion("MAN_CODE not like", value, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeIn(List<String> values) {
            addCriterion("MAN_CODE in", values, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeNotIn(List<String> values) {
            addCriterion("MAN_CODE not in", values, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeBetween(String value1, String value2) {
            addCriterion("MAN_CODE between", value1, value2, "manCode");
            return (Criteria) this;
        }

        public Criteria andManCodeNotBetween(String value1, String value2) {
            addCriterion("MAN_CODE not between", value1, value2, "manCode");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("OPEN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("OPEN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterionForJDBCDate("OPEN_DATE >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterionForJDBCDate("OPEN_DATE <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPEN_DATE <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterionForJDBCDate("OPEN_DATE in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPEN_DATE not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPEN_DATE between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPEN_DATE not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateIsNull() {
            addCriterion("CLOSE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCloseDateIsNotNull() {
            addCriterion("CLOSE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCloseDateEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE =", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE <>", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE >", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE >=", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateLessThan(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE <", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CLOSE_DATE <=", value, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateIn(List<Date> values) {
            addCriterionForJDBCDate("CLOSE_DATE in", values, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CLOSE_DATE not in", values, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CLOSE_DATE between", value1, value2, "closeDate");
            return (Criteria) this;
        }

        public Criteria andCloseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CLOSE_DATE not between", value1, value2, "closeDate");
            return (Criteria) this;
        }

        public Criteria andAcreageIsNull() {
            addCriterion("ACREAGE is null");
            return (Criteria) this;
        }

        public Criteria andAcreageIsNotNull() {
            addCriterion("ACREAGE is not null");
            return (Criteria) this;
        }

        public Criteria andAcreageEqualTo(BigDecimal value) {
            addCriterion("ACREAGE =", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageNotEqualTo(BigDecimal value) {
            addCriterion("ACREAGE <>", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageGreaterThan(BigDecimal value) {
            addCriterion("ACREAGE >", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACREAGE >=", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageLessThan(BigDecimal value) {
            addCriterion("ACREAGE <", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACREAGE <=", value, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageIn(List<BigDecimal> values) {
            addCriterion("ACREAGE in", values, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageNotIn(List<BigDecimal> values) {
            addCriterion("ACREAGE not in", values, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACREAGE between", value1, value2, "acreage");
            return (Criteria) this;
        }

        public Criteria andAcreageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACREAGE not between", value1, value2, "acreage");
            return (Criteria) this;
        }

        public Criteria andSettleDateIsNull() {
            addCriterion("SETTLE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andSettleDateIsNotNull() {
            addCriterion("SETTLE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andSettleDateEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLE_DATE =", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLE_DATE <>", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SETTLE_DATE >", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLE_DATE >=", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateLessThan(Date value) {
            addCriterionForJDBCDate("SETTLE_DATE <", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SETTLE_DATE <=", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLE_DATE in", values, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SETTLE_DATE not in", values, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLE_DATE between", value1, value2, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SETTLE_DATE not between", value1, value2, "settleDate");
            return (Criteria) this;
        }

        public Criteria andRentRateIsNull() {
            addCriterion("RENT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andRentRateIsNotNull() {
            addCriterion("RENT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRentRateEqualTo(BigDecimal value) {
            addCriterion("RENT_RATE =", value, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateNotEqualTo(BigDecimal value) {
            addCriterion("RENT_RATE <>", value, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateGreaterThan(BigDecimal value) {
            addCriterion("RENT_RATE >", value, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RENT_RATE >=", value, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateLessThan(BigDecimal value) {
            addCriterion("RENT_RATE <", value, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RENT_RATE <=", value, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateIn(List<BigDecimal> values) {
            addCriterion("RENT_RATE in", values, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateNotIn(List<BigDecimal> values) {
            addCriterion("RENT_RATE not in", values, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RENT_RATE between", value1, value2, "rentRate");
            return (Criteria) this;
        }

        public Criteria andRentRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RENT_RATE not between", value1, value2, "rentRate");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("COMPANY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("COMPANY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("COMPANY_CODE =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("COMPANY_CODE <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("COMPANY_CODE >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("COMPANY_CODE <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("COMPANY_CODE <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("COMPANY_CODE like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("COMPANY_CODE not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("COMPANY_CODE in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("COMPANY_CODE not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("COMPANY_CODE not between", value1, value2, "companyCode");
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

        public Criteria andAccountGroupIsNull() {
            addCriterion("ACCOUNT_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIsNotNull() {
            addCriterion("ACCOUNT_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andAccountGroupEqualTo(String value) {
            addCriterion("ACCOUNT_GROUP =", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupNotEqualTo(String value) {
            addCriterion("ACCOUNT_GROUP <>", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupGreaterThan(String value) {
            addCriterion("ACCOUNT_GROUP >", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_GROUP >=", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupLessThan(String value) {
            addCriterion("ACCOUNT_GROUP <", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_GROUP <=", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupLike(String value) {
            addCriterion("ACCOUNT_GROUP like", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupNotLike(String value) {
            addCriterion("ACCOUNT_GROUP not like", value, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupIn(List<String> values) {
            addCriterion("ACCOUNT_GROUP in", values, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupNotIn(List<String> values) {
            addCriterion("ACCOUNT_GROUP not in", values, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupBetween(String value1, String value2) {
            addCriterion("ACCOUNT_GROUP between", value1, value2, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andAccountGroupNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_GROUP not between", value1, value2, "accountGroup");
            return (Criteria) this;
        }

        public Criteria andSapIdIsNull() {
            addCriterion("SAP_ID is null");
            return (Criteria) this;
        }

        public Criteria andSapIdIsNotNull() {
            addCriterion("SAP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSapIdEqualTo(BigDecimal value) {
            addCriterion("SAP_ID =", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotEqualTo(BigDecimal value) {
            addCriterion("SAP_ID <>", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdGreaterThan(BigDecimal value) {
            addCriterion("SAP_ID >", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SAP_ID >=", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdLessThan(BigDecimal value) {
            addCriterion("SAP_ID <", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SAP_ID <=", value, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdIn(List<BigDecimal> values) {
            addCriterion("SAP_ID in", values, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotIn(List<BigDecimal> values) {
            addCriterion("SAP_ID not in", values, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAP_ID between", value1, value2, "sapId");
            return (Criteria) this;
        }

        public Criteria andSapIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAP_ID not between", value1, value2, "sapId");
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

        public Criteria andDefaultWarehIdIsNull() {
            addCriterion("DEFAULT_WAREH_ID is null");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdIsNotNull() {
            addCriterion("DEFAULT_WAREH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdEqualTo(BigDecimal value) {
            addCriterion("DEFAULT_WAREH_ID =", value, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdNotEqualTo(BigDecimal value) {
            addCriterion("DEFAULT_WAREH_ID <>", value, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdGreaterThan(BigDecimal value) {
            addCriterion("DEFAULT_WAREH_ID >", value, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEFAULT_WAREH_ID >=", value, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdLessThan(BigDecimal value) {
            addCriterion("DEFAULT_WAREH_ID <", value, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEFAULT_WAREH_ID <=", value, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdIn(List<BigDecimal> values) {
            addCriterion("DEFAULT_WAREH_ID in", values, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdNotIn(List<BigDecimal> values) {
            addCriterion("DEFAULT_WAREH_ID not in", values, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEFAULT_WAREH_ID between", value1, value2, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andDefaultWarehIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEFAULT_WAREH_ID not between", value1, value2, "defaultWarehId");
            return (Criteria) this;
        }

        public Criteria andStoreScopeIsNull() {
            addCriterion("STORE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andStoreScopeIsNotNull() {
            addCriterion("STORE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreScopeEqualTo(String value) {
            addCriterion("STORE_SCOPE =", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotEqualTo(String value) {
            addCriterion("STORE_SCOPE <>", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeGreaterThan(String value) {
            addCriterion("STORE_SCOPE >", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_SCOPE >=", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeLessThan(String value) {
            addCriterion("STORE_SCOPE <", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeLessThanOrEqualTo(String value) {
            addCriterion("STORE_SCOPE <=", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeLike(String value) {
            addCriterion("STORE_SCOPE like", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotLike(String value) {
            addCriterion("STORE_SCOPE not like", value, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeIn(List<String> values) {
            addCriterion("STORE_SCOPE in", values, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotIn(List<String> values) {
            addCriterion("STORE_SCOPE not in", values, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeBetween(String value1, String value2) {
            addCriterion("STORE_SCOPE between", value1, value2, "storeScope");
            return (Criteria) this;
        }

        public Criteria andStoreScopeNotBetween(String value1, String value2) {
            addCriterion("STORE_SCOPE not between", value1, value2, "storeScope");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIsNull() {
            addCriterion("CUSTOMER_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIsNotNull() {
            addCriterion("CUSTOMER_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL =", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL <>", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelGreaterThan(String value) {
            addCriterion("CUSTOMER_LEVEL >", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL >=", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLessThan(String value) {
            addCriterion("CUSTOMER_LEVEL <", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_LEVEL <=", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelLike(String value) {
            addCriterion("CUSTOMER_LEVEL like", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotLike(String value) {
            addCriterion("CUSTOMER_LEVEL not like", value, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelIn(List<String> values) {
            addCriterion("CUSTOMER_LEVEL in", values, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotIn(List<String> values) {
            addCriterion("CUSTOMER_LEVEL not in", values, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelBetween(String value1, String value2) {
            addCriterion("CUSTOMER_LEVEL between", value1, value2, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andCustomerLevelNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_LEVEL not between", value1, value2, "customerLevel");
            return (Criteria) this;
        }

        public Criteria andOfflineshipIsNull() {
            addCriterion("OFFLINESHIP is null");
            return (Criteria) this;
        }

        public Criteria andOfflineshipIsNotNull() {
            addCriterion("OFFLINESHIP is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineshipEqualTo(String value) {
            addCriterion("OFFLINESHIP =", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipNotEqualTo(String value) {
            addCriterion("OFFLINESHIP <>", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipGreaterThan(String value) {
            addCriterion("OFFLINESHIP >", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipGreaterThanOrEqualTo(String value) {
            addCriterion("OFFLINESHIP >=", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipLessThan(String value) {
            addCriterion("OFFLINESHIP <", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipLessThanOrEqualTo(String value) {
            addCriterion("OFFLINESHIP <=", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipLike(String value) {
            addCriterion("OFFLINESHIP like", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipNotLike(String value) {
            addCriterion("OFFLINESHIP not like", value, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipIn(List<String> values) {
            addCriterion("OFFLINESHIP in", values, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipNotIn(List<String> values) {
            addCriterion("OFFLINESHIP not in", values, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipBetween(String value1, String value2) {
            addCriterion("OFFLINESHIP between", value1, value2, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflineshipNotBetween(String value1, String value2) {
            addCriterion("OFFLINESHIP not between", value1, value2, "offlineship");
            return (Criteria) this;
        }

        public Criteria andOfflincacIsNull() {
            addCriterion("OFFLINCAC is null");
            return (Criteria) this;
        }

        public Criteria andOfflincacIsNotNull() {
            addCriterion("OFFLINCAC is not null");
            return (Criteria) this;
        }

        public Criteria andOfflincacEqualTo(String value) {
            addCriterion("OFFLINCAC =", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacNotEqualTo(String value) {
            addCriterion("OFFLINCAC <>", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacGreaterThan(String value) {
            addCriterion("OFFLINCAC >", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacGreaterThanOrEqualTo(String value) {
            addCriterion("OFFLINCAC >=", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacLessThan(String value) {
            addCriterion("OFFLINCAC <", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacLessThanOrEqualTo(String value) {
            addCriterion("OFFLINCAC <=", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacLike(String value) {
            addCriterion("OFFLINCAC like", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacNotLike(String value) {
            addCriterion("OFFLINCAC not like", value, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacIn(List<String> values) {
            addCriterion("OFFLINCAC in", values, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacNotIn(List<String> values) {
            addCriterion("OFFLINCAC not in", values, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacBetween(String value1, String value2) {
            addCriterion("OFFLINCAC between", value1, value2, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflincacNotBetween(String value1, String value2) {
            addCriterion("OFFLINCAC not between", value1, value2, "offlincac");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipIsNull() {
            addCriterion("OFFLINE_ORDER_SHIP is null");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipIsNotNull() {
            addCriterion("OFFLINE_ORDER_SHIP is not null");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipEqualTo(String value) {
            addCriterion("OFFLINE_ORDER_SHIP =", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipNotEqualTo(String value) {
            addCriterion("OFFLINE_ORDER_SHIP <>", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipGreaterThan(String value) {
            addCriterion("OFFLINE_ORDER_SHIP >", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipGreaterThanOrEqualTo(String value) {
            addCriterion("OFFLINE_ORDER_SHIP >=", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipLessThan(String value) {
            addCriterion("OFFLINE_ORDER_SHIP <", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipLessThanOrEqualTo(String value) {
            addCriterion("OFFLINE_ORDER_SHIP <=", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipLike(String value) {
            addCriterion("OFFLINE_ORDER_SHIP like", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipNotLike(String value) {
            addCriterion("OFFLINE_ORDER_SHIP not like", value, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipIn(List<String> values) {
            addCriterion("OFFLINE_ORDER_SHIP in", values, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipNotIn(List<String> values) {
            addCriterion("OFFLINE_ORDER_SHIP not in", values, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipBetween(String value1, String value2) {
            addCriterion("OFFLINE_ORDER_SHIP between", value1, value2, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andOfflineOrderShipNotBetween(String value1, String value2) {
            addCriterion("OFFLINE_ORDER_SHIP not between", value1, value2, "offlineOrderShip");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosIsNull() {
            addCriterion("IS_SYNCTOOS is null");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosIsNotNull() {
            addCriterion("IS_SYNCTOOS is not null");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosEqualTo(String value) {
            addCriterion("IS_SYNCTOOS =", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosNotEqualTo(String value) {
            addCriterion("IS_SYNCTOOS <>", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosGreaterThan(String value) {
            addCriterion("IS_SYNCTOOS >", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYNCTOOS >=", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosLessThan(String value) {
            addCriterion("IS_SYNCTOOS <", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosLessThanOrEqualTo(String value) {
            addCriterion("IS_SYNCTOOS <=", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosLike(String value) {
            addCriterion("IS_SYNCTOOS like", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosNotLike(String value) {
            addCriterion("IS_SYNCTOOS not like", value, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosIn(List<String> values) {
            addCriterion("IS_SYNCTOOS in", values, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosNotIn(List<String> values) {
            addCriterion("IS_SYNCTOOS not in", values, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosBetween(String value1, String value2) {
            addCriterion("IS_SYNCTOOS between", value1, value2, "isSynctoos");
            return (Criteria) this;
        }

        public Criteria andIsSynctoosNotBetween(String value1, String value2) {
            addCriterion("IS_SYNCTOOS not between", value1, value2, "isSynctoos");
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