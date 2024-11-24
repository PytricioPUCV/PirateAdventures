# 🏝️ Pirate Adventures 🏝️

Embárcate en una aventura épica como el **Capitán Flameheart**:pirate_flag:, un joven pirata decidido a forjar su propia leyenda. Ayúdale a robar valiosos tesoros mientras evitas peligros mortales y objetos malditos que podrían acabar con su vida. ¡Conviértete en el pirata más temido de los siete mares!

## 🔧 Instalación

**Requisitos**:

- **Java**: JDK versión 17 o 21.
- **LibGDX**: framework de desarrollo de juegos en Java que está utilizado en el proyecto.
- **Eclipse** / **IntellIJ IDE**: Entorno de Desarrollo Integrado a elección.

## 🏗️ Desarrollo

Se han utilizado diversas herramientas y bibliotecas en este proyecto para facilitar su desarrollo.   

- **Java**: Lenguaje de programación utilizado para desarrollar el proyecto del videojuego en su versión **22.0.1**.  
  [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)

- **Eclipse IDE**: Utilizado para el desarrollo inicial, configuración base e importación de LibGDX.  
  [![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)](https://eclipseide.org/)
  
- **IntelliJ IDE**: Utilizado como IDE principal durante el transcurso del desarrollo.   
  [![IntelliJ](https://img.shields.io/badge/IntelliJ_IDE-326edd.svg?style=for-the-badge&logo=intellijidea&logoColor=white)](https://www.jetbrains.com/idea/)

- **LibGDX**: Framework de desarrollo de videojuegos utilizado para desarrollar este proyecto.   
  [![LibGDX](https://img.shields.io/badge/LibGDX-DA0C1F?style=for-the-badge&logoColor=white)](https://github.com/libgdx/gdx-liftoff)

- **Graddle**: Herramienta de automatización de construcción para gestionar dependencias y simplificar procesos de compilación.  
  [![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)](https://gradle.org/)

# Instrucciones para ejecutar el proyecto de LibGDX

## **Configuración en IntelliJ IDEA (recomendado)** [![IntelliJ](https://img.shields.io/badge/IntelliJ_IDE-326edd.svg?style=for-the-badge&logo=intellijidea&logoColor=white)](https://www.jetbrains.com/idea/)

### 1. Descargar IntelliJ IDEA
- Descarga e instala IntelliJ IDEA desde [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/). La versión Community es suficiente.

### 2. Extraer el proyecto
- Extrae el archivo `.winrar` descargado de GitHub en una carpeta de tu elección.

### 3. Abrir el proyecto en IntelliJ
- Abre IntelliJ IDEA.
- Ve a **File > Open**.
- Navega a la carpeta donde extrajiste el proyecto y selecciona la carpeta principal (que contiene `gradle`, `idea`, `assets`, etc.).
- Haz clic en **OK**.

### 4. Configurar el proyecto
- IntelliJ debería detectar automáticamente que es un proyecto Gradle.
- Si te pregunta, selecciona la opción para importar el proyecto como un proyecto Gradle.
- Espera a que IntelliJ sincronice las dependencias y configure el proyecto.

### 5. Ejecutar el juego
- En el menú lateral izquierdo, navega a `lwjgl3/src/main/java/io.github.some_example_name.lwjgl3`.
- Haz clic derecho en el archivo **`Lwjgl3Launcher.java`**.
- Selecciona **Run 'Lwjgl3Launcher.main()'**.
- El juego debería ejecutarse correctamente.

---

## **Configuración en Eclipse**  [![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)](https://eclipseide.org/)

### 1. Descargar Eclipse
- Descarga e instala Eclipse desde [Eclipse IDE](https://www.eclipse.org/downloads/). Asegúrate de elegir la versión para desarrollo Java (Eclipse IDE for Java Developers).

### 2. Extraer el proyecto
- Extrae el archivo `.winrar` descargado de GitHub en una carpeta de tu elección.

### 3. Importar el proyecto en Eclipse
- Abre Eclipse.
- Ve a **File > Import > Existing Gradle Project**.
- En la ventana emergente, haz clic en **Browse** y selecciona la carpeta principal donde extrajiste el proyecto.
- Haz clic en **Finish** para importar el proyecto.

### 4. Ejecutar el juego
- Navega a `lwjgl3/src/main/java/io.github.some_example_name.lwjgl3`.
- Haz clic derecho en el archivo **`Lwjgl3Launcher.java`**.
- Selecciona **Run As > Java Application**.
- El juego debería ejecutarse.

---

## **Notas adicionales**
- Si bien **Eclipse** fue el IDE en el que se empezó el proyecto, **IntelliJ IDEA**, gracias a algunas ventajas, se convirtió en el IDE principal durante el desarrollo. Por esta razón, se recomienda usar IntelliJ para evitar problemas de configuración y asegurar una experiencia más fluida.
- Si encuentras problemas con dependencias, ejecuta el comando `./gradlew build` en la terminal dentro de la carpeta principal del proyecto para actualizarlas.

---


## 👥 Integrantes
    Bastián Mejías
    Patricio Hernández
    Simón Vera

## ⚙️ Usage

Este proyecto está licenciado bajo la Licencia MIT, lo que te permite usar, modificar y distribuir el software libremente. Para más detalles, consulta [aquí](https://opensource.org/osd).
