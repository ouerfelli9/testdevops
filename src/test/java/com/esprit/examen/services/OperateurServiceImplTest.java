package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.StockRepository;

public class OperateurServiceImplTest {
	
Logger log= (Logger) LoggerFactory.getLogger(OperateurServiceImplTest.class);
	
	@InjectMocks
	 OperateurServiceImpl operateurService;
	@Mock
	 OperateurRepository operateurRepository;
	
	
	
	@Test
	public void retrieveAllOperateursTest() {
		
		 List<Operateur> Ls=new ArrayList<Operateur>();
			
			 Ls.add(new Operateur ("op1", "1", "2"));
			 Ls.add(new Operateur ("op2", "1", "2"));
			 Ls.add(new Operateur ("op3", "1", "2"));
			  
		when(operateurService.retrieveAllOperateurs()).thenReturn(Ls);
		List<Operateur> opList=operateurService.retrieveAllOperateurs();
		assertEquals(3, opList.size());
		log.info("retrieveAll==>" +opList.toString());
	}
	
	
	@Test
	public void AddStockTest() {
		Operateur o =new Operateur("op4","10","80");
		o.setIdOperateur(null);
		operateurService.addOperateur(o);
		verify(operateurRepository,times(1)).save(o);
		System.out.println(o);
		log.info("add==>" + o.toString());
		
		// when(stockRepository.save(s)).thenReturn(s);
		//assertEquals(s, stockService.addStock(s));
	}
	
	@Test
	public void DeleteOperateurTest() {
		Operateur o =new Operateur("op4","10","80");
		operateurRepository.save(o);
		operateurService.deleteOperateur(o.getIdOperateur());
		verify(operateurRepository,times(1)).deleteById(o.getIdOperateur());
		log.info("delete==>"+ o.toString());
		
		//stockService.deleteStock(null);
		//verify(stockRepository,times(1)).delete(null);
	}
	

}
