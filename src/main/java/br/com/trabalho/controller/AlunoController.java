package br.com.trabalho.controller;

import br.com.trabalho.model.Aluno;
import br.com.trabalho.repository.AlunoRepository;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/gerenciarAlunos")
    public String listarAlunos(Model model) {
        model.addAttribute("listaAlunos", alunoRepository.findAll());
        return "gerenciar_alunos";
    }

    @GetMapping("/novoAluno")
    public String novoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "editar_aluno";
    }

    @GetMapping("/editarAluno/{id}")
    public String editarAluno(@PathVariable("id") long idAluno, Model model) {
        Optional<Aluno> aluno = alunoRepository.findById(idAluno);
        model.addAttribute("aluno", aluno.get());
        return "editar_aluno";
    }

    @PostMapping("/salvarAluno")
    public String salvarAluno(Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_Aluno";
        }
        alunoRepository.save(aluno);
        return "redirect:/gerenciarAlunos";
    }

    @GetMapping("/excluirAluno/{id}")
    public String excluirAluno(@PathVariable("id") long idAluno) {  
        alunoRepository.deleteById(idAluno);
        return "redirect:/gerenciarAlunos";
    }
}