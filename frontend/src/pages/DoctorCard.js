import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

const DoctorCard = ({ doctor, turnos }) => {
    return (
        <div className="card m-3 shadow" style={{ width: '18rem' }}>
            <img
                src={
                    doctor.foto
                        ? require(`../assets/img/${doctor.foto}`)
                        : require(`../assets/img/doctor-default.png`)
                }
                alt={`Foto de ${doctor.nombres} ${doctor.apellidos}`}
                className="card-img-top"
            />



            <div className="card-body">
                <h5 className="card-title">{doctor.nombres} {doctor.apellidos}</h5>
                <p className="card-text">
                    <strong>Especialidad:</strong> {doctor.especialidad}<br />
                    <strong>Teléfono:</strong> {doctor.telefono}<br />
                    <strong>Sede:</strong> {doctor.sede && doctor.sede.nombre}
                </p>
                <p>
                    <strong>Turnos:</strong>{" "}
                    {turnos && turnos.length > 0 ? turnos.join(', ') : "No asignados"}
                </p>
                <a href="#" className="btn btn-primary">
                    <i className="bi bi-info-circle-fill"></i> Ver más
                </a>
            </div>
        </div>
    );
};

export default DoctorCard;
