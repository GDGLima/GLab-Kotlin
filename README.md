# GLab-Kotlin GDGLima 2017

GLab sobre Kotlin

![alt text](./images/gdglima-glabkotlin.png)

## Resumen

Este codelab está enfocado al desarrollo de aplicaciones Android usando Kotlin. Iniciaremos con una introducción a este lenguaje , sus características, ventajas, interoperabilidad y diferencias con java. Luego, usaremos Android Studio para implementar  un ejemplo práctico de una aplicación Android desarrollada con Kotlin.

## [1] Bienvenido

Bienvenido al CodeLab de Kotlin , antes de empezar y para tener todo listo  para el CodeLab,  te recomiendo revisar lo siguiente :

### [1.1] Requisitos

 * IDE , vamos a usar Android Studio versión 2.3.3

 * Kotlin Plugin , vamos a usar un plugin para poder construir un proyecto en Kotlin en  Android Studio. La versión que usaremos será v1.1.4-Release-studio2.3-3

 * Descargar los files del CodeLab , para esto seleccionas CLONE OR DOWNLOAD /DOWNLOAD ZIP o desde el siguiente link
 ```
  https://github.com/GDGLima/GLab-Kotlin/archive/master.zip
 ```
 <img src="./images/files-codelab1.png" height="360">

 * Explorar el CodeLab , en los files del CodeLab vamos a encontrar lo siguiente :

  * La carpeta  "/KotlinTemplate"
  * La carpeta  "/GDGLimaApp"
  * La carpeta "/images"
  * Los archivos "README.md" y "TipsAndTricks.md"


 * Proyecto Template , en los archivos de este codelab se encuentra un  proyecto base  llamado "KotlinTemplate" . Para poder abrirlo desde Android Studio seleccionas FILE / OPEN / KotlinTemplate . Al abrirlo la primera vez te va pedir descargar dependencias , para esto debes estar conectado a internet.

 <img src="./images/template-project.png" height="360">

  * Ejecutar el ejemplo , antes de correr nuestra app vamos a necesitar un emulador. En este [link](https://developer.android.com/studio/run/emulator.html) puedes encontrar información de como crear y configurar un emulador , también si deseas pueden usar [Genymotion](https://www.genymotion.com/) . Finalmente para ejecutar el proyecto seleccionamos :

  ```
      Run / Run App
  ```
  <img src="./images/kotlin-template-app.png" height="360"> <img src="./images/kotlin-template-app1.png" height="360"> <img src="./images/kotlin-template-app2.png" height="360">

### [1.2] Aprende sobre Kotlin

  * Kotlin es bastante amplio y trae consigo conceptos nuevos, por lo que sería genial que vayas leyendo un poco sobre este lenguaje de programación. Para esto te recomiendo visitar la pagina oficial, donde encontrarás todo lo que necesitas y más, de hecho tiene muy buena documentación.

  ```
     https://kotlinlang.org/docs/reference/
  ```
  * Aprendamos sobre este lenguaje de programación, hagamos un review de Kotlin [ReviewKotlin](./ReviewKotlin.md)

## [2] Instala Android Studio

  * Trabajaremos con la versión 2.3.3 de Android Studio que pueden descargar desde aquí https://developer.android.com/studio/index.html . Esta versión requiere de un plugin para poder usar Kotlin.
  * La versión 3.0+ de Android Studio ya soporta Kotlin pero aún esta en beta. Pueden encontrar más información en el siguiente link https://developer.android.com/studio/preview/index.html

## [3] Crea tu primer proyecto y configura el plugin de Kotlin

#### [3.1] Crea un nuevo proyecto con Android Studio

  * Paso 1 : Start a new Android Studio project

  * Paso 2 : Configure you new project
    * Application name : KotlinTemplate
    * Company domain : emedinaa.com
    * Package name : com.emedinaa.infosoft.kotlintemplate
    * Project location : ..GLabKotlin/repo/KotlinTemplate

  * Paso 3 : Minimum SDK

    * API 15 - Android 4.0.3

  * Paso 4 : Add an Activity

    * Empty Activity

  * Paso 5 : Customize de Activity

    <img src="./images/android-project1.png" height="360">

    <img src="./images/android-project2.png" height="360">

    <img src="./images/android-project3.png" height="360">


#### [3.2] Instala el plugin de Kotlin para Android Studio

  * Android Studio / Preferences / Plugins / Browse repositories / Kotlin / install
  * La versión del plugin que vamos a utilizar es v1.1.4-Release-studio2.3-3
  * Reiniciar Android Studio

  <img src="./images/kotlin-plugin.png" height="240">

#### [3.3] Configura el proyecto para trabajar con Kotlin

  * Tools / Kotlin / Configure project in Kotlin
  * Configuration / Android with Gradle
  * Configure Kotlin with Android with Gradle / All Modules / version 1.1.4-3
  * Se cambia la configuración de nuestro proyecto y debemos sincronizar (Gradle)

  <img src="./images/kotlin-configure.png" height="240">

  <img src="./images/kotlin-android-configure.png" height="200">

#### [3.4] Revisa los cambios realizados en el proyecto

  * En el <b>build.gradle</b> del proyecto vemos los siguientes cambios :
  ```groovy
    buildscript {

      ext.kotlin_version = '1.1.4-3'

      repositories {
          jcenter()
      }
      dependencies {
          classpath 'com.android.tools.build:gradle:2.3.3'
          classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

      }

  ```

  * y en el <b>build.gradle</b> de la App (app/build.gradle)
  ```groovy
    apply plugin: 'kotlin-android'
    ...

    dependencies {
        compile fileTree(dir: 'libs', include: ['*.jar'])
        androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
            exclude group: 'com.android.support', module: 'support-annotations'
        })
        compile 'com.android.support:appcompat-v7:26.+'
        compile 'com.android.support.constraint:constraint-layout:1.0.2'
        testCompile 'junit:junit:4.12'
        compile "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
    }

  ```

#### [3.5] Agrega Kotlin Android Extensions

* Kotlin nos da herramientas para agilizar el desarrollo en Android , este conjunto de utilizarios se encuentran en el plugin llamado "Kotlin Android Extensiones"

* En el build.gradle de la app agregamos
```
  apply plugin: 'com.android.application'
  apply plugin: 'kotlin-android'
  apply plugin: 'kotlin-android-extensions'
```

* Si deseas conocer más sobre Kotlin Android Extensions , revisa este [link](https://kotlinlang.org/docs/tutorials/android-plugin.html)

#### [3.6] Conoce algunos tips y trucos

* El plugin de Kotlin en Android Studio integra una serie de herramientas para facilitar el desarrollo de Android en este IDE , por lo que recopilé algunos tips y trucos que te pueden servir [TipsAndTricks](./TipsAndTricks.md)