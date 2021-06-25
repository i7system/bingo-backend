package br.com.bingo.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bingo.config.TratamentoErros;
import br.com.bingo.funcoes.SelectDinamico;
import br.com.bingo.funcoes.TrataErros;
import br.com.bingo.models.PortListas;
import br.com.bingo.models.PortListasBotoes;
import br.com.bingo.models.PortListasColunas;
import br.com.bingo.models.TabColunas;
import br.com.bingo.models.TabTabelas;
import br.com.bingo.repository.port_listasRepository;
import br.com.bingo.repository.port_listas_botoesRepository;
import br.com.bingo.repository.port_listas_breadcrumbsRepository;
import br.com.bingo.repository.port_listas_colunasRepository;
import br.com.bingo.repository.tab_colunasRepository;
import br.com.bingo.repository.tab_tabelasRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/bingo")
public class CrudController {
	
	@Autowired
	private port_listasRepository servico01;
	
	@Autowired
	private port_listas_breadcrumbsRepository servico02;
	
	@Autowired
	private port_listas_colunasRepository servico03;
	
	@Autowired
	private sec_errosController servico04;
	
	@Autowired
	private tab_tabelasRepository servico05;
	
	@Autowired
	private tab_colunasRepository servico06;

	@Autowired
	private port_listas_botoesRepository servico07;
	
	
	@PersistenceContext
	protected EntityManager manager;

	public List<Object> findCustomNativeQuery(String query) {
	    return manager.createNativeQuery(query).getResultList();
	}

	@PostMapping("/Listas")
	public HashMap<String, Object> Lista(@RequestBody HashMap<String, Object> objeto,@RequestHeader HttpHeaders headers){
	
		HashMap<String, Object> lista = new HashMap<String, Object>();
		
		System.out.println("objeto recebido: " + objeto);
		
		try {
		
			int IDLISTA = (int) objeto.get("idlista");
			int PAGINA= (int) objeto.get("pagina");
			
			//ORDENANDO PORT_LISTA POR IDLISTA
			Pageable paginacao_lista = PageRequest.of(0, 1, Sort.by("IDLISTA").ascending());
			List<PortListas> port_listas = servico01.findByIDLISTA(IDLISTA, paginacao_lista);
			
			//ORDENANDO PORT_LISTAS_BREADCRUMBS POR IDLISTABREADCRUMB
			Pageable paginacao_breadcrumb = PageRequest.of(0, 100, Sort.by("IDLISTABREADCRUMB").ascending());
			List port_listas_breadcrumbs = servico02.findByIDLISTA(IDLISTA,paginacao_breadcrumb);
			
			//ORDENANDO PORT_LISTAS_COLUNAS POR IDLISTACOLUNA
			Pageable paginacao_coluna = PageRequest.of(0, 100, Sort.by("ORDEM").ascending());
			List<PortListasColunas> port_listas_colunas = servico03.findByIDLISTA(IDLISTA,paginacao_coluna);
			
			//ORDENANDO PORT_LISTAS_BOTAO POR IDBOTAO
			Pageable paginacao_botao = PageRequest.of(0, 100, Sort.by("ORDEM_BOTAO").ascending());
			List<PortListasBotoes> port_listas_botoes = servico07.findByIDLISTA(IDLISTA, paginacao_botao);
			
			Pageable paginacao_lista1 = PageRequest.of(0, 1, Sort.by("IDLISTA").ascending());			
			TabTabelas tab_tabelas = servico05.findByIDTABELA(port_listas.get(0).getIDTABELA());
			
			List<TabColunas> tab_colunas = servico06.ListaTabColunas(IDLISTA);
			
			String nometabela = tab_tabelas.getNOME_TABELA();				
			String campos ="";
			
			
			
			// ordenação
			String ordem = " ORDER BY ";
			int qtde_ordem=0;
			
			for (int i = 0; i <port_listas_colunas.size(); i++) {
				
				if(port_listas_colunas.get(i).getORDENADO() > 0) {
						for (int j = 0; j < tab_colunas.size(); j++) {
							if(tab_colunas.get(j).getIDCOLUNA() == port_listas_colunas.get(i).getIDCOLUNA()) {
								
								if(qtde_ordem>0) {
									ordem=ordem+" , ";
								}
								ordem=ordem+tab_colunas.get(j).getNOME_COLUNA();

								if(port_listas_colunas.get(i).getORDENADO() ==1 ) {	
									   ordem=ordem + " ASC"; 
								}

								if(port_listas_colunas.get(i).getORDENADO() ==2 ) {	
								   ordem=ordem + " DESC"; 
								}
								
								qtde_ordem=qtde_ordem+1;
							}
						}			
				}
			}
			
			if(ordem.contentEquals(" ORDER BY ")){ordem="";};
			
				for (int i = 0; i < tab_colunas.size(); i++) {
					
					campos=campos+tab_colunas.get(i).getNOME_COLUNA();
					if(i<(tab_colunas.size()-1)) {
						campos=campos+",";
					}
				}

			String mysel = "SELECT "+campos+" FROM "+ nometabela + "" + ordem ;
			
			List itens = this.findCustomNativeQuery(mysel);

			lista.put("port_listas_botoes", port_listas_botoes);
			
			lista.put("port_listas_colunas", port_listas_colunas);

			lista.put("port_listas_breadcrumbs", port_listas_breadcrumbs);
			
			lista.put("port_listas", port_listas);
			
			lista.put("itens", itens);

		}catch(Exception erro) {
		
		servico04.SalvarErro(erro, headers, "br.com.bingo.controllers","CrudController", "Lista");
			
			lista.put("erro", erro);
			
			
		}
			
		return lista;
	
		 
		
	}
	
	

}
