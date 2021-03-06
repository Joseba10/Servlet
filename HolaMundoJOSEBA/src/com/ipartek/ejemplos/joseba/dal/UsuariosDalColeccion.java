package com.ipartek.ejemplos.joseba.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.ejemplos.joseba.tipos.Usuario;

public class UsuariosDalColeccion implements UsuariosDAL {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	@Override
	public void alta(Usuario usuario) {
		if (usuarios.containsKey(usuario.getNombre()))
			throw new UsuarioYaExiste("Ya existe el usuario " + usuario.getNombre());

		usuarios.put(usuario.getNombre(), usuario);
	}

	@Override
	public boolean validar(Usuario usuario) {
		return usuarios.containsValue(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		if (!usuarios.containsKey(usuario.getNombre()))
			throw new DALException("Intento de modificar usuario no existente " + usuario);

		usuarios.put(usuario.getNombre(), usuario);
	}

	@Override
	public void borrar(Usuario usuario) {
		usuarios.remove(usuario.getNombre());
	}

	@Override
	public Usuario buscarPorId(String id) {
		return usuarios.get(id);
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {
		// Usuario[] arr = new Usuario[usuarios.size()];

		// int i = 0;
		//
		// for (Usuario usuario : usuarios.values())
		// arr[i++] = usuario;
		//
		// return usuarios.entrySet().toArray(new Usuario[0]);
		return usuarios.values().toArray(new Usuario[usuarios.size()]);
	}

}
