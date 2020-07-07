package org.gdz.mycloud.common.base.model;


public class Page {

    /**
     * Default page size.
     */
    public final int DEFAULT_SIZE = 20;

    /**
     * Current page index(Start from 0).
     */
    private int index;

    /**
     * Total page count.
     */
    private int count;

    private int offSet;

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    /**
     * Page size.
     */
    private int size;

    /**
     * Total record count.
     */
    private long recordCount;

    /**
     * Create default page object.
     */
    public Page() {
        this.index = 0;
        this.size = DEFAULT_SIZE;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index > 0 ? index - 1 : 0;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the recordCount
     */
    public long getRecordCount() {
        return recordCount;
    }

    /**
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
        this.count = recordCount == 0 ? 1 : (int) (recordCount + (size - 1)) / size;
    }
}
