package com.metersbonwe.stock.po.sync;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BfProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BfProductExample() {
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

        public Criteria andBfProdClsIdIsNull() {
            addCriterion("BF_PROD_CLS_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdIsNotNull() {
            addCriterion("BF_PROD_CLS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_CLS_ID =", value, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_CLS_ID <>", value, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdGreaterThan(BigDecimal value) {
            addCriterion("BF_PROD_CLS_ID >", value, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_CLS_ID >=", value, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdLessThan(BigDecimal value) {
            addCriterion("BF_PROD_CLS_ID <", value, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_CLS_ID <=", value, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_CLS_ID in", values, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_CLS_ID not in", values, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_CLS_ID between", value1, value2, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdClsIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_CLS_ID not between", value1, value2, "bfProdClsId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdIsNull() {
            addCriterion("BF_PROD_COLOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdIsNotNull() {
            addCriterion("BF_PROD_COLOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_COLOR_ID =", value, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_COLOR_ID <>", value, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdGreaterThan(BigDecimal value) {
            addCriterion("BF_PROD_COLOR_ID >", value, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_COLOR_ID >=", value, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdLessThan(BigDecimal value) {
            addCriterion("BF_PROD_COLOR_ID <", value, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_COLOR_ID <=", value, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_COLOR_ID in", values, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_COLOR_ID not in", values, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_COLOR_ID between", value1, value2, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdColorIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_COLOR_ID not between", value1, value2, "bfProdColorId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdIsNull() {
            addCriterion("BF_PROD_EDTN_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdIsNotNull() {
            addCriterion("BF_PROD_EDTN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_EDTN_ID =", value, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_EDTN_ID <>", value, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdGreaterThan(BigDecimal value) {
            addCriterion("BF_PROD_EDTN_ID >", value, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_EDTN_ID >=", value, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdLessThan(BigDecimal value) {
            addCriterion("BF_PROD_EDTN_ID <", value, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_EDTN_ID <=", value, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_EDTN_ID in", values, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_EDTN_ID not in", values, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_EDTN_ID between", value1, value2, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdEdtnIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_EDTN_ID not between", value1, value2, "bfProdEdtnId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdIsNull() {
            addCriterion("BF_PROD_SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdIsNotNull() {
            addCriterion("BF_PROD_SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_SPEC_ID =", value, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdNotEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_SPEC_ID <>", value, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdGreaterThan(BigDecimal value) {
            addCriterion("BF_PROD_SPEC_ID >", value, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_SPEC_ID >=", value, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdLessThan(BigDecimal value) {
            addCriterion("BF_PROD_SPEC_ID <", value, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BF_PROD_SPEC_ID <=", value, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_SPEC_ID in", values, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdNotIn(List<BigDecimal> values) {
            addCriterion("BF_PROD_SPEC_ID not in", values, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_SPEC_ID between", value1, value2, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andBfProdSpecIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BF_PROD_SPEC_ID not between", value1, value2, "bfProdSpecId");
            return (Criteria) this;
        }

        public Criteria andProdNumIsNull() {
            addCriterion("PROD_NUM is null");
            return (Criteria) this;
        }

        public Criteria andProdNumIsNotNull() {
            addCriterion("PROD_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andProdNumEqualTo(String value) {
            addCriterion("PROD_NUM =", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumNotEqualTo(String value) {
            addCriterion("PROD_NUM <>", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumGreaterThan(String value) {
            addCriterion("PROD_NUM >", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_NUM >=", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumLessThan(String value) {
            addCriterion("PROD_NUM <", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumLessThanOrEqualTo(String value) {
            addCriterion("PROD_NUM <=", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumLike(String value) {
            addCriterion("PROD_NUM like", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumNotLike(String value) {
            addCriterion("PROD_NUM not like", value, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumIn(List<String> values) {
            addCriterion("PROD_NUM in", values, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumNotIn(List<String> values) {
            addCriterion("PROD_NUM not in", values, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumBetween(String value1, String value2) {
            addCriterion("PROD_NUM between", value1, value2, "prodNum");
            return (Criteria) this;
        }

        public Criteria andProdNumNotBetween(String value1, String value2) {
            addCriterion("PROD_NUM not between", value1, value2, "prodNum");
            return (Criteria) this;
        }

        public Criteria andAdditDescIsNull() {
            addCriterion("ADDIT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andAdditDescIsNotNull() {
            addCriterion("ADDIT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andAdditDescEqualTo(String value) {
            addCriterion("ADDIT_DESC =", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescNotEqualTo(String value) {
            addCriterion("ADDIT_DESC <>", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescGreaterThan(String value) {
            addCriterion("ADDIT_DESC >", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescGreaterThanOrEqualTo(String value) {
            addCriterion("ADDIT_DESC >=", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescLessThan(String value) {
            addCriterion("ADDIT_DESC <", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescLessThanOrEqualTo(String value) {
            addCriterion("ADDIT_DESC <=", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescLike(String value) {
            addCriterion("ADDIT_DESC like", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescNotLike(String value) {
            addCriterion("ADDIT_DESC not like", value, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescIn(List<String> values) {
            addCriterion("ADDIT_DESC in", values, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescNotIn(List<String> values) {
            addCriterion("ADDIT_DESC not in", values, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescBetween(String value1, String value2) {
            addCriterion("ADDIT_DESC between", value1, value2, "additDesc");
            return (Criteria) this;
        }

        public Criteria andAdditDescNotBetween(String value1, String value2) {
            addCriterion("ADDIT_DESC not between", value1, value2, "additDesc");
            return (Criteria) this;
        }

        public Criteria andInnerBcIsNull() {
            addCriterion("INNER_BC is null");
            return (Criteria) this;
        }

        public Criteria andInnerBcIsNotNull() {
            addCriterion("INNER_BC is not null");
            return (Criteria) this;
        }

        public Criteria andInnerBcEqualTo(String value) {
            addCriterion("INNER_BC =", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcNotEqualTo(String value) {
            addCriterion("INNER_BC <>", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcGreaterThan(String value) {
            addCriterion("INNER_BC >", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcGreaterThanOrEqualTo(String value) {
            addCriterion("INNER_BC >=", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcLessThan(String value) {
            addCriterion("INNER_BC <", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcLessThanOrEqualTo(String value) {
            addCriterion("INNER_BC <=", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcLike(String value) {
            addCriterion("INNER_BC like", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcNotLike(String value) {
            addCriterion("INNER_BC not like", value, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcIn(List<String> values) {
            addCriterion("INNER_BC in", values, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcNotIn(List<String> values) {
            addCriterion("INNER_BC not in", values, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcBetween(String value1, String value2) {
            addCriterion("INNER_BC between", value1, value2, "innerBc");
            return (Criteria) this;
        }

        public Criteria andInnerBcNotBetween(String value1, String value2) {
            addCriterion("INNER_BC not between", value1, value2, "innerBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcIsNull() {
            addCriterion("INTNL_BC is null");
            return (Criteria) this;
        }

        public Criteria andIntnlBcIsNotNull() {
            addCriterion("INTNL_BC is not null");
            return (Criteria) this;
        }

        public Criteria andIntnlBcEqualTo(String value) {
            addCriterion("INTNL_BC =", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcNotEqualTo(String value) {
            addCriterion("INTNL_BC <>", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcGreaterThan(String value) {
            addCriterion("INTNL_BC >", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcGreaterThanOrEqualTo(String value) {
            addCriterion("INTNL_BC >=", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcLessThan(String value) {
            addCriterion("INTNL_BC <", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcLessThanOrEqualTo(String value) {
            addCriterion("INTNL_BC <=", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcLike(String value) {
            addCriterion("INTNL_BC like", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcNotLike(String value) {
            addCriterion("INTNL_BC not like", value, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcIn(List<String> values) {
            addCriterion("INTNL_BC in", values, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcNotIn(List<String> values) {
            addCriterion("INTNL_BC not in", values, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcBetween(String value1, String value2) {
            addCriterion("INTNL_BC between", value1, value2, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andIntnlBcNotBetween(String value1, String value2) {
            addCriterion("INTNL_BC not between", value1, value2, "intnlBc");
            return (Criteria) this;
        }

        public Criteria andProdStatusIsNull() {
            addCriterion("PROD_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andProdStatusIsNotNull() {
            addCriterion("PROD_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andProdStatusEqualTo(String value) {
            addCriterion("PROD_STATUS =", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusNotEqualTo(String value) {
            addCriterion("PROD_STATUS <>", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusGreaterThan(String value) {
            addCriterion("PROD_STATUS >", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_STATUS >=", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusLessThan(String value) {
            addCriterion("PROD_STATUS <", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusLessThanOrEqualTo(String value) {
            addCriterion("PROD_STATUS <=", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusLike(String value) {
            addCriterion("PROD_STATUS like", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusNotLike(String value) {
            addCriterion("PROD_STATUS not like", value, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusIn(List<String> values) {
            addCriterion("PROD_STATUS in", values, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusNotIn(List<String> values) {
            addCriterion("PROD_STATUS not in", values, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusBetween(String value1, String value2) {
            addCriterion("PROD_STATUS between", value1, value2, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andProdStatusNotBetween(String value1, String value2) {
            addCriterion("PROD_STATUS not between", value1, value2, "prodStatus");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("CANCEL_REASON is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("CANCEL_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("CANCEL_REASON =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("CANCEL_REASON <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("CANCEL_REASON >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("CANCEL_REASON >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("CANCEL_REASON <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("CANCEL_REASON <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("CANCEL_REASON like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("CANCEL_REASON not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("CANCEL_REASON in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("CANCEL_REASON not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("CANCEL_REASON between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("CANCEL_REASON not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andProdGridIsNull() {
            addCriterion("PROD_GRID is null");
            return (Criteria) this;
        }

        public Criteria andProdGridIsNotNull() {
            addCriterion("PROD_GRID is not null");
            return (Criteria) this;
        }

        public Criteria andProdGridEqualTo(String value) {
            addCriterion("PROD_GRID =", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridNotEqualTo(String value) {
            addCriterion("PROD_GRID <>", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridGreaterThan(String value) {
            addCriterion("PROD_GRID >", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_GRID >=", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridLessThan(String value) {
            addCriterion("PROD_GRID <", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridLessThanOrEqualTo(String value) {
            addCriterion("PROD_GRID <=", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridLike(String value) {
            addCriterion("PROD_GRID like", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridNotLike(String value) {
            addCriterion("PROD_GRID not like", value, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridIn(List<String> values) {
            addCriterion("PROD_GRID in", values, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridNotIn(List<String> values) {
            addCriterion("PROD_GRID not in", values, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridBetween(String value1, String value2) {
            addCriterion("PROD_GRID between", value1, value2, "prodGrid");
            return (Criteria) this;
        }

        public Criteria andProdGridNotBetween(String value1, String value2) {
            addCriterion("PROD_GRID not between", value1, value2, "prodGrid");
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

        public Criteria andIsTransB2cIsNull() {
            addCriterion("IS_TRANS_B2C is null");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cIsNotNull() {
            addCriterion("IS_TRANS_B2C is not null");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cEqualTo(String value) {
            addCriterion("IS_TRANS_B2C =", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cNotEqualTo(String value) {
            addCriterion("IS_TRANS_B2C <>", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cGreaterThan(String value) {
            addCriterion("IS_TRANS_B2C >", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TRANS_B2C >=", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cLessThan(String value) {
            addCriterion("IS_TRANS_B2C <", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cLessThanOrEqualTo(String value) {
            addCriterion("IS_TRANS_B2C <=", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cLike(String value) {
            addCriterion("IS_TRANS_B2C like", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cNotLike(String value) {
            addCriterion("IS_TRANS_B2C not like", value, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cIn(List<String> values) {
            addCriterion("IS_TRANS_B2C in", values, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cNotIn(List<String> values) {
            addCriterion("IS_TRANS_B2C not in", values, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cBetween(String value1, String value2) {
            addCriterion("IS_TRANS_B2C between", value1, value2, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andIsTransB2cNotBetween(String value1, String value2) {
            addCriterion("IS_TRANS_B2C not between", value1, value2, "isTransB2c");
            return (Criteria) this;
        }

        public Criteria andCalcMarginIsNull() {
            addCriterion("CALC_MARGIN is null");
            return (Criteria) this;
        }

        public Criteria andCalcMarginIsNotNull() {
            addCriterion("CALC_MARGIN is not null");
            return (Criteria) this;
        }

        public Criteria andCalcMarginEqualTo(String value) {
            addCriterion("CALC_MARGIN =", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginNotEqualTo(String value) {
            addCriterion("CALC_MARGIN <>", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginGreaterThan(String value) {
            addCriterion("CALC_MARGIN >", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginGreaterThanOrEqualTo(String value) {
            addCriterion("CALC_MARGIN >=", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginLessThan(String value) {
            addCriterion("CALC_MARGIN <", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginLessThanOrEqualTo(String value) {
            addCriterion("CALC_MARGIN <=", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginLike(String value) {
            addCriterion("CALC_MARGIN like", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginNotLike(String value) {
            addCriterion("CALC_MARGIN not like", value, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginIn(List<String> values) {
            addCriterion("CALC_MARGIN in", values, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginNotIn(List<String> values) {
            addCriterion("CALC_MARGIN not in", values, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginBetween(String value1, String value2) {
            addCriterion("CALC_MARGIN between", value1, value2, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andCalcMarginNotBetween(String value1, String value2) {
            addCriterion("CALC_MARGIN not between", value1, value2, "calcMargin");
            return (Criteria) this;
        }

        public Criteria andIsSapManageIsNull() {
            addCriterion("IS_SAP_MANAGE is null");
            return (Criteria) this;
        }

        public Criteria andIsSapManageIsNotNull() {
            addCriterion("IS_SAP_MANAGE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSapManageEqualTo(String value) {
            addCriterion("IS_SAP_MANAGE =", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageNotEqualTo(String value) {
            addCriterion("IS_SAP_MANAGE <>", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageGreaterThan(String value) {
            addCriterion("IS_SAP_MANAGE >", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SAP_MANAGE >=", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageLessThan(String value) {
            addCriterion("IS_SAP_MANAGE <", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageLessThanOrEqualTo(String value) {
            addCriterion("IS_SAP_MANAGE <=", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageLike(String value) {
            addCriterion("IS_SAP_MANAGE like", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageNotLike(String value) {
            addCriterion("IS_SAP_MANAGE not like", value, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageIn(List<String> values) {
            addCriterion("IS_SAP_MANAGE in", values, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageNotIn(List<String> values) {
            addCriterion("IS_SAP_MANAGE not in", values, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageBetween(String value1, String value2) {
            addCriterion("IS_SAP_MANAGE between", value1, value2, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSapManageNotBetween(String value1, String value2) {
            addCriterion("IS_SAP_MANAGE not between", value1, value2, "isSapManage");
            return (Criteria) this;
        }

        public Criteria andIsSampleIsNull() {
            addCriterion("IS_SAMPLE is null");
            return (Criteria) this;
        }

        public Criteria andIsSampleIsNotNull() {
            addCriterion("IS_SAMPLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSampleEqualTo(String value) {
            addCriterion("IS_SAMPLE =", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleNotEqualTo(String value) {
            addCriterion("IS_SAMPLE <>", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleGreaterThan(String value) {
            addCriterion("IS_SAMPLE >", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleGreaterThanOrEqualTo(String value) {
            addCriterion("IS_SAMPLE >=", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleLessThan(String value) {
            addCriterion("IS_SAMPLE <", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleLessThanOrEqualTo(String value) {
            addCriterion("IS_SAMPLE <=", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleLike(String value) {
            addCriterion("IS_SAMPLE like", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleNotLike(String value) {
            addCriterion("IS_SAMPLE not like", value, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleIn(List<String> values) {
            addCriterion("IS_SAMPLE in", values, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleNotIn(List<String> values) {
            addCriterion("IS_SAMPLE not in", values, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleBetween(String value1, String value2) {
            addCriterion("IS_SAMPLE between", value1, value2, "isSample");
            return (Criteria) this;
        }

        public Criteria andIsSampleNotBetween(String value1, String value2) {
            addCriterion("IS_SAMPLE not between", value1, value2, "isSample");
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