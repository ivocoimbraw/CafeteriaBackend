package com.si.apirest.model.dto;

import java.util.List;


import lombok.Data;

@Data
public class RolPerDTO {
    private int id;
    private String name;
    private List<PermissionDTO> permissions;
}
