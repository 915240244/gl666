package net.nice.utils;

public class PageController {
    /*总行数*/
    int totalRowsAmount;
    //每页大小
    int pageSize=6;
    //总页数
    int totalPages;
    //当前页
    int currentPage=1;
    //下一页
    int nextPage;
    //前一页
    int previousPage;
    //最后一页
    boolean hasNext;
    //返回首页
    boolean hasPrevious;
    // 页号式导航, 起始页号
    int pageStartRow;
    // 页号式导航, 结束页号
    int pageEndRow;
    //偏移量
    int offset;

    public PageController() {
    }

    public PageController(int totalRows, int currentPage) {
        this.setPageController(totalRows, currentPage);
    }

    public PageController(int totalRows, int currentPage, int pageSize) {
        this.pageSize = pageSize;
        this.setPageController(totalRows, currentPage);
    }

    public void setPageController(int totalRows, int currentPage) {
        this.setTotalRowsAmount(totalRows);
        this.setCurrentPage(currentPage);
    }

    private void setTotalRowsAmount(int rows) {
        if (rows < 0) {
            this.totalRowsAmount = 0;
        } else {
            this.totalRowsAmount = rows;
        }

        if (this.totalRowsAmount % this.pageSize == 0) {
            this.totalPages = this.totalRowsAmount / this.pageSize;
        } else {
            this.totalPages = this.totalRowsAmount / this.pageSize + 1;
        }

    }

    public void setCurrentPage(int curPage) {
        if (curPage <= 0) {
            this.currentPage = 1;
        } else if (curPage > this.totalPages) {
            this.currentPage = this.totalPages;
        } else {
            this.currentPage = curPage;
        }

        if (this.currentPage <= 1) {
            this.hasPrevious = false;
        } else {
            this.hasPrevious = true;
        }

        if (this.currentPage >= this.totalPages) {
            this.hasNext = false;
        } else {
            this.hasNext = true;
        }

        this.nextPage = this.currentPage + 1;
        this.previousPage = this.currentPage - 1;
        if (this.currentPage != this.totalPages) {
            this.pageStartRow = (this.currentPage - 1) * this.pageSize;
            this.pageEndRow = this.currentPage * this.pageSize;
        } else {
            this.pageStartRow = (this.currentPage - 1) * this.pageSize;
            this.pageEndRow = this.totalRowsAmount - this.pageStartRow;
        }

    }

    public int getTotalRowsAmount() {
        return totalRowsAmount;
    }



    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }



    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public int getOffset() {
        return (this.currentPage - 1) * this.pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }



    public String description() {
        String description = "Total:" + this.getTotalRowsAmount() + " items " + this.getTotalPages() + " pages,Current page:" + this.currentPage + " Previous " + this.hasPrevious + " Next:" + this.hasNext + " start row:" + this.pageStartRow + " end row:" + this.pageEndRow;
        return description;
    }
}
