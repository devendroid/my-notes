# Android To Do

### For best practice

* **Networking** - okhttp, Retrofit, Volley
* **Parsing** - gson by google
* **Image Loading/Processing** - picaso
* **Memory Analysis** - Leak canary
* **ORM** - Sugar ORM
* **Unit testing** -
* **Proguard** - 
* **Zip align** - (On signed build only)
* **Patterns** - MVC, MVP, MVVM
* **Using Lint** - 
* **RX Java** - 
* **.exo file** - (Used by you tube)
* **DDA/DPP** - 
* **Dagger/Dagger2** - Dependency Injection 
* **Android USB and Host Framework** -  
* **Android RPC Framework** - 
* **AIDL and Service Framework** - 
* **Optimizes data container** - 
* **OpenGL** -

### Precaution for memory leak

- **Static Activity** - Use weak references.
- **Static View** - Set null in onDestroy().
- **Inner Class** - Don't create static reference in outer class.
- **Anonymous Class** - Create separate static inner class instead.
- **Note** - Non static inner class and Anonymous class holds a implicit reference of its outer class.

 