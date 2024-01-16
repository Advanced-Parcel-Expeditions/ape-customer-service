package si.ape.customer.models.converters;

import si.ape.customer.models.entities.BranchTypeEntity;
import si.ape.customer.lib.BranchType;

public class BranchTypeConverter {

    public static BranchType toDto(BranchTypeEntity entity) {

        BranchType dto = new BranchType();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;

    }

    public static BranchTypeEntity toEntity(BranchType dto) {

        BranchTypeEntity entity = new BranchTypeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;

    }


}
