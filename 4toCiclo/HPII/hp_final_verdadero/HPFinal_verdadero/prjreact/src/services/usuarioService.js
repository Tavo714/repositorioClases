import axios from 'axios';

const API_URL = 'http://localhost:5196/api';

export const usuariosPenalizados = () => {
  return axios.get(`${API_URL}/ListarUsuariosConPenalidades/GetListarUsuariosConPenalidades`);
};

export const usuariosInactivos = () => {
  return axios.get(`${API_URL}/sp_ObtenerUsuariosInactivos/GetObtenerUsuariosInactivos`);
};

export const cambiarPenalidadUsuario = (usuarioId) => {
  return axios.post(`${API_URL}/ListarUsuariosConPenalidades/CambiarPenalidad/${usuarioId}`);
};
