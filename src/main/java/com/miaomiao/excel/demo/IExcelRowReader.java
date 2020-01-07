package com.miaomiao.excel.demo;

import java.util.List;

public interface IExcelRowReader {
    /**
     * 业务逻辑实现方法
     *
     * @param sheetIndex
     * @param curRow
     * @param rowlist
     */
    void getRows(int sheetIndex, int curRow, List<String> rowlist);
}
