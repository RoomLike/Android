package com.darkheaven.roomlike.object;

/**
 * Created by tinyiota on 6/17/16.
 */
public class HelpItem {
    String header;
    String detail;

    public HelpItem(){}

    public HelpItem(String header, String detail) {
        this.header = header;
        this.detail = detail;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
