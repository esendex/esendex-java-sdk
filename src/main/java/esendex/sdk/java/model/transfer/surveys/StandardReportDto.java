package esendex.sdk.java.model.transfer.surveys;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

public class StandardReportDto {

    @XStreamImplicit(itemFieldName = "row")
    private List<StandardReportRowDto> rows;

    public List<StandardReportRowDto> getRows()
    {
        return rows == null ? new ArrayList<StandardReportRowDto>() : rows;
    }
}
