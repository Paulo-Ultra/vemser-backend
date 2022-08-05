package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import freemarker.template.TemplateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

    @InjectMocks // Injetar a classe na qual é o foco do caso de uso
    private PessoaService pessoaService;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private EmailService emailService;

    @Before
    public void init(){
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ReflectionTestUtils.setField(pessoaService, "objectMapper", objectMapper);
    }

    @Test
    public void deveTestarCreateComSucesso() throws TemplateException, RegraDeNegocioException, IOException {
        //setup -> preparamos o que vamos usar no teste
        PessoaCreateDTO pessoaCreateDTO = new PessoaCreateDTO();
        pessoaCreateDTO.setDataNascimento(LocalDate.of(1986, 8, 12));
        pessoaCreateDTO.setCpf("12345678910");
        pessoaCreateDTO.setEmail("prfultra@teste.com.br");
        pessoaCreateDTO.setNome("Paulo");

        PessoaEntity pessoaEntity = getPessoaEntity();

        pessoaEntity.setIdPessoa(10);
        String email = null;
        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaEntity);
//        when(emailService.sendEmailPessoa()).thenReturn(null);

        //act -> ação do teste
        PessoaDTO pessoaDTO = pessoaService.create(pessoaCreateDTO);

        //assert -> garantir o retorno do teste
        Assert.assertNotNull(pessoaDTO);
        Assert.assertEquals(LocalDate.of(1986, 8, 12), pessoaDTO.getDataNascimento());
        Assert.assertEquals("12345678910", pessoaDTO.getCpf());
        Assert.assertEquals("prfultra@teste.com.br", pessoaDTO.getEmail());
        Assert.assertEquals("Paulo", pessoaDTO.getNome());
        Assert.assertNotNull(pessoaDTO.getIdPessoa());

    }

    @Test
    public void deveTestarListComSucesso(){
        // setup
        List<PessoaEntity> pessoaEntities = List.of(getPessoaEntity());

        when(pessoaRepository.findAll()).thenReturn(pessoaEntities);

        // act
        List<PessoaDTO> pessoaDTOS = pessoaService.list();

        // assert
        Assert.assertNotNull(pessoaDTOS);
        Assert.assertTrue(!pessoaDTOS.isEmpty());
    }

    @Test
    public void deveTestarListPaginadoComSucesso(){
        // setup
        List<PessoaEntity> pessoaEntities = List.of(getPessoaEntity());
        Page<PessoaEntity> pagePessoas = new PageImpl<>(pessoaEntities);

        when(pessoaRepository.findAll(any(Pageable.class)))
                .thenReturn(pagePessoas);

        // act
        Page<PessoaEntity> paginaDePessoas = pessoaService
                .listPaginado(1000, 3);

        // assert
        Assert.assertNotNull(paginaDePessoas);
        Assert.assertEquals(1, paginaDePessoas.getTotalElements());
        Assert.assertEquals(1, paginaDePessoas.getContent().size());
    }

    @Test
    public void deveTestarUpdateComSucesso() throws TemplateException, RegraDeNegocioException, IOException {
        // setup
        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTO();
        PessoaEntity pessoaEntity = getPessoaEntity();

        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(pessoaEntity));
        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaEntity);

        // act
        PessoaDTO pessoaDTO = pessoaService.update(10, pessoaCreateDTO);

        // assert
        Assert.assertNotNull(pessoaDTO);
        Assert.assertEquals(10, pessoaDTO.getIdPessoa().intValue());
        Assert.assertEquals(LocalDate.of(1986, 8, 12), pessoaDTO.getDataNascimento());
        Assert.assertEquals("12345678910", pessoaDTO.getCpf());
        Assert.assertEquals("prfultra@teste.com.br", pessoaDTO.getEmail());
        Assert.assertEquals("Paulo", pessoaDTO.getNome());
    }

    @Test(expected = RegraDeNegocioException.class)
    public void deveTestarUpdateSemId() throws TemplateException, RegraDeNegocioException, IOException {

        PessoaCreateDTO pessoaCreateDTO = getPessoaCreateDTO();

        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.empty());

        // act
        pessoaService.update(10, pessoaCreateDTO);
    }

    @Test
    public void deveTestarDeleComSucesso() throws TemplateException, RegraDeNegocioException, IOException {
        // setup
        Integer idParaDeletar = 10;
        PessoaEntity pessoaEntity = getPessoaEntity();

        when(pessoaRepository.findById(anyInt())).thenReturn(Optional.of(pessoaEntity));
        doNothing().when(pessoaRepository).delete(any(PessoaEntity.class));

        // act
        pessoaService.delete(idParaDeletar);

        // assert
        verify(pessoaRepository, times(1)).delete(any(PessoaEntity.class));
    }

    private static PessoaEntity getPessoaEntity() {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setDataNascimento(LocalDate.of(1986,8,12));
        pessoaEntity.setCpf("12345678910");
        pessoaEntity.setEmail("prfultra@teste.com.br");
        pessoaEntity.setNome("Paulo");
        pessoaEntity.setIdPessoa(10);
        return pessoaEntity;
    }

    private static PessoaCreateDTO getPessoaCreateDTO() {
        PessoaCreateDTO pessoaCreateDTO = new PessoaCreateDTO();
        pessoaCreateDTO.setDataNascimento(LocalDate.of(1986, 8, 12));
        pessoaCreateDTO.setCpf("12345678910");
        pessoaCreateDTO.setEmail("prfultra@teste.com.br");
        pessoaCreateDTO.setNome("Paulo");
        return pessoaCreateDTO;
    }
}
