# Constitución del Proyecto

## Principios

1. El dominio no depende de Spring.
2. Todo endpoint debe documentarse con OpenAPI.
3. Toda clase pública requiere JavaDoc.
4. Todo caso de uso equivale a una clase.
5. No usar LocalDateTime.now(); utilizar Clock.
6. Los DTO serán Records.
7. Los mappers serán MapStruct.
8. Las excepciones serán específicas por módulo.
9. La comunicación entre módulos será mediante interfaces.
10. Cada cambio importante tendrá un ADR.