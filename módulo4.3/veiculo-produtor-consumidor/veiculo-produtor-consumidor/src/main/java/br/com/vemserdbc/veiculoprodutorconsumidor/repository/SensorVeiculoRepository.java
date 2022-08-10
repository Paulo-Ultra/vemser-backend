package br.com.vemserdbc.veiculoprodutorconsumidor.repository;

import br.com.vemserdbc.veiculoprodutorconsumidor.entity.SensorVeiculoEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorVeiculoRepository extends MongoRepository<SensorVeiculoEntity, String> {

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$avg: $velocidade }}}" })
    public Double findVelocidade();

}
