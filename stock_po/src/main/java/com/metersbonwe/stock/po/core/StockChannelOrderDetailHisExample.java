package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockChannelOrderDetailHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockChannelOrderDetailHisExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(String value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(String value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(String value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(String value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(String value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(String value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLike(String value) {
            addCriterion("business_id like", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotLike(String value) {
            addCriterion("business_id not like", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<String> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<String> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(String value1, String value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(String value1, String value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdIsNull() {
            addCriterion("os_order_id is null");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdIsNotNull() {
            addCriterion("os_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdEqualTo(String value) {
            addCriterion("os_order_id =", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdNotEqualTo(String value) {
            addCriterion("os_order_id <>", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdGreaterThan(String value) {
            addCriterion("os_order_id >", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("os_order_id >=", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdLessThan(String value) {
            addCriterion("os_order_id <", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdLessThanOrEqualTo(String value) {
            addCriterion("os_order_id <=", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdLike(String value) {
            addCriterion("os_order_id like", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdNotLike(String value) {
            addCriterion("os_order_id not like", value, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdIn(List<String> values) {
            addCriterion("os_order_id in", values, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdNotIn(List<String> values) {
            addCriterion("os_order_id not in", values, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdBetween(String value1, String value2) {
            addCriterion("os_order_id between", value1, value2, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andOsOrderIdNotBetween(String value1, String value2) {
            addCriterion("os_order_id not between", value1, value2, "osOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdIsNull() {
            addCriterion("sub_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdIsNotNull() {
            addCriterion("sub_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdEqualTo(String value) {
            addCriterion("sub_order_id =", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotEqualTo(String value) {
            addCriterion("sub_order_id <>", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdGreaterThan(String value) {
            addCriterion("sub_order_id >", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_order_id >=", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdLessThan(String value) {
            addCriterion("sub_order_id <", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdLessThanOrEqualTo(String value) {
            addCriterion("sub_order_id <=", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdLike(String value) {
            addCriterion("sub_order_id like", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotLike(String value) {
            addCriterion("sub_order_id not like", value, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdIn(List<String> values) {
            addCriterion("sub_order_id in", values, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotIn(List<String> values) {
            addCriterion("sub_order_id not in", values, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdBetween(String value1, String value2) {
            addCriterion("sub_order_id between", value1, value2, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andSubOrderIdNotBetween(String value1, String value2) {
            addCriterion("sub_order_id not between", value1, value2, "subOrderId");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNull() {
            addCriterion("prod_id is null");
            return (Criteria) this;
        }

        public Criteria andProdIdIsNotNull() {
            addCriterion("prod_id is not null");
            return (Criteria) this;
        }

        public Criteria andProdIdEqualTo(String value) {
            addCriterion("prod_id =", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotEqualTo(String value) {
            addCriterion("prod_id <>", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThan(String value) {
            addCriterion("prod_id >", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdGreaterThanOrEqualTo(String value) {
            addCriterion("prod_id >=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThan(String value) {
            addCriterion("prod_id <", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLessThanOrEqualTo(String value) {
            addCriterion("prod_id <=", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdLike(String value) {
            addCriterion("prod_id like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotLike(String value) {
            addCriterion("prod_id not like", value, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdIn(List<String> values) {
            addCriterion("prod_id in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotIn(List<String> values) {
            addCriterion("prod_id not in", values, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdBetween(String value1, String value2) {
            addCriterion("prod_id between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andProdIdNotBetween(String value1, String value2) {
            addCriterion("prod_id not between", value1, value2, "prodId");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyIsNull() {
            addCriterion("is_pre_occupy is null");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyIsNotNull() {
            addCriterion("is_pre_occupy is not null");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyEqualTo(Integer value) {
            addCriterion("is_pre_occupy =", value, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyNotEqualTo(Integer value) {
            addCriterion("is_pre_occupy <>", value, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyGreaterThan(Integer value) {
            addCriterion("is_pre_occupy >", value, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pre_occupy >=", value, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyLessThan(Integer value) {
            addCriterion("is_pre_occupy <", value, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyLessThanOrEqualTo(Integer value) {
            addCriterion("is_pre_occupy <=", value, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyIn(List<Integer> values) {
            addCriterion("is_pre_occupy in", values, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyNotIn(List<Integer> values) {
            addCriterion("is_pre_occupy not in", values, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyBetween(Integer value1, Integer value2) {
            addCriterion("is_pre_occupy between", value1, value2, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andIsPreOccupyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pre_occupy not between", value1, value2, "isPreOccupy");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockIsNull() {
            addCriterion("order_private_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockIsNotNull() {
            addCriterion("order_private_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockEqualTo(Integer value) {
            addCriterion("order_private_stock =", value, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockNotEqualTo(Integer value) {
            addCriterion("order_private_stock <>", value, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockGreaterThan(Integer value) {
            addCriterion("order_private_stock >", value, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_private_stock >=", value, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockLessThan(Integer value) {
            addCriterion("order_private_stock <", value, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_private_stock <=", value, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockIn(List<Integer> values) {
            addCriterion("order_private_stock in", values, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockNotIn(List<Integer> values) {
            addCriterion("order_private_stock not in", values, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockBetween(Integer value1, Integer value2) {
            addCriterion("order_private_stock between", value1, value2, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderPrivateStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_private_stock not between", value1, value2, "orderPrivateStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockIsNull() {
            addCriterion("order_share_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockIsNotNull() {
            addCriterion("order_share_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockEqualTo(Integer value) {
            addCriterion("order_share_stock =", value, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockNotEqualTo(Integer value) {
            addCriterion("order_share_stock <>", value, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockGreaterThan(Integer value) {
            addCriterion("order_share_stock >", value, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_share_stock >=", value, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockLessThan(Integer value) {
            addCriterion("order_share_stock <", value, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_share_stock <=", value, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockIn(List<Integer> values) {
            addCriterion("order_share_stock in", values, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockNotIn(List<Integer> values) {
            addCriterion("order_share_stock not in", values, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockBetween(Integer value1, Integer value2) {
            addCriterion("order_share_stock between", value1, value2, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShareStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_share_stock not between", value1, value2, "orderShareStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockIsNull() {
            addCriterion("order_shop_group_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockIsNotNull() {
            addCriterion("order_shop_group_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockEqualTo(Integer value) {
            addCriterion("order_shop_group_stock =", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockNotEqualTo(Integer value) {
            addCriterion("order_shop_group_stock <>", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockGreaterThan(Integer value) {
            addCriterion("order_shop_group_stock >", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_shop_group_stock >=", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockLessThan(Integer value) {
            addCriterion("order_shop_group_stock <", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_shop_group_stock <=", value, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockIn(List<Integer> values) {
            addCriterion("order_shop_group_stock in", values, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockNotIn(List<Integer> values) {
            addCriterion("order_shop_group_stock not in", values, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockBetween(Integer value1, Integer value2) {
            addCriterion("order_shop_group_stock between", value1, value2, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andOrderShopGroupStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_shop_group_stock not between", value1, value2, "orderShopGroupStock");
            return (Criteria) this;
        }

        public Criteria andRelationChannelIsNull() {
            addCriterion("relation_channel is null");
            return (Criteria) this;
        }

        public Criteria andRelationChannelIsNotNull() {
            addCriterion("relation_channel is not null");
            return (Criteria) this;
        }

        public Criteria andRelationChannelEqualTo(String value) {
            addCriterion("relation_channel =", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelNotEqualTo(String value) {
            addCriterion("relation_channel <>", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelGreaterThan(String value) {
            addCriterion("relation_channel >", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelGreaterThanOrEqualTo(String value) {
            addCriterion("relation_channel >=", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelLessThan(String value) {
            addCriterion("relation_channel <", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelLessThanOrEqualTo(String value) {
            addCriterion("relation_channel <=", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelLike(String value) {
            addCriterion("relation_channel like", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelNotLike(String value) {
            addCriterion("relation_channel not like", value, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelIn(List<String> values) {
            addCriterion("relation_channel in", values, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelNotIn(List<String> values) {
            addCriterion("relation_channel not in", values, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelBetween(String value1, String value2) {
            addCriterion("relation_channel between", value1, value2, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andRelationChannelNotBetween(String value1, String value2) {
            addCriterion("relation_channel not between", value1, value2, "relationChannel");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
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