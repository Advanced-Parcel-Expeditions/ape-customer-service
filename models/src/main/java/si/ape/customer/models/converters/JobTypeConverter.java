package si.ape.customer.models.converters;

import si.ape.customer.lib.JobType;
import si.ape.customer.models.entities.JobTypeEntity;

public class JobTypeConverter {

    public static JobType toDto(JobTypeEntity entity) {

        JobType dto = new JobType();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;

    }

    public static JobTypeEntity toEntity(JobType dto) {

        JobTypeEntity entity = new JobTypeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;

    }

}
