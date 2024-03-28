## Welcome to [Nombre del Proyecto]!

Este proyecto sigue una estructura de ramas específica para el desarrollo y la implementación de nuevas funcionalidades o corrección de fallos. A continuación, se detallan las instrucciones para contribuir de manera efectiva al proyecto.

### Ramas del Proyecto

- **main**: Esta rama contiene la versión estable y lista para producción del proyecto. No se debe modificar directamente.
- **develop**: Rama de integración donde se combinan las nuevas funcionalidades. No se debe modificar directamente.
- **[nombre-de-tu-rama]**: Cada desarrollador debe crear su propia rama a partir de develop, con el nombre de la funcionalidad o fallo que se está abordando.

### Contribuir al Proyecto

Para contribuir al proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
   ```bash
   git clone [URL del repositorio]
   ```

2. Crea tu propia rama a partir de develop utilizando el siguiente comando (reemplaza `[nombre-de-tu-rama]` con el nombre de la funcionalidad o fallo):
   ```bash
   git checkout -b [nombre-de-tu-rama] develop
   ```

3. Realiza tus cambios y commits en tu rama. Asegúrate de mantener tu rama actualizada con los cambios en develop realizando un fetch regularmente:
   ```bash
   git fetch origin
   git rebase origin/develop
   ```

4. Si hay conflictos al actualizar tu rama con los cambios de develop, soluciónalos localmente en tu rama antes de hacer push:
   ```bash
   git rebase origin/develop
   ```

5. Una vez completados tus cambios y resueltos los conflictos, haz push de tu rama al repositorio remoto:
   ```bash
   git push origin [nombre-de-tu-rama]
   ```

6. Crea una solicitud de extracción (pull request) en GitHub para fusionar tus cambios en la rama develop. Describe detalladamente los cambios y espera la revisión del equipo.

Siguiendo estas instrucciones, contribuirás de manera ordenada y eficiente al desarrollo del proyecto, manteniendo la estabilidad de las ramas principales (main y develop) y facilitando la integración de nuevas funcionalidades y correcciones de errores. ¡Gracias por tu contribución! 😊🚀

### Resumen

## Ramas

- **main:** No tocar directamente. Es la rama estable del proyecto.
- **develop:** No tocar directamente. Es la rama de desarrollo principal.
- **tu-propia-rama:** Crea tu propia rama a partir de develop para trabajar en nuevas características o solucionar problemas.

## Actualizaciones

- Siempre que hayan actualizaciones en la rama develop, realiza un fetch y resuelve los conflictos en tu propia rama antes de fusionar.
- Mantén tu rama actualizada con las últimas mejoras del proyecto.

## Contribuciones

Cuando termines de hacer tu aporte crea un pull request desde tu rama hacia develop.

