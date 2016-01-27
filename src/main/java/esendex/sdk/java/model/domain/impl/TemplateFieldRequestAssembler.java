package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.surveys.TemplateFieldDto;
import esendex.sdk.java.model.transfer.surveys.TemplateFieldsDto;

import java.util.ArrayList;
import java.util.List;

public class TemplateFieldRequestAssembler {

    public TemplateFieldsDto create(List<TemplateField> tf)
    {
        TemplateFieldsDto templateFieldsDto = new TemplateFieldsDto();
        List<TemplateFieldDto> templateFieldDtos = new ArrayList<>();

        for (TemplateField currentField : tf) {

            TemplateFieldDto dto = new TemplateFieldDto();

            dto.setName(currentField.getName());
            dto.setValue(currentField.getValue());
            templateFieldDtos.add(dto);
        }
        templateFieldsDto.setTemplateField(templateFieldDtos);

        return templateFieldsDto;
    }
}
