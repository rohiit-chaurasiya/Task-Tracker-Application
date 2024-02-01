import { useState } from 'react'
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import HeaderComponent from "./components/navbar";
import ListTodoComponent from "./components/TaskList";
import TodoComponent from "./components/Tasks";
import RegisterComponent from "./components/Signup";
import LoginComponent from "./components/Signin";
import { isUserLoggedIn } from "./services/AuthService";

import './App.css'


function App() {
  const [count, setCount] = useState(0)
  const AuthenticatedRoute=({children})=>{
    const isAuth=isUserLoggedIn();
    if(isAuth){
      return children;
    }
    return <Navigate to="/" />
  }

  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
      <Routes>
        {/* <Route path="/" element={<ListTodoComponent />} /> */}
          {/* Diplay the Links as Per User Auth in the Header */}
          <Route path="/" element={<LoginComponent />} />
          {/* Secure the Routes */}
          <Route
            path="/todos"
            element={
              <AuthenticatedRoute>
                <ListTodoComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/add-todo"
            element={
              <AuthenticatedRoute>
                <TodoComponent />
              </AuthenticatedRoute>
            }
          />
          <Route
            path="/update-todo/:id"
            element={
              <AuthenticatedRoute>
                <TodoComponent />
              </AuthenticatedRoute>
            }
          />
          <Route path="/register" element={<RegisterComponent />} />
          <Route path="/login" element={<LoginComponent />} />
        
      
      </Routes>
    
    </BrowserRouter>
      
      
      
    </>
  )
}

export default App
