package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("SHOP_ID =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("SHOP_ID <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("SHOP_ID >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ID >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("SHOP_ID <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ID <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("SHOP_ID like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("SHOP_ID not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("SHOP_ID in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("SHOP_ID not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("SHOP_ID between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("SHOP_ID not between", value1, value2, "shopId");
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

        public Criteria andManIdIsNull() {
            addCriterion("MAN_ID is null");
            return (Criteria) this;
        }

        public Criteria andManIdIsNotNull() {
            addCriterion("MAN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andManIdEqualTo(String value) {
            addCriterion("MAN_ID =", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotEqualTo(String value) {
            addCriterion("MAN_ID <>", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdGreaterThan(String value) {
            addCriterion("MAN_ID >", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdGreaterThanOrEqualTo(String value) {
            addCriterion("MAN_ID >=", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdLessThan(String value) {
            addCriterion("MAN_ID <", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdLessThanOrEqualTo(String value) {
            addCriterion("MAN_ID <=", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdLike(String value) {
            addCriterion("MAN_ID like", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotLike(String value) {
            addCriterion("MAN_ID not like", value, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdIn(List<String> values) {
            addCriterion("MAN_ID in", values, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotIn(List<String> values) {
            addCriterion("MAN_ID not in", values, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdBetween(String value1, String value2) {
            addCriterion("MAN_ID between", value1, value2, "manId");
            return (Criteria) this;
        }

        public Criteria andManIdNotBetween(String value1, String value2) {
            addCriterion("MAN_ID not between", value1, value2, "manId");
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

        public Criteria andJoinFlagIsNull() {
            addCriterion("JOIN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andJoinFlagIsNotNull() {
            addCriterion("JOIN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andJoinFlagEqualTo(String value) {
            addCriterion("JOIN_FLAG =", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagNotEqualTo(String value) {
            addCriterion("JOIN_FLAG <>", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagGreaterThan(String value) {
            addCriterion("JOIN_FLAG >", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagGreaterThanOrEqualTo(String value) {
            addCriterion("JOIN_FLAG >=", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagLessThan(String value) {
            addCriterion("JOIN_FLAG <", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagLessThanOrEqualTo(String value) {
            addCriterion("JOIN_FLAG <=", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagLike(String value) {
            addCriterion("JOIN_FLAG like", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagNotLike(String value) {
            addCriterion("JOIN_FLAG not like", value, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagIn(List<String> values) {
            addCriterion("JOIN_FLAG in", values, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagNotIn(List<String> values) {
            addCriterion("JOIN_FLAG not in", values, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagBetween(String value1, String value2) {
            addCriterion("JOIN_FLAG between", value1, value2, "joinFlag");
            return (Criteria) this;
        }

        public Criteria andJoinFlagNotBetween(String value1, String value2) {
            addCriterion("JOIN_FLAG not between", value1, value2, "joinFlag");
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

        public Criteria andShopSaleClsIsNull() {
            addCriterion("SHOP_SALE_CLS is null");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsIsNotNull() {
            addCriterion("SHOP_SALE_CLS is not null");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsEqualTo(String value) {
            addCriterion("SHOP_SALE_CLS =", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsNotEqualTo(String value) {
            addCriterion("SHOP_SALE_CLS <>", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsGreaterThan(String value) {
            addCriterion("SHOP_SALE_CLS >", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_SALE_CLS >=", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsLessThan(String value) {
            addCriterion("SHOP_SALE_CLS <", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsLessThanOrEqualTo(String value) {
            addCriterion("SHOP_SALE_CLS <=", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsLike(String value) {
            addCriterion("SHOP_SALE_CLS like", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsNotLike(String value) {
            addCriterion("SHOP_SALE_CLS not like", value, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsIn(List<String> values) {
            addCriterion("SHOP_SALE_CLS in", values, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsNotIn(List<String> values) {
            addCriterion("SHOP_SALE_CLS not in", values, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsBetween(String value1, String value2) {
            addCriterion("SHOP_SALE_CLS between", value1, value2, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andShopSaleClsNotBetween(String value1, String value2) {
            addCriterion("SHOP_SALE_CLS not between", value1, value2, "shopSaleCls");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeIsNull() {
            addCriterion("SMS_MARKET_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeIsNotNull() {
            addCriterion("SMS_MARKET_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeEqualTo(String value) {
            addCriterion("SMS_MARKET_CODE =", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeNotEqualTo(String value) {
            addCriterion("SMS_MARKET_CODE <>", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeGreaterThan(String value) {
            addCriterion("SMS_MARKET_CODE >", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SMS_MARKET_CODE >=", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeLessThan(String value) {
            addCriterion("SMS_MARKET_CODE <", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeLessThanOrEqualTo(String value) {
            addCriterion("SMS_MARKET_CODE <=", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeLike(String value) {
            addCriterion("SMS_MARKET_CODE like", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeNotLike(String value) {
            addCriterion("SMS_MARKET_CODE not like", value, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeIn(List<String> values) {
            addCriterion("SMS_MARKET_CODE in", values, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeNotIn(List<String> values) {
            addCriterion("SMS_MARKET_CODE not in", values, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeBetween(String value1, String value2) {
            addCriterion("SMS_MARKET_CODE between", value1, value2, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andSmsMarketCodeNotBetween(String value1, String value2) {
            addCriterion("SMS_MARKET_CODE not between", value1, value2, "smsMarketCode");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeIsNull() {
            addCriterion("CUR_STOCK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeIsNotNull() {
            addCriterion("CUR_STOCK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeEqualTo(String value) {
            addCriterion("CUR_STOCK_TYPE =", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeNotEqualTo(String value) {
            addCriterion("CUR_STOCK_TYPE <>", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeGreaterThan(String value) {
            addCriterion("CUR_STOCK_TYPE >", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CUR_STOCK_TYPE >=", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeLessThan(String value) {
            addCriterion("CUR_STOCK_TYPE <", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeLessThanOrEqualTo(String value) {
            addCriterion("CUR_STOCK_TYPE <=", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeLike(String value) {
            addCriterion("CUR_STOCK_TYPE like", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeNotLike(String value) {
            addCriterion("CUR_STOCK_TYPE not like", value, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeIn(List<String> values) {
            addCriterion("CUR_STOCK_TYPE in", values, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeNotIn(List<String> values) {
            addCriterion("CUR_STOCK_TYPE not in", values, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeBetween(String value1, String value2) {
            addCriterion("CUR_STOCK_TYPE between", value1, value2, "curStockType");
            return (Criteria) this;
        }

        public Criteria andCurStockTypeNotBetween(String value1, String value2) {
            addCriterion("CUR_STOCK_TYPE not between", value1, value2, "curStockType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeIsNull() {
            addCriterion("CONSIGN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andConsignTypeIsNotNull() {
            addCriterion("CONSIGN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andConsignTypeEqualTo(String value) {
            addCriterion("CONSIGN_TYPE =", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeNotEqualTo(String value) {
            addCriterion("CONSIGN_TYPE <>", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeGreaterThan(String value) {
            addCriterion("CONSIGN_TYPE >", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGN_TYPE >=", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeLessThan(String value) {
            addCriterion("CONSIGN_TYPE <", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeLessThanOrEqualTo(String value) {
            addCriterion("CONSIGN_TYPE <=", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeLike(String value) {
            addCriterion("CONSIGN_TYPE like", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeNotLike(String value) {
            addCriterion("CONSIGN_TYPE not like", value, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeIn(List<String> values) {
            addCriterion("CONSIGN_TYPE in", values, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeNotIn(List<String> values) {
            addCriterion("CONSIGN_TYPE not in", values, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeBetween(String value1, String value2) {
            addCriterion("CONSIGN_TYPE between", value1, value2, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignTypeNotBetween(String value1, String value2) {
            addCriterion("CONSIGN_TYPE not between", value1, value2, "consignType");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidIsNull() {
            addCriterion("CONSIGN_WAREHID is null");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidIsNotNull() {
            addCriterion("CONSIGN_WAREHID is not null");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidEqualTo(String value) {
            addCriterion("CONSIGN_WAREHID =", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidNotEqualTo(String value) {
            addCriterion("CONSIGN_WAREHID <>", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidGreaterThan(String value) {
            addCriterion("CONSIGN_WAREHID >", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidGreaterThanOrEqualTo(String value) {
            addCriterion("CONSIGN_WAREHID >=", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidLessThan(String value) {
            addCriterion("CONSIGN_WAREHID <", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidLessThanOrEqualTo(String value) {
            addCriterion("CONSIGN_WAREHID <=", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidLike(String value) {
            addCriterion("CONSIGN_WAREHID like", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidNotLike(String value) {
            addCriterion("CONSIGN_WAREHID not like", value, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidIn(List<String> values) {
            addCriterion("CONSIGN_WAREHID in", values, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidNotIn(List<String> values) {
            addCriterion("CONSIGN_WAREHID not in", values, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidBetween(String value1, String value2) {
            addCriterion("CONSIGN_WAREHID between", value1, value2, "consignWarehid");
            return (Criteria) this;
        }

        public Criteria andConsignWarehidNotBetween(String value1, String value2) {
            addCriterion("CONSIGN_WAREHID not between", value1, value2, "consignWarehid");
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