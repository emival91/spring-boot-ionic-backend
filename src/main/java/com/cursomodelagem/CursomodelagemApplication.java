package com.cursomodelagem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursomodelagem.domain.Categoria;
import com.cursomodelagem.domain.Cidade;
import com.cursomodelagem.domain.Cliente;
import com.cursomodelagem.domain.Endereco;
import com.cursomodelagem.domain.Estado;
import com.cursomodelagem.domain.Produto;
import com.cursomodelagem.domain.enums.TipoCliente;
import com.cursomodelagem.repositories.CategoriaRepository;
import com.cursomodelagem.repositories.CidadeRepository;
import com.cursomodelagem.repositories.ClienteRepository;
import com.cursomodelagem.repositories.EnderecoRepository;
import com.cursomodelagem.repositories.EstadoRepository;
import com.cursomodelagem.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomodelagemApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(CursomodelagemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "24878977293", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua das Flores", "300", "Apto 303", "Centro", "76300000", cli1, c1);
		Endereco e2 = new Endereco(null, "Av. Brasil", "110", "Centro Comecial", "Bueno", "74300000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		Cliente cli2 = new Cliente(null, "João Paulo da Silva", "jpaulo@gmail.com", "27978966293", TipoCliente.PESSOAFISICA);
		
		cli2.getTelefones().addAll(Arrays.asList("5553323", "93999893"));
		
		Endereco e3 = new Endereco(null, "Av.Goias", "50", "Fundos", "Centro", "76300000", cli2, c2);
		Endereco e4 = new Endereco(null, "Rua do Café", "10", "-", "Bueno", "74300000", cli2, c3);
		
		cli1.getEnderecos().addAll(Arrays.asList(e2, e3));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2, e3, e4));
		
		
	}

}
