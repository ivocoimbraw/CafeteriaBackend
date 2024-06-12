package com.si.apirest.model.enums;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Permission {
    VER_BITACORA,
    VER_DEPARTAMENTO,
    VER_CATEGORIA,
    VER_DESCUENTO,
    VER_INVENTARIO,
    VER_NOTA_INGRESO,
    VER_PRODUCTO,
    VER_ROLES,
    VER_PERMISOS,
    VER_NOTA_VENTA,
    VER_TIPO_PAGO,
    VER_USUARIOS,
    VER_ADMINISTRAR_VENTA,
    VER_VENTA_DE_PRODUCTO,
    VER_DASHBOARD,
    VER_HOME;

    static {
        permissionListEnums = Arrays.stream(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    private static final List<String> permissionListEnums;

    // Método para obtener la lista de nombres de permisos
    public static List<String> getAllPermissionNames() {
        return permissionListEnums;
    }

}
