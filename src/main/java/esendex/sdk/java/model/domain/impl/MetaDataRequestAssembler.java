package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.surveys.MetaDataDto;
import esendex.sdk.java.model.transfer.surveys.MetaDataItemDto;

import java.util.ArrayList;
import java.util.List;

public class MetaDataRequestAssembler {

    public MetaDataDto create(List<MetaData> metaData)
    {
        MetaDataDto metaDataDto = new MetaDataDto();
        List<MetaDataItemDto> metaDataItemDtos = new ArrayList<>();

        for (MetaData item : metaData) {

            MetaDataItemDto dto = new MetaDataItemDto();

            dto.setName(item.getName());
            dto.setValue(item.getValue());
            metaDataItemDtos.add(dto);
        }
        metaDataDto.setMetaData(metaDataItemDtos);

        return metaDataDto;
    }
}
