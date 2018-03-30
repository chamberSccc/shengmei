package com.tangmo.shengmei.utility.code;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chamber
 * @date 2018/3/30.
 */
@Data
@NoArgsConstructor
public class Page extends Result implements Serializable {

    private final static long serialVersionUID = 1L;
    private final static String ORDER_DESC = "desc";

    /** 页码, 从1开始 */
    protected Integer pageNum = 1;
    /** 每页大小 */
    protected Integer pageSize = 50;
    /** 总数 */
    protected Long total;
    /** 排序字段 */
    private String orderColumn;
    /** 排序方式 */
    private String orderDir = ORDER_DESC;
    /** 搜索内容 */
    private String searchValue;


    public Page(Integer pageNum, Integer pageSize){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    public Page(Integer pageNum, Integer pageSize, String orderColumn){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderColumn = orderColumn;
    }
    public Page(Integer pageNum, Integer pageSize, String orderColumn, String orderDir){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderColumn = orderColumn;
        this.orderDir = orderDir;
    }

    public void startPage() {
        if(this.orderDir != null && this.orderColumn != null){
            PageHelper.startPage(this.pageNum, this.pageSize, this.orderColumn + " " + this.orderDir);
        }else{
            PageHelper.startPage(this.pageNum, this.pageSize);
        }
    }

    /**
     * 分页后返回的结果如果需要处理才返回，
     * 则先调用page.setTotalByList(List list),
     * 再调用page.setDataByList(List list);
     *
     * @param list
     */
    public void setTotalByList(List list){
        PageInfo page = new PageInfo(list);
        setTotal(page.getTotal());
    }
    public void setDataByList(List list){
        setData(list);
        setCode(SUCCESS);
    }

    /**
     * 如果分页查询的结果直接返回，则调用此方法
     *
     * @param list
     */
    public void setResult(List list) {
        PageInfo page = new PageInfo(list);
        setTotal(page.getTotal());
        setDataByList(list);
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", orderColumn='" + orderColumn + '\'' +
                ", orderDir='" + orderDir + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", " + super.toString() +
                '}';
    }
}
