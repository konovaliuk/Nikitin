package com.peregrine.getfit.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTag extends SimpleTagSupport {
    private String mFormat;

    public void setFormat(String pFormat) {
        mFormat = pFormat;
    }


    @Override
    public void doTag() throws JspException {
        try {
            Date today = new Date();
            SimpleDateFormat dateFormatter = new SimpleDateFormat(mFormat);
            getJspContext().getOut().write(dateFormatter.format(today));

        } catch(IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }

    }
}
