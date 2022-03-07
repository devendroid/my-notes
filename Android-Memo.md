# Android Basics


### Android Development Process

![](assets/process.jpg)

### Java to APK Process

![](assets/code-flow.png)

### Terms to remember - 

- **AIDL**  - Android Interface Defination Language works between Native code (like .c, .cpp) and Source code (.java).
- **.dex** - Dalvik Executable file.
- **AAPT** - Android Assets Packaging Tool kit, that helps to create .apk.
- **.apk** - Just a packaged single file (like a zip) including .dex, .xml and some other resources.
- **JVM** - Java Virtual Machine, to run .class file in java.
- **DVM or ART (from android 5.0-lollipop)** - Dalvik Virtual Machine or Android Run Time, to run .dex files packaged under single .apk file (Note: .dex file can't run by JVM).
- **.JIT** - Just In Time used by DVM, It interpret to native code during run time. 
- **.AOT** - Ahead Of Time used by ART, It compile to native code once at app installation time and keep in single ".oat" file for execution.
- **IMEI** - International Mobile Equipment Identity, Its a telephony module (sim slot) based, never update until sim slot (h/w) change from device.
- **Android ID** - Generates by android OS on first time boot, Can be change by Factory reset and by Rooted device.
- **MAC Address of WiFi** - Its WiFi Module based, never update until wifi (h/w) change from device but need wifi enable to get.
- **MAC Address of Bluetooth** - Its Bluetooth Module based, never update until bluetooth (h/w) change from device but need bluetooth enable to get.
 - **Gradle** - Gradle is a open source build automation tool, gradle file supports DSL (Domain Specific Language) and Java.
 - A android gradle dependency looks like - {Group id}:{Artifact id}:{Version} , eg - junit:junit:4.12   
 - Mostly gradle dependencies uploaded on Maven Repository Centers "jCenter" and "mavenCentral".
 - jCenter - Hosted on bintray.com
 - mavenCentral - Hosted on sonatype.org.(default by android studio).
 
 ### Fragment
 #### &nbsp;&nbsp;&nbsp;&nbsp;Why we should use?
 - **Reusability** - One Fragment can use by multiple Activities.
 - **Flexibility** - One Activity can use multiple Fragments.
 - **Dynamically Handling** - Add/Replace/Remove dynamically while Activity is running.
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
   - If remove this Fragment below methods would be call on this Fragment.<br><br> 
10. onDestroyView()   
    ***onSaveInstanceState() --> Can call any time before onDestroy.***
11. onDestroy()   
12. onDetach()   
   
### Background Task Evolution  

1. Thread
2. AsynchTask
3. Service
4. IntentService
5. Loader - CursorLoader/AsynchTaskLoader
6. JobService and Job Schedular (from lolipop)
7. **RxJava/Andoid** - Java/Android implementation of **ReactiveX (Reactive Extensions)** ( a library for composing asynchronous and event-based programs by using observable sequences). Its based on **Observer Pattern**
8. Coroutine: A lightweight thread to do asynchronous task/job.

### Android Architecture Components

Android software components have been arranged in 4 categories in which one of the categories is **Architecture Components**. Other categories are Foundation Components, Behavior Components and UI Components.<br>
Android architecture components are a collection of libraries that help you design robust, testable, and maintainable apps.<br><br>
**Note:** Now AAC is a part of Android Jetpack.

### Android Jetpack

Android Jetpack is a collection of Android software components that also known as Android Jetpack components which helps developers to follow best practices and build great Android apps.

#### Android Jetpack Components
Android Jetpack components are a collection of libraries, tools and guidance that are individually adoptable and built to work together while taking advantage of Kotlin language features that make us more productive.<br>
These libraries comes under the **androidx.*** package and these are unbundled from the platform APIs, therefore it offers backward compatibility as well.<br>
These software components have been arranged in 4 categories which are as follows:

**1. Foundation Components -**

- [App Compat](https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat "App Compat") Degrade gracefully on older versions of Android with material design user interface implementation support.
- [Android KTX](https://developer.android.com/kotlin/ktx "Android KTX") Set of Kotlin extensions to write more concise, idiomatic Kotlin code.
- [Multidex](https://developer.android.com/studio/build/multidex "Multidex") Provide support for multiple dex files for apps.
- [Test](https://developer.android.com/training/testing/ "Test") A testing framework for unit and runtime UI tests in Android.
- And many more....
    
**2. Architecture Components -**

- [Data Binding](https://developer.android.com/topic/libraries/data-binding/ "Data Binding") Declaratively bind UI elements to in our layout to data sources of our app.
- [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle "Lifecycles") Manages activity and fragment lifecycles of our app.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata "LiveData") Notify views of any database changes.
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/ "Navigation") Handle everything needed for in-app navigation.
- [Paging](https://developer.android.com/topic/libraries/architecture/paging/ "Paging") Gradually load information on demand from your data source.
- [Room](https://developer.android.com/topic/libraries/architecture/room "Room") Fluent SQLite database access.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel "ViewModel") Manage UI-related data in a lifecycle-conscious way.
- [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager/ "WorkManager") Manage every background jobs in Android with the circumstances we choose.
- And many more....

**3. Behavior Components -**

- [Download Manager](https://developer.android.com/reference/android/app/DownloadManager "Download Manager") Schedule and manage large downloads in background with auto retry support.
- [Media & playback](https://developer.android.com/guide/topics/media-apps/media-apps-overview "Media & playback") Backwards compatible APIs for media playback and routing (including Google Cast).
- [Notifications](https://developer.android.com/guide/topics/ui/notifiers/notifications "Notifications") Provides a backwards-compatible notification API with Wear and Auto support.
- [Permissions](https://developer.android.com/guide/topics/permissions/overview "Permissions") Compatibility APIs for checking and requesting permissions in app.
- [Preferences](https://developer.android.com/guide/topics/ui/settings "Preferences") Create interactive settings screens for users to configure.
- [Sharing](https://developer.android.com/training/sharing/shareaction "Sharing") Provides a share action suitable for an app’s action bar.
- [Slices](https://developer.android.com/guide/slices "Slices") Create flexible UI elements that can display app data outside the app and can be extended all the way back to Android 4.4.
- And many more....

**4. UI Components -**

- [Animation and transitions](https://developer.android.com/training/animation/ "Animation and transitions") Move widgets and transition between screens.
- [Auto](https://developer.android.com/auto "Auto") Components to develop Android Auto apps.
- [Emoji](https://developer.android.com/guide/topics/ui/look-and-feel/emoji-compat "Emoji") Enable updated emoji font on older platforms.
- [Fragment](https://developer.android.com/guide/components/fragments "Fragment") A basic unit of composable UI.
- [Layout](https://developer.android.com/guide/topics/ui/declaring-layout "Layout") Lay out widgets with different algorithms.
- [Palette](https://developer.android.com/training/material/palette-colors "Palette") Pull useful information from color palettes.
- [TV](https://developer.android.com/tv/ "TV") Components to develop Android TV apps.
- [Wear](https://developer.android.com/wear/ "Wear") Components to develop Wear apps.
- And many more....

