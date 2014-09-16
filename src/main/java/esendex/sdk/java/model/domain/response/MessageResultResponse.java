package esendex.sdk.java.model.domain.response;

import java.util.List;

public interface MessageResultResponse {

	String getBatchId();

	List<ResourceLinkResponse> getMessageIds();

}