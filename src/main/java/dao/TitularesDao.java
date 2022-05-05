package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Titular;
import model.TitularPK;

public interface TitularesDao extends JpaRepository<Titular, TitularPK> {

}
