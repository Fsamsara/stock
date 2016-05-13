package com.metersbonwe.stock.po.sync;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProdPropIsNull() {
            addCriterion("PROD_PROP is null");
            return (Criteria) this;
        }

        public Criteria andProdPropIsNotNull() {
            addCriterion("PROD_PROP is not null");
            return (Criteria) this;
        }

        public Criteria andProdPropEqualTo(String value) {
            addCriterion("PROD_PROP =", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropNotEqualTo(String value) {
            addCriterion("PROD_PROP <>", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropGreaterThan(String value) {
            addCriterion("PROD_PROP >", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_PROP >=", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropLessThan(String value) {
            addCriterion("PROD_PROP <", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropLessThanOrEqualTo(String value) {
            addCriterion("PROD_PROP <=", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropLike(String value) {
            addCriterion("PROD_PROP like", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropNotLike(String value) {
            addCriterion("PROD_PROP not like", value, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropIn(List<String> values) {
            addCriterion("PROD_PROP in", values, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropNotIn(List<String> values) {
            addCriterion("PROD_PROP not in", values, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropBetween(String value1, String value2) {
            addCriterion("PROD_PROP between", value1, value2, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdPropNotBetween(String value1, String value2) {
            addCriterion("PROD_PROP not between", value1, value2, "prodProp");
            return (Criteria) this;
        }

        public Criteria andProdSortIsNull() {
            addCriterion("PROD_SORT is null");
            return (Criteria) this;
        }

        public Criteria andProdSortIsNotNull() {
            addCriterion("PROD_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andProdSortEqualTo(String value) {
            addCriterion("PROD_SORT =", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortNotEqualTo(String value) {
            addCriterion("PROD_SORT <>", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortGreaterThan(String value) {
            addCriterion("PROD_SORT >", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_SORT >=", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortLessThan(String value) {
            addCriterion("PROD_SORT <", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortLessThanOrEqualTo(String value) {
            addCriterion("PROD_SORT <=", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortLike(String value) {
            addCriterion("PROD_SORT like", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortNotLike(String value) {
            addCriterion("PROD_SORT not like", value, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortIn(List<String> values) {
            addCriterion("PROD_SORT in", values, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortNotIn(List<String> values) {
            addCriterion("PROD_SORT not in", values, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortBetween(String value1, String value2) {
            addCriterion("PROD_SORT between", value1, value2, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdSortNotBetween(String value1, String value2) {
            addCriterion("PROD_SORT not between", value1, value2, "prodSort");
            return (Criteria) this;
        }

        public Criteria andProdStyleIsNull() {
            addCriterion("PROD_STYLE is null");
            return (Criteria) this;
        }

        public Criteria andProdStyleIsNotNull() {
            addCriterion("PROD_STYLE is not null");
            return (Criteria) this;
        }

        public Criteria andProdStyleEqualTo(String value) {
            addCriterion("PROD_STYLE =", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleNotEqualTo(String value) {
            addCriterion("PROD_STYLE <>", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleGreaterThan(String value) {
            addCriterion("PROD_STYLE >", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_STYLE >=", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleLessThan(String value) {
            addCriterion("PROD_STYLE <", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleLessThanOrEqualTo(String value) {
            addCriterion("PROD_STYLE <=", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleLike(String value) {
            addCriterion("PROD_STYLE like", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleNotLike(String value) {
            addCriterion("PROD_STYLE not like", value, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleIn(List<String> values) {
            addCriterion("PROD_STYLE in", values, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleNotIn(List<String> values) {
            addCriterion("PROD_STYLE not in", values, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleBetween(String value1, String value2) {
            addCriterion("PROD_STYLE between", value1, value2, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andProdStyleNotBetween(String value1, String value2) {
            addCriterion("PROD_STYLE not between", value1, value2, "prodStyle");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("COLOR is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("COLOR =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("COLOR <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("COLOR >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("COLOR >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("COLOR <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("COLOR <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("COLOR like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("COLOR not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("COLOR in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("COLOR not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("COLOR between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("COLOR not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andEditionIsNull() {
            addCriterion("EDITION is null");
            return (Criteria) this;
        }

        public Criteria andEditionIsNotNull() {
            addCriterion("EDITION is not null");
            return (Criteria) this;
        }

        public Criteria andEditionEqualTo(String value) {
            addCriterion("EDITION =", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotEqualTo(String value) {
            addCriterion("EDITION <>", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionGreaterThan(String value) {
            addCriterion("EDITION >", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionGreaterThanOrEqualTo(String value) {
            addCriterion("EDITION >=", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLessThan(String value) {
            addCriterion("EDITION <", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLessThanOrEqualTo(String value) {
            addCriterion("EDITION <=", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLike(String value) {
            addCriterion("EDITION like", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotLike(String value) {
            addCriterion("EDITION not like", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionIn(List<String> values) {
            addCriterion("EDITION in", values, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotIn(List<String> values) {
            addCriterion("EDITION not in", values, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionBetween(String value1, String value2) {
            addCriterion("EDITION between", value1, value2, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotBetween(String value1, String value2) {
            addCriterion("EDITION not between", value1, value2, "edition");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("SPEC is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("SPEC is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("SPEC =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("SPEC <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("SPEC >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("SPEC >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("SPEC <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("SPEC <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("SPEC like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("SPEC not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("SPEC in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("SPEC not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("SPEC between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("SPEC not between", value1, value2, "spec");
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

        public Criteria andEfficientTimeIsNull() {
            addCriterion("EFFICIENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeIsNotNull() {
            addCriterion("EFFICIENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeEqualTo(Date value) {
            addCriterion("EFFICIENT_TIME =", value, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeNotEqualTo(Date value) {
            addCriterion("EFFICIENT_TIME <>", value, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeGreaterThan(Date value) {
            addCriterion("EFFICIENT_TIME >", value, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EFFICIENT_TIME >=", value, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeLessThan(Date value) {
            addCriterion("EFFICIENT_TIME <", value, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeLessThanOrEqualTo(Date value) {
            addCriterion("EFFICIENT_TIME <=", value, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeIn(List<Date> values) {
            addCriterion("EFFICIENT_TIME in", values, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeNotIn(List<Date> values) {
            addCriterion("EFFICIENT_TIME not in", values, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeBetween(Date value1, Date value2) {
            addCriterion("EFFICIENT_TIME between", value1, value2, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andEfficientTimeNotBetween(Date value1, Date value2) {
            addCriterion("EFFICIENT_TIME not between", value1, value2, "efficientTime");
            return (Criteria) this;
        }

        public Criteria andNeedSendIsNull() {
            addCriterion("NEED_SEND is null");
            return (Criteria) this;
        }

        public Criteria andNeedSendIsNotNull() {
            addCriterion("NEED_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andNeedSendEqualTo(String value) {
            addCriterion("NEED_SEND =", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendNotEqualTo(String value) {
            addCriterion("NEED_SEND <>", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendGreaterThan(String value) {
            addCriterion("NEED_SEND >", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendGreaterThanOrEqualTo(String value) {
            addCriterion("NEED_SEND >=", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendLessThan(String value) {
            addCriterion("NEED_SEND <", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendLessThanOrEqualTo(String value) {
            addCriterion("NEED_SEND <=", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendLike(String value) {
            addCriterion("NEED_SEND like", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendNotLike(String value) {
            addCriterion("NEED_SEND not like", value, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendIn(List<String> values) {
            addCriterion("NEED_SEND in", values, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendNotIn(List<String> values) {
            addCriterion("NEED_SEND not in", values, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendBetween(String value1, String value2) {
            addCriterion("NEED_SEND between", value1, value2, "needSend");
            return (Criteria) this;
        }

        public Criteria andNeedSendNotBetween(String value1, String value2) {
            addCriterion("NEED_SEND not between", value1, value2, "needSend");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNull() {
            addCriterion("SERIES is null");
            return (Criteria) this;
        }

        public Criteria andSeriesIsNotNull() {
            addCriterion("SERIES is not null");
            return (Criteria) this;
        }

        public Criteria andSeriesEqualTo(String value) {
            addCriterion("SERIES =", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotEqualTo(String value) {
            addCriterion("SERIES <>", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThan(String value) {
            addCriterion("SERIES >", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesGreaterThanOrEqualTo(String value) {
            addCriterion("SERIES >=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThan(String value) {
            addCriterion("SERIES <", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLessThanOrEqualTo(String value) {
            addCriterion("SERIES <=", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesLike(String value) {
            addCriterion("SERIES like", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotLike(String value) {
            addCriterion("SERIES not like", value, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesIn(List<String> values) {
            addCriterion("SERIES in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotIn(List<String> values) {
            addCriterion("SERIES not in", values, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesBetween(String value1, String value2) {
            addCriterion("SERIES between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andSeriesNotBetween(String value1, String value2) {
            addCriterion("SERIES not between", value1, value2, "series");
            return (Criteria) this;
        }

        public Criteria andPlanBatchIsNull() {
            addCriterion("PLAN_BATCH is null");
            return (Criteria) this;
        }

        public Criteria andPlanBatchIsNotNull() {
            addCriterion("PLAN_BATCH is not null");
            return (Criteria) this;
        }

        public Criteria andPlanBatchEqualTo(String value) {
            addCriterion("PLAN_BATCH =", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchNotEqualTo(String value) {
            addCriterion("PLAN_BATCH <>", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchGreaterThan(String value) {
            addCriterion("PLAN_BATCH >", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchGreaterThanOrEqualTo(String value) {
            addCriterion("PLAN_BATCH >=", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchLessThan(String value) {
            addCriterion("PLAN_BATCH <", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchLessThanOrEqualTo(String value) {
            addCriterion("PLAN_BATCH <=", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchLike(String value) {
            addCriterion("PLAN_BATCH like", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchNotLike(String value) {
            addCriterion("PLAN_BATCH not like", value, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchIn(List<String> values) {
            addCriterion("PLAN_BATCH in", values, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchNotIn(List<String> values) {
            addCriterion("PLAN_BATCH not in", values, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchBetween(String value1, String value2) {
            addCriterion("PLAN_BATCH between", value1, value2, "planBatch");
            return (Criteria) this;
        }

        public Criteria andPlanBatchNotBetween(String value1, String value2) {
            addCriterion("PLAN_BATCH not between", value1, value2, "planBatch");
            return (Criteria) this;
        }

        public Criteria andReckonTypeIsNull() {
            addCriterion("RECKON_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReckonTypeIsNotNull() {
            addCriterion("RECKON_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReckonTypeEqualTo(String value) {
            addCriterion("RECKON_TYPE =", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotEqualTo(String value) {
            addCriterion("RECKON_TYPE <>", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeGreaterThan(String value) {
            addCriterion("RECKON_TYPE >", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RECKON_TYPE >=", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeLessThan(String value) {
            addCriterion("RECKON_TYPE <", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeLessThanOrEqualTo(String value) {
            addCriterion("RECKON_TYPE <=", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeLike(String value) {
            addCriterion("RECKON_TYPE like", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotLike(String value) {
            addCriterion("RECKON_TYPE not like", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeIn(List<String> values) {
            addCriterion("RECKON_TYPE in", values, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotIn(List<String> values) {
            addCriterion("RECKON_TYPE not in", values, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeBetween(String value1, String value2) {
            addCriterion("RECKON_TYPE between", value1, value2, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotBetween(String value1, String value2) {
            addCriterion("RECKON_TYPE not between", value1, value2, "reckonType");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("REMARK1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("REMARK1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("REMARK1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("REMARK1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("REMARK1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("REMARK1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("REMARK1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("REMARK1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("REMARK1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("REMARK1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("REMARK1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("REMARK1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("REMARK1 not between", value1, value2, "remark1");
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

        public Criteria andProdClsIdIsNull() {
            addCriterion("PROD_CLS_ID is null");
            return (Criteria) this;
        }

        public Criteria andProdClsIdIsNotNull() {
            addCriterion("PROD_CLS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProdClsIdEqualTo(String value) {
            addCriterion("PROD_CLS_ID =", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdNotEqualTo(String value) {
            addCriterion("PROD_CLS_ID <>", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdGreaterThan(String value) {
            addCriterion("PROD_CLS_ID >", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_CLS_ID >=", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdLessThan(String value) {
            addCriterion("PROD_CLS_ID <", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdLessThanOrEqualTo(String value) {
            addCriterion("PROD_CLS_ID <=", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdLike(String value) {
            addCriterion("PROD_CLS_ID like", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdNotLike(String value) {
            addCriterion("PROD_CLS_ID not like", value, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdIn(List<String> values) {
            addCriterion("PROD_CLS_ID in", values, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdNotIn(List<String> values) {
            addCriterion("PROD_CLS_ID not in", values, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdBetween(String value1, String value2) {
            addCriterion("PROD_CLS_ID between", value1, value2, "prodClsId");
            return (Criteria) this;
        }

        public Criteria andProdClsIdNotBetween(String value1, String value2) {
            addCriterion("PROD_CLS_ID not between", value1, value2, "prodClsId");
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

        public Criteria andProdStateIsNull() {
            addCriterion("PROD_STATE is null");
            return (Criteria) this;
        }

        public Criteria andProdStateIsNotNull() {
            addCriterion("PROD_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andProdStateEqualTo(String value) {
            addCriterion("PROD_STATE =", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateNotEqualTo(String value) {
            addCriterion("PROD_STATE <>", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateGreaterThan(String value) {
            addCriterion("PROD_STATE >", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateGreaterThanOrEqualTo(String value) {
            addCriterion("PROD_STATE >=", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateLessThan(String value) {
            addCriterion("PROD_STATE <", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateLessThanOrEqualTo(String value) {
            addCriterion("PROD_STATE <=", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateLike(String value) {
            addCriterion("PROD_STATE like", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateNotLike(String value) {
            addCriterion("PROD_STATE not like", value, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateIn(List<String> values) {
            addCriterion("PROD_STATE in", values, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateNotIn(List<String> values) {
            addCriterion("PROD_STATE not in", values, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateBetween(String value1, String value2) {
            addCriterion("PROD_STATE between", value1, value2, "prodState");
            return (Criteria) this;
        }

        public Criteria andProdStateNotBetween(String value1, String value2) {
            addCriterion("PROD_STATE not between", value1, value2, "prodState");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATE_TIME not between", value1, value2, "updateTime");
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

        public Criteria andSapZzstatusIsNull() {
            addCriterion("SAP_ZZSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusIsNotNull() {
            addCriterion("SAP_ZZSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusEqualTo(String value) {
            addCriterion("SAP_ZZSTATUS =", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusNotEqualTo(String value) {
            addCriterion("SAP_ZZSTATUS <>", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusGreaterThan(String value) {
            addCriterion("SAP_ZZSTATUS >", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusGreaterThanOrEqualTo(String value) {
            addCriterion("SAP_ZZSTATUS >=", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusLessThan(String value) {
            addCriterion("SAP_ZZSTATUS <", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusLessThanOrEqualTo(String value) {
            addCriterion("SAP_ZZSTATUS <=", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusLike(String value) {
            addCriterion("SAP_ZZSTATUS like", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusNotLike(String value) {
            addCriterion("SAP_ZZSTATUS not like", value, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusIn(List<String> values) {
            addCriterion("SAP_ZZSTATUS in", values, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusNotIn(List<String> values) {
            addCriterion("SAP_ZZSTATUS not in", values, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusBetween(String value1, String value2) {
            addCriterion("SAP_ZZSTATUS between", value1, value2, "sapZzstatus");
            return (Criteria) this;
        }

        public Criteria andSapZzstatusNotBetween(String value1, String value2) {
            addCriterion("SAP_ZZSTATUS not between", value1, value2, "sapZzstatus");
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