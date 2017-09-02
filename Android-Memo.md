# Android Memo


### Android Development Process

![](assets/process.jpg)

### Java to APK Process Process

![](assets/code-flow.png)

#### Points to remember - 

- **AIDL**  - Android Interface Defination Language works between Native code (like .c, .cpp) and Source code (.java).<br><br>
- **.dex** - Dalvik Executable file. <br><br>
- **.AAPT** - Android Assets Packaging Tool kit, that helps to create .apk.<br><br>
- **.apk** - Just a packaged single file (like a zip) including .dex, .xml and some other resources.<br><br>
- **JVM** - Java Virtual Machine, to run .class file in java.<br><br>
- **DVM or ART since android 5.0-lollipop** - Dalvik Virtual Machine or Android Run Time, to run .dex files packaged under single .apk file (Note: .dex file can't run by JVM).<br><br> 
- **.JIT** - Just In Time used by DVM, It interpret to native code during run time.<br><br>    
- **.AOT** - Ahead Of Time used by ART, It compile to native code once at app installation time and keep in single ".oat" file for execution.<br><br> 

### Options to Identify an android device

- **IMEI** - International Mobile Equipment Identity, Its a telephony module (sim slot) based, never update until sim slot (h/w) change from device. <br><br>
- **Android ID** - Generates by android OS on first time boot, Can be change by Factory reset and by Rooted device. <br><br>
- **MAC Address of WiFi** - Its WiFi Module based, never update until wifi (h/w) change from device but need wifi enable to get. <br><br>
- **MAC Address of Bluetooth** - Its Bluetooth Module based, never update until bluetooth (h/w) change from device but need bluetooth enable to get. <br><br>

### Something about gradle dependencies
 
 - gradle file supports DSL (Domain Specific Language) and Java.<br><br>
 - eg - &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;junit : junit : 4.12   
 contains - Group id : Artifact id : Version <br><br>
 - Mostly gradle dependencies uploaded on Maven Repository Centers "jCenter" and "mavenCentral".<br><br>
 - jCenter - Hosted on bintray.com (default by android studio).<br><br>
 - mavenCentral - Hosted on sonatype.org.
 
 ### Something about gradle Fragment
 
 #### &nbsp;&nbsp;&nbsp;&nbsp;Why we should use?
 - **Reusability** - One Fragment can use by multiple Activities.<br><br>
 - **Flexibility** - One Activity can use by multiple Fragments.<br><br>
 - **Dynamically Handling** - Add/Rplace/Remove dynamically while Activity is running.
 
 #### &nbsp;&nbsp;&nbsp;&nbsp;Lifecycle
 
1. onAttach()
2. onCreate() ***--> Can restore data***
3. onCreateView()
4. onViewCrated()
5. onActivityCreated() ***--> Can restore data***
6. onStart()
7. onResume() ---> ideal condition <br><br>
   - On replace/add next Fragment these 7 methods would be repeat for next Fragment.<br>
   - And this below 2 methods would be call on this Fragment. <br><br> 
8. onPause()    
9. onStop() <br><br>
   - If remove this Fragment below 2 methods would be call on this Fragment.<br><br> 
10. onDestroyView()   
    ***onSaveInstanceState() --> Can call any time before onDestroy.***
11. onDestroy()   
12. onDetach()   
   