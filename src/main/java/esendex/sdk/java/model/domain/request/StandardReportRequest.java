package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.types.DateRangeType;

import java.util.Date;

public class StandardReportRequest {
    private Date startDate;
    private Date endDate;
    private DateRangeType type;

    public StandardReportRequest(Date startDate, Date endDate, DateRangeType type) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setDateRangeType(DateRangeType type)
    {
        this.type = type;
    }

    public DateRangeType getDateRangeType()
    {
        return type;
    }
}
