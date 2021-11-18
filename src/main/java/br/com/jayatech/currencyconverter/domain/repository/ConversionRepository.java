package br.com.jayatech.currencyconverter.domain.repository;

import br.com.jayatech.currencyconverter.domain.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
}
