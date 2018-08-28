### The following pages are reference for TDD understanding.
### This is a  collection of samples demonstrating different frameworks and techniques for automated testing in Android.


Mediam blogs:
**[android-testing-Medium_guidance](https://medium.com/@nileshjarad)** - A good tutorial from Mr.Nilesh for testing

**[android-testing-Medium_guidance all parts](https://medium.com/mobility/how-to-do-tdd-in-android-90f013d91d7f)** - Basic samples from Mr.Nilesh medium blog for reference

**[android-testing](https://github.com/googlesamples/android-testing)** - Basic Testing guidance from GOOGLE.INC

### Espresso Samples

   **[BasicSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/BasicSample)** - Basic Espresso sample

**[CustomMatcherSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/CustomMatcherSample)** - Shows how to extend Espresso to match the *hint* property of an EditText

**[DataAdapterSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/DataAdapterSample)** - Showcases the `onData()` entry point for Espresso, for lists and AdapterViews

**[IdlingResourceSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/IdlingResourceSample)** - Synchronization with background jobs

**[IntentsBasicSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/IntentsBasicSample)** - Basic usage of `intended()` and `intending()`

**[IntentsAdvancedSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/IntentsAdvancedSample)** - Simulates a user fetching a bitmap using the camera

**[MultiWindowSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/MultiWindowSample)** - Shows how to point Espresso to different windows

**[RecyclerViewSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/RecyclerViewSample)** - RecyclerView actions for Espresso

**[WebBasicSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/WebBasicSample)** - Use Espresso-web to interact with WebViews

**[BasicSampleBundled](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/BasicSampleBundled)** - Basic sample for Eclipse and other IDEs

**[MultiProcessSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/MultiProcessSample)** - Showcases how to use multiprocess Espresso.
### UiAutomator Sample

**[BasicSample](https://github.com/googlesamples/android-testing/tree/master/ui/uiautomator/BasicSample)** - Basic UI Automator sample

### AndroidJUnitRunner Sample

**[AndroidJunitRunnerSample](https://github.com/googlesamples/android-testing/tree/master/runner/AndroidJunitRunnerSample)** - Showcases test annotations, parameterized tests and testsuite creation

### JUnit4 Rules Sample

**All previous samples use ActivityTestRule or IntentsTestRule but there's one specific to ServiceTestRule:

**[BasicSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/BasicSample)** - Simple usage of `ActivityTestRule`

**[IntentsBasicSample](https://github.com/googlesamples/android-testing/blob/master/ui/espresso/IntentsBasicSample)** - Simple usage of `IntentsTestRule`

**[ServiceTestRuleSample](https://github.com/googlesamples/android-testing/tree/master/integration/ServiceTestRuleSample)** - Simple usage of `ServiceTestRule`

Getting Started
---------------

These samples use the Gradle build system. To build a project, enter the project directory and use the `./gradlew assemble` command or use "Import Project" in Android Studio.

- Use `./gradlew connectedAndroidTest` to run the tests on a connected emulator or device.
- Use `./gradlew test` to run the unit test on your local host.

There is a top-level `build.gradle` file if you want to build and test all samples from the root directory. This is mostly helpful to build on a CI (Continuous Integration) server.

Android Testing Support Library
---------------
Many of these samples use the ATSL. Visit the [Android Testing Support Library site](https://google.github.io/android-testing-support-library/) for more information.

Experimental Bazel Support
--------------------------

Some of these samples can be built with [Bazel](https://bazel.build) on Linux. These samples contain a `BUILD.bazel` file, which is similar to a `build.gradle` file. The external dependencies are defined in the top level `WORKSPACE` file.

This is __experimental__ feature. To run the tests, please install the latest version of Bazel (0.12.0 or later) by following the [instructions on the Bazel website](https://docs.bazel.build/versions/master/install-ubuntu.html).