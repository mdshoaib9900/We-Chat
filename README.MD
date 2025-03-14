# We-Chat 🚀

A **real-time chat application** built using **Spring Boot** for the backend and a modern frontend for seamless user interaction. This project enables users to send messages instantly, ensuring a smooth and interactive chat experience.

## 🛠️ Tech Stack

### **Backend:**
- **Spring Boot** - Framework for backend development
- **WebSockets** - Real-time messaging
- **Spring Data JPA** - ORM for database interaction
- **MySQL** - Relational Database
- **Lombok** - Simplified Java annotations
- **Maven** - Dependency management

### **Frontend:**
- Frontend UI
- **Axios** - HTTP client for API requests
- **Socket.IO / WebSockets** - Real-time communication

## ✨ Features
✅ **Real-time Messaging** with WebSockets  
✅ **Group Chat Support**  
✅ **Secure Communication** with encrypted tokens  
✅ **Database Integration** for chat persistence  
✅ **Minimalistic UI** for better user experience  

## 📂 Project Setup

### **Backend (Spring Boot)**
1. Clone the repository:
   ```bash
   git clone https://github.com/mdshoaib9900/We-Chat.git
   cd We-Chat
   ```
2. Open the backend project in **IntelliJ IDEA** / **VS Code**.
3. Configure `application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/we_chat_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```
4. Build and run the Spring Boot application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### **Frontend Setup**
1. Navigate to the frontend folder:
   ```bash
   cd frontend  # If using React.js
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the frontend:
   ```bash
   npm start
   ```

## 🚀 Running the Project
- **Start the backend server** (`Spring Boot`)
- **Start the frontend application**
- Open the browser and test the chat functionality 🎉

👤 **Mohammed Shoaib**  
📧 [mdshoaib6360@gmail.com](mailto:mdshoaib6360@gmail.com)
