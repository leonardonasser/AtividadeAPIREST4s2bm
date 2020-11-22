package com.ads.programacaoII.veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping
    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/{id}")    
    public Veiculo recuperarVeiculo(@PathVariable String id) {
        return veiculoRepository.findById(id).get();
    }

    @PostMapping
    public String criar(@RequestBody Veiculo novo) {
        if (veiculoRepository.findById(novo.getId()).isPresent()) {            
            throw new RegistroDuplicadoException();
        }
        novo = veiculoRepository.save(novo);
        return novo.getId();
    }

    @DeleteMapping("/{id}")    
    public void deletarVeiculo(@PathVariable String id) {
        veiculoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void Atualizar(@PathVariable String id, @RequestBody Veiculo atualizado) {
        if (!id.equals(atualizado.getId())) {
            throw new RuntimeException("Id não encontrado");
        }
        if (!veiculoRepository.findById(atualizado.getId()).isPresent()) {            
            throw new RuntimeException("Registro não foi encontrado");

        }
        veiculoRepository.save(atualizado);
    }
	

}
