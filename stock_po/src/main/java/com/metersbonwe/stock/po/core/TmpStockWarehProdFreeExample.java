package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TmpStockWarehProdFreeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmpStockWarehProdFreeExample() {
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

        public Criteria andWarehIdIsNull() {
            addCriterion("wareh_id is null");
            return (Criteria) this;
        }

        public Criteria andWarehIdIsNotNull() {
            addCriterion("wareh_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarehIdEqualTo(String value) {
            addCriterion("wareh_id =", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotEqualTo(String value) {
            addCriterion("wareh_id <>", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdGreaterThan(String value) {
            addCriterion("wareh_id >", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdGreaterThanOrEqualTo(String value) {
            addCriterion("wareh_id >=", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLessThan(String value) {
            addCriterion("wareh_id <", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLessThanOrEqualTo(String value) {
            addCriterion("wareh_id <=", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdLike(String value) {
            addCriterion("wareh_id like", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotLike(String value) {
            addCriterion("wareh_id not like", value, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdIn(List<String> values) {
            addCriterion("wareh_id in", values, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotIn(List<String> values) {
            addCriterion("wareh_id not in", values, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdBetween(String value1, String value2) {
            addCriterion("wareh_id between", value1, value2, "warehId");
            return (Criteria) this;
        }

        public Criteria andWarehIdNotBetween(String value1, String value2) {
            addCriterion("wareh_id not between", value1, value2, "warehId");
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

        public Criteria andStkOnHandIsNull() {
            addCriterion("stk_on_hand is null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIsNotNull() {
            addCriterion("stk_on_hand is not null");
            return (Criteria) this;
        }

        public Criteria andStkOnHandEqualTo(Integer value) {
            addCriterion("stk_on_hand =", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotEqualTo(Integer value) {
            addCriterion("stk_on_hand <>", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandGreaterThan(Integer value) {
            addCriterion("stk_on_hand >", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandGreaterThanOrEqualTo(Integer value) {
            addCriterion("stk_on_hand >=", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandLessThan(Integer value) {
            addCriterion("stk_on_hand <", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandLessThanOrEqualTo(Integer value) {
            addCriterion("stk_on_hand <=", value, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandIn(List<Integer> values) {
            addCriterion("stk_on_hand in", values, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotIn(List<Integer> values) {
            addCriterion("stk_on_hand not in", values, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandBetween(Integer value1, Integer value2) {
            addCriterion("stk_on_hand between", value1, value2, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andStkOnHandNotBetween(Integer value1, Integer value2) {
            addCriterion("stk_on_hand not between", value1, value2, "stkOnHand");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedIsNull() {
            addCriterion("qty_committed is null");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedIsNotNull() {
            addCriterion("qty_committed is not null");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedEqualTo(Integer value) {
            addCriterion("qty_committed =", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedNotEqualTo(Integer value) {
            addCriterion("qty_committed <>", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedGreaterThan(Integer value) {
            addCriterion("qty_committed >", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedGreaterThanOrEqualTo(Integer value) {
            addCriterion("qty_committed >=", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedLessThan(Integer value) {
            addCriterion("qty_committed <", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedLessThanOrEqualTo(Integer value) {
            addCriterion("qty_committed <=", value, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedIn(List<Integer> values) {
            addCriterion("qty_committed in", values, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedNotIn(List<Integer> values) {
            addCriterion("qty_committed not in", values, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedBetween(Integer value1, Integer value2) {
            addCriterion("qty_committed between", value1, value2, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andQtyCommittedNotBetween(Integer value1, Integer value2) {
            addCriterion("qty_committed not between", value1, value2, "qtyCommitted");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockIsNull() {
            addCriterion("free_share_stock is null");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockIsNotNull() {
            addCriterion("free_share_stock is not null");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockEqualTo(Integer value) {
            addCriterion("free_share_stock =", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockNotEqualTo(Integer value) {
            addCriterion("free_share_stock <>", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockGreaterThan(Integer value) {
            addCriterion("free_share_stock >", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_share_stock >=", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockLessThan(Integer value) {
            addCriterion("free_share_stock <", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockLessThanOrEqualTo(Integer value) {
            addCriterion("free_share_stock <=", value, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockIn(List<Integer> values) {
            addCriterion("free_share_stock in", values, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockNotIn(List<Integer> values) {
            addCriterion("free_share_stock not in", values, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockBetween(Integer value1, Integer value2) {
            addCriterion("free_share_stock between", value1, value2, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andFreeShareStockNotBetween(Integer value1, Integer value2) {
            addCriterion("free_share_stock not between", value1, value2, "freeShareStock");
            return (Criteria) this;
        }

        public Criteria andSafeTypeIsNull() {
            addCriterion("safe_type is null");
            return (Criteria) this;
        }

        public Criteria andSafeTypeIsNotNull() {
            addCriterion("safe_type is not null");
            return (Criteria) this;
        }

        public Criteria andSafeTypeEqualTo(String value) {
            addCriterion("safe_type =", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotEqualTo(String value) {
            addCriterion("safe_type <>", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeGreaterThan(String value) {
            addCriterion("safe_type >", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("safe_type >=", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeLessThan(String value) {
            addCriterion("safe_type <", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeLessThanOrEqualTo(String value) {
            addCriterion("safe_type <=", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeLike(String value) {
            addCriterion("safe_type like", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotLike(String value) {
            addCriterion("safe_type not like", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeIn(List<String> values) {
            addCriterion("safe_type in", values, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotIn(List<String> values) {
            addCriterion("safe_type not in", values, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeBetween(String value1, String value2) {
            addCriterion("safe_type between", value1, value2, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotBetween(String value1, String value2) {
            addCriterion("safe_type not between", value1, value2, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeStockIsNull() {
            addCriterion("safe_stock is null");
            return (Criteria) this;
        }

        public Criteria andSafeStockIsNotNull() {
            addCriterion("safe_stock is not null");
            return (Criteria) this;
        }

        public Criteria andSafeStockEqualTo(Integer value) {
            addCriterion("safe_stock =", value, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockNotEqualTo(Integer value) {
            addCriterion("safe_stock <>", value, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockGreaterThan(Integer value) {
            addCriterion("safe_stock >", value, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("safe_stock >=", value, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockLessThan(Integer value) {
            addCriterion("safe_stock <", value, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockLessThanOrEqualTo(Integer value) {
            addCriterion("safe_stock <=", value, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockIn(List<Integer> values) {
            addCriterion("safe_stock in", values, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockNotIn(List<Integer> values) {
            addCriterion("safe_stock not in", values, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockBetween(Integer value1, Integer value2) {
            addCriterion("safe_stock between", value1, value2, "safeStock");
            return (Criteria) this;
        }

        public Criteria andSafeStockNotBetween(Integer value1, Integer value2) {
            addCriterion("safe_stock not between", value1, value2, "safeStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockIsNull() {
            addCriterion("wms_stock is null");
            return (Criteria) this;
        }

        public Criteria andWmsStockIsNotNull() {
            addCriterion("wms_stock is not null");
            return (Criteria) this;
        }

        public Criteria andWmsStockEqualTo(Integer value) {
            addCriterion("wms_stock =", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockNotEqualTo(Integer value) {
            addCriterion("wms_stock <>", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockGreaterThan(Integer value) {
            addCriterion("wms_stock >", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("wms_stock >=", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockLessThan(Integer value) {
            addCriterion("wms_stock <", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockLessThanOrEqualTo(Integer value) {
            addCriterion("wms_stock <=", value, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockIn(List<Integer> values) {
            addCriterion("wms_stock in", values, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockNotIn(List<Integer> values) {
            addCriterion("wms_stock not in", values, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockBetween(Integer value1, Integer value2) {
            addCriterion("wms_stock between", value1, value2, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andWmsStockNotBetween(Integer value1, Integer value2) {
            addCriterion("wms_stock not between", value1, value2, "wmsStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockIsNull() {
            addCriterion("remail_stock is null");
            return (Criteria) this;
        }

        public Criteria andRemailStockIsNotNull() {
            addCriterion("remail_stock is not null");
            return (Criteria) this;
        }

        public Criteria andRemailStockEqualTo(Integer value) {
            addCriterion("remail_stock =", value, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockNotEqualTo(Integer value) {
            addCriterion("remail_stock <>", value, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockGreaterThan(Integer value) {
            addCriterion("remail_stock >", value, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("remail_stock >=", value, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockLessThan(Integer value) {
            addCriterion("remail_stock <", value, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockLessThanOrEqualTo(Integer value) {
            addCriterion("remail_stock <=", value, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockIn(List<Integer> values) {
            addCriterion("remail_stock in", values, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockNotIn(List<Integer> values) {
            addCriterion("remail_stock not in", values, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockBetween(Integer value1, Integer value2) {
            addCriterion("remail_stock between", value1, value2, "remailStock");
            return (Criteria) this;
        }

        public Criteria andRemailStockNotBetween(Integer value1, Integer value2) {
            addCriterion("remail_stock not between", value1, value2, "remailStock");
            return (Criteria) this;
        }

        public Criteria andDameStockIsNull() {
            addCriterion("dame_stock is null");
            return (Criteria) this;
        }

        public Criteria andDameStockIsNotNull() {
            addCriterion("dame_stock is not null");
            return (Criteria) this;
        }

        public Criteria andDameStockEqualTo(Integer value) {
            addCriterion("dame_stock =", value, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockNotEqualTo(Integer value) {
            addCriterion("dame_stock <>", value, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockGreaterThan(Integer value) {
            addCriterion("dame_stock >", value, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("dame_stock >=", value, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockLessThan(Integer value) {
            addCriterion("dame_stock <", value, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockLessThanOrEqualTo(Integer value) {
            addCriterion("dame_stock <=", value, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockIn(List<Integer> values) {
            addCriterion("dame_stock in", values, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockNotIn(List<Integer> values) {
            addCriterion("dame_stock not in", values, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockBetween(Integer value1, Integer value2) {
            addCriterion("dame_stock between", value1, value2, "dameStock");
            return (Criteria) this;
        }

        public Criteria andDameStockNotBetween(Integer value1, Integer value2) {
            addCriterion("dame_stock not between", value1, value2, "dameStock");
            return (Criteria) this;
        }

        public Criteria andIsShopIsNull() {
            addCriterion("is_shop is null");
            return (Criteria) this;
        }

        public Criteria andIsShopIsNotNull() {
            addCriterion("is_shop is not null");
            return (Criteria) this;
        }

        public Criteria andIsShopEqualTo(Integer value) {
            addCriterion("is_shop =", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotEqualTo(Integer value) {
            addCriterion("is_shop <>", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopGreaterThan(Integer value) {
            addCriterion("is_shop >", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_shop >=", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopLessThan(Integer value) {
            addCriterion("is_shop <", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopLessThanOrEqualTo(Integer value) {
            addCriterion("is_shop <=", value, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopIn(List<Integer> values) {
            addCriterion("is_shop in", values, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotIn(List<Integer> values) {
            addCriterion("is_shop not in", values, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopBetween(Integer value1, Integer value2) {
            addCriterion("is_shop between", value1, value2, "isShop");
            return (Criteria) this;
        }

        public Criteria andIsShopNotBetween(Integer value1, Integer value2) {
            addCriterion("is_shop not between", value1, value2, "isShop");
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