import React from "react";
import "../assets/css/contacto.css"; // el css corregido como arriba

function Contacto() {
  return (
    <div className="contact-page">
      <section className="contact-section">
        <div className="contact-container">
          <div className="contact-text-center">
            <h4 className="text-primary">Contacto</h4>
            <h1>
              Tu mensaje es importante para nosotros.<br />
              ¡Cuéntanos qué necesitas!
            </h1>
          </div>

          <div className="contact-content">
            <div className="contact-img">
              <div className="contact-img-inner">
                <img src="/img/con1.png" alt="Contact" />
              </div>
            </div>

            <form className="contact-form">
              <h4 className="text-primary">Contáctanos</h4>
              <p>Deja tus datos y tu consulta, y nos comunicaremos contigo</p>
              <br />

              <div className="contact-row">
                <div className="contact-form-floating" style={{ flex: 1 }}>
                  <input type="text" id="name" placeholder="Nombre" required />
                  <label htmlFor="name">Nombre</label>
                </div>
                <div className="contact-form-floating" style={{ flex: 1 }}>
                  <input type="text" id="phone" placeholder="Teléfono" />
                  <label htmlFor="phone">Teléfono</label>
                </div>
              </div>

              <div className="contact-row">
                <div className="contact-form-floating" style={{ flex: 1 }}>
                  <input type="email" id="email" placeholder="Email" required />
                  <label htmlFor="email">Email</label>
                </div>
                <div className="contact-form-floating" style={{ flex: 1 }}>
                  <input type="text" id="project" placeholder="Apellido" />
                  <label htmlFor="project">Apellido</label>
                </div>
              </div>

              <div className="contact-form-floating" style={{ marginTop: "1rem" }}>
                <textarea
                  id="message"
                  name="message"
                  placeholder="Mensaje"
                  style={{ width: "100%", height: "150px" }}
                ></textarea>
                <label htmlFor="message">Mensaje</label>
              </div>

              <div style={{ marginTop: "1rem" }}>
                <button type="submit" className="contact-btn">
                  Enviar mensaje
                </button>
              </div>
            </form>
          </div>
        </div>
      </section>

      <section className="contact-info-map">
        <div className="contact-container contact-details">
          <div className="info-item">
            <i className="icon">📍</i>
            <h4>Sede principal</h4>
            <p>Av. Petit Thouars 789</p>
          </div>
          <div className="info-item">
            <i className="icon">✉️</i>
            <h4>Email</h4>
            <p>Mediconect@gmail.com</p>
          </div>
          <div className="info-item">
            <i className="icon">📞</i>
            <h4>Telefono</h4>
            <p>(+51) 985437619</p>
          </div>
          <div className="info-item">
            <i className="icon">🌐</i>
            <h4>Website</h4>
            <p>Mediconect.com</p>
          </div>
        </div>

        <div className="contact-map-wrapper">
          <div className="map-container">
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6398741.779388219!2d-84.30995977217849!3d-9.190000397670062!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c8c38de66359%3A0x183e18e643ab99a1!2sPer%C3%BA!5e0!3m2!1ses-419!2spe!4v1713574000000!5m2!1ses-419!2spe"
              width="100%"
              height="400"
              style={{ border: 0 }}
              allowFullScreen=""
              loading="lazy"
              referrerPolicy="no-referrer-when-downgrade"
              title="Mapa Sede"
            ></iframe>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Contacto;
