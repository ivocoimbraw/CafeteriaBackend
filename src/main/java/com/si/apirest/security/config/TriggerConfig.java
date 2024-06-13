package com.si.apirest.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

public class TriggerConfig {

    private JdbcTemplate jdbcTemplate;

    public void createTriggers() {
        createTriggerCrearInventario();
        createTriggerActualizarInventario();
        createTriggerActualizarInventarioDeleteIngreso();
        createTriggerActualizarInventarioDelete();
        createTriggerDescontarInventario();
    }

    private void createTriggerCrearInventario() {
        String createTriggerSQL = "CREATE TRIGGER crear_inventario_despues_insertar_producto "
                                + "AFTER INSERT ON PRODUCTO "
                                + "FOR EACH ROW "
                                + "BEGIN "
                                + "INSERT INTO INVENTARIO (id, cantidad, id_producto) VALUES (NEW.id, 0, NEW.id); "
                                + "END;";
        executeTrigger(createTriggerSQL);
    }

    private void createTriggerActualizarInventario() {
        String createTriggerSQL = "CREATE TRIGGER actualizar_inventario "
                                + "AFTER INSERT ON DETALLE_INGRESO "
                                + "FOR EACH ROW "
                                + "BEGIN "
                                + "UPDATE INVENTARIO SET cantidad = cantidad + NEW.cantidad WHERE id = NEW.id_inventario; "
                                + "END;";
        executeTrigger(createTriggerSQL);
    }

    private void createTriggerActualizarInventarioDeleteIngreso() {
        String createTriggerSQL = "CREATE TRIGGER actualizar_inventario_delete_ingreso "
                                + "AFTER DELETE ON DETALLE_INGRESO "
                                + "FOR EACH ROW "
                                + "BEGIN "
                                + "UPDATE INVENTARIO SET cantidad = cantidad - OLD.cantidad WHERE id = OLD.id_inventario; "
                                + "END;";
        executeTrigger(createTriggerSQL);
    }

    private void createTriggerActualizarInventarioDelete() {
        String createTriggerSQL = "CREATE TRIGGER actualizar_inventario_delete "
                                + "AFTER DELETE ON DETALLE_EGRESO "
                                + "FOR EACH ROW "
                                + "BEGIN "
                                + "UPDATE INVENTARIO SET cantidad = cantidad + OLD.cantidad WHERE id = OLD.id_inventario; "
                                + "END;";
        executeTrigger(createTriggerSQL);
    }

    private void createTriggerDescontarInventario() {
        String createTriggerSQL = "CREATE TRIGGER descontar_inventario "
                                + "AFTER INSERT ON DETALLE_EGRESO "
                                + "FOR EACH ROW "
                                + "BEGIN "
                                + "DECLARE current_cantidad INT; "
                                + "SELECT cantidad INTO current_cantidad FROM INVENTARIO WHERE id = NEW.id_inventario; "
                                + "IF NEW.cantidad > current_cantidad THEN "
                                + "SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cantidad en inventario insuficiente'; "
                                + "ELSE "
                                + "UPDATE INVENTARIO SET cantidad = cantidad - NEW.cantidad WHERE id = NEW.id_inventario; "
                                + "END IF; "
                                + "END;";
        executeTrigger(createTriggerSQL);
    }

    private void executeTrigger(String triggerSQL) {
        try {
            jdbcTemplate.execute(triggerSQL);
            System.out.println("Trigger created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating trigger: " + e.getMessage());
        }
    }
}
