package esendex.sdk.java.model.transfer.surveys;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.domain.response.StandardReportRow;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("response")
public class StandardReportDto {

    @XStreamImplicit(itemFieldName = "row")
    private List<StandardReportRowDto> rows;

    private List<SurveyReportErrorDto> errors;

    public List<StandardReportRowDto> getRows()
    {
        return rows == null ? new ArrayList<StandardReportRowDto>() : rows;
    }

    public List<SurveyReportErrorDto> getErrors()
    {
        return errors == null ? new ArrayList<SurveyReportErrorDto>() : errors;
    }
}
