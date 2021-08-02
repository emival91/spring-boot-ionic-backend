package com.cursomodelagem;

import java.text.SimpleDateFormat;
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
import com.cursomodelagem.domain.ItemPedido;
import com.cursomodelagem.domain.Pagamento;
import com.cursomodelagem.domain.PagamentoComBoleto;
import com.cursomodelagem.domain.PagamentoComCartao;
import com.cursomodelagem.domain.Pedido;
import com.cursomodelagem.domain.Produto;
import com.cursomodelagem.domain.enums.EstadoPagamento;
import com.cursomodelagem.domain.enums.TipoCliente;
import com.cursomodelagem.repositories.CategoriaRepository;
import com.cursomodelagem.repositories.CidadeRepository;
import com.cursomodelagem.repositories.ClienteRepository;
import com.cursomodelagem.repositories.EnderecoRepository;
import com.cursomodelagem.repositories.EstadoRepository;
import com.cursomodelagem.repositories.ItemPedidoRepository;
import com.cursomodelagem.repositories.PagamentoRepository;
import com.cursomodelagem.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired PagamentoRepository pagamentoRepository;
	
	@Autowired ItemPedidoRepository itemPedidoRepository;
	

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 09:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.save(Arrays.asList(ip1, ip2, ip3));
	}

}
