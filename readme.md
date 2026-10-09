
# Experiment 8: Implement Menus and WebView in an Android Application

## 1. Experiment Details

- **Experiment Number:** 8
- **Experiment Title:** Implement Menus and WebView in an Android Application
- **Application Name:** Web Explorer
- **Platform:** Android
- **IDE:** Android Studio
- **Programming Language:** Kotlin
- **UI Design:** XML
- **Package Name:** `com.example.exp8`

---

## 2. Aim

To develop an Android application that implements an options menu and WebView to display web pages within the application, handle menu selections, and provide basic web navigation functionality.

## 3. Objectives

- To understand the implementation of menus in Android.
- To create an options menu using an XML menu resource.
- To handle menu selections using Kotlin.
- To display websites using the WebView component.
- To implement URL entry and web navigation controls.
- To understand the use of WebViewClient.
- To configure Internet permission in AndroidManifest.xml.
- To test the application's menu and WebView functionality.

## 4. Description of the Experiment

This experiment demonstrates an Android application called **Web Explorer** that combines an options menu with an embedded web browser.

The application provides a URL input field, a Go button, Back and Forward navigation controls, and a Reload button. A WebView displays website content within the application.

The options menu provides Home, Google, About, Reload, and Exit actions. Selecting About displays application information and the student's name and USN. Selecting Exit opens a confirmation dialog before closing the activity.

The application demonstrates menu handling, web navigation, XML layouts, and interaction between Android UI components and Kotlin code.

## 5. Scenario Used

### Web Explorer Application

The scenario is a simple browser application that allows users to open websites without leaving the Android application.

The user can:

1. Launch Web Explorer.
2. Enter a website URL.
3. Select Go to load the webpage.
4. Use Back and Forward to navigate browsing history.
5. Use Reload to refresh the current webpage.
6. Open the options menu to access Home, Google, About, Reload, and Exit.
7. View student information through the About dialog.

## 6. Technologies Used

| Technology | Purpose |
|---|---|
| Android Studio | Application development |
| Kotlin | Application logic and event handling |
| XML | User interface and menu definition |
| WebView | Displays web pages within the application |
| WebViewClient | Handles navigation within WebView |
| Options Menu | Provides application actions |
| AlertDialog | Displays About and Exit confirmation dialogs |
| AndroidManifest.xml | Declares application components and Internet permission |
| Android Emulator | Runs and tests the application |
| Git and GitHub | Version control and submission |

## 7. Concepts Used

### 7.1 Options Menu

An options menu provides a collection of actions available to users. In this experiment, the menu is defined in `res/menu/main_menu.xml` and displayed through `onCreateOptionsMenu()`.

### 7.2 Menu Item Selection

The `onOptionsItemSelected()` method handles user selections and performs the corresponding actions.

### 7.3 WebView

WebView is an Android UI component that renders web content inside an application. It is used to display websites without opening an external browser for normal navigation.

### 7.4 WebViewClient

WebViewClient controls how WebView handles navigation. The application uses it to keep normal webpage navigation within the WebView.

### 7.5 Internet Permission

The following permission allows the application to access the internet:

`android.permission.INTERNET`

It is declared in AndroidManifest.xml.

### 7.6 AlertDialog

AlertDialog is used to display application information and request confirmation before the application exits.

### 7.7 Web Navigation

WebView provides browsing history and page-loading methods, including `loadUrl()`, `reload()`, `goBack()`, `goForward()`, `canGoBack()`, and `canGoForward()`.

## 8. Project Folder Structure

```text
Exp8/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/exp8/
│           │       └── MainActivity.kt
│           ├── res/
│           │   ├── layout/
│           │   │   └── activity_main.xml
│           │   ├── menu/
│           │   │   └── main_menu.xml
│           │   ├── drawable/
│           │   └── values/
│           └── AndroidManifest.xml
├── docs/
│   └── screenshots/
│       ├── Output.png
│       ├── TC01_Menu.png
│       ├── TC02_WebView.png
│       └── TC03_StudentDetails.png
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

### Description of Important Files

| File | Description |
|---|---|
| MainActivity.kt | Implements WebView configuration, menu handling, URL entry, navigation, and dialogs. |
| activity_main.xml | Defines the application interface and WebView. |
| main_menu.xml | Defines the options menu items. |
| AndroidManifest.xml | Declares the main activity and Internet permission. |
| app/build.gradle.kts | Contains application configuration and dependencies. |
| docs/screenshots/ | Contains output and test-case screenshots. |

## 9. Implementation Overview

### 9.1 User Interface

The XML layout contains:
- Application header
- URL input field
- Go button
- Back button
- Forward button
- Reload button
- WebView

### 9.2 Menu Implementation

The options menu is defined in `main_menu.xml`.

| Menu Item | Function |
|---|---|
| Home | Loads the configured home page. |
| Google | Loads Google. |
| About | Displays application and student information. |
| Reload | Refreshes the current webpage. |
| Exit | Requests confirmation before closing the activity. |

### 9.3 WebView Implementation

The WebView loads website URLs entered by the user. A WebViewClient handles normal webpage navigation, and the navigation buttons use the WebView browsing history.

### 9.4 Internet Permission

The application declares the Internet permission in the manifest so it can access online websites.

## 10. Application Output

The application displays the Web Explorer interface, URL input field, navigation controls, options menu, and webpage content.

![Application Output](docs/screenshots/Output.png)

## 11. Test Cases

### Test Case 1: Verify Options Menu

**Test Case ID:** TC-01

**Objective:** To verify that the options menu displays all expected menu items.

**Procedure:**
1. Launch the application.
2. Open the options menu.
3. Verify Home, Google, About, Reload, and Exit.
4. Capture a screenshot of the expanded menu.

**Expected Result:** All five menu items are displayed.

**Actual Result:** [Enter the observed result.]

**Status:** [Pass/Fail]

**Screenshot:**

![Test Case 1 - Options Menu](![alt text](<Screenshot 2026-10-09 122647.png>))

### Test Case 2: Verify WebView Navigation

**Test Case ID:** TC-02

**Objective:** To verify that the application loads a webpage within WebView.

**Procedure:**
1. Launch the application.
2. Enter `https://example.com` in the URL field.
3. Tap Go.
4. Verify that the webpage appears within the application.
5. Test Reload and available Back/Forward navigation.
6. Capture a screenshot.

**Expected Result:** The webpage loads successfully within WebView, and navigation controls operate correctly.

**Actual Result:** [Enter the observed result.]

**Status:** [Pass/Fail]

**Screenshot:**

![Test Case 2 - WebView Navigation](![alt text](<Screenshot 2026-10-09 122711.png>))



## 13. How to Run the Application

1. Clone or download the project.
2. Open the project in Android Studio.
3. Allow Gradle synchronization to complete.
4. Connect an Android device or start an emulator.
5. Run the application.
6. Enter a website URL and tap Go.
7. Test the navigation controls and options menu.

An active internet connection is required to load online websites.

## 14. Learning Outcomes

After completing this experiment, the following concepts are demonstrated:

1. Creating and implementing an options menu.
2. Handling menu item selection in Kotlin.
3. Embedding web content using WebView.
4. Using WebViewClient for in-app navigation.
5. Implementing basic browser navigation controls.
6. Declaring Internet permission in AndroidManifest.xml.
7. Displaying information and confirmation dialogs.
8. Testing Android application functionality.

## 15. Conclusion

The experiment demonstrates the implementation of menus and WebView in an Android application. The options menu provides access to application actions, while WebView allows users to load and browse web pages inside the app.

The experiment provides practical experience with XML layouts, Kotlin event handling, WebView navigation, Internet permission, AlertDialog, and Android application testing.

## 16. GitHub Submission

**Experiment:** 8 - Implement Menus and WebView in an Android Application

**Student Name:** [Sudeep J S]

**USN:** [25MCAR0134]