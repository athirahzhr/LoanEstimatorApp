<h1 align="center">🚗 Loan Estimator App</h1> <p align="center"> A clean and simple Android application for calculating loan repayment details. </p>
📑 Table of Contents

Overview

Features

Technologies Used

Loan Calculation Method

Installation

Project Structure

License

🧾 Overview

Loan Estimator App allows users to estimate loan-related values such as:

Loan amount

Total interest

Total payment

Monthly installment

All calculations follow simple and commonly used financial formulas.

⭐ Features

🔹 Input Fields

Vehicle Price

Down Payment

Interest Rate (%)

Loan Period (Years)

🔹 Validation Rules

Fields cannot be empty

Values cannot be negative

Down payment must not exceed vehicle price

Prompt/error message for invalid calculations

🔹 Additional App Functions

Reset button to clear all fields

About page with application details

Material Design UI

Custom app icon

🛠 Technologies Used
Component	Description
Language	Java (Android)
UI Layout	XML
Design System	Material Components
Minimum SDK	API 21
IDE	Android Studio Flamingo or newer

📘 Loan Calculation Method
1. Loan Amount
loan = price - downPayment

2. Total Interest
totalInterest = loan × (rate / 100) × years

3. Total Payment
totalPayment = loan + totalInterest

4. Monthly Payment
monthlyPayment = totalPayment / (years × 12)

📥 Installation

1️⃣ Clone the repository
git clone https://github.com/athirahzhr/LoanEstimatorApp.git

2️⃣ Open in Android Studio

File → Open → Select project folder.

3️⃣ Run the App

Use an Android device or emulator.

📁 Project Structure
LoanEstimatorApp/
│── app/
│   ├── java/com.example.loanestimatorapp/
│   │   ├── MainActivity.java
│   │   ├── AboutActivity.java
│   ├── res/
│   │   ├── layout/activity_main.xml
│   │   ├── layout/activity_about.xml
│   │   ├── drawable/
│   │   └── menu/main_menu.xml
│── README.md
│── build.gradle
