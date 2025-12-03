# Parking Spot Manager 🚗📱

> An Android application designed to streamline parking management for multi-branch parking chains.

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/evangelosv/parking-app-android)
[![Platform](https://img.shields.io/badge/platform-Android-green)](https://developer.android.com/)
[![Language](https://img.shields.io/badge/language-Java%20%7C%20Kotlin-orange)](https://www.java.com)

## 📖 About the Project

**Parking Spot Manager** is a comprehensive software solution developed as part of a **Software Engineering** course. The application facilitates the management of parking spaces across a chain of parking lots, catering to three distinct user groups: Customers, Employees, and Top Management.

The system replaces traditional ticketing with a digital-first approach, utilizing **QR Codes** for entry/exit and an in-app wallet for payments.

## ✨ Key Features

### 👤 For Customers
* **User Registration**: Create a personal account with vehicle details.
* **Smart Search**: Find available parking spots based on specific criteria (location, time).
* **Reservations**: Book a specific spot for a defined time duration.
* **Contactless Access**: Enter and exit parking facilities using a generated **QR Code**.
* **Digital Wallet**: Manage account balance and pay for parking fees directly within the app.
* **Live Updates**: View real-time charges upon exit.

### 👔 For Employees
* **Verification**: Review and approve or reject new customer registration requests.
* **Management**: Oversee daily parking operations.

### 📈 For Management (Admin)
* **Analytics Dashboard**: View detailed statistics and reports regarding business performance (occupancy rates, revenue, etc.).

## 🛠️ Tech Stack & Architecture

This project follows strict Software Engineering principles and utilizes a layered architecture for maintainability and scalability.

* **Language**: Java & Kotlin
* **Framework**: Android SDK
* **Build Tool**: Gradle
* **Design Pattern**: MVP / MVVM (Model-View-Presenter / Model-View-ViewModel)
* **Data Persistence**: DAO (Data Access Object) pattern with In-Memory implementation for testing.
* **Modeling**: UML compliant (Use Case, Sequence, and Class diagrams included in documentation).

## 📂 Project Structure

The codebase is organized into logical packages:
* `domain`: Core business logic and entities (e.g., `Customer`, `ParkingSpace`, `Ticket`).
* `dao`: Interfaces for data access.
* `memorydao`: In-memory implementations of DAOs.
* `view`: UI components (Activities, Fragments) and their corresponding Presenters/ViewModels.
* `util`: Helper classes and custom exceptions.

## 🚀 Getting Started

### Prerequisites
* [Android Studio](https://developer.android.com/studio) (Latest version recommended)
* JDK 11 or higher

### Installation
1.  **Clone the repository**
    ```bash
    git clone [https://github.com/evangelosv/parking-app-android.git](https://github.com/evangelosv/parking-app-android.git)
    ```
2.  **Open in Android Studio**
    * Launch Android Studio.
    * Select "Open an existing Android Studio project".
    * Navigate to the cloned directory and select the `team02` folder.
3.  **Build the Project**
    * Wait for Gradle to sync dependencies.
    * Click the **Run** button (green play icon) or press `Shift + F10`.

## 🧪 Running Tests

The project includes unit tests for DAOs, Domain logic, and Presenters.
To run tests:
1.  Right-click on the `src/test/java` folder.
2.  Select **"Run 'All Tests'"**.

## 👥 Team

Developed by **Viglis Evangelos, Maniatis Ioannis, Lampos Antreas**.

---
*This project was created for educational purposes to demonstrate software engineering requirements analysis, design, and implementation.*
