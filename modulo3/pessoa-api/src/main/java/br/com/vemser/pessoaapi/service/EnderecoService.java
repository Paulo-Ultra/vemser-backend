package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception {
        pessoaService.findByIdPessoa(idPessoa);
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(idPessoa, endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco update(Integer id, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoAtualizado = finByIdEndereco(id);
        enderecoAtualizado.setTipo(enderecoAtualizar.getTipo());
        enderecoAtualizado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoAtualizado.setNumero(enderecoAtualizar.getNumero());
        enderecoAtualizado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoAtualizado.setCep(enderecoAtualizar.getCep());
        enderecoAtualizado.setCidade(enderecoAtualizar.getCidade());
        enderecoAtualizado.setEstado(enderecoAtualizar.getEstado());
        enderecoAtualizado.setPais(enderecoAtualizar.getPais());
        return enderecoAtualizado;
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco finByIdEndereco(Integer idEndereco) throws Exception {
        Endereco enderecoById = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        return enderecoById;
    }
}

