# CodeLab Kotlin - Infosoft 2017

## Review Kotlin

### [1] Sintaxis básica

```
  val i = 10
  val s = "Hello Kotlin"
```

```
  val a: Int = 1  // immediate assignment
  val b = 2   // `Int` type is inferred
  val c: Int  // Type required when no initializer is provided
  c = 3       // deferred assignment
```

Null Safety
```
  var a: String = "abc"
  a = null // compilation error
```

```
  var b: String? = "abc"
  b = null // ok
```

```
  v al l: Int = if (b != null) b.length else -1
```

```
  val l = b?.length ?: -1
```

```
  val l = b!!.length
```

If Expression

```
  var max: Int
  if (a > b) {
      max = a
  } else {
      max = b
  }
```

When Expression ( Switch)
```
  when (x) {
      1 -> print("x == 1")
      2 -> print("x == 2")
      else -> { // Note the block
          print("x is neither 1 nor 2")
      }
  }
```
Loops

```
  for (item in collection) print(item)
```

```
  for (item: Int in ints) {
      // ...
  }
```

### [2] Colecciones

```
  val items = listOf("apple", "banana", "kiwi")
  for (item in items) {
      println(item)
  }
```

```
  ints.forEach(fun(value: Int) {
          if (value == 0) return  // local return to the caller of the anonymous fun, i.e. the forEach loop
          print(value)
      })
```

### [3] Métodos y Funciones

Funciones
```
  fun sum(a: Int, b: Int): Int {
      return a + b
  }
```

```
  fun sum(a: Int, b: Int) = a + b
```

```
  fun printSum(a: Int, b: Int) {
      println("sum of $a and $b is ${a + b}")
  }
```

### [4] Clases y Objetos

Class

```
  class Person(firstName: String) {
  }
```

```
  class Customer(name: String) {
      init {
          logger.info("Customer initialized with value ${name}")
      }
  }
```

```
  class MyView : View {
      constructor(ctx: Context) : super(ctx)

      constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
  }
```

```
    class MainActivity: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }
    ...
```
Interface

```
  interface DataCallback {

      fun onDataSuccess(obj:Any)
      fun onDataError(obj:Any)
  }
```

```
   interface ServicesApiInterface {

          @POST("/api/login")
          fun logIn(@Body raw: UserRaw): Call<UserReponse>

          @POST("/api/register")
          fun register(@Body raw: UserRaw): Call<UserReponse>

          @GET("/api/subjects")
          fun subjects(): Call<SubjectReponse>

          @GET("/api/questions")
          fun questions(): Call<QuestionReponse>
  }
```

Data Class 

```java
      class Book {
          private String title;
          private Author author;

          public String getTitle() {
              return title;
          }

          public void setTitle(String title) {
              this.title = title;
          }

          public Author getAuthor() {
              return author;
          }

          public void setAuthor(Author author) {
              this.author = author;
          }
      }
```

```
  data class Book(var title: String, var author: Author)
```

Agrupar Data Classes 

AppModel.kt

```
    data class User(val id:String?,val username:String, val password:String,val firstname:String,
                    val lastname:String):Serializable

    data class Subject(val id:String, val name:String, val color:String):Serializable

    data class Question(val id:String, val subjectId:String, val levelId:Int,
    val title:String,val options:String, val format:String):Serializable
```

### [5] Interoperabilidad con Java

Call Java from Kotlin

```
  import java.util.*

  fun demo(source: List<Int>) {
      val list = ArrayList<Int>()
      // 'for'-loops work for Java collections:
      for (item in source) {
          list.add(item)
      }
      // Operator conventions work as well:
      for (i in 0..source.size - 1) {
          list[i] = source[i] // get and set are called
      }
  }
```

### [6] Extension functions

Extensions.kt

```
  fun monthByValue(month:String):String{
      when(month){
          "01"-> return "ENE"
          "02"-> return "FEB"
          "03"-> return "MAR"
          "04"-> return "ABR"
          "05"-> return "MAY"
          "06"-> return "JUN"
          "07"-> return "JUL"
          "08"-> return "AGO"
          "09"-> return "SEP"
          "10"-> return "OCT"
          "11"-> return "NOV"
          "12"-> return "DIC"
      }
      return ""
  }
```

```
  fun log(lambda: () -> String) {
      if (BuildConfig.DEBUG) {
          Log.d("TAG", lambda())
      }
  }
```

### [7] Sigue aprendiendo

* Página Oficial de Kotlin [https://kotlinlang.org/docs/reference/](https://kotlinlang.org/docs/reference/)

* Tutoriales [https://kotlinlang.org/docs/tutorials/](https://kotlinlang.org/docs/tutorials/)

* Kotlin Workshop - JetBrains [https://github.com/JetBrains/kotlin-workshop](https://github.com/JetBrains/kotlin-workshop)

* Ejemplos en github sobre Kotlin de JetBrains [https://github.com/JetBrains/kotlin-examples](https://github.com/JetBrains/kotlin-examples)

* Google CodeLabs (Kotlin) [https://codelabs.developers.google.com/](https://codelabs.developers.google.com/)

* Android Developers
[https://developer.android.com/kotlin/get-started.html](https://developer.android.com/kotlin/get-started.html)
