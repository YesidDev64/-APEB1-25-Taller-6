#Taller: Persistencia de Datos en Java – Caso "Taller Padel"
##Resumen de la Tarea
El #Taller Padel# es una actividad de laboratorio técnico enfocada en la implementación de mecanismos de persistencia en Java. Los estudiantes desarrollarán un sistema capaz de guardar y recuperar información de partidos de pádel, permitiendo que el estado de los objetos persista incluso después de que la ejecución del programa haya finalizado.

##Contexto del Problema
La organización de un torneo de pádel requiere un sistema robusto para registrar los enfrentamientos. El estudiante deberá modelar una clase PartidoPadel que almacene los nombres de las parejas y el marcador final. La tarea consiste en comparar dos formas de almacenar esta información:

#1. Serialización Binaria (.dat):# Para un almacenamiento rápido, eficiente y exclusivo para la aplicación Java.

#2. Persistencia en Texto Plano (.txt):# Para un almacenamiento legible, útil para exportar reportes o interoperar con otros sistemas (como hojas de cálculo).

##Entregables
Para completar satisfactoriamente esta tarea, el estudiante deberá entregar:

#1. Código Fuente:# Proyecto Java completo que incluya:

 -Clase modelo PartidoPadel correctamente encapsulada e implementando Serializable.

 -Clase GestorPadelBinario con métodos para guardar/cargar objetos.

 -Clase GestorPadelTexto con métodos para escritura/lectura en formato plano.

 -Clase Main que demuestre el flujo completo (creación, guardado, carga y visualización).

#2. Informe de Resultados (Breve):# Un documento (o comentario en el código) donde el estudiante responda:

 -¿Qué sucede si intentas abrir el archivo .dat con un editor de texto?

 -¿Cuál es el principal inconveniente de usar .txt frente a .dat cuando el sistema crece en complejidad (muchos atributos o clases relacionadas)?

##Competencias a Desarrollar
#Gestión de Archivos:# Dominio del paquete java.io y manejo de flujos de datos (streams).

#Persistencia de Objetos:# Entendimiento de la serialización nativa de Java.

#Manipulación de Cadenas:# Habilidades de parsing y formateo de datos para archivos de texto.

#Buenas Prácticas:# Manejo adecuado de excepciones y uso de la interfaz Serializable.

##Entregar:

1. Repositorio en git.

2. Proyecto comprimido.

3. Informe -> en .pdf
