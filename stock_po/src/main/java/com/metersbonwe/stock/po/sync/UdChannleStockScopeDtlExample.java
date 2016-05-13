package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UdChannleStockScopeDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UdChannleStockScopeDtlExample() {
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

        public Criteria andUdCwIdIsNull() {
            addCriterion("UD_CW_ID is null");
            return (Criteria) this;
        }

        public Criteria andUdCwIdIsNotNull() {
            addCriterion("UD_CW_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUdCwIdEqualTo(BigDecimal value) {
            addCriterion("UD_CW_ID =", value, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdNotEqualTo(BigDecimal value) {
            addCriterion("UD_CW_ID <>", value, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdGreaterThan(BigDecimal value) {
            addCriterion("UD_CW_ID >", value, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("UD_CW_ID >=", value, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdLessThan(BigDecimal value) {
            addCriterion("UD_CW_ID <", value, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("UD_CW_ID <=", value, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdIn(List<BigDecimal> values) {
            addCriterion("UD_CW_ID in", values, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdNotIn(List<BigDecimal> values) {
            addCriterion("UD_CW_ID not in", values, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UD_CW_ID between", value1, value2, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdCwIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("UD_CW_ID not between", value1, value2, "udCwId");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeIsNull() {
            addCriterion("UD_LOCKED_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeIsNotNull() {
            addCriterion("UD_LOCKED_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeEqualTo(String value) {
            addCriterion("UD_LOCKED_TYPE =", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeNotEqualTo(String value) {
            addCriterion("UD_LOCKED_TYPE <>", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeGreaterThan(String value) {
            addCriterion("UD_LOCKED_TYPE >", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("UD_LOCKED_TYPE >=", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeLessThan(String value) {
            addCriterion("UD_LOCKED_TYPE <", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeLessThanOrEqualTo(String value) {
            addCriterion("UD_LOCKED_TYPE <=", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeLike(String value) {
            addCriterion("UD_LOCKED_TYPE like", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeNotLike(String value) {
            addCriterion("UD_LOCKED_TYPE not like", value, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeIn(List<String> values) {
            addCriterion("UD_LOCKED_TYPE in", values, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeNotIn(List<String> values) {
            addCriterion("UD_LOCKED_TYPE not in", values, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeBetween(String value1, String value2) {
            addCriterion("UD_LOCKED_TYPE between", value1, value2, "udLockedType");
            return (Criteria) this;
        }

        public Criteria andUdLockedTypeNotBetween(String value1, String value2) {
            addCriterion("UD_LOCKED_TYPE not between", value1, value2, "udLockedType");
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

        public Criteria andLastModifiedUserIsNull() {
            addCriterion("LAST_MODIFIED_USER is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserIsNotNull() {
            addCriterion("LAST_MODIFIED_USER is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER =", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER <>", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserGreaterThan(String value) {
            addCriterion("LAST_MODIFIED_USER >", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER >=", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserLessThan(String value) {
            addCriterion("LAST_MODIFIED_USER <", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserLessThanOrEqualTo(String value) {
            addCriterion("LAST_MODIFIED_USER <=", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserLike(String value) {
            addCriterion("LAST_MODIFIED_USER like", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotLike(String value) {
            addCriterion("LAST_MODIFIED_USER not like", value, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserIn(List<String> values) {
            addCriterion("LAST_MODIFIED_USER in", values, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotIn(List<String> values) {
            addCriterion("LAST_MODIFIED_USER not in", values, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIED_USER between", value1, value2, "lastModifiedUser");
            return (Criteria) this;
        }

        public Criteria andLastModifiedUserNotBetween(String value1, String value2) {
            addCriterion("LAST_MODIFIED_USER not between", value1, value2, "lastModifiedUser");
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

        public Criteria andForcedLockedTypeIsNull() {
            addCriterion("FORCED_LOCKED_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeIsNotNull() {
            addCriterion("FORCED_LOCKED_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeEqualTo(String value) {
            addCriterion("FORCED_LOCKED_TYPE =", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeNotEqualTo(String value) {
            addCriterion("FORCED_LOCKED_TYPE <>", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeGreaterThan(String value) {
            addCriterion("FORCED_LOCKED_TYPE >", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FORCED_LOCKED_TYPE >=", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeLessThan(String value) {
            addCriterion("FORCED_LOCKED_TYPE <", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeLessThanOrEqualTo(String value) {
            addCriterion("FORCED_LOCKED_TYPE <=", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeLike(String value) {
            addCriterion("FORCED_LOCKED_TYPE like", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeNotLike(String value) {
            addCriterion("FORCED_LOCKED_TYPE not like", value, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeIn(List<String> values) {
            addCriterion("FORCED_LOCKED_TYPE in", values, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeNotIn(List<String> values) {
            addCriterion("FORCED_LOCKED_TYPE not in", values, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeBetween(String value1, String value2) {
            addCriterion("FORCED_LOCKED_TYPE between", value1, value2, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andForcedLockedTypeNotBetween(String value1, String value2) {
            addCriterion("FORCED_LOCKED_TYPE not between", value1, value2, "forcedLockedType");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNull() {
            addCriterion("SEQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNotNull() {
            addCriterion("SEQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNumEqualTo(Integer value) {
            addCriterion("SEQ_NUM =", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotEqualTo(Integer value) {
            addCriterion("SEQ_NUM <>", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThan(Integer value) {
            addCriterion("SEQ_NUM >", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEQ_NUM >=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThan(Integer value) {
            addCriterion("SEQ_NUM <", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThanOrEqualTo(Integer value) {
            addCriterion("SEQ_NUM <=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumIn(List<Integer> values) {
            addCriterion("SEQ_NUM in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotIn(List<Integer> values) {
            addCriterion("SEQ_NUM not in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumBetween(Integer value1, Integer value2) {
            addCriterion("SEQ_NUM between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SEQ_NUM not between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeIsNull() {
            addCriterion("ISMONOPOLIZE is null");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeIsNotNull() {
            addCriterion("ISMONOPOLIZE is not null");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeEqualTo(String value) {
            addCriterion("ISMONOPOLIZE =", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeNotEqualTo(String value) {
            addCriterion("ISMONOPOLIZE <>", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeGreaterThan(String value) {
            addCriterion("ISMONOPOLIZE >", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeGreaterThanOrEqualTo(String value) {
            addCriterion("ISMONOPOLIZE >=", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeLessThan(String value) {
            addCriterion("ISMONOPOLIZE <", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeLessThanOrEqualTo(String value) {
            addCriterion("ISMONOPOLIZE <=", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeLike(String value) {
            addCriterion("ISMONOPOLIZE like", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeNotLike(String value) {
            addCriterion("ISMONOPOLIZE not like", value, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeIn(List<String> values) {
            addCriterion("ISMONOPOLIZE in", values, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeNotIn(List<String> values) {
            addCriterion("ISMONOPOLIZE not in", values, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeBetween(String value1, String value2) {
            addCriterion("ISMONOPOLIZE between", value1, value2, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsmonopolizeNotBetween(String value1, String value2) {
            addCriterion("ISMONOPOLIZE not between", value1, value2, "ismonopolize");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsIsNull() {
            addCriterion("IS_SYNC_OS is null");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsIsNotNull() {
            addCriterion("IS_SYNC_OS is not null");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsEqualTo(String value) {
            addCriterion("IS_SYNC_OS =", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsNotEqualTo(String value) {
            addCriterion("IS_SYNC_OS <>", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsGreaterThan(String value) {
            addCriterion("IS_SYNC_OS >", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SYNC_OS >=", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsLessThan(String value) {
            addCriterion("IS_SYNC_OS <", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsLessThanOrEqualTo(String value) {
            addCriterion("IS_SYNC_OS <=", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsLike(String value) {
            addCriterion("IS_SYNC_OS like", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsNotLike(String value) {
            addCriterion("IS_SYNC_OS not like", value, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsIn(List<String> values) {
            addCriterion("IS_SYNC_OS in", values, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsNotIn(List<String> values) {
            addCriterion("IS_SYNC_OS not in", values, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsBetween(String value1, String value2) {
            addCriterion("IS_SYNC_OS between", value1, value2, "isSyncOs");
            return (Criteria) this;
        }

        public Criteria andIsSyncOsNotBetween(String value1, String value2) {
            addCriterion("IS_SYNC_OS not between", value1, value2, "isSyncOs");
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