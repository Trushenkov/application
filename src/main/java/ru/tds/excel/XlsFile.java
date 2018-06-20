package ru.tds.excel;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class XlsFile {

    private Date date;

    private UUID GUID;

    private List<XlsRow> xlsRowList;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "XlsFile{" +
                "date=" + date +
                ", GUID=" + GUID +
                ", xlsRowList=" + xlsRowList +
                '}';
    }

    public UUID getGUID() {
        return GUID;
    }

    public void setGUID(UUID GUID) {
        this.GUID = GUID;
    }

    public List<XlsRow> getXlsRowList() {
        return xlsRowList;
    }

    public void setXlsRowList(List<XlsRow> xlsRowList) {
        this.xlsRowList = xlsRowList;
    }

}
