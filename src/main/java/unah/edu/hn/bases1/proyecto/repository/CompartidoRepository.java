package unah.edu.hn.bases1.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.hn.bases1.proyecto.Entities.Compartido;

public interface CompartidoRepository extends JpaRepository<Compartido, Integer> {
    List<Compartido> findByPropietario_IdUsuarioAndUsuarioreceptor_IdUsuario(int propietario, int Receptor);
}
