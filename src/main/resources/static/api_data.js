define({ "api": [
  {
    "type": "DELETE",
    "url": "/admin/goods/type/item/{id}",
    "title": "删除商品分类",
    "group": "Admin",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>商品分类值主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/goods/type/item/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除商品分类</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "DeleteAdminGoodsTypeItemId"
  },
  {
    "type": "GET",
    "url": "/admin/car/illegal/{start}/{end}",
    "title": "获取违章信息列表",
    "group": "Admin",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/car/illegal/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取违章信息列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    id: 主键,\n    carId: \"车辆Id\",\n    carNum:\"车牌号\",\n    carProvince:\"车辆省份\",\n    userId:\"用户id\",\n    username: \"用户姓名\",\n    totalPrice:\"罚款总数\",\n    totalScore:\"总分数\",\n    number:\"违章编号\",\n    handleFee:\"代缴费用\",\n    canHandle:\"是否可以代缴\"}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminCarIllegalStartEnd"
  },
  {
    "type": "GET",
    "url": "/admin/commodity/{type}/{start}/{end}",
    "title": "获取指定类型商品",
    "group": "Admin",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "byte",
            "optional": false,
            "field": "type",
            "description": "<p>商品类型</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/commodity/1/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取指定类型商品 区分全新汽配,二手汽配...</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容1\",\n    pricePre:\"商品原价1\",\n    priceNow:\"商品现价1\",\n    cdType:\"商品类型1\"},\n {\n    cdId: 2,\n    title: \"商品信息标题2\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容2\",\n    pricePre:\"商品原价2\",\n    priceNow:\"商品现价2\",\n    cdType:\"商品类型2\"},\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminCommodityTypeStartEnd"
  },
  {
    "type": "GET",
    "url": "admin/conv/{type}/{start}/{end}",
    "title": "获取失效/未失效便民信息",
    "group": "Admin",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "type",
            "description": "<p>是否失效</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "admin/conv/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取失效/未失效便民信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ciId: 1,\n    title: \"文章标题\",\n    content: \"文章内容\",\n    userId:\"用户id\",\n    userName:\"用户姓名\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\"},{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminConvTypeStartEnd"
  },
  {
    "type": "GET",
    "url": "/admin/goods/color",
    "title": "获取商品颜色列表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>获取商品颜色列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/goods/color",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    pvId: \"主键\",\n    paramType:\"类型\",\n    paramValue: \"参数值\"\n    },\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminGoodsColor"
  },
  {
    "type": "GET",
    "url": "/admin/goods/condition",
    "title": "获取商品新旧程度列表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>获取商品颜色列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/goods/condition",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    pvId: \"主键\",\n    paramType:\"类型\",\n    paramValue: \"参数值\"\n    },\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminGoodsCondition"
  },
  {
    "type": "GET",
    "url": "/admin/goods/size",
    "title": "获取商品规格列表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>获取商品规格列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/goods/size",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    pvId: \"主键\",\n    paramType:\"类型\",\n    paramValue: \"参数值\"\n    },\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminGoodsSize"
  },
  {
    "type": "GET",
    "url": "/admin/report",
    "title": "用户报表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>精品列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   start:\"分页开始\",\n   end:\"数据长度\",\n   startDate:\"开始日期\",\n   endDate:\"结束日期\",\n   province:\"省\",\n   city:\"市\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    userId: 用户编号,\n    mobile: \"账号\",\n    income:\"收入\",\n    expend: \"支出\",\n    balance:\"余额\",\n    withdraw:\"提现金额\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "GetAdminReport"
  },
  {
    "type": "GET",
    "url": "/common/goods/color",
    "title": "获取商品颜色列表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>获取商品颜色列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/common/goods/color",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    pvId: \"主键\",\n    paramType:\"类型\",\n    paramValue: \"参数值\"\n    },\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Admin",
    "name": "GetCommonGoodsColor"
  },
  {
    "type": "GET",
    "url": "/common/goods/condition",
    "title": "获取商品新旧程度列表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>获取商品颜色列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/common/goods/condition",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    pvId: \"主键\",\n    paramType:\"类型\",\n    paramValue: \"参数值\"\n    },\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Admin",
    "name": "GetCommonGoodsCondition"
  },
  {
    "type": "GET",
    "url": "/common/goods/size",
    "title": "获取商品规格列表",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>获取商品规格列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/common/goods/size",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    pvId: \"主键\",\n    paramType:\"类型\",\n    paramValue: \"参数值\"\n    },\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Admin",
    "name": "GetCommonGoodsSize"
  },
  {
    "type": "GET",
    "url": "/shop/unverify/{start}/{end}",
    "title": "查询未审核商铺信息",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>查询未审核商铺信息</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/shop/unverify/0/10",
          "type": "json"
        },
        {
          "title": "返回样例:",
          "content": "{\n   userId:\"用户Id\",\n   userName:\"代表人姓名\",\n   idNumber:\"身份证号\",\n   mobile:\"手机号\",\n   shopName:\"店铺名称\",\n   shopIntro:\"店铺描述\",\n   shopAddress:\"店铺地址\",\n   idFrontImg:\"身份证正面照\",\n   idRearImg:\"身份证反面照\",\n   logoImg:\"logo图片\",\n   licenseImg:\"营业执照照片\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopVerifyController.java",
    "groupTitle": "Admin",
    "name": "GetShopUnverifyStartEnd"
  },
  {
    "type": "GET",
    "url": "/shop/verify/{start}/{end}",
    "title": "查询已审核商铺信息",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>查询已审核商铺信息</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/shop/verify/0/10",
          "type": "json"
        },
        {
          "title": "返回样例:",
          "content": "{\n   userId:\"用户Id\",\n   userName:\"代表人姓名\",\n   idNumber:\"身份证号\",\n   mobile:\"手机号\",\n   shopName:\"店铺名称\",\n   shopIntro:\"店铺描述\",\n   shopAddress:\"店铺地址\",\n   idFrontImg:\"身份证正面照\",\n   idRearImg:\"身份证反面照\",\n   logoImg:\"logo图片\",\n   licenseImg:\"营业执照照片\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopVerifyController.java",
    "groupTitle": "Admin",
    "name": "GetShopVerifyStartEnd"
  },
  {
    "type": "POST",
    "url": "/admin",
    "title": "增加管理员用户",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>增加管理员用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "AdminInfo",
            "optional": false,
            "field": "adminInfo",
            "description": "<p>管理员用户对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   account:\"账户名\",\n   password:\"密码\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；registered：手机号已被注册;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PostAdmin"
  },
  {
    "type": "POST",
    "url": "/admin/goods/color",
    "title": "增加商品颜色",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>增加商品颜色</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ParamValue",
            "optional": false,
            "field": "paramValue",
            "description": "<p>参数对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   paramValue:\"参数值\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PostAdminGoodsColor"
  },
  {
    "type": "POST",
    "url": "/admin/goods/condition",
    "title": "增加商品新旧程度",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>增加商品规格</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ParamValue",
            "optional": false,
            "field": "paramValue",
            "description": "<p>参数对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   paramValue:\"参数值\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PostAdminGoodsCondition"
  },
  {
    "type": "POST",
    "url": "/admin/goods/size",
    "title": "增加商品规格",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>增加商品规格</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ParamValue",
            "optional": false,
            "field": "paramValue",
            "description": "<p>参数对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   paramValue:\"参数值\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PostAdminGoodsSize"
  },
  {
    "type": "POST",
    "url": "/admin/goods/type/item",
    "title": "增加商品分类",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>增加商品分类</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "GoodsTypeItem",
            "optional": false,
            "field": "goodsTypeItem",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   gtId:\"商品类型Id\",\n   name:\"名称\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；pwd_error：密码错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PostAdminGoodsTypeItem"
  },
  {
    "type": "POST",
    "url": "/admin/login",
    "title": "管理员登录",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>管理员登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "AdminInfo",
            "optional": false,
            "field": "adminInfo",
            "description": "<p>管理员用户对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   password:\"MD5加密后的密码\",\n   account:\"18710889234\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；pwd_error：密码错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PostAdminLogin"
  },
  {
    "type": "PUT",
    "url": "/admin/goods/type/item",
    "title": "修改商品分类",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>修改商品分类</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "GoodsTypeItem",
            "optional": false,
            "field": "goodsTypeItem",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   id:\"本条记录主键\",\n   name:\"名称\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；pwd_error：密码错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Admin",
    "name": "PutAdminGoodsTypeItem"
  },
  {
    "type": "PUT",
    "url": "/shop/verify/{svId}",
    "title": "通过商家审核",
    "group": "Admin",
    "version": "0.0.1",
    "description": "<p>通过商家审核</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "/shop/verify/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopVerifyController.java",
    "groupTitle": "Admin",
    "name": "PutShopVerifySvid"
  },
  {
    "type": "DELETE",
    "url": "/commodity/{cdId}",
    "title": "删除商品信息",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cdId",
            "description": "<p>商品表主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除用户地址信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "DeleteCommodityCdid"
  },
  {
    "type": "DELETE",
    "url": "/commodity/view/empty/{userId}",
    "title": "清空浏览记录",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "commodity/view//empty/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>清空浏览记录</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "DeleteCommodityViewEmptyUserid"
  },
  {
    "type": "DELETE",
    "url": "/commodity/view/multi",
    "title": "删除多条浏览记录",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>删除多条浏览记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "vrId",
            "optional": false,
            "field": "vrId",
            "description": "<p>浏览记录主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "/commodity/view/multi?vrId=1&vrId=2",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "DeleteCommodityViewMulti"
  },
  {
    "type": "DELETE",
    "url": "/commodity/view/{vrId}",
    "title": "删除浏览记录",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "vrId",
            "description": "<p>浏览记录主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "commodity/view/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除浏览记录</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "DeleteCommodityViewVrid"
  },
  {
    "type": "GET",
    "url": "/commodity/comment/list/{cdId}/{start}/{end}",
    "title": "获取个人商品评论",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cdId",
            "description": "<p>商品Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/comment/list/1/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取个人商品评论</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ccId: 评论Id,\n    userId: \"用户Id\",\n    userName:用户名字\n    avatarId: \"头像Id\",\n    comment:\"评论内容\"},\n {\n    ccId: 评论Id,\n    userId: \"用户Id\",\n    userName:用户名字\n    avatarId: \"头像Id\",\n    comment:\"评论内容\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityCommentListCdidStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/detail/{userId}/{cdId}",
    "title": "获取商品详情",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cdId",
            "description": "<p>商品主键</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>商品类型</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/detail/1/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取商品详情</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": " {\"code\":\"success\",\n  \"data\":{\n   title:\"标题是什么\",\n   content:\"内容是什么\",\n   imgId:\"图片base64编码\",\n   province:\"省\",\n   city:\"市\",\n   district:\"区\",\n   pricePre:\"原价\",\n   priceNow:\"现价\",\n   cdType:\"商品类型\",\n   condition:\"新旧程度\",\n   cdCount:\"商品数量\",\n   cdColor:\"商品颜色,多种颜色以逗号分隔,\n   cdSize:\"商品规格,多种规格以逗号分隔\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityDetailUseridCdid"
  },
  {
    "type": "GET",
    "url": "/commodity/list/{type}/{start}/{end}",
    "title": "获取指定类型商品",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "byte",
            "optional": false,
            "field": "type",
            "description": "<p>商品类型</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/list/1/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取指定类型商品 区分全新汽配,二手汽配...</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\",\n    content: \"商品信息内容1\",\n    pricePre:\"商品原价1\",\n    priceNow:\"商品现价1\",\n    condition:\"新旧程度\",\n    cdType:\"商品类型1\",},\n {\n    cdId: 2,\n    title: \"商品信息标题2\",\n    imgId:\"商品图片\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\",\n    content: \"商品信息内容2\",\n    pricePre:\"商品原价2\",\n    condition:\"新旧程度\",\n    priceNow:\"商品现价2\",\n    cdType:\"商品类型2\"},\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityListTypeStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/quality/{start}/{end}",
    "title": "精品列表",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/quality/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>精品列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容1\",\n    pricePre:\"商品原价1\",\n    priceNow:\"商品现价1\",\n    cdType:\"商品类型1\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityQualityStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/quality/{type}/{start}/{end}",
    "title": "指定类型的精品列表",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/quality/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>指定类型的精品列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容1\",\n    pricePre:\"商品原价1\",\n    priceNow:\"商品现价1\",\n    cdType:\"商品类型1\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityQualityTypeStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/record/{userId}/{state}/{start}/{end}",
    "title": "查询上架/下架商品销售记录",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "state",
            "description": "<p>0:下架  1:上架</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/record/1/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>查询上架/下架商品销售记录</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    sellCount:\"卖出数量\",\n    priceNow:\"商品现价1\",\n    cdCount:\"剩余数量\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityRecordUseridStateStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/select",
    "title": "通过条件筛选商品",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>通过条件筛选商品</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "CommodityDto",
            "optional": false,
            "field": "commodityDto",
            "description": "<p>商品查询对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   cdType:商品类型,\n   city:\"城市\",\n   district:\"区域\",\n   cdClass:\"商品分类\",\n   price:\"价格排序 0,正序,1倒序\"\n   priceStart:\"价格开始区间\",\n   priceEnd:\"价格结束区间\",\n   start:\"分页开始索引,必填\",\n   end:\"分页查询长度,必填\",\n   star:\"好评排序,0正序,1倒序\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{和返回商品信息字段相同}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommoditySelect"
  },
  {
    "type": "GET",
    "url": "/commodity/star/{type}/{start}/{end}",
    "title": "指定类型的热门列表",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/star/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>指定类型的热门列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容1\",\n    pricePre:\"商品原价1\",\n    priceNow:\"商品现价1\",\n    cdType:\"商品类型1\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityStarTypeStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/user/{userId}/{start}/{end}",
    "title": "获取指定用户的商品",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>商品类型</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/user/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取指定用户的商品</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cdId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\",\n    content: \"商品信息内容1\",\n    pricePre:\"商品原价1\",\n    priceNow:\"商品现价1\",\n    condition:\"新旧程度\",\n    cdType:\"商品类型1\"},\n {\n    cdId: 2,\n    title: \"商品信息标题2\",\n    imgId:\"商品图片\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\",\n    content: \"商品信息内容2\",\n    pricePre:\"商品原价2\",\n    priceNow:\"商品现价2\",\n    condition:\"新旧程度\",\n    cdType:\"商品类型2\"},\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityUserUseridStartEnd"
  },
  {
    "type": "GET",
    "url": "/commodity/view/{userId}}/{start}/{end}",
    "title": "查询浏览记录",
    "group": "Commodity",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/view/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>查询浏览记录</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    vrId: \"浏览记录主键\",\n    goodsId:商品信息主键,\n    title: \"商品信息标题1\",\n    content: \"商品信息内容1\",\n    imgId:\"图片id\",\n    priceNow:\"价格\",\n    cdType:\"商品类型1\"},\n {\n    vrId: \"浏览记录主键\",\n    goodsId:商品信息主键,\n    title: \"商品信息标题2\",\n    content: \"商品信息内容2\",\n    priceNow:\"价格\",\n    cdType:\"商品类型2\"}\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "GetCommodityViewUseridStartEnd"
  },
  {
    "type": "POST",
    "url": "/commodity/add",
    "title": "增加商品信息",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>增加商品信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Commodity",
            "optional": false,
            "field": "commodity",
            "description": "<p>商品信息对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"1\",\n   title:\"标题是什么\",\n   content:\"内容是什么\",\n   province:\"省\",\n   city:\"市\",\n   district:\"区\",\n   pricePre:\"原价\",\n   priceNow:\"现价\",\n   cdType:\"商品类型,0,1,2\",\n   condition:\"新旧程度\",\n   cdCount:\"商品数量\",c\n   cdColor:\"商品颜色,多种颜色以逗号分隔,\n   cdSize:\"商品规格,多种规格以逗号分隔\",\n   imgId:商品图片Id,\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PostCommodityAdd"
  },
  {
    "type": "POST",
    "url": "/commodity/comment",
    "title": "增加商品评论",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>增加商品评论</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "GoodsComment",
            "optional": false,
            "field": "goodsComment",
            "description": "<p>商品评论对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户id\",\n   goodsId:\"商品Id\",\n   comment:\"评论内容\",\n   star:\"商品评价\",\n   isAnonymous:\"是否匿名\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PostCommodityComment"
  },
  {
    "type": "POST",
    "url": "/commodity/img/{userId}",
    "title": "上传商品图片",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>上传商品图片</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   file:\"图片文件\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PostCommodityImgUserid"
  },
  {
    "type": "PUT",
    "url": "/commodity",
    "title": "修改商品信息",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>增加商品信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Commodity",
            "optional": false,
            "field": "commodity",
            "description": "<p>商品信息对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   cdId:\"商品信息主键\",\n   title:\"标题是什么\",\n   content:\"内容是什么\",\n   priceNow:\"现价\",\n   cdType:\"商品类型\",\n   cdCount:\"商品数量\",\n   imgId:商品图片,\n   discountFee:\"打折费用\",\n   expressFee:\"物流费用\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PutCommodity"
  },
  {
    "type": "PUT",
    "url": "/commodity/star",
    "title": "商品增加好评",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>商品增加好评</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Commodity",
            "optional": false,
            "field": "commodity",
            "description": "<p>商品对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   cdId:\"商品Id\",\n   userId:\"用户Id\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PutCommodityStar"
  },
  {
    "type": "PUT",
    "url": "/remove/{cdId}",
    "title": "商品下架",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>商品下架</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "/commodity/remove/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PutRemoveCdid"
  },
  {
    "type": "PUT",
    "url": "/sell/{cdId}",
    "title": "商品上架",
    "group": "Commodity",
    "version": "0.0.1",
    "description": "<p>商品上架</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "/commodity/sell/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommodityController.java",
    "groupTitle": "Commodity",
    "name": "PutSellCdid"
  },
  {
    "type": "DELETE",
    "url": "/common/param/{pvId}",
    "title": "删除参数值",
    "group": "Common",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pvId",
            "description": "<p>参数主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/common/param/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除参数值</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Common",
    "name": "DeleteCommonParamPvid"
  },
  {
    "type": "GET",
    "url": "/admin/goods/class/{type}",
    "title": "获取商品分类列表",
    "group": "Common",
    "version": "0.0.1",
    "description": "<p>获取商品分类列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/goods/class/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    id: \"分类主键\",\n    name:\"名称\",\n    gtId: \"对应商品类型主键\",\n    value:\"对应数字值\"},\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Common",
    "name": "GetAdminGoodsClassType"
  },
  {
    "type": "GET",
    "url": "/admin/goods/type",
    "title": "获取商品类型列表",
    "group": "Common",
    "version": "0.0.1",
    "description": "<p>获取商品类型列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/admin/goods/type",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    id: \"类型主键\",\n    name:名称,\n    value: \"对应数字值\"},\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/AdminController.java",
    "groupTitle": "Common",
    "name": "GetAdminGoodsType"
  },
  {
    "type": "GET",
    "url": "/common/district",
    "title": "获取行政区域",
    "group": "Common",
    "version": "0.0.1",
    "description": "<p>获取行政区域</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "{\n    city: 西安\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    id: \"主键\",\n    district:\"区\",\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Common",
    "name": "GetCommonDistrict"
  },
  {
    "type": "GET",
    "url": "/common/goods/class/{type}",
    "title": "获取商品分类列表",
    "group": "Common",
    "version": "0.0.1",
    "description": "<p>获取商品分类列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/common/goods/class/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    id: \"分类主键\",\n    name:\"名称\",\n    gtId: \"对应商品类型主键\",\n    value:\"对应数字值\"},\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Common",
    "name": "GetCommonGoodsClassType"
  },
  {
    "type": "GET",
    "url": "/common/goods/type",
    "title": "获取商品类型列表",
    "group": "Common",
    "version": "0.0.1",
    "description": "<p>获取商品类型列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/common/goods/type",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    id: \"类型主键\",\n    name:名称,\n    value: \"对应数字值\"},\n ...]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Common",
    "name": "GetCommonGoodsType"
  },
  {
    "type": "PUT",
    "url": "/common/param",
    "title": "修改参数值",
    "group": "Common",
    "version": "0.0.1",
    "description": "<p>修改参数值</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ParamValue",
            "optional": false,
            "field": "paramValue",
            "description": "<p>参数对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   pvId:\"参数主键\",\n   paramValue:\"参数值\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CommonController.java",
    "groupTitle": "Common",
    "name": "PutCommonParam"
  },
  {
    "type": "DELETE",
    "url": "/conv/del/{ciId}",
    "title": "删除指定便民信息",
    "group": "Convenient",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "ciId",
            "description": "<p>便民信息表主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/conv/del/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除指定便民信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "DeleteConvDelCiid"
  },
  {
    "type": "GET",
    "url": "/conv/{ciId}",
    "title": "便民信息详情",
    "group": "Convenient",
    "version": "0.0.1",
    "description": "<p>便民信息详情</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/conv/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ciId: 1,\n    title: \"文章标题\",\n    content: \"文章内容\",\n    userId:\"用户id\",\n    userName:\"用户姓名\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\"},{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "GetConvCiid"
  },
  {
    "type": "GET",
    "url": "/conv/comment/list/{ciId}/{start}/{end}",
    "title": "获取便民信息评论",
    "group": "Convenient",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/conv/comment/list/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取便民信息评论</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ccId: 评论Id,\n    userId: \"用户Id\",\n    userName:用户名字,\n    avatarId: \"头像Id\"},\n {\n    ccId: 评论Id,\n    userId: \"用户Id\",\n    userName:用户名字,\n    avatarId: \"头像Id\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "GetConvCommentListCiidStartEnd"
  },
  {
    "type": "GET",
    "url": "/conv/list/{start}/{end}",
    "title": "获取便民信息列表",
    "group": "Convenient",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/conv/list/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取个人信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ciId: 1,\n    title: \"文章标题\",\n    content: \"文章内容\",\n    userId:\"用户id\",\n    userName:\"用户姓名\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    province:\"省\",\n    city:\"市\",\n    district:\"区\",\n    isExpire:\"是否有效\"},{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "GetConvListStartEnd"
  },
  {
    "type": "GET",
    "url": "/conv/user/{userId}/{start}/{end}",
    "title": "获取用户便民信息",
    "group": "Convenient",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/conv/user/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取用户便民信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ciId: 便民信息id,\n    userId:用户Id\n    viewCount:\"浏览数\",\n    commentCount:\"评论数量\",\n    isExpire:\"是否失效\",\n    title: \"文章标题\",\n    content: \"文章内容\"\n    },\n {\n    ciId: 2,\n    userId:用户Id\n    viewCount:\"浏览数\",\n    commentCount:\"评论数量\",\n    isExpire:\"是否失效\",\n    title: \"文章标题2\",\n    content: \"文章内容2\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "GetConvUserUseridStartEnd"
  },
  {
    "type": "POST",
    "url": "/conv",
    "title": "增加便民信息",
    "group": "Convenient",
    "version": "0.0.1",
    "description": "<p>增加便民信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ConvInfo",
            "optional": false,
            "field": "convInfo",
            "description": "<p>便民信息对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   title:\"标题是什么\",\n   content:\"内容是什么\",\n   validDate:\"结束日期\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "PostConv"
  },
  {
    "type": "POST",
    "url": "/conv/comment",
    "title": "增加便民信息评论",
    "group": "Convenient",
    "version": "0.0.1",
    "description": "<p>增加便民信息评论</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ConvComment",
            "optional": false,
            "field": "convComment",
            "description": "<p>评论对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户id\",\n   ciId:\"便民信息id\",\n   comment:\"评论内容\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "PostConvComment"
  },
  {
    "type": "PUT",
    "url": "/conv",
    "title": "修改便民信息",
    "group": "Convenient",
    "version": "0.0.1",
    "description": "<p>修改便民信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ConvInfo",
            "optional": false,
            "field": "convInfo",
            "description": "<p>便民信息对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"112312\",\n   title:\"标题是什么\",\n   content:\"内容是什么\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ConvInfoController.java",
    "groupTitle": "Convenient",
    "name": "PutConv"
  },
  {
    "type": "GET",
    "url": "/moments/comment/{cfId}/{start}/{end}",
    "title": "车友圈评论",
    "group": "Forum",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cfId",
            "description": "<p>车友圈主键</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/moments/comment/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>车友圈评论</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    fsId: 主键,\n    content: \"评论内容\",\n    userId:\"用户Id\",\n    userName:\"评论数\",\n    avatarId:\"头像\",\n    createTime:\"评论时间\"\n    },{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "GetMomentsCommentCfidStartEnd"
  },
  {
    "type": "GET",
    "url": "/moments/detail/{cfId}",
    "title": "车友圈详情",
    "group": "Forum",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cfId",
            "description": "<p>车友圈Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/moments/detail/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>车友圈详情</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n    cfId: 主键,\n    content: \"车友圈内容\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    starCount:\"好评数\",\n    imgList:\"图片数组\",\n    mediaId:\"视频文件\",\n    cfType:0:车友圈,1:视频\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "GetMomentsDetailCfid"
  },
  {
    "type": "GET",
    "url": "/moments/forum/user/{userId}/{start}/{end}",
    "title": "我的车友圈列表",
    "group": "Forum",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/moments/forum/user/forum/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>我的车友圈列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cfId: 主键,\n    content: \"车友圈内容\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    starCount:\"好评数\",\n    imgList:\"图片数组\",\n    mediaId:\"视频文件\",\n    cfType:0:车友圈,1:视频\n    },{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "GetMomentsForumUserUseridStartEnd"
  },
  {
    "type": "GET",
    "url": "/moments/list/forum/{start}/{end}",
    "title": "车友圈列表",
    "group": "Forum",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/moments/list/forum/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>车友圈列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cfId: 主键,\n    content: \"车友圈内容\",\n    userId:\"用户id\",\n    userName:\"用户姓名\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    starCount:\"好评数\",\n    imgList:\"图片数组\",\n    },{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "GetMomentsListForumStartEnd"
  },
  {
    "type": "GET",
    "url": "/moments/list/video/{start}/{end}",
    "title": "车友圈视频列表",
    "group": "Forum",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/moments/list/video/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>车友圈视频列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    cfId: 主键,\n    content: \"车友圈内容\",\n    userId:\"用户id\",\n    userName:\"用户姓名\",\n    viewCount:\"浏览数\",\n    commentCount:\"评论数\",\n    starCount:\"好评数\",\n    mediaId:\"视频文件Id\",\n    },{...}\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "GetMomentsListVideoStartEnd"
  },
  {
    "type": "POST",
    "url": "/moments/comment",
    "title": "增加车友圈评论",
    "group": "Forum",
    "version": "0.0.1",
    "description": "<p>增加车友圈视频</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   cfId:\"车友圈Id\"\n   userId:\"用户Id\",\n   content:\"评论内容\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "PostMomentsComment"
  },
  {
    "type": "POST",
    "url": "/moments/forum",
    "title": "增加车友圈",
    "group": "Forum",
    "version": "0.0.1",
    "description": "<p>增加车友圈</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   content:\"贴子内容\",\n   mediaId:\"图片id,多个图片用逗号分隔\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "PostMomentsForum"
  },
  {
    "type": "POST",
    "url": "/moments/star",
    "title": "增加车友圈好评",
    "group": "Forum",
    "version": "0.0.1",
    "description": "<p>增加车友圈好评</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   cfId:\"车友圈Id\"\n   userId:\"用户Id\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "PostMomentsStar"
  },
  {
    "type": "POST",
    "url": "/moments/video",
    "title": "增加车友圈视频",
    "group": "Forum",
    "version": "0.0.1",
    "description": "<p>增加车友圈视频</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   content:\"贴子内容\",\n   mediaId:\"视频Id\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/CarForumController.java",
    "groupTitle": "Forum",
    "name": "PostMomentsVideo"
  },
  {
    "type": "DELETE",
    "url": "/collect/{mcId}",
    "title": "删除我的收藏",
    "group": "MyCollect",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "mcId",
            "description": "<p>我的收藏主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/collect/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除我的收藏</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/MyCollectController.java",
    "groupTitle": "MyCollect",
    "name": "DeleteCollectMcid"
  },
  {
    "type": "DELETE",
    "url": "/collect/multi",
    "title": "删除多条我的收藏",
    "group": "MyCollect",
    "version": "0.0.1",
    "description": "<p>删除多条我的收藏</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "mcId",
            "description": "<p>浏览记录主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "/collect/multi?mcId=1&mcId=2",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/MyCollectController.java",
    "groupTitle": "MyCollect",
    "name": "DeleteCollectMulti"
  },
  {
    "type": "GET",
    "url": "/collect/list/{userId}/{start}/{end}",
    "title": "查看我的收藏信息",
    "group": "MyCollect",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/collect/list/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>查看我的收藏信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    mcId: \"我的收藏主键\",\n    userId:\"用户id2\",\n    cdId:\"商品id2\",\n    content:\"商品描述\"\n    title:\"商品名\",\n    imgId:\"图像Id\",\n    pricePre:\"商品原价2\",\n    pricePre:\"商品现价2\",\n    createTime:\"创建时间2\"},\n {\n    mcId: \"我的收藏主键\",\n    userId:\"用户id2\",\n    cdId:\"商品id2\",\n    content:\"商品描述\"\n    title:\"商品名\",\n    imgId:\"图像Id\",\n    pricePre:\"商品原价2\",\n    pricePre:\"商品现价2\",\n    createTime:\"创建时间2\"}\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/MyCollectController.java",
    "groupTitle": "MyCollect",
    "name": "GetCollectListUseridStartEnd"
  },
  {
    "type": "POST",
    "url": "/collect",
    "title": "增加我的收藏",
    "group": "MyCollect",
    "version": "0.0.1",
    "description": "<p>增加我的收藏</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "MyCollect",
            "optional": false,
            "field": "myCollect",
            "description": "<p>我的收藏对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户id\",\n   cdId:\"商品id\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/MyCollectController.java",
    "groupTitle": "MyCollect",
    "name": "PostCollect"
  },
  {
    "type": "DELETE",
    "url": "/order/{goId}",
    "title": "删除订单",
    "group": "Order",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "goId",
            "description": "<p>订单表主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/order/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除订单</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "DeleteOrderGoid"
  },
  {
    "type": "GET",
    "url": "/order/all/{userId}/{start}/{end}",
    "title": "所有订单列表",
    "group": "Order",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/order/all/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>所有订单列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    goId: \"订单Id\",\n    cdId: \"商品id\",\n    orderState: \"订单状态\",\n    imgId:\"商品图片\",\n    title:\"商品标题\",\n    content:\"商品内容\",\n    payFee:\"支付费用\",\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "GetOrderAllUseridStartEnd"
  },
  {
    "type": "GET",
    "url": "/order/complete/{userId}/{start}/{end}",
    "title": "已完成订单列表",
    "group": "Order",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/order/complete/1/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>已完成订单列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    goId: \"订单Id\",\n    cdId: \"商品id\",\n    orderState: \"订单状态\",\n    imgId:\"商品图片\",\n    title:\"商品标题\",\n    content:\"商品内容\",\n    payFee:\"支付费用\",\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "GetOrderCompleteUseridStartEnd"
  },
  {
    "type": "GET",
    "url": "/order/detail/{goId}",
    "title": "订单详情",
    "group": "Order",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cdId",
            "description": "<p>商品主键</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>商品类型</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/commodity/detail/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>订单详情</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": " {\"code\":\"success\",\n  \"data\":{\n   goId:\"订单Id\",\n   cdId:\"商品id\",\n   userId:\"用户id\",\n   merchantId:商户Id,\n   goCount:\"商品数量\",\n   orderState:\"订单状态\",\n   orderNumber:\"订单号\",\n   expressFee:\"物流费用\",\n   discountFee:\"打折费用\",\n   payFee:\"实际支付费用\",\n   createTime:\"创建时间\",\n   imgId:\"商品图片\",\n   cdColor:\"商品颜色,\n   cdSize:\"商品规格\",\n   goodsPrice:\"商品单价\",\n   title:\"商品标题\",\n   content:\"商品内容\",\n   \"address\": {\n       \"uaId\": 1,\n       \"city\": \"市\",\n       \"district\": \"区\",\n       \"address\": \"地址\",\n       \"recipient\": \"收件人\",\n       \"mobile\": \"手机号\",\n       \"userId\": null,\n       \"isDefault\": 1,\n    }\n }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "GetOrderDetailGoid"
  },
  {
    "type": "GET",
    "url": "/order/express/{goId}",
    "title": "查看订单物流",
    "group": "Order",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "goId",
            "description": "<p>订单主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/order/express/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>查看订单物流</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": " {\"code\":\"success\",\n  \"data\":{\n   deliverystatus:\"物流状态 1在途中 2派件中 3已签收 4派送失败\",\n   company:\"快递公司\",\n   number:\"快递单号\",\n   \"list\": [{\n       \"time\": 时间,\n       \"status\": \"快递状态\",\n    },{}]\n }\n}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "GetOrderExpressGoid"
  },
  {
    "type": "GET",
    "url": "/order/incomplete/{userId}/{start}/{end}",
    "title": "未完成订单列表",
    "group": "Order",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/order/incomplete/1/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>未完成订单列表</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    goId: \"订单Id\",\n    cdId: \"商品id\",\n    orderState: \"订单状态\",\n    imgId:\"商品图片\",\n    title:\"商品标题\",\n    content:\"商品内容\",\n    payFee:\"支付费用\",\n ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "GetOrderIncompleteUseridStartEnd"
  },
  {
    "type": "POST",
    "url": "/order",
    "title": "增加订单",
    "group": "Order",
    "version": "0.0.1",
    "description": "<p>增加订单</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "GoodsOrderSimple",
            "optional": false,
            "field": "goodsOrderSimple",
            "description": "<p>订单对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   uaId:\"用户地址Id\",\n   cdId:\"商品Id\",\n   goCount:\"商品数量\",\n   expressFee:\"物流费用\",\n   discountFee:\"优惠费用\",\n   cdSize:\"商品规格\",\n   cdColor:\"商品颜色\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "PostOrder"
  },
  {
    "type": "POST",
    "url": "/order/deliver/remind",
    "title": "发货提醒",
    "group": "Order",
    "version": "0.0.1",
    "description": "<p>发货提醒</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   goId:\"订单Id\",\n   merchantId:\"商家Id\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "PostOrderDeliverRemind"
  },
  {
    "type": "POST",
    "url": "/order/deliver/return",
    "title": "申请退货",
    "group": "Order",
    "version": "0.0.1",
    "description": "<p>申请退货</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   goId:\"订单Id\",\n   merchantId:\"商家Id\",\n   explain:\"退货说明\",\n   reason:\"退货原因---原因列表前台写死\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "PostOrderDeliverReturn"
  },
  {
    "type": "PUT",
    "url": "/order/cancel/{goId}",
    "title": "取消订单",
    "group": "Order",
    "version": "0.0.1",
    "description": "<p>取消订单</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "/order/cancel/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "PutOrderCancelGoid"
  },
  {
    "type": "PUT",
    "url": "/order/deliver/confirm/{goId}",
    "title": "确认收货",
    "group": "Order",
    "version": "0.0.1",
    "description": "<p>取消订单</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "/order/deliver/confirm/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/GoodsOrderController.java",
    "groupTitle": "Order",
    "name": "PutOrderDeliverConfirmGoid"
  },
  {
    "type": "GET",
    "url": "/file/read/{rfId}",
    "title": "附件查看",
    "group": "Resource",
    "version": "0.0.1",
    "description": "<p>查看文件,需要传输文件id, 返回ResponseEntity&lt;byte[]&gt;</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "rfId",
            "description": "<p>文件id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "/file/read/d5540ff2db804a8daf1050a06679155f",
          "type": "uri"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/FileController.java",
    "groupTitle": "Resource",
    "name": "GetFileReadRfid"
  },
  {
    "type": "DELETE",
    "url": "/cart/{scId}",
    "title": "删除指定购物车信息",
    "group": "ShopCart",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "scId",
            "description": "<p>购物车表主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/cart/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除用户地址信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopCartController.java",
    "groupTitle": "ShopCart",
    "name": "DeleteCartScid"
  },
  {
    "type": "GET",
    "url": "/cart/list/{userId}/{start}/{end}",
    "title": "获取用户购物车信息",
    "group": "ShopCart",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/cart/list/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取指定类型商品</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    scId: 1,\n    userId:\"用户id\",\n    cdId:\"商品id\",\n    title:商品标题,\n    payCount:购买数量\n    price:\"商品价格\",\n    cdCount:\"商品数量\",\n    scColor:\"商品颜色,\n    scSize:\"商品规格\",\n    createTime:\"创建时间\"},\n {\n    scId: 1,\n    userId:\"用户id\",\n    cdId:\"商品id\",\n    priceNow:\"商品价格2\",\n    payCount:购买数量\n    price:\"商品价格\",\n    cdCount:\"商品数量2\",\n    scColor:\"商品颜色,\n    scSize:\"商品规格\",\n    createTime:\"创建时间2\"}\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopCartController.java",
    "groupTitle": "ShopCart",
    "name": "GetCartListUseridStartEnd"
  },
  {
    "type": "POST",
    "url": "/cart",
    "title": "增加购物车信息",
    "group": "ShopCart",
    "version": "0.0.1",
    "description": "<p>增加购物车信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ShopCart",
            "optional": false,
            "field": "shopCart",
            "description": "<p>购物车对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户id\",\n   cdId:\"商品id\",\n   price:\"商品价格\",\n   payCount:\"商品数量\",\n   scColor:\"商品颜色,\n   scSize:\"商品规格\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopCartController.java",
    "groupTitle": "ShopCart",
    "name": "PostCart"
  },
  {
    "type": "GET",
    "url": "/shop/service/detail/{sgId}",
    "title": "获取服务详情",
    "group": "ShopGoods",
    "version": "0.0.1",
    "description": "<p>获取服务详情</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/shop/service/detail/1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": " {\"code\":\"success\",\n  \"data\":{\n   username:\"发布人\",\n   shopName:\"标题是什么\",\n   shopContent:\"内容是什么\",\n   imgId:\"图片base64编码\",\n   imgList:\"图片列表\",\n   city:\"市\",\n   price:\"商品价格\",\n   address:\"地址\",\n   mobile:\"手机\",\n   discountNote:\"打折活动\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "GetShopServiceDetailSgid"
  },
  {
    "type": "GET",
    "url": "/shop/service/list/{type}/{start}/{end}",
    "title": "获取指定类型服务列表",
    "group": "ShopGoods",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "byte",
            "optional": false,
            "field": "type",
            "description": "<p>服务类型</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/shop/service/list/1/0/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取指定类型服务列表 汽车美容,改装...</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    sgId: 1,\n    shopName \"店铺名\",\n    imgId:\"商品图片\",\n    shopContent: \"店铺介绍\",\n    price:\"价格\",\n    city:\"城市\",\n    district:\"区域\"\n  }\n {\n    sgId: 2,\n    shopName: \"店铺名\",\n    imgId:\"商品图片\",\n    shopContent: \"店铺介绍\",\n    price:\"价格\",\n    city:\"城市\",\n    district:\"区域\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "GetShopServiceListTypeStartEnd"
  },
  {
    "type": "GET",
    "url": "/shop/service/select",
    "title": "筛选服务列表",
    "group": "ShopGoods",
    "version": "0.0.1",
    "description": "<p>筛选服务列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "{\n    type:服务类型,\n    city:\"城市\",\n    price:\"价格排序 0,正序,1倒序\"\n    priceStart:\"价格开始区间\",\n    priceEnd:\"价格结束区间\",\n    start:\"分页开始索引,必填\",\n    end:\"分页查询长度,必填\",\n }",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    sgId: 1,\n    shopName \"店铺名\",\n    imgId:\"商品图片\",\n    shopContent: \"店铺介绍\",\n    price:\"价格\",\n    city:\"城市\",\n    district:\"区域\"\n  }\n {\n    sgId: 2,\n    shopName: \"店铺名\",\n    imgId:\"商品图片\",\n    shopContent: \"店铺介绍\",\n    price:\"价格\",\n    city:\"城市\",\n    district:\"区域\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "GetShopServiceSelect"
  },
  {
    "type": "POST",
    "url": "/shop/goods",
    "title": "增加商家商品",
    "group": "ShopGoods",
    "version": "0.0.1",
    "description": "<p>增加商家商品</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"1\",\n   title:\"标题是\",\n   content:\"商品介绍\",\n   province:\"省\",\n   city:\"市\",\n   district:\"区\",\n   priceNow:\"价格\",\n   cdType:\"商品类型,0,1,2\",\n   condition:\"新旧程度\",\n   cdCount:\"商品数量\",\n   cdColor:\"商品颜色,多种颜色以逗号分隔,\n   cdSize:\"商品规格,多种规格以逗号分隔\",\n   imgId:商品图片Id,\n   discountFee:打折费用,\n   expressFee:物流费用\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "PostShopGoods"
  },
  {
    "type": "POST",
    "url": "/shop/service",
    "title": "增加商家服务",
    "group": "ShopGoods",
    "version": "0.0.1",
    "description": "<p>增加商家服务</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"1\",\n   shopContent:\"店铺介绍\",\n   shopName:\"店铺名\"\n   price:\"起步价\",\n   serviceType:\"3:汽车美容,5:故障快处,6:道路救援 8:需求通讯\",\n   address:\"店铺地址\",\n   imgId:图片Id,\n   discountNote:打折活动,\n   mobile:手机号,\n   city:\"城市\",\n   district:\"区域\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "PostShopService"
  },
  {
    "type": "PUT",
    "url": "/shop/goods",
    "title": "修改商家商品",
    "group": "ShopGoods",
    "version": "0.0.1",
    "description": "<p>修改商家商品</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   cdId:\"商品信息主键\",\n   title:\"标题\",\n   content:\"商品介绍\",\n   priceNow:\"价格\",\n   cdType:\"商品类型\",\n   cdCount:\"商品数量\",\n   imgId:商品图片,\n   discountFee:\"打折费用\",\n   expressFee:\"物流费用\",\n   cdCount:\"商品数量\",\n   cdColor:\"商品颜色,多种颜色以逗号分隔,\n   cdSize:\"商品规格,多种规格以逗号分隔\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "PutShopGoods"
  },
  {
    "type": "PUT",
    "url": "/shop/service",
    "title": "修改商家服务",
    "group": "ShopGoods",
    "version": "0.0.1",
    "description": "<p>修改商家服务</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   sgId:\"主键\"\n   shopContent:\"店铺介绍\",\n   shopName:\"店铺名\"\n   price:\"起步价\",\n   serviceType:\"3:汽车美容,5:故障快处,6:道路救援 8:需求通讯\",\n   address:\"店铺地址\",\n   imgId:图片Id,\n   discountNote:打折活动,\n   mobile:手机号\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopGoodsController.java",
    "groupTitle": "ShopGoods",
    "name": "PutShopService"
  },
  {
    "type": "GET",
    "url": "/shop/info/{userId}",
    "title": "查询商铺信息",
    "group": "ShopVerify",
    "version": "0.0.1",
    "description": "<p>查询商铺信息</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/shop/info/1",
          "type": "json"
        },
        {
          "title": "返回样例:",
          "content": "{\n   userId:\"用户Id\",\n   userName:\"代表人姓名\",\n   idNumber:\"身份证号\",\n   mobile:\"手机号\",\n   shopName:\"店铺名称\",\n   shopIntro:\"店铺描述\",\n   shopAddress:\"店铺地址\",\n   idFrontImg:\"身份证正面照\",\n   idRearImg:\"身份证反面照\",\n   logoImg:\"logo图片\",\n   licenseImg:\"营业执照照片\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopVerifyController.java",
    "groupTitle": "ShopVerify",
    "name": "GetShopInfoUserid"
  },
  {
    "type": "POST",
    "url": "/shop/verify",
    "title": "增加商家审核信息",
    "group": "ShopVerify",
    "version": "0.0.1",
    "description": "<p>增加商家审核信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "ShopVerify",
            "optional": false,
            "field": "shopVerify",
            "description": "<p>商家审核对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   userName:\"代表人姓名\",\n   idNumber:\"收件人\",\n   mobile:\"手机号\",\n   shopName:\"店铺名称\",\n   shopIntro:\"店铺描述\",\n   shopAddress:\"店铺地址\",\n   idFrontImg:\"身份证正面照\",\n   idRearImg:\"身份证反面照\",\n   logoImg:\"logo图片\",\n   licenseImg:\"营业执照照片\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopVerifyController.java",
    "groupTitle": "ShopVerify",
    "name": "PostShopVerify"
  },
  {
    "type": "PUT",
    "url": "/shop/info",
    "title": "修改商家信息",
    "group": "ShopVerify",
    "version": "0.0.1",
    "description": "<p>修改商家信息</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   svId: 信息主键,\n   userId:\"用户Id\",\n   shopName:\"店铺名称\",\n   shopIntro:\"店铺描述\",\n   shopAddress:\"店铺地址\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/ShopVerifyController.java",
    "groupTitle": "ShopVerify",
    "name": "PutShopInfo"
  },
  {
    "type": "DELETE",
    "url": "/address/{uaId}",
    "title": "删除用户地址信息",
    "group": "UserAddress",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "uaId",
            "description": "<p>地址表主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/address/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除用户地址信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserAddressController.java",
    "groupTitle": "UserAddress",
    "name": "DeleteAddressUaid"
  },
  {
    "type": "GET",
    "url": "/address/default/{userId}",
    "title": "获取用户默认地址",
    "group": "UserAddress",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/address/default/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取用户默认地址</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n    uaId: 1,\n    address: \"地址信息1\",\n    city:\"市\",\n    district:\"区\"\n    recipient: \"收件人1\",\n    isDefault:\"是否是默认地址\",\n    mobile:\"手机号1\"\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserAddressController.java",
    "groupTitle": "UserAddress",
    "name": "GetAddressDefaultUserid"
  },
  {
    "type": "GET",
    "url": "/address/list/{userId}",
    "title": "获取用户地址信息",
    "group": "UserAddress",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/address/list/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取用户地址信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    uaId: 1,\n    address: \"地址信息1\",\n    city:\"市\",\n    district:\"区\"\n    recipient: \"收件人1\",\n    isDefault:\"是否是默认地址\",\n    mobile:\"手机号1\"},\n {\n    uaId: 2,\n    address: \"地址信息2\",\n    city:\"市\",\n    district:\"区\"\n    recipient: \"收件人2\",\n    isDefault:\"是否是默认地址\",\n    mobile:\"手机号2\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserAddressController.java",
    "groupTitle": "UserAddress",
    "name": "GetAddressListUserid"
  },
  {
    "type": "POST",
    "url": "/address",
    "title": "增加地址信息",
    "group": "UserAddress",
    "version": "0.0.1",
    "description": "<p>增加地址信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "UserAddress",
            "optional": false,
            "field": "UserAddress",
            "description": "<p>用户地址对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   mobile:\"手机号\",\n   recipient:\"收件人\",\n   isDefault:\"是否是默认地址\",\n   address:\"地址信息\",\n   city:\"市\",\n   district:\"区\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserAddressController.java",
    "groupTitle": "UserAddress",
    "name": "PostAddress"
  },
  {
    "type": "PUT",
    "url": "/address",
    "title": "修改地址信息",
    "group": "UserAddress",
    "version": "0.0.1",
    "description": "<p>增加地址信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "UserAddress",
            "optional": false,
            "field": "UserAddress",
            "description": "<p>用户地址对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   uaId: \"本条记录id\",\n   mobile:\"手机号\",\n   recipient:\"收件人\",\n   address:\"地址信息\",\n   city:\"市\",\n   district:\"区\"\n   isDefault:\"0 ,1 是否为默认地址\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserAddressController.java",
    "groupTitle": "UserAddress",
    "name": "PutAddress"
  },
  {
    "type": "PUT",
    "url": "/address/default",
    "title": "修改为默认地址",
    "group": "UserAddress",
    "version": "0.0.1",
    "description": "<p>增加地址信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "UserAddress",
            "optional": false,
            "field": "UserAddress",
            "description": "<p>用户地址对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   uaId: \"本条记录id\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserAddressController.java",
    "groupTitle": "UserAddress",
    "name": "PutAddressDefault"
  },
  {
    "type": "DELETE",
    "url": "/car/{ucId}",
    "title": "删除指定车辆信息",
    "group": "UserCar",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "ucId",
            "description": "<p>车辆表主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/car/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>删除用户地址信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "DeleteCarUcid"
  },
  {
    "type": "GET",
    "url": "/car/illegal/info/{carId}",
    "title": "获取已存车辆违章信息",
    "group": "UserCar",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "carId",
            "description": "<p>车辆Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/car/illegal/info/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取已存车辆违章信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n    userId: 1,\n    carId:\"车辆ID\",\n    username:\"姓名\",\n    carProvince:\"车辆省份  陕A,山A...\",\n    carType:\"车类型 0:小车,1:大车\",\n    carNum:\"12345\",\n    list:[{\n        canHandle:\"是否可以代缴\",\n        address:\"违章地址\",\n        handleFee:\"代缴费用\",\n        content:\"违章内容\",\n        score:\"扣分\",\n        price:\"金额\",\n        time:\"违章时间\"\n    }\n    ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "GetCarIllegalInfoCarid"
  },
  {
    "type": "GET",
    "url": "/car/license/score/{fileId}/{licenseId}",
    "title": "驾照查分",
    "group": "UserCar",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "fileId",
            "description": "<p>档案编号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "licenseId",
            "description": "<p>驾驶证号</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/car/license/score/12/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>驾照查分</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n    userId: 1,\n    carId:\"车辆ID\",\n    username:\"姓名\",\n    score:\"扣分\",\n    enddate:\"有效时间\"\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "GetCarLicenseScoreFileidLicenseid"
  },
  {
    "type": "GET",
    "url": "/car/list/{userId}",
    "title": "获取用户车辆信息",
    "group": "UserCar",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/car/list/12",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取用户地址信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    ucId: 1,\n    userId:\"用户Id\",\n    carNum:\"车牌号: 13768\",\n    carProvince:\"车辆省份  陕A,山A...\",\n    carType:\"车类型 0:小车,1:大车\",\n    engineNum:\"发动机号\",\n    frameNum:\"车架号\"\n  },\n {\n    uaId: 2,\n    userId:\"用户Id\",\n    carNum:\"车牌号: 13768\",\n    carProvince:\"车辆省份  陕A,山A...\",\n    carType:\"车类型 0:小车,1:大车\",\n    engineNum:\"发动机号\",\n    frameNum:\"车架号\"\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "GetCarListUserid"
  },
  {
    "type": "POST",
    "url": "/car",
    "title": "增加车辆信息",
    "group": "UserCar",
    "version": "0.0.1",
    "description": "<p>增加车辆信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "UserCar",
            "optional": false,
            "field": "userCar",
            "description": "<p>用户车辆对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   carNum:\"车牌号: 13768\",\n   carProvince:\"车辆省份  陕A,山A...\",\n   carType:\"车类型 0:小车,1:大车\",\n   engineNum:\"发动机号\",\n   frameNum:\"车架号\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "PostCar"
  },
  {
    "type": "POST",
    "url": "/car/illegal/attach/{carId}",
    "title": "违章信息补充",
    "group": "UserCar",
    "version": "0.0.1",
    "description": "<p>违章信息补充</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   file:\"图片文件\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "PostCarIllegalAttachCarid"
  },
  {
    "type": "POST",
    "url": "/car/illegal/info",
    "title": "获取违章信息",
    "group": "UserCar",
    "version": "0.0.1",
    "description": "<p>获取违章信息</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": " {\n   userId:\"用户Id\",\n   carNum:\"车牌号: 13768\",\n   carProvince:\"车辆省份  陕A,山A...\",\n   carType:\"车类型 0:小车,1:大车\",\n   engineNum:\"发动机号\",\n   frameNum:\"车架号\",\n   isSave:\"0不保存,1保存\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n    userId: 1,\n    carId:\"车辆ID\",\n    username:\"姓名\",\n    carProvince:\"车辆省份  陕A,山A...\",\n    carType:\"车类型 0:小车,1:大车\",\n    carNum:\"12345\",\n    list:[{\n        canHandle:\"是否可以代缴\",\n        address:\"违章地址\",\n        handleFee:\"代缴费用\",\n        content:\"违章内容\",\n        score:\"扣分\",\n        price:\"金额\",\n        time:\"违章时间\"\n    }\n    ]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "PostCarIllegalInfo"
  },
  {
    "type": "PUT",
    "url": "/car",
    "title": "修改车辆信息",
    "group": "UserCar",
    "version": "0.0.1",
    "description": "<p>修改车辆信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "UserCar",
            "optional": false,
            "field": "userCar",
            "description": "<p>用户车辆对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   ucId:\"主键id\",\n   userId:\"用户Id\",\n   carNum:\"车牌号: A13768\",\n   carProvince:\"车辆省份  陕A,山A...\",\n   carType:\"车类型 0:小车,1:大车\",\n   engineNum:\"发动机号\",\n   frameNum:\"车架号\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserCarController.java",
    "groupTitle": "UserCar",
    "name": "PutCar"
  },
  {
    "type": "DELETE",
    "url": "/user/buy/multi",
    "title": "删除多条购买记录",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>删除多条购买记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "brId",
            "description": "<p>浏览记录主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "/user/buy/multi?brId=1&brId=2",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "DeleteUserBuyMulti"
  },
  {
    "type": "DELETE",
    "url": "/user/sell/multi",
    "title": "删除多条卖出记录",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>删除多条购买记录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "srId",
            "description": "<p>浏览记录主键</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "/user/sell/multi?srId=1&srId=2",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "DELETE",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "DeleteUserSellMulti"
  },
  {
    "type": "GET",
    "url": "/user/buy/{userId}}/{start}/{end}",
    "title": "购买记录",
    "group": "User",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/user/buy/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>购买记录</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    brId: 1,\n    title: \"商品信息标题1\",\n    goodsId:\"商品Id\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容1\",\n    amount:\"价格\",\n    brCount:\"购买数量\",\n    createTime:\"购买时间\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "GetUserBuyUseridStartEnd"
  },
  {
    "type": "GET",
    "url": "/user/mobile/auth/{mobile}",
    "title": "获取手机验证码",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>获取手机验证码</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/user/mobile/auth/18710829356",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "GetUserMobileAuthMobile"
  },
  {
    "type": "GET",
    "url": "/user/mobile/check/{userId}/{mobile}/{authCode}}",
    "title": "验证手机信息",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>验证手机信息</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/user/mobile/check/1/18710829356/3267",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "GetUserMobileCheckUseridMobileAuthcode"
  },
  {
    "type": "GET",
    "url": "/user/sell/{userId}}/{start}/{end}",
    "title": "卖出记录",
    "group": "User",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "start",
            "description": "<p>分页起始索引</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "end",
            "description": "<p>查询列表长度</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户Id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/user/sell/1/1/10",
          "type": "json"
        }
      ]
    },
    "description": "<p>卖出记录</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    srId: 1,\n    title: \"商品信息标题1\",\n    imgId:\"商品图片\",\n    content: \"商品信息内容1\",\n    goodsId:\"商品Id\",\n    amount:\"价格\",\n    brCount:\"购买数量\",\n    createTime:\"购买时间\"\n  },\n {...}]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "GetUserSellUseridStartEnd"
  },
  {
    "type": "GET",
    "url": "/user/{userId}",
    "title": "获取用户信息",
    "group": "User",
    "version": "0.0.1",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>用户表ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例：",
          "content": "/user/1",
          "type": "json"
        }
      ]
    },
    "description": "<p>获取个人信息</p>",
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n userId: 1,\n username: \"姓名\",\n mobile: \"312445345\",\n province:\"省份\",\n city:\"市\",\n gender:\"性别 0女  1男\",\n avatarId: \"fsd42sd656sdasdasd\",\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "GetUserUserid"
  },
  {
    "type": "GET",
    "url": "/user/withdraw/{userId}",
    "title": "获取提现记录列表",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>获取提现记录列表</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例：",
          "content": "/user/withdraw/10",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "200": [
          {
            "group": "200",
            "type": "String",
            "optional": false,
            "field": "msg",
            "description": "<p>信息</p>"
          }
        ],
        "success": [
          {
            "group": "success",
            "type": "GET",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\",\n \"data\":{\n [{\n    wiId: 1,\n    amount: \"提现金额\",\n    orderNum: \"订单号\",\n    wiWay:\"提现方式\"},\n {\n    wiId: 1,\n    amount: \"提现金额\",\n    orderNum: \"订单号\",\n    wiWay:\"提现方式\"},\n }]\n }",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "GetUserWithdrawUserid"
  },
  {
    "type": "POST",
    "url": "/file/upload/{userId}",
    "title": "上传用户图片",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>上传用户图片</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   file:\"图片文件\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/FileController.java",
    "groupTitle": "User",
    "name": "PostFileUploadUserid"
  },
  {
    "type": "POST",
    "url": "/user/avatar/{userId}",
    "title": "上传头像",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>上传头像</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   file:\"图片文件\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PostUserAvatarUserid"
  },
  {
    "type": "POST",
    "url": "/user/feedback",
    "title": "提交反馈",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>提交反馈</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户id\",\n   content:\"建议内容\",\n   mobile:\"电话\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PostUserFeedback"
  },
  {
    "type": "POST",
    "url": "/user/login",
    "title": "用户登录",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>用户登录</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>用户对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   password:\"MD5加密后的密码\",\n   mobile:\"18710889234\",\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；pwd_error：密码错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PostUserLogin"
  },
  {
    "type": "POST",
    "url": "/user/register",
    "title": "增加用户",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>增加用户</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>用户对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   username:\"姓名\",\n   mobile:\"18710889234\",\n   password:\"MD5加密后的密码\",\n   province:\"省\",\n   city:\"市\",\n   authCode:\"验证码\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；code_error：验证码错误；registered：手机号已被注册;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PostUserRegister"
  },
  {
    "type": "POST",
    "url": "/user/withdraw",
    "title": "增加提现记录",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>增加提现记录</p>",
    "parameter": {
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   amount:\"提现金额\",\n   userId:\"用户id\",\n   wiWay:\"提现方式\",\n   orderNum:\"订单号\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "POST",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PostUserWithdraw"
  },
  {
    "type": "PUT",
    "url": "/user",
    "title": "修改用户信息",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>修改用户信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>用户信息对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:1\n   username:\"姓名\",\n   mobile:\"18710889234\",\n   province:\"省份\",\n   city:\"市\",\n   gender:\"性别 0女  1男\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PutUser"
  },
  {
    "type": "PUT",
    "url": "/user/mobile",
    "title": "修改手机",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>修改手机</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "code",
            "description": "<p>图片base64编码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\"\n   mobile:\"新的手机号\"\n   authCode:\"验证码\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PutUserMobile"
  },
  {
    "type": "PUT",
    "url": "/user/pwd",
    "title": "修改密码",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>修改密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>user对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   userId:\"用户Id\",\n   password:\"旧密码\",\n   newPwd:\"新密码\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PutUserPwd"
  },
  {
    "type": "PUT",
    "url": "/user/pwd/reset",
    "title": "重置密码",
    "group": "User",
    "version": "0.0.1",
    "description": "<p>重置密码</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "User",
            "optional": false,
            "field": "user",
            "description": "<p>user对象</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例:",
          "content": "{\n   authCode:\"短信验证码\",\n   newPwd:\"新密码\",\n   mobile:18710829325\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "success": [
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "code",
            "description": "<p>success:请求成功； fail:请求失败；code_error：验证码错误；param_error：请求参数错误;</p>"
          },
          {
            "group": "success",
            "type": "PUT",
            "optional": false,
            "field": "data",
            "description": "<p>返回数据</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "返回样例:",
          "content": "{\"code\":\"success\"}",
          "type": "json"
        }
      ]
    },
    "filename": "E:/project/shengmei/src/main/java/com/tangmo/shengmei/controller/UserController.java",
    "groupTitle": "User",
    "name": "PutUserPwdReset"
  }
] });
