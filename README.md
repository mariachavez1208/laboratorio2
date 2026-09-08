Análisis  

1. ¿Qué propiedades y métodos tendrá cada clase?

- Parque: nombre, código, encargado, puntos de acceso y visitantes. Tendrá métodos para administrar accesos, visitantes y generar reportes.
- PuntoAcceso: código, nombre, ubicación, capacidad y estado. Tendrá métodos para consultar y modificar sus datos.
- Visitante: código, nombre, edad, atracciones visitadas y puntos. Tendrá métodos para consultar y modificar su información.
- Main: contendrá el menú, la entrada de datos y el método principal.

2. ¿Qué tipos tendrán las propiedades y métodos?

Los textos serán String, los valores numéricos serán int y el promedio de edad será double. Los métodos devolverán el tipo correspondiente o void cuando solo realicen una acción.

3. ¿Qué propiedad utilizará un arreglo básico?

Los puntos de acceso se almacenarán en un arreglo de objetos PuntoAcceso, con un tamaño fijo de 5 posiciones.

4. ¿Qué propiedad utilizará un ArrayList?

Los visitantes se almacenarán en un ArrayList de objetos Visitante, porque su cantidad puede variar.

5. ¿Qué modificadores de visibilidad se utilizarán?

Los atributos serán private para mantener el encapsulamiento. Los constructores y métodos principales serán public. Los métodos auxiliares serán private.

6. ¿Qué parámetros requerirán los métodos?

Recibirán datos como posiciones, códigos, nombres, capacidad, estado, edad, atracciones visitadas y puntos acumulados, dependiendo de la operación.

7. ¿Cómo se inicializarán y validarán los objetos?

Los objetos se inicializarán mediante constructores. Se validará que la capacidad y la edad sean mayores que cero, que las atracciones y los puntos no sean negativos y que los textos no estén vacíos.

8. ¿Cómo se determinará si una posición contiene null?

Primero se verificará que la posición esté dentro de los límites del arreglo. Después, se comprobará si contiene un objeto o null antes de utilizarla.

9. ¿Cómo se operará dentro del ArrayList?

La búsqueda se realizará recorriendo los visitantes y comparando sus códigos. Al encontrar al visitante, se podrá modificar su información o eliminarlo del ArrayList.

10. ¿Qué situaciones pueden producir excepciones?

Una entrada numérica incorrecta producirá InputMismatchException. Los valores inválidos producirán IllegalArgumentException. También se controlarán posiciones inválidas, posiciones vacías y códigos repetidos mediante try-catch. Se utilizará finally para ejecutar una acción final después de cada operación.
