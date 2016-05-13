package com.metersbonwe.stock.po.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockPreSaleModifyDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockPreSaleModifyDetailExample() {
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

        public Criteria andRelationIdIsNull() {
            addCriterion("relation_id is null");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("relation_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelationIdEqualTo(Long value) {
            addCriterion("relation_id =", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotEqualTo(Long value) {
            addCriterion("relation_id <>", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThan(Long value) {
            addCriterion("relation_id >", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("relation_id >=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThan(Long value) {
            addCriterion("relation_id <", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThanOrEqualTo(Long value) {
            addCriterion("relation_id <=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdIn(List<Long> values) {
            addCriterion("relation_id in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotIn(List<Long> values) {
            addCriterion("relation_id not in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdBetween(Long value1, Long value2) {
            addCriterion("relation_id between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotBetween(Long value1, Long value2) {
            addCriterion("relation_id not between", value1, value2, "relationId");
            return (Criteria) this;
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

        public Criteria andPrePrivateStockIsNull() {
            addCriterion("pre_private_stock is null");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockIsNotNull() {
            addCriterion("pre_private_stock is not null");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockEqualTo(Integer value) {
            addCriterion("pre_private_stock =", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockNotEqualTo(Integer value) {
            addCriterion("pre_private_stock <>", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockGreaterThan(Integer value) {
            addCriterion("pre_private_stock >", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_private_stock >=", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockLessThan(Integer value) {
            addCriterion("pre_private_stock <", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockLessThanOrEqualTo(Integer value) {
            addCriterion("pre_private_stock <=", value, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockIn(List<Integer> values) {
            addCriterion("pre_private_stock in", values, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockNotIn(List<Integer> values) {
            addCriterion("pre_private_stock not in", values, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockBetween(Integer value1, Integer value2) {
            addCriterion("pre_private_stock between", value1, value2, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_private_stock not between", value1, value2, "prePrivateStock");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyIsNull() {
            addCriterion("pre_private_stock_modify is null");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyIsNotNull() {
            addCriterion("pre_private_stock_modify is not null");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyEqualTo(Integer value) {
            addCriterion("pre_private_stock_modify =", value, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyNotEqualTo(Integer value) {
            addCriterion("pre_private_stock_modify <>", value, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyGreaterThan(Integer value) {
            addCriterion("pre_private_stock_modify >", value, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_private_stock_modify >=", value, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyLessThan(Integer value) {
            addCriterion("pre_private_stock_modify <", value, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyLessThanOrEqualTo(Integer value) {
            addCriterion("pre_private_stock_modify <=", value, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyIn(List<Integer> values) {
            addCriterion("pre_private_stock_modify in", values, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyNotIn(List<Integer> values) {
            addCriterion("pre_private_stock_modify not in", values, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyBetween(Integer value1, Integer value2) {
            addCriterion("pre_private_stock_modify between", value1, value2, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andPrePrivateStockModifyNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_private_stock_modify not between", value1, value2, "prePrivateStockModify");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyIsNull() {
            addCriterion("end_time_modify is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyIsNotNull() {
            addCriterion("end_time_modify is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyEqualTo(Date value) {
            addCriterion("end_time_modify =", value, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyNotEqualTo(Date value) {
            addCriterion("end_time_modify <>", value, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyGreaterThan(Date value) {
            addCriterion("end_time_modify >", value, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time_modify >=", value, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyLessThan(Date value) {
            addCriterion("end_time_modify <", value, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyLessThanOrEqualTo(Date value) {
            addCriterion("end_time_modify <=", value, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyIn(List<Date> values) {
            addCriterion("end_time_modify in", values, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyNotIn(List<Date> values) {
            addCriterion("end_time_modify not in", values, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyBetween(Date value1, Date value2) {
            addCriterion("end_time_modify between", value1, value2, "endTimeModify");
            return (Criteria) this;
        }

        public Criteria andEndTimeModifyNotBetween(Date value1, Date value2) {
            addCriterion("end_time_modify not between", value1, value2, "endTimeModify");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andReservedStatusIsNull() {
            addCriterion("reserved_status is null");
            return (Criteria) this;
        }

        public Criteria andReservedStatusIsNotNull() {
            addCriterion("reserved_status is not null");
            return (Criteria) this;
        }

        public Criteria andReservedStatusEqualTo(Integer value) {
            addCriterion("reserved_status =", value, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusNotEqualTo(Integer value) {
            addCriterion("reserved_status <>", value, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusGreaterThan(Integer value) {
            addCriterion("reserved_status >", value, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserved_status >=", value, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusLessThan(Integer value) {
            addCriterion("reserved_status <", value, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusLessThanOrEqualTo(Integer value) {
            addCriterion("reserved_status <=", value, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusIn(List<Integer> values) {
            addCriterion("reserved_status in", values, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusNotIn(List<Integer> values) {
            addCriterion("reserved_status not in", values, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusBetween(Integer value1, Integer value2) {
            addCriterion("reserved_status between", value1, value2, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("reserved_status not between", value1, value2, "reservedStatus");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkIsNull() {
            addCriterion("reserved_remark is null");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkIsNotNull() {
            addCriterion("reserved_remark is not null");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkEqualTo(String value) {
            addCriterion("reserved_remark =", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkNotEqualTo(String value) {
            addCriterion("reserved_remark <>", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkGreaterThan(String value) {
            addCriterion("reserved_remark >", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("reserved_remark >=", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkLessThan(String value) {
            addCriterion("reserved_remark <", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkLessThanOrEqualTo(String value) {
            addCriterion("reserved_remark <=", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkLike(String value) {
            addCriterion("reserved_remark like", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkNotLike(String value) {
            addCriterion("reserved_remark not like", value, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkIn(List<String> values) {
            addCriterion("reserved_remark in", values, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkNotIn(List<String> values) {
            addCriterion("reserved_remark not in", values, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkBetween(String value1, String value2) {
            addCriterion("reserved_remark between", value1, value2, "reservedRemark");
            return (Criteria) this;
        }

        public Criteria andReservedRemarkNotBetween(String value1, String value2) {
            addCriterion("reserved_remark not between", value1, value2, "reservedRemark");
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