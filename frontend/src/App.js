import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import React from "react";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from './components/Header';
import Login from "./pages/login";
import Register from './pages/register';
import Footer from './components/Footer';
import Nosotros from './pages/Nosotros';
import Red from './pages/Red';
import Contacto from './pages/Contacto';
import Servicios from './pages/Servicios';
import ServicioPersona from './pages/ServicioPersona';
import ServicioEvento from './pages/ServicioEvento';
import ListaDoctores from './pages/ListaDoctores';
import Reserva from "./pages/Reserva";
import Citas from "./pages/Citas";
import ProtectedRoute from "./components/ProtectedRoute";

// ...



function App() {
  return (
    <BrowserRouter>
    <Header />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/nosotros" element={<Nosotros />} />
        <Route path="/red" element={<Red />} />
        <Route path="/contacto" element={<Contacto />} />
        <Route path="/servicios" element={<Servicios />} />
        <Route path="/servicio-persona" element={<ServicioPersona />} />
        <Route path="/servicio-evento" element={<ServicioEvento />} />
         <Route path="/medicos" element={<ListaDoctores />} />
        <Route path="/reserva" element={<ProtectedRoute><Reserva /></ProtectedRoute>} />
        <Route path="/citas" element={<ProtectedRoute><Citas /></ProtectedRoute>} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;
