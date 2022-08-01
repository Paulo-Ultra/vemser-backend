package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login,senha);
    }
    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO cadastro(LoginDTO loginDTO){
        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioRepository.save(usuarioEntity);
        return loginDTO;
    }

    public Integer getIdLoggedUser() {
        Integer findUserId = (Integer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserId;
    }

    public UsuarioDTO getLoggedUser() throws RegraDeNegocioException {
        return findById(getIdLoggedUser());
    }
    public UsuarioDTO findById(Integer idUsuario) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(idUsuario)
                .orElseThrow(()->
                        new RegraDeNegocioException("Usuário não encontrado"));
        UsuarioDTO usuarioDTO =  objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }

}
