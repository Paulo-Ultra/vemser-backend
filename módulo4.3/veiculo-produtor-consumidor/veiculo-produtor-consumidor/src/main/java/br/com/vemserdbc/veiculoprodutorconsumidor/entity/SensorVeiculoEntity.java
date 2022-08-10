package br.com.vemserdbc.veiculoprodutorconsumidor.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Document(collection = "sensor-veiculo")
@RequiredArgsConstructor
@Getter
@Setter
public class SensorVeiculoEntity {

    @Id
    @Field
    private String idSensor;
    @Field(name = "data_leitura")
    private LocalDateTime dataLeitura;
    @Field(name = "velocidade")
    private Double velocidade;
    @Field(name = "rotacao")
    private Integer rotacao;
    @Field(name = "sensor_frenagem")
    private Boolean sensorFrenagem;
}
