---------------------------------------------
-- Export file for user STOCK_USER         --
-- Created by FENG on 2016-04-14, 11:29:14 --
---------------------------------------------

set define off
spool mtsbw-view-meta.log

prompt
prompt Creating table BF_ORG
prompt =====================
prompt
create table BF_ORG
(
  id                 INTEGER not null,
  name               VARCHAR2(64),
  code               VARCHAR2(32),
  old_id             VARCHAR2(32),
  input_code         VARCHAR2(32),
  sort_code          VARCHAR2(32),
  bf_org_type_id     INTEGER,
  country            VARCHAR2(50),
  province           VARCHAR2(50),
  city               VARCHAR2(50),
  address            VARCHAR2(100),
  postcode           VARCHAR2(6),
  ph_num             VARCHAR2(25),
  fax_num            VARCHAR2(25),
  email_addr         VARCHAR2(30),
  website            VARCHAR2(60),
  region_code        VARCHAR2(4),
  simple_addr        VARCHAR2(100),
  deta_address       VARCHAR2(250),
  status             VARCHAR2(4),
  owner_id           INTEGER,
  remark             VARCHAR2(255),
  last_modified_date TIMESTAMP(6),
  county             VARCHAR2(50),
  act_province       VARCHAR2(32),
  act_city           VARCHAR2(32),
  act_county         VARCHAR2(32),
  act_dtl_address    VARCHAR2(100),
  to_user            VARCHAR2(32),
  to_user_tel        VARCHAR2(32),
  to_user_phone      VARCHAR2(32),
  from_user          VARCHAR2(32),
  from_user_tel      VARCHAR2(32),
  act_country        VARCHAR2(32),
  business_range     VARCHAR2(4),
  profit_center      VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 7M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table BF_ORG
  is '记录组织基本信息
';
comment on column BF_ORG.old_id
  is 'Old ID';
comment on column BF_ORG.input_code
  is 'Input Code';
comment on column BF_ORG.sort_code
  is 'Sort Code';
comment on column BF_ORG.address
  is 'Address';
comment on column BF_ORG.postcode
  is 'Postcode';
comment on column BF_ORG.ph_num
  is 'Phone Number';
comment on column BF_ORG.fax_num
  is 'Fax Number';
comment on column BF_ORG.email_addr
  is 'Email Address';
comment on column BF_ORG.website
  is 'Website Address';
comment on column BF_ORG.region_code
  is 'Region Code';
comment on column BF_ORG.remark
  is 'Remark';
comment on column BF_ORG.profit_center
  is '利润中心';
create index IDX2_BF_ORG_CODE on BF_ORG (COUNTRY, PROVINCE, CITY)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 896K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_BF_ORG_CODE on BF_ORG (CODE)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1088K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BF_ORG
  add constraint PK_BF_ORG primary key (ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 832K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table BF_ORG_SHOP
prompt ==========================
prompt
create table BF_ORG_SHOP
(
  bf_org_id          INTEGER not null,
  shop_type          VARCHAR2(4),
  man_code           VARCHAR2(32),
  open_date          DATE,
  close_date         DATE,
  acreage            NUMBER(18,6),
  settle_date        DATE,
  rent_rate          NUMBER(7,4),
  company_code       VARCHAR2(32),
  profit_center      VARCHAR2(32),
  account_group      VARCHAR2(32),
  sap_id             INTEGER,
  last_modified_date TIMESTAMP(6),
  owner_id           INTEGER,
  default_wareh_id   NUMBER(38),
  store_scope        VARCHAR2(32),
  customer_level     VARCHAR2(32),
  offlineship        CHAR(1),
  offlincac          CHAR(1),
  offline_order_ship CHAR(1),
  is_synctoos        CHAR(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table BF_ORG_SHOP
  is '门店信息';
comment on column BF_ORG_SHOP.bf_org_id
  is 'Factory ID';
comment on column BF_ORG_SHOP.shop_type
  is 'Shop Type';
comment on column BF_ORG_SHOP.open_date
  is 'Open Date';
comment on column BF_ORG_SHOP.close_date
  is 'Close Date';
comment on column BF_ORG_SHOP.acreage
  is 'Acreage';
comment on column BF_ORG_SHOP.settle_date
  is 'Settle Date';
comment on column BF_ORG_SHOP.customer_level
  is '门店等级';
comment on column BF_ORG_SHOP.offlineship
  is '参与线上订单配发';
comment on column BF_ORG_SHOP.offlincac
  is '参与线下自提';
alter table BF_ORG_SHOP
  add constraint PK_BF_ORG_SHOP primary key (BF_ORG_ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 384K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BF_ORG_SHOP
  add constraint FK_BF_ORG_S_REF_BF_ORG foreign key (BF_ORG_ID)
  references BF_ORG (ID);

prompt
prompt Creating table BF_PARTNER_SHOP
prompt ==============================
prompt
create table BF_PARTNER_SHOP
(
  id                 INTEGER not null,
  agent_id           INTEGER,
  shop_id            INTEGER,
  owner_id           INTEGER,
  account_wareh_id   INTEGER,
  shop_manager       VARCHAR2(100),
  shop_phone         VARCHAR2(100),
  shop_address       VARCHAR2(1000),
  province           VARCHAR2(1000),
  city               VARCHAR2(1000),
  county             VARCHAR2(1000),
  remark             VARCHAR2(255),
  create_user        VARCHAR2(32),
  create_date        TIMESTAMP(6),
  last_modified_user VARCHAR2(32),
  last_modified_date TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table BF_PRODUCT
prompt =========================
prompt
create table BF_PRODUCT
(
  id               INTEGER not null,
  bf_prod_cls_id   INTEGER not null,
  bf_prod_color_id INTEGER,
  bf_prod_edtn_id  INTEGER,
  bf_prod_spec_id  INTEGER,
  prod_num         VARCHAR2(32),
  addit_desc       VARCHAR2(100),
  inner_bc         VARCHAR2(16),
  intnl_bc         VARCHAR2(16),
  prod_status      CHAR(1),
  cancel_reason    VARCHAR2(32),
  prod_grid        VARCHAR2(32),
  remark           VARCHAR2(255),
  is_trans_b2c     CHAR(1),
  calc_margin      VARCHAR2(32),
  is_sap_manage    CHAR(1),
  is_sample        CHAR(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 135M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table BF_PRODUCT
  is 'SKU';
comment on column BF_PRODUCT.addit_desc
  is 'Additional Description';
comment on column BF_PRODUCT.inner_bc
  is 'Inner Barcode';
comment on column BF_PRODUCT.intnl_bc
  is 'International Barcode';
comment on column BF_PRODUCT.remark
  is 'Remark';
comment on column BF_PRODUCT.is_sap_manage
  is '是否SAP管理';
comment on column BF_PRODUCT.is_sample
  is '是否为样衣';
create unique index IDX_BF_PRODUCT on BF_PRODUCT (PROD_NUM)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 36352K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_BF_PRODUCT_1 on BF_PRODUCT (PROD_STATUS, ID, PROD_NUM)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 50304K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_BF_PRODUCT_BF_PROD_EDTN_ID on BF_PRODUCT (BF_PROD_EDTN_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 23104K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_BF_PRODUCT_CLS on BF_PRODUCT (BF_PROD_CLS_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 26432K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_BF_PRODUCT_INNER_BC on BF_PRODUCT (INNER_BC)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40576K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_BF_PRODUCT_INTNL_BC on BF_PRODUCT (INTNL_BC)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 31104K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_CALC_MARGIN on BF_PRODUCT (CALC_MARGIN)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 21M
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index PK_BF_PRODUCT on BF_PRODUCT (ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 25792K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DR_INTERFACE_PRO
prompt ===============================
prompt
create table DR_INTERFACE_PRO
(
  id          INTEGER not null,
  code        VARCHAR2(32),
  unit_id     INTEGER,
  new_date    TIMESTAMP(6),
  create_user VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table DR_INTERFACE_PRO
  is 'DR_接口切换查询';
comment on column DR_INTERFACE_PRO.id
  is 'ID';
comment on column DR_INTERFACE_PRO.code
  is 'Serial number';
comment on column DR_INTERFACE_PRO.unit_id
  is 'UNIT_ID';
comment on column DR_INTERFACE_PRO.new_date
  is 'Switching time';
comment on column DR_INTERFACE_PRO.create_user
  is 'Operation user';
create index INX_DR_INTERFACE_PRO_UNIT on DR_INTERFACE_PRO (UNIT_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table DR_INTERFACE_PRO
  add constraint PK_DR_INTERFACE_PRO primary key (ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table MV_TT
prompt ====================
prompt
create table MV_TT
(
  idx         NUMBER,
  wareh_id    VARCHAR2(32) not null,
  prod_id     CHAR(11) not null,
  stk_on_hand NUMBER(15,6) not null,
  sku_num     NUMBER(15,6) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 488M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table MV_TT
  is 'snapshot table for snapshot TEST.MV_TT';

prompt
prompt Creating table PRODUCT
prompt ======================
prompt
create table PRODUCT
(
  prod_id        VARCHAR2(20) not null,
  prod_prop      VARCHAR2(10) not null,
  prod_sort      VARCHAR2(10) not null,
  prod_style     VARCHAR2(10) not null,
  color          CHAR(2) not null,
  edition        CHAR(1) not null,
  spec           CHAR(2) not null,
  addit_desc     VARCHAR2(200),
  inner_bc       CHAR(13) not null,
  intnl_bc       VARCHAR2(17),
  remark         VARCHAR2(50),
  efficient_time TIMESTAMP(6),
  need_send      VARCHAR2(2) default '10',
  series         VARCHAR2(15),
  plan_batch     VARCHAR2(15),
  reckon_type    VARCHAR2(32),
  remark1        VARCHAR2(100),
  prod_num       VARCHAR2(20),
  prod_cls_id    VARCHAR2(20),
  prod_grid      VARCHAR2(8),
  prod_state     VARCHAR2(1) default 'A',
  update_time    DATE,
  is_sap_manage  VARCHAR2(1),
  is_sample      VARCHAR2(1),
  sap_zzstatus   VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 168M
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_PRODUCT5 on PRODUCT (PROD_ID, PROD_PROP, PROD_SORT, PROD_STYLE)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 53696K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_PRODUCT_1 on PRODUCT (PROD_PROP, PROD_SORT, PROD_STYLE, COLOR, EDITION, SPEC)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 45440K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_PRODUCT_2 on PRODUCT (INNER_BC)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 40256K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_PRODUCT_3 on PRODUCT (INTNL_BC)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 31040K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_PRODUCT_4 on PRODUCT (PROD_PROP||PROD_SORT||PROD_STYLE)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 30336K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PRODUCT
  add constraint PK_PRODUCT primary key (PROD_ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 36992K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SF_STK_DTL
prompt =========================
prompt
create table SF_STK_DTL
(
  id                  INTEGER not null,
  sf_warehouse_loc_id INTEGER not null,
  prod_id             INTEGER not null,
  stk_on_hand         NUMBER(18,6) not null,
  expd_qty            NUMBER(18,6) not null,
  alloc_qty           NUMBER(18,6) not null,
  bf_org_id           NUMBER not null,
  last_modified_date  TIMESTAMP(6),
  last_pick_time      TIMESTAMP(6),
  lock_qty            NUMBER(18,6),
  stk_on_hand_befor   NUMBER(18,6),
  expd_qty_befor      NUMBER(18,6),
  sttk_lock_qty       NUMBER(18,6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SF_WAREHOUSE_LOC
prompt ===============================
prompt
create table SF_WAREHOUSE_LOC
(
  id                   INTEGER not null,
  sf_warehouse_zone_id INTEGER not null,
  code                 VARCHAR2(32) not null,
  loc_prop             VARCHAR2(32),
  dimension            NUMBER(18,6),
  description          VARCHAR2(100),
  loc_desc             VARCHAR2(100),
  loc_trans_loc_id     INTEGER,
  floor_num            VARCHAR2(32),
  lock_status          VARCHAR2(16),
  laneway              VARCHAR2(32),
  sequence_num         NUMBER(18),
  row_code             VARCHAR2(32),
  pick_trace_num       NUMBER(18),
  flow_type            VARCHAR2(16),
  on_shelf_num         VARCHAR2(32),
  last_ctrlr_time      TIMESTAMP(6),
  lock_type            VARCHAR2(16),
  box_adopted          CHAR(1) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SF_WAREHOUSE_ZONE
prompt ================================
prompt
create table SF_WAREHOUSE_ZONE
(
  id                    INTEGER not null,
  bf_org_id             INTEGER not null,
  code                  VARCHAR2(32) not null,
  description           VARCHAR2(100),
  floor                 NUMBER(5),
  loc_desc              VARCHAR2(100),
  move_type             VARCHAR2(32),
  satellite_info        VARCHAR2(32),
  is_trans_locarea_adpt CHAR(1),
  sup_trans_loc_id      INTEGER,
  zone_type             VARCHAR2(16),
  priv                  NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SF_WAREH_LOCKED_LST
prompt ==================================
prompt
create table SF_WAREH_LOCKED_LST
(
  id                 INTEGER not null,
  bf_org_id          INTEGER,
  prod_id            INTEGER,
  locked_qty         NUMBER(15,6),
  locked_type        VARCHAR2(16),
  last_modified_user VARCHAR2(32),
  last_modified_date TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 6M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table SF_WAREH_LOCKED_LST
  is 'THE WAREHOUSE LOCKED LIST FOR GOODS';
comment on column SF_WAREH_LOCKED_LST.id
  is 'ID';
comment on column SF_WAREH_LOCKED_LST.bf_org_id
  is 'WAREHOUSE''S ID ';
comment on column SF_WAREH_LOCKED_LST.prod_id
  is 'GOODS''ID';
comment on column SF_WAREH_LOCKED_LST.locked_qty
  is 'THE LOCKED QUANTITY FOR THE WAREHOUSE';
comment on column SF_WAREH_LOCKED_LST.locked_type
  is 'THE LOCKED TYPE FOR THE WAREHOUSE';
comment on column SF_WAREH_LOCKED_LST.last_modified_user
  is 'LAST MODIFIED USER';
comment on column SF_WAREH_LOCKED_LST.last_modified_date
  is 'LAST MODIFIED DATE';
create unique index INDX_WAREH_LOCKED_LST on SF_WAREH_LOCKED_LST (BF_ORG_ID, PROD_ID, LOCKED_TYPE)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 3264K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SF_WAREH_LOCKED_LST
  add constraint PK_SF_WAREH_LOCKED_LST primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 2112K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SF_WAREH_PROD
prompt ============================
prompt
create table SF_WAREH_PROD
(
  id                     INTEGER not null,
  bf_org_id              INTEGER,
  bf_product_id          INTEGER not null,
  stk_on_hand            NUMBER(18,6),
  qty_on_order           NUMBER(18,6) not null,
  qty_in_transit         NUMBER(18,6) not null,
  qty_committed          NUMBER(18,6) not null,
  qty_in_doubt           NUMBER(18,6) not null,
  stk_published          NUMBER(18,6) not null,
  min_stk                NUMBER(18,6),
  max_stk                NUMBER(18,6),
  alert_min_stk          NUMBER(18,6),
  alert_max_stk          NUMBER(18,6),
  min_ad_stk             NUMBER(18,6),
  max_ad_stk             NUMBER(18,6),
  sf_warehouse_loc_id    INTEGER,
  std_loc_cap            NUMBER(5),
  stk_just_time          NUMBER(18,6),
  qty_cur_comm           NUMBER(18,6),
  qty_fuc_comm           NUMBER(18,6),
  qty_type               VARCHAR2(4),
  last_modified_date     TIMESTAMP(6),
  qty_on_lock            NUMBER(18,6),
  in_rcv_stk             NUMBER(18,6),
  cur_cost               NUMBER(20,6),
  qty_in_transit_ag      NUMBER(18,6),
  locked_qty             NUMBER(15,6),
  reserved_committed_qty NUMBER(15,6),
  lock_stockin           NUMBER(15,6),
  reserved_qty           NUMBER(15,6),
  stockin_free           NUMBER(15,6),
  b2b_locked_qty         NUMBER(15,6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 4096M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table SF_WAREH_PROD
  is 'Warehouse Product';
comment on column SF_WAREH_PROD.bf_product_id
  is 'Product ID';
comment on column SF_WAREH_PROD.stk_on_hand
  is 'Stock On Hand';
comment on column SF_WAREH_PROD.qty_on_order
  is 'Quantity On Order';
comment on column SF_WAREH_PROD.qty_in_transit
  is 'Quantity In Transit';
comment on column SF_WAREH_PROD.qty_committed
  is 'Quantity Committed';
comment on column SF_WAREH_PROD.qty_in_doubt
  is 'Quantity In Doubt';
comment on column SF_WAREH_PROD.stk_published
  is 'Stock Published';
comment on column SF_WAREH_PROD.min_stk
  is 'Minimum Stock';
comment on column SF_WAREH_PROD.max_stk
  is 'Maximum Stock';
comment on column SF_WAREH_PROD.alert_min_stk
  is 'Alert Minimum Stock';
comment on column SF_WAREH_PROD.alert_max_stk
  is 'Alert Maximum Stock';
comment on column SF_WAREH_PROD.min_ad_stk
  is 'Minimum Admeasure Stock';
comment on column SF_WAREH_PROD.max_ad_stk
  is 'Maximun Admeasure Stock';
comment on column SF_WAREH_PROD.sf_warehouse_loc_id
  is 'Default Location ID';
comment on column SF_WAREH_PROD.std_loc_cap
  is 'Capacity of Stardard Location';
comment on column SF_WAREH_PROD.qty_cur_comm
  is 'Quantity Current Committed';
comment on column SF_WAREH_PROD.locked_qty
  is '锁定库存';
comment on column SF_WAREH_PROD.reserved_committed_qty
  is '预留量已分配量';
comment on column SF_WAREH_PROD.lock_stockin
  is '入库锁定量';
comment on column SF_WAREH_PROD.reserved_qty
  is '预留量';
comment on column SF_WAREH_PROD.stockin_free
  is '入库锁定自由量';
create index IDX_SF_WAREH_PROD_ORG_ID on SF_WAREH_PROD (BF_ORG_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1338624K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index IDX_SF_WAREH_PROD_ORG_PROD_ID on SF_WAREH_PROD (BF_ORG_ID, BF_PRODUCT_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1727808K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_SF_WAREH_PROD_PROD_ID on SF_WAREH_PROD (BF_PRODUCT_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1413056K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SF_WAREH_PROD
  add constraint PK_SF_WAREH_PROD primary key (ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1358784K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table SF_WAREH_PROD
  add constraint FK_SF_WAREH_REF_BF_ORG foreign key (BF_ORG_ID)
  references BF_ORG (ID);

prompt
prompt Creating table SHOP
prompt ===================
prompt
create table SHOP
(
  shop_id         VARCHAR2(32) not null,
  shop_type       CHAR(2) not null,
  man_id          VARCHAR2(32),
  open_date       DATE,
  close_date      DATE,
  acreage         NUMBER(8,2),
  settle_date     DATE,
  rent_rate       NUMBER(7,4),
  join_flag       CHAR(1),
  account_group   VARCHAR2(4),
  company_code    VARCHAR2(3),
  profit_center   VARCHAR2(10),
  shop_sale_cls   VARCHAR2(4),
  sms_market_code VARCHAR2(16),
  cur_stock_type  VARCHAR2(2),
  consign_type    CHAR(1),
  consign_warehid VARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table STK_DTL
prompt ======================
prompt
create table STK_DTL
(
  wareh_id        VARCHAR2(32) not null,
  loc_id          VARCHAR2(12) not null,
  prod_id         CHAR(11) not null,
  stk_on_hand     NUMBER(15,6) not null,
  alloc_qty       NUMBER(15,6) not null,
  expd_qty        NUMBER(15,6) not null,
  stk_change_date TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ST_ACTIVITY_WAREH
prompt ================================
prompt
create table ST_ACTIVITY_WAREH
(
  wareh_id    VARCHAR2(32) not null,
  is_shop     CHAR(1) not null,
  data_source VARCHAR2(10),
  update_by   VARCHAR2(30),
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ST_ACTIVITY_WAREH
  is '需要库存同步的仓店信息';
comment on column ST_ACTIVITY_WAREH.wareh_id
  is '仓店ID';
comment on column ST_ACTIVITY_WAREH.is_shop
  is '是否为门店0否1是';
comment on column ST_ACTIVITY_WAREH.data_source
  is '店仓数据存放源（NERP:新ERP,OERP：老ERP，VERP：门户）';
comment on column ST_ACTIVITY_WAREH.update_by
  is '更新人';
comment on column ST_ACTIVITY_WAREH.update_time
  is '更新时间';
create unique index W_I_D on ST_ACTIVITY_WAREH (WAREH_ID, IS_SHOP, DATA_SOURCE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ST_ACTIVITY_WAREH
  add constraint PK_WAREH primary key (WAREH_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_ACTIVITY_STOCK
prompt =================================
prompt
create table TMP_ACTIVITY_STOCK
(
  id           INTEGER not null,
  channel_code VARCHAR2(30),
  prod_id      VARCHAR2(11),
  update_time  TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_ACTIVITY_STOCK
  is '活动渠道商品是否只推独占量配置变化临时表';
comment on column TMP_ACTIVITY_STOCK.id
  is '非业务主键';
comment on column TMP_ACTIVITY_STOCK.channel_code
  is '渠道ID';
comment on column TMP_ACTIVITY_STOCK.prod_id
  is '商品ID';
comment on column TMP_ACTIVITY_STOCK.update_time
  is '更新时间';
alter table TMP_ACTIVITY_STOCK
  add constraint SYS_22 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_CHANNEL_CELL_MIN
prompt ===================================
prompt
create table TMP_CHANNEL_CELL_MIN
(
  id               INTEGER not null,
  channel_code     VARCHAR2(30),
  prod_id          VARCHAR2(11),
  channel_cell_min INTEGER,
  update_time      TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_CHANNEL_CELL_MIN
  is '渠道单元最小值变化临时表';
comment on column TMP_CHANNEL_CELL_MIN.id
  is '非业务主键';
comment on column TMP_CHANNEL_CELL_MIN.channel_code
  is '渠道ID';
comment on column TMP_CHANNEL_CELL_MIN.prod_id
  is '商品码';
comment on column TMP_CHANNEL_CELL_MIN.channel_cell_min
  is '渠道单元最小';
comment on column TMP_CHANNEL_CELL_MIN.update_time
  is '更新时间';
alter table TMP_CHANNEL_CELL_MIN
  add constraint SYS_0 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_CHANNEL_MINMAX
prompt =================================
prompt
create table TMP_CHANNEL_MINMAX
(
  id           INTEGER not null,
  channel_code VARCHAR2(30),
  update_time  TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_CHANNEL_MINMAX
  is '渠道最大-最小值变化临时表';
comment on column TMP_CHANNEL_MINMAX.id
  is '非业务主键';
comment on column TMP_CHANNEL_MINMAX.channel_code
  is '渠道ID';
comment on column TMP_CHANNEL_MINMAX.update_time
  is '更新时间';
alter table TMP_CHANNEL_MINMAX
  add constraint SYS_101 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_CHANNEL_SCOPE
prompt ================================
prompt
create table TMP_CHANNEL_SCOPE
(
  id           INTEGER not null,
  channel_code VARCHAR2(30) not null,
  wareh_id     VARCHAR2(30) not null,
  scope_change CHAR(1) default 0,
  wareh_state  CHAR(1) default 0,
  update_time  TIMESTAMP(6) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_CHANNEL_SCOPE
  is '渠道可用仓/店明细开关变化临时表';
comment on column TMP_CHANNEL_SCOPE.id
  is '非业务主键';
comment on column TMP_CHANNEL_SCOPE.channel_code
  is ' 渠道ID';
comment on column TMP_CHANNEL_SCOPE.wareh_id
  is '仓集合';
comment on column TMP_CHANNEL_SCOPE.scope_change
  is ' 配发范围是否变化';
comment on column TMP_CHANNEL_SCOPE.wareh_state
  is '仓/店开关状态0否1是';
comment on column TMP_CHANNEL_SCOPE.update_time
  is ' 更新时间';
alter table TMP_CHANNEL_SCOPE
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_DAME_STOCK
prompt =============================
prompt
create table TMP_DAME_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  prod_id     VARCHAR2(11),
  dame_stock  INTEGER,
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_DAME_STOCK
  is ' 污损值变化临时表';
comment on column TMP_DAME_STOCK.id
  is '非业务主键';
comment on column TMP_DAME_STOCK.wareh_id
  is '仓ID';
comment on column TMP_DAME_STOCK.prod_id
  is '商品ID';
comment on column TMP_DAME_STOCK.dame_stock
  is '污损值库存';
comment on column TMP_DAME_STOCK.update_time
  is '更新时间';
alter table TMP_DAME_STOCK
  add constraint SYS_66 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_FREE_STOCK
prompt =============================
prompt
create table TMP_FREE_STOCK
(
  id              INTEGER not null,
  wareh_id        VARCHAR2(30),
  prod_id         VARCHAR2(11),
  stk_on_hand     INTEGER,
  qty_committed   INTEGER,
  free_stock      INTEGER,
  update_time     TIMESTAMP(6),
  data_source     VARCHAR2(10),
  is_free_changed CHAR(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table TMP_FREE_STOCK
  is '（自由量临时表）';
comment on column TMP_FREE_STOCK.id
  is '非业务主键';
comment on column TMP_FREE_STOCK.wareh_id
  is '仓ID （新ERP为非业务ID）';
comment on column TMP_FREE_STOCK.prod_id
  is '商品ID （新ERP为非业务ID）';
comment on column TMP_FREE_STOCK.stk_on_hand
  is '实际量';
comment on column TMP_FREE_STOCK.qty_committed
  is '已分配量';
comment on column TMP_FREE_STOCK.free_stock
  is '自由量';
comment on column TMP_FREE_STOCK.update_time
  is '更新时间';
comment on column TMP_FREE_STOCK.data_source
  is '数据来源 NERP 新ERP OERP老ERP';
comment on column TMP_FREE_STOCK.is_free_changed
  is '自由量是否变化';
alter table TMP_FREE_STOCK
  add constraint KEY_ID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_LOCKED_STOCK
prompt ===============================
prompt
create table TMP_LOCKED_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  prod_id     VARCHAR2(11),
  update_time TIMESTAMP(6),
  data_source VARCHAR2(10) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_LOCKED_STOCK
  is '（锁定量临时表）';
comment on column TMP_LOCKED_STOCK.id
  is '非业务ID';
comment on column TMP_LOCKED_STOCK.wareh_id
  is '仓ID （新ERP时为非业务ID）';
comment on column TMP_LOCKED_STOCK.prod_id
  is '商品ID  （新ERP时为非业务ID）';
comment on column TMP_LOCKED_STOCK.update_time
  is '更新时间';
comment on column TMP_LOCKED_STOCK.data_source
  is '新老ERP （NERP  OERP）';
alter table TMP_LOCKED_STOCK
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_REMAILED_STOCK
prompt =================================
prompt
create table TMP_REMAILED_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  remail_date TIMESTAMP(6),
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_REMAILED_STOCK
  is ' 门店日结临时表';
comment on column TMP_REMAILED_STOCK.id
  is '非业务主键';
comment on column TMP_REMAILED_STOCK.wareh_id
  is '仓|门店ID';
comment on column TMP_REMAILED_STOCK.remail_date
  is '日结时间';
comment on column TMP_REMAILED_STOCK.update_time
  is '更新时间';
alter table TMP_REMAILED_STOCK
  add constraint SYS_55 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_REMAIL_STOCK
prompt ===============================
prompt
create table TMP_REMAIL_STOCK
(
  id           INTEGER not null,
  wareh_id     VARCHAR2(30),
  prod_id      VARCHAR2(11),
  remail_stock INTEGER,
  update_time  TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_REMAIL_STOCK
  is '门店未日结变化临时表';
comment on column TMP_REMAIL_STOCK.id
  is '非业务主键';
comment on column TMP_REMAIL_STOCK.wareh_id
  is '仓ID';
comment on column TMP_REMAIL_STOCK.prod_id
  is '商品ID';
comment on column TMP_REMAIL_STOCK.remail_stock
  is '未日结库存';
comment on column TMP_REMAIL_STOCK.update_time
  is '更新时间';
alter table TMP_REMAIL_STOCK
  add constraint SYS_00 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_RESERVED_STOCK
prompt =================================
prompt
create table TMP_RESERVED_STOCK
(
  id           INTEGER not null,
  wareh_id     VARCHAR2(30),
  prod_id      VARCHAR2(11),
  channel_code VARCHAR2(30),
  update_time  TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_RESERVED_STOCK
  is '(预留独占量临时表)';
comment on column TMP_RESERVED_STOCK.id
  is '非业务主键';
comment on column TMP_RESERVED_STOCK.wareh_id
  is '仓ID';
comment on column TMP_RESERVED_STOCK.prod_id
  is '商品ID';
comment on column TMP_RESERVED_STOCK.channel_code
  is '渠道号';
comment on column TMP_RESERVED_STOCK.update_time
  is '更新时间';
alter table TMP_RESERVED_STOCK
  add constraint PRIMARY_KEY primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_SAFE_TYPE_STOCK
prompt ==================================
prompt
create table TMP_SAFE_TYPE_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  safe_type   VARCHAR2(50),
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_SAFE_TYPE_STOCK
  is '   仓安全库存类型变化临时表';
comment on column TMP_SAFE_TYPE_STOCK.id
  is '非业务主键';
comment on column TMP_SAFE_TYPE_STOCK.wareh_id
  is '仓ID';
comment on column TMP_SAFE_TYPE_STOCK.safe_type
  is '仓安全库存类型(wp,ws,no)';
comment on column TMP_SAFE_TYPE_STOCK.update_time
  is '更新时间';
alter table TMP_SAFE_TYPE_STOCK
  add constraint SYS_100 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_SHOP_SAFE_STOCK
prompt ==================================
prompt
create table TMP_SHOP_SAFE_STOCK
(
  id              INTEGER not null,
  wareh_id        VARCHAR2(30),
  prod_id         VARCHAR2(11),
  shop_safe_stock INTEGER,
  update_time     TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_SHOP_SAFE_STOCK
  is '门店安全库存变化临时表';
comment on column TMP_SHOP_SAFE_STOCK.id
  is '非业务主键';
comment on column TMP_SHOP_SAFE_STOCK.wareh_id
  is '门店ID';
comment on column TMP_SHOP_SAFE_STOCK.prod_id
  is '商品ID';
comment on column TMP_SHOP_SAFE_STOCK.shop_safe_stock
  is '门店安全库存';
comment on column TMP_SHOP_SAFE_STOCK.update_time
  is '更新时间';
alter table TMP_SHOP_SAFE_STOCK
  add constraint SYS_11 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_TP_STOCK
prompt ===========================
prompt
create table TMP_TP_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  prod_id     VARCHAR2(11),
  tp_stock    INTEGER,
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_TP_STOCK
  is '第三方自由量';
comment on column TMP_TP_STOCK.id
  is '非业务主键';
comment on column TMP_TP_STOCK.wareh_id
  is '仓ID';
comment on column TMP_TP_STOCK.prod_id
  is '商品ID';
comment on column TMP_TP_STOCK.tp_stock
  is '第三方自由量';
comment on column TMP_TP_STOCK.update_time
  is '更新时间';
alter table TMP_TP_STOCK
  add constraint SYS_00000 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_WMS_PROPERTY
prompt ===============================
prompt
create table TMP_WMS_PROPERTY
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  used_ma     CHAR(1),
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_WMS_PROPERTY
  is ' 仓库USED_MA属性变化临时表';
comment on column TMP_WMS_PROPERTY.id
  is '非业务主键';
comment on column TMP_WMS_PROPERTY.wareh_id
  is '仓ID';
comment on column TMP_WMS_PROPERTY.used_ma
  is '是否启动WMS             ';
comment on column TMP_WMS_PROPERTY.update_time
  is '更新时间';
alter table TMP_WMS_PROPERTY
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_WP_STOCK
prompt ===========================
prompt
create table TMP_WP_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  prod_id     VARCHAR2(11),
  wp_stock    INTEGER,
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_WP_STOCK
  is ' WP安全库存变化临时表';
comment on column TMP_WP_STOCK.id
  is '非业务主键';
comment on column TMP_WP_STOCK.wareh_id
  is '仓ID';
comment on column TMP_WP_STOCK.prod_id
  is '商品ID';
comment on column TMP_WP_STOCK.wp_stock
  is 'wp安全库存';
comment on column TMP_WP_STOCK.update_time
  is '更新时间';
alter table TMP_WP_STOCK
  add constraint SYS_88 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TMP_WS_STOCK
prompt ===========================
prompt
create table TMP_WS_STOCK
(
  id          INTEGER not null,
  wareh_id    VARCHAR2(30),
  ws_stock    INTEGER,
  update_time TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table TMP_WS_STOCK
  is '  WS安全库存变化临时表';
comment on column TMP_WS_STOCK.id
  is '非业务主键';
comment on column TMP_WS_STOCK.wareh_id
  is '仓ID';
comment on column TMP_WS_STOCK.ws_stock
  is 'ws安全库存';
comment on column TMP_WS_STOCK.update_time
  is '更新时间';
alter table TMP_WS_STOCK
  add constraint SYS_99 primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table UD_CHANNLE_STOCK_SCOPE
prompt =====================================
prompt
create table UD_CHANNLE_STOCK_SCOPE
(
  id                 INTEGER not null,
  channle_sorce      VARCHAR2(32) not null,
  remark             VARCHAR2(250),
  create_user        VARCHAR2(32),
  create_date        TIMESTAMP(6),
  last_modified_user VARCHAR2(32),
  last_modified_date TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table UD_CHANNLE_STOCK_SCOPE
  is '渠道库存配发范围设置';
comment on column UD_CHANNLE_STOCK_SCOPE.channle_sorce
  is '渠道来源';
comment on column UD_CHANNLE_STOCK_SCOPE.remark
  is '备注';
alter table UD_CHANNLE_STOCK_SCOPE
  add constraint PK_UD_CHANNLE_STOCK_SCOPE primary key (ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table UD_CHANNLE_STOCK_SCOPE_DTL
prompt =========================================
prompt
create table UD_CHANNLE_STOCK_SCOPE_DTL
(
  id                 INTEGER not null,
  ud_cw_id           INTEGER not null,
  ud_locked_type     VARCHAR2(32) not null,
  status             VARCHAR2(2),
  remark             VARCHAR2(250),
  last_modified_user VARCHAR2(32),
  last_modified_date TIMESTAMP(6),
  forced_locked_type VARCHAR2(32),
  seq_num            NUMBER(5),
  ismonopolize       CHAR(1),
  is_sync_os         CHAR(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table UD_CHANNLE_STOCK_SCOPE_DTL
  is '渠道库存配发范围设置 明细';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.ud_locked_type
  is '锁定类型';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.status
  is '状态';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.remark
  is '备注';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.forced_locked_type
  is '属性';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.seq_num
  is '顺序';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.ismonopolize
  is '是否独占';
comment on column UD_CHANNLE_STOCK_SCOPE_DTL.is_sync_os
  is '是否同步OS';
alter table UD_CHANNLE_STOCK_SCOPE_DTL
  add constraint PK_UD_CHANNLE_STOCK_SCOPE_DTL primary key (ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table UD_OVERALL_PARAMELIST
prompt ====================================
prompt
create table UD_OVERALL_PARAMELIST
(
  id                 INTEGER not null,
  code               VARCHAR2(40) not null,
  para_type          VARCHAR2(100),
  status             VARCHAR2(2),
  para_value         VARCHAR2(500),
  create_user        VARCHAR2(32),
  create_date        TIMESTAMP(6),
  last_modified_user VARCHAR2(32),
  last_modified_date TIMESTAMP(6),
  description        VARCHAR2(300),
  code_type          VARCHAR2(12)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table UD_WAREH_PARAM
prompt =============================
prompt
create table UD_WAREH_PARAM
(
  id                   INTEGER not null,
  bf_org_id            INTEGER,
  org_type             VARCHAR2(32),
  virtual_warehouse_id INTEGER not null,
  b2c_starting_qty     NUMBER(18,6),
  b2c_dist_peak_value  NUMBER(18,6),
  b2b_starting_qty     NUMBER(18,6),
  b2b_dist_peak_value  NUMBER(18,6),
  online_safeqty_type  VARCHAR2(32),
  offline_safeqty_type VARCHAR2(32),
  flag                 CHAR(1),
  up_flag              CHAR(1),
  ud_online            CHAR(1),
  ud_offline           CHAR(1),
  shipping_id          INTEGER,
  hand_create_doc      CHAR(1),
  min_num              INTEGER,
  prod_source          VARCHAR2(20),
  safety_stock         NUMBER(18,6),
  is_tfo_dist_wareh    CHAR(1),
  used_ma              CHAR(1),
  canad_zones          VARCHAR2(32),
  is_stk_sync2os       CHAR(1),
  is_double_locked     CHAR(1),
  release_order        INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table UD_WAREH_PARAM
  is 'SOA_仓库属性设置表';
comment on column UD_WAREH_PARAM.id
  is '内码';
comment on column UD_WAREH_PARAM.bf_org_id
  is '仓库ID';
comment on column UD_WAREH_PARAM.org_type
  is '仓库类型';
comment on column UD_WAREH_PARAM.virtual_warehouse_id
  is '虚拟仓ID';
comment on column UD_WAREH_PARAM.b2c_starting_qty
  is 'B2C起配量';
comment on column UD_WAREH_PARAM.b2c_dist_peak_value
  is 'B2C仓库配发峰值';
comment on column UD_WAREH_PARAM.b2b_starting_qty
  is 'B2B起配量';
comment on column UD_WAREH_PARAM.b2b_dist_peak_value
  is 'B2B仓库配发峰值';
comment on column UD_WAREH_PARAM.online_safeqty_type
  is '线上安全库存类型';
comment on column UD_WAREH_PARAM.offline_safeqty_type
  is '线下安全库存类型';
comment on column UD_WAREH_PARAM.flag
  is '是否有效';
comment on column UD_WAREH_PARAM.up_flag
  is '是否上传';
comment on column UD_WAREH_PARAM.ud_online
  is '参与线上订单配发';
comment on column UD_WAREH_PARAM.ud_offline
  is '参与线下订单配发';
comment on column UD_WAREH_PARAM.shipping_id
  is '默认承运商';
comment on column UD_WAREH_PARAM.hand_create_doc
  is '手工创建跨仓单据';
comment on column UD_WAREH_PARAM.min_num
  is '调拨单最小生成个数';
comment on column UD_WAREH_PARAM.prod_source
  is '库存来源';
comment on column UD_WAREH_PARAM.safety_stock
  is '仓库全局安全库存';
comment on column UD_WAREH_PARAM.is_tfo_dist_wareh
  is '是否B2B统一配货';
comment on column UD_WAREH_PARAM.used_ma
  is '启用MAWMS';
comment on column UD_WAREH_PARAM.canad_zones
  is 'RDC仓库能参与分配的分配货区';
comment on column UD_WAREH_PARAM.is_stk_sync2os
  is '是否同步库存到OS';
comment on column UD_WAREH_PARAM.is_double_locked
  is '双向锁定库存（1：是， 0或者空：否）';
comment on column UD_WAREH_PARAM.release_order
  is '释放顺序';
create index IDX2_UD_WAREH_PARAM_CODE on UD_WAREH_PARAM (BF_ORG_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_UD_WAREH_PARAM_CODE on UD_WAREH_PARAM (BF_ORG_ID, VIRTUAL_WAREHOUSE_ID, SHIPPING_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table UD_WAREH_PARAM
  add constraint PK_UD_WAREH_PARAM primary key (ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table UR_UNIT_RESERVED_RESULT
prompt ======================================
prompt
create table UR_UNIT_RESERVED_RESULT
(
  id                     INTEGER not null,
  unit_id                VARCHAR2(32),
  prod_id                VARCHAR2(32),
  wareh_id               VARCHAR2(32),
  reserved_qty           NUMBER(15,6) default 0,
  reserved_type          VARCHAR2(10),
  allocated_qty          NUMBER(15,6) default 0,
  locked_qty             NUMBER(15,6) default 0,
  reserved_allocated_qty NUMBER(15,6) default 0,
  last_modified_date     TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 136M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table UR_UNIT_RESERVED_RESULT
  is '组织预留结果';
comment on column UR_UNIT_RESERVED_RESULT.id
  is '内码';
comment on column UR_UNIT_RESERVED_RESULT.unit_id
  is '组织编码';
comment on column UR_UNIT_RESERVED_RESULT.prod_id
  is '商品编码';
comment on column UR_UNIT_RESERVED_RESULT.wareh_id
  is '仓库编码';
comment on column UR_UNIT_RESERVED_RESULT.reserved_qty
  is '预留量';
comment on column UR_UNIT_RESERVED_RESULT.reserved_type
  is '预留类型';
comment on column UR_UNIT_RESERVED_RESULT.allocated_qty
  is '已分配锁定量';
comment on column UR_UNIT_RESERVED_RESULT.locked_qty
  is '预分配锁定量';
comment on column UR_UNIT_RESERVED_RESULT.reserved_allocated_qty
  is '预留数据源表中到期的货期已分配量总和';
comment on column UR_UNIT_RESERVED_RESULT.last_modified_date
  is '最后修改时间';
create index IDX_UR_UNIT_RESERVED_RESULT_1 on UR_UNIT_RESERVED_RESULT (PROD_ID, WAREH_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 75136K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index INDEX_UNIT_RESERVED_RESULT on UR_UNIT_RESERVED_RESULT (UNIT_ID, PROD_ID, WAREH_ID, RESERVED_TYPE)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 100608K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table UR_UNIT_RESERVED_RESULT
  add constraint PK_UR_UNIT_RESERVED_RESULT primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 36928K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table WAREH_LOCKED_LST
prompt ===============================
prompt
create table WAREH_LOCKED_LST
(
  wareh_id        VARCHAR2(32) not null,
  prod_id         CHAR(11) not null,
  locked_type     VARCHAR2(2) not null,
  locked_qty      NUMBER(15,6) default 0,
  stk_change_date TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 408M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column WAREH_LOCKED_LST.wareh_id
  is 'Warehouse ID';
comment on column WAREH_LOCKED_LST.prod_id
  is 'Product ID';
create index IDX_STK_DTL_3 on WAREH_LOCKED_LST (WAREH_ID, PROD_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 320640K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_STK_DTL_4 on WAREH_LOCKED_LST (WAREH_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 200768K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table WAREH_LOCKED_LST
  add constraint PK_WAREH_LOCKED_LST primary key (WAREH_ID, PROD_ID, LOCKED_TYPE)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 340224K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table WAREH_PROD
prompt =========================
prompt
create table WAREH_PROD
(
  wareh_id        VARCHAR2(32) not null,
  prod_id         CHAR(11) not null,
  stk_on_hand     NUMBER(15,6) not null,
  qty_on_order    NUMBER(15,6) not null,
  qty_in_transit  NUMBER(15,6) not null,
  qty_committed   NUMBER(15,6) not null,
  qty_in_doubt    NUMBER(15,6) not null,
  stk_published   NUMBER(15,6) not null,
  min_stk         NUMBER(15,6),
  max_stk         NUMBER(15,6),
  alert_min_stk   NUMBER(15,6),
  alert_max_stk   NUMBER(15,6),
  min_ad_stk      NUMBER(15,6),
  max_ad_stk      NUMBER(15,6),
  dflt_zone_id    VARCHAR2(12),
  std_loc_cap     NUMBER(5),
  dflt_loc_id     VARCHAR2(12),
  stk_just_time   NUMBER(15,6),
  qty_fuc_comm    NUMBER(15,6),
  qty_cur_comm    NUMBER(15,6),
  stk_change_date TIMESTAMP(6),
  bgr_stk         NUMBER(15,6),
  in_rcv_stk      NUMBER(15,6),
  locked_qty      NUMBER(15,6),
  reserved_qty    NUMBER(15,6),
  lock_stockin    NUMBER(15,6),
  stockin_free    NUMBER(15,6)
)
partition by hash (WAREH_ID)
(
  partition PARTITION_1
    tablespace USERS,
  partition PARTITION_2
    tablespace USERS,
  partition PARTITION_3
    tablespace USERS,
  partition PARTITION_4
    tablespace USERS,
  partition PARTITION_5
    tablespace USERS,
  partition PARTITION_6
    tablespace USERS,
  partition PARTITION_7
    tablespace USERS,
  partition PARTITION_8
    tablespace USERS,
  partition PARTITION_9
    tablespace USERS,
  partition PARTITION_10
    tablespace USERS,
  partition PARTITION_11
    tablespace USERS,
  partition PARTITION_12
    tablespace USERS,
  partition PARTITION_13
    tablespace USERS,
  partition PARTITION_14
    tablespace USERS,
  partition PARTITION_15
    tablespace USERS,
  partition PARTITION_16
    tablespace USERS
);
comment on table WAREH_PROD
  is 'Warehouse Product';
comment on column WAREH_PROD.wareh_id
  is 'Warehouse ID';
comment on column WAREH_PROD.prod_id
  is 'Product ID';
comment on column WAREH_PROD.stk_on_hand
  is 'Stock On Hand';
comment on column WAREH_PROD.qty_on_order
  is 'Quantity On Order';
comment on column WAREH_PROD.qty_in_transit
  is 'Quantity In Transit';
comment on column WAREH_PROD.qty_committed
  is 'Quantity Committed';
comment on column WAREH_PROD.qty_in_doubt
  is 'Quantity In Doubt';
comment on column WAREH_PROD.stk_published
  is 'Stock Published';
comment on column WAREH_PROD.min_stk
  is 'Minimum Stock';
comment on column WAREH_PROD.max_stk
  is 'Maximum Stock';
comment on column WAREH_PROD.alert_min_stk
  is 'Alert Minimum Stock';
comment on column WAREH_PROD.alert_max_stk
  is 'Alert Maximum Stock';
comment on column WAREH_PROD.min_ad_stk
  is 'Minimum Admeasure Stock';
comment on column WAREH_PROD.max_ad_stk
  is 'Maximun Admeasure Stock';
comment on column WAREH_PROD.dflt_zone_id
  is 'Default Zone ID';
comment on column WAREH_PROD.std_loc_cap
  is 'Capacity of Stardard Location';
comment on column WAREH_PROD.qty_cur_comm
  is 'Quantity Current Committed';
create index IDX_WAREH_PROD_1 on WAREH_PROD (PROD_ID)
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 3364928K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table WAREH_PROD
  add constraint PK_WAREH_PROD primary key (WAREH_ID, PROD_ID)
  using index 
  tablespace INDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 4096M
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence TMP_ACTIVITY_STOCK_SEQ
prompt ========================================
prompt
create sequence TMP_ACTIVITY_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_CHANNEL_CELL_MIN_SEQ
prompt ==========================================
prompt
create sequence TMP_CHANNEL_CELL_MIN_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_CHANNEL_MINMAX_SEQ
prompt ========================================
prompt
create sequence TMP_CHANNEL_MINMAX_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 13
increment by 1
nocache;

prompt
prompt Creating sequence TMP_CHANNEL_SCOPE_SEQ
prompt =======================================
prompt
create sequence TMP_CHANNEL_SCOPE_SEQ
minvalue 1
maxvalue 999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_DAME_STOCK_SEQ
prompt ====================================
prompt
create sequence TMP_DAME_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_FREE_STOCK_SEQ
prompt ====================================
prompt
create sequence TMP_FREE_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_LOCKED_STOCK_SEQ
prompt ======================================
prompt
create sequence TMP_LOCKED_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_REMAILED_STOCK_SEQ
prompt ========================================
prompt
create sequence TMP_REMAILED_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_REMAIL_STOCK_SEQ
prompt ======================================
prompt
create sequence TMP_REMAIL_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_RESERVED_STOCK_SEQ
prompt ========================================
prompt
create sequence TMP_RESERVED_STOCK_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_SAFE_TYPE_STOCK_SEQ
prompt =========================================
prompt
create sequence TMP_SAFE_TYPE_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_SHOP_SAFE_STOCK_SEQ
prompt =========================================
prompt
create sequence TMP_SHOP_SAFE_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 16
increment by 1
nocache;

prompt
prompt Creating sequence TMP_TP_STOCK_SEQ
prompt ==================================
prompt
create sequence TMP_TP_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_WMS_PROPERTY_SEQ
prompt ======================================
prompt
create sequence TMP_WMS_PROPERTY_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_WP_STOCK_SEQ
prompt ==================================
prompt
create sequence TMP_WP_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence TMP_WS_STOCK_SEQ
prompt ==================================
prompt
create sequence TMP_WS_STOCK_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating trigger TR_TMP_ACTIVITY_STOCK
prompt ======================================
prompt
create or replace trigger tr_TMP_ACTIVITY_STOCK before insert on TMP_ACTIVITY_STOCK for each row begin select TMP_ACTIVITY_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_CHANNEL_CELL_MIN
prompt ========================================
prompt
create or replace trigger tr_TMP_CHANNEL_CELL_MIN before insert on TMP_CHANNEL_CELL_MIN for each row begin select TMP_CHANNEL_CELL_MIN_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_CHANNEL_MINMAX
prompt ======================================
prompt
create or replace trigger tr_TMP_CHANNEL_MINMAX before insert on TMP_CHANNEL_MINMAX for each row begin select TMP_CHANNEL_MINMAX_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_CHANNEL_SCOPE
prompt =====================================
prompt
create or replace trigger tr_TMP_CHANNEL_SCOPE before insert on TMP_CHANNEL_SCOPE for each row begin select TMP_CHANNEL_SCOPE_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_DAME_STOCK
prompt ==================================
prompt
create or replace trigger tr_TMP_DAME_STOCK before insert on TMP_DAME_STOCK for each row begin select TMP_DAME_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_FREE_STOCK
prompt ==================================
prompt
create or replace trigger tr_TMP_FREE_STOCK before insert on TMP_FREE_STOCK for each row begin select TMP_FREE_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_LOCKED_STOCK
prompt ====================================
prompt
create or replace trigger tr_TMP_LOCKED_STOCK before insert on TMP_LOCKED_STOCK for each row begin select TMP_LOCKED_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_REMAILED_STOCK
prompt ======================================
prompt
create or replace trigger tr_TMP_REMAILED_STOCK before insert on TMP_REMAILED_STOCK for each row begin select TMP_REMAILED_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_REMAIL_STOCK
prompt ====================================
prompt
create or replace trigger tr_TMP_REMAIL_STOCK before insert on TMP_REMAIL_STOCK for each row begin select TMP_REMAIL_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_RESERVED_STOCK
prompt ======================================
prompt
create or replace trigger tr_TMP_RESERVED_STOCK before insert on TMP_RESERVED_STOCK for each row begin select TMP_RESERVED_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_SAFE_TYPE_STOCK
prompt =======================================
prompt
create or replace trigger tr_TMP_SAFE_TYPE_STOCK before insert on TMP_SAFE_TYPE_STOCK for each row begin select TMP_SAFE_TYPE_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_SHOP_SAFE_STOCK
prompt =======================================
prompt
create or replace trigger tr_TMP_SHOP_SAFE_STOCK before insert on TMP_SHOP_SAFE_STOCK for each row begin select TMP_SHOP_SAFE_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_TP_STOCK
prompt ================================
prompt
create or replace trigger tr_TMP_TP_STOCK before insert on TMP_TP_STOCK for each row begin select TMP_TP_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_WMS_PROPERTY
prompt ====================================
prompt
create or replace trigger tr_TMP_WMS_PROPERTY
  before insert on TMP_WMS_PROPERTY
  for each row
begin
  select TMP_WMS_PROPERTY_SEQ.nextval into :new.id from dual;
end;
/

prompt
prompt Creating trigger TR_TMP_WP_STOCK
prompt ================================
prompt
create or replace trigger tr_TMP_WP_STOCK before insert on TMP_WP_STOCK for each row begin select TMP_WP_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_TMP_WS_STOCK
prompt ================================
prompt
create or replace trigger tr_TMP_WS_STOCK before insert on TMP_WS_STOCK for each row begin select TMP_WS_STOCK_SEQ.nextval into :new.id from dual;end;
/

prompt
prompt Creating trigger TR_UT_SF_WAREH_LOCKED_LST
prompt ==========================================
prompt
CREATE OR REPLACE TRIGGER TR_UT_SF_WAREH_LOCKED_LST
  AFTER INSERT OR UPDATE OR DELETE ON SF_WAREH_LOCKED_LST
  FOR EACH ROW
DECLARE
  var_bf_org_id     integer(20);
  var_bf_product_id integer(20);
BEGIN

  var_bf_org_id     := :NEW.BF_ORG_ID;
  var_bf_product_id := :NEW.PROD_ID;

  IF (DELETING) THEN
    var_bf_org_id     := :OLD.BF_ORG_ID;
    var_bf_product_id := :OLD.PROD_ID;
  END IF;

  INSERT INTO TMP_LOCKED_STOCK
  VALUES
    (TMP_LOCKED_STOCK_SEQ.NEXTVAL,
     var_bf_org_id,
     var_bf_product_id,
     SYSDATE,
     'NERP');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('TR_UT_SF_WAREH_LOCKED_LST执行出错！');
END TR_UT_SF_WAREH_LOCKED_LST;
/

prompt
prompt Creating trigger TR_UT_SF_WAREH_PROD
prompt ====================================
prompt
CREATE OR REPLACE TRIGGER TR_UT_SF_WAREH_PROD
  AFTER INSERT OR UPDATE OR DELETE ON SF_WAREH_PROD
  FOR EACH ROW
DECLARE
  var_bf_org_id      integer(20);
  var_bf_product_id  integer(20);
  var_stk_on_hand    number(20, 2);
  var_qty_committed  number(20, 2);
  var_changed_flag   integer(1);
  var_new_free_stock number(20, 2);
  var_old_free_stock number(20, 2);
BEGIN

  var_bf_org_id      := :NEW.bf_org_id;
  var_bf_product_id  := :NEW.bf_product_id;
  var_stk_on_hand    := :NEW.stk_on_hand;
  var_qty_committed  := :NEW.qty_committed;
  var_changed_flag   := 1; --  1 表示有变化  0 表示无变化
  var_new_free_stock := NVL(var_stk_on_hand, 0) - NVL(var_qty_committed, 0) -
                        NVL(:NEW.qty_on_lock, 0) - NVL(:NEW.locked_qty, 0) -
                        NVL(:NEW.b2b_locked_qty, 0);
  var_old_free_stock := NVL(:OLD.stk_on_hand, 0) -
                        NVL(:OLD.qty_committed, 0) -
                        NVL(:OLD.qty_on_lock, 0) - NVL(:OLD.locked_qty, 0) -
                        NVL(:OLD.b2b_locked_qty, 0);
  IF (DELETING) THEN
    var_bf_org_id      := :OLD.bf_org_id;
    var_bf_product_id  := :OLD.bf_product_id;
    var_stk_on_hand    := 0;
    var_qty_committed  := 0;
    var_new_free_stock := 0;
  END IF;

  IF (var_new_free_stock = var_old_free_stock) THEN
    var_changed_flag := 0;
  END IF;

  --dbms_output.put_line('var_new_free_stock:' || var_new_free_stock);
  --dbms_output.put_line('var_old_free_stock:' || var_old_free_stock);
  --dbms_output.put_line('var_changed_flag:' || var_changed_flag);

  INSERT INTO TMP_FREE_STOCK
  VALUES
    (TMP_FREE_STOCK_SEQ.NEXTVAL,
     var_bf_org_id,
     var_bf_product_id,
     var_stk_on_hand,
     var_qty_committed,
     var_new_free_stock,
     SYSDATE,'NERP',var_changed_flag);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('TR_UT_SF_WAREH_PROD执行出错！');
END TR_UT_SF_WAREH_PROD;
/

prompt
prompt Creating trigger TR_UT_UR_UNIT_RESERVED_RESULT
prompt ==============================================
prompt
CREATE OR REPLACE TRIGGER TR_UT_UR_UNIT_RESERVED_RESULT
  AFTER INSERT OR UPDATE OR DELETE ON UR_UNIT_RESERVED_RESULT
  FOR EACH ROW
DECLARE
  var_wareh_id     varchar(30);
  var_prod_id      varchar(30);
  var_channel_code varchar(30);
BEGIN
  var_wareh_id     := :NEW.wareh_id;
  var_prod_id      := :NEW.PROD_ID;
  var_channel_code := :NEW.unit_id;
  IF (DELETING) THEN
    var_wareh_id     := :OLD.wareh_id;
    var_prod_id      := :OLD.PROD_ID;
    var_channel_code := :OLD.unit_id;
  END IF;
  INSERT INTO TMP_RESERVED_STOCK
  VALUES
    (TMP_RESERVED_STOCK_SEQ.NEXTVAL,
     var_wareh_id,
     var_prod_id,
     var_channel_code,
     sysdate);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('TR_UT_UR_UNIT_RESERVED_RESULT执行出错！');
END TR_UT_UR_UNIT_RESERVED_RESULT;
/

prompt
prompt Creating trigger TR_UT_WAREH_LOCKED_LST
prompt =======================================
prompt
CREATE OR REPLACE TRIGGER TR_UT_WAREH_LOCKED_LST
  AFTER INSERT OR UPDATE OR DELETE ON WAREH_LOCKED_LST
  FOR EACH ROW
DECLARE
  var_wareh_id varchar(20);
  var_prod_id  char(11);
BEGIN

  var_wareh_id := :NEW.wareh_id;
  var_prod_id  := :NEW.PROD_ID;

  IF (DELETING) THEN
    var_wareh_id := :OLD.wareh_id;
    var_prod_id  := :OLD.PROD_ID;
  END IF;

  INSERT INTO TMP_LOCKED_STOCK
  VALUES
    (TMP_LOCKED_STOCK_SEQ.NEXTVAL,
     var_wareh_id,
     var_prod_id,
     SYSDATE,
     'OERP');
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('TR_UT_WAREH_LOCKED_LST执行出错！');
END TR_UT_WAREH_LOCKED_LST;
/

prompt
prompt Creating trigger TR_UT_WAREH_PROD
prompt =================================
prompt
CREATE OR REPLACE TRIGGER TR_UT_WAREH_PROD
  AFTER INSERT OR UPDATE OR DELETE ON WAREH_PROD
  FOR EACH ROW
DECLARE
  var_wareh_id       varchar(20);
  var_prod_id        char(11);
  var_stk_on_hand    number(20, 2);
  var_qty_committed  number(20, 2);
  var_changed_flag   integer(1);
  var_new_free_stock number(20, 2);
  var_old_free_stock number(20, 2);
BEGIN

  var_wareh_id       := :NEW.wareh_id;
  var_prod_id        := :NEW.prod_Id;
  var_stk_on_hand    := :NEW.stk_on_hand;
  var_qty_committed  := :NEW.qty_committed;
  var_changed_flag   := 1; --  1 表示有变化  0 表示无变化
  var_new_free_stock := NVL(var_stk_on_hand, 0) - NVL(var_qty_committed, 0) -
                        NVL(:NEW.locked_qty, 0);
  var_old_free_stock := NVL(:OLD.stk_on_hand, 0) -
                        NVL(:OLD.qty_committed, 0) -
                        NVL(:OLD.locked_qty, 0);
  IF (DELETING) THEN
    var_wareh_id       := :OLD.wareh_id;
    var_prod_id        := :OLD.prod_id;
    var_stk_on_hand    := 0;
    var_qty_committed  := 0;
    var_new_free_stock := 0;
  END IF;

  IF (var_new_free_stock = var_old_free_stock) THEN
    var_changed_flag := 0;
  END IF;

  --dbms_output.put_line('var_new_free_stock:' || var_new_free_stock);
  --dbms_output.put_line('var_old_free_stock:' || var_old_free_stock);
  --dbms_output.put_line('var_changed_flag:' || var_changed_flag);

  INSERT INTO TMP_FREE_STOCK
  VALUES
    (TMP_FREE_STOCK_SEQ.NEXTVAL,
     var_wareh_id,
     var_prod_id,
     var_stk_on_hand,
     var_qty_committed,
     var_new_free_stock,
     SYSDATE,'OERP',var_changed_flag);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('TR_UT_WAREH_PROD执行出错！');
END TR_UT_WAREH_PROD;
/


spool off
